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
    private final b.C0441b dds;

    private c(b.C0441b c0441b) {
        this.dds = c0441b == null ? new b.C0441b() : c0441b;
    }

    public static c axF() {
        return a((b.C0441b) null);
    }

    public static c a(b.C0441b c0441b) {
        return new c(c0441b);
    }

    public b.C0441b axG() {
        return this.dds;
    }

    public c iK(int i) {
        if (isValid() && i != this.dds.ddr && (this.dds.ddr == 0 || this.dds.ddr == this.dds.ddq)) {
            this.dds.ddr = i;
        }
        return this;
    }

    public c iL(int i) {
        if (isValid()) {
            this.dds.ddq = i;
        }
        return this;
    }

    public int axH() {
        return this.dds.ddr == 0 ? this.dds.ddq : this.dds.ddr;
    }

    public c oE(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.dds.ddp.get(str))) {
            a oD = a.oD(str);
            if (a(oD)) {
                this.dds.ddp.put(oD.axE(), oD);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.dds) {
            z = this.dds.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray axI() {
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
            if (ddo) {
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
            if (ddo) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void axJ() {
        if (ddo) {
            Log.i("PurgerStatistic", "performReport: " + this.dds);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.axK();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axK() {
        String str;
        b.a value;
        synchronized (this.dds) {
            if (isValid()) {
                this.dds.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
                eVar.mSource = "NA";
                int axH = axH();
                eVar.mType = String.valueOf(axH);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.dds.ddp.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.t("purged_list", jSONArray);
                if (7 == axH) {
                    eVar.t("history_list", axI());
                }
                if (ddo) {
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
