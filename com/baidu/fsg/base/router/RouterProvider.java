package com.baidu.fsg.base.router;

import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class RouterProvider {
    private boolean a = true;
    private HashMap<String, RouterAction> b = new HashMap<>();

    protected abstract void registerActions();

    public RouterProvider() {
        registerActions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerAction(String str, RouterAction routerAction) {
        this.b.put(str, routerAction);
    }

    public RouterAction findAction(String str) {
        return this.b.get(str);
    }

    public boolean isValid() {
        return this.a;
    }
}
