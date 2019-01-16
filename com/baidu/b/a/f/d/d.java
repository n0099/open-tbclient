package com.baidu.b.a.f.d;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
/* loaded from: classes2.dex */
public class d {
    private static Vector<com.baidu.b.a.c.a.a> aai = new Vector<>();

    private static int c(com.baidu.b.a.b.c.b bVar) {
        Map<String, Integer> options = bVar.getOptions();
        if (options == null || !options.containsKey("download_ret_type")) {
            return 0;
        }
        return options.get("download_ret_type").intValue();
    }

    public static boolean a(com.baidu.b.a.b.c.b bVar, com.baidu.b.a.c.a.a aVar) {
        if (bVar == null || aVar == null) {
            return false;
        }
        aVar.ZE = c(bVar);
        if (aVar.ZE == 1) {
            if (aai.contains(aVar)) {
                Iterator<com.baidu.b.a.c.a.a> it = aai.iterator();
                long j = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.b.a.c.a.a next = it.next();
                    j += next.ZF;
                    if (j > 16777216) {
                        aVar.ZE = 0;
                        aai.remove(next);
                        break;
                    }
                }
            } else if (aai.size() < 16777216) {
                aai.add(aVar);
            } else {
                aVar.ZE = 0;
            }
        }
        return aVar.ZE == 0;
    }

    public static void f(com.baidu.b.a.c.a.a aVar) {
        aai.remove(aVar);
        aVar.fileData = null;
    }
}
