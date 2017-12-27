package com.baidu.sofire.push;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.b.d;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.e;
import com.baidu.sofire.push.a.a;
import com.baidu.sofire.push.a.b;
import com.baidu.tbadk.core.atomData.SocialLoginActivityConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class PushConnService extends Service {
    public static final String a = "com.baidu.sofire.push.service.action";
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static final int k = 1;
    private static final int l = 2;
    private static final int m = 3;
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;
    private static final int r = 1;
    private static final int s = -1;
    private static final int t = -2;
    private static final int u = -3;
    private static final int v = -4;
    private static final int w = -5;
    private static final int x = -6;
    private static final int y = -7;
    private c C;
    public static boolean b = false;
    private static int z = -1;
    private String A = "";
    private String B = "";
    private final a<b> D = new a<>(this, (byte) 0);
    Map<String, b> c = new HashMap();
    private Callback E = new Callback() { // from class: com.baidu.sofire.push.PushConnService.2
        @Override // com.baidu.sofire.ac.Callback
        public final Object onProgress1(Object... objArr) {
            boolean z2;
            try {
                String str = (String) objArr[0];
                int intValue = ((Integer) objArr[1]).intValue();
                long longValue = ((Long) objArr[2]).longValue();
                new StringBuilder("push::onProgress1:type-").append(intValue).append(" ,msgId-").append(longValue);
                byte[] bArr = (byte[]) objArr[3];
                new StringBuilder("push::onProgress1:messageBytes-").append(bArr.length);
                b bVar = PushConnService.this.c.get(str);
                if (bVar == null) {
                    PushConnService.this.a(str, intValue, longValue, 1);
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("type", 1);
                bundle.putByteArray("data", bArr);
                synchronized (PushConnService.this.D) {
                    PushConnService.this.D.beginBroadcast();
                    try {
                        z2 = bVar.a(bundle).getBoolean("message_result");
                        PushConnService.this.D.finishBroadcast();
                    } catch (RemoteException e2) {
                        d.a(e2);
                        PushConnService.this.D.finishBroadcast();
                        z2 = false;
                    }
                }
                if (z2) {
                    PushConnService.this.a(str, intValue, longValue, 2);
                } else {
                    PushConnService.this.a(str, intValue, longValue, 3);
                }
                return Boolean.valueOf(z2);
            } catch (Throwable th) {
                d.a(th);
                return false;
            }
        }

        @Override // com.baidu.sofire.ac.Callback
        public final Object onError(Object... objArr) {
            try {
                switch (((Integer) objArr[0]).intValue()) {
                    case 1:
                        if (PushConnService.z != -1) {
                            try {
                                Thread.sleep(60000L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            PushConnService.this.c(PushConnService.z);
                            return null;
                        }
                        return null;
                    case 2:
                        PushConnService.this.a(4);
                        PushConnService.this.stopSelf();
                        Process.killProcess(Process.myPid());
                        return null;
                    case 3:
                        b bVar = PushConnService.this.c.get(PushConnService.this.A);
                        if (bVar != null) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("type", 2);
                            synchronized (PushConnService.this.D) {
                                PushConnService.this.D.beginBroadcast();
                                try {
                                    bVar.a(bundle);
                                    PushConnService.this.D.finishBroadcast();
                                } catch (RemoteException e3) {
                                    d.a(e3);
                                    PushConnService.this.D.finishBroadcast();
                                }
                            }
                        }
                        PushConnService.this.a(6);
                        PushConnService.this.stopSelf();
                        Process.killProcess(Process.myPid());
                        return null;
                    default:
                        return null;
                }
            } catch (Throwable th) {
                d.a(th);
                return null;
            }
        }
    };
    private a.AbstractBinderC0063a F = new a.AbstractBinderC0063a() { // from class: com.baidu.sofire.push.PushConnService.3
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [417=4] */
        @Override // com.baidu.sofire.push.a.a
        public final Bundle a(Bundle bundle) throws RemoteException {
            try {
                Bundle bundle2 = new Bundle();
                int i2 = bundle.getInt("action_type");
                if (i2 <= 0) {
                    bundle2.putInt(SocialLoginActivityConfig.RESULT_CODE, 0);
                    return bundle2;
                }
                switch (i2) {
                    case 1:
                        bundle2.putInt(SocialLoginActivityConfig.RESULT_CODE, 1);
                        return bundle2;
                    case 2:
                        bundle2.putInt(SocialLoginActivityConfig.RESULT_CODE, 2);
                        bundle2.putStringArray("query_host_ret", PushConnService.this.a());
                        return bundle2;
                    case 3:
                        String string = bundle.getString("appkey");
                        int i3 = bundle.getInt("plugin_id");
                        String string2 = bundle.getString("message");
                        bundle2.putInt(SocialLoginActivityConfig.RESULT_CODE, 3);
                        if (TextUtils.isEmpty(string) || i3 <= 0 || TextUtils.isEmpty(string2)) {
                            bundle2.putInt("error_code", -2);
                            return bundle2;
                        }
                        b bVar = PushConnService.this.c.get(string);
                        if (bVar == null) {
                            bundle2.putInt("error_code", -3);
                            return bundle2;
                        }
                        synchronized (PushConnService.this.D) {
                            PushConnService.this.D.beginBroadcast();
                            Bundle bundle3 = new Bundle();
                            bundle3.putInt("type", 4);
                            bundle3.putString("message", string2);
                            bundle3.putInt("plugin_id", i3);
                            Bundle a2 = bVar.a(bundle3);
                            switch (a2.getInt("local_msg_code")) {
                                case 0:
                                    bundle2.putInt("error_code", 1);
                                    String string3 = a2.getString("local_msg_return_msg");
                                    if (!TextUtils.isEmpty(string3)) {
                                        bundle2.putString("ret_msg", string3);
                                        break;
                                    }
                                    break;
                                case 1:
                                    bundle2.putInt("error_code", -7);
                                    break;
                                case 2:
                                    bundle2.putInt("error_code", -6);
                                    break;
                                case 3:
                                    bundle2.putInt("error_code", -7);
                                    break;
                                case 4:
                                    bundle2.putInt("error_code", -5);
                                    break;
                            }
                            PushConnService.this.D.finishBroadcast();
                        }
                        return bundle2;
                    default:
                        bundle2.putInt(SocialLoginActivityConfig.RESULT_CODE, 0);
                        return bundle2;
                }
            } catch (Throwable th) {
                d.a(th);
                return null;
            }
        }

        @Override // com.baidu.sofire.push.a.a
        public final void a(Bundle bundle, b bVar) throws RemoteException {
            String str;
            String str2;
            String str3;
            try {
                new StringBuilder("push::Push Service registerCallback called ").append(bVar);
                String[] packagesForUid = PushConnService.this.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                if (packagesForUid.length > 0) {
                    boolean z2 = false;
                    for (String str4 : packagesForUid) {
                        z2 = d.a(PushConnService.this.getApplicationContext(), str4);
                        if (z2) {
                            break;
                        }
                    }
                    if (z2 && bVar != null) {
                        if (bundle != null) {
                            str3 = bundle.getString(PushConstants.PACKAGE_NAME);
                            str2 = bundle.getString("app_key");
                            str = bundle.getString("last_ids");
                        } else {
                            str = null;
                            str2 = null;
                            str3 = null;
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            if (str3.equals(PushConnService.this.getApplicationContext().getPackageName())) {
                                PushConnService.this.A = str2;
                            }
                            b bVar2 = PushConnService.this.c.get(str2);
                            if (bVar2 != null) {
                                PushConnService.this.D.unregister(bVar2);
                            }
                            if (PushConnService.this.D.register(bVar)) {
                                PushConnService.this.c.put(str2, bVar);
                                c aB = c.aB(PushConnService.this.getApplicationContext());
                                e aC = e.aC(PushConnService.this);
                                ApkInfo cf = aC.cf("com.baidu.sofire.x18");
                                if (cf == null) {
                                    for (int i2 = 0; i2 < 10; i2++) {
                                        try {
                                            Thread.sleep(3000L);
                                        } catch (InterruptedException e2) {
                                            e2.printStackTrace();
                                        }
                                        cf = aC.cf("com.baidu.sofire.x18");
                                        if (cf != null) {
                                            break;
                                        }
                                    }
                                }
                                new StringBuilder("push::fha:").append(aB).append(",hub:").append(aC).append(",info:").append(cf);
                                if (cf != null) {
                                    if (PushConnService.z == -1) {
                                        int unused = PushConnService.z = cf.key;
                                    }
                                    Pair<Integer, Object> a2 = aB.a(PushConnService.z, "registerHost", new Class[]{String.class, String.class, String.class}, str3, str2, str);
                                    new StringBuilder("push::p:").append(a2.first).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(a2.second);
                                    if (((Integer) a2.first).intValue() != 0) {
                                        PushConnService.this.a("registerHost", (Integer) a2.first);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }

        @Override // com.baidu.sofire.push.a.a
        public final void b(Bundle bundle) throws RemoteException {
            try {
                String string = bundle.getString("app_key");
                String string2 = bundle.getString(PushConstants.PACKAGE_NAME);
                new StringBuilder("push::unregisterCallback remove:").append(string2).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(string);
                b bVar = PushConnService.this.c.get(string);
                new StringBuilder("push::unregisterCallback callbackToRemove:").append(bVar);
                if (bVar != null) {
                    PushConnService.this.D.unregister(bVar);
                }
                if (!TextUtils.isEmpty(string)) {
                    PushConnService.this.c.remove(string);
                    new StringBuilder("afterRemove:mCallbackMap:").append(PushConnService.this.c.size());
                    c aB = c.aB(PushConnService.this.getApplicationContext());
                    e aC = e.aC(PushConnService.this);
                    ApkInfo cf = aC.cf("com.baidu.sofire.x18");
                    if (cf == null) {
                        for (int i2 = 0; i2 < 10; i2++) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            cf = aC.cf("com.baidu.sofire.x18");
                            if (cf != null) {
                                break;
                            }
                        }
                    }
                    if (cf != null) {
                        if (PushConnService.z == -1) {
                            int unused = PushConnService.z = cf.key;
                        }
                        Pair<Integer, Object> a2 = aB.a(PushConnService.z, "unregisterHost", new Class[]{String.class, String.class}, string2, string);
                        new StringBuilder("push::unregisterHost:p:").append(a2.first).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(a2.second);
                        if (((Integer) a2.first).intValue() != 0) {
                            PushConnService.this.a("unregisterHost", (Integer) a2.first);
                        }
                    }
                }
                if (!TextUtils.isEmpty(string2) && PushConnService.this.getApplicationContext().getPackageName().equals(string2)) {
                    PushConnService.this.a(5);
                    PushConnService.this.stopSelf();
                    Process.killProcess(Process.myPid());
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            new StringBuilder("push::1 PushService onBind()").append(getPackageName());
            if (a.equals(intent.getAction())) {
                return this.F;
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            super.onCreate();
            b = true;
            this.C = c.aB(getApplicationContext());
            new StringBuilder("push::1 PushService oncreate:").append(getPackageName());
            new Thread(new Runnable() { // from class: com.baidu.sofire.push.PushConnService.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z2;
                    Pair pair;
                    try {
                        if (!PushConnService.this.C.c()) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            if (!PushConnService.this.C.c()) {
                                PushConnService.this.a(false);
                                PushConnService.this.a(1);
                                PushConnService.this.stopSelf();
                                Process.killProcess(Process.myPid());
                            } else {
                                PushConnService.this.a(true);
                            }
                        } else {
                            PushConnService.this.a(true);
                        }
                        e aC = e.aC(PushConnService.this);
                        ApkInfo cf = aC.cf("com.baidu.sofire.x18");
                        new StringBuilder("push::onCreate fha:").append(PushConnService.this.C).append(",hub:").append(aC).append(",info:").append(cf);
                        if (cf != null) {
                            PushConnService.this.B = cf.versionName;
                        } else {
                            PushConnService.this.a(2);
                            PushConnService.this.stopSelf();
                            Process.killProcess(Process.myPid());
                        }
                        int unused = PushConnService.z = cf.key;
                        Pair c = PushConnService.this.c(PushConnService.z);
                        boolean z3 = c != null && ((Boolean) c.second).booleanValue();
                        if (((Integer) c.first).intValue() == 0 && z3) {
                            z2 = z3;
                            pair = c;
                        } else {
                            Pair c2 = PushConnService.this.c(PushConnService.z);
                            z2 = c2 != null && ((Boolean) c2.second).booleanValue();
                            pair = c2;
                        }
                        if (((Integer) pair.first).intValue() != 0 || !z2) {
                            PushConnService.this.a(3);
                            PushConnService.this.stopSelf();
                            Process.killProcess(Process.myPid());
                        }
                    } catch (Throwable th) {
                        d.a(th);
                    }
                }
            }).start();
        } catch (Throwable th) {
            d.a(th);
        }
    }

    protected void a(int i2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.0.6.1");
            hashMap.put("2", com.baidu.sofire.b.e.c(getApplicationContext()));
            hashMap.put("3", this.B);
            hashMap.put("4", Integer.valueOf(i2));
            d.a(getApplicationContext(), "1003133", hashMap);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    protected void a(boolean z2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.0.6.1");
            hashMap.put("2", com.baidu.sofire.b.e.c(getApplicationContext()));
            hashMap.put("3", Integer.valueOf(z2 ? 1 : 2));
            d.a(getApplicationContext(), "1003130", hashMap);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Integer, Object> c(int i2) {
        try {
            Pair<Integer, Object> a2 = this.C.a(i2, "startDataServer", new Class[]{Callback.class}, this.E);
            new StringBuilder("push::p:").append(a2.first).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(a2.second);
            if (((Integer) a2.first).intValue() != 0) {
                a("startDataServer", (Integer) a2.first);
            }
            return a2;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    protected void a(String str, int i2, long j2, int i3) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.0.6.1");
            hashMap.put("2", com.baidu.sofire.b.e.c(getApplicationContext()));
            hashMap.put("3", this.B);
            hashMap.put("4", Integer.valueOf(i2));
            hashMap.put("5", Long.valueOf(j2));
            hashMap.put("6", str);
            hashMap.put("7", Integer.valueOf(i3));
            d.a(getApplicationContext(), "1003132", hashMap);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    protected void a(String str, Integer num) {
        new StringBuilder("push::reportMethodFail:").append(str).append("_").append(num);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.0.6.1");
            hashMap.put("2", com.baidu.sofire.b.e.c(getApplicationContext()));
            hashMap.put("3", this.B);
            hashMap.put("4", str);
            hashMap.put("5", num);
            d.a(getApplicationContext(), "1003131", hashMap);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a<E extends IInterface> extends RemoteCallbackList<E> {
        private a() {
        }

        /* synthetic */ a(PushConnService pushConnService, byte b) {
            this();
        }

        @Override // android.os.RemoteCallbackList
        public final void onCallbackDied(E e) {
            super.onCallbackDied(e);
        }

        @Override // android.os.RemoteCallbackList
        public final void onCallbackDied(E e, Object obj) {
            super.onCallbackDied(e, obj);
        }
    }

    protected String[] a() {
        try {
            if (this.c == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            synchronized (this.D) {
                this.D.beginBroadcast();
                for (String str : this.c.keySet()) {
                    b bVar = this.c.get(str);
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", 3);
                    try {
                        bVar.a(bundle);
                        arrayList.add(str);
                    } catch (Throwable th) {
                        d.a(th);
                        arrayList2.add(str);
                    }
                }
                this.D.finishBroadcast();
            }
            if (arrayList.size() > 0) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return null;
        } catch (Throwable th2) {
            d.a(th2);
            return null;
        }
    }
}
