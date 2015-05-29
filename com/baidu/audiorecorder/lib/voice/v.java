package com.baidu.audiorecorder.lib.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ u Ls;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.voice.a Lt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, com.baidu.tieba.tbadkCore.voice.a aVar) {
        this.Ls = uVar;
        this.Lt = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.Ls.os();
        if (this.Ls.getVoiceManager() != null && this.Ls.mModel != null) {
            if (this.Lt != null) {
                this.Lt.bO(this.Ls.mModel.voiceId);
            }
            this.Ls.mModel = null;
        }
    }
}
