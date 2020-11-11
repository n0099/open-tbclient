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
    private final b.C0439b cTo;

    private c(b.C0439b c0439b) {
        this.cTo = c0439b == null ? new b.C0439b() : c0439b;
    }

    public static c atN() {
        return a((b.C0439b) null);
    }

    public static c a(b.C0439b c0439b) {
        return new c(c0439b);
    }

    public b.C0439b atO() {
        return this.cTo;
    }

    public c iv(int i) {
        if (isValid() && i != this.cTo.cTn && (this.cTo.cTn == 0 || this.cTo.cTn == this.cTo.cTm)) {
            this.cTo.cTn = i;
        }
        return this;
    }

    public c iw(int i) {
        if (isValid()) {
            this.cTo.cTm = i;
        }
        return this;
    }

    public int atP() {
        return this.cTo.cTn == 0 ? this.cTo.cTm : this.cTo.cTn;
    }

    public c oj(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.cTo.cTl.get(str))) {
            a oi = a.oi(str);
            if (a(oi)) {
                this.cTo.cTl.put(oi.atM(), oi);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.cTo) {
            z = this.cTo.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray atQ() {
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
            if (cTk) {
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
            if (cTk) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void atR() {
        if (cTk) {
            Log.i("PurgerStatistic", "performReport: " + this.cTo);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.atS();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atS() {
        String str;
        b.a value;
        synchronized (this.cTo) {
            if (isValid()) {
                this.cTo.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = "swan";
                eVar.mSource = "NA";
                int atP = atP();
                eVar.mType = String.valueOf(atP);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.cTo.cTl.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.u("purged_list", jSONArray);
                if (7 == atP) {
                    eVar.u("history_list", atQ());
                }
                if (cTk) {
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
