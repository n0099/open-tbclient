package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes10.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b tz = h.tz(cVar.dvc);
        if (tz == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                tz.putInt(cVar.dvd, Integer.parseInt(cVar.dve));
                break;
            case 2:
                tz.putLong(cVar.dvd, Long.parseLong(cVar.dve));
                break;
            case 3:
                tz.putBoolean(cVar.dvd, Boolean.parseBoolean(cVar.dve));
                break;
            case 4:
                tz.putString(cVar.dvd, cVar.dve);
                break;
            case 5:
                tz.putFloat(cVar.dvd, Float.parseFloat(cVar.dve));
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
