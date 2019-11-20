package com.baidu.swan.apps.textarea.c;

import com.baidu.swan.apps.console.c;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a brK;
    private HashMap<String, b> br = new HashMap<>();

    private a() {
    }

    public static a TG() {
        if (brK == null) {
            synchronized (a.class) {
                if (brK == null) {
                    brK = new a();
                }
            }
        }
        return brK;
    }

    private b iE(String str) {
        c.d("TextAreaBaseParser", "createTextAreaSecondaryParser slaveId:" + str);
        b bVar = new b();
        this.br.put(str, bVar);
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
        return this.br.get(str);
    }

    public void iH(String str) {
        c.d("TextAreaBaseParser", "destroyTextAreaSecondaryParser slaveId:" + str);
        this.br.remove(str);
    }
}
