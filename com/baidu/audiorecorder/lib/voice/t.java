package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s FM;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a FN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.FM = sVar;
        this.FN = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.FM.lD();
        if (this.FM.getVoiceManager() != null && this.FM.mModel != null) {
            if (this.FN != null) {
                this.FN.bM(this.FM.mModel.voiceId);
            }
            this.FM.mModel = null;
        }
    }
}
