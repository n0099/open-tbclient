package com.baidu.swan.apps.textarea.c;

import com.baidu.swan.apps.console.c;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bsB;
    private HashMap<String, b> bS = new HashMap<>();

    private a() {
    }

    public static a TI() {
        if (bsB == null) {
            synchronized (a.class) {
                if (bsB == null) {
                    bsB = new a();
                }
            }
        }
        return bsB;
    }

    private b iE(String str) {
        c.d("TextAreaBaseParser", "createTextAreaSecondaryParser slaveId:" + str);
        b bVar = new b();
        this.bS.put(str, bVar);
        return bVar;
    }

    public b iF(String str) {
        c.d("TextAreaBaseParser", "getOrCreateSecondaryParser slaveId:" + str);
        b iG = iG(str);
        if (iG == null) {
            return iE(str);
        }
        return iG;
    }

    public b iG(String str) {
        c.d("TextAreaBaseParser", "getTextAreaSecondaryParser slaveId:" + str);
        return this.bS.get(str);
    }

    public void iH(String str) {
        c.d("TextAreaBaseParser", "destroyTextAreaSecondaryParser slaveId:" + str);
        this.bS.remove(str);
    }
}
