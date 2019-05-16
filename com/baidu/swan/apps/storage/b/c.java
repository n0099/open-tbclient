package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class c extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        Bundle bundle = new Bundle();
        switch (aVar.aVQ) {
            case 1:
                bundle.putInt("result_value", f.Ni().getInt(aVar.aVR, Integer.parseInt(aVar.aVS)));
                break;
            case 2:
                bundle.putLong("result_value", f.Ni().getLong(aVar.aVR, Long.parseLong(aVar.aVS)));
                break;
            case 3:
                bundle.putBoolean("result_value", f.Ni().getBoolean(aVar.aVR, Boolean.parseBoolean(aVar.aVS)));
                break;
            case 4:
                bundle.putString("result_value", f.Ni().getString(aVar.aVR, aVar.aVS));
                break;
            case 5:
                bundle.putFloat("result_value", f.Ni().getFloat(aVar.aVR, Float.parseFloat(aVar.aVS)));
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
