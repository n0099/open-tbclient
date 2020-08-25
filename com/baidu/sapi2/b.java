package com.baidu.sapi2;
/* loaded from: classes12.dex */
final class b extends com.baidu.sapi2.share.a {
    @Override // com.baidu.sapi2.share.a
    protected String a(SapiAccount sapiAccount) {
        return sapiAccount.extra;
    }

    @Override // com.baidu.sapi2.share.a
    protected String b(SapiAccount sapiAccount) {
        return sapiAccount.ptoken;
    }

    @Override // com.baidu.sapi2.share.a
    protected void c(SapiAccount sapiAccount, String str) {
        sapiAccount.ptoken = str;
    }

    @Override // com.baidu.sapi2.share.a
    protected void d(SapiAccount sapiAccount, String str) {
        sapiAccount.stoken = str;
    }

    @Override // com.baidu.sapi2.share.a
    protected void a(SapiAccount sapiAccount, SapiAccount sapiAccount2) {
        sapiAccount.updateSession(sapiAccount2);
    }

    @Override // com.baidu.sapi2.share.a
    protected void b(SapiAccount sapiAccount, String str) {
        sapiAccount.extra = str;
    }

    @Override // com.baidu.sapi2.share.a
    protected String c(SapiAccount sapiAccount) {
        return sapiAccount.stoken;
    }

    @Override // com.baidu.sapi2.share.a
    protected void d(SapiAccount sapiAccount) {
        sapiAccount.a();
    }

    @Override // com.baidu.sapi2.share.a
    protected void a(SapiAccount sapiAccount, String str) {
        sapiAccount.setAccountPkg(str);
    }
}
