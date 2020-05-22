package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b pg = h.pg(cVar.cHe);
        if (pg == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                pg.putInt(cVar.cHf, Integer.parseInt(cVar.cHg));
                break;
            case 2:
                pg.putLong(cVar.cHf, Long.parseLong(cVar.cHg));
                break;
            case 3:
                pg.putBoolean(cVar.cHf, Boolean.parseBoolean(cVar.cHg));
                break;
            case 4:
                pg.putString(cVar.cHf, cVar.cHg);
                break;
            case 5:
                pg.putFloat(cVar.cHf, Float.parseFloat(cVar.cHg));
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
