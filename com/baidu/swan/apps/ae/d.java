package com.baidu.swan.apps.ae;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d extends c {
    private Map<String, Object> aNU;

    public d(b bVar) {
        super(bVar);
        this.aNU = new HashMap();
    }

    public void clear() {
        this.aNU.clear();
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        clear();
    }

    public void putBoolean(String str, boolean z) {
        this.aNU.put(str, Boolean.valueOf(z));
    }

    public boolean getBoolean(String str, boolean z) {
        return !(this.aNU.get(str) instanceof Boolean) ? z : ((Boolean) this.aNU.get(str)).booleanValue();
    }
}
