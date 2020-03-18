package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b mm = h.mm(cVar.bWf);
        if (mm == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.bWg) {
                case 1:
                    bundle.putInt("result_value", mm.getInt(cVar.bWh, Integer.parseInt(cVar.bWi)));
                    break;
                case 2:
                    bundle.putLong("result_value", mm.getLong(cVar.bWh, Long.parseLong(cVar.bWi)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", mm.getBoolean(cVar.bWh, Boolean.parseBoolean(cVar.bWi)));
                    break;
                case 4:
                    bundle.putString("result_value", mm.getString(cVar.bWh, cVar.bWi));
                    break;
                case 5:
                    bundle.putFloat("result_value", mm.getFloat(cVar.bWh, Float.parseFloat(cVar.bWi)));
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
