package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b mn = h.mn(cVar.bVS);
        if (mn == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.bVT) {
            case 1:
                mn.putInt(cVar.bVU, Integer.parseInt(cVar.bVV));
                break;
            case 2:
                mn.putLong(cVar.bVU, Long.parseLong(cVar.bVV));
                break;
            case 3:
                mn.putBoolean(cVar.bVU, Boolean.parseBoolean(cVar.bVV));
                break;
            case 4:
                mn.putString(cVar.bVU, cVar.bVV);
                break;
            case 5:
                mn.putFloat(cVar.bVU, Float.parseFloat(cVar.bVV));
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
