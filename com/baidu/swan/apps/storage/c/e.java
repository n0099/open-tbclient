package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes8.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b tb = h.tb(cVar.dKe);
        if (tb == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", tb.getInt(cVar.dKf, Integer.parseInt(cVar.dKg)));
                    break;
                case 2:
                    bundle.putLong("result_value", tb.getLong(cVar.dKf, Long.parseLong(cVar.dKg)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", tb.getBoolean(cVar.dKf, Boolean.parseBoolean(cVar.dKg)));
                    break;
                case 4:
                    bundle.putString("result_value", tb.getString(cVar.dKf, cVar.dKg));
                    break;
                case 5:
                    bundle.putFloat("result_value", tb.getFloat(cVar.dKf, Float.parseFloat(cVar.dKg)));
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
