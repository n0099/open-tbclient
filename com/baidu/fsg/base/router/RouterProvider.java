package com.baidu.fsg.base.router;

import java.util.HashMap;
/* loaded from: classes5.dex */
public abstract class RouterProvider {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1922a = true;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, RouterAction> f1923b = new HashMap<>();

    protected abstract void registerActions();

    public RouterProvider() {
        registerActions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerAction(String str, RouterAction routerAction) {
        this.f1923b.put(str, routerAction);
    }

    public RouterAction findAction(String str) {
        return this.f1923b.get(str);
    }

    public boolean isValid() {
        return this.f1922a;
    }
}
