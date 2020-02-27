package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes6.dex */
public abstract class k {
    private static k a;

    public static k a() {
        k kVar = a;
        if (kVar == null) {
            try {
                Class.forName(SapiAccount.class.getName(), true, SapiAccount.class.getClassLoader());
            } catch (Exception e) {
                Log.e(e);
            }
            return a;
        }
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String a(SapiAccount sapiAccount);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(SapiAccount sapiAccount, SapiAccount sapiAccount2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(SapiAccount sapiAccount, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String b(SapiAccount sapiAccount);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(SapiAccount sapiAccount, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String c(SapiAccount sapiAccount);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(SapiAccount sapiAccount, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void d(SapiAccount sapiAccount);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void d(SapiAccount sapiAccount, String str);

    public static void a(k kVar) {
        if (a == null) {
            a = kVar;
            return;
        }
        throw new IllegalStateException();
    }
}
