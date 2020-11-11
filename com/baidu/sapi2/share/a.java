package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f3513a;

    public static a a() {
        a aVar = f3513a;
        if (aVar == null) {
            try {
                Class.forName(SapiAccount.class.getName(), true, SapiAccount.class.getClassLoader());
            } catch (Exception e) {
                Log.e(e);
            }
            return f3513a;
        }
        return aVar;
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

    public static void a(a aVar) {
        if (f3513a == null) {
            f3513a = aVar;
            return;
        }
        throw new IllegalStateException();
    }
}
