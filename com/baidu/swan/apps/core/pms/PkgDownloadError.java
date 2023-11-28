package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.ai3;
import com.baidu.tieba.ff4;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public ai3 mErrCode;
    public ff4 mPackage;

    public PkgDownloadError(ff4 ff4Var, ai3 ai3Var) {
        super(ai3Var.e());
        this.mPackage = ff4Var;
        this.mErrCode = ai3Var;
    }

    public ai3 getErrCode() {
        return this.mErrCode;
    }

    public ff4 getPackage() {
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
