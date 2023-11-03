package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.ef4;
import com.baidu.tieba.zh3;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public zh3 mErrCode;
    public ef4 mPackage;

    public PkgDownloadError(ef4 ef4Var, zh3 zh3Var) {
        super(zh3Var.e());
        this.mPackage = ef4Var;
        this.mErrCode = zh3Var;
    }

    public zh3 getErrCode() {
        return this.mErrCode;
    }

    public ef4 getPackage() {
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
