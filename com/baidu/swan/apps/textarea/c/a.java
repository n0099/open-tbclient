package com.baidu.swan.apps.textarea.c;

import com.baidu.swan.apps.console.c;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a aZd;
    private HashMap<String, b> jk = new HashMap<>();

    private a() {
    }

    public static a OO() {
        if (aZd == null) {
            synchronized (a.class) {
                if (aZd == null) {
                    aZd = new a();
                }
            }
        }
        return aZd;
    }

    private b hY(String str) {
        c.d("TextAreaBaseParser", "createTextAreaSecondaryParser slaveId:" + str);
        b bVar = new b();
        this.jk.put(str, bVar);
        return bVar;
    }

    public b hZ(String str) {
        c.d("TextAreaBaseParser", "getOrCreateSecondaryParser slaveId:" + str);
        b ia = ia(str);
        if (ia == null) {
            return hY(str);
        }
        return ia;
    }

    public b ia(String str) {
        c.d("TextAreaBaseParser", "getTextAreaSecondaryParser slaveId:" + str);
        return this.jk.get(str);
    }

    public void ib(String str) {
        c.d("TextAreaBaseParser", "destroyTextAreaSecondaryParser slaveId:" + str);
        this.jk.remove(str);
    }
}
