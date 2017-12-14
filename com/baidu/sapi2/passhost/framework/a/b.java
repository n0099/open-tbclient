package com.baidu.sapi2.passhost.framework.a;

import android.content.Context;
import com.baidu.appsearchlib.Info;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.hostsdk.service.SafeService;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.hostsdk.service.d;
import com.baidu.sapi2.passhost.pluginsdk.service.IServiceCenter;
import com.baidu.sapi2.passhost.pluginsdk.service.IServiceName;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public class b implements IServiceCenter, IServiceName {
    private static final String a = "ServiceCenter";
    private ReentrantReadWriteLock b;
    private HashMap<String, Object> c;

    /* loaded from: classes.dex */
    private static class a {
        public static b a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.a;
    }

    private b() {
        this.b = new ReentrantReadWriteLock();
        this.c = new HashMap<>();
    }

    public void a(Context context) {
        boolean z = com.baidu.sapi2.passhost.hostsdk.service.a.b(context) && ServiceManager.getInstance().getIsAccountManager().getConfignation().lowerUpdateFreq;
        com.baidu.sapi2.passhost.framework.a.a.a().a(context);
        d.a().a(context);
        com.baidu.sapi2.passhost.hostsdk.service.a.a().a(z);
        com.baidu.sapi2.passhost.hostsdk.service.a.a().a(context);
        if (!z) {
            com.baidu.sapi2.passhost.hostsdk.service.b.a().a(context);
            com.baidu.sapi2.passhost.hostsdk.service.b.a().b();
        }
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.IServiceCenter
    public Object getService(int i, int i2) {
        Log.d(a, "getService()", Integer.valueOf(i), Integer.valueOf(i2));
        this.b.readLock().lock();
        Object obj = this.c.get("" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2);
        this.b.readLock().unlock();
        if (obj == null) {
            try {
                return a(i, i2);
            } catch (Throwable th) {
                Log.e(a, "getService()", "serviceName", Info.kBaiduPIDKey, th.toString());
                return obj;
            }
        }
        return obj;
    }

    private Object a(int i, int i2) {
        Object obj;
        String str = null;
        Log.d(a, "createService()", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                str = "" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
                this.b.readLock().lock();
                obj = this.c.get(str);
                this.b.readLock().unlock();
                if (obj == null) {
                    Log.i(a, "create service: " + str);
                    obj = ThreadPoolService.getInstance();
                    Log.i(a, "create service: " + str, obj.getClass());
                    break;
                }
                break;
            case 2:
                str = "" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
                this.b.readLock().lock();
                obj = this.c.get(str);
                this.b.readLock().unlock();
                if (obj == null) {
                    obj = com.baidu.sapi2.passhost.hostsdk.service.a.a();
                    Log.i(a, "create service: " + str);
                    break;
                }
                break;
            case 3:
                str = "" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
                this.b.readLock().lock();
                obj = this.c.get(str);
                this.b.readLock().unlock();
                if (obj == null) {
                    obj = d.a();
                    Log.i(a, "create service: " + str);
                    break;
                }
                break;
            case 4:
                str = "" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
                this.b.readLock().lock();
                obj = this.c.get(str);
                this.b.readLock().unlock();
                if (obj == null) {
                    obj = com.baidu.sapi2.passhost.hostsdk.service.b.a();
                    Log.i(a, "create service: " + str);
                    break;
                }
                break;
            case 5:
                str = "" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
                this.b.readLock().lock();
                obj = this.c.get(str);
                this.b.readLock().unlock();
                if (obj == null) {
                    obj = SafeService.getInstance();
                    Log.i(a, "create service: " + str);
                    break;
                }
                break;
            case 6:
                str = "" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
                this.b.readLock().lock();
                obj = this.c.get(str);
                this.b.readLock().unlock();
                if (obj == null) {
                    obj = ServiceManager.getInstance().getIsAccountManager();
                    Log.i(a, "create service: " + str);
                    break;
                }
                break;
            case 7:
                str = "" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
                this.b.readLock().lock();
                obj = this.c.get(str);
                this.b.readLock().unlock();
                if (obj == null) {
                    obj = com.baidu.sapi2.passhost.framework.a.a.a();
                    Log.i(a, "create service: " + str);
                    break;
                }
                break;
            default:
                obj = null;
                break;
        }
        if (str != null && obj != null) {
            this.b.writeLock().lock();
            this.c.put(str, obj);
            this.b.writeLock().unlock();
        }
        return obj;
    }
}
