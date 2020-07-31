package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes7.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b pZ = h.pZ(cVar.cPj);
        if (pZ == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", pZ.getInt(cVar.cPk, Integer.parseInt(cVar.cPl)));
                    break;
                case 2:
                    bundle.putLong("result_value", pZ.getLong(cVar.cPk, Long.parseLong(cVar.cPl)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", pZ.getBoolean(cVar.cPk, Boolean.parseBoolean(cVar.cPl)));
                    break;
                case 4:
                    bundle.putString("result_value", pZ.getString(cVar.cPk, cVar.cPl));
                    break;
                case 5:
                    bundle.putFloat("result_value", pZ.getFloat(cVar.cPk, Float.parseFloat(cVar.cPl)));
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
