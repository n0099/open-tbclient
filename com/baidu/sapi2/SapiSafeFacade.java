package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SafeService;
/* loaded from: classes2.dex */
public final class SapiSafeFacade {
    public static final int DEVICE_AUTH_TOKEN_EVENT_ID = 122;
    public static final int GET_ZID_DEFAULT_EVENT_ID = 120;
    public static SapiSafeFacade instance;

    public static synchronized SapiSafeFacade getInstance() {
        SapiSafeFacade sapiSafeFacade;
        synchronized (SapiSafeFacade.class) {
            if (instance == null) {
                instance = new SapiSafeFacade();
            }
            sapiSafeFacade = instance;
        }
        return sapiSafeFacade;
    }

    public String getCurrentZid(Context context) {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        String zidAndCheckSafe = getZidAndCheckSafe(context, currentAccount != null ? currentAccount.uid : null, 1);
        return TextUtils.isEmpty(zidAndCheckSafe) ? "NoZidYet" : zidAndCheckSafe;
    }

    public String getDeviceAuthToken(Context context, String str, int i2) {
        return SafeService.getInstance().getDeviceAuthToken(context, SapiAccountManager.getInstance().getSapiConfiguration().tpl, str, i2);
    }

    public String getZidAndCheckSafe(Context context, String str, int i2) {
        return SafeService.getInstance().getZidAndCheckSafe(context, str, i2);
    }
}
