package com.baidu.searchbox.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.player.helper.ITimerTask;
import com.baidu.searchbox.player.helper.OrientationHelper;
import com.baidu.searchbox.player.helper.ProgressHelper;
import com.baidu.searchbox.player.helper.SimpleStyleSwitchHelper;
import com.baidu.searchbox.player.interfaces.INeuronSetupHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.ILayer;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher;
import com.baidu.searchbox.player.stat.UniversalStatDispatcherImp;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes2.dex */
public class UniversalPlayer extends BDVideoPlayer {
    public static final String TAG = "UniversalPlayer";
    public static boolean sIsOrientationLock;
    public final SimpleArrayMap<Class<? extends IPlayerContext>, IPlayerContext> mContextMap;
    public String mCurrentMode;
    public boolean mIsEnableOrientation;
    public OrientationHelper mOrientationHelper;
    public ITimerTask mProgressHelper;
    public IPlayerStyleSwitchHelper mStyleSwitchHelper;
    @Deprecated
    public VideoSession mVideoSession;

    public boolean canChangeOrientation() {
        return true;
    }

    @Nullable
    public INeuronSetupHelper getNeuronSetupHelper() {
        return null;
    }

    public boolean isEnablePlayerConfigNotch(boolean z) {
        return true;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupLayers(@NonNull Context context) {
    }

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
            if (!UniversalPlayer.isOrientationLock()) {
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
    }

    public UniversalPlayer(@Nullable Context context) {
        super(context);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
    }

    private void setupInternalNeuron(@NonNull Context context) {
        if (getNeuronSetupHelper() != null) {
            getNeuronSetupHelper().setupInternalNeuron(context);
        }
    }

    @IntRange(from = -1)
    @PublicMethod
    public int findLayerIndex(@NonNull ILayer iLayer) {
        return this.mLayerContainer.indexOfChild(iLayer.getContentView());
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
        if (!z) {
            enableOrientationEventHelper();
        }
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

    @PublicMethod
    public void switchToFull(int i) {
        switchToFull();
    }

    public UniversalPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        super(context, baseKernelLayer);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
    }

    @PublicMethod
    public void registerContext(Class<? extends IPlayerContext> cls, @NonNull IPlayerContext iPlayerContext) {
        iPlayerContext.setPlayer(this);
        this.mContextMap.put(cls, iPlayerContext);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupPlayer(@NonNull Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        super.setupPlayer(context, baseKernelLayer);
        setupInternalNeuron(context);
    }

    public UniversalPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer, @NonNull String str) {
        super(context, baseKernelLayer, str, "");
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
    }

    public UniversalPlayer(@Nullable Context context, @NonNull String str, @Nullable String str2) {
        super(context, null, str, str2);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
    }

    @PublicMethod
    public static boolean isOrientationLock() {
        return sIsOrientationLock;
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

    @PublicMethod
    public String getCurrentMode() {
        return this.mCurrentMode;
    }

    @PublicMethod
    public OrientationHelper getOrientationHelper() {
        return this.mOrientationHelper;
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

    @NonNull
    @PublicMethod
    public IPlayerStyleSwitchHelper getStyleSwitchHelper() {
        return this.mStyleSwitchHelper;
    }

    @NonNull
    @Deprecated
    public VideoSession getVideoSession() {
        return this.mVideoSession;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void initCallBackManager() {
        this.mCallbackManager = new UniversalPlayerCallbackManager();
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
        if (orientationHelper != null && this.mIsEnableOrientation) {
            return OrientationHelper.isReverseLandscape(orientationHelper.getLastOrientation());
        }
        return false;
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

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @PublicMethod
    public void release() {
        super.release();
        this.mContextMap.clear();
    }

    @PublicMethod
    public void switchOrientationLock() {
        setOrientationLock(!sIsOrientationLock);
    }

    @PublicMethod
    public void switchToHalf() {
        switchToHalf(-1);
    }

    @PublicMethod
    public int findLayerIndex(Class<?> cls) {
        int childCount = this.mLayerContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (this.mLayerContainer.getChildAt(i).getClass() == cls) {
                return i;
            }
        }
        return -1;
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

    @PublicMethod
    public void switchToFull() {
        if (isEnablePlayerConfigNotch(true)) {
            BdViewOpUtils.fixFullScreen4Notch(getActivity(), true);
        }
        BdVideoLog.d(TAG, "player start switchToFull");
        getPlayerCallbackManager().onBeforeSwitchToFull();
        this.mStyleSwitchHelper.switchToFullStyle();
        sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_FULL));
        getPlayerCallbackManager().onVideoSwitchToFull();
    }

    @PublicMethod
    public void switchToHalf(int i) {
        if (isEnablePlayerConfigNotch(false)) {
            BdViewOpUtils.fixFullScreen4Notch(getActivity(), false);
        }
        getPlayerCallbackManager().onBeforeSwitchToHalf();
        BdVideoLog.d(TAG, "player start switchToHalf");
        this.mStyleSwitchHelper.switchToNormalStyle();
        sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_HALF));
        getPlayerCallbackManager().onVideoSwitchToHalf();
    }
}
