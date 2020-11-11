package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes10.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b tN = h.tN(cVar.dAU);
        if (tN == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                tN.putInt(cVar.dAV, Integer.parseInt(cVar.dAW));
                break;
            case 2:
                tN.putLong(cVar.dAV, Long.parseLong(cVar.dAW));
                break;
            case 3:
                tN.putBoolean(cVar.dAV, Boolean.parseBoolean(cVar.dAW));
                break;
            case 4:
                tN.putString(cVar.dAV, cVar.dAW);
                break;
            case 5:
                tN.putFloat(cVar.dAV, Float.parseFloat(cVar.dAW));
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
