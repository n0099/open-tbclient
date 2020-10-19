package com.baidu.swan.apps.runtime;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class g extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Map<String, Object> deF;

    public g(e eVar) {
        super(eVar);
        this.deF = new HashMap();
    }

    public void putString(String str, String str2) {
        t(str, str2);
    }

    public String getString(String str, String str2) {
        try {
            return (String) s(str, str2);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return str2;
        }
    }

    public void a(String str, Boolean bool) {
        t(str, bool);
    }

    public Boolean b(String str, Boolean bool) {
        try {
            return (Boolean) s(str, bool);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return bool;
        }
    }

    public void a(String str, Integer num) {
        t(str, num);
    }

    public Integer b(String str, Integer num) {
        try {
            return (Integer) s(str, num);
        } catch (ClassCastException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return num;
        }
    }

    public void clear() {
        this.deF.clear();
    }

    public boolean containsKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.deF.containsKey(str);
    }

    private <V> V s(String str, V v) {
        if (containsKey(str)) {
            if (this.deF.get(str) == null) {
                return null;
            }
            try {
                return (V) this.deF.get(str);
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

    private <V> void t(String str, V v) {
        this.deF.put(str, v);
    }

    @Override // com.baidu.swan.apps.runtime.f
    public void onDestroy() {
        clear();
    }
}
