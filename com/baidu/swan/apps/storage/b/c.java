package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class c extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        Bundle bundle = new Bundle();
        switch (aVar.bpJ) {
            case 1:
                bundle.putInt("result_value", f.ST().getInt(aVar.bpK, Integer.parseInt(aVar.bpL)));
                break;
            case 2:
                bundle.putLong("result_value", f.ST().getLong(aVar.bpK, Long.parseLong(aVar.bpL)));
                break;
            case 3:
                bundle.putBoolean("result_value", f.ST().getBoolean(aVar.bpK, Boolean.parseBoolean(aVar.bpL)));
                break;
            case 4:
                bundle.putString("result_value", f.ST().getString(aVar.bpK, aVar.bpL));
                break;
            case 5:
                bundle.putFloat("result_value", f.ST().getFloat(aVar.bpK, Float.parseFloat(aVar.bpL)));
                break;
            default:
                if (DEBUG) {
                    throw new IllegalArgumentException("wrong info params.");
                }
                break;
        }
        if (DEBUG) {
            Log.d("SwanAppSpDelegation", "Get: " + aVar);
        }
        return bundle;
    }
}
