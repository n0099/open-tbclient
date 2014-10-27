package com.baidu.sapi2;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.shell.SapiAccountService;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
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
    public static final int VERSION_CODE = 40;
    public static final String VERSION_NAME = "6.7.7";
    private static SapiAccountManager a;
    private static SapiConfiguration b;
    private static c c;
    private static SapiAccountService d;
    private static SilentShareListener e;
    private static ReceiveShareListener f;
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
        g.addAll(Arrays.asList(SESSION_UID, SESSION_DISPLAYNAME, SESSION_BDUSS, SESSION_PTOKEN, SESSION_STOKEN));
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
            c = c.a(sapiConfiguration.context);
            d = new SapiAccountService(sapiConfiguration.context);
            new Thread(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1
                @Override // java.lang.Runnable
                public void run() {
                    Looper.prepare();
                    sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
                    sapiConfiguration.clientIp = SapiUtils.getLocalIpAddress();
                    com.baidu.sapi2.share.c.c();
                    if (sapiConfiguration.syncCacheOnInit) {
                        SapiCache.init(sapiConfiguration.context);
                    }
                    if (!TextUtils.isEmpty(sapiConfiguration.deviceLoginSignKey)) {
                        SapiAccountManager.d.n();
                    }
                    com.baidu.sapi2.utils.b.a();
                    SapiAccountManager.c.b(SapiAccountManager.VERSION_NAME);
                    SapiAccountManager.c.a(sapiConfiguration.loginShareStrategy());
                    com.baidu.sapi2.utils.c.a(sapiConfiguration.context);
                    Looper.loop();
                }
            }).start();
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
        return d;
    }

    public boolean isLogin() {
        a();
        return c.d() != null;
    }

    @Deprecated
    public void login(Intent intent) {
        a();
        if (intent == null) {
            throw new IllegalArgumentException("Intent can't be null");
        }
        intent.setFlags(268435456);
        b.context.startActivity(intent);
    }

    public void logout() {
        a();
        com.baidu.sapi2.share.c.a().b();
    }

    @Deprecated
    public void fillUsername(Activity activity, Class cls, int i) {
        a();
        activity.startActivityForResult(new Intent(activity, cls), i);
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
        return c.d();
    }

    public boolean validate(SapiAccount sapiAccount) {
        a();
        if (!SapiUtils.isValidAccount(sapiAccount)) {
            return false;
        }
        com.baidu.sapi2.share.c.a().a(sapiAccount);
        return true;
    }

    public List<SapiAccount> getShareAccounts() {
        a();
        List<SapiAccount> e2 = c.e();
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : e2) {
            if (SapiUtils.isValidAccount(sapiAccount)) {
                arrayList.add(sapiAccount);
            } else {
                c.d(sapiAccount);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public void removeLoginAccount(SapiAccount sapiAccount) {
        a();
        c.e(sapiAccount);
    }

    public List<SapiAccount> getLoginAccounts() {
        a();
        return c.f();
    }

    boolean a(String str) {
        return !TextUtils.isEmpty(str) && g.contains(str);
    }

    void a() {
        if (b == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " have not been initialized");
        }
    }

    public static void registerSilentShareListener(SilentShareListener silentShareListener) {
        e = silentShareListener;
    }

    public static void unregisterSilentShareListener() {
        e = null;
    }

    public static SilentShareListener getSilentShareListener() {
        return e;
    }

    public static void registerReceiveShareListener(ReceiveShareListener receiveShareListener) {
        f = receiveShareListener;
    }

    public static void unregisterReceiveShareListener() {
        f = null;
    }

    public static ReceiveShareListener getReceiveShareListener() {
        return f;
    }
}
