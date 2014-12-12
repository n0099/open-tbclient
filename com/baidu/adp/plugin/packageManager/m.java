package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
class m implements com.baidu.adp.plugin.install.b {
    private final /* synthetic */ e sR;
    final /* synthetic */ l sS;
    private final /* synthetic */ BdFileDownloadData sT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, e eVar, BdFileDownloadData bdFileDownloadData) {
        this.sS = lVar;
        this.sR = eVar;
        this.sT = bdFileDownloadData;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void aV(String str) {
        if (this.sR != null) {
            this.sR.a(this.sT, 0, "");
        }
    }

    @Override // com.baidu.adp.plugin.install.b
    public void C(String str, String str2) {
        if (this.sR != null) {
            this.sR.a(this.sT, -1, str2);
        }
    }
}
