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
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.f;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
import com.baidu.sofire.core.e;
import com.baidu.sofire.push.remote.ISocketService;
import com.baidu.sofire.push.remote.ISocketServiceCallback;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class PushConnService extends Service {
    private static final int ERROR_CODE_KILL = 2;
    private static final int ERROR_CODE_RETRY = 1;
    private static final int ERROR_VERSION_OUT = 3;
    public static final String PUSH_SERVICE_ACTION = "com.baidu.sofire.push.service.action";
    private static final int REQUEST_LOCAL_MSG_ERROR_CODE_ARGUMENT = -2;
    private static final int REQUEST_LOCAL_MSG_ERROR_CODE_CALL_ERROR = -7;
    private static final int REQUEST_LOCAL_MSG_ERROR_CODE_DEFULT = -1;
    private static final int REQUEST_LOCAL_MSG_ERROR_CODE_EXCEPTION = -4;
    private static final int REQUEST_LOCAL_MSG_ERROR_CODE_MISS_HOST = -3;
    private static final int REQUEST_LOCAL_MSG_ERROR_CODE_MISS_PLUGIN = -5;
    private static final int REQUEST_LOCAL_MSG_ERROR_CODE_SUCCESS = 1;
    private static final int REQUEST_LOCAL_MSG_ERROR_CODE_TARGET_FUNCTION = -6;
    private static final int REQUEST_RETURN_TYPE_DEFULT = 0;
    private static final int REQUEST_RETURN_TYPE_LOCAL_MSG = 3;
    private static final int REQUEST_RETURN_TYPE_PONG = 1;
    private static final int REQUEST_RETURN_TYPE_QUERY_HOST = 2;
    private static final int REQUEST_TYPE_LOCAL_MESSAGE = 3;
    private static final int REQUEST_TYPE_PING = 1;
    private static final int REQUEST_TYPE_QUERY_HOST = 2;
    private static final int RESPONSE_TYPE_LOCAL_MESSAGE = 4;
    private static final int RESPONSE_TYPE_MESSAGE = 1;
    private static final int RESPONSE_TYPE_PING = 3;
    private static final int RESPONSE_TYPE_VERSION_OUT = 2;
    public static boolean sIsPushServiceProcess = false;
    private static int sPushPluginId = -1;
    private c mFha;
    private String mAppKey = "";
    private String mPushPluginVersion = "";
    private final a<ISocketServiceCallback> mCallbacks = new a<>(this, (byte) 0);
    Map<String, ISocketServiceCallback> mCallbackMap = new HashMap();
    private Callback dataServerCallback = new Callback() { // from class: com.baidu.sofire.push.PushConnService.2
        @Override // com.baidu.sofire.ac.Callback
        public final Object onProgress1(Object... objArr) {
            boolean z;
            try {
                String str = (String) objArr[0];
                int intValue = ((Integer) objArr[1]).intValue();
                long longValue = ((Long) objArr[2]).longValue();
                new StringBuilder("push::onProgress1:type-").append(intValue).append(" ,msgId-").append(longValue);
                byte[] bArr = (byte[]) objArr[3];
                new StringBuilder("push::onProgress1:messageBytes-").append(bArr.length);
                ISocketServiceCallback iSocketServiceCallback = PushConnService.this.mCallbackMap.get(str);
                if (iSocketServiceCallback == null) {
                    PushConnService.this.reportReceiveMessage(str, intValue, longValue, 1);
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("type", 1);
                bundle.putByteArray("data", bArr);
                synchronized (PushConnService.this.mCallbacks) {
                    PushConnService.this.mCallbacks.beginBroadcast();
                    try {
                        z = iSocketServiceCallback.response(bundle).getBoolean("message_result");
                        PushConnService.this.mCallbacks.finishBroadcast();
                    } catch (RemoteException e) {
                        d.a(e);
                        PushConnService.this.mCallbacks.finishBroadcast();
                        z = false;
                    }
                }
                if (z) {
                    PushConnService.this.reportReceiveMessage(str, intValue, longValue, 2);
                } else {
                    PushConnService.this.reportReceiveMessage(str, intValue, longValue, 3);
                }
                return Boolean.valueOf(z);
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
                        if (PushConnService.sPushPluginId != -1) {
                            try {
                                Thread.sleep(60000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            PushConnService.this.startDataServer(PushConnService.sPushPluginId);
                            return null;
                        }
                        return null;
                    case 2:
                        PushConnService.this.reportKillSelf(4);
                        PushConnService.this.stopSelf();
                        Process.killProcess(Process.myPid());
                        return null;
                    case 3:
                        ISocketServiceCallback iSocketServiceCallback = PushConnService.this.mCallbackMap.get(PushConnService.this.mAppKey);
                        if (iSocketServiceCallback != null) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("type", 2);
                            synchronized (PushConnService.this.mCallbacks) {
                                PushConnService.this.mCallbacks.beginBroadcast();
                                try {
                                    iSocketServiceCallback.response(bundle);
                                    PushConnService.this.mCallbacks.finishBroadcast();
                                } catch (RemoteException e2) {
                                    d.a(e2);
                                    PushConnService.this.mCallbacks.finishBroadcast();
                                }
                            }
                        }
                        PushConnService.this.reportKillSelf(6);
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
    private ISocketService.Stub mBinder = new ISocketService.Stub() { // from class: com.baidu.sofire.push.PushConnService.3
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [417=4] */
        @Override // com.baidu.sofire.push.remote.ISocketService
        public final Bundle request(Bundle bundle) throws RemoteException {
            try {
                Bundle bundle2 = new Bundle();
                int i = bundle.getInt(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
                if (i <= 0) {
                    bundle2.putInt("result_code", 0);
                    return bundle2;
                }
                switch (i) {
                    case 1:
                        bundle2.putInt("result_code", 1);
                        return bundle2;
                    case 2:
                        bundle2.putInt("result_code", 2);
                        bundle2.putStringArray("query_host_ret", PushConnService.this.queryHost());
                        return bundle2;
                    case 3:
                        String string = bundle.getString("appkey");
                        int i2 = bundle.getInt("plugin_id");
                        String string2 = bundle.getString("message");
                        bundle2.putInt("result_code", 3);
                        if (TextUtils.isEmpty(string) || i2 <= 0 || TextUtils.isEmpty(string2)) {
                            bundle2.putInt("error_code", -2);
                            return bundle2;
                        }
                        ISocketServiceCallback iSocketServiceCallback = PushConnService.this.mCallbackMap.get(string);
                        if (iSocketServiceCallback == null) {
                            bundle2.putInt("error_code", -3);
                            return bundle2;
                        }
                        synchronized (PushConnService.this.mCallbacks) {
                            PushConnService.this.mCallbacks.beginBroadcast();
                            Bundle bundle3 = new Bundle();
                            bundle3.putInt("type", 4);
                            bundle3.putString("message", string2);
                            bundle3.putInt("plugin_id", i2);
                            Bundle response = iSocketServiceCallback.response(bundle3);
                            switch (response.getInt("local_msg_code")) {
                                case 0:
                                    bundle2.putInt("error_code", 1);
                                    String string3 = response.getString("local_msg_return_msg");
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
                            PushConnService.this.mCallbacks.finishBroadcast();
                        }
                        return bundle2;
                    default:
                        bundle2.putInt("result_code", 0);
                        return bundle2;
                }
            } catch (Throwable th) {
                d.a(th);
                return null;
            }
        }

        @Override // com.baidu.sofire.push.remote.ISocketService
        public final void registerCallback(Bundle bundle, ISocketServiceCallback iSocketServiceCallback) throws RemoteException {
            String str;
            String str2;
            String str3;
            try {
                new StringBuilder("push::Push Service registerCallback called ").append(iSocketServiceCallback);
                String[] packagesForUid = PushConnService.this.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                if (packagesForUid.length > 0) {
                    boolean z = false;
                    for (String str4 : packagesForUid) {
                        z = d.a(PushConnService.this.getApplicationContext(), str4);
                        if (z) {
                            break;
                        }
                    }
                    if (z && iSocketServiceCallback != null) {
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
                                PushConnService.this.mAppKey = str2;
                            }
                            ISocketServiceCallback iSocketServiceCallback2 = PushConnService.this.mCallbackMap.get(str2);
                            if (iSocketServiceCallback2 != null) {
                                PushConnService.this.mCallbacks.unregister(iSocketServiceCallback2);
                            }
                            if (PushConnService.this.mCallbacks.register(iSocketServiceCallback)) {
                                PushConnService.this.mCallbackMap.put(str2, iSocketServiceCallback);
                                c aC = c.aC(PushConnService.this.getApplicationContext());
                                e aD = e.aD(PushConnService.this);
                                ApkInfo cm = aD.cm("com.baidu.sofire.x18");
                                if (cm == null) {
                                    for (int i = 0; i < 10; i++) {
                                        try {
                                            Thread.sleep(3000L);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        cm = aD.cm("com.baidu.sofire.x18");
                                        if (cm != null) {
                                            break;
                                        }
                                    }
                                }
                                new StringBuilder("push::fha:").append(aC).append(",hub:").append(aD).append(",info:").append(cm);
                                if (cm != null) {
                                    if (PushConnService.sPushPluginId == -1) {
                                        int unused = PushConnService.sPushPluginId = cm.key;
                                    }
                                    Pair<Integer, Object> a2 = aC.a(PushConnService.sPushPluginId, "registerHost", new Class[]{String.class, String.class, String.class}, str3, str2, str);
                                    new StringBuilder("push::p:").append(a2.first).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(a2.second);
                                    if (((Integer) a2.first).intValue() != 0) {
                                        PushConnService.this.reportMethodFail("registerHost", (Integer) a2.first);
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

        @Override // com.baidu.sofire.push.remote.ISocketService
        public final void unregisterCallback(Bundle bundle) throws RemoteException {
            try {
                String string = bundle.getString("app_key");
                String string2 = bundle.getString(PushConstants.PACKAGE_NAME);
                new StringBuilder("push::unregisterCallback remove:").append(string2).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(string);
                ISocketServiceCallback iSocketServiceCallback = PushConnService.this.mCallbackMap.get(string);
                new StringBuilder("push::unregisterCallback callbackToRemove:").append(iSocketServiceCallback);
                if (iSocketServiceCallback != null) {
                    PushConnService.this.mCallbacks.unregister(iSocketServiceCallback);
                }
                if (!TextUtils.isEmpty(string)) {
                    PushConnService.this.mCallbackMap.remove(string);
                    new StringBuilder("afterRemove:mCallbackMap:").append(PushConnService.this.mCallbackMap.size());
                    c aC = c.aC(PushConnService.this.getApplicationContext());
                    e aD = e.aD(PushConnService.this);
                    ApkInfo cm = aD.cm("com.baidu.sofire.x18");
                    if (cm == null) {
                        for (int i = 0; i < 10; i++) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            cm = aD.cm("com.baidu.sofire.x18");
                            if (cm != null) {
                                break;
                            }
                        }
                    }
                    if (cm != null) {
                        if (PushConnService.sPushPluginId == -1) {
                            int unused = PushConnService.sPushPluginId = cm.key;
                        }
                        Pair<Integer, Object> a2 = aC.a(PushConnService.sPushPluginId, "unregisterHost", new Class[]{String.class, String.class}, string2, string);
                        new StringBuilder("push::unregisterHost:p:").append(a2.first).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(a2.second);
                        if (((Integer) a2.first).intValue() != 0) {
                            PushConnService.this.reportMethodFail("unregisterHost", (Integer) a2.first);
                        }
                    }
                }
                if (!TextUtils.isEmpty(string2) && PushConnService.this.getApplicationContext().getPackageName().equals(string2)) {
                    PushConnService.this.reportKillSelf(5);
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
            if (PUSH_SERVICE_ACTION.equals(intent.getAction())) {
                return this.mBinder;
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
            sIsPushServiceProcess = true;
            this.mFha = c.aC(getApplicationContext());
            new StringBuilder("push::1 PushService oncreate:").append(getPackageName());
            new Thread(new Runnable() { // from class: com.baidu.sofire.push.PushConnService.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    Pair pair;
                    try {
                        if (!PushConnService.this.mFha.c()) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (!PushConnService.this.mFha.c()) {
                                PushConnService.this.reportInitPushModuleResult(false);
                                PushConnService.this.reportKillSelf(1);
                                PushConnService.this.stopSelf();
                                Process.killProcess(Process.myPid());
                            } else {
                                PushConnService.this.reportInitPushModuleResult(true);
                            }
                        } else {
                            PushConnService.this.reportInitPushModuleResult(true);
                        }
                        e aD = e.aD(PushConnService.this);
                        ApkInfo cm = aD.cm("com.baidu.sofire.x18");
                        new StringBuilder("push::onCreate fha:").append(PushConnService.this.mFha).append(",hub:").append(aD).append(",info:").append(cm);
                        if (cm != null) {
                            PushConnService.this.mPushPluginVersion = cm.versionName;
                        } else {
                            PushConnService.this.reportKillSelf(2);
                            PushConnService.this.stopSelf();
                            Process.killProcess(Process.myPid());
                        }
                        int unused = PushConnService.sPushPluginId = cm.key;
                        Pair startDataServer = PushConnService.this.startDataServer(PushConnService.sPushPluginId);
                        boolean z2 = startDataServer != null && ((Boolean) startDataServer.second).booleanValue();
                        if (((Integer) startDataServer.first).intValue() == 0 && z2) {
                            z = z2;
                            pair = startDataServer;
                        } else {
                            Pair startDataServer2 = PushConnService.this.startDataServer(PushConnService.sPushPluginId);
                            z = startDataServer2 != null && ((Boolean) startDataServer2.second).booleanValue();
                            pair = startDataServer2;
                        }
                        if (((Integer) pair.first).intValue() != 0 || !z) {
                            PushConnService.this.reportKillSelf(3);
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

    protected void reportKillSelf(int i) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.1.0");
            hashMap.put("2", f.c(getApplicationContext()));
            hashMap.put("3", this.mPushPluginVersion);
            hashMap.put("4", Integer.valueOf(i));
            d.a(getApplicationContext(), "1003133", hashMap);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    protected void reportInitPushModuleResult(boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.1.0");
            hashMap.put("2", f.c(getApplicationContext()));
            hashMap.put("3", Integer.valueOf(z ? 1 : 2));
            d.a(getApplicationContext(), "1003130", hashMap);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Integer, Object> startDataServer(int i) {
        try {
            Pair<Integer, Object> a2 = this.mFha.a(i, "startDataServer", new Class[]{Callback.class}, this.dataServerCallback);
            new StringBuilder("push::p:").append(a2.first).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(a2.second);
            if (((Integer) a2.first).intValue() != 0) {
                reportMethodFail("startDataServer", (Integer) a2.first);
            }
            return a2;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    protected void reportReceiveMessage(String str, int i, long j, int i2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.1.0");
            hashMap.put("2", f.c(getApplicationContext()));
            hashMap.put("3", this.mPushPluginVersion);
            hashMap.put("4", Integer.valueOf(i));
            hashMap.put("5", Long.valueOf(j));
            hashMap.put("6", str);
            hashMap.put("7", Integer.valueOf(i2));
            d.a(getApplicationContext(), "1003132", hashMap);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    protected void reportMethodFail(String str, Integer num) {
        new StringBuilder("push::reportMethodFail:").append(str).append("_").append(num);
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.1.0");
            hashMap.put("2", f.c(getApplicationContext()));
            hashMap.put("3", this.mPushPluginVersion);
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

    protected String[] queryHost() {
        try {
            if (this.mCallbackMap == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            synchronized (this.mCallbacks) {
                this.mCallbacks.beginBroadcast();
                for (String str : this.mCallbackMap.keySet()) {
                    ISocketServiceCallback iSocketServiceCallback = this.mCallbackMap.get(str);
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", 3);
                    try {
                        iSocketServiceCallback.response(bundle);
                        arrayList.add(str);
                    } catch (Throwable th) {
                        d.a(th);
                        arrayList2.add(str);
                    }
                }
                this.mCallbacks.finishBroadcast();
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
