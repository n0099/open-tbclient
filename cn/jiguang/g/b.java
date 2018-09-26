package cn.jiguang.g;

import android.content.Context;
import android.widget.Toast;
/* loaded from: classes3.dex */
final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.a, this.b, 0).show();
    }
}
