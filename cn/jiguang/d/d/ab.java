package cn.jiguang.d.d;

import android.content.Context;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ab implements Runnable {
    final /* synthetic */ JSONArray a;
    final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(JSONArray jSONArray, Context context) {
        this.a = jSONArray;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        aa.a(this.b, this.a, aa.e(this.a));
    }
}
