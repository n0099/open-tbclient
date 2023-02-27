package com.baidu.searchbox.common.security;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes2.dex */
public final class SecurityUtils {
    public static boolean checkActivityRefuseServiceAndFinish(Activity activity) {
        if (activity != null && checkIntentRefuseService(activity.getIntent())) {
            try {
                activity.finish();
            } catch (Exception unused) {
            }
            return true;
        }
        return false;
    }

    public static boolean checkIntentRefuseService(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            try {
                extras.isEmpty();
                return false;
            } catch (Exception unused) {
                return true;
            }
        }
        return false;
    }
}
