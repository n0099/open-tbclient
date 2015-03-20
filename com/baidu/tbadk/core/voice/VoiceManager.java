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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.y;
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
    private CustomResponsedMessage<com.baidu.tieba.tbadkCore.voice.a> mRecorderManagerRespMsg;
    private i sNewPlayView;
    private i sPlayView;
    private View screenView;
    private WindowManager windowManager;
    private WindowManager.LayoutParams windowParams;
    private static boolean bUseMedaiPlayer = false;
    private static boolean bInitConfig = false;
    private static boolean bVoiceUseSoftDecoder = false;
    private static float eym = 0.5f;
    private boolean bSensorRegistered = false;
    private final Runnable startPlayRunnable = new a(this);
    private VoiceData.VoiceModel mCurPlayModel = null;
    private VoiceData.VoiceModel mNewClickModel = null;
    private k mPlayCall = null;
    private com.baidu.adp.lib.f.c<com.baidu.tbadk.core.voice.a.a> mResourceCall = null;
    SensorManager sensorManager = null;
    Sensor proximitySensor = null;
    private boolean bAllowChangeVoiceMode = true;
    private boolean bStopAndReplay = false;
    Runnable stopVoiceAndRePlayRunnable = new b(this);
    Runnable setSpeakerphoneOnRunnable = new c(this);
    private final Runnable unRegistSensorRunnable = new d(this);
    boolean b_HEADSET_PLUG = false;
    private final BroadcastReceiver mVoicePlayerReceiver = new e(this);

    /* loaded from: classes.dex */
    public enum PlayMode {
        SPEAKER,
        HEADSET;

        /* JADX DEBUG: Replace access to removed values field (Zp) with 'values()' method */
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
                bVoiceUseSoftDecoder = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("voice_use_soft_decoder", com.baidu.adp.lib.voice.l.jj());
            }
        }
    }

    public static boolean isVoiceUseSoftDecoder() {
        return bVoiceUseSoftDecoder;
    }

    public static void setVoiceUseSoftDecoder(boolean z) {
        bVoiceUseSoftDecoder = true;
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("voice_use_soft_decoder", bVoiceUseSoftDecoder);
    }

    public static VoiceManager instance() {
        return new VoiceManager();
    }

    public VoiceManager() {
        this.mRecorderManagerRespMsg = null;
        initConfig();
        bUseMedaiPlayer = isVoiceUseSoftDecoder() ? false : true;
        this.mRecorderManagerRespMsg = MessageManager.getInstance().runTask(2001278, com.baidu.tieba.tbadkCore.voice.a.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001280, new f(this));
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
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
        com.baidu.adp.lib.voice.l.zJ = 2;
        setVolumeControlStream();
        i playView = getPlayView();
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
            n nVar = new n();
            if (voiceModel != null) {
                nVar.h("id", voiceModel.getId());
                nVar.h("from", voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_PAUSE, "VoiceManager.setPlayWaiting() error : " + e.toString(), nVar.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloading(VoiceData.VoiceModel voiceModel) {
        BdUniqueId bdUniqueId = null;
        try {
            if (this.mResourceCall == null) {
                this.mResourceCall = new g(this);
            }
            Object db = l.db(voiceModel.getId());
            if (db == null) {
                if (this.context != null && (this.context.getOrignalPage() instanceof com.baidu.adp.base.l)) {
                    bdUniqueId = ((com.baidu.adp.base.l) this.context.getOrignalPage()).getUniqueId();
                }
                db = com.baidu.adp.lib.f.d.hB().a(voiceModel.getId(), 23, this.mResourceCall, 0, 0, bdUniqueId, voiceModel.from);
            }
            if (voiceModel.isLocal && db == null) {
                if (this.mPlayCall == null) {
                    this.mPlayCall = new k(this, null);
                }
                this.mPlayCall.error(5, com.baidu.adp.lib.voice.l.getString(y.voice_err_no_file));
                n nVar = new n();
                if (voiceModel != null) {
                    nVar.h("id", voiceModel.getId());
                    nVar.h("from", voiceModel.from);
                }
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "VoiceManager.setDownloading() error : record file not exists", nVar.toString());
            } else if (db != null) {
                setPlaying(voiceModel, (String) db);
            } else {
                voiceModel.voice_status = 2;
                i playView = getPlayView();
                if (playView != null) {
                    playView.b(voiceModel);
                }
            }
        } catch (Exception e) {
            n nVar2 = new n();
            if (voiceModel != null) {
                nVar2.h("id", voiceModel.getId());
                nVar2.h("from", voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_DOWN, "setMsgDownloading error: " + e.getMessage(), nVar2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i getPlayView() {
        if (this.sPlayView == null) {
            return null;
        }
        i realView = this.sPlayView.getRealView();
        if (realView == null) {
            return this.sPlayView;
        }
        return realView;
    }

    private void putPlayView(i iVar) {
        this.sPlayView = iVar;
    }

    public void resetPlayView(i iVar) {
        if (iVar != null && isPlayDoing(iVar.getVoiceModel())) {
            putPlayView(iVar);
        }
    }

    public void startPlay(i iVar) {
        if (iVar != null) {
            if (this.mHandle != null) {
                this.mHandle.removeCallbacks(this.stopVoiceAndRePlayRunnable);
            }
            this.bStopAndReplay = false;
            VoiceData.VoiceModel voiceModel = iVar.getVoiceModel();
            if (voiceModel != null) {
                if (this.bSpeaker != null && this.bSpeaker.booleanValue()) {
                    setSpeakerphone(this.bSpeaker.booleanValue());
                    this.bSpeaker = null;
                }
                this.sNewPlayView = iVar;
                this.mNewClickModel = voiceModel;
                int i = 1;
                if (this.mNewClickModel.voice_status != null) {
                    i = this.mNewClickModel.voice_status.intValue();
                }
                if (this.mCurPlayModel != null) {
                    this.mCurPlayModel.curr_time = 0;
                    if (this.mCurPlayModel == this.mNewClickModel) {
                        putPlayView(iVar);
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
                putPlayView(iVar);
                this.mCurPlayModel = this.mNewClickModel;
                setDownloading(this.mCurPlayModel);
            }
        }
    }

    private void firstOpenSpeaker() {
        if (this.bFirstSetSpeaker) {
            if (TbadkCoreApplication.m411getInst().isHeadsetModeOn()) {
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
                this.mPlayCall = new k(this, null);
            }
            if (!new File(str).exists()) {
                this.mPlayCall.error(5, com.baidu.adp.lib.voice.l.getString(y.voice_err_no_file));
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
                n nVar = new n();
                nVar.h("file", str);
                if (voiceModel != null) {
                    nVar.h("id", voiceModel.getId());
                    nVar.h("from", voiceModel.from);
                }
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "setMsgPlaying error: AmrAudioPlayer.start", nVar.toString());
                return;
            }
            voiceModel.voice_status = 3;
            i playView = getPlayView();
            if (playView != null) {
                playView.b(voiceModel);
            }
            com.baidu.adp.lib.voice.l.zJ = 3;
            setVolumeControlStream();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            n nVar2 = new n();
            nVar2.h("file", str);
            if (voiceModel != null) {
                nVar2.h("id", voiceModel.getId());
                nVar2.h("from", voiceModel.from);
            }
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "setMsgPlaying error: " + e.getMessage(), nVar2.toString());
        }
    }

    private void release() {
        stopPlay();
        restoreVoiceMode();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
            unRegistPlugin(this.context.getPageActivity());
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
            com.baidu.adp.lib.f.d.hB().e(this.mCurPlayModel.getId(), 23);
        }
        release();
        if (bUseMedaiPlayer) {
            MediaService.unregisterReceiver(tbPageContext.getPageActivity(), this.mVoicePlayerReceiver);
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
        if (this.audioManager != null && com.baidu.adp.lib.voice.l.zI != 2) {
            if (TbadkCoreApplication.m411getInst().isHeadsetModeOn() || TbadkCoreApplication.m411getInst().getIsPhoneCalling()) {
                setSpeakerphone(false);
                return;
            }
            try {
                saveInitVoiceStatus();
                setSpeakerphone(true);
                com.baidu.adp.lib.voice.l.zJ = 3;
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
                com.baidu.adp.lib.voice.l.zJ = 0;
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
                this.context.getPageActivity().setVolumeControlStream(com.baidu.adp.lib.voice.l.zJ);
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
            i playView = getPlayView();
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
            i playView = getPlayView();
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
                    com.baidu.adp.lib.voice.l.zJ = 3;
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
        if (!this.b_HEADSET_PLUG && this.bAllowChangeVoiceMode && isPlaying()) {
            float[] fArr = sensorEvent.values;
            if (sensorEvent.sensor.getType() == 8 && fArr.length > 0) {
                float f = fArr[0];
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

    private void registSensor() {
        if (!this.bSensorRegistered && this.proximitySensor != null) {
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
                h hVar = new h(this, null);
                hVar.setSelfExecute(true);
                hVar.execute(new Void[0]);
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
