package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t implements a.b {
    final /* synthetic */ s KU;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a KV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.KU = sVar;
        this.KV = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.KU.lQ();
        if (this.KU.getVoiceManager() != null && this.KU.mModel != null) {
            if (this.KV != null) {
                this.KV.bE(this.KU.mModel.voiceId);
            }
            this.KU.mModel = null;
        }
    }
}
