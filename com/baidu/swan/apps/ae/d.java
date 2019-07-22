package com.baidu.swan.apps.ae;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d extends c {
    private Map<String, Object> aQM;

    public d(b bVar) {
        super(bVar);
        this.aQM = new HashMap();
    }

    public void clear() {
        this.aQM.clear();
    }

    @Override // com.baidu.swan.apps.ae.c
    public void onDestroy() {
        clear();
    }

    public void putBoolean(String str, boolean z) {
        this.aQM.put(str, Boolean.valueOf(z));
    }

    public boolean getBoolean(String str, boolean z) {
        return !(this.aQM.get(str) instanceof Boolean) ? z : ((Boolean) this.aQM.get(str)).booleanValue();
    }

    public boolean containsKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.aQM.containsKey(str);
    }
}
