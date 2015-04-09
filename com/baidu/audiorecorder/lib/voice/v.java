package com.baidu.audiorecorder.lib.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ u LA;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a LB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.LA = uVar;
        this.LB = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.LA.oc();
        if (this.LA.getVoiceManager() != null && this.LA.mModel != null) {
            if (this.LB != null) {
                this.LB.bE(this.LA.mModel.voiceId);
            }
            this.LA.mModel = null;
        }
    }
}
