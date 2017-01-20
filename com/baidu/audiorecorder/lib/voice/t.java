package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s EY;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a EZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.EY = sVar;
        this.EZ = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.EY.lv();
        if (this.EY.getVoiceManager() != null && this.EY.mModel != null) {
            if (this.EZ != null) {
                this.EZ.bK(this.EY.mModel.voiceId);
            }
            this.EY.mModel = null;
        }
    }
}
