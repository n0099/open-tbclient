package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b nz = h.nz(cVar.cuX);
        if (nz == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                nz.putInt(cVar.cuY, Integer.parseInt(cVar.cuZ));
                break;
            case 2:
                nz.putLong(cVar.cuY, Long.parseLong(cVar.cuZ));
                break;
            case 3:
                nz.putBoolean(cVar.cuY, Boolean.parseBoolean(cVar.cuZ));
                break;
            case 4:
                nz.putString(cVar.cuY, cVar.cuZ);
                break;
            case 5:
                nz.putFloat(cVar.cuY, Float.parseFloat(cVar.cuZ));
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
