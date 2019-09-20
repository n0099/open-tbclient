package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class c extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        Bundle bundle = new Bundle();
        switch (aVar.aWY) {
            case 1:
                bundle.putInt("result_value", f.Ob().getInt(aVar.aWZ, Integer.parseInt(aVar.aXa)));
                break;
            case 2:
                bundle.putLong("result_value", f.Ob().getLong(aVar.aWZ, Long.parseLong(aVar.aXa)));
                break;
            case 3:
                bundle.putBoolean("result_value", f.Ob().getBoolean(aVar.aWZ, Boolean.parseBoolean(aVar.aXa)));
                break;
            case 4:
                bundle.putString("result_value", f.Ob().getString(aVar.aWZ, aVar.aXa));
                break;
            case 5:
                bundle.putFloat("result_value", f.Ob().getFloat(aVar.aWZ, Float.parseFloat(aVar.aXa)));
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
