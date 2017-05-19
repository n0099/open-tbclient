package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t implements a.b {
    final /* synthetic */ s Lh;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a Li;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.Lh = sVar;
        this.Li = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.Lh.ma();
        if (this.Lh.getVoiceManager() != null && this.Lh.mModel != null) {
            if (this.Li != null) {
                this.Li.bz(this.Lh.mModel.voiceId);
            }
            this.Lh.mModel = null;
        }
    }
}
