package com.baidu.swan.apps.core.prefetch.resource.task;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.qr1;
/* loaded from: classes4.dex */
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
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            ResType resType2 = values[i];
            if (str.equalsIgnoreCase(resType2.name())) {
                resType = resType2;
                break;
            }
            i++;
        }
        if (qr1.a) {
            Log.d("ResType", "res type - " + resType.name());
        }
        return resType;
    }
}
