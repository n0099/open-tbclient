package cn.jiguang.d.d;

import android.content.Context;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ac implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(JSONObject jSONObject, Context context) {
        this.a = jSONObject;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String e;
        e = aa.e(this.a);
        HashSet hashSet = new HashSet();
        hashSet.add(e);
        aa.a(this.b, new JSONArray().put(this.a), hashSet);
    }
}
