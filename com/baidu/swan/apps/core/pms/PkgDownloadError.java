package com.baidu.swan.apps.core.pms;
/* loaded from: classes2.dex */
public class PkgDownloadError extends Throwable {
    private com.baidu.swan.apps.ak.a mErrCode;
    private com.baidu.swan.pms.model.f mPackage;

    public PkgDownloadError(com.baidu.swan.pms.model.f fVar, com.baidu.swan.apps.ak.a aVar) {
        super(aVar.LA());
        this.mPackage = fVar;
        this.mErrCode = aVar;
    }

    public com.baidu.swan.pms.model.f getPackage() {
        return this.mPackage;
    }

    public com.baidu.swan.apps.ak.a getErrCode() {
        return this.mErrCode;
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
