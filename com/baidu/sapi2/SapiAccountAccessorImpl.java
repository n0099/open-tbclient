package com.baidu.sapi2;
/* loaded from: classes2.dex */
public final class SapiAccountAccessorImpl extends ShareAccountAccessor {
    @Override // com.baidu.sapi2.ShareAccountAccessor
    public String getExtra(SapiAccount sapiAccount) {
        return sapiAccount.extra;
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public String getPtoken(SapiAccount sapiAccount) {
        return sapiAccount.ptoken;
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public String getStoken(SapiAccount sapiAccount) {
        return sapiAccount.stoken;
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void updatePtoken(SapiAccount sapiAccount) {
        sapiAccount.updatePtoken();
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void setAccountPkg(SapiAccount sapiAccount, String str) {
        sapiAccount.setAccountPkg(str);
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void setExtra(SapiAccount sapiAccount, String str) {
        sapiAccount.extra = str;
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void setPtoken(SapiAccount sapiAccount, String str) {
        sapiAccount.ptoken = str;
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void setStoken(SapiAccount sapiAccount, String str) {
        sapiAccount.stoken = str;
    }

    @Override // com.baidu.sapi2.ShareAccountAccessor
    public void updateSession(SapiAccount sapiAccount, SapiAccount sapiAccount2) {
        sapiAccount.updateSession(sapiAccount2);
    }
}
