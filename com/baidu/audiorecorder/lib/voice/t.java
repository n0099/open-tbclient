package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s CX;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a CY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.CX = sVar;
        this.CY = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.CX.kJ();
        if (this.CX.getVoiceManager() != null && this.CX.mModel != null) {
            if (this.CY != null) {
                this.CY.bK(this.CX.mModel.voiceId);
            }
            this.CX.mModel = null;
        }
    }
}
