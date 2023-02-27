package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.fl3;
import com.baidu.tieba.ki4;
/* loaded from: classes3.dex */
public class PkgDownloadError extends Throwable {
    public fl3 mErrCode;
    public ki4 mPackage;

    public PkgDownloadError(ki4 ki4Var, fl3 fl3Var) {
        super(fl3Var.e());
        this.mPackage = ki4Var;
        this.mErrCode = fl3Var;
    }

    public fl3 getErrCode() {
        return this.mErrCode;
    }

    public ki4 getPackage() {
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
