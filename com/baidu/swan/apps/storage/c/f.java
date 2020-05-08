package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b nz = h.nz(cVar.cvd);
        if (nz == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                nz.putInt(cVar.cve, Integer.parseInt(cVar.cvf));
                break;
            case 2:
                nz.putLong(cVar.cve, Long.parseLong(cVar.cvf));
                break;
            case 3:
                nz.putBoolean(cVar.cve, Boolean.parseBoolean(cVar.cvf));
                break;
            case 4:
                nz.putString(cVar.cve, cVar.cvf);
                break;
            case 5:
                nz.putFloat(cVar.cve, Float.parseFloat(cVar.cvf));
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
