package com.baidu.sapi2.utils;

import android.os.Looper;
import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
/* loaded from: classes2.dex */
public class CommonUtil {
    public static void showErrorNotice(String str) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (!SapiUtils.isDebug(confignation.context) && !confignation.debug) {
            Log.e(str, new Object[0]);
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            Toast.makeText(confignation.context, str, 1).show();
        } else {
            Log.e(str, new Object[0]);
        }
    }

    public static void throwException(String str) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (!SapiUtils.isDebug(confignation.context) && !confignation.debug) {
            Log.e(str, new Object[0]);
            return;
        }
        throw new RuntimeException(str);
    }
}
