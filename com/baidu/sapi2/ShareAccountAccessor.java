package com.baidu.sapi2;

import com.baidu.sapi2.utils.Log;
/* loaded from: classes2.dex */
public abstract class ShareAccountAccessor {
    public static ShareAccountAccessor accessor;

    public static ShareAccountAccessor getAccessor() {
        ShareAccountAccessor shareAccountAccessor = accessor;
        if (shareAccountAccessor != null) {
            return shareAccountAccessor;
        }
        try {
            Class.forName(SapiAccount.class.getName(), true, SapiAccount.class.getClassLoader());
        } catch (Exception e2) {
            Log.e(e2);
        }
        return accessor;
    }

    public static void setShareAccountAccessor(ShareAccountAccessor shareAccountAccessor) {
        if (accessor == null) {
            accessor = shareAccountAccessor;
            return;
        }
        throw new IllegalStateException();
    }

    public abstract String getExtra(SapiAccount sapiAccount);

    public abstract String getPtoken(SapiAccount sapiAccount);

    public abstract String getStoken(SapiAccount sapiAccount);

    public abstract void setAccountPkg(SapiAccount sapiAccount, String str);

    public abstract void setExtra(SapiAccount sapiAccount, String str);

    public abstract void setPtoken(SapiAccount sapiAccount, String str);

    public abstract void setStoken(SapiAccount sapiAccount, String str);

    public abstract void updatePtoken(SapiAccount sapiAccount);

    public abstract void updateSession(SapiAccount sapiAccount, SapiAccount sapiAccount2);
}
