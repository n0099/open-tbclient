package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ s Dx;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a Dy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.Dx = sVar;
        this.Dy = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.Dx.kF();
        if (this.Dx.getVoiceManager() != null && this.Dx.mModel != null) {
            if (this.Dy != null) {
                this.Dy.bL(this.Dx.mModel.voiceId);
            }
            this.Dx.mModel = null;
        }
    }
}
