package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes9.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b um = h.um(cVar.dOQ);
        if (um == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", um.getInt(cVar.dOR, Integer.parseInt(cVar.dOS)));
                    break;
                case 2:
                    bundle.putLong("result_value", um.getLong(cVar.dOR, Long.parseLong(cVar.dOS)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", um.getBoolean(cVar.dOR, Boolean.parseBoolean(cVar.dOS)));
                    break;
                case 4:
                    bundle.putString("result_value", um.getString(cVar.dOR, cVar.dOS));
                    break;
                case 5:
                    bundle.putFloat("result_value", um.getFloat(cVar.dOR, Float.parseFloat(cVar.dOS)));
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
