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
/* loaded from: classes25.dex */
public final class c implements b {
    private final b.C0449b cYx;

    private c(b.C0449b c0449b) {
        this.cYx = c0449b == null ? new b.C0449b() : c0449b;
    }

    public static c awn() {
        return a((b.C0449b) null);
    }

    public static c a(b.C0449b c0449b) {
        return new c(c0449b);
    }

    public b.C0449b awo() {
        return this.cYx;
    }

    public c iP(int i) {
        if (isValid() && i != this.cYx.cYw && (this.cYx.cYw == 0 || this.cYx.cYw == this.cYx.cYv)) {
            this.cYx.cYw = i;
        }
        return this;
    }

    public c iQ(int i) {
        if (isValid()) {
            this.cYx.cYv = i;
        }
        return this;
    }

    public int awp() {
        return this.cYx.cYw == 0 ? this.cYx.cYv : this.cYx.cYw;
    }

    public c oL(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.cYx.cYu.get(str))) {
            a oK = a.oK(str);
            if (a(oK)) {
                this.cYx.cYu.put(oK.awm(), oK);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.cYx) {
            z = this.cYx.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray awq() {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor R = com.baidu.swan.apps.database.a.b.R("", 400);
            int count = R.getCount();
            while (R.moveToNext()) {
                String string = R.getString(R.getColumnIndex("app_id"));
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg_id", string);
                    jSONArray.put(jSONObject);
                }
            }
            if (cYt) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (R != null) {
                if (0 != 0) {
                    R.close();
                } else {
                    R.close();
                }
            }
        } catch (JSONException e) {
            if (cYt) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void awr() {
        if (cYt) {
            Log.i("PurgerStatistic", "performReport: " + this.cYx);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aws();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aws() {
        String str;
        b.a value;
        synchronized (this.cYx) {
            if (isValid()) {
                this.cYx.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = "swan";
                eVar.mSource = "NA";
                int awp = awp();
                eVar.mType = String.valueOf(awp);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.cYx.cYu.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.t("purged_list", jSONArray);
                if (7 == awp) {
                    eVar.t("history_list", awq());
                }
                if (cYt) {
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
