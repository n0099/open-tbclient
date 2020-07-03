package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class f extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        b po = h.po(cVar.cLO);
        if (po == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return Bundle.EMPTY;
        }
        switch (cVar.mDataType) {
            case 1:
                po.putInt(cVar.cLP, Integer.parseInt(cVar.cLQ));
                break;
            case 2:
                po.putLong(cVar.cLP, Long.parseLong(cVar.cLQ));
                break;
            case 3:
                po.putBoolean(cVar.cLP, Boolean.parseBoolean(cVar.cLQ));
                break;
            case 4:
                po.putString(cVar.cLP, cVar.cLQ);
                break;
            case 5:
                po.putFloat(cVar.cLP, Float.parseFloat(cVar.cLQ));
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
