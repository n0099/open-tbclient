package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.base.debug.Log;
/* loaded from: classes.dex */
public abstract class ShareAccountAccessor {
    private static ShareAccountAccessor a;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getExtra(SapiAccount sapiAccount);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getPtoken(SapiAccount sapiAccount);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String getStoken(SapiAccount sapiAccount);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setExtra(SapiAccount sapiAccount, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setPtoken(SapiAccount sapiAccount, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setStoken(SapiAccount sapiAccount, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void updatePtoken(SapiAccount sapiAccount);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void updateSession(SapiAccount sapiAccount, SapiAccount sapiAccount2);

    public static ShareAccountAccessor getAccessor() {
        ShareAccountAccessor shareAccountAccessor = a;
        if (shareAccountAccessor == null) {
            try {
                Class.forName(SapiAccount.class.getName(), true, SapiAccount.class.getClassLoader());
            } catch (Exception e) {
                Log.e(e);
            }
            return a;
        }
        return shareAccountAccessor;
    }

    public static void setShareAccountAccessor(ShareAccountAccessor shareAccountAccessor) {
        if (a != null) {
            throw new IllegalStateException();
        }
        a = shareAccountAccessor;
    }
}
