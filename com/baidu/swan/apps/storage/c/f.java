package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b mn = h.mn(cVar.bVT);
        if (mn == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.bVU) {
            case 1:
                mn.putInt(cVar.bVV, Integer.parseInt(cVar.bVW));
                break;
            case 2:
                mn.putLong(cVar.bVV, Long.parseLong(cVar.bVW));
                break;
            case 3:
                mn.putBoolean(cVar.bVV, Boolean.parseBoolean(cVar.bVW));
                break;
            case 4:
                mn.putString(cVar.bVV, cVar.bVW);
                break;
            case 5:
                mn.putFloat(cVar.bVV, Float.parseFloat(cVar.bVW));
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
