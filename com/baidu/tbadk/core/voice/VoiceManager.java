package com.baidu.tbadk.core.voice;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class VoiceManager extends BroadcastReceiver implements SensorEventListener {
    public static final boolean BOOLEAN_SEEKTO = false;
    public static final String MI3_MODEL_NAME = "MI 3W";
    public static final int MI3_REGISTER_DELAY = 300;
    public static boolean bInitConfig = false;
    public static Integer bInitMode = null;
    public static Boolean bInitSpeakerphoneOn = null;
    public static Integer bInitVolume = null;
    public static boolean bUseMedaiPlayer = false;
    public static boolean bVoiceUseSoftDecoder = false;
    public static float eym = 0.5f;
    public AudioManager audioManager;
    public boolean bFirstSetSpeaker;
    public Boolean bSpeaker;
    public Boolean bSpeakerphoneOn;
    public TbPageContext<?> context;
    public boolean isAddScreenView;
    public Handler mHandle;
    public PermissionJudgePolicy mPermissionJudgePolicy;
    public CustomResponsedMessage<d.a.k0.d3.p0.a> mRecorderManagerRespMsg;
    public i sNewPlayView;
    public i sPlayView;
    public View screenView;
    public WindowManager windowManager;
    public WindowManager.LayoutParams windowParams;
    public long sensorRegisterTime = 0;
    public CustomMessageListener stopListener = new a(2001273);
    public boolean bSensorRegistered = false;
    public boolean mPhoneSpeaker = false;
    public final Runnable startPlayRunnable = new b();
    public VoiceData$VoiceModel mCurPlayModel = null;
    public VoiceData$VoiceModel mNewClickModel = null;
    public k mPlayCall = null;
    public d.a.c.e.l.c<d.a.j0.r.g0.b.a> mResourceCall = null;
    public SensorManager sensorManager = null;
    public Sensor proximitySensor = null;
    public boolean bAllowChangeVoiceMode = true;
    public boolean bStopAndReplay = false;
    public Runnable stopVoiceAndRePlayRunnable = new d();
    public Runnable setSpeakerphoneOnRunnable = new e();
    public final Runnable unRegistSensorRunnable = new f();
    public boolean b_HEADSET_PLUG = false;
    public boolean b_BlUETOOTH_HEADSET_PLUG = false;
    public final BroadcastReceiver mVoicePlayerReceiver = new g();

    /* loaded from: classes3.dex */
    public enum PlayMode {
        SPEAKER,
        HEADSET
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001273) {
                VoiceManager.this.stopPlay();
                if ((customResponsedMessage.getData() instanceof Boolean) && (bool = (Boolean) customResponsedMessage.getData()) != null && bool.booleanValue()) {
                    VoiceManager voiceManager = VoiceManager.this;
                    voiceManager.bSpeaker = voiceManager.isSpeakerphone();
                    VoiceManager.this.setSpeakerphone(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VoiceManager voiceManager = VoiceManager.this;
            voiceManager.mCurPlayModel = voiceManager.mNewClickModel;
            VoiceManager voiceManager2 = VoiceManager.this;
            voiceManager2.sPlayView = voiceManager2.sNewPlayView;
            VoiceManager.this.sNewPlayView = null;
            VoiceManager voiceManager3 = VoiceManager.this;
            voiceManager3.setDownloading(voiceManager3.mCurPlayModel);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.c.e.l.c<d.a.j0.r.g0.b.a> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        /* renamed from: a */
        public void onLoaded(d.a.j0.r.g0.b.a aVar, String str, int i2) {
            super.onLoaded(aVar, str, i2);
            if (VoiceManager.this.mCurPlayModel == null || VoiceManager.this.sPlayView == null || aVar == null) {
                return;
            }
            String str2 = aVar.f49777b;
            String str3 = aVar.f49776a;
            int i3 = aVar.f49778c;
            String str4 = aVar.f49779d;
            if (!StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
                if (VoiceManager.this.mCurPlayModel.voiceId.equals(str3) && VoiceManager.isVoiceDownloading(VoiceManager.this.mCurPlayModel.voice_status.intValue())) {
                    VoiceManager voiceManager = VoiceManager.this;
                    voiceManager.setPlaying(voiceManager.mCurPlayModel, str2);
                    return;
                }
                return;
            }
            TiebaStatic.voiceError(1, VoiceManager.this.context.getString(R.string.voice_cache_error_internal), str2);
            if (i3 <= 0 || StringUtils.isNull(str4) || (i3 != 2 && i3 != 4 && i3 != 3 && i3 != 7)) {
                VoiceManager.this.sPlayView.onShowErr(5, d.a.c.e.q.h.a(R.string.voice_err_load_fail));
            } else {
                VoiceManager.this.sPlayView.onShowErr(5, str4);
            }
            VoiceManager voiceManager2 = VoiceManager.this;
            voiceManager2.setPlayWaiting(voiceManager2.mCurPlayModel);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i playView = VoiceManager.this.getPlayView();
            if (playView != null) {
                VoiceManager.this.startPlay(playView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoiceManager.this.bSpeakerphoneOn == null) {
                return;
            }
            if (VoiceManager.this.bSpeakerphoneOn.booleanValue()) {
                VoiceManager.this.openSpeaker();
            } else {
                VoiceManager.this.closeSpeaker();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VoiceManager.this.isPlaying()) {
                return;
            }
            VoiceManager.this.unRegistSensor();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends BroadcastReceiver {
        public g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String a2;
            if (VoiceManager.this.mCurPlayModel == null || intent == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("com.baidu.isPlaying")) {
                VoiceManager.this.setVolumeControlStream();
                if (!intent.getBooleanExtra("com.baidu.msg.isPlaying", false) || VoiceManager.this.mCurPlayModel == null) {
                    return;
                }
                if (VoiceManager.this.mHandle != null) {
                    VoiceManager.this.mHandle.removeCallbacks(VoiceManager.this.unRegistSensorRunnable);
                }
                try {
                    VoiceManager.this.mCurPlayModel.voice_status = 3;
                    i playView = VoiceManager.this.getPlayView();
                    if (playView != null) {
                        playView.onRefreshByPlayStatus(VoiceManager.this.mCurPlayModel);
                    }
                } catch (Exception e2) {
                    FieldBuilder fieldBuilder = new FieldBuilder();
                    if (VoiceManager.this.mCurPlayModel != null) {
                        fieldBuilder.append("id", VoiceManager.this.mCurPlayModel.getId());
                        fieldBuilder.append("from", VoiceManager.this.mCurPlayModel.from);
                    }
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UPDATEVIEW, "mVoicePlayerReceiver.onReceive exception: " + e2.getMessage(), fieldBuilder.toString());
                }
            } else if (action.equals("com.baidu.playElapsedTime")) {
                int intExtra = intent.getIntExtra("com.baidu.msg.playElapsedTime", 0);
                i playView2 = VoiceManager.this.getPlayView();
                if (playView2 != null) {
                    playView2.onPlayElapse(intExtra);
                }
                if (VoiceManager.this.mCurPlayModel != null) {
                    VoiceManager.this.mCurPlayModel.elapse = intExtra;
                }
            } else if (action.equals("com.baidu.isStoped")) {
                i playView3 = VoiceManager.this.getPlayView();
                if (VoiceManager.this.mCurPlayModel != null) {
                    if (!VoiceManager.this.bStopAndReplay) {
                        VoiceManager.this.releaseWakeLock();
                        VoiceManager voiceManager = VoiceManager.this;
                        voiceManager.setStatusWaiting(voiceManager.mCurPlayModel);
                        VoiceManager.this.sPlayView = null;
                    }
                    VoiceManager.this.mCurPlayModel = null;
                    if (!VoiceManager.this.bStopAndReplay || playView3 == null) {
                        return;
                    }
                    VoiceData$VoiceModel voiceModel = playView3.getVoiceModel();
                    if (voiceModel != null) {
                        voiceModel.curr_time = intent.getIntExtra("com.baidu.msg.curr_time", 0);
                    }
                    if (VoiceManager.this.mHandle != null) {
                        VoiceManager.this.mHandle.removeCallbacks(VoiceManager.this.stopVoiceAndRePlayRunnable);
                        VoiceManager.this.mHandle.postDelayed(VoiceManager.this.stopVoiceAndRePlayRunnable, 200L);
                    }
                }
            } else if (action.equals("com.baidu.playPrepared")) {
                int intExtra2 = intent.getIntExtra("com.baidu.playPrepared_err_code", -1);
                if (intExtra2 != -1) {
                    i playView4 = VoiceManager.this.getPlayView();
                    if (playView4 != null) {
                        if (intExtra2 == 2) {
                            a2 = d.a.c.e.q.h.a(R.string.voice_err_io);
                        } else {
                            a2 = d.a.c.e.q.h.a(R.string.voice_err_play);
                        }
                        playView4.onShowErr(5, a2);
                    }
                    if (VoiceManager.this.mCurPlayModel != null) {
                        VoiceManager voiceManager2 = VoiceManager.this;
                        voiceManager2.setStatusWaiting(voiceManager2.mCurPlayModel);
                        VoiceManager.this.mCurPlayModel = null;
                        return;
                    }
                    return;
                }
                long longExtra = intent.getLongExtra("com.baidu.msg.durationTime2", VoiceManager.this.mCurPlayModel != null ? VoiceManager.this.mCurPlayModel.duration * 1000 : 0L);
                if (longExtra > 900 && VoiceManager.this.mCurPlayModel != null) {
                    VoiceManager.this.mCurPlayModel.duration2 = (int) longExtra;
                }
                i playView5 = VoiceManager.this.getPlayView();
                if (playView5 != null) {
                    playView5.onPlayPrepared();
                }
                MediaService.startPlay(context);
            } else {
                action.equalsIgnoreCase("com.baidu.recognize");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BdAsyncTask<Void, Void, Void> {
        public h() {
        }

        public /* synthetic */ h(VoiceManager voiceManager, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0091, code lost:
            if (r4 == null) goto L17;
         */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            FileReader fileReader;
            FileReader fileReader2 = null;
            try {
                try {
                    fileReader = new FileReader("/sys/class/switch/h2w/state");
                    try {
                        char[] cArr = new char[1024];
                        VoiceManager.this.b_HEADSET_PLUG = Integer.valueOf(new String(cArr, 0, fileReader.read(cArr, 0, 1024)).trim()).intValue() != 0;
                        if (VoiceManager.this.b_HEADSET_PLUG) {
                            VoiceManager.this.setSpeakerphone(false);
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("path", "/sys/class/switch/h2w/state");
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), fieldBuilder.toString());
                    } catch (Exception e3) {
                        e = e3;
                        FieldBuilder fieldBuilder2 = new FieldBuilder();
                        fieldBuilder2.append("path", "/sys/class/switch/h2w/state");
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), fieldBuilder2.toString());
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                fileReader = null;
            } catch (Exception e5) {
                e = e5;
                fileReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (fileReader2 != null) {
                }
                throw th;
            }
            try {
                fileReader.close();
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface i {
        i getRealView();

        VoiceData$VoiceModel getVoiceModel();

        void onPlayElapse(int i2);

        void onPlayPrepared();

        void onRefreshByPlayStatus(VoiceData$VoiceModel voiceData$VoiceModel);

        void onShowErr(int i2, String str);
    }

    /* loaded from: classes3.dex */
    public interface j {
        i getRealView(VoiceData$VoiceModel voiceData$VoiceModel);

        VoiceManager getVoiceManager();
    }

    /* loaded from: classes3.dex */
    public class k implements d.a.c.e.q.c {
        public k() {
        }

        @Override // d.a.c.e.q.e
        public void b(int i2) {
        }

        @Override // d.a.c.e.q.e
        public void c(String str, int i2) {
            if (VoiceManager.this.sPlayView == null || VoiceManager.this.mCurPlayModel == null) {
                return;
            }
            if (!VoiceManager.this.bStopAndReplay) {
                VoiceManager voiceManager = VoiceManager.this;
                voiceManager.setStatusWaiting(voiceManager.mCurPlayModel);
                VoiceManager.this.sPlayView = null;
            }
            VoiceManager.this.mCurPlayModel = null;
            i playView = VoiceManager.this.getPlayView();
            if (!VoiceManager.this.bStopAndReplay || playView == null) {
                VoiceManager.this.releaseWakeLock();
                return;
            }
            VoiceData$VoiceModel voiceModel = playView.getVoiceModel();
            if (voiceModel != null && i2 >= 0) {
                voiceModel.curr_time = i2;
            }
            if (VoiceManager.this.mHandle != null) {
                VoiceManager.this.mHandle.removeCallbacks(VoiceManager.this.stopVoiceAndRePlayRunnable);
                VoiceManager.this.mHandle.postDelayed(VoiceManager.this.stopVoiceAndRePlayRunnable, 10L);
            }
        }

        @Override // d.a.c.e.q.c
        public void d(int i2) {
            i playView = VoiceManager.this.getPlayView();
            if (playView != null) {
                playView.onPlayElapse(i2);
            }
            if (VoiceManager.this.mCurPlayModel != null) {
                VoiceManager.this.mCurPlayModel.elapse = i2;
            }
        }

        @Override // d.a.c.e.q.e
        public void error(int i2, String str) {
            TiebaStatic.voiceError(i2, str, "");
            if (VoiceManager.this.sPlayView == null) {
                return;
            }
            VoiceManager.this.sPlayView.onShowErr(i2, str);
            if (VoiceManager.this.mCurPlayModel != null) {
                VoiceManager voiceManager = VoiceManager.this;
                voiceManager.setStatusWaiting(voiceManager.mCurPlayModel);
                VoiceManager.this.mCurPlayModel = null;
            }
            VoiceManager.this.releaseWakeLock();
        }

        public /* synthetic */ k(VoiceManager voiceManager, a aVar) {
            this();
        }
    }

    public VoiceManager() {
        this.mRecorderManagerRespMsg = null;
        initConfig();
        bUseMedaiPlayer = true ^ isVoiceUseSoftDecoder();
        this.mRecorderManagerRespMsg = MessageManager.getInstance().runTask(2001271, d.a.k0.d3.p0.a.class);
    }

    private void acquireWakeLock() {
        if (this.context == null) {
        }
    }

    private void addBlackScreen() {
        if (this.context == null) {
            return;
        }
        if (this.windowParams == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.windowParams = layoutParams;
            layoutParams.width = -1;
            layoutParams.height = -1;
        }
        if (this.screenView == null) {
            View view = new View(this.context.getPageActivity());
            this.screenView = view;
            view.setBackgroundColor(-16777216);
        }
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) this.context.getContext().getSystemService("window");
        }
        if (d.a.c.e.m.g.f(this.context)) {
            try {
                if (!this.isAddScreenView) {
                    if (this.screenView.getParent() != null) {
                        this.windowManager.removeViewImmediate(this.screenView);
                    }
                    this.windowManager.addView(this.screenView, this.windowParams);
                }
            } catch (Exception unused) {
            }
            this.isAddScreenView = true;
        }
    }

    private void checkHeadsetPlug() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return;
        }
        try {
            this.b_HEADSET_PLUG = audioManager.isWiredHeadsetOn();
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                this.b_BlUETOOTH_HEADSET_PLUG = 2 == defaultAdapter.getProfileConnectionState(1);
            }
            if (this.b_HEADSET_PLUG || this.b_BlUETOOTH_HEADSET_PLUG) {
                setSpeakerphone(false);
            }
        } catch (Throwable th) {
            h hVar = new h(this, null);
            hVar.setSelfExecute(true);
            hVar.execute(new Void[0]);
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "checkHeadsetPlug exception: " + th.getMessage(), "");
        }
    }

    private void firstOpenSpeaker() {
        if (this.bFirstSetSpeaker) {
            if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
                closeSpeaker();
            } else {
                openSpeaker();
            }
            this.bFirstSetSpeaker = false;
        }
    }

    public static String formatVoiceTime(int i2) {
        StringBuffer stringBuffer = new StringBuffer(10);
        if (i2 > 0) {
            int i3 = i2 % 60;
            int i4 = i2 / 60;
            if (i4 > 0) {
                stringBuffer.append(i4);
                stringBuffer.append("'");
            }
            stringBuffer.append(i3);
            stringBuffer.append("\"");
            return stringBuffer.toString();
        }
        return "0\"";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getPlayView() {
        i iVar = this.sPlayView;
        if (iVar == null) {
            return null;
        }
        i realView = iVar.getRealView();
        return realView == null ? this.sPlayView : realView;
    }

    public static synchronized void initConfig() {
        synchronized (VoiceManager.class) {
            if (!bInitConfig) {
                bVoiceUseSoftDecoder = d.a.j0.r.d0.b.j().g("voice_use_soft_decoder", d.a.c.e.q.h.b());
            }
        }
    }

    public static VoiceManager instance() {
        return new VoiceManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean isSpeakerphone() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return null;
        }
        try {
            return Boolean.valueOf(audioManager.isSpeakerphoneOn());
        } catch (Throwable th) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "audioManager.isSpeakerphoneOn() exception: " + th.getMessage(), "");
            return null;
        }
    }

    private boolean isSpeakerphoneOn() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return false;
        }
        try {
            return audioManager.isSpeakerphoneOn();
        } catch (Throwable th) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "audioManager.isSpeakerphoneOn() exception: " + th.getMessage(), "");
            return false;
        }
    }

    public static boolean isVoiceDownloading(int i2) {
        return i2 == 2;
    }

    public static boolean isVoicePlaying(int i2) {
        return i2 == 3;
    }

    public static boolean isVoiceUseSoftDecoder() {
        return bVoiceUseSoftDecoder;
    }

    private boolean mi3Filter(float f2) {
        return Build.MODEL.equals(MI3_MODEL_NAME) && this.sensorRegisterTime + 300 > new Date().getTime();
    }

    private void putPlayView(i iVar) {
        this.sPlayView = iVar;
    }

    private void registPlugin(Context context) {
        this.mPhoneSpeaker = isSpeakerphoneOn();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
        context.registerReceiver(this, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
    }

    private void registSensor() {
        if (this.bSensorRegistered || this.proximitySensor == null) {
            return;
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.unRegistSensorRunnable);
        }
        this.bSensorRegistered = true;
        this.sensorManager.registerListener(this, this.proximitySensor, 3);
        this.sensorRegisterTime = new Date().getTime();
    }

    private void release() {
        stopPlay();
        restoreVoiceMode();
        TbPageContext<?> tbPageContext = this.context;
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
            unRegistPlugin(this.context.getPageActivity());
            MediaService.unregisterReceiver(this.context.getPageActivity(), this.mVoicePlayerReceiver);
        }
        this.context = null;
        if (getRecorderManager() != null) {
            getRecorderManager().release();
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.startPlayRunnable);
            this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
            this.mHandle.removeCallbacks(this.setSpeakerphoneOnRunnable);
        }
        VoiceData$VoiceModel voiceData$VoiceModel = this.mCurPlayModel;
        if (voiceData$VoiceModel != null) {
            voiceData$VoiceModel.init();
        }
        VoiceData$VoiceModel voiceData$VoiceModel2 = this.mNewClickModel;
        if (voiceData$VoiceModel2 != null) {
            voiceData$VoiceModel2.init();
        }
        this.sPlayView = null;
        this.sNewPlayView = null;
        this.mCurPlayModel = null;
        this.mNewClickModel = null;
        this.mHandle = null;
        this.audioManager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWakeLock() {
        removeBlackScreen();
    }

    private void saveInitVoiceStatus() {
        if (this.audioManager == null) {
            return;
        }
        if (bInitSpeakerphoneOn == null) {
            bInitSpeakerphoneOn = Boolean.valueOf(isSpeakerphoneOn());
        }
        if (bInitMode == null) {
            bInitMode = Integer.valueOf(this.audioManager.getMode());
        }
        if (bInitVolume == null) {
            if (bInitMode.intValue() == 3) {
                bInitVolume = Integer.valueOf(this.audioManager.getStreamVolume(3));
            } else {
                bInitVolume = Integer.valueOf(this.audioManager.getStreamVolume(0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloading(VoiceData$VoiceModel voiceData$VoiceModel) {
        try {
            if (this.mResourceCall == null) {
                this.mResourceCall = new c();
            }
            Object b2 = d.a.j0.r.g0.a.b(voiceData$VoiceModel.getId());
            if (b2 == null) {
                b2 = d.a.c.e.l.d.h().k(voiceData$VoiceModel.getId(), 23, this.mResourceCall, 0, 0, (this.context == null || !(this.context.getOrignalPage() instanceof d.a.c.a.i)) ? null : ((d.a.c.a.i) this.context.getOrignalPage()).getUniqueId(), voiceData$VoiceModel.from);
            }
            if (voiceData$VoiceModel.isLocal && b2 == null) {
                if (this.mPlayCall == null) {
                    this.mPlayCall = new k(this, null);
                }
                this.mPlayCall.error(5, d.a.c.e.q.h.a(R.string.voice_err_no_file));
                FieldBuilder fieldBuilder = new FieldBuilder();
                if (voiceData$VoiceModel != null) {
                    fieldBuilder.append("id", voiceData$VoiceModel.getId());
                    fieldBuilder.append("from", voiceData$VoiceModel.from);
                }
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "VoiceManager.setDownloading() error : record file not exists", fieldBuilder.toString());
            } else if (b2 != null) {
                setPlaying(voiceData$VoiceModel, (String) b2);
            } else {
                voiceData$VoiceModel.voice_status = 2;
                i playView = getPlayView();
                if (playView != null) {
                    playView.onRefreshByPlayStatus(voiceData$VoiceModel);
                }
            }
        } catch (Exception e2) {
            FieldBuilder fieldBuilder2 = new FieldBuilder();
            if (voiceData$VoiceModel != null) {
                fieldBuilder2.append("id", voiceData$VoiceModel.getId());
                fieldBuilder2.append("from", voiceData$VoiceModel.from);
            }
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_DOWN, "setMsgDownloading error: " + e2.getMessage(), fieldBuilder2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayWaiting(VoiceData$VoiceModel voiceData$VoiceModel) {
        if (bUseMedaiPlayer) {
            if (isVoicePlaying(voiceData$VoiceModel.voice_status.intValue())) {
                setStatusWaiting(voiceData$VoiceModel);
                MediaService.stopPlay(this.context.getPageActivity());
                return;
            }
            setStatusWaiting(voiceData$VoiceModel);
            return;
        }
        try {
            if (isVoicePlaying(voiceData$VoiceModel.voice_status.intValue())) {
                setStatusWaiting(voiceData$VoiceModel);
                d.a.c.e.q.a.f();
            } else {
                setStatusWaiting(voiceData$VoiceModel);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            FieldBuilder fieldBuilder = new FieldBuilder();
            if (voiceData$VoiceModel != null) {
                fieldBuilder.append("id", voiceData$VoiceModel.getId());
                fieldBuilder.append("from", voiceData$VoiceModel.from);
            }
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_PAUSE, "VoiceManager.setPlayWaiting() error : " + e2.toString(), fieldBuilder.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaying(VoiceData$VoiceModel voiceData$VoiceModel, String str) {
        try {
            if (this.mPlayCall == null) {
                this.mPlayCall = new k(this, null);
            }
            if (!new File(str).exists()) {
                this.mPlayCall.error(5, d.a.c.e.q.h.a(R.string.voice_err_no_file));
                return;
            }
            registSensor();
            acquireWakeLock();
            firstOpenSpeaker();
            if (this.audioManager != null) {
                if (this.audioManager.isSpeakerphoneOn()) {
                    d.a.c.e.q.h.f39247b = 3;
                } else {
                    d.a.c.e.q.h.f39247b = 0;
                }
            }
            setVolumeControlStream();
            if (bUseMedaiPlayer) {
                MediaService.preparePlay(this.context.getPageActivity(), str, voiceData$VoiceModel.duration, voiceData$VoiceModel.curr_time);
                voiceData$VoiceModel.curr_time = 0;
                return;
            }
            boolean e2 = d.a.c.e.q.a.e(str, this.mPlayCall, voiceData$VoiceModel.curr_time);
            voiceData$VoiceModel.curr_time = 0;
            if (!e2) {
                FieldBuilder fieldBuilder = new FieldBuilder();
                fieldBuilder.append("file", str);
                if (voiceData$VoiceModel != null) {
                    fieldBuilder.append("id", voiceData$VoiceModel.getId());
                    fieldBuilder.append("from", voiceData$VoiceModel.from);
                }
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "setMsgPlaying error: AmrAudioPlayer.start", fieldBuilder.toString());
                return;
            }
            voiceData$VoiceModel.voice_status = 3;
            i playView = getPlayView();
            if (playView != null) {
                playView.onRefreshByPlayStatus(voiceData$VoiceModel);
            }
        } catch (Exception e3) {
            BdLog.e(e3.getMessage());
            FieldBuilder fieldBuilder2 = new FieldBuilder();
            fieldBuilder2.append("file", str);
            if (voiceData$VoiceModel != null) {
                fieldBuilder2.append("id", voiceData$VoiceModel.getId());
                fieldBuilder2.append("from", voiceData$VoiceModel.from);
            }
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "setMsgPlaying error: " + e3.getMessage(), fieldBuilder2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeakerphone(boolean z) {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return;
        }
        try {
            if (audioManager.isSpeakerphoneOn() == z) {
                return;
            }
            this.audioManager.setSpeakerphoneOn(z);
        } catch (Throwable th) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "audioManager.setSpeakerphoneOn() exception: " + th.getMessage(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusWaiting(VoiceData$VoiceModel voiceData$VoiceModel) {
        unRegistSensorHandler();
        voiceData$VoiceModel.voice_status = 1;
        d.a.c.e.q.h.f39247b = 2;
        setVolumeControlStream();
        i playView = getPlayView();
        if (playView != null) {
            playView.onRefreshByPlayStatus(voiceData$VoiceModel);
        }
    }

    public static void setVoiceUseSoftDecoder(boolean z) {
        bVoiceUseSoftDecoder = true;
        d.a.j0.r.d0.b.j().t("voice_use_soft_decoder", bVoiceUseSoftDecoder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolumeControlStream() {
        try {
            if (this.context == null || this.context.getPageActivity() == null) {
                return;
            }
            this.context.getPageActivity().setVolumeControlStream(d.a.c.e.q.h.f39247b);
        } catch (Exception e2) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_VOLUME, "setVolumeControlStream exception: " + e2.getMessage(), "");
        }
    }

    private void stopVoiceAndRePlay() {
        VoiceData$VoiceModel voiceData$VoiceModel;
        if (this.context == null) {
            return;
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.stopVoiceAndRePlayRunnable);
        }
        i playView = getPlayView();
        if (this.bStopAndReplay || (voiceData$VoiceModel = this.mCurPlayModel) == null || !isVoicePlaying(voiceData$VoiceModel.voice_status.intValue()) || playView == null) {
            return;
        }
        this.bStopAndReplay = true;
        if (bUseMedaiPlayer) {
            MediaService.stopPlay(this.context.getPageActivity());
        } else {
            stopPlay();
        }
    }

    private void stopVoiceAndRePlay_new() {
        VoiceData$VoiceModel voiceData$VoiceModel;
        if (this.context == null) {
            return;
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.stopVoiceAndRePlayRunnable);
        }
        i playView = getPlayView();
        if (this.bStopAndReplay || (voiceData$VoiceModel = this.mCurPlayModel) == null || !isVoicePlaying(voiceData$VoiceModel.voice_status.intValue()) || playView == null) {
            return;
        }
        MediaService.stopAndReplayVoice(this.context.getPageActivity());
    }

    private void unRegistPlugin(Context context) {
        if (context == null) {
            return;
        }
        try {
            context.unregisterReceiver(this);
            setSpeakerphone(this.mPhoneSpeaker);
            this.mHandle.removeCallbacks(this.unRegistSensorRunnable);
            unRegistSensor();
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UNREGISTPLUGIN, "unRegistPlugin exception: " + e2.getMessage(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegistSensor() {
        if (this.bSensorRegistered) {
            try {
                if (this.sensorManager != null) {
                    this.sensorManager.unregisterListener(this, this.proximitySensor);
                    this.sensorManager.unregisterListener(this);
                }
            } catch (Exception e2) {
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UNREGISTSENSOR, "unRegistSensor exception: " + e2.getMessage(), "");
            }
            this.bSensorRegistered = false;
        }
    }

    private void unRegistSensorHandler() {
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.unRegistSensorRunnable);
            this.mHandle.postDelayed(this.unRegistSensorRunnable, 1000L);
        }
    }

    public void closeSpeaker() {
        if (this.audioManager == null) {
            return;
        }
        saveInitVoiceStatus();
        try {
            setSpeakerphone(false);
            d.a.c.e.q.h.f39247b = 0;
            stopVoiceAndRePlay();
        } catch (Exception e2) {
            e2.printStackTrace();
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "closeSpeaker exception: " + e2.getMessage(), "");
        }
    }

    public void forceStop() {
        TbPageContext<?> tbPageContext = this.context;
        if (tbPageContext == null) {
            return;
        }
        unRegistPlugin(tbPageContext.getPageActivity());
        if (bUseMedaiPlayer) {
            VoiceData$VoiceModel voiceData$VoiceModel = this.mCurPlayModel;
            if (voiceData$VoiceModel != null) {
                setStatusWaiting(voiceData$VoiceModel);
                this.mCurPlayModel = null;
            }
            MediaService.stopPlay(this.context.getPageActivity());
            return;
        }
        stopPlay();
    }

    public d.a.k0.d3.p0.a getRecorderManager() {
        CustomResponsedMessage<d.a.k0.d3.p0.a> customResponsedMessage = this.mRecorderManagerRespMsg;
        if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
            return null;
        }
        d.a.k0.d3.p0.a data = this.mRecorderManagerRespMsg.getData();
        data.c(this.context);
        return data;
    }

    public boolean isPlayDoing(VoiceData$VoiceModel voiceData$VoiceModel) {
        VoiceData$VoiceModel voiceData$VoiceModel2 = this.mCurPlayModel;
        return (voiceData$VoiceModel2 == null || voiceData$VoiceModel == null || voiceData$VoiceModel2 != voiceData$VoiceModel) ? false : true;
    }

    public boolean isPlaying(VoiceData$VoiceModel voiceData$VoiceModel) {
        VoiceData$VoiceModel voiceData$VoiceModel2 = this.mCurPlayModel;
        return voiceData$VoiceModel2 != null && voiceData$VoiceModel != null && voiceData$VoiceModel2.getId().equals(voiceData$VoiceModel.getId()) && isVoicePlaying(this.mCurPlayModel.voice_status.intValue());
    }

    public void manualSetPlayMode(PlayMode playMode) {
        if (isPlaying()) {
            if (playMode == PlayMode.HEADSET) {
                unRegistSensor();
                setSpeakerphoneOn(false);
                return;
            }
            registSensor();
            setSpeakerphoneOn(true);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    public void onCreate(TbPageContext<?> tbPageContext) {
        this.context = tbPageContext;
        this.mHandle = new Handler();
        this.audioManager = (AudioManager) tbPageContext.getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        SensorManager sensorManager = (SensorManager) TbadkCoreApplication.getInst().getSystemService("sensor");
        this.sensorManager = sensorManager;
        this.proximitySensor = sensorManager.getDefaultSensor(8);
        this.bSpeakerphoneOn = Boolean.TRUE;
        this.mCurPlayModel = null;
        this.mNewClickModel = null;
        if (bUseMedaiPlayer) {
            MediaService.initBroadcastReceivers(tbPageContext.getPageActivity(), this.mVoicePlayerReceiver);
            try {
                MediaService.startMy(tbPageContext.getPageActivity(), null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        checkHeadsetPlug();
    }

    public void onDestory(TbPageContext<?> tbPageContext) {
        if (this.mCurPlayModel != null) {
            d.a.c.e.l.d.h().c(this.mCurPlayModel.getId(), 23);
        }
        release();
    }

    public void onPause(TbPageContext<?> tbPageContext) {
        onPause(tbPageContext, true);
        MessageManager.getInstance().unRegisterListener(this.stopListener);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            z = intent.getIntExtra("state", 0) == 1;
            this.b_HEADSET_PLUG = z;
            if (z) {
                setSpeakerphone(false);
            }
        } else if (intent.getAction().equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
            z = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1) == 2;
            this.b_BlUETOOTH_HEADSET_PLUG = z;
            if (z) {
                setSpeakerphone(false);
            }
        }
    }

    public void onResume(TbPageContext<?> tbPageContext) {
        this.bFirstSetSpeaker = true;
        registPlugin(tbPageContext.getPageActivity());
        MessageManager.getInstance().registerListener(this.stopListener);
    }

    public void onSaveInstanceState(Activity activity) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 8 && !this.b_HEADSET_PLUG && this.bAllowChangeVoiceMode) {
            float[] fArr = sensorEvent.values;
            if (fArr.length > 0) {
                float f2 = fArr[0];
                if (mi3Filter(f2)) {
                    return;
                }
                float f3 = eym;
                if (f2 < f3) {
                    setSpeakerphoneOn(false);
                    addBlackScreen();
                } else if (f2 > f3) {
                    removeBlackScreen();
                    setSpeakerphoneOn(true);
                }
            }
        }
    }

    public void onStart(TbPageContext<?> tbPageContext) {
    }

    public void onStop(TbPageContext<?> tbPageContext) {
        forceStop();
        restoreVoiceMode();
    }

    public void openSpeaker() {
        if (this.audioManager == null || d.a.c.e.q.h.f39246a == 2) {
            return;
        }
        if (!TbadkCoreApplication.getInst().isHeadsetModeOn() && !TbadkCoreApplication.getInst().getIsPhoneCalling()) {
            try {
                saveInitVoiceStatus();
                setSpeakerphone(true);
                d.a.c.e.q.h.f39247b = 3;
                stopVoiceAndRePlay();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "openSpeaker exception: " + e2.getMessage(), "");
                return;
            }
        }
        setSpeakerphone(false);
        this.bSpeakerphoneOn = Boolean.FALSE;
    }

    public void removeBlackScreen() {
        View view;
        if (this.windowManager != null && (view = this.screenView) != null && this.isAddScreenView && view.getWindowToken() != null) {
            this.windowManager.removeView(this.screenView);
        }
        this.isAddScreenView = false;
    }

    public void resetPlayView(i iVar) {
        if (iVar != null && isPlayDoing(iVar.getVoiceModel())) {
            putPlayView(iVar);
        }
    }

    public void restoreVoiceMode() {
        this.bStopAndReplay = false;
        if (this.audioManager == null) {
            return;
        }
        try {
            if (bInitSpeakerphoneOn == null || bInitMode == null || bInitVolume == null) {
                return;
            }
            setSpeakerphone(bInitSpeakerphoneOn.booleanValue());
            d.a.c.e.q.h.f39247b = 3;
            bInitSpeakerphoneOn = null;
            bInitMode = null;
            bInitVolume = null;
        } catch (Exception e2) {
            e2.printStackTrace();
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "restoreVoiceMode exception: " + e2.getMessage(), "");
        }
    }

    public void setAllowChangeVoiceMode(boolean z) {
        this.bAllowChangeVoiceMode = z;
    }

    public void setSpeakerphoneOn(boolean z) {
        if (this.audioManager == null) {
            return;
        }
        Boolean bool = this.bSpeakerphoneOn;
        if (bool == null || bool.booleanValue() != z) {
            this.bSpeakerphoneOn = Boolean.valueOf(z);
            Handler handler = this.mHandle;
            if (handler != null) {
                handler.removeCallbacks(this.setSpeakerphoneOnRunnable);
                this.mHandle.postDelayed(this.setSpeakerphoneOnRunnable, 300L);
            }
        }
    }

    public void startPlay(i iVar) {
        if (iVar == null) {
            return;
        }
        if (this.mPermissionJudgePolicy == null) {
            this.mPermissionJudgePolicy = new PermissionJudgePolicy();
        }
        this.mPermissionJudgePolicy.clearRequestPermissionList();
        this.mPermissionJudgePolicy.appendRequestPermission(this.context.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        this.mPermissionJudgePolicy.appendRequestPermission(this.context.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        if (this.mPermissionJudgePolicy.startRequestPermission(this.context.getPageActivity())) {
            return;
        }
        Handler handler = this.mHandle;
        if (handler != null) {
            handler.removeCallbacks(this.stopVoiceAndRePlayRunnable);
        }
        this.bStopAndReplay = false;
        VoiceData$VoiceModel voiceModel = iVar.getVoiceModel();
        if (voiceModel == null) {
            return;
        }
        Boolean bool = this.bSpeaker;
        if (bool != null && bool.booleanValue()) {
            setSpeakerphone(this.bSpeaker.booleanValue());
            this.bSpeaker = null;
        }
        this.sNewPlayView = iVar;
        this.mNewClickModel = voiceModel;
        Integer num = voiceModel.voice_status;
        int intValue = num != null ? num.intValue() : 1;
        VoiceData$VoiceModel voiceData$VoiceModel = this.mCurPlayModel;
        if (voiceData$VoiceModel != null) {
            voiceData$VoiceModel.curr_time = 0;
            if (voiceData$VoiceModel == this.mNewClickModel) {
                putPlayView(iVar);
                VoiceData$VoiceModel voiceData$VoiceModel2 = this.mNewClickModel;
                this.mCurPlayModel = voiceData$VoiceModel2;
                if (intValue == 1) {
                    setDownloading(voiceData$VoiceModel2);
                    return;
                } else if (intValue == 2 || intValue == 3) {
                    setPlayWaiting(this.mCurPlayModel);
                    return;
                } else {
                    return;
                }
            }
            setPlayWaiting(voiceData$VoiceModel);
            setStatusWaiting(this.mCurPlayModel);
            Handler handler2 = this.mHandle;
            if (handler2 != null) {
                handler2.removeCallbacks(this.startPlayRunnable);
                this.mHandle.postDelayed(this.startPlayRunnable, 300L);
                return;
            }
            return;
        }
        Handler handler3 = this.mHandle;
        if (handler3 != null) {
            handler3.removeCallbacks(this.startPlayRunnable);
            this.mHandle.postDelayed(this.startPlayRunnable, 300L);
        }
    }

    public void stopPlay() {
        VoiceData$VoiceModel voiceData$VoiceModel = this.mCurPlayModel;
        if (voiceData$VoiceModel != null) {
            setPlayWaiting(voiceData$VoiceModel);
        }
        if (this.bStopAndReplay) {
            return;
        }
        releaseWakeLock();
    }

    public void onPause(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            forceStop();
        }
    }

    public boolean isPlaying() {
        VoiceData$VoiceModel voiceData$VoiceModel = this.mCurPlayModel;
        return voiceData$VoiceModel != null && isVoicePlaying(voiceData$VoiceModel.voice_status.intValue());
    }
}
