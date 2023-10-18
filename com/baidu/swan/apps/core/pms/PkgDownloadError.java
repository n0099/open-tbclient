package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.ih3;
import com.baidu.tieba.ne4;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public ih3 mErrCode;
    public ne4 mPackage;

    public PkgDownloadError(ne4 ne4Var, ih3 ih3Var) {
        super(ih3Var.e());
        this.mPackage = ne4Var;
        this.mErrCode = ih3Var;
    }

    public ih3 getErrCode() {
        return this.mErrCode;
    }

    public ne4 getPackage() {
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
