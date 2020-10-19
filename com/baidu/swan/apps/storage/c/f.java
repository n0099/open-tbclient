package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes10.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b tg = h.tg(cVar.dmA);
        if (tg == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                tg.putInt(cVar.dmB, Integer.parseInt(cVar.dmC));
                break;
            case 2:
                tg.putLong(cVar.dmB, Long.parseLong(cVar.dmC));
                break;
            case 3:
                tg.putBoolean(cVar.dmB, Boolean.parseBoolean(cVar.dmC));
                break;
            case 4:
                tg.putString(cVar.dmB, cVar.dmC);
                break;
            case 5:
                tg.putFloat(cVar.dmB, Float.parseFloat(cVar.dmC));
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
