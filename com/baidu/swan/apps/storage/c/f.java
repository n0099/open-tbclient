package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b mm = h.mm(cVar.bWf);
        if (mm == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.bWg) {
            case 1:
                mm.putInt(cVar.bWh, Integer.parseInt(cVar.bWi));
                break;
            case 2:
                mm.putLong(cVar.bWh, Long.parseLong(cVar.bWi));
                break;
            case 3:
                mm.putBoolean(cVar.bWh, Boolean.parseBoolean(cVar.bWi));
                break;
            case 4:
                mm.putString(cVar.bWh, cVar.bWi);
                break;
            case 5:
                mm.putFloat(cVar.bWh, Float.parseFloat(cVar.bWi));
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
