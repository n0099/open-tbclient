package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.an3;
import com.baidu.tieba.fk4;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public an3 mErrCode;
    public fk4 mPackage;

    public PkgDownloadError(fk4 fk4Var, an3 an3Var) {
        super(an3Var.e());
        this.mPackage = fk4Var;
        this.mErrCode = an3Var;
    }

    public an3 getErrCode() {
        return this.mErrCode;
    }

    public fk4 getPackage() {
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
