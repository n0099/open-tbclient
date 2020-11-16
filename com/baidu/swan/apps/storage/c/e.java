package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes7.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b tI = h.tI(cVar.dzn);
        if (tI == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", tI.getInt(cVar.dzo, Integer.parseInt(cVar.dzp)));
                    break;
                case 2:
                    bundle.putLong("result_value", tI.getLong(cVar.dzo, Long.parseLong(cVar.dzp)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", tI.getBoolean(cVar.dzo, Boolean.parseBoolean(cVar.dzp)));
                    break;
                case 4:
                    bundle.putString("result_value", tI.getString(cVar.dzo, cVar.dzp));
                    break;
                case 5:
                    bundle.putFloat("result_value", tI.getFloat(cVar.dzo, Float.parseFloat(cVar.dzp)));
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
