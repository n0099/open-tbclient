package com.baidu.swan.apps.core.prefetch.resource.task;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public enum ResType {
    NONE,
    TEST,
    VIDEO,
    IMAGE;
    
    public static final long serialVersionUID = 0;

    public static ResType typeOf(String str) {
        if (TextUtils.isEmpty(str)) {
            return NONE;
        }
        ResType resType = NONE;
        ResType[] values = values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            ResType resType2 = values[i2];
            if (str.equalsIgnoreCase(resType2.name())) {
                resType = resType2;
                break;
            }
            i2++;
        }
        if (k.f46875a) {
            Log.d("ResType", "res type - " + resType.name());
        }
        return resType;
    }
}
