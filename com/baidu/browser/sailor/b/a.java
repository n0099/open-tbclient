package com.baidu.browser.sailor.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.baidu.android.common.util.CommonParam;
import com.baidu.browser.core.BdCore;
import com.baidu.browser.sailor.webkit.loader.BdWebkitManager;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsRouteMessage;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public final class a {
    private static a WD;
    private com.baidu.browser.sailor.b.a.a WF;
    private BdWebkitManager WG;
    private String WH;
    private C0065a WN;
    private HashMap<String, com.baidu.browser.sailor.feature.a> WO;
    private Context mContext;
    private String mCuid;
    private Handler mHandler;
    public static final String TAG = a.class.getName();
    private static SoftReference<String> WE = null;
    private boolean WI = true;
    private boolean WJ = false;
    private boolean WK = false;
    private boolean WL = false;
    private int WM = -1;
    private boolean US = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.browser.sailor.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0065a extends BroadcastReceiver {
        private C0065a() {
        }

        /* synthetic */ C0065a(a aVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == null || !action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            com.baidu.browser.sailor.a.qr().a(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo());
        }
    }

    private a() {
        Log.d(TAG, "BdSailorPlatform");
        this.WF = new com.baidu.browser.sailor.b.a.a();
        this.WG = new BdWebkitManager();
        this.WO = new HashMap<>(4);
    }

    private void a(com.baidu.browser.sailor.feature.a aVar) {
        if (aVar != null) {
            this.WO.put(aVar.getName(), aVar);
        }
    }

    public static boolean a(Activity activity, ValueCallback<Uri> valueCallback) {
        com.baidu.browser.sailor.feature.b.a aVar;
        com.baidu.browser.sailor.feature.a cD = qS().cD("UPLOAD");
        if (cD == null || !cD.isEnable() || (aVar = (com.baidu.browser.sailor.feature.b.a) cD) == null || activity == null) {
            valueCallback.onReceiveValue(null);
            return false;
        }
        return aVar.a(activity, valueCallback);
    }

    public static boolean a(Activity activity, ValueCallback<Uri> valueCallback, String str) {
        com.baidu.browser.sailor.feature.a cD = qS().cD("UPLOAD");
        if (cD == null || !cD.isEnable()) {
            valueCallback.onReceiveValue(null);
        } else {
            com.baidu.browser.sailor.feature.b.a aVar = (com.baidu.browser.sailor.feature.b.a) cD;
            if (aVar != null && activity != null) {
                return aVar.a(activity, valueCallback, str);
            }
        }
        return false;
    }

    public static boolean a(Activity activity, ValueCallback<Uri> valueCallback, String str, String str2) {
        com.baidu.browser.sailor.feature.a cD = qS().cD("UPLOAD");
        if (cD == null || !cD.isEnable()) {
            valueCallback.onReceiveValue(null);
        } else {
            com.baidu.browser.sailor.feature.b.a aVar = (com.baidu.browser.sailor.feature.b.a) cD;
            if (aVar != null && activity != null) {
                return aVar.a(activity, valueCallback, str, str2);
            }
        }
        return false;
    }

    public static String aZ(Context context) {
        return "<html></html>";
    }

    public static boolean b(Activity activity, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        com.baidu.browser.sailor.feature.a cD = qS().cD("UPLOAD");
        if (cD == null || !cD.isEnable()) {
            valueCallback.onReceiveValue(null);
        } else {
            com.baidu.browser.sailor.feature.b.a aVar = (com.baidu.browser.sailor.feature.b.a) cD;
            if (aVar != null && activity != null) {
                return aVar.a(activity, valueCallback, fileChooserParams);
            }
        }
        return false;
    }

    private void bF(int i) {
        this.WM = i;
        if (1 == i || -1 == i) {
            com.baidu.browser.sailor.a.qr().qu().aC(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0058 -> B:22:0x0004). Please submit an issue!!! */
    public boolean ba(Context context) {
        boolean z;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return false;
        }
        try {
            runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        } catch (Exception e) {
            Log.e(TAG, "isAppOnForeground exception");
            e.printStackTrace();
        }
        if (runningAppProcesses == null) {
            z = false;
        } else {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    if (runningAppProcessInfo.importance == 100) {
                        Log.d(TAG, "app is in foreground");
                        z = true;
                    } else {
                        Log.d(TAG, "app is in background");
                        z = false;
                    }
                }
            }
            Log.d(TAG, "app is in background 1");
            z = false;
        }
        return z;
    }

    private void bb(Context context) {
        if (this.US) {
            return;
        }
        a(new com.baidu.browser.sailor.feature.b.a(context));
        a(new com.baidu.browser.sailor.feature.a.b(context));
        this.US = true;
    }

    private boolean cC(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        new File(str).mkdirs();
        return true;
    }

    public static synchronized a qS() {
        a aVar;
        synchronized (a.class) {
            if (WD == null) {
                WD = new a();
            }
            aVar = WD;
        }
        return aVar;
    }

    public static com.baidu.browser.sailor.b.a.a qT() {
        return qS().WF;
    }

    public static BdWebkitManager qU() {
        return qS().WG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qV() {
        if (getAppContext() == null) {
            return;
        }
        if (!com.baidu.browser.core.permission.b.aY(getAppContext())) {
            com.baidu.browser.sailor.util.c.a(new e(this), 500L);
        } else if (this.WN == null) {
            this.WN = new C0065a(this, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getAppContext().registerReceiver(this.WN, intentFilter);
        }
    }

    public final void a(String str, boolean z, Class<? extends CrashCallback> cls) {
        String packageName;
        if (!this.WJ) {
            Log.d(TAG, "initWebkit");
            WebKitFactory.setKernelSessionId(String.valueOf(System.currentTimeMillis()));
            if (this.WG != null) {
                this.WG.a(str, z, cls);
            }
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.browser.sailor.webkit.a rb = com.baidu.browser.sailor.webkit.a.rb();
            Context appContext = getAppContext();
            if (rb.b == null) {
                rb.b = appContext.getApplicationContext();
                Log.d(com.baidu.browser.sailor.webkit.a.a, "in BdWebViewSingleton, init");
            }
            this.WJ = true;
            Log.d("tangxianding", "[START] BdWebViewSingleton init time = " + (System.currentTimeMillis() - currentTimeMillis));
            qV();
            int i = z ? 10 : 3;
            boolean z2 = z;
            if (this.mContext != null && (packageName = this.mContext.getApplicationContext().getPackageName()) != null && packageName.equalsIgnoreCase("com.baidu.searchbox.lite")) {
                z2 = true;
            }
            if (z2) {
                com.baidu.browser.sailor.util.c.a(new c(this), i * 1000);
            }
        }
        com.baidu.browser.sailor.util.c.a(new d(this), 5000L);
    }

    public final void bE(int i) {
        bF(i);
    }

    public final com.baidu.browser.sailor.feature.a cD(String str) {
        com.baidu.browser.sailor.feature.a aVar = this.WO.get(str);
        if (aVar instanceof com.baidu.browser.sailor.feature.a) {
            return aVar;
        }
        return null;
    }

    public final Context getAppContext() {
        return this.mContext;
    }

    public final String getCuid() {
        if (TextUtils.isEmpty(this.mCuid)) {
            this.mCuid = CommonParam.getCUID(this.mContext);
        }
        return this.mCuid;
    }

    public final int getNetworkType() {
        return this.WM;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean init(Context context, String str) {
        boolean z;
        File filesDir;
        Log.d(TAG, AiAppsRouteMessage.TYPE_INIT);
        this.mContext = context;
        if (TextUtils.isEmpty(str)) {
            str = "sailor";
        }
        if (context != null) {
            this.WH = str;
            try {
                if (context.getFilesDir() == null) {
                    new File(context.getApplicationContext().getFilesDir() + "/").mkdirs();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (context.getFilesDir() != null) {
                z = cC(filesDir.getAbsolutePath() + str);
                bb(context);
                BdCore.qi().init(context, false);
                if (this.mHandler == null) {
                    this.mHandler = new b(this, Looper.getMainLooper());
                }
                return z;
            }
        }
        z = false;
        bb(context);
        BdCore.qi().init(context, false);
        if (this.mHandler == null) {
        }
        return z;
    }

    public final boolean qt() {
        return this.WJ;
    }

    public final void setCuid(String str) {
        this.mCuid = str;
    }
}
