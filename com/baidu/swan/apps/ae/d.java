package com.baidu.swan.apps.ae;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d extends c {
    private Map<String, Object> aNZ;

    public d(b bVar) {
        super(bVar);
        this.aNZ = new HashMap();
    }

    public void clear() {
        this.aNZ.clear();
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        clear();
    }

    public void putBoolean(String str, boolean z) {
        this.aNZ.put(str, Boolean.valueOf(z));
    }

    public boolean getBoolean(String str, boolean z) {
        return !(this.aNZ.get(str) instanceof Boolean) ? z : ((Boolean) this.aNZ.get(str)).booleanValue();
    }
}
