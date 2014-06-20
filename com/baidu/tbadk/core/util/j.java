package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, JSONObject> {
    final /* synthetic */ h a;
    private final an b = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
    private final int c;
    private final int d;
    private final String e;
    private final String f;
    private final int g;
    private final int h;

    public j(h hVar, int i, int i2, int i3, String str, int i4, String str2) {
        this.a = hVar;
        this.c = i3;
        this.d = i4;
        this.e = str;
        this.f = str2;
        this.g = i;
        this.h = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public JSONObject doInBackground(Object... objArr) {
        if (this.a.b() == null || !this.a.b().d() || this.g == 0) {
            return null;
        }
        this.b.a("number", String.valueOf(this.h));
        if (this.g == 1) {
            this.b.a("ab_num_error", String.valueOf(this.c));
            this.b.a("error", this.e);
            this.b.a("ab_num_slow", String.valueOf(this.d));
            this.b.a("time", this.f);
        } else if (this.g == 3) {
            this.b.a("ab_num_slow", new StringBuilder(String.valueOf(this.d)).toString());
            this.b.a("time", this.f);
        } else if (this.g == 2) {
            this.b.a("ab_num_error", new StringBuilder(String.valueOf(this.c)).toString());
            this.b.a("error", this.e);
        }
        String i = this.b.i();
        if (!this.b.c() || TextUtils.isEmpty(i)) {
            return null;
        }
        try {
            return new JSONObject(i);
        } catch (JSONException e) {
            BdLog.e("CDNLogger", "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [398=6] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(JSONObject jSONObject) {
        int i;
        com.baidu.tbadk.core.data.e eVar;
        com.baidu.tbadk.core.data.e eVar2;
        super.onPostExecute(jSONObject);
        try {
            if (jSONObject == null) {
                com.baidu.adp.lib.stats.s a = ac.a();
                a.a("act", "fallback");
                a.a("result", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                a.a("type", "end");
                com.baidu.adp.lib.stats.h.a().a("img", a);
                return;
            }
            h hVar = this.a;
            i = hVar.i;
            int i2 = i + 1;
            hVar.i = i2;
            if (i2 >= 5) {
                eVar2 = this.a.h;
                eVar2.a(false);
                this.a.l = System.currentTimeMillis();
                return;
            }
            if (jSONObject.optJSONObject("ret").optInt("err_no", -1) != 0) {
                com.baidu.adp.lib.stats.s a2 = ac.a();
                a2.a("act", "fallback");
                a2.a("result", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                a2.a("type", "end");
                com.baidu.adp.lib.stats.h.a().a("img", a2);
            } else {
                com.baidu.adp.lib.stats.s a3 = ac.a();
                a3.a("act", "fallback");
                a3.a("result", "0");
                a3.a("type", "end");
                com.baidu.adp.lib.stats.h.a().a("img", a3);
                this.a.c();
                eVar = this.a.h;
                eVar.a(false);
                this.a.l = System.currentTimeMillis();
            }
            String optString = jSONObject.optString("photo_strategy");
            com.baidu.tbadk.core.data.e eVar3 = new com.baidu.tbadk.core.data.e();
            eVar3.a(optString);
            if (eVar3.d() == this.a.b().d() && eVar3.g() == this.a.b().g() && eVar3.e() == this.a.b().e() && eVar3.f() == this.a.b().f()) {
                return;
            }
            this.a.a(eVar3);
        } catch (Exception e) {
            BdLog.e("CDNLogger", "onPostExecute", e.getMessage());
        } finally {
            this.a.k = false;
        }
    }
}
