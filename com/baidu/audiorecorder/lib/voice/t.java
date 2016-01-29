package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a MA;
    final /* synthetic */ s Mz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.Mz = sVar;
        this.MA = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.Mz.oA();
        if (this.Mz.getVoiceManager() != null && this.Mz.mModel != null) {
            if (this.MA != null) {
                this.MA.bT(this.Mz.mModel.voiceId);
            }
            this.Mz.mModel = null;
        }
    }
}
