package com.baidu.swan.apps.ad;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public class a {
    public static void a(@NonNull String str, @NonNull String[] strArr, @NonNull int i, @NonNull Context context, @NonNull b bVar) {
        if (com.baidu.swan.uuid.b.c.hasPermission(context, str)) {
            bVar.hg("permission has already granted");
        } else {
            a(strArr, i, bVar);
        }
    }

    public static void a(@NonNull String str, @NonNull String[] strArr, @NonNull int i, @NonNull b bVar) {
        if (!com.baidu.swan.apps.aq.b.hasMarshMallow()) {
            bVar.hg("it's no need system granted");
        } else if (ActivityCompat.checkSelfPermission(com.baidu.swan.apps.u.a.afX(), str) == 0) {
            bVar.hg("permission has already granted");
        } else {
            a(strArr, i, bVar);
        }
    }

    public static void a(@NonNull String[] strArr, @NonNull final int i, @NonNull final b bVar) {
        f.ajb().a(i, strArr, new c.a() { // from class: com.baidu.swan.apps.ad.a.1
            @Override // com.baidu.swan.apps.ad.c.a
            public void onRequestPermissionsResult(int i2, @NonNull String[] strArr2, @NonNull int[] iArr) {
                if (i2 != i) {
                    b bVar2 = bVar;
                    b bVar3 = bVar;
                    bVar2.O(2, "request permission fail");
                    return;
                }
                for (int i3 : iArr) {
                    if (i3 == -1) {
                        b bVar4 = bVar;
                        b bVar5 = bVar;
                        bVar4.O(1, "user denied");
                        return;
                    }
                }
                bVar.hg("permission granted successful");
            }
        });
    }
}
