package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ h a;
    private final ak b = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/p/updata");
    private final int c;
    private final int d;
    private final String e;
    private final String f;
    private final int g;
    private final int h;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(Object... objArr) {
        if (this.a.b() == null || !this.a.b().a() || this.g == 0) {
            return null;
        }
        this.b.a("number", new StringBuilder(String.valueOf(this.h)).toString());
        if (this.g == 1) {
            this.b.a("ab_num_error", new StringBuilder(String.valueOf(this.c)).toString());
            this.b.a("error", this.e);
            this.b.a("ab_num_slow", new StringBuilder(String.valueOf(this.d)).toString());
            this.b.a("time", this.f);
        } else if (this.g == 3) {
            this.b.a("ab_num_slow", new StringBuilder(String.valueOf(this.d)).toString());
            this.b.a("time", this.f);
        } else if (this.g == 2) {
            this.b.a("ab_num_error", new StringBuilder(String.valueOf(this.c)).toString());
            this.b.a("error", this.e);
        }
        return this.b.i();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        super.a((i) str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.optInt("error_code") != 0) {
                return;
            }
            String optString = jSONObject.optString("photo_strategy");
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.a(optString);
            if (eVar.a() == this.a.b().a() && eVar.e() == this.a.b().e() && eVar.c() == this.a.b().c() && eVar.d() == this.a.b().d()) {
                return;
            }
            this.a.a(eVar);
        } catch (Exception e) {
            com.baidu.tbadk.core.data.e eVar2 = new com.baidu.tbadk.core.data.e();
            eVar2.a(false);
            this.a.a(eVar2);
            com.baidu.adp.lib.util.f.b("CDNLogger", "onPostExecute", e.getMessage());
        }
    }

    public i(h hVar, int i, int i2, int i3, String str, int i4, String str2) {
        this.a = hVar;
        this.c = i3;
        this.d = i4;
        this.e = str;
        this.f = str2;
        this.g = i;
        this.h = i2;
    }
}
