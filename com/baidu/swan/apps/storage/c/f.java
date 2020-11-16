package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes7.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b tI = h.tI(cVar.dzn);
        if (tI == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                tI.putInt(cVar.dzo, Integer.parseInt(cVar.dzp));
                break;
            case 2:
                tI.putLong(cVar.dzo, Long.parseLong(cVar.dzp));
                break;
            case 3:
                tI.putBoolean(cVar.dzo, Boolean.parseBoolean(cVar.dzp));
                break;
            case 4:
                tI.putString(cVar.dzo, cVar.dzp);
                break;
            case 5:
                tI.putFloat(cVar.dzo, Float.parseFloat(cVar.dzp));
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
