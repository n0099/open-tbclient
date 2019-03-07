package com.baidu.swan.apps.textarea.c;

import com.baidu.swan.apps.c;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    protected static final boolean DEBUG = c.DEBUG;
    private static volatile a aVo;
    private HashMap<String, b> jk = new HashMap<>();

    private a() {
    }

    public static a Lw() {
        if (aVo == null) {
            synchronized (a.class) {
                if (aVo == null) {
                    aVo = new a();
                }
            }
        }
        return aVo;
    }

    private b hp(String str) {
        com.baidu.swan.apps.console.c.d("TextAreaBaseParser", "createTextAreaSecondaryParser slaveId:" + str);
        b bVar = new b();
        this.jk.put(str, bVar);
        return bVar;
    }

    public b hq(String str) {
        com.baidu.swan.apps.console.c.d("TextAreaBaseParser", "getOrCreateSecondaryParser slaveId:" + str);
        b hr = hr(str);
        if (hr == null) {
            return hp(str);
        }
        return hr;
    }

    public b hr(String str) {
        com.baidu.swan.apps.console.c.d("TextAreaBaseParser", "getTextAreaSecondaryParser slaveId:" + str);
        return this.jk.get(str);
    }

    public void hs(String str) {
        com.baidu.swan.apps.console.c.d("TextAreaBaseParser", "destroyTextAreaSecondaryParser slaveId:" + str);
        this.jk.remove(str);
    }
}
