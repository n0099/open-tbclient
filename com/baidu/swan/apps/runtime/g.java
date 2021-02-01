package com.baidu.swan.apps.runtime;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, Object> dEr;

    public g(e eVar) {
        super(eVar);
        this.dEr = new HashMap();
    }

    public void putString(String str, String str2) {
        q(str, str2);
    }

    public String getString(String str, String str2) {
        try {
            return (String) p(str, str2);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return str2;
        }
    }

    public void a(String str, Boolean bool) {
        q(str, bool);
    }

    public Boolean b(String str, Boolean bool) {
        try {
            return (Boolean) p(str, bool);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return bool;
        }
    }

    public void b(String str, Integer num) {
        q(str, num);
    }

    public Integer c(String str, Integer num) {
        try {
            return (Integer) p(str, num);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return num;
        }
    }

    public void clear() {
        this.dEr.clear();
    }

    public boolean containsKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.dEr.containsKey(str);
    }

    private <V> V p(String str, V v) {
        if (containsKey(str)) {
            if (this.dEr.get(str) == null) {
                return null;
            }
            try {
                return (V) this.dEr.get(str);
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

    private <V> void q(String str, V v) {
        this.dEr.put(str, v);
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        clear();
    }
}
