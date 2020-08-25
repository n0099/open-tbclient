package com.baidu.searchbox.network.core.connect;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.network.HttpManager;
import com.baidu.searchbox.network.core.Dns;
import com.baidu.searchbox.network.core.RequestClient;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
/* loaded from: classes14.dex */
public class CronetDelegator implements IHttpDelegator {
    private static final boolean DEBUG = false;
    private static final long DEFAULT_CACHE_SIZE = 10485760;
    private static final String TAG = CronetDelegator.class.getSimpleName();
    private Object mCronetEngine;
    private Class mCronetEngineAppStateEnumClazz;
    private Method mGetEffectiveConnectionTypeMethod;
    private int mLastEffectiveConnectionType = -1;
    private Method mNotifyBdAppStatusChangeMethod;
    private Method mOpenConnectionMethod;
    private RequestClient mRequest;

    /* loaded from: classes14.dex */
    public enum AppState {
        APP_STATE_BACKGROUND,
        APP_STATE_FOREGROUND
    }

    public void notifyCronetAppState(AppState appState) {
        if (this.mCronetEngine != null && this.mNotifyBdAppStatusChangeMethod != null && this.mCronetEngineAppStateEnumClazz != null) {
            try {
                if (this.mCronetEngineAppStateEnumClazz.isEnum()) {
                    this.mNotifyBdAppStatusChangeMethod.invoke(this.mCronetEngine, Enum.valueOf(this.mCronetEngineAppStateEnumClazz, appState.name()));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    public CronetDelegator(Context context, RequestClient requestClient) {
        try {
            this.mRequest = requestClient;
            Class<?> cls = Class.forName("com.baidu.webkit.sdk.WebViewFactory");
            ClassLoader classLoader = cls.getDeclaredMethod("getProvider", new Class[0]).invoke(cls, new Object[0]).getClass().getClassLoader();
            Class<?> cls2 = Class.forName("org.chromium.net.CronetEngine$Builder", true, classLoader);
            Object newInstance = cls2.getDeclaredConstructor(Context.class).newInstance(context);
            if (this.mRequest != null && this.mRequest.isPreconnectEnable()) {
                newInstance = newInstance.getClass().getDeclaredMethod("addPreconnPrefixes", String.class).invoke(newInstance.getClass().getDeclaredMethod("enablePreconn", Boolean.TYPE).invoke(newInstance, true), "https://mbd.baidu.com|2");
            }
            if (this.mRequest != null && this.mRequest.isNQEEnable()) {
                newInstance = newInstance.getClass().getDeclaredMethod("enableNetworkQualityEstimator", Boolean.TYPE).invoke(newInstance, true);
            }
            Class<?> cls3 = Class.forName("org.chromium.net.HostResolver", true, classLoader);
            Method declaredMethod = newInstance.getClass().getDeclaredMethod("setHostResolver", cls3);
            CronetInvocationHandler cronetInvocationHandler = new CronetInvocationHandler();
            Object invoke = declaredMethod.invoke(newInstance, Proxy.newProxyInstance(classLoader, new Class[]{cls3}, cronetInvocationHandler));
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                cls2.getDeclaredMethod("setAppPackageName", String.class).invoke(invoke, packageName);
            }
            this.mCronetEngine = cls2.getDeclaredMethod("build", new Class[0]).invoke(invoke, new Object[0]);
            Class<?> cls4 = Class.forName("org.chromium.net.CronetEngine", true, classLoader);
            if (this.mRequest != null && this.mRequest.isNQEEnable()) {
                Class<?> cls5 = Class.forName("org.chromium.net.NetworkQualityRttListener", true, classLoader);
                Class<?> cls6 = Class.forName("org.chromium.net.NetworkQualityThroughputListener", true, classLoader);
                Method declaredMethod2 = cls4.getDeclaredMethod("addRttListener", cls5);
                Method declaredMethod3 = cls4.getDeclaredMethod("addThroughputListener", cls6);
                this.mGetEffectiveConnectionTypeMethod = cls4.getDeclaredMethod("getEffectiveConnectionType", new Class[0]);
                declaredMethod2.invoke(this.mCronetEngine, Proxy.newProxyInstance(classLoader, new Class[]{cls5}, cronetInvocationHandler));
                declaredMethod3.invoke(this.mCronetEngine, Proxy.newProxyInstance(classLoader, new Class[]{cls6}, cronetInvocationHandler));
            }
            this.mOpenConnectionMethod = cls4.getDeclaredMethod("openConnection", URL.class);
            this.mCronetEngineAppStateEnumClazz = Class.forName("org.chromium.net.CronetEngine$AppState", true, classLoader);
            this.mNotifyBdAppStatusChangeMethod = cls4.getDeclaredMethod("notifyBdAppStatusChange", this.mCronetEngineAppStateEnumClazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.network.core.connect.IHttpDelegator
    public HttpURLConnection openHttpURLConnection(URL url) throws IOException {
        try {
            if (this.mOpenConnectionMethod != null && this.mCronetEngine != null) {
                return (HttpURLConnection) this.mOpenConnectionMethod.invoke(this.mCronetEngine, url);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
        return (HttpURLConnection) url.openConnection();
    }

    @Override // com.baidu.searchbox.network.core.connect.IHttpDelegator
    public void setRequestClient(RequestClient requestClient) {
        this.mRequest = requestClient;
    }

    /* loaded from: classes14.dex */
    private class CronetInvocationHandler implements InvocationHandler {
        private CronetInvocationHandler() {
        }

        /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
        @Override // java.lang.reflect.InvocationHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            List<InetAddress> lookup;
            String name = method.getName();
            if ("resolve".equalsIgnoreCase(name)) {
                String str = (String) objArr[0];
                Dns httpDns = CronetDelegator.this.mRequest.getHttpDns();
                if (httpDns != null) {
                    try {
                        lookup = httpDns.lookup(str);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    if (lookup != null) {
                        return new ArrayList();
                    }
                    return lookup;
                }
                lookup = null;
                if (lookup != null) {
                }
            } else {
                if ("onRTTOrThroughputEstimatesComputed".equalsIgnoreCase(name)) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    ((Integer) objArr[1]).intValue();
                    ((Integer) objArr[2]).intValue();
                    int intValue2 = ((Integer) CronetDelegator.this.mGetEffectiveConnectionTypeMethod.invoke(CronetDelegator.this.mCronetEngine, new Object[0])).intValue();
                    if (intValue2 == 0) {
                        RequestClient.sNetworkQuality = -1;
                    } else if (intValue2 == 1) {
                        RequestClient.sNetworkQuality = 3;
                    } else if (intValue2 == 2 || intValue2 == 3 || intValue > 1000.0d) {
                        RequestClient.sNetworkQuality = 2;
                    } else {
                        RequestClient.sNetworkQuality = 1;
                    }
                    if (CronetDelegator.this.mLastEffectiveConnectionType != intValue2) {
                        for (final HttpManager.NetworkQualityListener networkQualityListener : RequestClient.sNetworkQualityListeners) {
                            try {
                                networkQualityListener.getExecutor().execute(new Runnable() { // from class: com.baidu.searchbox.network.core.connect.CronetDelegator.CronetInvocationHandler.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (networkQualityListener != null) {
                                            networkQualityListener.onNetworkQualityChanged(RequestClient.sNetworkQuality);
                                        }
                                    }
                                });
                            } catch (Exception e2) {
                                Log.e(CronetDelegator.TAG, "Exception posting task to executor", e2);
                            }
                        }
                        CronetDelegator.this.mLastEffectiveConnectionType = intValue2;
                    }
                }
                if ("getExecutor".equalsIgnoreCase(name)) {
                    return Executors.newCachedThreadPool();
                }
                return null;
            }
        }
    }
}
