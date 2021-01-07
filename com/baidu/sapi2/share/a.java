package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f5340a;

    public static a a() {
        a aVar = f5340a;
        if (aVar == null) {
            try {
                Class.forName(SapiAccount.class.getName(), true, SapiAccount.class.getClassLoader());
            } catch (Exception e) {
                Log.e(e);
            }
            return f5340a;
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
        if (f5340a == null) {
            f5340a = aVar;
            return;
        }
        throw new IllegalStateException();
    }
}
