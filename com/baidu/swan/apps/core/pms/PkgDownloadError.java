package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.qj3;
import com.baidu.tieba.vg4;
/* loaded from: classes3.dex */
public class PkgDownloadError extends Throwable {
    public qj3 mErrCode;
    public vg4 mPackage;

    public PkgDownloadError(vg4 vg4Var, qj3 qj3Var) {
        super(qj3Var.e());
        this.mPackage = vg4Var;
        this.mErrCode = qj3Var;
    }

    public qj3 getErrCode() {
        return this.mErrCode;
    }

    public vg4 getPackage() {
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
