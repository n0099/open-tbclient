package com.baidu.android.pushservice;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.android.pushservice.a.a;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.h.u;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PushServiceUtil {
    public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 32;
    public static final int SERVICE_STOPPED_DELAY = 1000;
    private static final String TAG = "PushServiceUtil";
    private static PushServiceUtil mInstance;
    private Context mContext;
    private boolean mExitOnDestroy = false;
    private Handler mHandler = new Handler();
    private boolean initSuc = false;
    private Runnable mDestroyRunnable = new Runnable() { // from class: com.baidu.android.pushservice.PushServiceUtil.1
        @Override // java.lang.Runnable
        public void run() {
            if (PushServiceUtil.this.mContext != null) {
                PushServiceUtil.this.mContext = null;
            }
            g.b();
            if ((!(PushServiceUtil.this.bindCnt > 0) || !(PushServiceUtil.this.mContext != null)) || PushServiceUtil.this.mContext.getPackageName().equals(u.u(PushServiceUtil.this.mContext.getApplicationContext()))) {
                return;
            }
            PushServiceUtil.this.onDestroy();
        }
    };
    private int bindCnt = 0;
    private final a.AbstractBinderC0014a mBinder = new a.AbstractBinderC0014a() { // from class: com.baidu.android.pushservice.PushServiceUtil.2
        @Override // com.baidu.android.pushservice.a.a
        public int a(String str, int i) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public String a() throws RemoteException {
            return null;
        }

        @Override // com.baidu.android.pushservice.a.a
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // com.baidu.android.pushservice.a.a
        public String a(String str, int i, boolean z, int i2, int i3) throws RemoteException {
            return null;
        }

        @Override // com.baidu.android.pushservice.a.a
        public void a(String str, String str2, com.baidu.android.pushservice.a.b bVar) throws RemoteException {
            bVar.b(30602, PushServiceUtil.this.generateResultMsg(str, null));
        }

        @Override // com.baidu.android.pushservice.a.a
        public void a(String str, String str2, boolean z, com.baidu.android.pushservice.a.b bVar) throws RemoteException {
            bVar.a(30602, PushServiceUtil.this.generateResultMsg(str, null));
        }

        @Override // com.baidu.android.pushservice.a.a
        public void a(String str, String str2, boolean z, String str3, com.baidu.android.pushservice.a.b bVar) throws RemoteException {
            bVar.a(30602, PushServiceUtil.this.generateResultMsg(str, str));
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean a(String str, String str2) throws RemoteException {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean a(String str, String str2, int i) throws RemoteException {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean a(String str, String str2, String str3, String str4) throws RemoteException {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean a(String str, boolean z) {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public int b(String str) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public int b(String str, int i) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public String b() throws RemoteException {
            return null;
        }

        @Override // com.baidu.android.pushservice.a.a
        public void b(String str, String str2, com.baidu.android.pushservice.a.b bVar) throws RemoteException {
            bVar.c(30602, PushServiceUtil.this.generateResultMsg(str, null));
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean b(String str, String str2) throws RemoteException {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public int c() throws RemoteException {
            com.baidu.android.pushservice.e.a.c(PushServiceUtil.TAG, "getPushVersion " + ((int) a.a()));
            return a.a();
        }

        @Override // com.baidu.android.pushservice.a.a
        public int c(String str) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public int c(String str, int i) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public int d(String str) throws RemoteException {
            return 0;
        }

        @Override // com.baidu.android.pushservice.a.a
        public boolean e(String str) throws RemoteException {
            return true;
        }

        @Override // com.baidu.android.pushservice.a.a
        public String f(String str) throws RemoteException {
            return null;
        }
    };

    private PushServiceUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateResultMsg(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error", 30602);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("api_key", str2);
            }
            jSONObject.put(PushConstants.EXTRA_ERROR_CODE, "NOT SUPPORTED ANYMORE");
        } catch (Exception e) {
            com.baidu.android.pushservice.e.a.a(TAG, e);
        }
        return jSONObject.toString();
    }

    public static PushServiceUtil getInstance() {
        if (mInstance == null) {
            mInstance = new PushServiceUtil();
        }
        return mInstance;
    }

    private void stopSelf(boolean z, boolean z2) {
        this.mExitOnDestroy = z;
        com.baidu.android.pushservice.e.b.a(TAG, "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, this.mContext.getApplicationContext());
        if (z2) {
            this.mDestroyRunnable.run();
            return;
        }
        this.mHandler.removeCallbacks(this.mDestroyRunnable);
        this.mHandler.postDelayed(this.mDestroyRunnable, 1000L);
    }

    public IBinder onBind(Intent intent) {
        this.bindCnt++;
        com.baidu.android.pushservice.e.a.c(TAG, "onBind(" + this.bindCnt + "), intent=" + intent + " cur: " + this.mContext.getApplicationContext().getPackageName() + " initSuc: " + this.initSuc);
        if (this.initSuc) {
            return this.mBinder;
        }
        return null;
    }

    public void onCreate(Context context) {
        this.mContext = context;
        com.baidu.android.pushservice.e.b.a(TAG, "onCreate from : " + context.getPackageName(), context.getApplicationContext());
        u.b("PushService onCreate from : " + context.getPackageName() + " at Time :" + System.currentTimeMillis(), context.getApplicationContext());
        this.initSuc = g.a(context).a();
        if (this.initSuc) {
            return;
        }
        stopSelf(true, true);
    }

    public void onDestroy() {
        if (this.mContext != null) {
            q.b(this.mContext.getApplicationContext(), (String) null);
            com.baidu.android.pushservice.e.b.a(TAG, "onDestroy from : " + this.mContext.getPackageName(), this.mContext.getApplicationContext());
            u.b("PushService onDestroy from : " + this.mContext.getPackageName() + " at Time :" + System.currentTimeMillis(), this.mContext.getApplicationContext());
        }
        g.b();
        mInstance = null;
        if (this.mExitOnDestroy) {
            Process.killProcess(Process.myPid());
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.mContext == null) {
            return 2;
        }
        if (intent == null) {
            intent = new Intent();
            com.baidu.android.pushservice.e.b.c(TAG, "--- onStart by null intent!", this.mContext.getApplicationContext());
        } else {
            try {
                String uri = intent.toUri(0);
                com.baidu.android.pushservice.e.a.c(TAG, "-- onStartCommand -- " + uri);
                u.b("PushService onStartCommand from " + this.mContext.getPackageName() + " Intent " + uri + " at Time " + System.currentTimeMillis(), this.mContext.getApplicationContext());
            } catch (Exception e) {
                com.baidu.android.pushservice.e.a.a(TAG, e);
            }
        }
        this.mHandler.removeCallbacks(this.mDestroyRunnable);
        if ("com.baidu.android.pushservice.action.CROSS_REQUEST".equals(intent.getAction())) {
            com.baidu.android.pushservice.h.d.a(this.mContext.getApplicationContext(), intent);
        }
        try {
            this.initSuc = g.a(this.mContext).a(intent);
            if (this.initSuc) {
                return 1;
            }
            stopSelf(true, true);
            return 2;
        } catch (Exception e2) {
            com.baidu.android.pushservice.e.a.a(TAG, e2);
            stopSelf(true, true);
            return 2;
        }
    }

    public void onUnbind(Intent intent) {
        this.bindCnt--;
        com.baidu.android.pushservice.e.a.c(TAG, "onUnbind(" + this.bindCnt + "), intent=" + intent);
    }
}
