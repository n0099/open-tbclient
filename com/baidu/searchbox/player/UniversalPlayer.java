package com.baidu.searchbox.player;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.player.helper.ITimerTask;
import com.baidu.searchbox.player.helper.OrientationHelper;
import com.baidu.searchbox.player.helper.ProgressHelper;
import com.baidu.searchbox.player.helper.SimpleStyleSwitchHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.ILayer;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher;
import com.baidu.searchbox.player.stat.UniversalStatDispatcherImp;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
/* loaded from: classes2.dex */
public class UniversalPlayer extends BDVideoPlayer {
    public static final String TAG = "UniversalPlayer";
    public static boolean sIsOrientationLock = false;
    public SimpleArrayMap<Class<? extends IPlayerContext>, IPlayerContext> mContextMap;
    public String mCurrentMode;
    public boolean mIsEnableOrientation;
    public OrientationHelper mOrientationHelper;
    public ITimerTask mProgressHelper;
    public IPlayerStyleSwitchHelper mStyleSwitchHelper;

    /* loaded from: classes2.dex */
    public class OrientationChangeCallBack implements OrientationHelper.IOrientationChange {
        public static final int DELAY_TIME = 1000;
        public long mChangedTime = 0;
        public boolean mIsLandscape;
        public boolean mIsPortrait;

        public OrientationChangeCallBack() {
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i) {
            if (UniversalPlayer.isOrientationLock()) {
                return;
            }
            UniversalPlayer universalPlayer = UniversalPlayer.this;
            if (universalPlayer.mPlayerContainer == null || !universalPlayer.canChangeOrientation() || UniversalPlayer.this.isFloatingMode() || OrientationHelper.isSystemOrientationLocked(BDPlayerConfig.getAppContext())) {
                return;
            }
            if (!UniversalPlayer.this.isFullMode()) {
                this.mIsLandscape = false;
                if (OrientationHelper.isPortrait(i)) {
                    this.mIsPortrait = true;
                }
                if (this.mIsPortrait && OrientationHelper.isLandscape(i) && UniversalPlayer.this.mPlayerContainer.getVisibility() == 0 && System.currentTimeMillis() - this.mChangedTime > 1000) {
                    this.mChangedTime = System.currentTimeMillis();
                    UniversalPlayer.this.switchToFull(0);
                    this.mIsPortrait = false;
                    return;
                }
                return;
            }
            this.mIsPortrait = false;
            if (OrientationHelper.isReverseLandscape(i)) {
                this.mIsLandscape = true;
                BdActivityUtils.requestLandscape(UniversalPlayer.this.getActivity(), true);
            } else if (OrientationHelper.isLandscape(i)) {
                this.mIsLandscape = true;
                BdActivityUtils.requestLandscape(UniversalPlayer.this.getActivity(), false);
            } else if (OrientationHelper.isPortrait(i) && this.mIsLandscape && System.currentTimeMillis() - this.mChangedTime > 1000) {
                this.mChangedTime = System.currentTimeMillis();
                UniversalPlayer.this.switchToHalf(0);
                this.mIsLandscape = false;
            }
        }
    }

    public UniversalPlayer(@Nullable Context context) {
        super(context);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
    }

    @PublicMethod
    public static boolean isOrientationLock() {
        return sIsOrientationLock;
    }

    private void syncWork() {
        if (this.mVideoSession.getStatus() == PlayerStatus.PLAYING) {
            this.mProgressHelper.start();
        } else {
            this.mProgressHelper.cancel();
        }
    }

    public boolean canChangeOrientation() {
        return true;
    }

    @PublicMethod
    public void disableOrientationEventHelper() {
        OrientationHelper orientationHelper = this.mOrientationHelper;
        if (orientationHelper == null) {
            return;
        }
        this.mIsEnableOrientation = false;
        orientationHelper.disable();
    }

    @PublicMethod
    public void enableOrientationEventHelper() {
        if (this.mOrientationHelper.canDetectOrientation()) {
            this.mIsEnableOrientation = this.mOrientationHelper.enableSensor();
        }
    }

    @IntRange(from = -1)
    @PublicMethod
    public int findLayerIndex(@NonNull ILayer iLayer) {
        return this.mLayerContainer.indexOfChild(iLayer.getContentView());
    }

    @PublicMethod
    public String getCurrentMode() {
        return this.mCurrentMode;
    }

    @PublicMethod
    public OrientationHelper getOrientationHelper() {
        return this.mOrientationHelper;
    }

    @Nullable
    @PublicMethod
    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        T t = (T) this.mContextMap.get(cls);
        if (t != null) {
            return t;
        }
        return null;
    }

    @NonNull
    @PublicMethod
    public IPlayerStyleSwitchHelper getStyleSwitchHelper() {
        return this.mStyleSwitchHelper;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @PublicMethod
    public void goBackOrForeground(boolean z) {
        super.goBackOrForeground(z);
        if (z) {
            enableOrientationEventHelper();
        } else {
            disableOrientationEventHelper();
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void initCallBackManager() {
        this.mCallbackManager = new UniversalPlayerCallbackManager();
    }

    public void initHelper() {
        this.mProgressHelper = new ProgressHelper(this);
        OrientationHelper orientationHelper = new OrientationHelper(BDPlayerConfig.getAppContext(), 3);
        this.mOrientationHelper = orientationHelper;
        if (orientationHelper.canDetectOrientation()) {
            this.mIsEnableOrientation = true;
            this.mOrientationHelper.disable();
            this.mOrientationHelper.setListener(new OrientationChangeCallBack());
        }
        this.mStyleSwitchHelper = new SimpleStyleSwitchHelper(this);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void initPlayer() {
        initHelper();
    }

    @PublicMethod
    public boolean isFloatingMode() {
        return TextUtils.equals(this.mCurrentMode, PlayerConstant.FLOATING_MODE);
    }

    @PublicMethod
    public boolean isFullMode() {
        return TextUtils.equals(this.mCurrentMode, PlayerConstant.FULL_MODE);
    }

    @PublicMethod
    public boolean isReverseLandscape() {
        OrientationHelper orientationHelper = this.mOrientationHelper;
        if (orientationHelper == null || !this.mIsEnableOrientation) {
            return false;
        }
        return OrientationHelper.isReverseLandscape(orientationHelper.getLastOrientation());
    }

    @PublicMethod
    public boolean onKeyBack() {
        if (isFullMode()) {
            BdVideoLog.d(TAG, "switch to half");
            switchToHalf(3);
            return true;
        }
        return false;
    }

    @PublicMethod
    public void registerContext(Class<? extends IPlayerContext> cls, @NonNull IPlayerContext iPlayerContext) {
        iPlayerContext.setPlayer(this);
        this.mContextMap.put(cls, iPlayerContext);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @PublicMethod
    public void release() {
        super.release();
        this.mContextMap.clear();
    }

    @PublicMethod
    public void setIsFullMode(boolean z) {
        if (z) {
            this.mCurrentMode = PlayerConstant.FULL_MODE;
        } else {
            this.mCurrentMode = PlayerConstant.HALF_MODE;
        }
    }

    @PublicMethod
    public void setOrientationHelper(@NonNull OrientationHelper orientationHelper) {
        this.mOrientationHelper = orientationHelper;
    }

    @PublicMethod
    public void setOrientationLock(boolean z) {
        sIsOrientationLock = z;
        if (z) {
            return;
        }
        enableOrientationEventHelper();
    }

    @PublicMethod
    public void setPlayerMode(String str) {
        this.mCurrentMode = str;
    }

    @PublicMethod
    public void setRemote(boolean z) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setRemote(z);
        }
    }

    @PublicMethod
    public void setStyleSwitchHelper(@NonNull IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper) {
        this.mStyleSwitchHelper = iPlayerStyleSwitchHelper;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupLayers(@NonNull Context context) {
    }

    @PublicMethod
    public void switchOrientationLock() {
        setOrientationLock(!sIsOrientationLock);
    }

    @PublicMethod
    public void switchToFull(int i) {
        switchToFull();
    }

    @PublicMethod
    public void switchToHalf(int i) {
        switchToHalf();
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @PublicMethod
    public void syncSession(@NonNull VideoSession videoSession) {
        super.syncSession(videoSession);
        syncWork();
    }

    @PublicMethod
    public int findLayerIndex(Class cls) {
        int childCount = this.mLayerContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.mLayerContainer.getChildAt(i).getClass() == cls) {
                return i;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @NonNull
    @PublicMethod
    public UniversalPlayerCallbackManager getPlayerCallbackManager() {
        return (UniversalPlayerCallbackManager) this.mCallbackManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @NonNull
    @PublicMethod
    public IUniversalPlayerStatDispatcher getStatDispatcher() {
        return UniversalStatDispatcherImp.EMPTY;
    }

    @PublicMethod
    public void switchToFull() {
        BdViewOpUtils.fixFullScreen4Notch(getActivity(), true);
        BdVideoLog.d(TAG, "player start switchToFull");
        getPlayerCallbackManager().onBeforeSwitchToFull();
        this.mStyleSwitchHelper.switchToFullStyle();
        sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_FULL));
        getPlayerCallbackManager().onVideoSwitchToFull();
    }

    @PublicMethod
    public void switchToHalf() {
        BdViewOpUtils.fixFullScreen4Notch(getActivity(), false);
        getPlayerCallbackManager().onBeforeSwitchToHalf();
        BdVideoLog.d(TAG, "player start switchToHalf");
        this.mStyleSwitchHelper.switchToNormalStyle();
        sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_HALF));
        getPlayerCallbackManager().onVideoSwitchToHalf();
    }

    public UniversalPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        super(context, baseKernelLayer);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
    }

    public UniversalPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer, @NonNull String str) {
        super(context, baseKernelLayer, str);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
    }
}
