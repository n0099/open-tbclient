package com.baidu.swan.apps.textarea.c;

import com.baidu.swan.apps.console.c;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a aVs;
    private HashMap<String, b> jk = new HashMap<>();

    private a() {
    }

    public static a Lu() {
        if (aVs == null) {
            synchronized (a.class) {
                if (aVs == null) {
                    aVs = new a();
                }
            }
        }
        return aVs;
    }

    private b hq(String str) {
        c.d("TextAreaBaseParser", "createTextAreaSecondaryParser slaveId:" + str);
        b bVar = new b();
        this.jk.put(str, bVar);
        return bVar;
    }

    public b hr(String str) {
        c.d("TextAreaBaseParser", "getOrCreateSecondaryParser slaveId:" + str);
        b hs = hs(str);
        if (hs == null) {
            return hq(str);
        }
        return hs;
    }

    public b hs(String str) {
        c.d("TextAreaBaseParser", "getTextAreaSecondaryParser slaveId:" + str);
        return this.jk.get(str);
    }

    public void ht(String str) {
        c.d("TextAreaBaseParser", "destroyTextAreaSecondaryParser slaveId:" + str);
        this.jk.remove(str);
    }
}
