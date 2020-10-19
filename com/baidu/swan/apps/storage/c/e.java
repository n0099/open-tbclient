package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes10.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b tg = h.tg(cVar.dmA);
        if (tg == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", tg.getInt(cVar.dmB, Integer.parseInt(cVar.dmC)));
                    break;
                case 2:
                    bundle.putLong("result_value", tg.getLong(cVar.dmB, Long.parseLong(cVar.dmC)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", tg.getBoolean(cVar.dmB, Boolean.parseBoolean(cVar.dmC)));
                    break;
                case 4:
                    bundle.putString("result_value", tg.getString(cVar.dmB, cVar.dmC));
                    break;
                case 5:
                    bundle.putFloat("result_value", tg.getFloat(cVar.dmB, Float.parseFloat(cVar.dmC)));
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
