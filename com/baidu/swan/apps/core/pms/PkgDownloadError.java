package com.baidu.swan.apps.core.pms;
/* loaded from: classes7.dex */
public class PkgDownloadError extends Throwable {
    private com.baidu.swan.apps.am.a mErrCode;
    private com.baidu.swan.pms.model.e mPackage;

    public PkgDownloadError(com.baidu.swan.pms.model.e eVar, com.baidu.swan.apps.am.a aVar) {
        super(aVar.aLe());
        this.mPackage = eVar;
        this.mErrCode = aVar;
    }

    public com.baidu.swan.pms.model.e getPackage() {
        return this.mPackage;
    }

    public com.baidu.swan.apps.am.a getErrCode() {
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
