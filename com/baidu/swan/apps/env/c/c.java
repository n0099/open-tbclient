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
    private final b.C0427b cNv;

    private c(b.C0427b c0427b) {
        this.cNv = c0427b == null ? new b.C0427b() : c0427b;
    }

    public static c arm() {
        return a((b.C0427b) null);
    }

    public static c a(b.C0427b c0427b) {
        return new c(c0427b);
    }

    public b.C0427b arn() {
        return this.cNv;
    }

    public c il(int i) {
        if (isValid() && i != this.cNv.cNu && (this.cNv.cNu == 0 || this.cNv.cNu == this.cNv.cNt)) {
            this.cNv.cNu = i;
        }
        return this;
    }

    public c im(int i) {
        if (isValid()) {
            this.cNv.cNt = i;
        }
        return this;
    }

    public int aro() {
        return this.cNv.cNu == 0 ? this.cNv.cNt : this.cNv.cNu;
    }

    public c nU(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.cNv.cNs.get(str))) {
            a nT = a.nT(str);
            if (a(nT)) {
                this.cNv.cNs.put(nT.arl(), nT);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.cNv) {
            z = this.cNv.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray arp() {
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
            if (cNr) {
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
            if (cNr) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void arq() {
        if (cNr) {
            Log.i("PurgerStatistic", "performReport: " + this.cNv);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.arr();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arr() {
        String str;
        b.a value;
        synchronized (this.cNv) {
            if (isValid()) {
                this.cNv.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = "swan";
                eVar.mSource = "NA";
                int aro = aro();
                eVar.mType = String.valueOf(aro);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.cNv.cNs.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.u("purged_list", jSONArray);
                if (7 == aro) {
                    eVar.u("history_list", arp());
                }
                if (cNr) {
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
