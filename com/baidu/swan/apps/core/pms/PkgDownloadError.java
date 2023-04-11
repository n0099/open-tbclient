package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.nj3;
import com.baidu.tieba.sg4;
/* loaded from: classes3.dex */
public class PkgDownloadError extends Throwable {
    public nj3 mErrCode;
    public sg4 mPackage;

    public PkgDownloadError(sg4 sg4Var, nj3 nj3Var) {
        super(nj3Var.e());
        this.mPackage = sg4Var;
        this.mErrCode = nj3Var;
    }

    public nj3 getErrCode() {
        return this.mErrCode;
    }

    public sg4 getPackage() {
        return this.mPackage;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.mPackage != null) {
            sb.append(" -> package: ");
            sb.append(this.mPackage.toString());
        }
        if (this.mErrCode != null) {
            sb.append(" -> ErrCode: ");
            sb.append(this.mErrCode.toString());
        }
        return sb.toString();
    }
}
