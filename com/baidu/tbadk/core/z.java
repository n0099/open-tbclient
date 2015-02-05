package com.baidu.tbadk.core;

import com.baidu.bdcvf.CertVerifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements CertVerifier.ResultListener {
    final /* synthetic */ TbadkCoreApplication CO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TbadkCoreApplication tbadkCoreApplication) {
        this.CO = tbadkCoreApplication;
    }

    @Override // com.baidu.bdcvf.CertVerifier.ResultListener
    public void onVerifyOK() {
        this.CO.mIsOfficial = true;
    }

    @Override // com.baidu.bdcvf.CertVerifier.ResultListener
    public void onVerifyFail(int i) {
        this.CO.mIsOfficial = false;
    }
}
