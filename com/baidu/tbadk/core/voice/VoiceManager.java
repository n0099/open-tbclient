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
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.z;
import java.io.File;
/* loaded from: classes.dex */
public class VoiceManager extends BroadcastReceiver implements SensorEventListener {
    public static final boolean BOOLEAN_SEEKTO = false;
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
    n recordView;
    private m sNewPlayView;
    private m sPlayView;
    private View screenView;
    private WindowManager windowManager;
    private WindowManager.LayoutParams windowParams;
    private static boolean bUseMedaiPlayer = false;
    private static boolean bInitConfig = false;
    private static boolean bVoiceUseSoftDecoder = false;
    private static float eym = 0.5f;
    String mCurRecordVid = null;
    private boolean bSensorRegistered = false;
    private final Runnable startPlayRunnable = new a(this);
    private VoiceData.VoiceModel mCurPlayModel = null;
    private VoiceData.VoiceModel mNewClickModel = null;
    private p mPlayCall = null;
    private com.baidu.adp.lib.f.c<com.baidu.tbadk.core.voice.a.a> mResourceCall = null;
    Runnable stopingRecorderRunnable = new b(this);
    SensorManager sensorManager = null;
    Sensor proximitySensor = null;
    private boolean bAllowChangeVoiceMode = true;
    private int currRecordState = 1;
    private com.baidu.adp.lib.voice.p mRecoreCall = null;
    private boolean bStopAndReplay = false;
    Runnable stopVoiceAndRePlayRunnable = new c(this);
    Runnable setSpeakerphoneOnRunnable = new d(this);
    private final Runnable unRegistSensorRunnable = new e(this);
    boolean b_HEADSET_PLUG = false;
    private final BroadcastReceiver mVoicePlayerReceiver = new f(this);

    /* loaded from: classes.dex */
    public enum PlayMode {
        SPEAKER,
        HEADSET;

        /* JADX DEBUG: Replace access to removed values field (Om) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PlayMode[] valuesCustom() {
            PlayMode[] valuesCustom = values();
            int length = valuesCustom.length;
            PlayMode[] playModeArr = new PlayMode[length];
            System.arraycopy(valuesCustom, 0, playModeArr, 0, length);
            return playModeArr;
        }
    }

    public static synchronized void initConfig() {
        synchronized (VoiceManager.class) {
            if (!bInitConfig) {
                bVoiceUseSoftDecoder = com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("voice_use_soft_decoder", com.baidu.adp.lib.voice.q.fL());
            }
        }
    }

    public static boolean isVoiceUseSoftDecoder() {
        return bVoiceUseSoftDecoder;
    }

    public static void setVoiceUseSoftDecoder(boolean z) {
        bVoiceUseSoftDecoder = true;
        com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("voice_use_soft_decoder", bVoiceUseSoftDecoder);
    }

    public static VoiceManager instance() {
        return new VoiceManager();
    }

    public VoiceManager() {
        initConfig();
        bUseMedaiPlayer = isVoiceUseSoftDecoder() ? false : true;
    }

    public boolean startRecord(n nVar, int i) {
        if (nVar == null) {
            return false;
        }
        this.recordView = nVar;
        if (!s.bL()) {
            String os = s.os();
            if (os == null) {
                os = this.context.getString(z.voice_error_sdcard);
            }
            this.recordView.onShowErr(0, os);
            return false;
        }
        stopPlay();
        this.mCurRecordVid = r.qU();
        String cU = r.cU(this.mCurRecordVid);
        if (this.mRecoreCall == null) {
            this.mRecoreCall = new q(this, null);
        }
        com.baidu.adp.lib.voice.f.stop();
        releaseWakeLock();
        boolean a = com.baidu.adp.lib.voice.f.a(cU, i, this.mRecoreCall);
        if (a) {
            this.recordView.onStartedRecorder(true);
            this.currRecordState = 2;
            acquireWakeLock();
            return a;
        }
        this.currRecordState = 1;
        com.baidu.adp.lib.voice.f.stop();
        com.baidu.tbadk.core.util.r rVar = new com.baidu.tbadk.core.util.r();
        rVar.h("voiceType", Integer.valueOf(i));
        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", rVar.toString());
        this.recordView.onStartedRecorder(false);
        return a;
    }

    public void cancelRecord() {
        com.baidu.adp.lib.voice.f.cancel();
    }

    public void delRecord(String str) {
        stopRecord();
        stopPlay();
        if (this.recordView != null) {
            this.recordView.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new g(this, str), 200L);
        }
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
        m playView = getPlayView();
        if (playView != null) {
            playView.a(voiceModel);
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
            com.baidu.tbadk.core.util.r rVar = new com.baidu.tbadk.core.util.r();
            if (voiceModel != null) {
                rVar.h("id", voiceModel.getId());
                rVar.h("from", voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_PAUSE, "VoiceManager.setPlayWaiting() error : " + e.toString(), rVar.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloading(VoiceData.VoiceModel voiceModel) {
        BdUniqueId bdUniqueId = null;
        try {
            if (this.mResourceCall == null) {
                this.mResourceCall = new h(this);
            }
            Object cV = r.cV(voiceModel.getId());
            if (cV == null) {
                if (this.context != null && (this.context.getOrignalPage() instanceof com.baidu.adp.base.l)) {
                    bdUniqueId = ((com.baidu.adp.base.l) this.context.getOrignalPage()).getUniqueId();
                }
                cV = com.baidu.adp.lib.f.d.ec().a(voiceModel.getId(), 23, this.mResourceCall, 0, 0, bdUniqueId, voiceModel.from);
            }
            if (voiceModel.isLocal && cV == null) {
                if (this.mPlayCall == null) {
                    this.mPlayCall = new p(this, null);
                }
                this.mPlayCall.error(5, com.baidu.adp.lib.voice.q.getString(z.voice_err_no_file));
                com.baidu.tbadk.core.util.r rVar = new com.baidu.tbadk.core.util.r();
                if (voiceModel != null) {
                    rVar.h("id", voiceModel.getId());
                    rVar.h("from", voiceModel.from);
                }
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "VoiceManager.setDownloading() error : record file not exists", rVar.toString());
            } else if (cV != null) {
                setPlaying(voiceModel, (String) cV);
            } else {
                voiceModel.voice_status = 2;
                m playView = getPlayView();
                if (playView != null) {
                    playView.a(voiceModel);
                }
            }
        } catch (Exception e) {
            com.baidu.tbadk.core.util.r rVar2 = new com.baidu.tbadk.core.util.r();
            if (voiceModel != null) {
                rVar2.h("id", voiceModel.getId());
                rVar2.h("from", voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_DOWN, "setMsgDownloading error: " + e.getMessage(), rVar2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m getPlayView() {
        if (this.sPlayView == null) {
            return null;
        }
        m realView = this.sPlayView.getRealView();
        if (realView == null) {
            return this.sPlayView;
        }
        return realView;
    }

    private void putPlayView(m mVar) {
        this.sPlayView = mVar;
    }

    public void resetPlayView(m mVar) {
        if (mVar != null && isPlayDoing(mVar.getVoiceModel())) {
            putPlayView(mVar);
        }
    }

    public void startPlay(m mVar) {
        if (mVar != null) {
            if (this.mHandle != null) {
                this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
            }
            this.bStopAndReplay = false;
            VoiceData.VoiceModel voiceModel = mVar.getVoiceModel();
            if (voiceModel != null) {
                if (this.bSpeaker != null && this.bSpeaker.booleanValue()) {
                    setSpeakerphone(this.bSpeaker.booleanValue());
                    this.bSpeaker = null;
                }
                this.sNewPlayView = mVar;
                this.mNewClickModel = voiceModel;
                int i = 1;
                if (this.mNewClickModel.voice_status != null) {
                    i = this.mNewClickModel.voice_status.intValue();
                }
                if (this.mCurPlayModel != null) {
                    this.mCurPlayModel.curr_time = 0;
                    if (this.mCurPlayModel == this.mNewClickModel) {
                        putPlayView(mVar);
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
                        return;
                    }
                    return;
                }
                putPlayView(mVar);
                this.mCurPlayModel = this.mNewClickModel;
                setDownloading(this.mCurPlayModel);
            }
        }
    }

    private void firstOpenSpeaker() {
        if (this.bFirstSetSpeaker) {
            if (TbadkCoreApplication.m255getInst().isHeadsetModeOn()) {
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
                this.mPlayCall = new p(this, null);
            }
            if (!new File(str).exists()) {
                this.mPlayCall.error(5, com.baidu.adp.lib.voice.q.getString(z.voice_err_no_file));
                return;
            }
            registSensor();
            acquireWakeLock();
            firstOpenSpeaker();
            if (bUseMedaiPlayer) {
                MediaService.preparePlay(this.context.getPageActivity(), str, voiceModel.duration, voiceModel.curr_time);
                voiceModel.curr_time = 0;
                return;
            }
            boolean a = com.baidu.adp.lib.voice.a.a(str, this.mPlayCall, voiceModel.curr_time);
            voiceModel.curr_time = 0;
            if (!a) {
                com.baidu.tbadk.core.util.r rVar = new com.baidu.tbadk.core.util.r();
                rVar.h("file", str);
                if (voiceModel != null) {
                    rVar.h("id", voiceModel.getId());
                    rVar.h("from", voiceModel.from);
                }
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "setMsgPlaying error: AmrAudioPlayer.start", rVar.toString());
                return;
            }
            voiceModel.voice_status = 3;
            m playView = getPlayView();
            if (playView != null) {
                playView.a(voiceModel);
            }
            setVolumeControlStream();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            com.baidu.tbadk.core.util.r rVar2 = new com.baidu.tbadk.core.util.r();
            rVar2.h("file", str);
            if (voiceModel != null) {
                rVar2.h("id", voiceModel.getId());
                rVar2.h("from", voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "setMsgPlaying error: " + e.getMessage(), rVar2.toString());
        }
    }

    private void release() {
        stopRecord();
        stopPlay();
        restoreVoiceMode();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
            unRegistPlugin(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.stopingRecorderRunnable);
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
        this.context = null;
        this.recordView = null;
        this.sPlayView = null;
        this.sNewPlayView = null;
        this.mCurPlayModel = null;
        this.mNewClickModel = null;
        this.mHandle = null;
        this.audioManager = null;
    }

    public void stopRecord() {
        com.baidu.adp.lib.voice.f.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.stopingRecorderRunnable, 100L);
        }
        releaseWakeLock();
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
        this.sensorManager = (SensorManager) tbPageContext.getContext().getSystemService("sensor");
        this.proximitySensor = this.sensorManager.getDefaultSensor(8);
        this.mCurPlayModel = null;
        this.mNewClickModel = null;
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
    }

    public void onPause(TbPageContext<?> tbPageContext) {
        onPause(tbPageContext, true);
    }

    public void onPause(TbPageContext<?> tbPageContext, boolean z) {
        if (z) {
            forceStop();
        }
    }

    public void forceStop() {
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

    public void onSaveInstanceState(Activity activity) {
    }

    public void onStop(TbPageContext<?> tbPageContext) {
        forceStop();
        restoreVoiceMode();
    }

    public void onDestory(TbPageContext<?> tbPageContext) {
        if (this.mCurPlayModel != null) {
            com.baidu.adp.lib.f.d.ec().e(this.mCurPlayModel.getId(), 23);
        }
        release();
        if (bUseMedaiPlayer) {
            MediaService.unregisterReceiver(tbPageContext.getPageActivity(), this.mVoicePlayerReceiver);
        }
    }

    public boolean isAllowRecord() {
        return this.currRecordState == 1;
    }

    public boolean isDoingMd5Record() {
        return this.currRecordState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doVoiceFileMd5(String str, int i) {
        if (str != null && i >= 1) {
            this.currRecordState = 3;
            new Thread(new i(this, str, i)).start();
        }
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
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SPEAKER, "audioManager.isSpeakerphoneOn() exception: " + th.getMessage(), "");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeakerphone(boolean z) {
        if (this.audioManager != null) {
            try {
                this.audioManager.setSpeakerphoneOn(z);
            } catch (Throwable th) {
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SPEAKER, "audioManager.setSpeakerphoneOn() exception: " + th.getMessage(), "");
            }
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
        if (this.audioManager != null && this.currRecordState != 2) {
            if (TbadkCoreApplication.m255getInst().isHeadsetModeOn() || TbadkCoreApplication.m255getInst().getIsPhoneCalling()) {
                setSpeakerphone(false);
                return;
            }
            try {
                saveInitVoiceStatus();
                setSpeakerphone(true);
                com.baidu.adp.lib.voice.q.oH = 3;
                stopVoiceAndRePlay();
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SPEAKER, "openSpeaker exception: " + e.getMessage(), "");
            }
        }
    }

    public void closeSpeaker() {
        if (this.audioManager != null) {
            saveInitVoiceStatus();
            try {
                setSpeakerphone(false);
                com.baidu.adp.lib.voice.q.oH = 0;
                stopVoiceAndRePlay();
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SPEAKER, "closeSpeaker exception: " + e.getMessage(), "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolumeControlStream() {
        try {
            if (this.context != null && this.context.getPageActivity() != null) {
                this.context.getPageActivity().setVolumeControlStream(com.baidu.adp.lib.voice.q.oH);
            }
        } catch (Exception e) {
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_VOLUME, "setVolumeControlStream exception: " + e.getMessage(), "");
        }
    }

    private void stopVoiceAndRePlay_new() {
        if (this.context != null) {
            if (this.mHandle != null) {
                this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
            }
            m playView = getPlayView();
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
            m playView = getPlayView();
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
        if (this.audioManager != null && com.baidu.adp.lib.voice.q.fM()) {
            try {
                if (bInitSpeakerphoneOn != null && bInitMode != null && bInitVolume != null) {
                    setSpeakerphone(bInitSpeakerphoneOn.booleanValue());
                    com.baidu.adp.lib.voice.q.oH = 3;
                    bInitSpeakerphoneOn = null;
                    bInitMode = null;
                    bInitVolume = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SPEAKER, "restoreVoiceMode exception: " + e.getMessage(), "");
            }
        }
    }

    public void setSpeakerphoneOn(boolean z) {
        if (this.audioManager != null && com.baidu.adp.lib.voice.q.fM()) {
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
        if (!this.b_HEADSET_PLUG && this.bAllowChangeVoiceMode) {
            float[] fArr = sensorEvent.values;
            if (sensorEvent.sensor.getType() == 8 && fArr.length > 0) {
                float f = fArr[0];
                if (f < eym || f < this.proximitySensor.getMaximumRange()) {
                    setSpeakerphoneOn(false);
                    addBlackScreen();
                } else if (f > eym) {
                    removeBlackScreen();
                    setSpeakerphoneOn(true);
                }
            }
        }
    }

    private void registSensor() {
        if (!TbadkCoreApplication.m255getInst().isHeadsetModeOn() && !this.bSensorRegistered && this.proximitySensor != null && com.baidu.adp.lib.voice.q.fM()) {
            if (this.mHandle != null) {
                this.mHandle.removeCallbacks(this.unRegistSensorRunnable);
            }
            this.bSensorRegistered = true;
            this.sensorManager.registerListener(this, this.proximitySensor, 3);
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
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_UNREGISTSENSOR, "unRegistSensor exception: " + e.getMessage(), "");
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
                setSpeakerphone(false);
                this.mHandle.removeCallbacks(this.unRegistSensorRunnable);
                unRegistSensor();
            } catch (IllegalArgumentException e) {
            } catch (Exception e2) {
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_UNREGISTPLUGIN, "unRegistPlugin exception: " + e2.getMessage(), "");
            }
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
                l lVar = new l(this, null);
                lVar.setSelfExecute(true);
                lVar.execute(new Void[0]);
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_HEADSET, "checkHeadsetPlug exception: " + th.getMessage(), "");
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
        if (com.baidu.adp.lib.g.k.a(this.context)) {
            if (!this.isAddScreenView) {
                this.windowManager.addView(this.screenView, this.windowParams);
            }
            this.isAddScreenView = true;
        }
    }

    private void removeBlackScreen() {
        if (this.windowManager != null && this.screenView != null && this.isAddScreenView) {
            this.windowManager.removeView(this.screenView);
        }
        this.isAddScreenView = false;
    }
}
