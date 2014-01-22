package com.baidu.sapi2;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.shell.SapiAccountService;
import com.baidu.sapi2.utils.L;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class SapiAccountManager {
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_PTOKEN = "ptoken";
    public static final String SESSION_STOKEN = "stoken";
    public static final String SESSION_UID = "uid";
    public static final int VERSION_CODE = 11;
    public static final String VERSION_NAME = "6.3.0";
    private static SapiAccountManager a;
    private static SapiConfiguration b;
    private static d c;
    private static SapiAccountService d;
    private static final List<String> e = new ArrayList();

    static {
        e.addAll(Arrays.asList(SESSION_UID, SESSION_DISPLAYNAME, "bduss", SESSION_PTOKEN, SESSION_STOKEN));
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

    public synchronized void init(SapiConfiguration sapiConfiguration) {
        if (sapiConfiguration == null) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " initialized failed: SapiConfiguration can't be null");
        }
        if (b == null) {
            b = sapiConfiguration;
            c = d.a(sapiConfiguration.context);
            c.a(sapiConfiguration);
            com.baidu.sapi2.utils.a.a.a().a(sapiConfiguration.context);
            d = new SapiAccountService(sapiConfiguration.context);
            SapiCache.a(sapiConfiguration.context);
        } else {
            L.w("Try to reinitialize SapiAccountManager which had already been initialized before", new Object[0]);
        }
    }

    public SapiConfiguration getSapiConfiguration() {
        b();
        return b;
    }

    public SapiAccountService getAccountService() {
        b();
        return d;
    }

    public boolean isLogin() {
        b();
        return c.b() != null;
    }

    public void login(Intent intent) {
        b();
        intent.setFlags(268435456);
        b.context.startActivity(intent);
        com.baidu.sapi2.utils.a.a.a().a("openloginact", 0L, 0L);
    }

    public void logout() {
        b();
        com.baidu.sapi2.b.a.a().b();
    }

    public String getSession(String str, String str2) {
        JSONObject jSONObject;
        b();
        if (str != null && str.trim().length() != 0 && a(str) && isLogin() && (jSONObject = getSession().toJSONObject()) != null) {
            return jSONObject.optString(str, str2);
        }
        return str2;
    }

    public String getSession(String str) {
        b();
        return getSession(str, null);
    }

    public SapiAccount getSession() {
        b();
        return c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<SapiAccount> a() {
        b();
        return c.c();
    }

    boolean a(String str) {
        return !TextUtils.isEmpty(str) && e.contains(str);
    }

    void b() {
        if (b == null) {
            try {
                init(c.a());
            } catch (Throwable th) {
                throw new IllegalStateException(getClass().getSimpleName() + " have not been initialized");
            }
        }
    }
}
