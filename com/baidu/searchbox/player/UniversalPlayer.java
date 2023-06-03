package com.baidu.searchbox.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.baidu.searchbox.player.callback.UniversalPlayerCallbackManager;
import com.baidu.searchbox.player.config.PlayerConfig;
import com.baidu.searchbox.player.config.PlayerConfigKit;
import com.baidu.searchbox.player.constants.PlayerConstant;
import com.baidu.searchbox.player.context.IPlayerContext;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.IPlayerStyleSwitchHelper;
import com.baidu.searchbox.player.helper.ITimerTask;
import com.baidu.searchbox.player.helper.OrientationHelper;
import com.baidu.searchbox.player.helper.ProgressHelper;
import com.baidu.searchbox.player.helper.SimpleStyleSwitchHelper;
import com.baidu.searchbox.player.interfaces.IFloatingPlayerContext;
import com.baidu.searchbox.player.interfaces.INeuronSetupHelper;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.ILayer;
import com.baidu.searchbox.player.property.OrientationLockProperty;
import com.baidu.searchbox.player.property.PlayerPropertyKit;
import com.baidu.searchbox.player.property.PropertyManager;
import com.baidu.searchbox.player.property.Scope;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.stat.IUniversalPlayerStatDispatcher;
import com.baidu.searchbox.player.stat.UniversalStatDispatcherImp;
import com.baidu.searchbox.player.utils.BdActivityUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.BdViewOpUtils;
@SuppressLint({"KotlinPropertyAccess"})
/* loaded from: classes4.dex */
public class UniversalPlayer extends BDVideoPlayer {
    public static final String TAG = "UniversalPlayer";
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

    /* loaded from: classes4.dex */
    public class OrientationChangeCallBack implements OrientationHelper.IOrientationChange {
        public static final int DELAY_TIME = 1000;
        public long mChangedTime = 0;
        public boolean mIsLandscape;
        public boolean mIsPortrait;

        public OrientationChangeCallBack() {
        }

        @Override // com.baidu.searchbox.player.helper.OrientationHelper.IOrientationChange
        public void onOrientationChanged(int i) {
            if (!UniversalPlayer.this.isOrientationLocked()) {
                UniversalPlayer universalPlayer = UniversalPlayer.this;
                if (universalPlayer.mPlayerContainer == null || !universalPlayer.canChangeOrientation() || UniversalPlayer.this.isFloatingMode() || !UniversalPlayer.this.isForeground() || OrientationHelper.isSystemOrientationLocked(BDPlayerConfig.getAppContext())) {
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

    private void setupLockProperty(@Nullable PlayerConfig playerConfig) {
        OrientationLockProperty lockConfig = PlayerConfigKit.getLockConfig(playerConfig);
        getProperties().getLock().setScope(lockConfig.getScope());
        setOrientationLock(lockConfig.getState().booleanValue());
    }

    @IntRange(from = -1)
    public int findLayerIndex(@NonNull ILayer iLayer) {
        return this.mLayerContainer.indexOfChild(iLayer.getContentView());
    }

    @Nullable
    public <T extends IPlayerContext> T getPlayerContext(Class<T> cls) {
        T t = (T) this.mContextMap.get(cls);
        if (t != null) {
            return t;
        }
        return null;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void goBackOrForeground(boolean z) {
        super.goBackOrForeground(z);
        if (z) {
            enableOrientationEventHelper();
        } else {
            disableOrientationEventHelper();
        }
    }

    public void onOrientationLockConfigChange(boolean z) {
        setOrientationLock(z);
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void onPropertyStateChange(VideoEvent videoEvent) {
        super.onPropertyStateChange(videoEvent);
        onLockStateChanged(videoEvent);
    }

    public void sendSwitchHalfEvent(int i) {
        VideoEvent obtainEvent = LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_HALF);
        obtainEvent.putExtra(42, Integer.valueOf(i));
        sendEvent(obtainEvent);
    }

    public void setIsFullMode(boolean z) {
        if (z) {
            this.mCurrentMode = PlayerConstant.FULL_MODE;
        } else {
            this.mCurrentMode = PlayerConstant.HALF_MODE;
        }
    }

    public void setOrientationHelper(@NonNull OrientationHelper orientationHelper) {
        this.mOrientationHelper = orientationHelper;
    }

    public void setOrientationLock(boolean z) {
        setLockState(z, true);
    }

    public void setPlayerMode(String str) {
        this.mCurrentMode = str;
    }

    public void setRemote(boolean z) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setRemote(z);
        }
    }

    public void setStyleSwitchHelper(@NonNull IPlayerStyleSwitchHelper iPlayerStyleSwitchHelper) {
        this.mStyleSwitchHelper = iPlayerStyleSwitchHelper;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void setupProperties(@Nullable PlayerConfig playerConfig) {
        super.setupProperties(playerConfig);
        setupLockProperty(playerConfig);
    }

    public void switchToFloating(@NonNull IFloatingPlayerContext iFloatingPlayerContext) {
        String currentMode = getCurrentMode();
        setPlayerMode(PlayerConstant.FLOATING_MODE);
        iFloatingPlayerContext.switchToFloating();
        BdVideoLog.d(TAG, "player switch to floating");
        sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_FLOATING));
        getPlayerCallbackManager().onVideoSwitchToFloating(currentMode);
    }

    public void switchToFull(int i) {
        switchToFull();
    }

    public void switchToHalf(int i) {
        if (isEnablePlayerConfigNotch(false)) {
            BdViewOpUtils.fixFullScreen4Notch(getActivity(), false);
        }
        getPlayerCallbackManager().onBeforeSwitchToHalf();
        BdVideoLog.d(TAG, "player start switchToHalf");
        this.mStyleSwitchHelper.switchToNormalStyle();
        sendSwitchHalfEvent(i);
        getPlayerCallbackManager().onVideoSwitchToHalf();
    }

    public UniversalPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        super(context, baseKernelLayer);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
    }

    private void setLockState(boolean z, boolean z2) {
        if (!z) {
            enableOrientationEventHelper();
        }
        PlayerPropertyKit.setLockState(this, z, z2);
    }

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

    public UniversalPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer, @NonNull String str, @Nullable PlayerConfig playerConfig) {
        super(context, baseKernelLayer, str, "", playerConfig);
        this.mCurrentMode = PlayerConstant.HALF_MODE;
        this.mContextMap = new SimpleArrayMap<>();
        this.mVideoSession = VideoSessionManager.getInstance().createVideoSession();
    }

    public UniversalPlayer(@Nullable Context context, @NonNull String str, @Nullable PlayerConfig playerConfig) {
        super(context, str, playerConfig);
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

    @Deprecated
    public static boolean isOrientationLock() {
        return PropertyManager.queryLockState();
    }

    public void disableOrientationEventHelper() {
        OrientationHelper orientationHelper = this.mOrientationHelper;
        if (orientationHelper == null) {
            return;
        }
        this.mIsEnableOrientation = false;
        orientationHelper.disable();
    }

    public void enableOrientationEventHelper() {
        if (this.mOrientationHelper.canDetectOrientation()) {
            this.mIsEnableOrientation = this.mOrientationHelper.enableSensor();
        }
    }

    public String getCurrentMode() {
        return this.mCurrentMode;
    }

    public OrientationHelper getOrientationHelper() {
        return this.mOrientationHelper;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @NonNull
    public UniversalPlayerCallbackManager getPlayerCallbackManager() {
        return (UniversalPlayerCallbackManager) this.mCallbackManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.BDVideoPlayer
    @NonNull
    public IUniversalPlayerStatDispatcher getStatDispatcher() {
        return UniversalStatDispatcherImp.EMPTY;
    }

    @NonNull
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

    public boolean isFloatingMode() {
        return TextUtils.equals(this.mCurrentMode, PlayerConstant.FLOATING_MODE);
    }

    public boolean isFullMode() {
        return TextUtils.equals(this.mCurrentMode, PlayerConstant.FULL_MODE);
    }

    public boolean isOrientationLocked() {
        return getProperties().getLock().getState().booleanValue();
    }

    public boolean isReverseLandscape() {
        OrientationHelper orientationHelper = this.mOrientationHelper;
        if (orientationHelper != null && this.mIsEnableOrientation) {
            return OrientationHelper.isReverseLandscape(orientationHelper.getLastOrientation());
        }
        return false;
    }

    public boolean onKeyBack() {
        if (isFullMode()) {
            BdVideoLog.d(TAG, "switch to half");
            switchToHalf(3);
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.player.BDVideoPlayer
    public void release() {
        super.release();
        this.mContextMap.clear();
    }

    public void sendSwitchFullEvent() {
        sendEvent(LayerEvent.obtainEvent(LayerEvent.ACTION_SWITCH_FULL));
    }

    public void switchOrientationLock() {
        setOrientationLock(!isOrientationLocked());
    }

    public void switchToFull() {
        if (isEnablePlayerConfigNotch(true)) {
            BdViewOpUtils.fixFullScreen4Notch(getActivity(), true);
        }
        BdVideoLog.d(TAG, "player start switchToFull");
        getPlayerCallbackManager().onBeforeSwitchToFull();
        this.mStyleSwitchHelper.switchToFullStyle();
        sendSwitchFullEvent();
        getPlayerCallbackManager().onVideoSwitchToFull();
    }

    public void switchToHalf() {
        switchToHalf(-1);
    }

    private void onLockStateChanged(VideoEvent videoEvent) {
        if (TextUtils.equals(videoEvent.getStringExtra(1), OrientationLockProperty.class.getName()) && (videoEvent.getExtra(3) instanceof Scope) && PlayerPropertyKit.isMatch((Scope) videoEvent.getExtra(3), getProperties().getLock().getScope())) {
            setLockState(videoEvent.getBooleanExtra(2), false);
        }
    }

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
}
