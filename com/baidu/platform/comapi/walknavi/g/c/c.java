package com.baidu.platform.comapi.walknavi.g.c;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import java.util.List;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Toast f10129a;

    public static void a(Context context, String str) {
        if (context == null) {
            return;
        }
        List<ActivityManager.RunningTaskInfo> list = null;
        try {
            list = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        } catch (SecurityException unused) {
            Log.e("TipTool", "catch SecurityException");
        }
        if (list == null || list.get(0) == null || !context.getPackageName().equals(list.get(0).baseActivity.getPackageName())) {
            return;
        }
        Toast toast = f10129a;
        if (toast != null) {
            toast.cancel();
        }
        Toast makeText = Toast.makeText(context, str, str.length() <= 15 ? 0 : 1);
        f10129a = makeText;
        makeText.show();
    }
}
