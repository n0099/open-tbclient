package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.hostsdk.service.SafeService;
/* loaded from: classes.dex */
public final class SapiSafeFacade {
    private static SapiSafeFacade a;

    private SapiSafeFacade() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized SapiSafeFacade a() {
        SapiSafeFacade sapiSafeFacade;
        synchronized (SapiSafeFacade.class) {
            if (a == null) {
                a = new SapiSafeFacade();
            }
            sapiSafeFacade = a;
        }
        return sapiSafeFacade;
    }

    public String getCurrentZid(Context context) {
        String str = null;
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            str = session.uid;
        }
        String zidAndCheckSafe = getZidAndCheckSafe(context, str, 1);
        return TextUtils.isEmpty(zidAndCheckSafe) ? "NoZidYet" : zidAndCheckSafe;
    }

    public String getZidAndCheckSafe(Context context, String str, int i) {
        return SafeService.getInstance().getZidAndCheckSafe(context, str, i);
    }
}
