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
/* loaded from: classes9.dex */
public final class c implements b {
    private final b.C0421b daP;

    private c(b.C0421b c0421b) {
        this.daP = c0421b == null ? new b.C0421b() : c0421b;
    }

    public static c auk() {
        return a((b.C0421b) null);
    }

    public static c a(b.C0421b c0421b) {
        return new c(c0421b);
    }

    public b.C0421b aul() {
        return this.daP;
    }

    public c hh(int i) {
        if (isValid() && i != this.daP.daO && (this.daP.daO == 0 || this.daP.daO == this.daP.daN)) {
            this.daP.daO = i;
        }
        return this;
    }

    public c hi(int i) {
        if (isValid()) {
            this.daP.daN = i;
        }
        return this;
    }

    public int aum() {
        return this.daP.daO == 0 ? this.daP.daN : this.daP.daO;
    }

    public c nJ(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.daP.daM.get(str))) {
            a nI = a.nI(str);
            if (a(nI)) {
                this.daP.daM.put(nI.auj(), nI);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.daP) {
            z = this.daP.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray aun() {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor V = com.baidu.swan.apps.database.a.b.V("", 400);
            int count = V.getCount();
            while (V.moveToNext()) {
                String string = V.getString(V.getColumnIndex("app_id"));
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg_id", string);
                    jSONArray.put(jSONObject);
                }
            }
            if (daL) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (V != null) {
                if (0 != 0) {
                    V.close();
                } else {
                    V.close();
                }
            }
        } catch (JSONException e) {
            if (daL) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void auo() {
        if (daL) {
            Log.i("PurgerStatistic", "performReport: " + this.daP);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aup();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aup() {
        String str;
        b.a value;
        synchronized (this.daP) {
            if (isValid()) {
                this.daP.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
                eVar.mSource = "NA";
                int aum = aum();
                eVar.mType = String.valueOf(aum);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.daP.daM.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.r("purged_list", jSONArray);
                if (7 == aum) {
                    eVar.r("history_list", aun());
                }
                if (daL) {
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
