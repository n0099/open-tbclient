package com.baidu.sapi2;
/* loaded from: classes2.dex */
public final class b extends e {
    @Override // com.baidu.sapi2.e
    public String a(SapiAccount sapiAccount) {
        return sapiAccount.extra;
    }

    @Override // com.baidu.sapi2.e
    public String b(SapiAccount sapiAccount) {
        return sapiAccount.ptoken;
    }

    @Override // com.baidu.sapi2.e
    public void c(SapiAccount sapiAccount, String str) {
        sapiAccount.ptoken = str;
    }

    @Override // com.baidu.sapi2.e
    public void d(SapiAccount sapiAccount, String str) {
        sapiAccount.stoken = str;
    }

    @Override // com.baidu.sapi2.e
    public void a(SapiAccount sapiAccount, SapiAccount sapiAccount2) {
        sapiAccount.updateSession(sapiAccount2);
    }

    @Override // com.baidu.sapi2.e
    public void b(SapiAccount sapiAccount, String str) {
        sapiAccount.extra = str;
    }

    @Override // com.baidu.sapi2.e
    public String c(SapiAccount sapiAccount) {
        return sapiAccount.stoken;
    }

    @Override // com.baidu.sapi2.e
    public void d(SapiAccount sapiAccount) {
        sapiAccount.a();
    }

    @Override // com.baidu.sapi2.e
    public void a(SapiAccount sapiAccount, String str) {
        sapiAccount.setAccountPkg(str);
    }
}
