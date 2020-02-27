package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b mn = h.mn(cVar.bVS);
        if (mn == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.bVT) {
                case 1:
                    bundle.putInt("result_value", mn.getInt(cVar.bVU, Integer.parseInt(cVar.bVV)));
                    break;
                case 2:
                    bundle.putLong("result_value", mn.getLong(cVar.bVU, Long.parseLong(cVar.bVV)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", mn.getBoolean(cVar.bVU, Boolean.parseBoolean(cVar.bVV)));
                    break;
                case 4:
                    bundle.putString("result_value", mn.getString(cVar.bVU, cVar.bVV));
                    break;
                case 5:
                    bundle.putFloat("result_value", mn.getFloat(cVar.bVU, Float.parseFloat(cVar.bVV)));
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
