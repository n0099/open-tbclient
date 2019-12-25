package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes9.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b lV = h.lV(cVar.bRe);
        if (lV == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.bRf) {
                case 1:
                    bundle.putInt("result_value", lV.getInt(cVar.bRg, Integer.parseInt(cVar.bRh)));
                    break;
                case 2:
                    bundle.putLong("result_value", lV.getLong(cVar.bRg, Long.parseLong(cVar.bRh)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", lV.getBoolean(cVar.bRg, Boolean.parseBoolean(cVar.bRh)));
                    break;
                case 4:
                    bundle.putString("result_value", lV.getString(cVar.bRg, cVar.bRh));
                    break;
                case 5:
                    bundle.putFloat("result_value", lV.getFloat(cVar.bRg, Float.parseFloat(cVar.bRh)));
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
