package com.baidu.tbadk.core.voice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BroadcastReceiver {
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VoiceData.VoiceModel voiceModel;
        m playView;
        VoiceData.VoiceModel voiceModel2;
        VoiceData.VoiceModel voiceModel3;
        String string;
        VoiceData.VoiceModel voiceModel4;
        m playView2;
        VoiceData.VoiceModel voiceModel5;
        VoiceData.VoiceModel voiceModel6;
        VoiceData.VoiceModel voiceModel7;
        m playView3;
        VoiceData.VoiceModel voiceModel8;
        boolean z;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceData.VoiceModel voiceModel9;
        m playView4;
        VoiceData.VoiceModel voiceModel10;
        VoiceData.VoiceModel voiceModel11;
        VoiceData.VoiceModel voiceModel12;
        Handler handler4;
        VoiceData.VoiceModel voiceModel13;
        VoiceData.VoiceModel voiceModel14;
        VoiceData.VoiceModel voiceModel15;
        VoiceData.VoiceModel voiceModel16;
        m playView5;
        VoiceData.VoiceModel voiceModel17;
        Handler handler5;
        Runnable runnable;
        int i = 0;
        voiceModel = this.this$0.mCurPlayModel;
        if (voiceModel != null && intent != null) {
            String action = intent.getAction();
            if (action.equals("com.baidu.isPlaying")) {
                this.this$0.setVolumeControlStream();
                if (intent.getBooleanExtra("com.baidu.msg.isPlaying", false)) {
                    voiceModel12 = this.this$0.mCurPlayModel;
                    if (voiceModel12 != null) {
                        handler4 = this.this$0.mHandle;
                        if (handler4 != null) {
                            handler5 = this.this$0.mHandle;
                            runnable = this.this$0.unRegistSensorRunnable;
                            handler5.removeCallbacks(runnable);
                        }
                        try {
                            voiceModel16 = this.this$0.mCurPlayModel;
                            voiceModel16.voice_status = 3;
                            playView5 = this.this$0.getPlayView();
                            if (playView5 != null) {
                                voiceModel17 = this.this$0.mCurPlayModel;
                                playView5.a(voiceModel17);
                            }
                        } catch (Exception e) {
                            com.baidu.tbadk.core.util.r rVar = new com.baidu.tbadk.core.util.r();
                            voiceModel13 = this.this$0.mCurPlayModel;
                            if (voiceModel13 != null) {
                                voiceModel14 = this.this$0.mCurPlayModel;
                                rVar.h("id", voiceModel14.getId());
                                voiceModel15 = this.this$0.mCurPlayModel;
                                rVar.h("from", voiceModel15.from);
                            }
                            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_UPDATEVIEW, "mVoicePlayerReceiver.onReceive exception: " + e.getMessage(), rVar.toString());
                        }
                    }
                }
            } else if (action.equals("com.baidu.playElapsedTime")) {
                int intExtra = intent.getIntExtra("com.baidu.msg.playElapsedTime", 0);
                playView4 = this.this$0.getPlayView();
                if (playView4 != null) {
                    playView4.cu(intExtra);
                }
                voiceModel10 = this.this$0.mCurPlayModel;
                if (voiceModel10 != null) {
                    voiceModel11 = this.this$0.mCurPlayModel;
                    voiceModel11.elapse = intExtra;
                }
            } else if (action.equals("com.baidu.isStoped")) {
                playView3 = this.this$0.getPlayView();
                voiceModel8 = this.this$0.mCurPlayModel;
                if (voiceModel8 != null) {
                    z = this.this$0.bStopAndReplay;
                    if (!z) {
                        this.this$0.releaseWakeLock();
                        VoiceManager voiceManager = this.this$0;
                        voiceModel9 = this.this$0.mCurPlayModel;
                        voiceManager.setStatusWaiting(voiceModel9);
                        this.this$0.sPlayView = null;
                    }
                    this.this$0.mCurPlayModel = null;
                    z2 = this.this$0.bStopAndReplay;
                    if (z2 && playView3 != null) {
                        VoiceData.VoiceModel voiceModel18 = playView3.getVoiceModel();
                        if (voiceModel18 != null) {
                            voiceModel18.curr_time = intent.getIntExtra("com.baidu.msg.curr_time", 0);
                        }
                        handler = this.this$0.mHandle;
                        if (handler != null) {
                            handler2 = this.this$0.mHandle;
                            handler2.removeCallbacks(this.this$0.stopVoiceAndRePlayRunnable);
                            handler3 = this.this$0.mHandle;
                            handler3.postDelayed(this.this$0.stopVoiceAndRePlayRunnable, 200L);
                        }
                    }
                }
            } else if (action.equals("com.baidu.playPrepared")) {
                int intExtra2 = intent.getIntExtra("com.baidu.playPrepared_err_code", -1);
                if (intExtra2 == -1) {
                    voiceModel4 = this.this$0.mCurPlayModel;
                    if (voiceModel4 != null) {
                        voiceModel7 = this.this$0.mCurPlayModel;
                        i = voiceModel7.duration * 1000;
                    }
                    long longExtra = intent.getLongExtra("com.baidu.msg.durationTime2", i);
                    Log.d("testVoice", "duration_msec=" + longExtra);
                    if (longExtra > 900) {
                        voiceModel5 = this.this$0.mCurPlayModel;
                        if (voiceModel5 != null) {
                            voiceModel6 = this.this$0.mCurPlayModel;
                            voiceModel6.duration2 = (int) longExtra;
                        }
                    }
                    playView2 = this.this$0.getPlayView();
                    if (playView2 != null) {
                        playView2.qN();
                    }
                    MediaService.startPlay(context);
                    return;
                }
                playView = this.this$0.getPlayView();
                if (playView != null) {
                    if (intExtra2 == 2) {
                        string = com.baidu.adp.lib.voice.q.getString(z.voice_err_io);
                    } else {
                        string = com.baidu.adp.lib.voice.q.getString(z.voice_err_play);
                    }
                    playView.onShowErr(5, string);
                }
                voiceModel2 = this.this$0.mCurPlayModel;
                if (voiceModel2 != null) {
                    VoiceManager voiceManager2 = this.this$0;
                    voiceModel3 = this.this$0.mCurPlayModel;
                    voiceManager2.setStatusWaiting(voiceModel3);
                    this.this$0.mCurPlayModel = null;
                }
            } else {
                action.equalsIgnoreCase("com.baidu.recognize");
            }
        }
    }
}
