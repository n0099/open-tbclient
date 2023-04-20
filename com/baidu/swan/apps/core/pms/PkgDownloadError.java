package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.oj3;
import com.baidu.tieba.tg4;
/* loaded from: classes3.dex */
public class PkgDownloadError extends Throwable {
    public oj3 mErrCode;
    public tg4 mPackage;

    public PkgDownloadError(tg4 tg4Var, oj3 oj3Var) {
        super(oj3Var.e());
        this.mPackage = tg4Var;
        this.mErrCode = oj3Var;
    }

    public oj3 getErrCode() {
        return this.mErrCode;
    }

    public tg4 getPackage() {
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
