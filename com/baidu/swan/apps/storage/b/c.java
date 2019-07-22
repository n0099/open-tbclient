package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class c extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        Bundle bundle = new Bundle();
        switch (aVar.aWA) {
            case 1:
                bundle.putInt("result_value", f.NX().getInt(aVar.aWB, Integer.parseInt(aVar.aWC)));
                break;
            case 2:
                bundle.putLong("result_value", f.NX().getLong(aVar.aWB, Long.parseLong(aVar.aWC)));
                break;
            case 3:
                bundle.putBoolean("result_value", f.NX().getBoolean(aVar.aWB, Boolean.parseBoolean(aVar.aWC)));
                break;
            case 4:
                bundle.putString("result_value", f.NX().getString(aVar.aWB, aVar.aWC));
                break;
            case 5:
                bundle.putFloat("result_value", f.NX().getFloat(aVar.aWB, Float.parseFloat(aVar.aWC)));
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
