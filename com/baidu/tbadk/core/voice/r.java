package com.baidu.tbadk.core.voice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BroadcastReceiver {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VoiceData.VoiceModel voiceModel;
        x m;
        VoiceData.VoiceModel voiceModel2;
        VoiceData.VoiceModel voiceModel3;
        String a;
        VoiceData.VoiceModel voiceModel4;
        x m2;
        VoiceData.VoiceModel voiceModel5;
        VoiceData.VoiceModel voiceModel6;
        VoiceData.VoiceModel voiceModel7;
        x m3;
        VoiceData.VoiceModel voiceModel8;
        boolean z;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceData.VoiceModel voiceModel9;
        x m4;
        VoiceData.VoiceModel voiceModel10;
        VoiceData.VoiceModel voiceModel11;
        VoiceData.VoiceModel voiceModel12;
        Handler handler4;
        VoiceData.VoiceModel voiceModel13;
        VoiceData.VoiceModel voiceModel14;
        VoiceData.VoiceModel voiceModel15;
        VoiceData.VoiceModel voiceModel16;
        x m5;
        VoiceData.VoiceModel voiceModel17;
        Handler handler5;
        Runnable runnable;
        int i = 0;
        voiceModel = this.a.x;
        if (voiceModel != null && intent != null) {
            String action = intent.getAction();
            if (action.equals("com.baidu.isPlaying")) {
                this.a.t();
                if (intent.getBooleanExtra("com.baidu.msg.isPlaying", false)) {
                    voiceModel12 = this.a.x;
                    if (voiceModel12 != null) {
                        handler4 = this.a.s;
                        if (handler4 != null) {
                            handler5 = this.a.s;
                            runnable = this.a.N;
                            handler5.removeCallbacks(runnable);
                        }
                        try {
                            voiceModel16 = this.a.x;
                            voiceModel16.voice_status = 3;
                            m5 = this.a.m();
                            if (m5 != null) {
                                voiceModel17 = this.a.x;
                                m5.a(voiceModel17);
                            }
                        } catch (Exception e) {
                            com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w();
                            voiceModel13 = this.a.x;
                            if (voiceModel13 != null) {
                                voiceModel14 = this.a.x;
                                wVar.a("id", voiceModel14.getId());
                                voiceModel15 = this.a.x;
                                wVar.a("from", voiceModel15.from);
                            }
                            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_UPDATEVIEW, "mVoicePlayerReceiver.onReceive exception: " + e.getMessage(), wVar.toString());
                        }
                    }
                }
            } else if (action.equals("com.baidu.playElapsedTime")) {
                int intExtra = intent.getIntExtra("com.baidu.msg.playElapsedTime", 0);
                m4 = this.a.m();
                if (m4 != null) {
                    m4.a(intExtra);
                }
                voiceModel10 = this.a.x;
                if (voiceModel10 != null) {
                    voiceModel11 = this.a.x;
                    voiceModel11.elapse = intExtra;
                }
            } else if (action.equals("com.baidu.isStoped")) {
                m3 = this.a.m();
                voiceModel8 = this.a.x;
                if (voiceModel8 != null) {
                    z = this.a.M;
                    if (!z) {
                        this.a.q();
                        VoiceManager voiceManager = this.a;
                        voiceModel9 = this.a.x;
                        voiceManager.b(voiceModel9);
                        this.a.A = null;
                    }
                    this.a.x = null;
                    z2 = this.a.M;
                    if (z2 && m3 != null) {
                        VoiceData.VoiceModel voiceModel18 = m3.getVoiceModel();
                        if (voiceModel18 != null) {
                            voiceModel18.curr_time = intent.getIntExtra("com.baidu.msg.curr_time", 0);
                        }
                        handler = this.a.s;
                        if (handler != null) {
                            handler2 = this.a.s;
                            handler2.removeCallbacks(this.a.i);
                            handler3 = this.a.s;
                            handler3.postDelayed(this.a.i, 200L);
                        }
                    }
                }
            } else if (action.equals("com.baidu.playPrepared")) {
                int intExtra2 = intent.getIntExtra("com.baidu.playPrepared_err_code", -1);
                if (intExtra2 == -1) {
                    voiceModel4 = this.a.x;
                    if (voiceModel4 != null) {
                        voiceModel7 = this.a.x;
                        i = voiceModel7.duration * LocationClientOption.MIN_SCAN_SPAN;
                    }
                    long longExtra = intent.getLongExtra("com.baidu.msg.durationTime2", i);
                    Log.d("testVoice", "duration_msec=" + longExtra);
                    if (longExtra > 900) {
                        voiceModel5 = this.a.x;
                        if (voiceModel5 != null) {
                            voiceModel6 = this.a.x;
                            voiceModel6.duration2 = (int) longExtra;
                        }
                    }
                    m2 = this.a.m();
                    if (m2 != null) {
                        m2.a();
                    }
                    MediaService.a(context);
                    return;
                }
                m = this.a.m();
                if (m != null) {
                    if (intExtra2 == 2) {
                        a = ae.a(com.baidu.tieba.u.voice_err_io);
                    } else {
                        a = ae.a(com.baidu.tieba.u.voice_err_play);
                    }
                    m.a(5, a);
                }
                voiceModel2 = this.a.x;
                if (voiceModel2 != null) {
                    VoiceManager voiceManager2 = this.a;
                    voiceModel3 = this.a.x;
                    voiceManager2.b(voiceModel3);
                    this.a.x = null;
                }
            } else {
                action.equalsIgnoreCase("com.baidu.recognize");
            }
        }
    }
}
