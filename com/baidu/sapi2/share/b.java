package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.L;
/* loaded from: classes.dex */
public abstract class b {
    private static b a;

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

    public static b a() {
        b bVar = a;
        if (bVar == null) {
            try {
                Class.forName(SapiAccount.class.getName(), true, SapiAccount.class.getClassLoader());
            } catch (Exception e) {
                L.e(e);
            }
            return a;
        }
        return bVar;
    }

    public static void a(b bVar) {
        if (a != null) {
            throw new IllegalStateException();
        }
        a = bVar;
    }
}
