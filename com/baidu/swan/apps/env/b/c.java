package com.baidu.swan.apps.env.b;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.env.b.b;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.d.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c implements b {
    private final b.C0356b cju;

    private c(b.C0356b c0356b) {
        this.cju = c0356b == null ? new b.C0356b() : c0356b;
    }

    public static c aeQ() {
        return a((b.C0356b) null);
    }

    public static c a(b.C0356b c0356b) {
        return new c(c0356b);
    }

    public b.C0356b aeR() {
        return this.cju;
    }

    public c fx(int i) {
        if (isValid() && i != this.cju.cjt && (this.cju.cjt == 0 || this.cju.cjt == this.cju.cjs)) {
            this.cju.cjt = i;
        }
        return this;
    }

    public c fy(int i) {
        if (isValid()) {
            this.cju.cjs = i;
        }
        return this;
    }

    public int aeS() {
        return this.cju.cjt == 0 ? this.cju.cjs : this.cju.cjt;
    }

    public c kG(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.cju.cjr.get(str))) {
            a kF = a.kF(str);
            if (a(kF)) {
                this.cju.cjr.put(kF.aeP(), kF);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.cju) {
            z = this.cju.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray aeT() {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor L = com.baidu.swan.apps.database.a.b.L("", 400);
            int count = L.getCount();
            while (L.moveToNext()) {
                String string = L.getString(L.getColumnIndex("app_id"));
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg_id", string);
                    jSONArray.put(jSONObject);
                }
            }
            if (cjq) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (L != null) {
                if (0 != 0) {
                    L.close();
                } else {
                    L.close();
                }
            }
        } catch (JSONException e) {
            if (cjq) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void aeU() {
        if (cjq) {
            Log.i("PurgerStatistic", "performReport: " + this.cju);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aeV();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeV() {
        String str;
        b.a value;
        synchronized (this.cju) {
            if (isValid()) {
                this.cju.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = "swan";
                eVar.mSource = "NA";
                int aeS = aeS();
                eVar.mType = String.valueOf(aeS);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.cju.cjr.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.v("purged_list", jSONArray);
                if (7 == aeS) {
                    eVar.v("history_list", aeT());
                }
                if (cjq) {
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
