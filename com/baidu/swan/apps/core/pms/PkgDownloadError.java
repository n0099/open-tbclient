package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.mj3;
import com.baidu.tieba.rg4;
/* loaded from: classes3.dex */
public class PkgDownloadError extends Throwable {
    public mj3 mErrCode;
    public rg4 mPackage;

    public PkgDownloadError(rg4 rg4Var, mj3 mj3Var) {
        super(mj3Var.e());
        this.mPackage = rg4Var;
        this.mErrCode = mj3Var;
    }

    public mj3 getErrCode() {
        return this.mErrCode;
    }

    public rg4 getPackage() {
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
