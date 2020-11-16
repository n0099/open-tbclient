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
/* loaded from: classes7.dex */
public final class c implements b {
    private final b.C0437b cRE;

    private c(b.C0437b c0437b) {
        this.cRE = c0437b == null ? new b.C0437b() : c0437b;
    }

    public static c atf() {
        return a((b.C0437b) null);
    }

    public static c a(b.C0437b c0437b) {
        return new c(c0437b);
    }

    public b.C0437b atg() {
        return this.cRE;
    }

    public c ir(int i) {
        if (isValid() && i != this.cRE.cRD && (this.cRE.cRD == 0 || this.cRE.cRD == this.cRE.cRC)) {
            this.cRE.cRD = i;
        }
        return this;
    }

    public c is(int i) {
        if (isValid()) {
            this.cRE.cRC = i;
        }
        return this;
    }

    public int ath() {
        return this.cRE.cRD == 0 ? this.cRE.cRC : this.cRE.cRD;
    }

    public c oc(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.cRE.cRB.get(str))) {
            a ob = a.ob(str);
            if (a(ob)) {
                this.cRE.cRB.put(ob.ate(), ob);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.cRE) {
            z = this.cRE.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray ati() {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor Q = com.baidu.swan.apps.database.a.b.Q("", 400);
            int count = Q.getCount();
            while (Q.moveToNext()) {
                String string = Q.getString(Q.getColumnIndex("app_id"));
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg_id", string);
                    jSONArray.put(jSONObject);
                }
            }
            if (cRA) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (Q != null) {
                if (0 != 0) {
                    Q.close();
                } else {
                    Q.close();
                }
            }
        } catch (JSONException e) {
            if (cRA) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void atj() {
        if (cRA) {
            Log.i("PurgerStatistic", "performReport: " + this.cRE);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.atk();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atk() {
        String str;
        b.a value;
        synchronized (this.cRE) {
            if (isValid()) {
                this.cRE.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = "swan";
                eVar.mSource = "NA";
                int ath = ath();
                eVar.mType = String.valueOf(ath);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.cRE.cRB.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.u("purged_list", jSONArray);
                if (7 == ath) {
                    eVar.u("history_list", ati());
                }
                if (cRA) {
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
