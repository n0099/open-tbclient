package com.baidu.swan.apps.ae;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d extends c {
    private Map<String, Object> aRk;

    public d(b bVar) {
        super(bVar);
        this.aRk = new HashMap();
    }

    public void clear() {
        this.aRk.clear();
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        clear();
    }

    public void putBoolean(String str, boolean z) {
        this.aRk.put(str, Boolean.valueOf(z));
    }

    public boolean getBoolean(String str, boolean z) {
        return !(this.aRk.get(str) instanceof Boolean) ? z : ((Boolean) this.aRk.get(str)).booleanValue();
    }

    public boolean containsKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.aRk.containsKey(str);
    }
}
