package com.baidu.swan.apps.storage.c;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes11.dex */
public class e extends d {
    @Override // com.baidu.swan.apps.storage.c.d
    protected Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b pg = h.pg(cVar.cHe);
        if (pg == null) {
            if (DEBUG) {
                throw new IllegalArgumentException("illegal sp.");
            }
        } else {
            switch (cVar.mDataType) {
                case 1:
                    bundle.putInt("result_value", pg.getInt(cVar.cHf, Integer.parseInt(cVar.cHg)));
                    break;
                case 2:
                    bundle.putLong("result_value", pg.getLong(cVar.cHf, Long.parseLong(cVar.cHg)));
                    break;
                case 3:
                    bundle.putBoolean("result_value", pg.getBoolean(cVar.cHf, Boolean.parseBoolean(cVar.cHg)));
                    break;
                case 4:
                    bundle.putString("result_value", pg.getString(cVar.cHf, cVar.cHg));
                    break;
                case 5:
                    bundle.putFloat("result_value", pg.getFloat(cVar.cHf, Float.parseFloat(cVar.cHg)));
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
