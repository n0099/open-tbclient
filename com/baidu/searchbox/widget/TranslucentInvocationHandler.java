package com.baidu.searchbox.widget;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* loaded from: classes16.dex */
public class TranslucentInvocationHandler implements InvocationHandler {
    private OnTranslucentListener listener;

    public TranslucentInvocationHandler(OnTranslucentListener onTranslucentListener) {
        this.listener = onTranslucentListener;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (this.listener != null) {
            try {
                this.listener.onTranslucent(((Boolean) objArr[0]).booleanValue());
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                this.listener.onTranslucent(false);
                return null;
            }
        }
        return null;
    }
}
