package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        switch (aVar.bpJ) {
            case 1:
                f.ST().putInt(aVar.bpK, Integer.parseInt(aVar.bpL));
                break;
            case 2:
                f.ST().putLong(aVar.bpK, Long.parseLong(aVar.bpL));
                break;
            case 3:
                f.ST().putBoolean(aVar.bpK, Boolean.parseBoolean(aVar.bpL));
                break;
            case 4:
                f.ST().putString(aVar.bpK, aVar.bpL);
                break;
            case 5:
                f.ST().putFloat(aVar.bpK, Float.parseFloat(aVar.bpL));
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
