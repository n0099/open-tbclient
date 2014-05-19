package com.baidu.tbadk.core.voice;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements j {
    final /* synthetic */ VoiceManager a;

    private aa(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(VoiceManager voiceManager, aa aaVar) {
        this(voiceManager);
    }

    @Override // com.baidu.adp.lib.voice.b
    public void a(String str, int i) {
        x xVar;
        VoiceData.VoiceModel voiceModel;
        boolean z;
        x m;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceData.VoiceModel voiceModel2;
        BdLog.i("VoiceManager", "Voice-Play-Succ", "");
        xVar = this.a.A;
        if (xVar != null) {
            voiceModel = this.a.x;
            if (voiceModel == null) {
                return;
            }
            z = this.a.M;
            if (!z) {
                VoiceManager voiceManager = this.a;
                voiceModel2 = this.a.x;
                voiceManager.b(voiceModel2);
                this.a.A = null;
            }
            this.a.x = null;
            m = this.a.m();
            z2 = this.a.M;
            if (z2 && m != null) {
                VoiceData.VoiceModel voiceModel3 = m.getVoiceModel();
                if (voiceModel3 != null && i >= 0) {
                    voiceModel3.curr_time = i;
                }
                handler = this.a.s;
                if (handler != null) {
                    handler2 = this.a.s;
                    handler2.removeCallbacks(this.a.i);
                    handler3 = this.a.s;
                    handler3.postDelayed(this.a.i, 10L);
                    return;
                }
                return;
            }
            this.a.q();
        }
    }

    @Override // com.baidu.adp.lib.voice.b
    public void a(int i, String str) {
        x xVar;
        x xVar2;
        VoiceData.VoiceModel voiceModel;
        VoiceData.VoiceModel voiceModel2;
        BdLog.e("VoiceManager", "Voice-Play-Fail", " " + i + " " + str);
        TiebaStatic.voiceError("", i, str, "");
        xVar = this.a.A;
        if (xVar != null) {
            xVar2 = this.a.A;
            xVar2.a(i, str);
            voiceModel = this.a.x;
            if (voiceModel != null) {
                VoiceManager voiceManager = this.a;
                voiceModel2 = this.a.x;
                voiceManager.b(voiceModel2);
                this.a.x = null;
            }
            this.a.q();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public void a(int i) {
        x m;
        VoiceData.VoiceModel voiceModel;
        VoiceData.VoiceModel voiceModel2;
        m = this.a.m();
        if (m != null) {
            m.a(i);
        }
        voiceModel = this.a.x;
        if (voiceModel != null) {
            voiceModel2 = this.a.x;
            voiceModel2.elapse = i;
        }
    }
}
