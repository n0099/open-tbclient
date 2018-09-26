package com.baidu.sapi2;

import com.baidu.sapi2.share.ShareAccountAccessor;
/* loaded from: classes.dex */
final class SapiAccountAccessorImpl extends ShareAccountAccessor {
    @Override // com.baidu.sapi2.share.ShareAccountAccessor
    protected String getPtoken(SapiAccount sapiAccount) {
        return sapiAccount.ptoken;
    }

    @Override // com.baidu.sapi2.share.ShareAccountAccessor
    protected void setPtoken(SapiAccount sapiAccount, String str) {
        sapiAccount.ptoken = str;
    }

    @Override // com.baidu.sapi2.share.ShareAccountAccessor
    protected String getStoken(SapiAccount sapiAccount) {
        return sapiAccount.stoken;
    }

    @Override // com.baidu.sapi2.share.ShareAccountAccessor
    protected void setStoken(SapiAccount sapiAccount, String str) {
        sapiAccount.stoken = str;
    }

    @Override // com.baidu.sapi2.share.ShareAccountAccessor
    protected String getExtra(SapiAccount sapiAccount) {
        return sapiAccount.extra;
    }

    @Override // com.baidu.sapi2.share.ShareAccountAccessor
    protected void setExtra(SapiAccount sapiAccount, String str) {
        sapiAccount.extra = str;
    }

    @Override // com.baidu.sapi2.share.ShareAccountAccessor
    protected void updateSession(SapiAccount sapiAccount, SapiAccount sapiAccount2) {
        sapiAccount.updateSession(sapiAccount2);
    }

    @Override // com.baidu.sapi2.share.ShareAccountAccessor
    protected void updatePtoken(SapiAccount sapiAccount) {
        sapiAccount.a();
    }

    @Override // com.baidu.sapi2.share.ShareAccountAccessor
    protected void setAccountPkg(SapiAccount sapiAccount, String str) {
        sapiAccount.setAccountPkg(str);
    }
}
