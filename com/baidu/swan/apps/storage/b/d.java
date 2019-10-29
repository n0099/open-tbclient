package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        switch (aVar.bqb) {
            case 1:
                f.SR().putInt(aVar.bqc, Integer.parseInt(aVar.bqd));
                break;
            case 2:
                f.SR().putLong(aVar.bqc, Long.parseLong(aVar.bqd));
                break;
            case 3:
                f.SR().putBoolean(aVar.bqc, Boolean.parseBoolean(aVar.bqd));
                break;
            case 4:
                f.SR().putString(aVar.bqc, aVar.bqd);
                break;
            case 5:
                f.SR().putFloat(aVar.bqc, Float.parseFloat(aVar.bqd));
                break;
            default:
                if (DEBUG) {
                    throw new IllegalArgumentException("wrong info params.");
                }
                break;
        }
        if (DEBUG) {
            Log.d("SwanAppSpDelegation", "Put: " + aVar);
        }
        return Bundle.EMPTY;
    }
}
