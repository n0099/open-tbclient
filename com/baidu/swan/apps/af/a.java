package com.baidu.swan.apps.af;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.y.f;
/* loaded from: classes11.dex */
public class a {
    public static void a(@NonNull String str, @NonNull String[] strArr, @NonNull int i, @NonNull Context context, @NonNull b bVar) {
        if (com.baidu.swan.uuid.b.c.hasPermission(context, str)) {
            bVar.gQ("permission has already granted");
        } else {
            a(strArr, i, bVar);
        }
    }

    public static void a(@NonNull String str, @NonNull String[] strArr, @NonNull int i, @NonNull b bVar) {
        if (!com.baidu.swan.apps.as.a.hasMarshMallow()) {
            bVar.gQ("it's no need system granted");
        } else if (ActivityCompat.checkSelfPermission(com.baidu.swan.apps.w.a.abN(), str) == 0) {
            bVar.gQ("permission has already granted");
        } else {
            a(strArr, i, bVar);
        }
    }

    public static void a(@NonNull String[] strArr, @NonNull final int i, @NonNull final b bVar) {
        f.aeJ().a(i, strArr, new c.a() { // from class: com.baidu.swan.apps.af.a.1
            @Override // com.baidu.swan.apps.af.c.a
            public void onRequestPermissionsResult(int i2, @NonNull String[] strArr2, @NonNull int[] iArr) {
                if (i2 != i) {
                    b bVar2 = bVar;
                    b bVar3 = bVar;
                    bVar2.M(2, "request permission fail");
                    return;
                }
                for (int i3 : iArr) {
                    if (i3 == -1) {
                        b bVar4 = bVar;
                        b bVar5 = bVar;
                        bVar4.M(1, "user denied");
                        return;
                    }
                }
                bVar.gQ("permission granted successful");
            }
        });
    }
}
