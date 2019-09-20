package com.baidu.swan.apps.textarea.c;

import com.baidu.swan.apps.console.c;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a aZB;
    private HashMap<String, b> jk = new HashMap<>();

    private a() {
    }

    public static a OS() {
        if (aZB == null) {
            synchronized (a.class) {
                if (aZB == null) {
                    aZB = new a();
                }
            }
        }
        return aZB;
    }

    private b ia(String str) {
        c.d("TextAreaBaseParser", "createTextAreaSecondaryParser slaveId:" + str);
        b bVar = new b();
        this.jk.put(str, bVar);
        return bVar;
    }

    public b ib(String str) {
        c.d("TextAreaBaseParser", "getOrCreateSecondaryParser slaveId:" + str);
        b ic = ic(str);
        if (ic == null) {
            return ia(str);
        }
        return ic;
    }

    public b ic(String str) {
        c.d("TextAreaBaseParser", "getTextAreaSecondaryParser slaveId:" + str);
        return this.jk.get(str);
    }

    public void ie(String str) {
        c.d("TextAreaBaseParser", "destroyTextAreaSecondaryParser slaveId:" + str);
        this.jk.remove(str);
    }
}
