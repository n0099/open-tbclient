package com.baidu.adp.lib.stats.b;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.stats.base.a {
    public h(n nVar) {
        super(nVar);
        this.mMaxMemCount = 10;
        this.mFilePrefixString = "stat";
        this.mMustSuccess = true;
        this.mUseSdCard = false;
    }

    @Override // com.baidu.adp.lib.stats.base.a
    public String getPostFileName() {
        return "omp";
    }
}
