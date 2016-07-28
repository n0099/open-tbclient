package com.baidu.a.a;

import android.app.Activity;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public interface a {
        void aN(int i);
    }

    public static void a(Activity activity, String[] strArr, int i) {
        if (activity instanceof a) {
            ((a) activity).aN(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
