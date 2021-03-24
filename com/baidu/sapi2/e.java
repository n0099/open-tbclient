package com.baidu.sapi2;

import com.baidu.sapi2.utils.Log;
/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static e f11214a;

    public static e a() {
        e eVar = f11214a;
        if (eVar != null) {
            return eVar;
        }
        try {
            Class.forName(SapiAccount.class.getName(), true, SapiAccount.class.getClassLoader());
        } catch (Exception e2) {
            Log.e(e2);
        }
        return f11214a;
    }

    public abstract String a(SapiAccount sapiAccount);

    public abstract void a(SapiAccount sapiAccount, SapiAccount sapiAccount2);

    public abstract void a(SapiAccount sapiAccount, String str);

    public abstract String b(SapiAccount sapiAccount);

    public abstract void b(SapiAccount sapiAccount, String str);

    public abstract String c(SapiAccount sapiAccount);

    public abstract void c(SapiAccount sapiAccount, String str);

    public abstract void d(SapiAccount sapiAccount);

    public abstract void d(SapiAccount sapiAccount, String str);

    public static void a(e eVar) {
        if (f11214a == null) {
            f11214a = eVar;
            return;
        }
        throw new IllegalStateException();
    }
}
