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
/* loaded from: classes3.dex */
public final class c implements b {
    private final b.C0396b csO;

    private c(b.C0396b c0396b) {
        this.csO = c0396b == null ? new b.C0396b() : c0396b;
    }

    public static c amG() {
        return a((b.C0396b) null);
    }

    public static c a(b.C0396b c0396b) {
        return new c(c0396b);
    }

    public b.C0396b amH() {
        return this.csO;
    }

    public c hD(int i) {
        if (isValid() && i != this.csO.csN && (this.csO.csN == 0 || this.csO.csN == this.csO.csM)) {
            this.csO.csN = i;
        }
        return this;
    }

    public c hE(int i) {
        if (isValid()) {
            this.csO.csM = i;
        }
        return this;
    }

    public int amI() {
        return this.csO.csN == 0 ? this.csO.csM : this.csO.csN;
    }

    public c mP(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.csO.csL.get(str))) {
            a mO = a.mO(str);
            if (a(mO)) {
                this.csO.csL.put(mO.amF(), mO);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.csO) {
            z = this.csO.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray amJ() {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor N = com.baidu.swan.apps.database.a.b.N("", 400);
            int count = N.getCount();
            while (N.moveToNext()) {
                String string = N.getString(N.getColumnIndex("app_id"));
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg_id", string);
                    jSONArray.put(jSONObject);
                }
            }
            if (csK) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (N != null) {
                if (0 != 0) {
                    N.close();
                } else {
                    N.close();
                }
            }
        } catch (JSONException e) {
            if (csK) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void amK() {
        if (csK) {
            Log.i("PurgerStatistic", "performReport: " + this.csO);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.amL();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amL() {
        String str;
        b.a value;
        synchronized (this.csO) {
            if (isValid()) {
                this.csO.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = "swan";
                eVar.mSource = "NA";
                int amI = amI();
                eVar.mType = String.valueOf(amI);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.csO.csL.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.u("purged_list", jSONArray);
                if (7 == amI) {
                    eVar.u("history_list", amJ());
                }
                if (csK) {
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
