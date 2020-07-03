package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b po = h.po(cVar.cLO);
        if (po == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", po.getInt(cVar.cLP, Integer.parseInt(cVar.cLQ)));
                    break;
                case 2:
                    bundle.putLong("result_value", po.getLong(cVar.cLP, Long.parseLong(cVar.cLQ)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", po.getBoolean(cVar.cLP, Boolean.parseBoolean(cVar.cLQ)));
                    break;
                case 4:
                    bundle.putString("result_value", po.getString(cVar.cLP, cVar.cLQ));
                    break;
                case 5:
                    bundle.putFloat("result_value", po.getFloat(cVar.cLP, Float.parseFloat(cVar.cLQ)));
                    break;
                default:
                    if (DEBUG) {
                        throw new IllegalArgumentException("wrong info params.");
                    }
                    break;
            }
            if (DEBUG) {
                Log.d("SwanAppSpDelegation", "Get: " + cVar);
            }
        }
        return bundle;
    }
}
