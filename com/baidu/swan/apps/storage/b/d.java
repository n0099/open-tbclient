package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        switch (aVar.aSX) {
            case 1:
                f.KL().putInt(aVar.aSY, Integer.parseInt(aVar.aSZ));
                break;
            case 2:
                f.KL().putLong(aVar.aSY, Long.parseLong(aVar.aSZ));
                break;
            case 3:
                f.KL().putBoolean(aVar.aSY, Boolean.parseBoolean(aVar.aSZ));
                break;
            case 4:
                f.KL().putString(aVar.aSY, aVar.aSZ);
                break;
            case 5:
                f.KL().putFloat(aVar.aSY, Float.parseFloat(aVar.aSZ));
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
