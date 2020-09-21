package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b su = h.su(cVar.daq);
        if (su == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", su.getInt(cVar.dar, Integer.parseInt(cVar.das)));
                    break;
                case 2:
                    bundle.putLong("result_value", su.getLong(cVar.dar, Long.parseLong(cVar.das)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", su.getBoolean(cVar.dar, Boolean.parseBoolean(cVar.das)));
                    break;
                case 4:
                    bundle.putString("result_value", su.getString(cVar.dar, cVar.das));
                    break;
                case 5:
                    bundle.putFloat("result_value", su.getFloat(cVar.dar, Float.parseFloat(cVar.das)));
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
