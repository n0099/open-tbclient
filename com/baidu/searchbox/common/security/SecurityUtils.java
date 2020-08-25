package com.baidu.searchbox.common.security;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/* loaded from: classes5.dex */
public final class SecurityUtils {
    public static boolean checkActivityRefuseServiceAndFinish(Activity activity) {
        if (activity == null || !checkIntentRefuseService(activity.getIntent())) {
            return false;
        }
        try {
            activity.finish();
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean checkIntentRefuseService(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null) {
            try {
                extras.isEmpty();
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }
}
