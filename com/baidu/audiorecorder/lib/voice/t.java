package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t implements a.b {
    final /* synthetic */ s KV;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a KW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.KV = sVar;
        this.KW = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.KV.lS();
        if (this.KV.getVoiceManager() != null && this.KV.mModel != null) {
            if (this.KW != null) {
                this.KW.bz(this.KV.mModel.voiceId);
            }
            this.KV.mModel = null;
        }
    }
}
