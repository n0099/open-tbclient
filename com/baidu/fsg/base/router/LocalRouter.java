package com.baidu.fsg.base.router;

import android.content.Context;
import com.baidu.fsg.base.utils.LogUtil;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class LocalRouter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1918a = "LocalRouter";

    /* renamed from: b  reason: collision with root package name */
    private static LocalRouter f1919b = null;
    private HashMap<String, RouterProvider> c;
    private Context d;

    private LocalRouter(Context context) {
        this.c = null;
        this.d = context;
        this.c = new HashMap<>();
    }

    public static synchronized LocalRouter init(Context context) {
        LocalRouter localRouter;
        synchronized (LocalRouter.class) {
            if (f1919b == null) {
                f1919b = new LocalRouter(context);
            }
            localRouter = f1919b;
        }
        return localRouter;
    }

    public static synchronized LocalRouter getInstance() {
        LocalRouter localRouter;
        synchronized (LocalRouter.class) {
            if (f1919b == null) {
                throw new RuntimeException("Local Router must be init first");
            }
            localRouter = f1919b;
        }
        return localRouter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, RouterProvider routerProvider) {
        this.c.put(str, routerProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, RouterRequest routerRequest, RouterCallback routerCallback) {
        LogUtil.d(f1918a, "Process:Local route start: " + System.currentTimeMillis());
        LogUtil.d(f1918a, "Process:Local find action start: " + System.currentTimeMillis());
        RouterAction a2 = a(routerRequest);
        LogUtil.d(f1918a, "Process:Local find action end: " + System.currentTimeMillis());
        try {
            a2.invoke(context, routerRequest.getData(), routerCallback);
        } catch (Exception e) {
            e.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("retMsg", e.getMessage());
            routerCallback.onResult(RouterCallback.CODE_ERROR, hashMap);
        }
        LogUtil.d(f1918a, "Process:Local route end: " + System.currentTimeMillis());
    }

    private RouterAction a(RouterRequest routerRequest) {
        RouterProvider routerProvider = this.c.get(routerRequest.getProvider());
        ErrorAction errorAction = new ErrorAction();
        if (routerProvider == null) {
            for (RouterProvider routerProvider2 : this.c.values()) {
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
