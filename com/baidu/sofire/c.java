package com.baidu.sofire;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, d> f11638a = new HashMap();

    public static void a(Context context, int i, File file, File file2) {
        if (file != null) {
            try {
                if (com.baidu.sofire.g.d.a(file)) {
                    if (!com.baidu.sofire.g.d.a(file2)) {
                        com.baidu.sofire.g.d.a(file, file2);
                    }
                    StringBuilder sb = new StringBuilder("f=");
                    sb.append(file);
                    sb.append(", b=");
                    sb.append(file2);
                    b.a();
                    if (f11638a.containsKey(file.getAbsolutePath())) {
                        return;
                    }
                    d dVar = new d(context, i, file.getAbsolutePath(), file2.getAbsolutePath());
                    dVar.startWatching();
                    f11638a.put(file.getAbsolutePath(), dVar);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
            }
        }
    }

    public static void a(File file) {
        if (file == null) {
            return;
        }
        try {
            new StringBuilder("f=").append(file.getAbsolutePath());
            b.a();
            d dVar = f11638a.get(file.getAbsolutePath());
            if (dVar != null) {
                dVar.stopWatching();
                f11638a.remove(file.getAbsolutePath());
                dVar.a();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }
}
