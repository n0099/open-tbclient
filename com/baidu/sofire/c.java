package com.baidu.sofire;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class c {
    private static Map<String, d> a = new HashMap();

    public static void a(Context context, int i, File file, File file2) {
        if (file != null) {
            try {
                if (com.baidu.sofire.i.d.a(file)) {
                    if (!com.baidu.sofire.i.d.a(file2)) {
                        com.baidu.sofire.i.d.a(file, file2);
                    }
                    new StringBuilder("f=").append(file).append(", b=").append(file2);
                    b.a();
                    if (!a.containsKey(file.getAbsolutePath())) {
                        d dVar = new d(context, i, file.getAbsolutePath(), file2.getAbsolutePath());
                        dVar.startWatching();
                        a.put(file.getAbsolutePath(), dVar);
                    }
                }
            } catch (Throwable th) {
                com.baidu.sofire.i.d.a();
            }
        }
    }

    public static void a(File file) {
        if (file != null) {
            try {
                new StringBuilder("f=").append(file.getAbsolutePath());
                b.a();
                d dVar = a.get(file.getAbsolutePath());
                if (dVar != null) {
                    dVar.stopWatching();
                    a.remove(file.getAbsolutePath());
                    dVar.a();
                }
            } catch (Throwable th) {
                com.baidu.sofire.i.d.a();
            }
        }
    }
}
