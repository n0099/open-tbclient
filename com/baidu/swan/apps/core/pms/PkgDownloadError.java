package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.sn3;
import com.baidu.tieba.xk4;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public sn3 mErrCode;
    public xk4 mPackage;

    public PkgDownloadError(xk4 xk4Var, sn3 sn3Var) {
        super(sn3Var.e());
        this.mPackage = xk4Var;
        this.mErrCode = sn3Var;
    }

    public sn3 getErrCode() {
        return this.mErrCode;
    }

    public xk4 getPackage() {
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
