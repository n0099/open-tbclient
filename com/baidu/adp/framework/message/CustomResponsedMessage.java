package com.baidu.adp.framework.message;
/* loaded from: classes.dex */
public class CustomResponsedMessage<T> extends f<T> {
    private T a;

    public CustomResponsedMessage(int i) {
        super(i);
        this.a = null;
    }

    public CustomResponsedMessage(int i, T t) {
        super(i);
        this.a = null;
        this.a = t;
    }

    public T a() {
        return this.a;
    }

    @Override // com.baidu.adp.framework.message.c
    public final void a(int i, T t) {
        this.a = t;
    }
}
