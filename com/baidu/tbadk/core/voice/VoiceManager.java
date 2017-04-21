package com.baidu.tbadk.core.voice;

import android.app.Activity;
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
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.voice.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
/* loaded from: classes.dex */
public class VoiceManager extends BroadcastReceiver implements SensorEventListener {
    public static final boolean BOOLEAN_SEEKTO = false;
    private static final String MI3_MODEL_NAME = "MI 3W";
    private static final int MI3_REGISTER_DELAY = 300;
    public static final int VOICE_ERROR_CODE_0 = 0;
    private static Integer bInitMode;
    private static Boolean bInitSpeakerphoneOn;
    private static Integer bInitVolume;
    AudioManager audioManager;
    private boolean bFirstSetSpeaker;
    private Boolean bSpeaker;
    private Boolean bSpeakerphoneOn;
    TbPageContext<?> context;
    private boolean isAddScreenView;
    private Handler mHandle;
    private CustomResponsedMessage<com.baidu.tieba.tbadkCore.voice.a> mRecorderManagerRespMsg;
    private b sNewPlayView;
    private b sPlayView;
    private View screenView;
    private WindowManager windowManager;
    private WindowManager.LayoutParams windowParams;
    private static boolean bUseMedaiPlayer = false;
    private static boolean bInitConfig = false;
    private static boolean bVoiceUseSoftDecoder = false;
    private static float eym = 0.5f;
    private long sensorRegisterTime = 0;
    private CustomMessageListener stopListener = new com.baidu.tbadk.core.voice.a(this, CmdConfigCustom.CMD_VOICE_STOP_PLAY);
    private CustomMessageListener ttsAudioStartListener = new com.baidu.tbadk.core.voice.b(this, CmdConfigCustom.CMD_AUDIO_VIEW_START_PALY);
    private boolean bSensorRegistered = false;
    private boolean mPhoneSpeaker = false;
    private final Runnable startPlayRunnable = new com.baidu.tbadk.core.voice.c(this);
    private VoiceData.VoiceModel mCurPlayModel = null;
    private VoiceData.VoiceModel mNewClickModel = null;
    private d mPlayCall = null;
    private com.baidu.adp.lib.f.b<com.baidu.tbadk.core.voice.a.a> mResourceCall = null;
    SensorManager sensorManager = null;
    Sensor proximitySensor = null;
    private boolean bAllowChangeVoiceMode = true;
    private boolean bStopAndReplay = false;
    Runnable stopVoiceAndRePlayRunnable = new com.baidu.tbadk.core.voice.d(this);
    Runnable setSpeakerphoneOnRunnable = new e(this);
    private final Runnable unRegistSensorRunnable = new f(this);
    boolean b_HEADSET_PLUG = false;
    private final BroadcastReceiver mVoicePlayerReceiver = new g(this);

    /* loaded from: classes.dex */
    public enum PlayMode {
        SPEAKER,
        HEADSET;

        /* JADX DEBUG: Replace access to removed values field (anw) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PlayMode[] valuesCustom() {
            PlayMode[] valuesCustom = values();
            int length = valuesCustom.length;
            PlayMode[] playModeArr = new PlayMode[length];
            System.arraycopy(valuesCustom, 0, playModeArr, 0, length);
            return playModeArr;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void aR(int i);

        void b(VoiceData.VoiceModel voiceModel);

        b getRealView();

        VoiceData.VoiceModel getVoiceModel();

        void mw();

        void onShowErr(int i, String str);
    }

    /* loaded from: classes.dex */
    public interface c {
        b c(VoiceData.VoiceModel voiceModel);

        VoiceManager getVoiceManager();
    }

    public static synchronized void initConfig() {
        synchronized (VoiceManager.class) {
            if (!bInitConfig) {
                bVoiceUseSoftDecoder = com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("voice_use_soft_decoder", l.hQ());
            }
        }
    }

    public static boolean isVoiceUseSoftDecoder() {
        return bVoiceUseSoftDecoder;
    }

    public static void setVoiceUseSoftDecoder(boolean z) {
        bVoiceUseSoftDecoder = true;
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("voice_use_soft_decoder", bVoiceUseSoftDecoder);
    }

    public static VoiceManager instance() {
        return new VoiceManager();
    }

    public VoiceManager() {
        this.mRecorderManagerRespMsg = null;
        initConfig();
        bUseMedaiPlayer = isVoiceUseSoftDecoder() ? false : true;
        this.mRecorderManagerRespMsg = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECORDER_MANAGER_INSTANCE, com.baidu.tieba.tbadkCore.voice.a.class);
    }

    public com.baidu.tieba.tbadkCore.voice.a getRecorderManager() {
        if (this.mRecorderManagerRespMsg == null || this.mRecorderManagerRespMsg.getData() == null) {
            return null;
        }
        com.baidu.tieba.tbadkCore.voice.a data = this.mRecorderManagerRespMsg.getData();
        data.a(this.context);
        return data;
    }

    public static boolean isVoicePlaying(int i) {
        return i == 3;
    }

    public static boolean isVoiceDownloading(int i) {
        return i == 2;
    }

    public boolean isPlaying(VoiceData.VoiceModel voiceModel) {
        return this.mCurPlayModel != null && voiceModel != null && this.mCurPlayModel.getId().equals(voiceModel.getId()) && isVoicePlaying(this.mCurPlayModel.voice_status.intValue());
    }

    public boolean isPlaying() {
        return this.mCurPlayModel != null && isVoicePlaying(this.mCurPlayModel.voice_status.intValue());
    }

    public boolean isPlayDoing(VoiceData.VoiceModel voiceModel) {
        return (this.mCurPlayModel == null || voiceModel == null || this.mCurPlayModel != voiceModel) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatusWaiting(VoiceData.VoiceModel voiceModel) {
        unRegistSensorHandler();
        voiceModel.voice_status = 1;
        l.zI = 2;
        setVolumeControlStream();
        b playView = getPlayView();
        if (playView != null) {
            playView.b(voiceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayWaiting(VoiceData.VoiceModel voiceModel) {
        if (bUseMedaiPlayer) {
            if (isVoicePlaying(voiceModel.voice_status.intValue())) {
                setStatusWaiting(voiceModel);
                MediaService.stopPlay(this.context.getPageActivity());
                return;
            }
            setStatusWaiting(voiceModel);
            return;
        }
        try {
            if (isVoicePlaying(voiceModel.voice_status.intValue())) {
                setStatusWaiting(voiceModel);
                com.baidu.adp.lib.voice.a.stop();
            } else {
                setStatusWaiting(voiceModel);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            k kVar = new k();
            if (voiceModel != null) {
                kVar.n("id", voiceModel.getId());
                kVar.n("from", voiceModel.from);
            }
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_PAUSE, "VoiceManager.setPlayWaiting() error : " + e.toString(), kVar.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloading(VoiceData.VoiceModel voiceModel) {
        BdUniqueId bdUniqueId = null;
        try {
            if (this.mResourceCall == null) {
                this.mResourceCall = new h(this);
            }
            Object dX = i.dX(voiceModel.getId());
            if (dX == null) {
                if (this.context != null && (this.context.getOrignalPage() instanceof j)) {
                    bdUniqueId = ((j) this.context.getOrignalPage()).getUniqueId();
                }
                dX = com.baidu.adp.lib.f.c.fM().a(voiceModel.getId(), 23, this.mResourceCall, 0, 0, bdUniqueId, voiceModel.from);
            }
            if (voiceModel.isLocal && dX == null) {
                if (this.mPlayCall == null) {
                    this.mPlayCall = new d(this, null);
                }
                this.mPlayCall.f(5, l.getString(w.l.voice_err_no_file));
                k kVar = new k();
                if (voiceModel != null) {
                    kVar.n("id", voiceModel.getId());
                    kVar.n("from", voiceModel.from);
                }
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "VoiceManager.setDownloading() error : record file not exists", kVar.toString());
            } else if (dX != null) {
                setPlaying(voiceModel, (String) dX);
            } else {
                voiceModel.voice_status = 2;
                b playView = getPlayView();
                if (playView != null) {
                    playView.b(voiceModel);
                }
            }
        } catch (Exception e) {
            k kVar2 = new k();
            if (voiceModel != null) {
                kVar2.n("id", voiceModel.getId());
                kVar2.n("from", voiceModel.from);
            }
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_DOWN, "setMsgDownloading error: " + e.getMessage(), kVar2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b getPlayView() {
        if (this.sPlayView == null) {
            return null;
        }
        b realView = this.sPlayView.getRealView();
        if (realView == null) {
            return this.sPlayView;
        }
        return realView;
    }

    private void putPlayView(b bVar) {
        this.sPlayView = bVar;
    }

    public void resetPlayView(b bVar) {
        if (bVar != null && isPlayDoing(bVar.getVoiceModel())) {
            putPlayView(bVar);
        }
    }

    public void startPlay(b bVar) {
        if (bVar != null && !ae.aF(this.context.getPageActivity()) && !ae.aC(null)) {
            if (this.mHandle != null) {
                this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
            }
            this.bStopAndReplay = false;
            VoiceData.VoiceModel voiceModel = bVar.getVoiceModel();
            if (voiceModel != null) {
                if (this.bSpeaker != null && this.bSpeaker.booleanValue()) {
                    setSpeakerphone(this.bSpeaker.booleanValue());
                    this.bSpeaker = null;
                }
                this.sNewPlayView = bVar;
                this.mNewClickModel = voiceModel;
                int i = 1;
                if (this.mNewClickModel.voice_status != null) {
                    i = this.mNewClickModel.voice_status.intValue();
                }
                if (this.mCurPlayModel != null) {
                    this.mCurPlayModel.curr_time = 0;
                    if (this.mCurPlayModel == this.mNewClickModel) {
                        putPlayView(bVar);
                        this.mCurPlayModel = this.mNewClickModel;
                        switch (i) {
                            case 1:
                                setDownloading(this.mCurPlayModel);
                                return;
                            case 2:
                            case 3:
                                setPlayWaiting(this.mCurPlayModel);
                                return;
                            default:
                                return;
                        }
                    }
                    setPlayWaiting(this.mCurPlayModel);
                    setStatusWaiting(this.mCurPlayModel);
                    if (this.mHandle != null) {
                        this.mHandle.removeCallbacks(this.startPlayRunnable);
                        this.mHandle.postDelayed(this.startPlayRunnable, 300L);
                    }
                } else if (this.mHandle != null) {
                    this.mHandle.removeCallbacks(this.startPlayRunnable);
                    this.mHandle.postDelayed(this.startPlayRunnable, 300L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements com.baidu.adp.lib.voice.f {
        private d() {
        }

        /* synthetic */ d(VoiceManager voiceManager, d dVar) {
            this();
        }

        @Override // com.baidu.adp.lib.voice.i
        public void k(String str, int i) {
            if (VoiceManager.this.sPlayView == null || VoiceManager.this.mCurPlayModel == null) {
                return;
            }
            if (!VoiceManager.this.bStopAndReplay) {
                VoiceManager.this.setStatusWaiting(VoiceManager.this.mCurPlayModel);
                VoiceManager.this.sPlayView = null;
            }
            VoiceManager.this.mCurPlayModel = null;
            b playView = VoiceManager.this.getPlayView();
            if (VoiceManager.this.bStopAndReplay && playView != null) {
                VoiceData.VoiceModel voiceModel = playView.getVoiceModel();
                if (voiceModel != null && i >= 0) {
                    voiceModel.curr_time = i;
                }
                if (VoiceManager.this.mHandle != null) {
                    VoiceManager.this.mHandle.removeCallbacks(VoiceManager.this.stopVoiceAndRePlayRunnable);
                    VoiceManager.this.mHandle.postDelayed(VoiceManager.this.stopVoiceAndRePlayRunnable, 10L);
                    return;
                }
                return;
            }
            VoiceManager.this.releaseWakeLock();
        }

        @Override // com.baidu.adp.lib.voice.i
        public void f(int i, String str) {
            TiebaStatic.voiceError(i, str, "");
            if (VoiceManager.this.sPlayView != null) {
                VoiceManager.this.sPlayView.onShowErr(i, str);
                if (VoiceManager.this.mCurPlayModel != null) {
                    VoiceManager.this.setStatusWaiting(VoiceManager.this.mCurPlayModel);
                    VoiceManager.this.mCurPlayModel = null;
                }
                VoiceManager.this.releaseWakeLock();
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void ay(int i) {
        }

        @Override // com.baidu.adp.lib.voice.f
        public void ax(int i) {
            b playView = VoiceManager.this.getPlayView();
            if (playView != null) {
                playView.aR(i);
            }
            if (VoiceManager.this.mCurPlayModel != null) {
                VoiceManager.this.mCurPlayModel.elapse = i;
            }
        }
    }

    private void firstOpenSpeaker() {
        if (this.bFirstSetSpeaker) {
            if (TbadkCoreApplication.m9getInst().isHeadsetModeOn()) {
                closeSpeaker();
            } else {
                openSpeaker();
            }
            this.bFirstSetSpeaker = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaying(VoiceData.VoiceModel voiceModel, String str) {
        try {
            if (this.mPlayCall == null) {
                this.mPlayCall = new d(this, null);
            }
            if (!new File(str).exists()) {
                this.mPlayCall.f(5, l.getString(w.l.voice_err_no_file));
                return;
            }
            registSensor();
            acquireWakeLock();
            firstOpenSpeaker();
            if (this.audioManager != null) {
                if (this.audioManager.isSpeakerphoneOn()) {
                    l.zI = 3;
                } else {
                    l.zI = 0;
                }
            }
            setVolumeControlStream();
            if (bUseMedaiPlayer) {
                MediaService.preparePlay(this.context.getPageActivity(), str, voiceModel.duration, voiceModel.curr_time);
                voiceModel.curr_time = 0;
                return;
            }
            boolean a2 = com.baidu.adp.lib.voice.a.a(str, this.mPlayCall, voiceModel.curr_time);
            voiceModel.curr_time = 0;
            if (!a2) {
                k kVar = new k();
                kVar.n("file", str);
                if (voiceModel != null) {
                    kVar.n("id", voiceModel.getId());
                    kVar.n("from", voiceModel.from);
                }
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "setMsgPlaying error: AmrAudioPlayer.start", kVar.toString());
                return;
            }
            voiceModel.voice_status = 3;
            b playView = getPlayView();
            if (playView != null) {
                playView.b(voiceModel);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            k kVar2 = new k();
            kVar2.n("file", str);
            if (voiceModel != null) {
                kVar2.n("id", voiceModel.getId());
                kVar2.n("from", voiceModel.from);
            }
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "setMsgPlaying error: " + e.getMessage(), kVar2.toString());
        }
    }

    private void release() {
        stopPlay();
        restoreVoiceMode();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
            unRegistPlugin(this.context.getPageActivity());
            MediaService.unregisterReceiver(this.context.getPageActivity(), this.mVoicePlayerReceiver);
        }
        this.context = null;
        if (getRecorderManager() != null) {
            getRecorderManager().release();
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.startPlayRunnable);
            this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
            this.mHandle.removeCallbacks(this.setSpeakerphoneOnRunnable);
        }
        if (this.mCurPlayModel != null) {
            this.mCurPlayModel.init();
        }
        if (this.mNewClickModel != null) {
            this.mNewClickModel.init();
        }
        this.sPlayView = null;
        this.sNewPlayView = null;
        this.mCurPlayModel = null;
        this.mNewClickModel = null;
        this.mHandle = null;
        this.audioManager = null;
    }

    public void stopPlay() {
        if (this.mCurPlayModel != null) {
            setPlayWaiting(this.mCurPlayModel);
        }
        if (!this.bStopAndReplay) {
            releaseWakeLock();
        }
    }

    private void acquireWakeLock() {
        if (this.context == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWakeLock() {
        removeBlackScreen();
    }

    public void setAllowChangeVoiceMode(boolean z) {
        this.bAllowChangeVoiceMode = z;
    }

    public void onCreate(TbPageContext<?> tbPageContext) {
        this.context = tbPageContext;
        this.mHandle = new Handler();
        this.audioManager = (AudioManager) tbPageContext.getContext().getSystemService("audio");
        this.sensorManager = (SensorManager) TbadkCoreApplication.m9getInst().getSystemService("sensor");
        this.proximitySensor = this.sensorManager.getDefaultSensor(8);
        this.bSpeakerphoneOn = true;
        this.mCurPlayModel = null;
        this.mNewClickModel = null;
        this.mPhoneSpeaker = isSpeakerphoneOn();
        MessageManager.getInstance().registerListener(this.ttsAudioStartListener);
        if (bUseMedaiPlayer) {
            MediaService.initBroadcastReceivers(tbPageContext.getPageActivity(), this.mVoicePlayerReceiver);
            MediaService.startMy(tbPageContext.getPageActivity(), null);
        }
        checkHeadsetPlug();
    }

    public void onStart(TbPageContext<?> tbPageContext) {
    }

    public void onResume(TbPageContext<?> tbPageContext) {
        this.bFirstSetSpeaker = true;
        registPlugin(tbPageContext.getPageActivity());
        MessageManager.getInstance().registerListener(this.stopListener);
    }

    public void onPause(TbPageContext<?> tbPageContext) {
        onPause(tbPageContext, true);
        MessageManager.getInstance().unRegisterListener(this.stopListener);
    }

    public void onPause(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            forceStop();
        }
    }

    public void forceStop() {
        if (this.context != null) {
            unRegistPlugin(this.context.getPageActivity());
            if (bUseMedaiPlayer) {
                if (this.mCurPlayModel != null) {
                    setStatusWaiting(this.mCurPlayModel);
                    this.mCurPlayModel = null;
                }
                MediaService.stopPlay(this.context.getPageActivity());
                return;
            }
            stopPlay();
        }
    }

    public void onSaveInstanceState(Activity activity) {
    }

    public void onStop(TbPageContext<?> tbPageContext) {
        forceStop();
        restoreVoiceMode();
    }

    public void onDestory(TbPageContext<?> tbPageContext) {
        if (this.mCurPlayModel != null) {
            com.baidu.adp.lib.f.c.fM().e(this.mCurPlayModel.getId(), 23);
        }
        MessageManager.getInstance().unRegisterListener(this.ttsAudioStartListener);
        release();
    }

    private void saveInitVoiceStatus() {
        if (this.audioManager != null) {
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
    }

    private boolean isSpeakerphoneOn() {
        if (this.audioManager == null) {
            return false;
        }
        try {
            return this.audioManager.isSpeakerphoneOn();
        } catch (Throwable th) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "audioManager.isSpeakerphoneOn() exception: " + th.getMessage(), "");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeakerphone(boolean z) {
        if (this.audioManager != null) {
            try {
                this.audioManager.setSpeakerphoneOn(z);
            } catch (Throwable th) {
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "audioManager.setSpeakerphoneOn() exception: " + th.getMessage(), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean isSpeakerphone() {
        if (this.audioManager == null) {
            return null;
        }
        try {
            return Boolean.valueOf(this.audioManager.isSpeakerphoneOn());
        } catch (Throwable th) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "audioManager.isSpeakerphoneOn() exception: " + th.getMessage(), "");
            return null;
        }
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

    public void openSpeaker() {
        if (this.audioManager != null && l.zH != 2) {
            if (TbadkCoreApplication.m9getInst().isHeadsetModeOn() || TbadkCoreApplication.m9getInst().getIsPhoneCalling()) {
                setSpeakerphone(false);
                this.bSpeakerphoneOn = false;
                return;
            }
            try {
                saveInitVoiceStatus();
                setSpeakerphone(true);
                l.zI = 3;
                stopVoiceAndRePlay();
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "openSpeaker exception: " + e.getMessage(), "");
            }
        }
    }

    public void closeSpeaker() {
        if (this.audioManager != null) {
            saveInitVoiceStatus();
            try {
                setSpeakerphone(false);
                l.zI = 0;
                stopVoiceAndRePlay();
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "closeSpeaker exception: " + e.getMessage(), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolumeControlStream() {
        try {
            if (this.context != null && this.context.getPageActivity() != null) {
                this.context.getPageActivity().setVolumeControlStream(l.zI);
            }
        } catch (Exception e) {
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_VOLUME, "setVolumeControlStream exception: " + e.getMessage(), "");
        }
    }

    private void stopVoiceAndRePlay_new() {
        if (this.context != null) {
            if (this.mHandle != null) {
                this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
            }
            b playView = getPlayView();
            if (!this.bStopAndReplay && this.mCurPlayModel != null && isVoicePlaying(this.mCurPlayModel.voice_status.intValue()) && playView != null) {
                MediaService.stopAndReplayVoice(this.context.getPageActivity());
            }
        }
    }

    private void stopVoiceAndRePlay() {
        if (this.context != null) {
            if (this.mHandle != null) {
                this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
            }
            b playView = getPlayView();
            if (!this.bStopAndReplay && this.mCurPlayModel != null && isVoicePlaying(this.mCurPlayModel.voice_status.intValue()) && playView != null) {
                this.bStopAndReplay = true;
                if (bUseMedaiPlayer) {
                    MediaService.stopPlay(this.context.getPageActivity());
                } else {
                    stopPlay();
                }
            }
        }
    }

    public void restoreVoiceMode() {
        this.bStopAndReplay = false;
        if (this.audioManager != null) {
            try {
                if (bInitSpeakerphoneOn != null && bInitMode != null && bInitVolume != null) {
                    setSpeakerphone(bInitSpeakerphoneOn.booleanValue());
                    l.zI = 3;
                    bInitSpeakerphoneOn = null;
                    bInitMode = null;
                    bInitVolume = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SPEAKER, "restoreVoiceMode exception: " + e.getMessage(), "");
            }
        }
    }

    public void setSpeakerphoneOn(boolean z) {
        if (this.audioManager != null) {
            if (this.bSpeakerphoneOn == null || this.bSpeakerphoneOn.booleanValue() != z) {
                this.bSpeakerphoneOn = Boolean.valueOf(z);
                if (this.mHandle != null) {
                    this.mHandle.removeCallbacks(this.setSpeakerphoneOnRunnable);
                    this.mHandle.postDelayed(this.setSpeakerphoneOnRunnable, 300L);
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 8 && !this.b_HEADSET_PLUG && this.bAllowChangeVoiceMode) {
            float[] fArr = sensorEvent.values;
            if (fArr.length > 0) {
                float f = fArr[0];
                if (!mi3Filter(f)) {
                    if (f < eym) {
                        setSpeakerphoneOn(false);
                        addBlackScreen();
                    } else if (f > eym) {
                        removeBlackScreen();
                        setSpeakerphoneOn(true);
                    }
                }
            }
        }
    }

    private boolean mi3Filter(float f) {
        return Build.MODEL.equals(MI3_MODEL_NAME) && this.sensorRegisterTime + 300 > new Date().getTime();
    }

    private void registSensor() {
        if (!this.bSensorRegistered && this.proximitySensor != null) {
            if (this.mHandle != null) {
                this.mHandle.removeCallbacks(this.unRegistSensorRunnable);
            }
            this.bSensorRegistered = true;
            this.sensorManager.registerListener(this, this.proximitySensor, 3);
            this.sensorRegisterTime = new Date().getTime();
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
            } catch (Exception e) {
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UNREGISTSENSOR, "unRegistSensor exception: " + e.getMessage(), "");
            }
            this.bSensorRegistered = false;
        }
    }

    private void unRegistSensorHandler() {
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.unRegistSensorRunnable);
            this.mHandle.postDelayed(this.unRegistSensorRunnable, 1000L);
        }
    }

    private void registPlugin(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
    }

    private void unRegistPlugin(Context context) {
        if (context != null) {
            try {
                context.unregisterReceiver(this);
                setSpeakerphone(this.mPhoneSpeaker);
                this.mHandle.removeCallbacks(this.unRegistSensorRunnable);
                unRegistSensor();
            } catch (IllegalArgumentException e) {
            } catch (Exception e2) {
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_UNREGISTPLUGIN, "unRegistPlugin exception: " + e2.getMessage(), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        private a() {
        }

        /* synthetic */ a(VoiceManager voiceManager, a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1373=4, 1374=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception e) {
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        k kVar = new k();
                        kVar.n("path", "/sys/class/switch/h2w/state");
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), kVar.toString());
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception e3) {
                            }
                        }
                        return null;
                    } catch (Exception e4) {
                        e = e4;
                        k kVar2 = new k();
                        kVar2.n("path", "/sys/class/switch/h2w/state");
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "CheckHeadsetPlugAsyncTask exception: " + e.getMessage(), kVar2.toString());
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception e5) {
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            fileReader2.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                fileReader = null;
            } catch (Exception e8) {
                e = e8;
                fileReader = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                throw th;
            }
            return null;
        }
    }

    private void checkHeadsetPlug() {
        if (this.audioManager != null) {
            try {
                this.b_HEADSET_PLUG = this.audioManager.isWiredHeadsetOn();
                if (this.b_HEADSET_PLUG) {
                    setSpeakerphone(false);
                }
            } catch (Throwable th) {
                a aVar = new a(this, null);
                aVar.setSelfExecute(true);
                aVar.execute(new Void[0]);
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_HEADSET, "checkHeadsetPlug exception: " + th.getMessage(), "");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            this.b_HEADSET_PLUG = intent.getIntExtra("state", 0) == 1;
            if (this.b_HEADSET_PLUG) {
                setSpeakerphone(false);
            }
        }
    }

    public static String formatVoiceTime(int i) {
        StringBuffer stringBuffer = new StringBuffer(10);
        if (i <= 0) {
            return "0\"";
        }
        int i2 = i % 60;
        int i3 = i / 60;
        if (i3 > 0) {
            stringBuffer.append(i3).append("'");
        }
        stringBuffer.append(i2).append("\"");
        return stringBuffer.toString();
    }

    private void addBlackScreen() {
        if (this.context != null) {
            if (this.windowParams == null) {
                this.windowParams = new WindowManager.LayoutParams();
                this.windowParams.width = -1;
                this.windowParams.height = -1;
            }
            if (this.screenView == null) {
                this.screenView = new View(this.context.getPageActivity());
                this.screenView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
            if (this.windowManager == null) {
                this.windowManager = (WindowManager) this.context.getContext().getSystemService("window");
            }
            if (com.baidu.adp.lib.g.j.a(this.context)) {
                if (!this.isAddScreenView) {
                    this.windowManager.addView(this.screenView, this.windowParams);
                }
                this.isAddScreenView = true;
            }
        }
    }

    private void removeBlackScreen() {
        if (this.windowManager != null && this.screenView != null && this.isAddScreenView) {
            this.windowManager.removeView(this.screenView);
        }
        this.isAddScreenView = false;
    }
}
