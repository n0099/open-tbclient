package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes8.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b tB = h.tB(cVar.dNJ);
        if (tB == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", tB.getInt(cVar.dNK, Integer.parseInt(cVar.dNL)));
                    break;
                case 2:
                    bundle.putLong("result_value", tB.getLong(cVar.dNK, Long.parseLong(cVar.dNL)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", tB.getBoolean(cVar.dNK, Boolean.parseBoolean(cVar.dNL)));
                    break;
                case 4:
                    bundle.putString("result_value", tB.getString(cVar.dNK, cVar.dNL));
                    break;
                case 5:
                    bundle.putFloat("result_value", tB.getFloat(cVar.dNK, Float.parseFloat(cVar.dNL)));
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
