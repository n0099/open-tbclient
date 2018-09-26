package cn.jiguang.d.i;

import android.content.Context;
import cn.jiguang.api.SdkType;
import cn.jpush.android.service.DownloadProvider;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class f {
    private static f lW;
    private AtomicBoolean c = new AtomicBoolean(false);
    private e lU;
    private h lV;

    private f() {
        this.lU = null;
        this.lV = null;
        this.lU = new e();
        this.lV = new h();
    }

    public static f bT() {
        if (lW == null) {
            synchronized (f.class) {
                if (lW == null) {
                    lW = new f();
                }
            }
        }
        return lW;
    }

    public final void a(Context context) {
        if (this.c.get()) {
            return;
        }
        String b = cn.jiguang.d.a.b(context);
        if (b == null) {
            b = "";
        }
        this.lU.c(cn.jiguang.api.e.bl());
        this.lU.d("cn.jpush.android.service.PushService");
        this.lU.e(DownloadProvider.class);
        this.lU.a(3600L);
        this.lU.b(cn.jiguang.d.a.d.c(context));
        this.lU.a(b);
        this.lV.a(3600L);
        h hVar = this.lV;
        cn.jiguang.d.d.e.bD();
        hVar.b(cn.jiguang.d.d.e.j(SdkType.JPUSH.name(), ""));
        this.lV.a(b);
        this.c.set(true);
    }

    public final void a(Context context, boolean z) {
        try {
            cn.jiguang.api.e.a(new g(this, context, z), new int[0]);
        } catch (Throwable th) {
        }
    }

    public final e bU() {
        return this.lU;
    }

    public final h bV() {
        return this.lV;
    }
}
