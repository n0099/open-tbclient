package com.baidu.poly.a;
/* loaded from: classes2.dex */
public abstract class a<T> {
    public void onSuccess(T t) {
    }

    public void d(Throwable th, String str) {
        if (th != null) {
            th.printStackTrace();
        }
    }
}
