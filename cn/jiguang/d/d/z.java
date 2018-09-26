package cn.jiguang.d.d;

import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class z implements Runnable {
    private final Context a;

    private z(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(Context context, byte b) {
        this(context);
    }

    @Override // java.lang.Runnable
    public final void run() {
        LinkedHashSet aj;
        boolean b;
        try {
            String jSONObject = y.ak(this.a).f().toString();
            aj = y.aj(this.a);
            aj.addAll(cn.jiguang.d.a.ky.bo());
            if (cn.jiguang.g.a.d(this.a)) {
                Iterator it = aj.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!TextUtils.isEmpty(str)) {
                        b = y.b(this.a, str, jSONObject);
                        if (b) {
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
    }
}
