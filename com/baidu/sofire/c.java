package com.baidu.sofire;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class c {
    private static Map<String, d> a = new HashMap();

    public static void a(File file, File file2) {
        if (file != null && com.baidu.sofire.b.d.o(file) && file2 != null && com.baidu.sofire.b.d.o(file2)) {
            String str = "f=" + file + ", b=" + file2;
            b.a();
            if (!a.containsKey(file.getAbsolutePath())) {
                d dVar = new d(file.getAbsolutePath(), file2.getAbsolutePath());
                dVar.startWatching();
                a.put(file.getAbsolutePath(), dVar);
            }
        }
    }

    public static void a(File file) {
        if (file != null) {
            String str = "f=" + file.getAbsolutePath();
            b.a();
            d dVar = a.get(file.getAbsolutePath());
            if (dVar != null) {
                dVar.stopWatching();
                a.remove(file.getAbsolutePath());
                dVar.a();
            }
        }
    }
}
