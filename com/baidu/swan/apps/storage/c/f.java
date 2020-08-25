package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes8.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b rZ = h.rZ(cVar.cYm);
        if (rZ == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                rZ.putInt(cVar.cYn, Integer.parseInt(cVar.cYo));
                break;
            case 2:
                rZ.putLong(cVar.cYn, Long.parseLong(cVar.cYo));
                break;
            case 3:
                rZ.putBoolean(cVar.cYn, Boolean.parseBoolean(cVar.cYo));
                break;
            case 4:
                rZ.putString(cVar.cYn, cVar.cYo);
                break;
            case 5:
                rZ.putFloat(cVar.cYn, Float.parseFloat(cVar.cYo));
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
