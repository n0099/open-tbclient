package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b su = h.su(cVar.daq);
        if (su == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                su.putInt(cVar.dar, Integer.parseInt(cVar.das));
                break;
            case 2:
                su.putLong(cVar.dar, Long.parseLong(cVar.das));
                break;
            case 3:
                su.putBoolean(cVar.dar, Boolean.parseBoolean(cVar.das));
                break;
            case 4:
                su.putString(cVar.dar, cVar.das);
                break;
            case 5:
                su.putFloat(cVar.dar, Float.parseFloat(cVar.das));
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
