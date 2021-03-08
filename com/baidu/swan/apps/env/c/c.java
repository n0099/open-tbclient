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
    private final b.C0427b dcq;

    private c(b.C0427b c0427b) {
        this.dcq = c0427b == null ? new b.C0427b() : c0427b;
    }

    public static c aun() {
        return a((b.C0427b) null);
    }

    public static c a(b.C0427b c0427b) {
        return new c(c0427b);
    }

    public b.C0427b auo() {
        return this.dcq;
    }

    public c hi(int i) {
        if (isValid() && i != this.dcq.dcp && (this.dcq.dcp == 0 || this.dcq.dcp == this.dcq.dco)) {
            this.dcq.dcp = i;
        }
        return this;
    }

    public c hj(int i) {
        if (isValid()) {
            this.dcq.dco = i;
        }
        return this;
    }

    public int aup() {
        return this.dcq.dcp == 0 ? this.dcq.dco : this.dcq.dcp;
    }

    public c nQ(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.dcq.dcn.get(str))) {
            a nP = a.nP(str);
            if (a(nP)) {
                this.dcq.dcn.put(nP.aum(), nP);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.dcq) {
            z = this.dcq.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray auq() {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor W = com.baidu.swan.apps.database.a.b.W("", 400);
            int count = W.getCount();
            while (W.moveToNext()) {
                String string = W.getString(W.getColumnIndex("app_id"));
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg_id", string);
                    jSONArray.put(jSONObject);
                }
            }
            if (dcm) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (W != null) {
                if (0 != 0) {
                    W.close();
                } else {
                    W.close();
                }
            }
        } catch (JSONException e) {
            if (dcm) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void aur() {
        if (dcm) {
            Log.i("PurgerStatistic", "performReport: " + this.dcq);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aus();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aus() {
        String str;
        b.a value;
        synchronized (this.dcq) {
            if (isValid()) {
                this.dcq.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
                eVar.mSource = "NA";
                int aup = aup();
                eVar.mType = String.valueOf(aup);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.dcq.dcn.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.s("purged_list", jSONArray);
                if (7 == aup) {
                    eVar.s("history_list", auq());
                }
                if (dcm) {
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
