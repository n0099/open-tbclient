package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b mn = h.mn(cVar.bVU);
        if (mn == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.bVV) {
            case 1:
                mn.putInt(cVar.bVW, Integer.parseInt(cVar.bVX));
                break;
            case 2:
                mn.putLong(cVar.bVW, Long.parseLong(cVar.bVX));
                break;
            case 3:
                mn.putBoolean(cVar.bVW, Boolean.parseBoolean(cVar.bVX));
                break;
            case 4:
                mn.putString(cVar.bVW, cVar.bVX);
                break;
            case 5:
                mn.putFloat(cVar.bVW, Float.parseFloat(cVar.bVX));
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
