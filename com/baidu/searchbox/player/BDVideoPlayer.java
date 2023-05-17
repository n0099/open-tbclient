package com.baidu.searchbox.player;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.callback.IVideoPlayerCallback;
import com.baidu.searchbox.player.callback.VideoPlayerCallbackBaseManager;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEventTrigger;
import com.baidu.searchbox.player.event.InternalSyncControlEventTrigger;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.StatisticsEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.SimpleKernelReuseHelper;
import com.baidu.searchbox.player.helper.VideoSystemHelper;
import com.baidu.searchbox.player.interfaces.IKernelLayerReuseHelper;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.interfaces.InternalEventDispatcher;
import com.baidu.searchbox.player.kernel.AbsVideoKernel;
import com.baidu.searchbox.player.kernel.IKernelPlayer;
import com.baidu.searchbox.player.layer.AbsLayer;
import com.baidu.searchbox.player.layer.BaseKernelLayer;
import com.baidu.searchbox.player.layer.LayerContainer;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.model.VideoTask;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.plugin.PluginManager;
import com.baidu.searchbox.player.session.VideoSessionManager;
import com.baidu.searchbox.player.ubc.IPlayerStatisticsDispatcher;
import com.baidu.searchbox.player.ubc.SimpleVideoStatisticsDispatcher;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class BDVideoPlayer implements IBVideoPlayer, IKernelPlayer {
    public static final String TAG = "BDVideoPlayer";
    public static boolean sGlobalMute;
    public boolean isUseCache;
    public AudioFocusChangedListener mAudioFocusListener;
    public AudioManager mAudioManager;
    public VideoPlayerCallbackBaseManager mCallbackManager;
    public ViewGroup.LayoutParams mContainerLayoutParams;
    public final ControlEventTrigger mControlEventTrigger;
    public boolean mHasAudioFocus;
    public boolean mIsForeground;
    public boolean mIsMute;
    @Nullable
    public String mKLayerCacheKey;
    @Nullable
    public BaseKernelLayer mKernelLayer;
    @NonNull
    public String mKey;
    public LayerContainer mLayerContainer;
    public IMessenger mMessenger;
    public ViewGroup mPlayerContainer;
    public final PlayerEventTrigger mPlayerEventTrigger;
    public PluginManager mPluginManager;
    public IKernelLayerReuseHelper mReuseHelper;
    public int mScaleMode;
    public float mSpeed;
    public final StatisticsEventTrigger mStatEventTrigger;
    public final InternalSyncControlEventTrigger mSyncControlEventTrigger;
    public int mVideoLoopCount;
    public VideoTask mVideoTask;

    @NonNull
    public String getBackupKernelType() {
        return AbsVideoKernel.CYBER_PLAYER;
    }

    @PublicMethod
    public int getPlayerStageType() {
        return -1;
    }

    public void initPlayer() {
    }

    @Deprecated
    public void setParameter(String str, int i) {
    }

    public abstract void setupLayers(@NonNull Context context);

    public void setupPlugin(@NonNull Context context) {
    }

    /* loaded from: classes3.dex */
    public class AudioFocusChangedListener implements AudioManager.OnAudioFocusChangeListener {
        public AudioFocusChangedListener() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            BDVideoPlayer.this.onAudioFocusChanged(i);
        }
    }

    /* loaded from: classes3.dex */
    public class InternalPlayerDispatcher implements InternalEventDispatcher {
        @Override // com.baidu.searchbox.player.interfaces.InternalEventDispatcher
        public int getExpectOrder() {
            return 0;
        }

        public InternalPlayerDispatcher() {
        }

        @Override // com.baidu.searchbox.player.interfaces.InternalEventDispatcher
        public void onVideoEventNotify(VideoEvent videoEvent) {
            BDVideoPlayer.this.getPlayerCallbackManager().dispatchPlayerAction(videoEvent);
        }
    }

    public BDVideoPlayer(@Nullable Context context) {
        this(context, new BaseKernelLayer(AbsVideoKernel.NORMAL_PLAYER));
    }

    private void createEnv(Context context) {
        this.mContainerLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.mVideoTask = new VideoTask();
        initMessenger();
        this.mPluginManager = new PluginManager(this);
        LayerContainer createLayerContainer = createLayerContainer(context);
        this.mLayerContainer = createLayerContainer;
        createLayerContainer.bindPlayer(this);
        this.mLayerContainer.setClickable(true);
        initCallBackManager();
    }

    private void createSessionId(boolean z) {
        if (z || TextUtils.isEmpty(this.mVideoTask.sessionId)) {
            this.mVideoTask.sessionId = VideoSessionManager.getInstance().getSessionId(getVideoUniqueKey());
        }
    }

    @PublicMethod
    public void addInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        this.mMessenger.addInterceptor(iVideoEventInterceptor);
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer) {
        this.mLayerContainer.addLayer(absLayer);
    }

    @PublicMethod
    public void addPlugin(@NonNull AbsPlugin absPlugin) {
        this.mPluginManager.addPlugin(absPlugin);
    }

    public boolean attachKLayerFromCache(@Nullable String str) {
        return getReuseHelper().attachCache(this, str);
    }

    @PublicMethod
    public void attachToContainer(@NonNull ViewGroup viewGroup) {
        attachToContainer(viewGroup, true);
    }

    public LayerContainer createLayerContainer(Context context) {
        return new LayerContainer(context);
    }

    public boolean detachKLayerToCache(String str) {
        boolean detachCache = getReuseHelper().detachCache(this, str);
        if (detachCache) {
            setUseCache(false);
        }
        return detachCache;
    }

    @PublicMethod
    public void detachLayer(@NonNull AbsLayer absLayer) {
        this.mLayerContainer.detachLayer(absLayer, true);
    }

    @PublicMethod
    public void insertLayer(@NonNull AbsLayer absLayer) {
        this.mLayerContainer.insertLayer(absLayer, (FrameLayout.LayoutParams) null);
    }

    public boolean matchStatus(@NonNull PlayerStatus... playerStatusArr) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return false;
        }
        return baseKernelLayer.getVideoSession().matchStatus(playerStatusArr);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void mute(boolean z) {
        BdVideoLog.i(wrapMessage("mute(" + z + SmallTailInfo.EMOTION_SUFFIX));
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.mute(z);
    }

    public void onAudioFocusChanged(final int i) {
        Activity activity = getActivity();
        if (activity != null && !isPlayerMute()) {
            activity.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.player.BDVideoPlayer.1
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = i;
                    if ((i2 == -2 || i2 == -1) && BDVideoPlayer.this.isPlaying()) {
                        BDVideoPlayer.this.pause(2);
                        BDVideoPlayer.this.abandonAudioFocus();
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onBufferingUpdate(int i) {
        getPlayerEventTrigger().onBufferingUpdate(i);
    }

    @PublicMethod
    public void pauseInternal(boolean z) {
        pause(z ? 1 : 0);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void play(String str) {
        BdVideoLog.i(wrapMessage("play(), url = " + str));
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.play(str);
    }

    public void removeInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        this.mMessenger.removeInterceptor(iVideoEventInterceptor);
    }

    @PublicMethod
    public void removePlugin(@NonNull AbsPlugin absPlugin) {
        this.mPluginManager.removePlugin(absPlugin);
    }

    @PublicMethod
    public void replaceVideoHolder(@NonNull ViewGroup viewGroup) {
        this.mPlayerContainer = viewGroup;
    }

    public void restoreVideoTask(@NonNull BaseKernelLayer baseKernelLayer) {
        this.mVideoTask.videoUrl = baseKernelLayer.getVideoUrl();
        this.mVideoTask.duration = baseKernelLayer.getDuration();
        this.mVideoTask.position = baseKernelLayer.getPosition();
        this.mVideoTask.positionMs = baseKernelLayer.getPositionMs();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void seekTo(int i) {
        getControlEventTrigger().seekToMs(i * 1000, 3);
    }

    @PublicMethod
    public void seekToMs(int i) {
        getControlEventTrigger().seekToMs(i, 3);
    }

    @PublicMethod
    public void sendEvent(@NonNull VideoEvent videoEvent) {
        this.mMessenger.notifyEvent(videoEvent);
    }

    @PublicMethod(version = "12.0.0.0")
    public void setClarityInfo(@Nullable String str) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setClarityInfo(str);
        }
    }

    @PublicMethod
    public void setDecodeMode(int i) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setDecodeMode(i);
        }
    }

    @PublicMethod
    public void setGlobalMuteMode(boolean z) {
        sGlobalMute = z;
        setMuteMode(z);
    }

    @PublicMethod
    public void setHasReplaceUrl(boolean z) {
        if (z && this.mKernelLayer != null) {
            BdVideoLog.i(wrapMessage("setHasReplaceUrl(" + z + SmallTailInfo.EMOTION_SUFFIX));
            this.mKernelLayer.updateFreeProxy(null);
        }
    }

    @PublicMethod
    public void setHttpHeader(HashMap<String, String> hashMap) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setHttpHeader(hashMap);
        }
    }

    @PublicMethod
    public void setInterceptor(@Nullable IVideoEventInterceptor iVideoEventInterceptor) {
        this.mMessenger.setInterceptor(iVideoEventInterceptor);
    }

    @PublicMethod(version = "11.26.0.0")
    public void setKLayerCacheKey(@NonNull String str) {
        this.mKLayerCacheKey = str;
    }

    @PublicMethod
    public void setLooping(boolean z) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.setLooping(z);
    }

    @PublicMethod(version = "12.0.0.0")
    public void setPlayConf(@Nullable String str) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setPlayConf(str);
        }
    }

    @PublicMethod
    public void setPlayerListener(IVideoPlayerCallback iVideoPlayerCallback) {
        getPlayerCallbackManager().setVideoPlayerCallback(iVideoPlayerCallback);
    }

    @PublicMethod
    public void setProxy(@Nullable String str) {
        BdVideoLog.i(wrapMessage("setProxy(" + str + SmallTailInfo.EMOTION_SUFFIX));
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.setProxy(str);
    }

    @PublicMethod(version = "11.26.0.0")
    public void setRadius(float f) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setRadius(f);
        }
    }

    public void setReuseHelper(@NonNull IKernelLayerReuseHelper iKernelLayerReuseHelper) {
        this.mReuseHelper = iKernelLayerReuseHelper;
    }

    @PublicMethod
    public void setSpeed(float f) {
        this.mSpeed = f;
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setSpeed(f);
            BdVideoLog.i(wrapMessage("setSpeed(" + f + SmallTailInfo.EMOTION_SUFFIX));
        }
    }

    public void setTraceId(@NonNull String str) {
        this.mVideoTask.traceId = str;
    }

    public void setUseCache(boolean z) {
        this.isUseCache = z;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setUserAgent(String str) {
        BdVideoLog.i(wrapMessage("setUserAgent(" + str + SmallTailInfo.EMOTION_SUFFIX));
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.setUserAgent(str);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoBackground(Drawable drawable) {
        View bVideoView;
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null || (bVideoView = baseKernelLayer.getVideoKernel().getBVideoView()) == null) {
            return;
        }
        bVideoView.setBackground(drawable);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoRotation(int i) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        baseKernelLayer.setVideoRotation(i);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoScalingMode(int i) {
        BdVideoLog.i(wrapMessage("setVideoScalingMode(" + i + SmallTailInfo.EMOTION_SUFFIX));
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        this.mScaleMode = i;
        baseKernelLayer.setVideoScalingMode(i);
    }

    @PublicMethod
    public void setVideoUniqueKey(@NonNull String str) {
        this.mKey = str;
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void setVideoUrl(@NonNull String str) {
        setVideoUrl(str, true);
    }

    @PublicMethod
    public void setupKernelLayer(@Nullable BaseKernelLayer baseKernelLayer) {
        getStatDispatcher().startInitPlayerKernel();
        if (baseKernelLayer != null) {
            attachKernelLayer(baseKernelLayer);
        }
        getStatDispatcher().endInitPlayerKernel();
    }

    @PublicMethod(version = "12.0.0.0")
    public void switchMediaSource(int i) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.switchMediaSource(i);
        }
    }

    @PublicMethod
    public void syncStatus(@NonNull PlayerStatus playerStatus) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.getVideoSession().statusChangeNotify(playerStatus);
        }
    }

    @PublicMethod(version = "11.23.0.0")
    public void updateFreeProxy(@Nullable String str) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.updateFreeProxy(str);
        }
    }

    @PublicMethod
    public void updateStatisticsContent(@NonNull Object obj) {
        VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_UPDATE_CONTENT);
        obtainEvent.putExtra(13, obj);
        getStatEventTrigger().triggerEvent(obtainEvent);
    }

    public BDVideoPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        this(context, baseKernelLayer, "", "");
    }

    @PublicMethod
    public void addInterceptor(int i, @NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        this.mMessenger.addInterceptor(i, iVideoEventInterceptor);
    }

    @PublicMethod
    public void addLayer(@NonNull AbsLayer absLayer, FrameLayout.LayoutParams layoutParams) {
        this.mLayerContainer.addLayer(absLayer, layoutParams);
    }

    @PublicMethod(version = "11.24.0.0")
    public void setExternalInfo(String str, Object obj) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setExternalInfo(str, obj);
        }
    }

    @PublicMethod(version = "11.24.0.0")
    public void setOption(String str, String str2) {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.setOption(str, str2);
        }
    }

    @PublicMethod
    public void setVideoUrl(@NonNull String str, boolean z) {
        BdVideoLog.i(wrapMessage("setVideoUrl = " + str));
        this.mVideoTask.videoUrl = str;
        createSessionId(z);
        getPlayerEventTrigger().setDataSource(this.mVideoTask.videoUrl, z, getPlayerStageType());
    }

    public void setupPlayer(@NonNull Context context, @Nullable BaseKernelLayer baseKernelLayer) {
        setupTrigger();
        setupKernelLayer(baseKernelLayer);
        setupLayers(context);
        setupPlugin(context);
    }

    public BDVideoPlayer(@Nullable Context context, @Nullable BaseKernelLayer baseKernelLayer, @NonNull String str, @Nullable String str2) {
        this.mIsForeground = false;
        this.mStatEventTrigger = new StatisticsEventTrigger();
        this.mPlayerEventTrigger = new PlayerEventTrigger();
        this.mControlEventTrigger = new ControlEventTrigger();
        this.mSyncControlEventTrigger = new InternalSyncControlEventTrigger();
        this.mIsMute = false;
        this.mSpeed = 1.0f;
        this.mVideoLoopCount = 0;
        this.isUseCache = false;
        this.mScaleMode = 2;
        this.mKey = str;
        this.mKLayerCacheKey = str2;
        BdVideoLog.i(wrapMessage("BDVideoPlayer(" + context + ",  kernelLayer@" + System.identityHashCode(baseKernelLayer) + ", key@" + this.mKey + SmallTailInfo.EMOTION_SUFFIX));
        getStatDispatcher().startInitPlayer();
        context = context == null ? getAppContext() : context;
        createEnv(context);
        initPlayer();
        setupPlayer(context, baseKernelLayer);
        getStatDispatcher().endInitPlayer();
    }

    @NonNull
    private InternalSyncControlEventTrigger getInternalSyncControlEventTrigger() {
        return this.mSyncControlEventTrigger;
    }

    private void initMessenger() {
        IMessenger createMessenger = BDPlayerConfig.getMessengerFactory().createMessenger();
        this.mMessenger = createMessenger;
        createMessenger.addInternalDispatcher(new InternalPlayerDispatcher());
        VideoSessionManager.getInstance().bindPlayer(this);
    }

    @PublicMethod
    public static boolean isGlobalMute() {
        return sGlobalMute;
    }

    private void releaseMessenger() {
        VideoSessionManager.getInstance().unbindPlayer(this);
        this.mMessenger.release();
    }

    public void abandonAudioFocus() {
        AudioFocusChangedListener audioFocusChangedListener;
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null && (audioFocusChangedListener = this.mAudioFocusListener) != null) {
            audioManager.abandonAudioFocus(audioFocusChangedListener);
            BdVideoLog.i(wrapMessage("abandonAudioFocus()"));
            this.mAudioManager = null;
            this.mAudioFocusListener = null;
        }
        this.mHasAudioFocus = false;
    }

    @PublicMethod
    public void detachFromContainer() {
        detachFromContainer(true);
    }

    public boolean detachKLayerToCache() {
        return detachKLayerToCache(this.mKLayerCacheKey);
    }

    @Nullable
    @PublicMethod
    public BaseKernelLayer detachKernelLayer() {
        if (this.mKernelLayer == null) {
            return null;
        }
        BdVideoLog.i(wrapMessage("detachKernelLayer = " + System.identityHashCode(this.mKernelLayer)));
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        this.mLayerContainer.detachLayer((AbsLayer) baseKernelLayer, true);
        baseKernelLayer.setKernelCallBack(null);
        this.mKernelLayer = null;
        return baseKernelLayer;
    }

    @Nullable
    @PublicMethod
    public Activity getActivity() {
        ViewGroup viewGroup = this.mPlayerContainer;
        if (viewGroup != null && (viewGroup.getContext() instanceof Activity)) {
            return (Activity) this.mPlayerContainer.getContext();
        }
        return null;
    }

    @NonNull
    @PublicMethod
    public Context getAppContext() {
        return BDPlayerConfig.getAppContext();
    }

    @Nullable
    @PublicMethod
    public ViewGroup getAttachedContainer() {
        return this.mPlayerContainer;
    }

    @PublicMethod
    public int getBufferingPosition() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return 0;
        }
        return baseKernelLayer.getBufferingPosition();
    }

    @NonNull
    @PublicMethod
    public ControlEventTrigger getControlEventTrigger() {
        return this.mControlEventTrigger;
    }

    @PublicMethod
    public int getDecodeMode() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            return baseKernelLayer.getDecodeMode();
        }
        return 0;
    }

    @PublicMethod
    public int getDuration() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return this.mVideoTask.duration;
        }
        return baseKernelLayer.getDuration();
    }

    @PublicMethod
    public int getDurationMs() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return this.mVideoTask.duration * 1000;
        }
        return baseKernelLayer.getDurationMs();
    }

    @Nullable
    @PublicMethod(version = "11.26.0.0")
    public String getKLayerCacheKey() {
        return this.mKLayerCacheKey;
    }

    @Nullable
    public String getKLogId() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            return baseKernelLayer.getKernelLogId();
        }
        return "";
    }

    @NonNull
    @PublicMethod
    public LayerContainer getLayerContainer() {
        return this.mLayerContainer;
    }

    @PublicMethod
    public int getLoopCount() {
        return this.mVideoLoopCount;
    }

    public IMessenger getMessenger() {
        return this.mMessenger;
    }

    @NonNull
    @PublicMethod
    public VideoPlayerCallbackBaseManager getPlayerCallbackManager() {
        return this.mCallbackManager;
    }

    public PlayerEventTrigger getPlayerEventTrigger() {
        return this.mPlayerEventTrigger;
    }

    @Nullable
    @PublicMethod
    public BaseKernelLayer getPlayerKernelLayer() {
        return this.mKernelLayer;
    }

    @PublicMethod
    public int getPosition() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return 0;
        }
        return baseKernelLayer.getPosition();
    }

    @PublicMethod
    public int getPositionMs() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return 0;
        }
        return baseKernelLayer.getPositionMs();
    }

    @NonNull
    public IKernelLayerReuseHelper getReuseHelper() {
        if (this.mReuseHelper == null) {
            this.mReuseHelper = new SimpleKernelReuseHelper();
        }
        return this.mReuseHelper;
    }

    @PublicMethod(version = "12.10.0.0")
    public int getScaleMode() {
        return this.mScaleMode;
    }

    @Nullable
    @PublicMethod
    public String getServerIpInfo() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            return baseKernelLayer.getServerIpInfo();
        }
        return null;
    }

    @Nullable
    public String getSessionId() {
        return this.mVideoTask.sessionId;
    }

    @PublicMethod(version = "12.2.0.0")
    public float getSpeed() {
        return this.mSpeed;
    }

    @NonNull
    @PublicMethod
    @Deprecated
    public IPlayerStatisticsDispatcher getStatDispatcher() {
        return SimpleVideoStatisticsDispatcher.EMPTY;
    }

    @NonNull
    @PublicMethod(version = "11.24.0.0")
    public StatisticsEventTrigger getStatEventTrigger() {
        return this.mStatEventTrigger;
    }

    @NonNull
    @PublicMethod
    public PlayerStatus getStatus() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return PlayerStatus.IDLE;
        }
        return baseKernelLayer.getStatus();
    }

    @PublicMethod
    public int getSyncPositionMs() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return 0;
        }
        return baseKernelLayer.getSyncPositionMs();
    }

    @PublicMethod(version = "11.24.0.0")
    public int getVideoHeight() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            return baseKernelLayer.getVideoHeight();
        }
        return 0;
    }

    @PublicMethod
    public VideoTask getVideoTask() {
        return this.mVideoTask;
    }

    @NonNull
    @PublicMethod
    public String getVideoUniqueKey() {
        return this.mKey;
    }

    @PublicMethod
    public String getVideoUrl() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return "";
        }
        return baseKernelLayer.getVideoUrl();
    }

    @PublicMethod(version = "11.24.0.0")
    public int getVideoWidth() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            return baseKernelLayer.getVideoWidth();
        }
        return 0;
    }

    public void initCallBackManager() {
        this.mCallbackManager = new VideoPlayerCallbackBaseManager();
    }

    @PublicMethod
    public boolean isAttachToContainer() {
        if (this.mLayerContainer.getParent() != null) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isComplete() {
        if (getStatus() == PlayerStatus.COMPLETE) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isError() {
        if (getStatus() == PlayerStatus.ERROR) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isForeground() {
        return this.mIsForeground;
    }

    @PublicMethod
    public boolean isHasAudioFocus() {
        return this.mHasAudioFocus;
    }

    @PublicMethod
    public boolean isIdle() {
        if (getStatus() == PlayerStatus.IDLE) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isMute() {
        return this.mIsMute;
    }

    @PublicMethod
    public boolean isPause() {
        if (getStatus() == PlayerStatus.PAUSE) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isPlayerMute() {
        return isGlobalMute();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public boolean isPlaying() {
        if (getStatus() == PlayerStatus.PLAYING) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isPrepared() {
        if (getStatus() == PlayerStatus.PREPARED) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isPreparing() {
        if (getStatus() == PlayerStatus.PREPARING) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isStop() {
        if (getStatus() == PlayerStatus.STOP) {
            return true;
        }
        return false;
    }

    public boolean isUseCache() {
        return this.isUseCache;
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onCompletion() {
        abandonAudioFocus();
        getPlayerEventTrigger().onCompletion();
        getStatDispatcher().end(getLoopCount());
        getStatEventTrigger().onPlayerComplete(getLoopCount());
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onPrepared() {
        getPlayerEventTrigger().onPrepared();
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onSeekComplete() {
        getPlayerEventTrigger().onSeekComplete();
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void pause() {
        pause(0);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void prepare() {
        BdVideoLog.i(wrapMessage("prepare()"));
        getControlEventTrigger().prepare();
        getInternalSyncControlEventTrigger().prepare();
    }

    public void releaseKernelLayer() {
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.pause();
            this.mKernelLayer.stop();
            this.mKernelLayer.release();
        }
    }

    public void releaseTrigger() {
        getStatEventTrigger().release();
        getPlayerEventTrigger().release();
        getControlEventTrigger().release();
        getInternalSyncControlEventTrigger().release();
    }

    public void resumeFromError() {
        BdVideoLog.i(wrapMessage("resumeFromError()"));
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.stopPlayback();
        }
        setVideoScalingMode(getScaleMode());
        setVideoUrl(this.mVideoTask.videoUrl);
        resumePlayer(false);
    }

    public void setupTrigger() {
        getStatEventTrigger().setMessenger(this.mMessenger);
        getPlayerEventTrigger().setMessenger(this.mMessenger);
        getControlEventTrigger().setMessenger(this.mMessenger);
        getInternalSyncControlEventTrigger().setMessenger(this.mMessenger);
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void start() {
        BdVideoLog.i(wrapMessage("start()"));
        doPlay();
    }

    @PublicMethod
    public void attachKernelLayer(@NonNull BaseKernelLayer baseKernelLayer) {
        detachKernelLayer();
        BdVideoLog.i(wrapMessage("attachKernelLayer(" + System.identityHashCode(baseKernelLayer) + "), kernel = " + System.identityHashCode(baseKernelLayer.getVideoKernel())));
        this.mKernelLayer = baseKernelLayer;
        baseKernelLayer.setKernelCallBack(this);
        this.mLayerContainer.attachKernelLayer(baseKernelLayer);
    }

    @PublicMethod
    public void pause(int i) {
        BdVideoLog.i(wrapMessage("pause(" + i + SmallTailInfo.EMOTION_SUFFIX));
        if (this.mKernelLayer == null) {
            return;
        }
        abandonAudioFocus();
        getControlEventTrigger().pause(i);
        getInternalSyncControlEventTrigger().pause();
        getStatDispatcher().pause();
        getStatEventTrigger().onPlayerPause();
    }

    @PublicMethod
    public void setMuteMode(boolean z) {
        BdVideoLog.i(wrapMessage("setMuteMode(" + z + SmallTailInfo.EMOTION_SUFFIX));
        this.mIsMute = z;
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer != null) {
            baseKernelLayer.mute(z);
        }
        if (z) {
            abandonAudioFocus();
        } else if (isPlaying()) {
            requestAudioFocus();
        }
    }

    public String wrapMessage(@NonNull String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(this.mKey)) {
            str2 = "Player@" + System.identityHashCode(this);
        } else {
            str2 = this.mKey;
        }
        sb.append(str2);
        sb.append("=>");
        sb.append(str);
        return sb.toString();
    }

    @PublicMethod
    public void attachToContainer(@NonNull ViewGroup viewGroup, boolean z) {
        detachFromContainer(z);
        BdVideoLog.i(wrapMessage("attachToContainer(" + System.identityHashCode(viewGroup) + StringUtil.ARRAY_ELEMENT_SEPARATOR + z + SmallTailInfo.EMOTION_SUFFIX));
        this.mPlayerContainer = viewGroup;
        viewGroup.addView(this.mLayerContainer, this.mContainerLayoutParams);
        getPlayerEventTrigger().onPlayerAttach();
    }

    @PublicMethod
    public void detachFromContainer(boolean z) {
        if (this.mLayerContainer.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) this.mLayerContainer.getParent();
            viewGroup.removeView(this.mLayerContainer);
            BdVideoLog.i(wrapMessage("detachFromContainer(" + z + "), parent = " + System.identityHashCode(viewGroup)));
            if (z) {
                this.mLayerContainer.onContainerDetach();
                getPlayerEventTrigger().onPlayerDetach();
            }
            this.mPlayerContainer = null;
        }
    }

    @PublicMethod
    public void goBackOrForeground(boolean z) {
        BdVideoLog.i(wrapMessage("goBackOrForeground(" + z + SmallTailInfo.EMOTION_SUFFIX));
        this.mIsForeground = z;
        getStatDispatcher().goBackOrForeground(z, getLoopCount());
        getStatEventTrigger().onPlayerBackOrForeground(z);
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), z);
        getPlayerEventTrigger().goBackOrForeground(z);
        getPlayerCallbackManager().onGoBackOrForeground(z);
    }

    @PublicMethod
    public void resumePlayer(boolean z) {
        BdVideoLog.i(wrapMessage("resumePlayer(" + z + SmallTailInfo.EMOTION_SUFFIX));
        BaseKernelLayer baseKernelLayer = this.mKernelLayer;
        if (baseKernelLayer == null) {
            return;
        }
        if (z) {
            VideoTask videoTask = this.mVideoTask;
            videoTask.position = 0;
            videoTask.duration = 0;
            videoTask.positionMs = 0;
        } else {
            this.mVideoTask.position = baseKernelLayer.getPosition();
            this.mVideoTask.duration = this.mKernelLayer.getDuration();
            this.mVideoTask.positionMs = this.mKernelLayer.getPositionMs();
        }
        if (isPause()) {
            resume();
        } else {
            start();
        }
    }

    @PublicMethod
    public void doPlay() {
        BdVideoLog.i(wrapMessage("doPlay(), status = " + getStatus()));
        if (this.mKernelLayer != null && !isPause()) {
            if (!isPlayerMute()) {
                requestAudioFocus();
            }
            VideoSystemHelper.setKeepScreenOnOff(getActivity(), true);
            getControlEventTrigger().start();
            getInternalSyncControlEventTrigger().start();
            BdVideoLog.i(wrapMessage("doPlay, url = " + getVideoUrl()));
            getStatDispatcher().start();
            getStatEventTrigger().onPlayerStart();
        }
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onError(int i, int i2, Object obj) {
        getPlayerEventTrigger().onError(i, i2, obj);
        getStatDispatcher().onError(i, i2, obj);
        getStatEventTrigger().onError(i, i2, obj);
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
        return true;
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onInfo(int i, int i2, Object obj) {
        String str;
        getPlayerEventTrigger().onInfo(i, i2, obj);
        IPlayerStatisticsDispatcher statDispatcher = getStatDispatcher();
        if (obj != null) {
            str = obj.toString();
        } else {
            str = "";
        }
        statDispatcher.onInfo(i, i2, str);
        getStatEventTrigger().onInfo(i, i2, obj);
        return false;
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        getPlayerEventTrigger().onMediaSourceChanged(i, i2, obj);
        return true;
    }

    public void setStageInfo(String str, String str2, String str3) {
        BdVideoLog.i(wrapMessage("setStageInfo(" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str3 + SmallTailInfo.EMOTION_SUFFIX));
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        getPlayerEventTrigger().onVideoSizeChanged(i, i2, i3, i4);
    }

    @PublicMethod
    public void release() {
        BdVideoLog.i(wrapMessage("release()"));
        getStatDispatcher().stop(getLoopCount());
        getStatEventTrigger().onPlayerStop(getLoopCount());
        getStatDispatcher().release();
        releaseKernelLayer();
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
        getPlayerCallbackManager().release();
        abandonAudioFocus();
        releaseTrigger();
        this.mPluginManager.release();
        this.mLayerContainer.release();
        detachFromContainer(false);
        releaseMessenger();
        this.mPlayerContainer = null;
    }

    public void requestAudioFocus() {
        if (this.mHasAudioFocus) {
            return;
        }
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) getAppContext().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            if (this.mAudioFocusListener == null) {
                this.mAudioFocusListener = new AudioFocusChangedListener();
            }
            boolean z = true;
            if (this.mAudioManager.requestAudioFocus(this.mAudioFocusListener, 3, 2) != 1) {
                z = false;
            }
            this.mHasAudioFocus = z;
            BdVideoLog.i(wrapMessage("requestAudioFocus()"));
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void resume() {
        BdVideoLog.i(wrapMessage("resume()"));
        if (this.mKernelLayer != null && isPause()) {
            if (!isPlayerMute()) {
                requestAudioFocus();
            }
            getControlEventTrigger().resume();
            getInternalSyncControlEventTrigger().resume();
            getStatDispatcher().resume();
            getStatEventTrigger().onPlayerResume();
        }
    }

    @Override // com.baidu.searchbox.player.IBVideoPlayer
    @PublicMethod
    public void stop() {
        BdVideoLog.i(wrapMessage("stop()"));
        if (this.mKernelLayer == null) {
            return;
        }
        abandonAudioFocus();
        getStatDispatcher().stop(getLoopCount());
        getStatEventTrigger().onPlayerStop(getLoopCount());
        getControlEventTrigger().stop();
        getInternalSyncControlEventTrigger().stop();
        VideoSystemHelper.setKeepScreenOnOff(getActivity(), false);
    }
}
