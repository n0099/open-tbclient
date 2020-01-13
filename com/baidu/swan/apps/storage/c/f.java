package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes10.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b lY = h.lY(cVar.bRO);
        if (lY == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.bRP) {
            case 1:
                lY.putInt(cVar.bRQ, Integer.parseInt(cVar.bRR));
                break;
            case 2:
                lY.putLong(cVar.bRQ, Long.parseLong(cVar.bRR));
                break;
            case 3:
                lY.putBoolean(cVar.bRQ, Boolean.parseBoolean(cVar.bRR));
                break;
            case 4:
                lY.putString(cVar.bRQ, cVar.bRR);
                break;
            case 5:
                lY.putFloat(cVar.bRQ, Float.parseFloat(cVar.bRR));
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
