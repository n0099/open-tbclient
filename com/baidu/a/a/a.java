package com.baidu.a.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class a extends com.baidu.a.b.a {

    /* renamed from: com.baidu.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0000a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void a(Activity activity, String[] strArr, int i) {
        if (com.baidu.a.a.nn()) {
            c.a(activity, strArr, i);
        } else if (activity instanceof InterfaceC0000a) {
            a(activity, strArr, i, (InterfaceC0000a) activity);
        }
    }

    public static void a(Activity activity, String[] strArr, int i, InterfaceC0000a interfaceC0000a) {
        if (com.baidu.a.a.nn()) {
            c.a(activity, strArr, i);
        } else if (!activity.isFinishing() && interfaceC0000a != null) {
            new Handler(Looper.getMainLooper()).post(new b(strArr, activity, interfaceC0000a, i));
        }
    }
}
