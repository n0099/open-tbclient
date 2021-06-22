package com.baidu.sofire;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, d> f10212a = new HashMap();

    public static void a(Context context, int i2, File file, File file2) {
        if (file != null) {
            try {
                if (com.baidu.sofire.utility.c.a(file)) {
                    if (!com.baidu.sofire.utility.c.a(file2)) {
                        com.baidu.sofire.utility.c.a(file, file2);
                    }
                    if (f10212a.containsKey(file.getAbsolutePath())) {
                        return;
                    }
                    d dVar = new d(context, i2, file.getAbsolutePath(), file2.getAbsolutePath());
                    dVar.startWatching();
                    f10212a.put(file.getAbsolutePath(), dVar);
                }
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public static void a(File file) {
        if (file == null) {
            return;
        }
        try {
            d dVar = f10212a.get(file.getAbsolutePath());
            if (dVar != null) {
                dVar.stopWatching();
                f10212a.remove(file.getAbsolutePath());
                dVar.a();
            }
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }
}
