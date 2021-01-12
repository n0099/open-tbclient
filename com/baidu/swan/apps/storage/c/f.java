package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes8.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b tb = h.tb(cVar.dKe);
        if (tb == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                tb.putInt(cVar.dKf, Integer.parseInt(cVar.dKg));
                break;
            case 2:
                tb.putLong(cVar.dKf, Long.parseLong(cVar.dKg));
                break;
            case 3:
                tb.putBoolean(cVar.dKf, Boolean.parseBoolean(cVar.dKg));
                break;
            case 4:
                tb.putString(cVar.dKf, cVar.dKg);
                break;
            case 5:
                tb.putFloat(cVar.dKf, Float.parseFloat(cVar.dKg));
                break;
            default:
                if (DEBUG) {
                    throw new IllegalArgumentException("wrong info params.");
                }
                break;
        }
        if (DEBUG) {
            Log.d("SwanAppSpDelegation", "Put: " + cVar);
        }
        return Bundle.EMPTY;
    }
}
