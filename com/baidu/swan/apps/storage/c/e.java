package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes10.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b lY = h.lY(cVar.bRO);
        if (lY == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.bRP) {
                case 1:
                    bundle.putInt("result_value", lY.getInt(cVar.bRQ, Integer.parseInt(cVar.bRR)));
                    break;
                case 2:
                    bundle.putLong("result_value", lY.getLong(cVar.bRQ, Long.parseLong(cVar.bRR)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", lY.getBoolean(cVar.bRQ, Boolean.parseBoolean(cVar.bRR)));
                    break;
                case 4:
                    bundle.putString("result_value", lY.getString(cVar.bRQ, cVar.bRR));
                    break;
                case 5:
                    bundle.putFloat("result_value", lY.getFloat(cVar.bRQ, Float.parseFloat(cVar.bRR)));
                    break;
                default:
                    if (DEBUG) {
                        throw new IllegalArgumentException("wrong info params.");
                    }
                    break;
            }
            if (DEBUG) {
                Log.d("SwanAppSpDelegation", "Get: " + cVar);
            }
        }
        return bundle;
    }
}
