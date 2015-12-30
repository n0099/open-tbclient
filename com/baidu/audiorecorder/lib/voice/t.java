package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s Mk;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a Ml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.Mk = sVar;
        this.Ml = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.Mk.of();
        if (this.Mk.getVoiceManager() != null && this.Mk.mModel != null) {
            if (this.Ml != null) {
                this.Ml.bT(this.Mk.mModel.voiceId);
            }
            this.Mk.mModel = null;
        }
    }
}
