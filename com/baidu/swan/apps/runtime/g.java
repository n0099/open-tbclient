package com.baidu.swan.apps.runtime;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, Object> bPn;

    public g(e eVar) {
        super(eVar);
        this.bPn = new HashMap();
    }

    public void putString(String str, String str2) {
        m(str, str2);
    }

    public String getString(String str, String str2) {
        try {
            return (String) l(str, str2);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return str2;
        }
    }

    public void a(String str, Boolean bool) {
        m(str, bool);
    }

    public Boolean b(String str, Boolean bool) {
        try {
            return (Boolean) l(str, bool);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return bool;
        }
    }

    public void a(String str, Integer num) {
        m(str, num);
    }

    public Integer b(String str, Integer num) {
        try {
            return (Integer) l(str, num);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return num;
        }
    }

    public void clear() {
        this.bPn.clear();
    }

    public boolean containsKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.bPn.containsKey(str);
    }

    private <V> V l(String str, V v) {
        if (containsKey(str)) {
            if (this.bPn.get(str) == null) {
                return null;
            }
            try {
                return (V) this.bPn.get(str);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return v;
                }
                return v;
            }
        }
        return v;
    }

    private <V> void m(String str, V v) {
        this.bPn.put(str, v);
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        clear();
    }
}
