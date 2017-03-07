package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s Mm;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a Mn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.Mm = sVar;
        this.Mn = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.Mm.mp();
        if (this.Mm.getVoiceManager() != null && this.Mm.mModel != null) {
            if (this.Mn != null) {
                this.Mn.bE(this.Mm.mModel.voiceId);
            }
            this.Mm.mModel = null;
        }
    }
}
