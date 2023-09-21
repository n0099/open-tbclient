package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.ek4;
import com.baidu.tieba.zm3;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public zm3 mErrCode;
    public ek4 mPackage;

    public PkgDownloadError(ek4 ek4Var, zm3 zm3Var) {
        super(zm3Var.e());
        this.mPackage = ek4Var;
        this.mErrCode = zm3Var;
    }

    public zm3 getErrCode() {
        return this.mErrCode;
    }

    public ek4 getPackage() {
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
