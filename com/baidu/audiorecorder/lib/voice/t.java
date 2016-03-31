package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s MF;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a MG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.MF = sVar;
        this.MG = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.MF.ot();
        if (this.MF.getVoiceManager() != null && this.MF.mModel != null) {
            if (this.MG != null) {
                this.MG.bR(this.MF.mModel.voiceId);
            }
            this.MF.mModel = null;
        }
    }
}
