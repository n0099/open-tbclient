package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s LN;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a LO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.LN = sVar;
        this.LO = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.LN.mt();
        if (this.LN.getVoiceManager() != null && this.LN.mModel != null) {
            if (this.LO != null) {
                this.LO.bz(this.LN.mModel.voiceId);
            }
            this.LN.mModel = null;
        }
    }
}
