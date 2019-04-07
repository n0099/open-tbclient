package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        switch (aVar.aTa) {
            case 1:
                f.KJ().putInt(aVar.aTb, Integer.parseInt(aVar.aTc));
                break;
            case 2:
                f.KJ().putLong(aVar.aTb, Long.parseLong(aVar.aTc));
                break;
            case 3:
                f.KJ().putBoolean(aVar.aTb, Boolean.parseBoolean(aVar.aTc));
                break;
            case 4:
                f.KJ().putString(aVar.aTb, aVar.aTc);
                break;
            case 5:
                f.KJ().putFloat(aVar.aTb, Float.parseFloat(aVar.aTc));
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
