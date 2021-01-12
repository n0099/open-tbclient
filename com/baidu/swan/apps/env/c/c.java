package com.baidu.swan.apps.env.c;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.env.c.b;
import com.baidu.swan.apps.statistic.a.e;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.c.d;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class c implements b {
    private final b.C0424b cYD;

    private c(b.C0424b c0424b) {
        this.cYD = c0424b == null ? new b.C0424b() : c0424b;
    }

    public static c atM() {
        return a((b.C0424b) null);
    }

    public static c a(b.C0424b c0424b) {
        return new c(c0424b);
    }

    public b.C0424b atN() {
        return this.cYD;
    }

    public c he(int i) {
        if (isValid() && i != this.cYD.cYC && (this.cYD.cYC == 0 || this.cYD.cYC == this.cYD.cYB)) {
            this.cYD.cYC = i;
        }
        return this;
    }

    public c hf(int i) {
        if (isValid()) {
            this.cYD.cYB = i;
        }
        return this;
    }

    public int atO() {
        return this.cYD.cYC == 0 ? this.cYD.cYB : this.cYD.cYC;
    }

    public c nr(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.cYD.cYA.get(str))) {
            a nq = a.nq(str);
            if (a(nq)) {
                this.cYD.cYA.put(nq.atL(), nq);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.cYD) {
            z = this.cYD.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray atP() {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor T = com.baidu.swan.apps.database.a.b.T("", 400);
            int count = T.getCount();
            while (T.moveToNext()) {
                String string = T.getString(T.getColumnIndex("app_id"));
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg_id", string);
                    jSONArray.put(jSONObject);
                }
            }
            if (cYz) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (T != null) {
                if (0 != 0) {
                    T.close();
                } else {
                    T.close();
                }
            }
        } catch (JSONException e) {
            if (cYz) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void atQ() {
        if (cYz) {
            Log.i("PurgerStatistic", "performReport: " + this.cYD);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.atR();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atR() {
        String str;
        b.a value;
        synchronized (this.cYD) {
            if (isValid()) {
                this.cYD.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
                eVar.mSource = "NA";
                int atO = atO();
                eVar.mType = String.valueOf(atO);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.cYD.cYA.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.t("purged_list", jSONArray);
                if (7 == atO) {
                    eVar.t("history_list", atP());
                }
                if (cYz) {
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
