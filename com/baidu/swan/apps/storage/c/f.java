package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes7.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b pZ = h.pZ(cVar.cPj);
        if (pZ == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                pZ.putInt(cVar.cPk, Integer.parseInt(cVar.cPl));
                break;
            case 2:
                pZ.putLong(cVar.cPk, Long.parseLong(cVar.cPl));
                break;
            case 3:
                pZ.putBoolean(cVar.cPk, Boolean.parseBoolean(cVar.cPl));
                break;
            case 4:
                pZ.putString(cVar.cPk, cVar.cPl);
                break;
            case 5:
                pZ.putFloat(cVar.cPk, Float.parseFloat(cVar.cPl));
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
