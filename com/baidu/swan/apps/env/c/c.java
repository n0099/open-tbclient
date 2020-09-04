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
/* loaded from: classes8.dex */
public final class c implements b {
    private final b.C0401b cqL;

    private c(b.C0401b c0401b) {
        this.cqL = c0401b == null ? new b.C0401b() : c0401b;
    }

    public static c alW() {
        return a((b.C0401b) null);
    }

    public static c a(b.C0401b c0401b) {
        return new c(c0401b);
    }

    public b.C0401b alX() {
        return this.cqL;
    }

    public c hu(int i) {
        if (isValid() && i != this.cqL.cqK && (this.cqL.cqK == 0 || this.cqL.cqK == this.cqL.cqJ)) {
            this.cqL.cqK = i;
        }
        return this;
    }

    public c hv(int i) {
        if (isValid()) {
            this.cqL.cqJ = i;
        }
        return this;
    }

    public int alY() {
        return this.cqL.cqK == 0 ? this.cqL.cqJ : this.cqL.cqK;
    }

    public c mw(@Nullable String str) {
        if (isValid() && !TextUtils.isEmpty(str) && !a(this.cqL.cqI.get(str))) {
            a mv = a.mv(str);
            if (a(mv)) {
                this.cqL.cqI.put(mv.alV(), mv);
            }
        }
        return this;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this.cqL) {
            z = this.cqL.mIsValid;
        }
        return z;
    }

    private static boolean a(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    @NonNull
    private JSONArray alZ() {
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
            if (cqH) {
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
            if (cqH) {
                e.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e);
            }
        }
        return jSONArray;
    }

    public void ama() {
        if (cqH) {
            Log.i("PurgerStatistic", "performReport: " + this.cqL);
        }
        if (isValid()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.env.c.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.amb();
                }
            }, "PurgerStatistic", 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amb() {
        String str;
        b.a value;
        synchronized (this.cqL) {
            if (isValid()) {
                this.cqL.mIsValid = false;
                e eVar = new e();
                eVar.mFrom = "swan";
                eVar.mSource = "NA";
                int alY = alY();
                eVar.mType = String.valueOf(alY);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.cqL.cqI.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.toJSONObject());
                    }
                }
                eVar.u("purged_list", jSONArray);
                if (7 == alY) {
                    eVar.u("history_list", alZ());
                }
                if (cqH) {
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
