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

    private b hR(String str) {
        c.d("TextAreaBaseParser", "createTextAreaSecondaryParser slaveId:" + str);
        b bVar = new b();
        this.jk.put(str, bVar);
        return bVar;
    }

    public b hS(String str) {
        c.d("TextAreaBaseParser", "getOrCreateSecondaryParser slaveId:" + str);
        b hT = hT(str);
        if (hT == null) {
            return hR(str);
        }
        return hT;
    }

    public b hT(String str) {
        c.d("TextAreaBaseParser", "getTextAreaSecondaryParser slaveId:" + str);
        return this.jk.get(str);
    }

    public void hU(String str) {
        c.d("TextAreaBaseParser", "destroyTextAreaSecondaryParser slaveId:" + str);
        this.jk.remove(str);
    }
}
