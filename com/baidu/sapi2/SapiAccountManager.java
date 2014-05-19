package com.baidu.sapi2;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.sapi2.shell.SapiAccountService;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
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
    public static final int VERSION_CODE = 24;
    public static final String VERSION_NAME = "6.4.10";
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

    public synchronized void init(SapiConfiguration sapiConfiguration) {
        if (sapiConfiguration == null) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " initialized failed: SapiConfiguration can't be null");
        }
        if (b == null) {
            b = sapiConfiguration;
            c = d.a(sapiConfiguration.context);
            d = new SapiAccountService(sapiConfiguration.context);
            SapiCache.a(sapiConfiguration.context);
            com.baidu.sapi2.share.b.c();
            com.baidu.sapi2.utils.a.a.a().a(sapiConfiguration.context);
            com.baidu.sapi2.utils.d.a(sapiConfiguration.context);
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
        return c.d() != null;
    }

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
        if (sapiAccount == null) {
            return false;
        }
        sapiAccount.app = com.baidu.sapi2.utils.c.a(b.context);
        if (SapiUtils.isValidAccount(sapiAccount)) {
            com.baidu.sapi2.share.b.a().a(sapiAccount);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<SapiAccount> a() {
        b();
        List<SapiAccount> e2 = c.e();
        ArrayList arrayList = new ArrayList();
        for (SapiAccount sapiAccount : e2) {
            if (!TextUtils.isEmpty(sapiAccount.displayname) && !TextUtils.isEmpty(sapiAccount.uid) && !TextUtils.isEmpty(sapiAccount.bduss)) {
                arrayList.add(sapiAccount);
            }
        }
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
