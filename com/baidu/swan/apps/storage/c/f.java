package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes25.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b up = h.up(cVar.dGm);
        if (up == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                up.putInt(cVar.dGn, Integer.parseInt(cVar.dGo));
                break;
            case 2:
                up.putLong(cVar.dGn, Long.parseLong(cVar.dGo));
                break;
            case 3:
                up.putBoolean(cVar.dGn, Boolean.parseBoolean(cVar.dGo));
                break;
            case 4:
                up.putString(cVar.dGn, cVar.dGo);
                break;
            case 5:
                up.putFloat(cVar.dGn, Float.parseFloat(cVar.dGo));
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
