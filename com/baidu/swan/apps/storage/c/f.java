package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes8.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b tB = h.tB(cVar.dNJ);
        if (tB == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                tB.putInt(cVar.dNK, Integer.parseInt(cVar.dNL));
                break;
            case 2:
                tB.putLong(cVar.dNK, Long.parseLong(cVar.dNL));
                break;
            case 3:
                tB.putBoolean(cVar.dNK, Boolean.parseBoolean(cVar.dNL));
                break;
            case 4:
                tB.putString(cVar.dNK, cVar.dNL);
                break;
            case 5:
                tB.putFloat(cVar.dNK, Float.parseFloat(cVar.dNL));
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
