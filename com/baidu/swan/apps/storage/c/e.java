package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes25.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b up = h.up(cVar.dGm);
        if (up == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", up.getInt(cVar.dGn, Integer.parseInt(cVar.dGo)));
                    break;
                case 2:
                    bundle.putLong("result_value", up.getLong(cVar.dGn, Long.parseLong(cVar.dGo)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", up.getBoolean(cVar.dGn, Boolean.parseBoolean(cVar.dGo)));
                    break;
                case 4:
                    bundle.putString("result_value", up.getString(cVar.dGn, cVar.dGo));
                    break;
                case 5:
                    bundle.putFloat("result_value", up.getFloat(cVar.dGn, Float.parseFloat(cVar.dGo)));
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
