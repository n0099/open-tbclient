package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class c extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        Bundle bundle = new Bundle();
        switch (aVar.aSX) {
            case 1:
                bundle.putInt("result_value", f.KL().getInt(aVar.aSY, Integer.parseInt(aVar.aSZ)));
                break;
            case 2:
                bundle.putLong("result_value", f.KL().getLong(aVar.aSY, Long.parseLong(aVar.aSZ)));
                break;
            case 3:
                bundle.putBoolean("result_value", f.KL().getBoolean(aVar.aSY, Boolean.parseBoolean(aVar.aSZ)));
                break;
            case 4:
                bundle.putString("result_value", f.KL().getString(aVar.aSY, aVar.aSZ));
                break;
            case 5:
                bundle.putFloat("result_value", f.KL().getFloat(aVar.aSY, Float.parseFloat(aVar.aSZ)));
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
