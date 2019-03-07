package com.baidu.swan.apps.storage.b;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes2.dex */
public class d extends b {
    @Override // com.baidu.swan.apps.storage.b.b
    protected Bundle a(a aVar) {
        switch (aVar.aSW) {
            case 1:
                f.KL().putInt(aVar.aSX, Integer.parseInt(aVar.aSY));
                break;
            case 2:
                f.KL().putLong(aVar.aSX, Long.parseLong(aVar.aSY));
                break;
            case 3:
                f.KL().putBoolean(aVar.aSX, Boolean.parseBoolean(aVar.aSY));
                break;
            case 4:
                f.KL().putString(aVar.aSX, aVar.aSY);
                break;
            case 5:
                f.KL().putFloat(aVar.aSX, Float.parseFloat(aVar.aSY));
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
