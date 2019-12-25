package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes9.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b lV = h.lV(cVar.bRe);
        if (lV == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.bRf) {
            case 1:
                lV.putInt(cVar.bRg, Integer.parseInt(cVar.bRh));
                break;
            case 2:
                lV.putLong(cVar.bRg, Long.parseLong(cVar.bRh));
                break;
            case 3:
                lV.putBoolean(cVar.bRg, Boolean.parseBoolean(cVar.bRh));
                break;
            case 4:
                lV.putString(cVar.bRg, cVar.bRh);
                break;
            case 5:
                lV.putFloat(cVar.bRg, Float.parseFloat(cVar.bRh));
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
