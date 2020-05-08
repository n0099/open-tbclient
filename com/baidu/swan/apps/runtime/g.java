package com.baidu.swan.apps.runtime;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, Object> coq;

    public g(e eVar) {
        super(eVar);
        this.coq = new HashMap();
    }

    public void putString(String str, String str2) {
        r(str, str2);
    }

    public String getString(String str, String str2) {
        try {
            return (String) q(str, str2);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return str2;
        }
    }

    public void a(String str, Boolean bool) {
        r(str, bool);
    }

    public Boolean b(String str, Boolean bool) {
        try {
            return (Boolean) q(str, bool);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return bool;
        }
    }

    public void a(String str, Integer num) {
        r(str, num);
    }

    public Integer b(String str, Integer num) {
        try {
            return (Integer) q(str, num);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return num;
        }
    }

    public void clear() {
        this.coq.clear();
    }

    public boolean containsKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.coq.containsKey(str);
    }

    private <V> V q(String str, V v) {
        if (containsKey(str)) {
            if (this.coq.get(str) == null) {
                return null;
            }
            try {
                return (V) this.coq.get(str);
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

    private <V> void r(String str, V v) {
        this.coq.put(str, v);
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        clear();
    }
}
