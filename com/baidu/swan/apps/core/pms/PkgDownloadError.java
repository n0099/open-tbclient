package com.baidu.swan.apps.core.pms;

import d.b.h0.a.f2.a;
import d.b.h0.l.k.e;
/* loaded from: classes2.dex */
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
