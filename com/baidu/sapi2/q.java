package com.baidu.sapi2;
/* loaded from: classes19.dex */
final class q extends com.baidu.sapi2.share.k {
    @Override // com.baidu.sapi2.share.k
    protected String a(SapiAccount sapiAccount) {
        return sapiAccount.extra;
    }

    @Override // com.baidu.sapi2.share.k
    protected String b(SapiAccount sapiAccount) {
        return sapiAccount.ptoken;
    }

    @Override // com.baidu.sapi2.share.k
    protected void c(SapiAccount sapiAccount, String str) {
        sapiAccount.ptoken = str;
    }

    @Override // com.baidu.sapi2.share.k
    protected void d(SapiAccount sapiAccount, String str) {
        sapiAccount.stoken = str;
    }

    @Override // com.baidu.sapi2.share.k
    protected void a(SapiAccount sapiAccount, SapiAccount sapiAccount2) {
        sapiAccount.updateSession(sapiAccount2);
    }

    @Override // com.baidu.sapi2.share.k
    protected void b(SapiAccount sapiAccount, String str) {
        sapiAccount.extra = str;
    }

    @Override // com.baidu.sapi2.share.k
    protected String c(SapiAccount sapiAccount) {
        return sapiAccount.stoken;
    }

    @Override // com.baidu.sapi2.share.k
    protected void d(SapiAccount sapiAccount) {
        sapiAccount.a();
    }

    @Override // com.baidu.sapi2.share.k
    protected void a(SapiAccount sapiAccount, String str) {
        sapiAccount.setAccountPkg(str);
    }
}
