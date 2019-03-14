package com.baidu.swan.apps.textarea.c;

import com.baidu.swan.apps.console.c;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a aVp;
    private HashMap<String, b> jk = new HashMap<>();

    private a() {
    }

    public static a Lw() {
        if (aVp == null) {
            synchronized (a.class) {
                if (aVp == null) {
                    aVp = new a();
                }
            }
        }
        return aVp;
    }

    private b hp(String str) {
        c.d("TextAreaBaseParser", "createTextAreaSecondaryParser slaveId:" + str);
        b bVar = new b();
        this.jk.put(str, bVar);
        return bVar;
    }

    public b hq(String str) {
        c.d("TextAreaBaseParser", "getOrCreateSecondaryParser slaveId:" + str);
        b hr = hr(str);
        if (hr == null) {
            return hp(str);
        }
        return hr;
    }

    public b hr(String str) {
        c.d("TextAreaBaseParser", "getTextAreaSecondaryParser slaveId:" + str);
        return this.jk.get(str);
    }

    public void hs(String str) {
        c.d("TextAreaBaseParser", "destroyTextAreaSecondaryParser slaveId:" + str);
        this.jk.remove(str);
    }
}
