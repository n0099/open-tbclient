package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes10.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b tN = h.tN(cVar.dAU);
        if (tN == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", tN.getInt(cVar.dAV, Integer.parseInt(cVar.dAW)));
                    break;
                case 2:
                    bundle.putLong("result_value", tN.getLong(cVar.dAV, Long.parseLong(cVar.dAW)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", tN.getBoolean(cVar.dAV, Boolean.parseBoolean(cVar.dAW)));
                    break;
                case 4:
                    bundle.putString("result_value", tN.getString(cVar.dAV, cVar.dAW));
                    break;
                case 5:
                    bundle.putFloat("result_value", tN.getFloat(cVar.dAV, Float.parseFloat(cVar.dAW)));
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
