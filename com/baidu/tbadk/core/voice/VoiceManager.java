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
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
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
    Activity context;
    private boolean isAddScreenView;
    private Handler mHandle;
    z recordView;
    private y sNewPlayView;
    private y sPlayView;
    private View screenView;
    private WindowManager windowManager;
    private WindowManager.LayoutParams windowParams;
    private static boolean bUseMedaiPlayer = false;
    private static boolean bInitConfig = false;
    private static boolean bVoiceUseSoftDecoder = false;
    private static float eym = 0.5f;
    public static int CURR_STREAM_TYPE = 3;
    String mCurRecordVid = null;
    private boolean bSensorRegistered = false;
    private final Runnable startPlayRunnable = new m(this);
    private VoiceData.VoiceModel mCurPlayModel = null;
    private VoiceData.VoiceModel mNewClickModel = null;
    private ab mPlayCall = null;
    private com.baidu.adp.lib.resourceLoader.c<com.baidu.tbadk.core.voice.a.a> mResourceCall = null;
    Runnable stopingRecorderRunnable = new n(this);
    SensorManager sensorManager = null;
    Sensor proximitySensor = null;
    private boolean bAllowChangeVoiceMode = true;
    private int currRecordState = 1;
    private l mRecoreCall = null;
    private boolean bStopAndReplay = false;
    Runnable stopVoiceAndRePlayRunnable = new o(this);
    Runnable setSpeakerphoneOnRunnable = new p(this);
    private final Runnable unRegistSensorRunnable = new q(this);
    boolean b_HEADSET_PLUG = false;
    private final BroadcastReceiver mVoicePlayerReceiver = new r(this);

    /* loaded from: classes.dex */
    public enum PlayMode {
        SPEAKER,
        HEADSET;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
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
                bVoiceUseSoftDecoder = com.baidu.tbadk.core.sharedPref.b.a().a("voice_use_soft_decoder", ae.a());
            }
        }
    }

    public static boolean isVoiceUseSoftDecoder() {
        return bVoiceUseSoftDecoder;
    }

    public static void setVoiceUseSoftDecoder(boolean z) {
        bVoiceUseSoftDecoder = true;
        com.baidu.tbadk.core.sharedPref.b.a().c("voice_use_soft_decoder", bVoiceUseSoftDecoder);
    }

    public static VoiceManager instance() {
        return new VoiceManager();
    }

    public VoiceManager() {
        initConfig();
        bUseMedaiPlayer = isVoiceUseSoftDecoder() ? false : true;
    }

    public boolean startRecord(z zVar, int i) {
        if (zVar == null) {
            return false;
        }
        this.recordView = zVar;
        if (!com.baidu.tbadk.core.util.z.a()) {
            String b = com.baidu.tbadk.core.util.z.b();
            if (b == null) {
                b = this.context.getString(com.baidu.tieba.y.voice_error_sdcard);
            }
            this.recordView.a(0, b);
            return false;
        }
        stopPlay();
        this.mCurRecordVid = ad.a();
        String a = ad.a(this.mCurRecordVid);
        if (this.mRecoreCall == null) {
            this.mRecoreCall = new ac(this, null);
        }
        f.a();
        releaseWakeLock();
        boolean a2 = f.a(a, i, this.mRecoreCall);
        if (a2) {
            this.recordView.a(true);
            this.currRecordState = 2;
            acquireWakeLock();
            return a2;
        }
        this.currRecordState = 1;
        f.a();
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y();
        yVar.a("voiceType", Integer.valueOf(i));
        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", yVar.toString());
        this.recordView.a(false);
        return a2;
    }

    public void cancelRecord() {
        f.b();
    }

    public void delRecord(String str) {
        stopRecord();
        stopPlay();
        if (this.recordView != null) {
            this.recordView.a(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new s(this, str), 200L);
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
        y playView = getPlayView();
        if (playView != null) {
            playView.a(voiceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayWaiting(VoiceData.VoiceModel voiceModel) {
        if (bUseMedaiPlayer) {
            if (isVoicePlaying(voiceModel.voice_status.intValue())) {
                setStatusWaiting(voiceModel);
                MediaService.stopPlay(this.context);
                return;
            }
            setStatusWaiting(voiceModel);
            return;
        }
        try {
            if (isVoicePlaying(voiceModel.voice_status.intValue())) {
                setStatusWaiting(voiceModel);
                a.a();
            } else {
                setStatusWaiting(voiceModel);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y();
            if (voiceModel != null) {
                yVar.a("id", voiceModel.getId());
                yVar.a(com.baidu.tbadk.core.frameworkData.a.FROM, voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_PAUSE, "VoiceManager.setPlayWaiting() error : " + e.toString(), yVar.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloading(VoiceData.VoiceModel voiceModel) {
        int i = 0;
        try {
            if (this.mResourceCall == null) {
                this.mResourceCall = new t(this);
            }
            Object b = ad.b(voiceModel.getId());
            if (b == null) {
                if (this.context != null && (this.context instanceof com.baidu.adp.base.j)) {
                    i = ((com.baidu.adp.base.j) this.context).getUniqueId();
                }
                b = com.baidu.adp.lib.resourceLoader.d.a().a(voiceModel.getId(), 23, this.mResourceCall, 0, 0, i, voiceModel.from);
            }
            if (voiceModel.isLocal && b == null) {
                if (this.mPlayCall == null) {
                    this.mPlayCall = new ab(this, null);
                }
                this.mPlayCall.a(5, ae.a(com.baidu.tieba.y.voice_err_no_file));
                com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y();
                if (voiceModel != null) {
                    yVar.a("id", voiceModel.getId());
                    yVar.a(com.baidu.tbadk.core.frameworkData.a.FROM, voiceModel.from);
                }
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "VoiceManager.setDownloading() error : record file not exists", yVar.toString());
            } else if (b != null) {
                setPlaying(voiceModel, (String) b);
            } else {
                voiceModel.voice_status = 2;
                y playView = getPlayView();
                if (playView != null) {
                    playView.a(voiceModel);
                }
            }
        } catch (Exception e) {
            com.baidu.tbadk.core.util.y yVar2 = new com.baidu.tbadk.core.util.y();
            if (voiceModel != null) {
                yVar2.a("id", voiceModel.getId());
                yVar2.a(com.baidu.tbadk.core.frameworkData.a.FROM, voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_DOWN, "setMsgDownloading error: " + e.getMessage(), yVar2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public y getPlayView() {
        if (this.sPlayView == null) {
            return null;
        }
        y realView = this.sPlayView.getRealView();
        if (realView == null) {
            return this.sPlayView;
        }
        return realView;
    }

    private void putPlayView(y yVar) {
        this.sPlayView = yVar;
    }

    public void resetPlayView(y yVar) {
        if (yVar != null && isPlayDoing(yVar.getVoiceModel())) {
            putPlayView(yVar);
        }
    }

    public void startPlay(y yVar) {
        if (yVar != null) {
            if (this.mHandle != null) {
                this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
            }
            this.bStopAndReplay = false;
            VoiceData.VoiceModel voiceModel = yVar.getVoiceModel();
            if (voiceModel != null) {
                if (this.bSpeaker != null && this.bSpeaker.booleanValue()) {
                    setSpeakerphone(this.bSpeaker.booleanValue());
                    this.bSpeaker = null;
                }
                this.sNewPlayView = yVar;
                this.mNewClickModel = voiceModel;
                int i = 1;
                if (this.mNewClickModel.voice_status != null) {
                    i = this.mNewClickModel.voice_status.intValue();
                }
                if (this.mCurPlayModel != null) {
                    this.mCurPlayModel.curr_time = 0;
                    if (this.mCurPlayModel == this.mNewClickModel) {
                        putPlayView(yVar);
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
                putPlayView(yVar);
                this.mCurPlayModel = this.mNewClickModel;
                setDownloading(this.mCurPlayModel);
            }
        }
    }

    private void firstOpenSpeaker() {
        if (this.bFirstSetSpeaker) {
            if (TbadkApplication.m252getInst().isHeadsetModeOn()) {
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
                this.mPlayCall = new ab(this, null);
            }
            if (!new File(str).exists()) {
                this.mPlayCall.a(5, ae.a(com.baidu.tieba.y.voice_err_no_file));
                return;
            }
            registSensor();
            acquireWakeLock();
            firstOpenSpeaker();
            if (bUseMedaiPlayer) {
                MediaService.preparePlay(this.context, str, voiceModel.duration, voiceModel.curr_time);
                voiceModel.curr_time = 0;
                return;
            }
            boolean a = a.a(str, this.mPlayCall, voiceModel.curr_time);
            voiceModel.curr_time = 0;
            if (!a) {
                com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y();
                yVar.a("file", str);
                if (voiceModel != null) {
                    yVar.a("id", voiceModel.getId());
                    yVar.a(com.baidu.tbadk.core.frameworkData.a.FROM, voiceModel.from);
                }
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "setMsgPlaying error: AmrAudioPlayer.start", yVar.toString());
                return;
            }
            voiceModel.voice_status = 3;
            y playView = getPlayView();
            if (playView != null) {
                playView.a(voiceModel);
            }
            setVolumeControlStream();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            com.baidu.tbadk.core.util.y yVar2 = new com.baidu.tbadk.core.util.y();
            yVar2.a("file", str);
            if (voiceModel != null) {
                yVar2.a("id", voiceModel.getId());
                yVar2.a(com.baidu.tbadk.core.frameworkData.a.FROM, voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "setMsgPlaying error: " + e.getMessage(), yVar2.toString());
        }
    }

    private void release() {
        stopRecord();
        stopPlay();
        restoreVoiceMode();
        MediaService.stopMy(this.context);
        unRegistPlugin(this.context);
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
        f.a();
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

    public void onCreate(Activity activity) {
        this.context = activity;
        this.mHandle = new Handler();
        this.audioManager = (AudioManager) activity.getSystemService("audio");
        this.sensorManager = (SensorManager) activity.getSystemService("sensor");
        this.proximitySensor = this.sensorManager.getDefaultSensor(8);
        this.mCurPlayModel = null;
        this.mNewClickModel = null;
        if (bUseMedaiPlayer) {
            MediaService.initBroadcastReceivers(activity, this.mVoicePlayerReceiver);
            MediaService.startMy(activity, null);
        }
        checkHeadsetPlug();
    }

    public void onStart(Activity activity) {
    }

    public void onResume(Activity activity) {
        this.bFirstSetSpeaker = true;
        registPlugin(activity);
    }

    public void onPause(Activity activity) {
        onPause(activity, true);
    }

    public void onPause(Activity activity, boolean z) {
        if (z) {
            forceStop();
        }
    }

    public void forceStop() {
        unRegistPlugin(this.context);
        if (bUseMedaiPlayer) {
            if (this.mCurPlayModel != null) {
                setStatusWaiting(this.mCurPlayModel);
                this.mCurPlayModel = null;
            }
            MediaService.stopPlay(this.context);
            return;
        }
        stopPlay();
    }

    public void onSaveInstanceState(Activity activity) {
    }

    public void onStop(Activity activity) {
        forceStop();
        restoreVoiceMode();
    }

    public void onDestory(Activity activity) {
        if (this.mCurPlayModel != null) {
            com.baidu.adp.lib.resourceLoader.d.a().a(this.mCurPlayModel.getId(), 23);
        }
        release();
        if (bUseMedaiPlayer) {
            MediaService.unregisterReceiver(activity, this.mVoicePlayerReceiver);
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
            new Thread(new u(this, str, i)).start();
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
            if (TbadkApplication.m252getInst().isHeadsetModeOn()) {
                setSpeakerphone(false);
                return;
            }
            try {
                saveInitVoiceStatus();
                setSpeakerphone(true);
                CURR_STREAM_TYPE = 3;
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
                CURR_STREAM_TYPE = 0;
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
            if (this.context != null && (this.context instanceof Activity)) {
                this.context.setVolumeControlStream(CURR_STREAM_TYPE);
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
            y playView = getPlayView();
            if (!this.bStopAndReplay && this.mCurPlayModel != null && isVoicePlaying(this.mCurPlayModel.voice_status.intValue()) && playView != null) {
                MediaService.stopAndReplayVoice(this.context);
            }
        }
    }

    private void stopVoiceAndRePlay() {
        if (this.context != null) {
            if (this.mHandle != null) {
                this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
            }
            y playView = getPlayView();
            if (!this.bStopAndReplay && this.mCurPlayModel != null && isVoicePlaying(this.mCurPlayModel.voice_status.intValue()) && playView != null) {
                this.bStopAndReplay = true;
                if (bUseMedaiPlayer) {
                    MediaService.stopPlay(this.context);
                } else {
                    stopPlay();
                }
            }
        }
    }

    public void restoreVoiceMode() {
        this.bStopAndReplay = false;
        if (this.audioManager != null && ae.b()) {
            try {
                if (bInitSpeakerphoneOn != null && bInitMode != null && bInitVolume != null) {
                    setSpeakerphone(bInitSpeakerphoneOn.booleanValue());
                    CURR_STREAM_TYPE = 3;
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
        if (this.audioManager != null && ae.b()) {
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
        if (!TbadkApplication.m252getInst().isHeadsetModeOn() && !this.bSensorRegistered && this.proximitySensor != null && ae.b()) {
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
                x xVar = new x(this, null);
                xVar.setSelfExecute(true);
                xVar.execute(new Void[0]);
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
            this.screenView = new View(this.context);
            this.screenView.setBackgroundColor(-16777216);
        }
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) this.context.getSystemService("window");
        }
        if (!this.isAddScreenView) {
            this.windowManager.addView(this.screenView, this.windowParams);
        }
        this.isAddScreenView = true;
    }

    private void removeBlackScreen() {
        if (this.windowManager != null && this.screenView != null && this.isAddScreenView) {
            this.windowManager.removeView(this.screenView);
        }
        this.isAddScreenView = false;
    }
}
