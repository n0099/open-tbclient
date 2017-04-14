package com.baidu.sapi2;
/* loaded from: classes.dex */
final class a extends com.baidu.sapi2.share.b {
    @Override // com.baidu.sapi2.share.b
    protected String a(SapiAccount sapiAccount) {
        return sapiAccount.k;
    }

    @Override // com.baidu.sapi2.share.b
    protected void a(SapiAccount sapiAccount, String str) {
        sapiAccount.k = str;
    }

    @Override // com.baidu.sapi2.share.b
    protected String b(SapiAccount sapiAccount) {
        return sapiAccount.l;
    }

    @Override // com.baidu.sapi2.share.b
    protected void b(SapiAccount sapiAccount, String str) {
        sapiAccount.l = str;
    }

    @Override // com.baidu.sapi2.share.b
    protected String c(SapiAccount sapiAccount) {
        return sapiAccount.m;
    }

    @Override // com.baidu.sapi2.share.b
    protected void c(SapiAccount sapiAccount, String str) {
        sapiAccount.m = str;
    }

    @Override // com.baidu.sapi2.share.b
    protected void a(SapiAccount sapiAccount, SapiAccount sapiAccount2) {
        sapiAccount.a(sapiAccount2);
    }

    @Override // com.baidu.sapi2.share.b
    protected void d(SapiAccount sapiAccount) {
        sapiAccount.b();
    }
}
