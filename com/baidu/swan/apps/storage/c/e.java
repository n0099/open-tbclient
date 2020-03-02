package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b mn = h.mn(cVar.bVT);
        if (mn == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.bVU) {
                case 1:
                    bundle.putInt("result_value", mn.getInt(cVar.bVV, Integer.parseInt(cVar.bVW)));
                    break;
                case 2:
                    bundle.putLong("result_value", mn.getLong(cVar.bVV, Long.parseLong(cVar.bVW)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", mn.getBoolean(cVar.bVV, Boolean.parseBoolean(cVar.bVW)));
                    break;
                case 4:
                    bundle.putString("result_value", mn.getString(cVar.bVV, cVar.bVW));
                    break;
                case 5:
                    bundle.putFloat("result_value", mn.getFloat(cVar.bVV, Float.parseFloat(cVar.bVW)));
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
