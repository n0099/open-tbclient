package com.baidu.tbadk.core.voice;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac implements com.baidu.tbadk.core.voice.a.c {
    final /* synthetic */ VoiceManager a;

    private ac(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(VoiceManager voiceManager, byte b) {
        this(voiceManager);
    }

    @Override // com.baidu.tbadk.core.voice.a.c
    public final void a(String str, String str2, int i, String str3) {
        VoiceData.VoiceModel voiceModel;
        x xVar;
        x xVar2;
        VoiceData.VoiceModel voiceModel2;
        x xVar3;
        VoiceData.VoiceModel voiceModel3;
        VoiceData.VoiceModel voiceModel4;
        VoiceData.VoiceModel voiceModel5;
        voiceModel = this.a.u;
        if (voiceModel != null) {
            xVar = this.a.x;
            if (xVar != null) {
                if (!com.baidu.adp.lib.util.o.a(str) && !com.baidu.adp.lib.util.o.a(str2)) {
                    voiceModel3 = this.a.u;
                    if (voiceModel3.voiceId.equals(str2)) {
                        voiceModel4 = this.a.u;
                        if (VoiceManager.a(voiceModel4.voice_status.intValue())) {
                            VoiceManager voiceManager = this.a;
                            voiceModel5 = this.a.u;
                            voiceManager.a(voiceModel5, str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.util.f.b("VoiceManager", "VoiceLoaderCallback::voiceLoaded", "error code:" + i + " error msg:" + str3);
                TiebaStatic.b("", i, str3, str);
                if (i <= 0 || com.baidu.adp.lib.util.o.a(str3) || (i != 2 && i != 4 && i != 3 && i != 7)) {
                    xVar2 = this.a.x;
                    xVar2.a(5, ae.a(com.baidu.tbadk.l.voice_err_load_fail));
                } else {
                    xVar3 = this.a.x;
                    xVar3.a(5, str3);
                }
                VoiceManager voiceManager2 = this.a;
                voiceModel2 = this.a.u;
                voiceManager2.c(voiceModel2);
            }
        }
    }
}
