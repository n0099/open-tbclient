package com.baidu.ala.livePlayer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.ala.helper.AlaLiveBaseInfo;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.helper.AlaLiveStatConfig;
import com.baidu.ala.helper.AlaLiveStreamCmdInfo;
import com.baidu.ala.helper.AlaLiveUtilHelper;
import com.baidu.ala.helper.AlaVideoFrame;
import com.baidu.ala.livePlayer.AlaVideoPlayer;
import com.baidu.ala.ndk.AlaNDKPlayerAdapter;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.coremedia.iso.boxes.PerformerBox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class AlaLivePlayer extends LinearLayout {
    private static final int JNI_NOTIFY_MESSAGE_NO_VIDEO_FRAME = 2;
    private static final int JNI_NOTIFY_MESSAGE_RENDER_VIDEO_FRAME = 1;
    private static final int JNI_NOTIFY_MESSAGE_STREAM_CMD = 3;
    public static final int LINE_INDEX1 = 1;
    public static final int LINE_INDEX2 = 2;
    private static final int MESSAGE_KEY_BUFFERING_EVENT = 2;
    private static final int MESSAGE_KEY_DEBUG_INFO = 1;
    private static final int MESSAGE_KEY_FIRST_VIDEO_FRAME = 0;
    private static final int MESSAGE_KEY_FRAME_DELAY_EVENT = 3;
    private static final int MESSAGE_KEY_STREAM_FAST_OPEN = 6;
    private static final int MESSAGE_KEY_STREAM_STATE_CHANGE = 4;
    private static final int MESSAGE_KEY_STREAM_STUCK = 5;
    private static final int NATIVE_CONN_BREAKED_STATE = 0;
    private static final int NATIVE_CONN_CONNECTED_STATE = 1;
    public static final int PLAYER_VIDEO_MODEL_FILL = 1;
    public static final int PLAYER_VIDEO_MODEL_FIT = 2;
    private static final int PULL_ONCE_PCM_LENGTH = 4096;
    private Activity mActivity;
    private volatile boolean mAudioMute;
    private AlaAudioPlayer mAudioPlayer;
    private ArrayList<Runnable> mEventQueue;
    private ExecutorService mExecService;
    private volatile boolean mIsAudioThreadRun;
    private volatile boolean mIsDestroy;
    private volatile boolean mIsNetworkChangedListenerReg;
    private volatile boolean mIsPlaySound;
    private volatile boolean mIsPlayerPause;
    private volatile boolean mIsSwitchForeBackListenerReg;
    private volatile AlaNDKPlayerAdapter mNDKAdapter;
    private volatile boolean mNativeFunctionsRegisted;
    private BdAlertDialog mNetChangedDialog;
    private CustomMessageListener mNetworkChangedListener;
    private BdPageContext<?> mPageContext;
    private byte[] mPcmBytes;
    private AlaLivePlayerCallback mPlayerCallback;
    private volatile Handler mPlayerHandler;
    private Map<Integer, AlaVideoPlayer2> mPlayersMap;
    private CallStateReceiver mReceiver;
    private AlaLiveStatConfig mStatConfig;
    private CustomMessageListener mSwitchForeBackListener;
    private boolean manualReconnect;

    /* loaded from: classes6.dex */
    public static class AlaLivePlayerConf {
        public int index;
        public LinearLayout.LayoutParams param;
        public String url;
    }

    public static AlaLivePlayer createLivePlayer(Context context) {
        if (AlaLivePlayerUtil.isSupported(context) && AlaLiveUtilHelper.loadPluginLibrary("ala")) {
            return new AlaLivePlayer(context);
        }
        AlaLivePlayerUtil.log(BdStatsConstant.StatsType.ERROR, "notsupportGL");
        return null;
    }

    private AlaLivePlayer(Context context) {
        super(context);
        this.mIsPlayerPause = false;
        this.mIsAudioThreadRun = false;
        this.mIsPlaySound = true;
        this.mIsDestroy = false;
        this.mAudioPlayer = null;
        this.mPlayersMap = new ConcurrentHashMap();
        this.mPcmBytes = new byte[4096];
        this.mExecService = Executors.newFixedThreadPool(1);
        this.mEventQueue = new ArrayList<>();
        this.mNativeFunctionsRegisted = false;
        this.mPlayerHandler = null;
        this.mAudioMute = false;
        this.mActivity = null;
        this.mPageContext = null;
        this.mStatConfig = new AlaLiveStatConfig();
        this.mNetChangedDialog = null;
        this.manualReconnect = false;
        this.mIsSwitchForeBackListenerReg = false;
        this.mSwitchForeBackListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        if (AlaLivePlayer.this.mNDKAdapter.getNativeObject() != 0) {
                            AlaLivePlayer.this.mNDKAdapter.enterBackground();
                        }
                        for (Map.Entry entry : AlaLivePlayer.this.mPlayersMap.entrySet()) {
                            AlaVideoPlayer2 alaVideoPlayer2 = (AlaVideoPlayer2) entry.getValue();
                            if (alaVideoPlayer2 != null) {
                                alaVideoPlayer2.getPlayerSurface().runInBackground();
                            }
                        }
                        return;
                    }
                    if (AlaLivePlayer.this.mNDKAdapter.getNativeObject() != 0) {
                        AlaLivePlayer.this.mNDKAdapter.enterForeground();
                    }
                    for (Map.Entry entry2 : AlaLivePlayer.this.mPlayersMap.entrySet()) {
                        AlaVideoPlayer2 alaVideoPlayer22 = (AlaVideoPlayer2) entry2.getValue();
                        if (alaVideoPlayer22 != null) {
                            alaVideoPlayer22.getPlayerSurface().runInForeground();
                        }
                    }
                }
            }
        };
        this.mIsNetworkChangedListenerReg = false;
        this.mNetworkChangedListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && AlaLivePlayer.this.mNDKAdapter.getNativeObject() != 0) {
                    NetWorkChangedMessage netWorkChangedMessage = (NetWorkChangedMessage) customResponsedMessage;
                    boolean isNetWorkAvailable = BdNetTypeUtil.isNetWorkAvailable();
                    if (!isNetWorkAvailable) {
                        AlaLivePlayer.this.mNDKAdapter.networkChangedNotifyNative(0);
                    } else if (netWorkChangedMessage.mCurNetState == 1) {
                        AlaLivePlayer.this.mNDKAdapter.networkChangedNotifyNative(1);
                    } else {
                        AlaLivePlayer.this.mNDKAdapter.networkChangedNotifyNative(2);
                    }
                    if (isNetWorkAvailable) {
                        for (Map.Entry entry : AlaLivePlayer.this.mPlayersMap.entrySet()) {
                            AlaVideoPlayer2 alaVideoPlayer2 = (AlaVideoPlayer2) entry.getValue();
                            if (alaVideoPlayer2 != null && alaVideoPlayer2.getPlayerData().mPlayUrl != null) {
                                AlaLivePlayer.this.restart(alaVideoPlayer2.getPlayerData().mIndex, alaVideoPlayer2.getPlayerData().mPlayUrl);
                            }
                        }
                    }
                }
            }
        };
        if (context instanceof Activity) {
            this.mActivity = (Activity) context;
        }
        setOrientation(0);
        this.mReceiver = new CallStateReceiver();
        if (this.mActivity != null) {
            this.mReceiver.register(this.mActivity);
        }
        this.mNDKAdapter = new AlaNDKPlayerAdapter();
        this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.1
            @Override // java.lang.Runnable
            public void run() {
                Thread.currentThread().setName("player_exec_service_thread");
            }
        });
        if (this.mPlayerHandler == null) {
            this.mPlayerHandler = new PlayerHandler();
        }
    }

    public void setPageContext(BdPageContext<?> bdPageContext) {
        this.mPageContext = bdPageContext;
    }

    private void createPlayerView(int i, LinearLayout.LayoutParams layoutParams) {
        AlaVideoPlayer2 alaVideoPlayer2;
        if (this.mActivity == null) {
            BdLog.i("createPlayerView mActivity = null index = " + i);
            return;
        }
        if (this.mPlayersMap.containsKey(Integer.valueOf(i))) {
            alaVideoPlayer2 = this.mPlayersMap.get(Integer.valueOf(i));
            if (alaVideoPlayer2.getPlayerSurface().getParent() != null) {
                ((ViewGroup) alaVideoPlayer2.getPlayerSurface().getParent()).removeView(alaVideoPlayer2.getPlayerSurface());
            }
            alaVideoPlayer2.getPlayerSurface().setLayoutParams(layoutParams);
            alaVideoPlayer2.getPlayerData().mFastOpen = 0;
            alaVideoPlayer2.getPlayerData().mHasAvailableVideoFrame = false;
            alaVideoPlayer2.getPlayerData().mPlayUrl = null;
            alaVideoPlayer2.getPlayerData().mLastStreamTime = 0L;
            alaVideoPlayer2.getPlayerData().mSurfaceCreated = false;
            alaVideoPlayer2.getPlayerData().mNativeVideoFrame = null;
        } else {
            alaVideoPlayer2 = null;
        }
        if (alaVideoPlayer2 == null) {
            if (i == 1) {
                alaVideoPlayer2 = new AlaVideoPlayer2(this.mActivity, 1, layoutParams);
            } else if (i == 2) {
                alaVideoPlayer2 = new AlaVideoPlayer2(this.mActivity, 2, layoutParams);
            }
        }
        if (alaVideoPlayer2 == null) {
            BdLog.e("createPlayerView index " + i);
        } else {
            this.mPlayersMap.put(Integer.valueOf(i), alaVideoPlayer2);
        }
    }

    private void removePlayerView(int i) {
        AlaVideoPlayer videoPlayer = getVideoPlayer(i);
        if (videoPlayer != null) {
            removeView(videoPlayer);
            videoPlayer.release();
        }
    }

    public AlaVideoPlayer getVideoPlayer(int i) {
        if (this.mPlayersMap.containsKey(Integer.valueOf(i))) {
            return this.mPlayersMap.get(Integer.valueOf(i)).getPlayerSurface();
        }
        return null;
    }

    private boolean getVideoPlayerUrlsEmpty() {
        for (Map.Entry<Integer, AlaVideoPlayer2> entry : this.mPlayersMap.entrySet()) {
            if (entry.getValue() != null && TextUtils.isEmpty(getVideoPlayer(entry.getKey().intValue()).getPlayerData().mPlayUrl)) {
                return true;
            }
        }
        return false;
    }

    private static boolean useOpenGL2(Object obj) {
        return AlaLivePlayer.class.isInstance(obj);
    }

    private synchronized void registerNativeObject(long j) {
        if (this.mNDKAdapter.getNativeObject() != 0) {
            BdLog.e("registerNativeObject native object Leak !!");
        }
        this.mNDKAdapter.setNativeObject(j);
        this.mNativeFunctionsRegisted = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void deRegisterNativeObject() {
        boolean z;
        Iterator<Map.Entry<Integer, AlaVideoPlayer2>> it = this.mPlayersMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            } else if (it.next().getValue().getPlayerData().mIsRun == 1) {
                z = false;
                break;
            }
        }
        if (z) {
            this.mNativeFunctionsRegisted = false;
            this.mNDKAdapter.setNativeObject(0L);
        }
    }

    private void jniNotifyMessage(final int i, int i2, final String str) {
        if (getVideoPlayer(i) == null) {
            BdLog.i("No VideoPlayer with Index " + i);
        } else if (this.mIsDestroy) {
            BdLog.i("VideoPlayer destroyed" + i);
        } else if (getVideoPlayer(i).getPlayerData().mIsRun == 1) {
            switch (i2) {
                case 1:
                    if (!getVideoPlayer(i).getPlayerData().mHasAvailableVideoFrame && this.mPlayerHandler != null) {
                        getVideoPlayer(i).getPlayerData().mHasAvailableVideoFrame = true;
                        this.mPlayerHandler.obtainMessage(0, i, 0, str).sendToTarget();
                    }
                    getVideoPlayer(i).getPlayerData().mLastStreamTime = System.currentTimeMillis();
                    return;
                case 2:
                    if (System.currentTimeMillis() - getVideoPlayer(i).getPlayerData().mLastStreamTime > 5000 && this.mPlayerHandler != null) {
                        Message obtainMessage = this.mPlayerHandler.obtainMessage();
                        MessageBufferEventData messageBufferEventData = new MessageBufferEventData();
                        messageBufferEventData.index = i;
                        messageBufferEventData.type = 2;
                        messageBufferEventData.startTime = 0;
                        messageBufferEventData.duration = 0;
                        obtainMessage.what = 2;
                        obtainMessage.obj = messageBufferEventData;
                        this.mPlayerHandler.sendMessage(obtainMessage);
                        getVideoPlayer(i).getPlayerData().mLastStreamTime = System.currentTimeMillis();
                    }
                    BdLog.i("NO Video Frame to Render.");
                    return;
                case 3:
                    synchronized (this.mEventQueue) {
                        this.mEventQueue.add(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaLivePlayer.this.parseStreamCmd(i, str);
                            }
                        });
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseStreamCmd(int i, String str) {
        int i2 = 0;
        if (!TextUtils.isEmpty(str) && getVideoPlayer(i) != null && this.mPlayerHandler != null) {
            try {
                String[] split = str.split("\\|");
                while (split != null) {
                    if (i2 < split.length) {
                        String[] split2 = split[i2].split("\\^");
                        if (split2.length > 2) {
                            int parseInt = Integer.parseInt(split2[0]);
                            if (parseInt == 1) {
                                long parseLong = Long.parseLong(split2[1]);
                                Message obtainMessage = this.mPlayerHandler.obtainMessage();
                                obtainMessage.what = 3;
                                obtainMessage.obj = Integer.valueOf(i);
                                obtainMessage.arg1 = (int) (System.currentTimeMillis() - parseLong);
                                obtainMessage.arg2 = Integer.parseInt(split2[2]);
                                this.mPlayerHandler.sendMessage(obtainMessage);
                            } else if (parseInt == 2) {
                                if (split2.length >= 5) {
                                    AlaLiveStreamCmdInfo alaLiveStreamCmdInfo = new AlaLiveStreamCmdInfo();
                                    alaLiveStreamCmdInfo.fillByStatus(split2[1], split2[2], split2[4], split2[3]);
                                    if (getVideoPlayer(i) != null) {
                                        getVideoPlayer(i).getPlayerData().mCmdInfo = alaLiveStreamCmdInfo;
                                    }
                                }
                            }
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public int start2(List<AlaLivePlayerConf> list) {
        if (list.size() == 0) {
            BdLog.e("AlaLivePlayer.start2  list = null");
            return -1;
        }
        for (Map.Entry<Integer, AlaVideoPlayer2> entry : this.mPlayersMap.entrySet()) {
            if (entry.getValue() != null) {
                removePlayerView(entry.getKey().intValue());
                stopNativePlayer(entry.getKey().intValue());
            }
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            removeAllViews();
        } else {
            post(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    AlaLivePlayer.this.removeAllViews();
                }
            });
        }
        for (int i = 0; i < list.size(); i++) {
            createPlayerView(list.get(i).index, list.get(i).param);
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            final AlaLivePlayerConf alaLivePlayerConf = list.get(i2);
            if (alaLivePlayerConf == null || alaLivePlayerConf.index == 0) {
                BdLog.e("AlaLivePlayer.start2  conf.index = 0");
                return -1;
            }
            if (getVideoPlayer(alaLivePlayerConf.index) != null) {
                getVideoPlayer(alaLivePlayerConf.index).getPlayerData().mPlayUrl = alaLivePlayerConf.url;
            }
            synchronized (this.mEventQueue) {
                this.mEventQueue.add(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.4
                    final int index;
                    final String url;

                    {
                        this.index = alaLivePlayerConf.index;
                        this.url = alaLivePlayerConf.url;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (!AlaLivePlayer.this.mIsDestroy) {
                            AlaLivePlayer.this.start(this.index, this.url);
                        }
                    }
                });
            }
        }
        this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.5
            @Override // java.lang.Runnable
            public void run() {
                AlaLivePlayer.this.runEventQueue();
            }
        });
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int start(final int i, String str) {
        if (this.mIsDestroy) {
            return -1;
        }
        if (getVideoPlayer(i) == null) {
            BdLog.e("AlaLivePlayer.start  " + i + " url " + str);
            return -1;
        }
        getVideoPlayer(i).getPlayerData().mStartBaseInfo.mStreamType = AlaLiveBaseInfo.STREAM_TYPE_RECV;
        if (getVideoPlayer(i).getPlayerData().mIsRun == 1) {
            return 0;
        }
        getVideoPlayer(i).getPlayerData().mIsRun = 1;
        getVideoPlayer(i).getPlayerData().mPlayUrl = str;
        if (this.mNDKAdapter.getNativeObject() == 0) {
            int initPlayerNative = this.mNDKAdapter.initPlayerNative(this);
            if (initPlayerNative != 0) {
                BdLog.e("initNative error. errcode is " + initPlayerNative);
                AlaLivePlayerUtil.log(BdStatsConstant.StatsType.ERROR, "initnative", "errcode", Integer.valueOf(initPlayerNative));
                stop();
                return -1;
            }
            this.mNDKAdapter.setDebugMonitor(i, true, 5);
        }
        if (this.mNDKAdapter.getNativeObject() == 0) {
            stop();
            return -1;
        } else if (getVideoPlayer(i) == null || getVideoPlayer(i).getPlayerData() == null) {
            stop();
            return -1;
        } else if (this.mIsDestroy) {
            stop();
            return -1;
        } else {
            this.mPlayerHandler.post(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaLivePlayer.this.getVideoPlayer(i) != null && AlaLivePlayer.this.getVideoPlayer(i).getParent() != null) {
                        ((ViewGroup) AlaLivePlayer.this.getVideoPlayer(i).getParent()).removeView(AlaLivePlayer.this.getVideoPlayer(i));
                    }
                    if (AlaLivePlayer.this.getVideoPlayer(i) != null) {
                        AlaLivePlayer.this.addView(AlaLivePlayer.this.getVideoPlayer(i));
                    }
                }
            });
            this.mNDKAdapter.syncStatConfig(this.mStatConfig.mSavePath, this.mStatConfig.mUploadUrl, this.mStatConfig.mEnable);
            int startPlayerNative = this.mNDKAdapter.startPlayerNative(getVideoPlayer(i).getPlayerData().mPlayUrl, i, getNetworkState(), getVideoPlayer(i).getPlayerData().mStartBaseInfo.toJsonString());
            if (startPlayerNative != 0) {
                if (this.mPlayerHandler != null) {
                    this.mPlayerHandler.sendMessage(this.mPlayerHandler.obtainMessage(4, i, 1));
                }
                BdLog.e("startNative error:" + startPlayerNative);
                AlaLivePlayerUtil.log(BdStatsConstant.StatsType.ERROR, "startnative", "errcode", Integer.valueOf(startPlayerNative), "curnet", BdNetTypeUtil.netTypeNameInLowerCase(), "pullip", getPullStreamIp(i));
            } else if (this.mPlayerHandler != null) {
                this.mPlayerHandler.sendMessage(this.mPlayerHandler.obtainMessage(4, i, 0));
            }
            if (getVideoPlayer(i) == null || getVideoPlayer(i).getPlayerData() == null) {
                stop();
                return -1;
            }
            getVideoPlayer(i).getPlayerData().mLastStreamTime = System.currentTimeMillis();
            if (startPlayerNative == 0) {
                startAudioDevics();
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int restart(int i, String str) {
        if (getVideoPlayer(i) == null) {
            return -1;
        }
        getVideoPlayer(i).getPlayerData().mStartBaseInfo.mStreamType = AlaLiveBaseInfo.STREAM_TYPE_RECV;
        if (getVideoPlayer(i).getPlayerData().mIsRun != 1) {
            return 0;
        }
        getVideoPlayer(i).getPlayerData().mIsRun = 1;
        getVideoPlayer(i).getPlayerData().mPlayUrl = str;
        if (this.mNDKAdapter.getNativeObject() == 0) {
            int initPlayerNative = this.mNDKAdapter.initPlayerNative(this);
            if (initPlayerNative != 0) {
                BdLog.e("initNative error. errcode is " + initPlayerNative);
                AlaLivePlayerUtil.log(BdStatsConstant.StatsType.ERROR, "initnative", "errcode", Integer.valueOf(initPlayerNative));
                stop();
                return -1;
            }
            this.mNDKAdapter.setDebugMonitor(i, true, 5);
        }
        if (this.mNDKAdapter.getNativeObject() == 0) {
            stop();
            return -1;
        }
        int restartNative = this.mNDKAdapter.restartNative(i, getNetworkState());
        if (restartNative != 0) {
            BdLog.e("restartNative error:" + restartNative);
            AlaLivePlayerUtil.log(BdStatsConstant.StatsType.ERROR, "restartnative", "errcode", Integer.valueOf(restartNative), "curnet", BdNetTypeUtil.netTypeNameInLowerCase(), "pullip", getPullStreamIp(i));
        }
        getVideoPlayer(i).getPlayerData().mLastStreamTime = System.currentTimeMillis();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean runEventQueue() {
        boolean z = false;
        while (true) {
            boolean z2 = z;
            Runnable runnable = null;
            synchronized (this.mEventQueue) {
                if (!this.mEventQueue.isEmpty() && !this.mEventQueue.isEmpty()) {
                    runnable = this.mEventQueue.remove(0);
                }
            }
            if (runnable != null) {
                runnable.run();
                z = !z2 ? true : z2;
            } else {
                return z2;
            }
        }
    }

    private void startAudioDevics() {
        if (!this.mIsAudioThreadRun) {
            this.mIsAudioThreadRun = true;
            this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.7
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaLivePlayer.this.mAudioPlayer != null) {
                        AlaLivePlayer.this.mAudioPlayer.stopAndRelease();
                    }
                    AlaLivePlayer.this.mAudioPlayer = new AlaAudioPlayer();
                    while (AlaLivePlayer.this.mIsAudioThreadRun) {
                        if (AlaLivePlayer.this.mNDKAdapter.getNativeObject() == 0 || AlaLivePlayer.this.mExecService.isShutdown()) {
                            BdLog.e("audio device will shutdown !!");
                            break;
                        } else if (!AlaLivePlayer.this.runEventQueue()) {
                            if (!AlaLivePlayer.this.mIsPlayerPause) {
                                int audioPCMNative = AlaLivePlayer.this.mNDKAdapter.getAudioPCMNative(AlaLivePlayer.this.mPcmBytes);
                                if (audioPCMNative <= 0) {
                                    Arrays.fill(AlaLivePlayer.this.mPcmBytes, (byte) 0);
                                    audioPCMNative = 2048;
                                }
                                if (AlaLivePlayer.this.mAudioPlayer != null && AlaLivePlayer.this.mIsPlaySound) {
                                    if (AlaLivePlayer.this.mAudioMute) {
                                        Arrays.fill(AlaLivePlayer.this.mPcmBytes, (byte) 0);
                                        audioPCMNative = 2048;
                                    }
                                    AlaLivePlayer.this.mAudioPlayer.writeData(AlaLivePlayer.this.mPcmBytes, 0, audioPCMNative);
                                }
                            } else {
                                try {
                                    Thread.sleep(40L);
                                } catch (Exception e) {
                                    e.fillInStackTrace();
                                }
                            }
                        }
                    }
                    AlaLivePlayer.this.mIsAudioThreadRun = false;
                    AlaLivePlayer.this.runEventQueue();
                    AlaLivePlayer.this.mAudioPlayer.stopAndRelease();
                    AlaLivePlayer.this.mAudioPlayer = null;
                }
            });
        }
    }

    private void stopNativePlayer(final int i) {
        synchronized (this.mEventQueue) {
            this.mEventQueue.add(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.8
                @Override // java.lang.Runnable
                public void run() {
                    int stopNative = AlaLivePlayer.this.mNDKAdapter.stopNative(i);
                    if (stopNative != 0) {
                        BdLog.e("stopNativePlayer error:" + stopNative);
                        AlaLivePlayerUtil.log(BdStatsConstant.StatsType.ERROR, "stopNativePlayer", "errcode", Integer.valueOf(stopNative));
                    }
                    if (AlaLivePlayer.this.getVideoPlayer(i) != null && AlaLivePlayer.this.getVideoPlayer(i).getPlayerData() != null) {
                        AlaLivePlayer.this.getVideoPlayer(i).getPlayerData().mIsRun = 3;
                    }
                    AlaLivePlayer.this.deRegisterNativeObject();
                }
            });
        }
        this.mExecService.submit(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.9
            @Override // java.lang.Runnable
            public void run() {
                AlaLivePlayer.this.runEventQueue();
            }
        });
    }

    public void setStatConfigBeforeStart(String str, String str2, int i) {
        this.mStatConfig.mEnable = i;
        this.mStatConfig.mSavePath = str;
        this.mStatConfig.mUploadUrl = str2;
    }

    public void setStartInfo(final int i, final String str, final String str2, final String str3, final String str4, final int i2, final String str5) {
        synchronized (this.mEventQueue) {
            this.mEventQueue.add(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.10
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaLivePlayer.this.getVideoPlayer(i) != null) {
                        AlaLivePlayer.this.getVideoPlayer(i).getPlayerData().mStartBaseInfo.mLiveId = str;
                        AlaLivePlayer.this.getVideoPlayer(i).getPlayerData().mStartBaseInfo.mSessionId = str2;
                        AlaLivePlayer.this.getVideoPlayer(i).getPlayerData().mStartBaseInfo.mClientIp = str3;
                        AlaLivePlayer.this.getVideoPlayer(i).getPlayerData().mStartBaseInfo.mStreamLine = str4;
                        AlaLivePlayer.this.getVideoPlayer(i).getPlayerData().mStartBaseInfo.mSessionLine = i2;
                        AlaLivePlayer.this.getVideoPlayer(i).getPlayerData().mStartBaseInfo.mSubAppType = str5;
                    }
                }
            });
        }
    }

    public void setConfigBeforeStop(String str, String str2, String str3) {
        if (this.mNDKAdapter.getNativeObject() != 0) {
            for (Map.Entry<Integer, AlaVideoPlayer2> entry : this.mPlayersMap.entrySet()) {
                if (entry.getValue() != null) {
                    this.mNDKAdapter.sendNativeStatAppData(entry.getKey().intValue(), PerformerBox.TYPE, str, 0);
                    this.mNDKAdapter.sendNativeStatAppData(entry.getKey().intValue(), "kStatFirstFrame", str2, 0);
                    this.mNDKAdapter.sendNativeStatAppData(entry.getKey().intValue(), "kStatDelayOff", str3, 0);
                }
            }
        }
    }

    public void setRoomInfo(int i, String str) {
        if (this.mNDKAdapter.getNativeObject() != 0) {
            this.mNDKAdapter.sendNativeStatAppData(i, "roomInfo", str, 0);
        }
    }

    public void pause() {
        this.mIsPlayerPause = true;
        if (this.mNDKAdapter.getNativeObject() != 0) {
            this.mEventQueue.add(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.11
                @Override // java.lang.Runnable
                public void run() {
                    for (Map.Entry entry : AlaLivePlayer.this.mPlayersMap.entrySet()) {
                        if (entry.getValue() != null) {
                            AlaLivePlayer.this.mNDKAdapter.setPause(((Integer) entry.getKey()).intValue(), true);
                        }
                    }
                }
            });
        }
    }

    public void resume() {
        this.mIsPlayerPause = false;
        if (this.mNDKAdapter.getNativeObject() != 0) {
            this.mEventQueue.add(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.12
                @Override // java.lang.Runnable
                public void run() {
                    for (Map.Entry entry : AlaLivePlayer.this.mPlayersMap.entrySet()) {
                        if (entry.getValue() != null) {
                            AlaLivePlayer.this.mNDKAdapter.setPause(((Integer) entry.getKey()).intValue(), false);
                        }
                    }
                }
            });
        }
    }

    public void stop() {
        this.mIsAudioThreadRun = false;
        for (Map.Entry<Integer, AlaVideoPlayer2> entry : this.mPlayersMap.entrySet()) {
            AlaVideoPlayer2 value = entry.getValue();
            if (value != null) {
                value.getPlayerData().mHasAvailableVideoFrame = false;
                value.getPlayerData().mPlayUrl = null;
                stopNativePlayer(entry.getKey().intValue());
            }
        }
    }

    public void setAudioMute(boolean z) {
        this.mAudioMute = z;
    }

    public String getPullStreamIp(int i) {
        if (this.mNDKAdapter.getNativeObject() == 0 && getVideoPlayer(i) == null) {
            return null;
        }
        return this.mNDKAdapter.getPullStreamIpNative(i);
    }

    private void removePlayer(AlaVideoPlayer2 alaVideoPlayer2) {
        removeView(alaVideoPlayer2.getPlayerSurface());
        alaVideoPlayer2.getPlayerSurface().release();
    }

    private int getNetworkState() {
        int netType = BdNetTypeUtil.netType();
        if (netType > 2) {
            return 2;
        }
        return netType;
    }

    private void nativeOnFastOpen(int i, int i2) {
        if (getVideoPlayer(i) != null) {
            getVideoPlayer(i).getPlayerData().mFastOpen = i2;
            Message obtainMessage = this.mPlayerHandler.obtainMessage(6);
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            this.mPlayerHandler.sendMessage(obtainMessage);
        }
    }

    private void nativeOnStreamStuck(int i, int i2, int i3) {
        MessageStreamStuckData messageStreamStuckData = new MessageStreamStuckData();
        messageStreamStuckData.index = i;
        messageStreamStuckData.type = i2;
        messageStreamStuckData.ms = i3;
        Message obtainMessage = this.mPlayerHandler.obtainMessage(5);
        obtainMessage.obj = messageStreamStuckData;
        this.mPlayerHandler.sendMessage(obtainMessage);
    }

    private void rtmpResponsedCallback(int i, int i2, int i3, String str) {
        if (i2 == 0) {
            if (this.mPlayerHandler != null) {
                this.mPlayerHandler.sendMessage(this.mPlayerHandler.obtainMessage(4, i, 1));
            }
            AlaLivePlayerUtil.log(BdStatsConstant.StatsType.ERROR, "startnative", "curnet", BdNetTypeUtil.netTypeNameInLowerCase(), "pullip", getPullStreamIp(i));
        } else if (i2 == 1 && this.mPlayerHandler != null) {
            this.mPlayerHandler.sendMessage(this.mPlayerHandler.obtainMessage(4, i, 0));
        }
        if (getVideoPlayer(i) != null && getVideoPlayer(i).getPlayerData().mIsRun == 1 && !this.manualReconnect && i2 == 0 && getNetworkState() > 0) {
            for (Map.Entry<Integer, AlaVideoPlayer2> entry : this.mPlayersMap.entrySet()) {
                AlaVideoPlayer2 value = entry.getValue();
                if (value != null && value.getPlayerData().mPlayUrl != null && value.getPlayerData().mPlayUrl.length() > 0) {
                    restart(entry.getKey().intValue(), getVideoPlayer(entry.getKey().intValue()).getPlayerData().mPlayUrl);
                }
            }
            AlaLivePlayerUtil.log(BdStatsConstant.StatsType.ERROR, "restart", TiebaInitialize.LogFields.REASON, "streamclose");
        }
    }

    public void destroy() {
        this.mIsDestroy = true;
        this.mPlayerCallback = null;
        if (this.mReceiver != null) {
            this.mReceiver.unregister(this.mActivity);
            this.mReceiver = null;
        }
        if (this.mPlayerHandler != null) {
            this.mPlayerHandler.removeCallbacksAndMessages(null);
            this.mPlayerHandler = null;
        }
        runEventQueue();
        this.mExecService.shutdown();
        for (Map.Entry<Integer, AlaVideoPlayer2> entry : this.mPlayersMap.entrySet()) {
            AlaVideoPlayer2 value = entry.getValue();
            if (value != null) {
                removePlayerView(value.getPlayerData().mIndex);
            }
            this.mPlayersMap.remove(entry.getKey());
        }
        this.mActivity = null;
        this.mPageContext = null;
    }

    public String getPlayUrl(int i) {
        if (getVideoPlayer(i) == null) {
            return null;
        }
        return getVideoPlayer(i).getPlayerData().mPlayUrl;
    }

    private void rtmpDebugResponsedCallback(int i, AlaLiveDebugInfo alaLiveDebugInfo) {
        if (getVideoPlayer(i) != null && getVideoPlayer(i).getPlayerData().mLiveDebugInfo != null && alaLiveDebugInfo != null && this.mPlayerHandler != null) {
            Message obtainMessage = this.mPlayerHandler.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = i;
            obtainMessage.obj = new AlaLiveDebugInfo(alaLiveDebugInfo);
            this.mPlayerHandler.sendMessage(obtainMessage);
        }
    }

    /* loaded from: classes6.dex */
    public class AlaVideoPlayer2 implements AlaVideoPlayer.VideoPlayerCallback {
        private AlaVideoPlayer mPlayer;

        public AlaVideoPlayer2(Context context, int i, LinearLayout.LayoutParams layoutParams) {
            this.mPlayer = null;
            this.mPlayer = new AlaVideoPlayer(context, i);
            this.mPlayer.setLayoutParams(layoutParams);
            this.mPlayer.setPlayerCallback(this);
        }

        @Override // com.baidu.ala.livePlayer.AlaVideoPlayer.VideoPlayerCallback
        public void onSurfaceCreated(AlaVideoPlayer.SurfaceHolder surfaceHolder) {
            if (AlaLivePlayer.this.mNativeFunctionsRegisted) {
                if (AlaLivePlayer.this.mNDKAdapter.createSurfaceNative(this.mPlayer.getPlayerData().mIndex, surfaceHolder.getSurface()) != 0) {
                    this.mPlayer.getPlayerData().mSurfaceCreated = false;
                    return;
                } else {
                    this.mPlayer.getPlayerData().mSurfaceCreated = true;
                    return;
                }
            }
            this.mPlayer.getPlayerData().mSurfaceCreated = true;
        }

        @Override // com.baidu.ala.livePlayer.AlaVideoPlayer.VideoPlayerCallback
        public void onSurfaceChanged(AlaVideoPlayer.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (AlaLivePlayer.this.mNativeFunctionsRegisted) {
                AlaLivePlayer.this.mNDKAdapter.surfaceChangedNative(this.mPlayer.getPlayerData().mIndex, i2, i3, surfaceHolder.getSurface());
            }
        }

        @Override // com.baidu.ala.livePlayer.AlaVideoPlayer.VideoPlayerCallback
        public void onSurfaceDestroyed(AlaVideoPlayer.SurfaceHolder surfaceHolder) {
            this.mPlayer.getPlayerData().mSurfaceCreated = false;
        }

        @Override // com.baidu.ala.livePlayer.AlaVideoPlayer.VideoPlayerCallback
        public void onAttachedToWindow() {
            if (!AlaLivePlayer.this.mIsNetworkChangedListenerReg) {
                AlaLivePlayer.this.post(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.AlaVideoPlayer2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().registerListener(AlaLivePlayer.this.mNetworkChangedListener);
                    }
                });
                AlaLivePlayer.this.mIsNetworkChangedListenerReg = true;
            }
            if (!AlaLivePlayer.this.mIsSwitchForeBackListenerReg) {
                MessageManager.getInstance().registerListener(AlaLivePlayer.this.mSwitchForeBackListener);
                AlaLivePlayer.this.mIsSwitchForeBackListenerReg = true;
            }
        }

        @Override // com.baidu.ala.livePlayer.AlaVideoPlayer.VideoPlayerCallback
        public void onDetachedFromWindow() {
            if (AlaLivePlayer.this.mNetChangedDialog != null) {
                AlaLivePlayer.this.mNetChangedDialog.dismiss();
            }
            if (AlaLivePlayer.this.mIsNetworkChangedListenerReg) {
                AlaLivePlayer.this.post(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.AlaVideoPlayer2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().unRegisterListener(AlaLivePlayer.this.mNetworkChangedListener);
                    }
                });
                AlaLivePlayer.this.mIsNetworkChangedListenerReg = false;
            }
            if (AlaLivePlayer.this.mIsSwitchForeBackListenerReg) {
                MessageManager.getInstance().unRegisterListener(AlaLivePlayer.this.mSwitchForeBackListener);
                AlaLivePlayer.this.mIsSwitchForeBackListenerReg = false;
            }
            if (AlaLivePlayer.this.mPlayerHandler != null) {
                AlaLivePlayer.this.mPlayerHandler.removeMessages(0);
            }
            if (this.mPlayer != null) {
                this.mPlayer.getPlayerData().mHasAvailableVideoFrame = false;
            }
        }

        public AlaVideoPlayer getPlayerSurface() {
            return this.mPlayer;
        }

        public AlaLivePlayerData getPlayerData() {
            return this.mPlayer.getPlayerData();
        }
    }

    /* loaded from: classes6.dex */
    private class MessageStreamStuckData {
        public int index;
        public int ms;
        public int type;

        private MessageStreamStuckData() {
        }
    }

    /* loaded from: classes6.dex */
    private class MessageBufferEventData {
        public int duration;
        public int index;
        public int startTime;
        public int type;

        private MessageBufferEventData() {
        }
    }

    /* loaded from: classes6.dex */
    private class PlayerHandler extends Handler {
        public PlayerHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            int i2 = 0;
            switch (message.what) {
                case 0:
                    if (AlaLivePlayer.this.getVideoPlayer(message.arg1) != null && AlaLivePlayer.this.mPlayerCallback != null) {
                        if (message.obj == null || !(message.obj instanceof String)) {
                            AlaLivePlayer.this.mPlayerCallback.onFirstFrame(message.arg1, 0, 0);
                            return;
                        }
                        try {
                            String[] split = ((String) message.obj).split("\\s+");
                            if (split.length > 0) {
                                int parseInt = Integer.parseInt(split[0]);
                                try {
                                    i2 = parseInt;
                                    i = Integer.parseInt(split[1]);
                                } catch (Exception e) {
                                    i2 = parseInt;
                                    i = 0;
                                    AlaLivePlayer.this.mPlayerCallback.onFirstFrame(message.arg1, i2, i);
                                    return;
                                }
                            } else {
                                i = 0;
                            }
                            try {
                                AlaLivePlayer.this.mPlayerCallback.onFirstFrame(message.arg1, i2, i);
                                return;
                            } catch (Exception e2) {
                                AlaLivePlayer.this.mPlayerCallback.onFirstFrame(message.arg1, i2, i);
                                return;
                            }
                        } catch (Exception e3) {
                            i = 0;
                        }
                    } else {
                        return;
                    }
                    break;
                case 1:
                    if (message.obj != null && (message.obj instanceof AlaLiveDebugInfo) && AlaLivePlayer.this.getVideoPlayer(message.arg1) != null && AlaLivePlayer.this.getVideoPlayer(message.arg1).getPlayerData() != null) {
                        AlaLivePlayer.this.getVideoPlayer(message.arg1).getPlayerData().mLiveDebugInfo.fillWithDebugInfo((AlaLiveDebugInfo) message.obj);
                        if (AlaLivePlayer.this.mPlayerCallback != null && AlaLivePlayer.this.getVideoPlayer(message.arg1).getPlayerData() != null) {
                            AlaLivePlayer.this.mPlayerCallback.onDebugInfo(message.arg1, AlaLivePlayer.this.getVideoPlayer(message.arg1).getPlayerData().mLiveDebugInfo);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (AlaLivePlayer.this.mPlayerCallback != null && message.obj != null && (message.obj instanceof MessageBufferEventData)) {
                        MessageBufferEventData messageBufferEventData = (MessageBufferEventData) message.obj;
                        AlaLivePlayer.this.mPlayerCallback.onBufferingEvent(messageBufferEventData.index, messageBufferEventData.type, messageBufferEventData.startTime, messageBufferEventData.duration);
                        return;
                    }
                    return;
                case 3:
                    if (AlaLivePlayer.this.mPlayerCallback != null && message.obj != null && (message.obj instanceof Integer)) {
                        AlaLivePlayer.this.mPlayerCallback.onFrameDelay(((Integer) message.obj).intValue(), message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 4:
                    if (AlaLivePlayer.this.mPlayerCallback != null) {
                        AlaLivePlayer.this.mPlayerCallback.onStreamChanged(message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 5:
                    if (AlaLivePlayer.this.mPlayerCallback != null && message.obj != null && (message.obj instanceof MessageStreamStuckData)) {
                        MessageStreamStuckData messageStreamStuckData = (MessageStreamStuckData) message.obj;
                        AlaLivePlayer.this.mPlayerCallback.onStreamStuck(messageStreamStuckData.index, messageStreamStuckData.type, messageStreamStuckData.ms);
                        return;
                    }
                    return;
                case 6:
                    if (AlaLivePlayer.this.mPlayerCallback != null) {
                        AlaLivePlayer.this.mPlayerCallback.onFastOpen(message.arg1, message.arg2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes6.dex */
    class CallStateReceiver extends BroadcastReceiver {
        private boolean isRegisted = false;

        CallStateReceiver() {
        }

        public void register(Context context) {
            if (context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PHONE_STATE");
                context.registerReceiver(this, intentFilter);
                this.isRegisted = true;
            }
        }

        public void unregister(Context context) {
            if (context != null && this.isRegisted) {
                context.unregisterReceiver(this);
            }
            this.isRegisted = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                switch (telephonyManager.getCallState()) {
                    case 0:
                        AlaLivePlayer.this.mIsPlaySound = true;
                        return;
                    case 1:
                    case 2:
                        AlaLivePlayer.this.mIsPlaySound = false;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public AlaLiveDebugInfo getLiveDebugInfo(int i) {
        if (getVideoPlayer(i) == null) {
            return null;
        }
        return getVideoPlayer(i).getPlayerData().mLiveDebugInfo;
    }

    public void setPlayerCallback(AlaLivePlayerCallback alaLivePlayerCallback) {
        this.mPlayerCallback = alaLivePlayerCallback;
    }

    public int getFirstOpenTime(int i) {
        if (getVideoPlayer(i) == null) {
            return -1;
        }
        return getVideoPlayer(i).getPlayerData().mFastOpen;
    }

    public void setRenderVideoModel(final int i, final int i2) {
        synchronized (this.mEventQueue) {
            this.mEventQueue.add(new Runnable() { // from class: com.baidu.ala.livePlayer.AlaLivePlayer.15
                @Override // java.lang.Runnable
                public void run() {
                    if (AlaLivePlayer.this.mNDKAdapter.getNativeObject() != 0 && AlaLivePlayer.this.getVideoPlayer(i) != null) {
                        AlaLivePlayer.this.mNDKAdapter.setVideoFillModel(i, i2);
                    }
                }
            });
        }
    }

    public int getRenderVideoModel(int i) {
        if (this.mNDKAdapter.getNativeObject() == 0 || getVideoPlayer(i) == null) {
            return 0;
        }
        return this.mNDKAdapter.getVideoFillModel(i);
    }

    public void setAutoSaveVideoFrame(int i, boolean z) {
    }

    public AlaVideoFrame getSavedVideoFrameNative(int i) {
        return null;
    }
}
