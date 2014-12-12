package com.baidu.tbadk.core;

import com.baidu.bdcvf.CertVerifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements CertVerifier.ResultListener {
    final /* synthetic */ TbadkCoreApplication CR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TbadkCoreApplication tbadkCoreApplication) {
        this.CR = tbadkCoreApplication;
    }

    @Override // com.baidu.bdcvf.CertVerifier.ResultListener
    public void onVerifyOK() {
        this.CR.mIsOfficial = true;
    }

    @Override // com.baidu.bdcvf.CertVerifier.ResultListener
    public void onVerifyFail(int i) {
        this.CR.mIsOfficial = false;
    }
}
