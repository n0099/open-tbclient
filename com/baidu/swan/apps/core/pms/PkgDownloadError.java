package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.on3;
import com.baidu.tieba.tk4;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public on3 mErrCode;
    public tk4 mPackage;

    public PkgDownloadError(tk4 tk4Var, on3 on3Var) {
        super(on3Var.e());
        this.mPackage = tk4Var;
        this.mErrCode = on3Var;
    }

    public on3 getErrCode() {
        return this.mErrCode;
    }

    public tk4 getPackage() {
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
