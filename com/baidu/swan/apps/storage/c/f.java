package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes8.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b sa = h.sa(cVar.cYq);
        if (sa == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                sa.putInt(cVar.cYr, Integer.parseInt(cVar.cYs));
                break;
            case 2:
                sa.putLong(cVar.cYr, Long.parseLong(cVar.cYs));
                break;
            case 3:
                sa.putBoolean(cVar.cYr, Boolean.parseBoolean(cVar.cYs));
                break;
            case 4:
                sa.putString(cVar.cYr, cVar.cYs);
                break;
            case 5:
                sa.putFloat(cVar.cYr, Float.parseFloat(cVar.cYs));
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
