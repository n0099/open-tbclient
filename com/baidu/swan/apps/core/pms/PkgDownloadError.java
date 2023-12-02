package com.baidu.swan.apps.core.pms;

import com.baidu.tieba.di3;
import com.baidu.tieba.if4;
/* loaded from: classes4.dex */
public class PkgDownloadError extends Throwable {
    public di3 mErrCode;
    public if4 mPackage;

    public PkgDownloadError(if4 if4Var, di3 di3Var) {
        super(di3Var.e());
        this.mPackage = if4Var;
        this.mErrCode = di3Var;
    }

    public di3 getErrCode() {
        return this.mErrCode;
    }

    public if4 getPackage() {
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
