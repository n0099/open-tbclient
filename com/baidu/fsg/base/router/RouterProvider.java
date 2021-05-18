package com.baidu.fsg.base.router;

import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class RouterProvider {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5280a = true;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, RouterAction> f5281b = new HashMap<>();

    public RouterProvider() {
        registerActions();
    }

    public RouterAction findAction(String str) {
        return this.f5281b.get(str);
    }

    public boolean isValid() {
        return this.f5280a;
    }

    public void registerAction(String str, RouterAction routerAction) {
        this.f5281b.put(str, routerAction);
    }

    public abstract void registerActions();
}
