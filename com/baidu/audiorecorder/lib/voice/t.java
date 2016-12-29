package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s FN;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a FO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.FN = sVar;
        this.FO = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.FN.lD();
        if (this.FN.getVoiceManager() != null && this.FN.mModel != null) {
            if (this.FO != null) {
                this.FO.bM(this.FN.mModel.voiceId);
            }
            this.FN.mModel = null;
        }
    }
}
