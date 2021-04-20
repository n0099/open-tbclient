package com.baidu.fsg.base.router;

import android.content.Context;
import com.baidu.fsg.base.utils.LogUtil;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class LocalRouter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5285a = "LocalRouter";

    /* renamed from: b  reason: collision with root package name */
    public static LocalRouter f5286b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, RouterProvider> f5287c;

    /* renamed from: d  reason: collision with root package name */
    public Context f5288d;

    public LocalRouter(Context context) {
        this.f5287c = null;
        this.f5288d = context;
        this.f5287c = new HashMap<>();
    }

    public static synchronized LocalRouter getInstance() {
        LocalRouter localRouter;
        synchronized (LocalRouter.class) {
            if (f5286b != null) {
                localRouter = f5286b;
            } else {
                throw new RuntimeException("Local Router must be init first");
            }
        }
        return localRouter;
    }

    public static synchronized LocalRouter init(Context context) {
        LocalRouter localRouter;
        synchronized (LocalRouter.class) {
            if (f5286b == null) {
                f5286b = new LocalRouter(context);
            }
            localRouter = f5286b;
        }
        return localRouter;
    }

    public void a(String str, RouterProvider routerProvider) {
        this.f5287c.put(str, routerProvider);
    }

    public void a(Context context, RouterRequest routerRequest, RouterCallback routerCallback) {
        LogUtil.d("LocalRouter", "Process:Local route start: " + System.currentTimeMillis());
        LogUtil.d("LocalRouter", "Process:Local find action start: " + System.currentTimeMillis());
        RouterAction a2 = a(routerRequest);
        LogUtil.d("LocalRouter", "Process:Local find action end: " + System.currentTimeMillis());
        try {
            a2.invoke(context, routerRequest.getData(), routerCallback);
        } catch (Exception e2) {
            e2.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("retMsg", e2.getMessage());
            routerCallback.onResult(RouterCallback.CODE_ERROR, hashMap);
        }
        LogUtil.d("LocalRouter", "Process:Local route end: " + System.currentTimeMillis());
    }

    private RouterAction a(RouterRequest routerRequest) {
        RouterProvider routerProvider = this.f5287c.get(routerRequest.getProvider());
        ErrorAction errorAction = new ErrorAction();
        if (routerProvider == null) {
            for (RouterProvider routerProvider2 : this.f5287c.values()) {
                RouterAction findAction = routerProvider2.findAction(routerRequest.getAction());
                if (findAction != null) {
                    return findAction;
                }
            }
            return errorAction;
        }
        return routerProvider.findAction(routerRequest.getAction());
    }
}
