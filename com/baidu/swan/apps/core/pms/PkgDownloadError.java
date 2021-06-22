package com.baidu.swan.apps.core.pms;

import d.a.m0.a.q2.a;
import d.a.m0.n.h.e;
/* loaded from: classes3.dex */
public class PkgDownloadError extends Throwable {
    public a mErrCode;
    public e mPackage;

    public PkgDownloadError(e eVar, a aVar) {
        super(aVar.d());
        this.mPackage = eVar;
        this.mErrCode = aVar;
    }

    public a getErrCode() {
        return this.mErrCode;
    }

    public e getPackage() {
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
