package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s CW;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a CX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.CW = sVar;
        this.CX = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.CW.kG();
        if (this.CW.getVoiceManager() != null && this.CW.mModel != null) {
            if (this.CX != null) {
                this.CX.bK(this.CW.mModel.voiceId);
            }
            this.CW.mModel = null;
        }
    }
}
