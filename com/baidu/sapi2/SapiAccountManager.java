package com.baidu.sapi2;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.e;
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
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 93;
    public static final String VERSION_NAME = "6.15.6";
    private static SapiAccountManager a;
    private static SapiConfiguration b;
    private static SapiAccountService c;
    private static SilentShareListener d;
    private static ReceiveShareListener e;
    private static GlobalAuthorizationListener f;
    private static final List<String> g = new ArrayList();

    /* loaded from: classes.dex */
    public interface ReceiveShareListener {
        void onReceiveShare();
    }

    /* loaded from: classes.dex */
    public interface SilentShareListener {
        void onSilentShare();
    }

    static {
        g.addAll(Arrays.asList("uid", SESSION_DISPLAYNAME, "bduss"));
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
                        int versionCode = SapiUtils.getVersionCode(sapiConfiguration.context);
                        if (sapiConfiguration.silentShareOnUpgrade && versionCode > c.a(sapiConfiguration.context).w()) {
                            SapiUtils.resetSilentShareStatus(sapiConfiguration.context);
                        }
                        if (versionCode > c.a(sapiConfiguration.context).w()) {
                            SapiUtils.webLogin(sapiConfiguration.context, SapiUtils.getCookieBduss(), "");
                        }
                        c.a(sapiConfiguration.context).a(versionCode);
                        sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
                        sapiConfiguration.clientIp = SapiUtils.getLocalIpAddress();
                        com.baidu.sapi2.share.a.b();
                        if (sapiConfiguration.syncCacheOnInit) {
                            SapiCache.init(sapiConfiguration.context);
                        }
                        if (!TextUtils.isEmpty(sapiConfiguration.deviceLoginSignKey)) {
                            SapiAccountManager.c.deviceLoginCheck();
                        }
                        StatService.a();
                        e.a(sapiConfiguration.context);
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
        return c.a(b.context).d() != null;
    }

    public void logout() {
        StatService.a("logout", Collections.singletonMap("di", com.baidu.sapi2.utils.d.b("sdk_api_logout")));
        removeLoginAccount(getSession());
    }

    public String getSession(String str, String str2) {
        JSONObject jSONObject;
        a();
        SapiAccount session = getSession();
        if (a(str) && isLogin() && session != null && (jSONObject = session.toJSONObject()) != null) {
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
        return c.a(b.context).d();
    }

    public boolean validate(SapiAccount sapiAccount) {
        a();
        if (!SapiUtils.isValidAccount(sapiAccount)) {
            return false;
        }
        com.baidu.sapi2.share.a.a().a(sapiAccount);
        return true;
    }

    public List<SapiAccount> getShareAccounts() {
        a();
        ArrayList arrayList = new ArrayList();
        if (b.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            return arrayList;
        }
        for (SapiAccount sapiAccount : c.a(b.context).f()) {
            if (SapiUtils.isValidAccount(sapiAccount)) {
                arrayList.add(sapiAccount);
            } else {
                c.a(b.context).d(sapiAccount);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        a();
        c.a(b.context).e(sapiAccount);
    }

    public List<SapiAccount> getLoginAccounts() {
        a();
        return c.a(b.context).g();
    }

    boolean a(String str) {
        return !TextUtils.isEmpty(str) && g.contains(str);
    }

    void a() {
        if (b == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " have not been initialized");
        }
    }

    /* loaded from: classes.dex */
    public static abstract class GlobalAuthorizationListener {
        public void onLogoutSuccess(SapiAccount sapiAccount) {
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

    public static void registerGlobalAuthorizationListener(GlobalAuthorizationListener globalAuthorizationListener) {
        f = globalAuthorizationListener;
    }

    public static void unregisterGlobalAuthorizationListener() {
        f = null;
    }

    public static GlobalAuthorizationListener getGlobalAuthorizationListener() {
        return f;
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
