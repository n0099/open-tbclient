package com.baidu.sofire;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, d> f5201a = new HashMap();

    public static void a(Context context, int i, File file, File file2) {
        if (file != null) {
            try {
                if (com.baidu.sofire.i.e.a(file)) {
                    if (!com.baidu.sofire.i.e.a(file2)) {
                        com.baidu.sofire.i.e.a(file, file2);
                    }
                    new StringBuilder("f=").append(file).append(", b=").append(file2);
                    b.a();
                    if (!f5201a.containsKey(file.getAbsolutePath())) {
                        d dVar = new d(context, i, file.getAbsolutePath(), file2.getAbsolutePath());
                        dVar.startWatching();
                        f5201a.put(file.getAbsolutePath(), dVar);
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
            }
        }
    }

    public static void a(File file) {
        if (file != null) {
            try {
                new StringBuilder("f=").append(file.getAbsolutePath());
                b.a();
                d dVar = f5201a.get(file.getAbsolutePath());
                if (dVar != null) {
                    dVar.stopWatching();
                    f5201a.remove(file.getAbsolutePath());
                    dVar.a();
                }
            } catch (Throwable th) {
                com.baidu.sofire.i.e.a();
            }
        }
    }
}
