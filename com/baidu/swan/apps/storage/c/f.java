package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes9.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b um = h.um(cVar.dOQ);
        if (um == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                um.putInt(cVar.dOR, Integer.parseInt(cVar.dOS));
                break;
            case 2:
                um.putLong(cVar.dOR, Long.parseLong(cVar.dOS));
                break;
            case 3:
                um.putBoolean(cVar.dOR, Boolean.parseBoolean(cVar.dOS));
                break;
            case 4:
                um.putString(cVar.dOR, cVar.dOS);
                break;
            case 5:
                um.putFloat(cVar.dOR, Float.parseFloat(cVar.dOS));
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
