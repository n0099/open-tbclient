package com.baidu.c.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
@SuppressLint({"NewApi"})
@TargetApi(23)
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public interface a {
        void aU(int i);
    }

    public static void a(Activity activity, String[] strArr, int i) {
        if (activity instanceof a) {
            ((a) activity).aU(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
