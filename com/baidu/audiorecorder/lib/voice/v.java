package com.baidu.audiorecorder.lib.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ u Ly;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a Lz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.Ly = uVar;
        this.Lz = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.Ly.oc();
        if (this.Ly.getVoiceManager() != null && this.Ly.mModel != null) {
            if (this.Lz != null) {
                this.Lz.bE(this.Ly.mModel.voiceId);
            }
            this.Ly.mModel = null;
        }
    }
}
