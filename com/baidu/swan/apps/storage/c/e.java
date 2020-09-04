package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes8.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b sa = h.sa(cVar.cYq);
        if (sa == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", sa.getInt(cVar.cYr, Integer.parseInt(cVar.cYs)));
                    break;
                case 2:
                    bundle.putLong("result_value", sa.getLong(cVar.cYr, Long.parseLong(cVar.cYs)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", sa.getBoolean(cVar.cYr, Boolean.parseBoolean(cVar.cYs)));
                    break;
                case 4:
                    bundle.putString("result_value", sa.getString(cVar.cYr, cVar.cYs));
                    break;
                case 5:
                    bundle.putFloat("result_value", sa.getFloat(cVar.cYr, Float.parseFloat(cVar.cYs)));
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
