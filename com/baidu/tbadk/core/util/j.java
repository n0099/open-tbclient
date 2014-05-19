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
    private final al b = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.CDN_LOG_ADDRESS);
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
        if (this.a.b() == null || !this.a.b().a() || this.g == 0) {
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
        if (TextUtils.isEmpty(i)) {
            return null;
        }
        try {
            return new JSONObject(i);
        } catch (JSONException e) {
            BdLog.e("CDNLogger", "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(JSONObject jSONObject) {
        int i;
        com.baidu.tbadk.core.data.e eVar;
        int i2;
        com.baidu.tbadk.core.data.e eVar2;
        super.onPostExecute(jSONObject);
        try {
            if (jSONObject.optInt("error_code") != 0) {
                h hVar = this.a;
                i2 = hVar.i;
                int i3 = i2 + 1;
                hVar.i = i3;
                if (i3 >= 5) {
                    eVar2 = this.a.h;
                    eVar2.a(false);
                    return;
                }
                return;
            }
            if (jSONObject.optJSONObject("ret").optInt("err_no") != 0) {
                h hVar2 = this.a;
                i = hVar2.i;
                int i4 = i + 1;
                hVar2.i = i4;
                if (i4 >= 5) {
                    eVar = this.a.h;
                    eVar.a(false);
                }
            }
            String optString = jSONObject.optString("photo_strategy");
            com.baidu.tbadk.core.data.e eVar3 = new com.baidu.tbadk.core.data.e();
            eVar3.a(optString);
            if (eVar3.a() != this.a.b().a() || eVar3.d() != this.a.b().d() || eVar3.b() != this.a.b().b() || eVar3.c() != this.a.b().c()) {
                this.a.a(eVar3);
            }
        } catch (Exception e) {
            com.baidu.tbadk.core.data.e eVar4 = new com.baidu.tbadk.core.data.e();
            eVar4.a(false);
            this.a.a(eVar4);
            BdLog.e("CDNLogger", "onPostExecute", e.getMessage());
        }
    }
}
