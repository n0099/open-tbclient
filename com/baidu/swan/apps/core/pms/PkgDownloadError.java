package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.rm3;
import com.baidu.tieba.wj4;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public rm3 mErrCode;
    public wj4 mPackage;

    public PkgDownloadError(wj4 wj4Var, rm3 rm3Var) {
        super(rm3Var.e());
        this.mPackage = wj4Var;
        this.mErrCode = rm3Var;
    }

    public rm3 getErrCode() {
        return this.mErrCode;
    }

    public wj4 getPackage() {
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
