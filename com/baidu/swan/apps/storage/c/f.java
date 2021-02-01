package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes9.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b tu = h.tu(cVar.dMi);
        if (tu == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                tu.putInt(cVar.dMj, Integer.parseInt(cVar.dMk));
                break;
            case 2:
                tu.putLong(cVar.dMj, Long.parseLong(cVar.dMk));
                break;
            case 3:
                tu.putBoolean(cVar.dMj, Boolean.parseBoolean(cVar.dMk));
                break;
            case 4:
                tu.putString(cVar.dMj, cVar.dMk);
                break;
            case 5:
                tu.putFloat(cVar.dMj, Float.parseFloat(cVar.dMk));
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
