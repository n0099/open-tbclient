package com.baidu.sapi2;

import android.app.Activity;
import android.content.Intent;
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
    public static final int VERSION_CODE = 29;
    public static final String VERSION_NAME = "6.5.2";
    private static SapiAccountManager a;
    private static SapiConfiguration b;
    private static d c;
    private static SapiAccountService d;
    private static final List<String> e = new ArrayList();

    static {
        e.addAll(Arrays.asList(SESSION_UID, SESSION_DISPLAYNAME, SESSION_BDUSS, SESSION_PTOKEN, SESSION_STOKEN));
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
            c = d.a(sapiConfiguration.context);
            d = new SapiAccountService(sapiConfiguration.context);
            SapiCache.a(sapiConfiguration.context);
            com.baidu.sapi2.share.b.c();
            new Thread(new Runnable() { // from class: com.baidu.sapi2.SapiAccountManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!TextUtils.isEmpty(sapiConfiguration.deviceLoginSignKey)) {
                        SapiAccountManager.d.i();
                    }
                    SapiAccountManager.c.b(SapiAccountManager.VERSION_NAME);
                    SapiAccountManager.c.a(sapiConfiguration.loginShareStrategy);
                    com.baidu.sapi2.utils.b.a(sapiConfiguration.context);
                }
            }).start();
        } else {
            L.w("Try to reinitialize " + getClass().getSimpleName() + " which had already been initialized before", new Object[0]);
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
        return c.d() != null;
    }

    @Deprecated
    public void login(Intent intent) {
        b();
        if (intent == null) {
            throw new IllegalArgumentException("Intent can't be null");
        }
        intent.setFlags(268435456);
        b.context.startActivity(intent);
    }

    public void logout() {
        b();
        com.baidu.sapi2.share.b.a().b();
    }

    @Deprecated
    public void fillUsername(Activity activity, Class cls, int i) {
        b();
        activity.startActivityForResult(new Intent(activity, cls), i);
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
        return c.d();
    }

    public boolean validate(SapiAccount sapiAccount) {
        b();
        if (!SapiUtils.isValidAccount(sapiAccount)) {
            return false;
        }
        sapiAccount.app = SapiUtils.getAppName(b.context);
        com.baidu.sapi2.share.b.a().a(sapiAccount);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<SapiAccount> a() {
        b();
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
        b();
        c.e(sapiAccount);
    }

    public List<SapiAccount> getLoginAccounts() {
        b();
        return c.f();
    }

    boolean a(String str) {
        return !TextUtils.isEmpty(str) && e.contains(str);
    }

    void b() {
        if (b == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " have not been initialized");
        }
    }
}
