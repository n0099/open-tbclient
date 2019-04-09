package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        switch (aVar.aTb) {
            case 1:
                f.KJ().putInt(aVar.aTc, Integer.parseInt(aVar.aTd));
                break;
            case 2:
                f.KJ().putLong(aVar.aTc, Long.parseLong(aVar.aTd));
                break;
            case 3:
                f.KJ().putBoolean(aVar.aTc, Boolean.parseBoolean(aVar.aTd));
                break;
            case 4:
                f.KJ().putString(aVar.aTc, aVar.aTd);
                break;
            case 5:
                f.KJ().putFloat(aVar.aTc, Float.parseFloat(aVar.aTd));
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
