package com.baidu.tbadk.core.voice;

import android.os.Handler;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements j {
    final /* synthetic */ VoiceManager a;

    private aa(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(VoiceManager voiceManager, byte b) {
        this(voiceManager);
    }

    @Override // com.baidu.adp.lib.voice.b
    public final void a(int i) {
        x xVar;
        VoiceData.VoiceModel voiceModel;
        boolean z;
        x o;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceData.VoiceModel voiceModel2;
        com.baidu.adp.lib.util.f.a("VoiceManager", "Voice-Play-Succ", "");
        xVar = this.a.x;
        if (xVar != null) {
            voiceModel = this.a.u;
            if (voiceModel == null) {
                return;
            }
            z = this.a.J;
            if (!z) {
                VoiceManager voiceManager = this.a;
                voiceModel2 = this.a.u;
                voiceManager.b(voiceModel2);
                this.a.x = null;
            }
            this.a.u = null;
            o = this.a.o();
            z2 = this.a.J;
            if (z2 && o != null) {
                VoiceData.VoiceModel voiceModel3 = o.getVoiceModel();
                if (voiceModel3 != null && i >= 0) {
                    voiceModel3.curr_time = i;
                }
                handler = this.a.p;
                if (handler != null) {
                    handler2 = this.a.p;
                    handler2.removeCallbacks(this.a.j);
                    handler3 = this.a.p;
                    handler3.postDelayed(this.a.j, 10L);
                    return;
                }
                return;
            }
            this.a.q();
        }
    }

    @Override // com.baidu.adp.lib.voice.b
    public final void a(int i, String str) {
        x xVar;
        x xVar2;
        VoiceData.VoiceModel voiceModel;
        VoiceData.VoiceModel voiceModel2;
        com.baidu.adp.lib.util.f.b("VoiceManager", "Voice-Play-Fail", " " + i + " " + str);
        TiebaStatic.b("", i, str, "");
        xVar = this.a.x;
        if (xVar != null) {
            xVar2 = this.a.x;
            xVar2.a(i, str);
            voiceModel = this.a.u;
            if (voiceModel != null) {
                VoiceManager voiceManager = this.a;
                voiceModel2 = this.a.u;
                voiceManager.b(voiceModel2);
                this.a.u = null;
            }
            this.a.q();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public final void b(int i) {
        x o;
        VoiceData.VoiceModel voiceModel;
        VoiceData.VoiceModel voiceModel2;
        o = this.a.o();
        if (o != null) {
            o.a(i);
        }
        voiceModel = this.a.u;
        if (voiceModel != null) {
            voiceModel2 = this.a.u;
            voiceModel2.elapse = i;
        }
    }
}
