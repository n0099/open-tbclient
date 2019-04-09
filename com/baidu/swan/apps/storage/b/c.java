package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class c extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        Bundle bundle = new Bundle();
        switch (aVar.aTb) {
            case 1:
                bundle.putInt("result_value", f.KJ().getInt(aVar.aTc, Integer.parseInt(aVar.aTd)));
                break;
            case 2:
                bundle.putLong("result_value", f.KJ().getLong(aVar.aTc, Long.parseLong(aVar.aTd)));
                break;
            case 3:
                bundle.putBoolean("result_value", f.KJ().getBoolean(aVar.aTc, Boolean.parseBoolean(aVar.aTd)));
                break;
            case 4:
                bundle.putString("result_value", f.KJ().getString(aVar.aTc, aVar.aTd));
                break;
            case 5:
                bundle.putFloat("result_value", f.KJ().getFloat(aVar.aTc, Float.parseFloat(aVar.aTd)));
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
