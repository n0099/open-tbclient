package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        switch (aVar.aWY) {
            case 1:
                f.Ob().putInt(aVar.aWZ, Integer.parseInt(aVar.aXa));
                break;
            case 2:
                f.Ob().putLong(aVar.aWZ, Long.parseLong(aVar.aXa));
                break;
            case 3:
                f.Ob().putBoolean(aVar.aWZ, Boolean.parseBoolean(aVar.aXa));
                break;
            case 4:
                f.Ob().putString(aVar.aWZ, aVar.aXa);
                break;
            case 5:
                f.Ob().putFloat(aVar.aWZ, Float.parseFloat(aVar.aXa));
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
