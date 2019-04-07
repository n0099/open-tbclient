package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class c extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        Bundle bundle = new Bundle();
        switch (aVar.aTa) {
            case 1:
                bundle.putInt("result_value", f.KJ().getInt(aVar.aTb, Integer.parseInt(aVar.aTc)));
                break;
            case 2:
                bundle.putLong("result_value", f.KJ().getLong(aVar.aTb, Long.parseLong(aVar.aTc)));
                break;
            case 3:
                bundle.putBoolean("result_value", f.KJ().getBoolean(aVar.aTb, Boolean.parseBoolean(aVar.aTc)));
                break;
            case 4:
                bundle.putString("result_value", f.KJ().getString(aVar.aTb, aVar.aTc));
                break;
            case 5:
                bundle.putFloat("result_value", f.KJ().getFloat(aVar.aTb, Float.parseFloat(aVar.aTc)));
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
