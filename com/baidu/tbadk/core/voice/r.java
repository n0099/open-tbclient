package com.baidu.tbadk.core.voice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends BroadcastReceiver {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VoiceData.VoiceModel voiceModel;
        x o;
        VoiceData.VoiceModel voiceModel2;
        VoiceData.VoiceModel voiceModel3;
        String a;
        VoiceData.VoiceModel voiceModel4;
        VoiceData.VoiceModel voiceModel5;
        VoiceData.VoiceModel voiceModel6;
        VoiceData.VoiceModel voiceModel7;
        x o2;
        VoiceData.VoiceModel voiceModel8;
        boolean z;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceData.VoiceModel voiceModel9;
        x o3;
        VoiceData.VoiceModel voiceModel10;
        VoiceData.VoiceModel voiceModel11;
        VoiceData.VoiceModel voiceModel12;
        Handler handler4;
        VoiceData.VoiceModel voiceModel13;
        VoiceData.VoiceModel voiceModel14;
        VoiceData.VoiceModel voiceModel15;
        VoiceData.VoiceModel voiceModel16;
        x o4;
        VoiceData.VoiceModel voiceModel17;
        Handler handler5;
        Runnable runnable;
        int i = 0;
        voiceModel = this.a.u;
        if (voiceModel != null && intent != null) {
            String action = intent.getAction();
            if (action.equals("com.baidu.isPlaying")) {
                this.a.t();
                if (intent.getBooleanExtra("com.baidu.msg.isPlaying", false)) {
                    voiceModel12 = this.a.u;
                    if (voiceModel12 != null) {
                        handler4 = this.a.p;
                        if (handler4 != null) {
                            handler5 = this.a.p;
                            runnable = this.a.K;
                            handler5.removeCallbacks(runnable);
                        }
                        try {
                            voiceModel16 = this.a.u;
                            voiceModel16.voice_status = 3;
                            o4 = this.a.o();
                            if (o4 != null) {
                                voiceModel17 = this.a.u;
                                o4.a(voiceModel17);
                            }
                        } catch (Exception e) {
                            com.baidu.tbadk.core.util.v vVar = new com.baidu.tbadk.core.util.v();
                            voiceModel13 = this.a.u;
                            if (voiceModel13 != null) {
                                voiceModel14 = this.a.u;
                                vVar.a("id", voiceModel14.getId());
                                voiceModel15 = this.a.u;
                                vVar.a("from", voiceModel15.from);
                            }
                            TiebaStatic.b("", -1112, "mVoicePlayerReceiver.onReceive exception: " + e.getMessage(), vVar.toString());
                        }
                    }
                }
            } else if (action.equals("com.baidu.playElapsedTime")) {
                int intExtra = intent.getIntExtra("com.baidu.msg.playElapsedTime", 0);
                o3 = this.a.o();
                if (o3 != null) {
                    o3.a(intExtra);
                }
                voiceModel10 = this.a.u;
                if (voiceModel10 != null) {
                    voiceModel11 = this.a.u;
                    voiceModel11.elapse = intExtra;
                }
            } else if (action.equals("com.baidu.isStoped")) {
                o2 = this.a.o();
                voiceModel8 = this.a.u;
                if (voiceModel8 != null) {
                    z = this.a.J;
                    if (!z) {
                        this.a.q();
                        VoiceManager voiceManager = this.a;
                        voiceModel9 = this.a.u;
                        voiceManager.b(voiceModel9);
                        this.a.x = null;
                    }
                    this.a.u = null;
                    z2 = this.a.J;
                    if (z2 && o2 != null) {
                        VoiceData.VoiceModel voiceModel18 = o2.getVoiceModel();
                        if (voiceModel18 != null) {
                            voiceModel18.curr_time = intent.getIntExtra("com.baidu.msg.curr_time", 0);
                        }
                        handler = this.a.p;
                        if (handler != null) {
                            handler2 = this.a.p;
                            handler2.removeCallbacks(this.a.j);
                            handler3 = this.a.p;
                            handler3.postDelayed(this.a.j, 200L);
                        }
                    }
                }
            } else if (action.equals("com.baidu.playPrepared")) {
                int intExtra2 = intent.getIntExtra("com.baidu.playPrepared_err_code", -1);
                if (intExtra2 == -1) {
                    voiceModel4 = this.a.u;
                    if (voiceModel4 != null) {
                        voiceModel7 = this.a.u;
                        i = voiceModel7.duration * LocationClientOption.MIN_SCAN_SPAN;
                    }
                    long longExtra = intent.getLongExtra("com.baidu.msg.durationTime2", i);
                    Log.d("testVoice", "duration_msec=" + longExtra);
                    if (longExtra > 900) {
                        voiceModel5 = this.a.u;
                        if (voiceModel5 != null) {
                            voiceModel6 = this.a.u;
                            voiceModel6.duration2 = (int) longExtra;
                        }
                    }
                    this.a.o();
                    com.baidu.tbadk.core.voice.service.a.a(context);
                    return;
                }
                o = this.a.o();
                if (o != null) {
                    if (intExtra2 == 2) {
                        a = ae.a(com.baidu.tbadk.l.voice_err_io);
                    } else {
                        a = ae.a(com.baidu.tbadk.l.voice_err_play);
                    }
                    o.a(5, a);
                }
                voiceModel2 = this.a.u;
                if (voiceModel2 != null) {
                    VoiceManager voiceManager2 = this.a;
                    voiceModel3 = this.a.u;
                    voiceManager2.b(voiceModel3);
                    this.a.u = null;
                }
            } else {
                action.equalsIgnoreCase("com.baidu.recognize");
            }
        }
    }
}
