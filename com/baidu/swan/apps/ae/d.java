package com.baidu.swan.apps.ae;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d extends c {
    private Map<String, Object> aNV;

    public d(b bVar) {
        super(bVar);
        this.aNV = new HashMap();
    }

    public void clear() {
        this.aNV.clear();
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        clear();
    }

    public void putBoolean(String str, boolean z) {
        this.aNV.put(str, Boolean.valueOf(z));
    }

    public boolean getBoolean(String str, boolean z) {
        return !(this.aNV.get(str) instanceof Boolean) ? z : ((Boolean) this.aNV.get(str)).booleanValue();
    }
}
