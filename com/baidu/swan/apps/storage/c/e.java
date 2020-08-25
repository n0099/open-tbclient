package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes8.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b rZ = h.rZ(cVar.cYm);
        if (rZ == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", rZ.getInt(cVar.cYn, Integer.parseInt(cVar.cYo)));
                    break;
                case 2:
                    bundle.putLong("result_value", rZ.getLong(cVar.cYn, Long.parseLong(cVar.cYo)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", rZ.getBoolean(cVar.cYn, Boolean.parseBoolean(cVar.cYo)));
                    break;
                case 4:
                    bundle.putString("result_value", rZ.getString(cVar.cYn, cVar.cYo));
                    break;
                case 5:
                    bundle.putFloat("result_value", rZ.getFloat(cVar.cYn, Float.parseFloat(cVar.cYo)));
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
