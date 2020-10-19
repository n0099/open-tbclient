package com.baidu.swan.apps.env.c;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.c.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c implements b {
    private final b.C0413b cEZ;

    private c(b.C0413b c0413b) {
        this.cEZ = c0413b == null ? new b.C0413b() : c0413b;
    }

    public static c aps() {
        return a((b.C0413b) null);
    }

    public static c a(b.C0413b c0413b) {
        return new c(c0413b);
    }

    public b.C0413b apt() {
        return this.cEZ;
    }

    public c ia(int i) {
        if (isValid() && i != this.cEZ.cEY && (this.cEZ.cEY == 0 || this.cEZ.cEY == this.cEZ.cEX)) {
            this.cEZ.cEY = i;
        }
        return this;
    }

    public c ib(int i) {
        if (isValid()) {
            this.cEZ.cEX = i;
        }
        return this;
    }

    public int apu() {
        return this.cEZ.cEY == 0 ? this.cEZ.cEX : this.cEZ.cEY;
    }

    public c nB(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.cEZ.cEW.get(str))) {
            a nA = a.nA(str);
            if (a(nA)) {
                this.cEZ.cEW.put(nA.apr(), nA);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.cEZ) {
            z = this.cEZ.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray apv() {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor O = com.baidu.swan.apps.database.a.b.O("", 400);
            int count = O.getCount();
            while (O.moveToNext()) {
                String string = O.getString(O.getColumnIndex("app_id"));
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg_id", string);
                    jSONArray.put(jSONObject);
                }
            }
            if (cEV) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (O != null) {
                if (0 != 0) {
                    O.close();
                } else {
                    O.close();
                }
            }
        } catch (JSONException e) {
            if (cEV) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void apw() {
        if (cEV) {
            Log.i("PurgerStatistic", "performReport: " + this.cEZ);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.apx();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apx() {
        String str;
        b.a value;
        synchronized (this.cEZ) {
            if (isValid()) {
                this.cEZ.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = "swan";
                eVar.mSource = "NA";
                int apu = apu();
                eVar.mType = String.valueOf(apu);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.cEZ.cEW.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.u("purged_list", jSONArray);
                if (7 == apu) {
                    eVar.u("history_list", apv());
                }
                if (cEV) {
                    JSONObject jSONObject = eVar.toJSONObject();
                    if (jSONObject == null) {
                        str = "null";
                    } else {
                        try {
                            str = jSONObject.toString(4);
                        } catch (JSONException e) {
                            str = "" + eVar;
                            e.printStackTrace();
                        }
                    }
                    BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            Log.i("PurgerStatistic", "report event => " + readLine);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        } finally {
                            d.closeSafely(bufferedReader);
                        }
                    }
                }
                h.a("1377", eVar);
            }
        }
    }
}
