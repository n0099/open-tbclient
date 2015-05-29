package com.baidu.sapi2;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiAccountManager {
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_PTOKEN = "ptoken";
    public static final String SESSION_STOKEN = "stoken";
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 55;
    public static final String VERSION_NAME = "6.10.1";
    private static SapiAccountManager a;
    private static SapiConfiguration b;
    private static SapiAccountService c;
    private static SilentShareListener d;
    private static ReceiveShareListener e;
    private static final List<String> f = new ArrayList();

    /* loaded from: classes.dex */
    public interface ReceiveShareListener {
        void onReceiveShare();
    }

    /* loaded from: classes.dex */
    public interface SilentShareListener {
        void onSilentShare();
    }

    static {
        f.addAll(Arrays.asList("uid", SESSION_DISPLAYNAME, SESSION_BDUSS, SESSION_PTOKEN, SESSION_STOKEN));
    }

    public static synchronized SapiAccountManager getInstance() {
        SapiAccountManager sapiAccountManager;
        synchronized (SapiAccountManager.class) {
            if (a == null) {
                a = new SapiAccountManager();
            }
            sapiAccountManager = a;
        }
        return sapiAccountManager;
    }

    private SapiAccountManager() {
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration) {
        if (sapiConfiguration == null) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " initialized failed: SapiConfiguration can't be null");
        }
        if (b == null) {
            b = sapiConfiguration;
            c = new SapiAccountService(sapiConfiguration.context);
            if (c(sapiConfiguration.context)) {
                new Thread(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Looper.prepare();
                        int versionCode = SapiUtils.getVersionCode(sapiConfiguration.context);
                        if (sapiConfiguration.silentShareOnUpgrade && versionCode > d.a(sapiConfiguration.context).z()) {
                            SapiUtils.resetSilentShareStatus(sapiConfiguration.context);
                        }
                        d.a(sapiConfiguration.context).c(versionCode);
                        sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
                        sapiConfiguration.clientIp = SapiUtils.getLocalIpAddress();
                        com.baidu.sapi2.share.b.b();
                        if (sapiConfiguration.syncCacheOnInit) {
                            SapiCache.init(sapiConfiguration.context);
                        }
                        if (!TextUtils.isEmpty(sapiConfiguration.deviceLoginSignKey)) {
                            SapiAccountManager.c.deviceLoginCheck();
                        }
                        com.baidu.sapi2.utils.a.a();
                        d.a(sapiConfiguration.context).b(SapiAccountManager.VERSION_NAME);
                        d.a(sapiConfiguration.context).a(sapiConfiguration.loginShareStrategy());
                        com.baidu.sapi2.utils.c.a(sapiConfiguration.context);
                        Looper.loop();
                    }
                }).start();
            }
        } else {
            L.d(getClass().getSimpleName() + " had already been initialized", new Object[0]);
        }
    }

    public SapiConfiguration getSapiConfiguration() {
        a();
        return b;
    }

    public SapiAccountService getAccountService() {
        a();
        return c;
    }

    public boolean isLogin() {
        a();
        return d.a(b.context).d() != null;
    }

    public void logout() {
        removeLoginAccount(getSession());
    }

    public String getSession(String str, String str2) {
        JSONObject jSONObject;
        a();
        if (a(str) && isLogin() && getSession() != null && (jSONObject = getSession().toJSONObject()) != null) {
            return jSONObject.optString(str, str2);
        }
        return str2;
    }

    public String getSession(String str) {
        a();
        return getSession(str, null);
    }

    public SapiAccount getSession() {
        a();
        return d.a(b.context).d();
    }

    public boolean validate(SapiAccount sapiAccount) {
        a();
        if (!SapiUtils.isValidAccount(sapiAccount)) {
            return false;
        }
        com.baidu.sapi2.share.b.a().a(sapiAccount);
        return true;
    }

    public List<SapiAccount> getShareAccounts() {
        a();
        ArrayList arrayList = new ArrayList();
        if (b.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            return arrayList;
        }
        for (SapiAccount sapiAccount : d.a(b.context).e()) {
            if (SapiUtils.isValidAccount(sapiAccount)) {
                arrayList.add(sapiAccount);
            } else {
                d.a(b.context).d(sapiAccount);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        a();
        d.a(b.context).e(sapiAccount);
    }

    public List<SapiAccount> getLoginAccounts() {
        a();
        return d.a(b.context).f();
    }

    boolean a(String str) {
        return !TextUtils.isEmpty(str) && f.contains(str);
    }

    void a() {
        if (b == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " have not been initialized");
        }
    }

    public static void registerSilentShareListener(SilentShareListener silentShareListener) {
        d = silentShareListener;
    }

    public static void unregisterSilentShareListener() {
        d = null;
    }

    public static SilentShareListener getSilentShareListener() {
        return d;
    }

    public static void registerReceiveShareListener(ReceiveShareListener receiveShareListener) {
        e = receiveShareListener;
    }

    public static void unregisterReceiveShareListener() {
        e = null;
    }

    public static ReceiveShareListener getReceiveShareListener() {
        return e;
    }

    static String a(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable th) {
            L.e(th);
        }
        return "";
    }

    static String b(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).processName;
        } catch (Throwable th) {
            L.e(th);
            return "";
        }
    }

    static boolean c(Context context) {
        String a2 = a(context);
        String b2 = b(context);
        return TextUtils.isEmpty(a2) || TextUtils.isEmpty(b2) || a2.equals(b2);
    }
}
