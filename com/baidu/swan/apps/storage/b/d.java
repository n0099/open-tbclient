package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        switch (aVar.aVQ) {
            case 1:
                f.Ni().putInt(aVar.aVR, Integer.parseInt(aVar.aVS));
                break;
            case 2:
                f.Ni().putLong(aVar.aVR, Long.parseLong(aVar.aVS));
                break;
            case 3:
                f.Ni().putBoolean(aVar.aVR, Boolean.parseBoolean(aVar.aVS));
                break;
            case 4:
                f.Ni().putString(aVar.aVR, aVar.aVS);
                break;
            case 5:
                f.Ni().putFloat(aVar.aVR, Float.parseFloat(aVar.aVS));
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
