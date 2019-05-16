package com.baidu.swan.apps.textarea.c;

import com.baidu.swan.apps.console.c;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a aYt;
    private HashMap<String, b> jk = new HashMap<>();

    private a() {
    }

    public static a NZ() {
        if (aYt == null) {
            synchronized (a.class) {
                if (aYt == null) {
                    aYt = new a();
                }
            }
        }
        return aYt;
    }

    private b hS(String str) {
        c.d("TextAreaBaseParser", "createTextAreaSecondaryParser slaveId:" + str);
        b bVar = new b();
        this.jk.put(str, bVar);
        return bVar;
    }

    public b hT(String str) {
        c.d("TextAreaBaseParser", "getOrCreateSecondaryParser slaveId:" + str);
        b hU = hU(str);
        if (hU == null) {
            return hS(str);
        }
        return hU;
    }

    public b hU(String str) {
        c.d("TextAreaBaseParser", "getTextAreaSecondaryParser slaveId:" + str);
        return this.jk.get(str);
    }

    public void hV(String str) {
        c.d("TextAreaBaseParser", "destroyTextAreaSecondaryParser slaveId:" + str);
        this.jk.remove(str);
    }
}
