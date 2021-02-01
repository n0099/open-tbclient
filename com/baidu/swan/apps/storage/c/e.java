package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes9.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b tu = h.tu(cVar.dMi);
        if (tu == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", tu.getInt(cVar.dMj, Integer.parseInt(cVar.dMk)));
                    break;
                case 2:
                    bundle.putLong("result_value", tu.getLong(cVar.dMj, Long.parseLong(cVar.dMk)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", tu.getBoolean(cVar.dMj, Boolean.parseBoolean(cVar.dMk)));
                    break;
                case 4:
                    bundle.putString("result_value", tu.getString(cVar.dMj, cVar.dMk));
                    break;
                case 5:
                    bundle.putFloat("result_value", tu.getFloat(cVar.dMj, Float.parseFloat(cVar.dMk)));
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
