package com.baidu.fsg.base.router;

import android.content.Context;
import com.baidu.fsg.base.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class RouterManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1478a = "MaApplication";
    private static RouterManager b = new RouterManager();
    private ArrayList<ApplicationLogicWrapper> c = new ArrayList<>();

    private RouterManager() {
    }

    public static RouterManager getInstance() {
        return b;
    }

    public void init(Context context, HashMap<String, Object> hashMap) {
        if (context == null) {
            throw new RuntimeException("Router manager init with context null");
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new RuntimeException("Router manager init with applciation context null");
        }
        LogUtil.d(f1478a, "Application onCreate start: " + System.currentTimeMillis());
        LocalRouter.init(applicationContext);
        a(applicationContext, hashMap);
        LogUtil.d(f1478a, "Application onCreate end: " + System.currentTimeMillis());
    }

    private void a(Context context, HashMap<String, Object> hashMap) {
        if (this.c != null && this.c.size() >= 1) {
            Iterator<ApplicationLogicWrapper> it = this.c.iterator();
            while (it.hasNext()) {
                ApplicationLogicWrapper next = it.next();
                if (next != null) {
                    try {
                        next.instance = next.logicClass.newInstance();
                    } catch (IllegalAccessException e) {
                    } catch (InstantiationException e2) {
                        e2.printStackTrace();
                    }
                    if (next != null && next.instance != null) {
                        next.instance.onCreate(context, hashMap);
                    }
                }
            }
        }
    }

    public boolean registerApplicationLogic(Class<? extends BaseApplicationLogic> cls) {
        if (this.c == null) {
            return false;
        }
        Iterator<ApplicationLogicWrapper> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().logicClass.equals(cls)) {
                throw new RuntimeException(cls.getName() + " has registered.");
            }
        }
        this.c.add(new ApplicationLogicWrapper(cls));
        return true;
    }

    public void route(Context context, RouterRequest routerRequest, RouterCallback routerCallback) {
        LocalRouter.getInstance().a(context, routerRequest, routerCallback);
    }

    public void registerProvider(String str, RouterProvider routerProvider) {
        LocalRouter.getInstance().a(str, routerProvider);
    }
}
