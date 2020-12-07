package com.baidu.searchbox.player;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
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
/* loaded from: classes6.dex */
public class UniversalPlayer extends BDVideoPlayer {
    private static final String TAG = "UniversalPlayer";
    protected static boolean sIsOrientationLock = false;
    private SimpleArrayMap<Class<? extends IPlayerContext>, IPlayerContext> mContextMap;
    protected String mCurrentMode;
    protected boolean mIsEnableOrientation;
    protected OrientationHelper mOrientationHelper;
    protected ITimerTask mProgressHelper;
    protected IPlayerStyleSwitchHelper mStyleSwitchHelper;

    /* JADX INFO: Access modifiers changed from: protected */
    public UniversalPlayer(@Nullable Context context) {
        super(context);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
    }

    protected UniversalPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        super(context, baseKernelLayer);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
    }

    protected UniversalPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer, @NonNull String str) {
        super(context, baseKernelLayer, str);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    protected void setupLayers(@NonNull Context context) {
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    protected void initPlayer() {
        initHelper();
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    protected void initCallBackManager() {
        this.mCallbackManager = new UniversalPlayerCallbackManager();
    }

    @PublicMethod
    public void registerContext(Class<? extends IPlayerContext> cls, @NonNull IPlayerContext iPlayerContext) {
        iPlayerContext.setPlayer(this);
        this.mContextMap.put(cls, iPlayerContext);
    }

    @PublicMethod
    @Nullable
    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        T t = (T) this.mContextMap.get(cls);
        if (t != null) {
            return t;
        }
        return null;
    }

    protected void initHelper() {
        this.mProgressHelper = new ProgressHelper(this);
        this.mOrientationHelper = new OrientationHelper(BDPlayerConfig.getAppContext(), 3);
        if (this.mOrientationHelper.canDetectOrientation()) {
            this.mIsEnableOrientation = true;
            this.mOrientationHelper.disable();
            this.mOrientationHelper.setListener(new OrientationChangeCallBack());
        }
        this.mStyleSwitchHelper = new SimpleStyleSwitchHelper(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @PublicMethod
    @NonNull
    public UniversalPlayerCallbackManager getPlayerCallbackManager() {
        return (UniversalPlayerCallbackManager) this.mCallbackManager;
    }

    @PublicMethod
    public void setStyleSwitchHelper(@NonNull IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper) {
        this.mStyleSwitchHelper = iPlayerStyleSwitchHelper;
    }

    @PublicMethod
    @NonNull
    public IPlayerStyleSwitchHelper getStyleSwitchHelper() {
        return this.mStyleSwitchHelper;
    }

    @PublicMethod
    @IntRange(from = -1)
    public int findLayerIndex(@NonNull ILayer iLayer) {
        return this.mLayerContainer.indexOfChild(iLayer.getContentView());
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

    @PublicMethod
    public boolean onKeyBack() {
        if (isFullMode()) {
            BdVideoLog.d(TAG, "switch to half");
            switchToHalf(3);
            return true;
        }
        return false;
    }

    private void syncWork() {
        if (this.mVideoSession.getStatus() == PlayerStatus.PLAYING) {
            this.mProgressHelper.start();
        } else {
            this.mProgressHelper.cancel();
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @PublicMethod
    public void syncSession(@NonNull VideoSession videoSession) {
        super.syncSession(videoSession);
        syncWork();
    }

    protected boolean canChangeOrientation() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @PublicMethod
    @NonNull
    public IUniversalPlayerStatDispatcher getStatDispatcher() {
        return UniversalStatDispatcherImp.EMPTY;
    }

    @PublicMethod
    public void switchToFull(int i) {
        switchToFull();
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
    public void switchToHalf(int i) {
        switchToHalf();
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

    @PublicMethod
    public void enableOrientationEventHelper() {
        if (this.mOrientationHelper.canDetectOrientation()) {
            this.mIsEnableOrientation = this.mOrientationHelper.enableSensor();
        }
    }

    @PublicMethod
    public void disableOrientationEventHelper() {
        if (this.mOrientationHelper != null) {
            this.mIsEnableOrientation = false;
            this.mOrientationHelper.disable();
        }
    }

    @PublicMethod
    public OrientationHelper getOrientationHelper() {
        return this.mOrientationHelper;
    }

    @PublicMethod
    public void setOrientationHelper(@NonNull OrientationHelper orientationHelper) {
        this.mOrientationHelper = orientationHelper;
    }

    @PublicMethod
    public boolean isReverseLandscape() {
        if (this.mOrientationHelper == null || !this.mIsEnableOrientation) {
            return false;
        }
        return OrientationHelper.isReverseLandscape(this.mOrientationHelper.getLastOrientation());
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
    public boolean isFullMode() {
        return TextUtils.equals(this.mCurrentMode, PlayerConstant.FULL_MODE);
    }

    @PublicMethod
    public String getCurrentMode() {
        return this.mCurrentMode;
    }

    @PublicMethod
    public void setPlayerMode(String str) {
        this.mCurrentMode = str;
    }

    @PublicMethod
    public boolean isFloatingMode() {
        return TextUtils.equals(this.mCurrentMode, PlayerConstant.FLOATING_MODE);
    }

    @PublicMethod
    public void setOrientationLock(boolean z) {
        sIsOrientationLock = z;
        if (!sIsOrientationLock) {
            enableOrientationEventHelper();
        }
    }

    @PublicMethod
    public void switchOrientationLock() {
        setOrientationLock(!sIsOrientationLock);
    }

    @PublicMethod
    public static boolean isOrientationLock() {
        return sIsOrientationLock;
    }

    @PublicMethod
    public void setRemote(boolean z) {
        if (this.mKernelLayer != null) {
            this.mKernelLayer.setRemote(z);
        }
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @PublicMethod
    public void release() {
        super.release();
        this.mContextMap.clear();
    }

    /* loaded from: classes6.dex */
    public class OrientationChangeCallBack implements OrientationHelper.IOrientationChange {
        private static final int DELAY_TIME = 1000;
        private long mChangedTime = 0;
        private boolean mIsLandscape;
        private boolean mIsPortrait;

        public OrientationChangeCallBack() {
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i) {
            if (!UniversalPlayer.isOrientationLock() && UniversalPlayer.this.mPlayerContainer != null && UniversalPlayer.this.canChangeOrientation() && !UniversalPlayer.this.isFloatingMode() && !OrientationHelper.isSystemOrientationLocked(BDPlayerConfig.getAppContext())) {
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
    }
}
