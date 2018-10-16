package com.baidu.searchbox.ng.ai.apiservice;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class APIServiceManager {
    private static final boolean DEBUG = false;
    private static final Map<String, Class<?>> SERVICES = new HashMap();
    private static final Map<String, Object> CACHES = new HashMap();

    static {
        registerAllServices();
    }

    public static synchronized <SERVICE> SERVICE getServiceByName(String str) {
        SERVICE service;
        synchronized (APIServiceManager.class) {
            if (str != null) {
                if (!str.isEmpty()) {
                    service = (SERVICE) CACHES.get(str);
                    if (service == null) {
                        Class<?> cls = SERVICES.get(str);
                        if (cls != null) {
                            try {
                                service = (SERVICE) cls.newInstance();
                                CACHES.put(str, service);
                            } catch (Exception e) {
                            }
                        }
                        service = null;
                    }
                }
            }
            service = null;
        }
        return service;
    }

    public static synchronized void registerService(String str, Class<?> cls) {
        synchronized (APIServiceManager.class) {
            if (str != null) {
                if (!str.isEmpty() && cls != null) {
                    SERVICES.put(str, cls);
                }
            }
        }
    }

    public static synchronized void registerService(String str, Object obj) {
        synchronized (APIServiceManager.class) {
            if (str != null) {
                if (!str.isEmpty() && obj != null) {
                    CACHES.put(str, obj);
                }
            }
        }
    }

    public static synchronized void unRegisterService(String str) {
        synchronized (APIServiceManager.class) {
            if (str != null) {
                if (!str.isEmpty()) {
                    CACHES.remove(str);
                }
            }
        }
    }

    private static void registerAllServices() {
    }
}
