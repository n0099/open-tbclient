package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, Context context, String str2) {
        this.a = str;
        this.b = context;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= 4) {
                str = null;
                break;
            }
            i++;
            cn.jiguang.h.c a = cn.jpush.android.b.a.a(this.a, 5, 8000L);
            if (a != null && a.getResponseCode() == 200) {
                z = true;
                str = a.cs();
                break;
            }
        }
        if (z && !TextUtils.isEmpty(str)) {
            i.a(this.b, str);
            return;
        }
        e.a(this.c, 1021, cn.jpush.android.d.a.a(this.b, this.a), this.b);
        e.a(this.c, 996, null, this.b);
    }
}
