package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class c extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        Bundle bundle = new Bundle();
        switch (aVar.bqb) {
            case 1:
                bundle.putInt("result_value", f.SR().getInt(aVar.bqc, Integer.parseInt(aVar.bqd)));
                break;
            case 2:
                bundle.putLong("result_value", f.SR().getLong(aVar.bqc, Long.parseLong(aVar.bqd)));
                break;
            case 3:
                bundle.putBoolean("result_value", f.SR().getBoolean(aVar.bqc, Boolean.parseBoolean(aVar.bqd)));
                break;
            case 4:
                bundle.putString("result_value", f.SR().getString(aVar.bqc, aVar.bqd));
                break;
            case 5:
                bundle.putFloat("result_value", f.SR().getFloat(aVar.bqc, Float.parseFloat(aVar.bqd)));
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
