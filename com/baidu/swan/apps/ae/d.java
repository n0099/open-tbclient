package com.baidu.swan.apps.ae;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d extends c {
    private Map<String, Object> aNY;

    public d(b bVar) {
        super(bVar);
        this.aNY = new HashMap();
    }

    public void clear() {
        this.aNY.clear();
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        clear();
    }

    public void putBoolean(String str, boolean z) {
        this.aNY.put(str, Boolean.valueOf(z));
    }

    public boolean getBoolean(String str, boolean z) {
        return !(this.aNY.get(str) instanceof Boolean) ? z : ((Boolean) this.aNY.get(str)).booleanValue();
    }
}
