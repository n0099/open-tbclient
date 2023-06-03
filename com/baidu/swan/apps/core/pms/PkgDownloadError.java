package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.rn3;
import com.baidu.tieba.wk4;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public rn3 mErrCode;
    public wk4 mPackage;

    public PkgDownloadError(wk4 wk4Var, rn3 rn3Var) {
        super(rn3Var.e());
        this.mPackage = wk4Var;
        this.mErrCode = rn3Var;
    }

    public rn3 getErrCode() {
        return this.mErrCode;
    }

    public wk4 getPackage() {
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
