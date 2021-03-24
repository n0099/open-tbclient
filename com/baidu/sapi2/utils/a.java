package com.baidu.sapi2.utils;

import android.widget.Toast;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
/* loaded from: classes2.dex */
public class a {
    public static void a(String str) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (!SapiUtils.isDebug(confignation.context) && !confignation.debug) {
            Log.e(str, new Object[0]);
        } else {
            Toast.makeText(confignation.context, str, 1).show();
        }
    }

    public static void b(String str) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (!SapiUtils.isDebug(confignation.context) && !confignation.debug) {
            Log.e(str, new Object[0]);
            return;
        }
        throw new RuntimeException(str);
    }
}
