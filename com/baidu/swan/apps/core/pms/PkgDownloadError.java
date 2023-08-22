package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.bk4;
import com.baidu.tieba.wm3;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public wm3 mErrCode;
    public bk4 mPackage;

    public PkgDownloadError(bk4 bk4Var, wm3 wm3Var) {
        super(wm3Var.e());
        this.mPackage = bk4Var;
        this.mErrCode = wm3Var;
    }

    public wm3 getErrCode() {
        return this.mErrCode;
    }

    public bk4 getPackage() {
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
