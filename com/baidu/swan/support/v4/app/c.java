package com.baidu.swan.support.v4.app;

import android.app.Activity;
/* loaded from: classes24.dex */
class c {

    /* loaded from: classes24.dex */
    public interface a {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (activity instanceof a) {
            ((a) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
