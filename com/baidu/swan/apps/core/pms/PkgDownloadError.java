package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.al4;
import com.baidu.tieba.vn3;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public vn3 mErrCode;
    public al4 mPackage;

    public PkgDownloadError(al4 al4Var, vn3 vn3Var) {
        super(vn3Var.e());
        this.mPackage = al4Var;
        this.mErrCode = vn3Var;
    }

    public vn3 getErrCode() {
        return this.mErrCode;
    }

    public al4 getPackage() {
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
