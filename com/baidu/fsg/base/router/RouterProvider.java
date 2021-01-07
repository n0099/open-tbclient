package com.baidu.fsg.base.router;

import java.util.HashMap;
/* loaded from: classes6.dex */
public abstract class RouterProvider {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1974a = true;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, RouterAction> f1975b = new HashMap<>();

    protected abstract void registerActions();

    public RouterProvider() {
        registerActions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerAction(String str, RouterAction routerAction) {
        this.f1975b.put(str, routerAction);
    }

    public RouterAction findAction(String str) {
        return this.f1975b.get(str);
    }

    public boolean isValid() {
        return this.f1974a;
    }
}
