package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class SapiSafeFacade {
    public static final int DEVICE_AUTH_TOKEN_EVENT_ID = 122;
    public static final int GET_ZID_DEFAULT_EVENT_ID = 120;

    /* renamed from: a  reason: collision with root package name */
    private static SapiSafeFacade f3164a;

    private SapiSafeFacade() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized SapiSafeFacade a() {
        SapiSafeFacade sapiSafeFacade;
        synchronized (SapiSafeFacade.class) {
            if (f3164a == null) {
                f3164a = new SapiSafeFacade();
            }
            sapiSafeFacade = f3164a;
        }
        return sapiSafeFacade;
    }

    public String getCurrentZid(Context context) {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        String zidAndCheckSafe = getZidAndCheckSafe(context, currentAccount != null ? currentAccount.uid : null, 1);
        return TextUtils.isEmpty(zidAndCheckSafe) ? "NoZidYet" : zidAndCheckSafe;
    }

    public String getDeviceAuthToken(Context context, String str, int i) {
        return com.baidu.sapi2.utils.c.a().a(context, SapiAccountManager.getInstance().getSapiConfiguration().tpl, str, i);
    }

    public String getZidAndCheckSafe(Context context, String str, int i) {
        return com.baidu.sapi2.utils.c.a().a(context, str, i);
    }
}
