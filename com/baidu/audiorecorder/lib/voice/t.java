package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s LU;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a LV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.LU = sVar;
        this.LV = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.LU.oH();
        if (this.LU.getVoiceManager() != null && this.LU.mModel != null) {
            if (this.LV != null) {
                this.LV.bR(this.LU.mModel.voiceId);
            }
            this.LU.mModel = null;
        }
    }
}
