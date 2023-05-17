package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.ei4;
import com.baidu.tieba.zk3;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public zk3 mErrCode;
    public ei4 mPackage;

    public PkgDownloadError(ei4 ei4Var, zk3 zk3Var) {
        super(zk3Var.e());
        this.mPackage = ei4Var;
        this.mErrCode = zk3Var;
    }

    public zk3 getErrCode() {
        return this.mErrCode;
    }

    public ei4 getPackage() {
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
