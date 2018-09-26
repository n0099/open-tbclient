package cn.jiguang.d.d;

import android.content.Context;
import java.io.File;
import java.util.Set;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Set b;
    final /* synthetic */ JSONObject c;
    final /* synthetic */ File d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Set set, JSONObject jSONObject, File file) {
        this.a = context;
        this.b = set;
        this.c = jSONObject;
        this.d = file;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            aa.a(this.a, this.b, this.c, this.d);
        } finally {
            s.a(this.d);
        }
    }
}
