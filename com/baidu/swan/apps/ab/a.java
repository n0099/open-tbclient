package com.baidu.swan.apps.ab;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.ab.c;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String TAG = "RequestPermissionHelper";

    public static void a(@NonNull String str, @NonNull String[] strArr, @NonNull int i, @NonNull Context context, @NonNull b bVar) {
        if (context == null || !(context instanceof Activity)) {
            bVar.ai(2, "context should be activity ref");
        } else if (com.baidu.swan.uuid.b.c.hasPermission(context, str)) {
            bVar.jC("permission has already granted");
        } else {
            a(context, strArr, i, bVar);
        }
    }

    public static void a(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull b bVar) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!com.baidu.swan.uuid.b.c.hasPermission(context, str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            a(context, (String[]) arrayList.toArray(new String[0]), i, bVar);
        } else {
            bVar.jC("permission has already granted");
        }
    }

    public static void a(Context context, String[] strArr, final int i, @NonNull final b bVar) {
        if (context == null || !(context instanceof SwanAppBaseActivity)) {
            bVar.ai(2, "method should be called after setActivityRef");
            if (DEBUG) {
                throw new IllegalStateException("this method should be called after setActivityRef");
            }
            return;
        }
        ((SwanAppBaseActivity) context).a(i, strArr, new c.a() { // from class: com.baidu.swan.apps.ab.a.1
            @Override // com.baidu.swan.apps.ab.c.a
            public void onRequestPermissionsResult(int i2, @NonNull String[] strArr2, @NonNull int[] iArr) {
                if (i2 != i) {
                    b bVar2 = bVar;
                    b bVar3 = bVar;
                    bVar2.ai(2, "request permission fail");
                    return;
                }
                for (int i3 : iArr) {
                    if (i3 == -1) {
                        b bVar4 = bVar;
                        b bVar5 = bVar;
                        bVar4.ai(1, "user denied");
                        return;
                    }
                }
                bVar.jC("permission granted successful");
            }
        });
    }
}
