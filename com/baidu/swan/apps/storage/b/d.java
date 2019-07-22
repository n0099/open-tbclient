package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        switch (aVar.aWA) {
            case 1:
                f.NX().putInt(aVar.aWB, Integer.parseInt(aVar.aWC));
                break;
            case 2:
                f.NX().putLong(aVar.aWB, Long.parseLong(aVar.aWC));
                break;
            case 3:
                f.NX().putBoolean(aVar.aWB, Boolean.parseBoolean(aVar.aWC));
                break;
            case 4:
                f.NX().putString(aVar.aWB, aVar.aWC);
                break;
            case 5:
                f.NX().putFloat(aVar.aWB, Float.parseFloat(aVar.aWC));
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
