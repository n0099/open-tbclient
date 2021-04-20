package com.baidu.fsg.base.router;

import android.content.Context;
import com.baidu.fsg.base.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class RouterManager {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5289a = "MaApplication";

    /* renamed from: b  reason: collision with root package name */
    public static RouterManager f5290b = new RouterManager();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ApplicationLogicWrapper> f5291c = new ArrayList<>();

    private void a(Context context, HashMap<String, Object> hashMap) {
        BaseApplicationLogic baseApplicationLogic;
        ArrayList<ApplicationLogicWrapper> arrayList = this.f5291c;
        if (arrayList == null || arrayList.size() < 1) {
            return;
        }
        Iterator<ApplicationLogicWrapper> it = this.f5291c.iterator();
        while (it.hasNext()) {
            ApplicationLogicWrapper next = it.next();
            if (next != null) {
                try {
                    next.instance = next.logicClass.newInstance();
                } catch (IllegalAccessException unused) {
                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                }
                if (next != null && (baseApplicationLogic = next.instance) != null) {
                    baseApplicationLogic.onCreate(context, hashMap);
                }
            }
        }
    }

    public static RouterManager getInstance() {
        return f5290b;
    }

    public void init(Context context, HashMap<String, Object> hashMap) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                LogUtil.d(f5289a, "Application onCreate start: " + System.currentTimeMillis());
                LocalRouter.init(applicationContext);
                a(applicationContext, hashMap);
                LogUtil.d(f5289a, "Application onCreate end: " + System.currentTimeMillis());
                return;
            }
            throw new RuntimeException("Router manager init with applciation context null");
        }
        throw new RuntimeException("Router manager init with context null");
    }

    public boolean registerApplicationLogic(Class<? extends BaseApplicationLogic> cls) {
        ArrayList<ApplicationLogicWrapper> arrayList = this.f5291c;
        if (arrayList != null) {
            Iterator<ApplicationLogicWrapper> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().logicClass.equals(cls)) {
                    throw new RuntimeException(cls.getName() + " has registered.");
                }
            }
            this.f5291c.add(new ApplicationLogicWrapper(cls));
            return true;
        }
        return false;
    }

    public void registerProvider(String str, RouterProvider routerProvider) {
        LocalRouter.getInstance().a(str, routerProvider);
    }

    public void route(Context context, RouterRequest routerRequest, RouterCallback routerCallback) {
        LocalRouter.getInstance().a(context, routerRequest, routerCallback);
    }
}
