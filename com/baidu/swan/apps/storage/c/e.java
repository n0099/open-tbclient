package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b nz = h.nz(cVar.cuX);
        if (nz == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", nz.getInt(cVar.cuY, Integer.parseInt(cVar.cuZ)));
                    break;
                case 2:
                    bundle.putLong("result_value", nz.getLong(cVar.cuY, Long.parseLong(cVar.cuZ)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", nz.getBoolean(cVar.cuY, Boolean.parseBoolean(cVar.cuZ)));
                    break;
                case 4:
                    bundle.putString("result_value", nz.getString(cVar.cuY, cVar.cuZ));
                    break;
                case 5:
                    bundle.putFloat("result_value", nz.getFloat(cVar.cuY, Float.parseFloat(cVar.cuZ)));
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
