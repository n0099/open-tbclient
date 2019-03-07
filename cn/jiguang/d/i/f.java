package cn.jiguang.d.i;

import android.content.Context;
import cn.jiguang.api.SdkType;
import cn.jpush.android.service.DownloadProvider;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class f {
    private static f mI;
    private AtomicBoolean c = new AtomicBoolean(false);
    private e mG;
    private h mH;

    private f() {
        this.mG = null;
        this.mH = null;
        this.mG = new e();
        this.mH = new h();
    }

    public static f cj() {
        if (mI == null) {
            synchronized (f.class) {
                if (mI == null) {
                    mI = new f();
                }
            }
        }
        return mI;
    }

    public final void a(Context context) {
        if (this.c.get()) {
            return;
        }
        String b = cn.jiguang.d.a.b(context);
        if (b == null) {
            b = "";
        }
        this.mG.c(cn.jiguang.api.e.bC());
        this.mG.d("cn.jpush.android.service.PushService");
        this.mG.e(DownloadProvider.class);
        this.mG.a(3600L);
        this.mG.b(cn.jiguang.d.a.d.c(context));
        this.mG.a(b);
        this.mH.a(3600L);
        h hVar = this.mH;
        cn.jiguang.d.d.e.bT();
        hVar.b(cn.jiguang.d.d.e.j(SdkType.JPUSH.name(), ""));
        this.mH.a(b);
        this.c.set(true);
    }

    public final void a(Context context, boolean z) {
        try {
            cn.jiguang.api.e.a(new g(this, context, z), new int[0]);
        } catch (Throwable th) {
        }
    }

    public final e ck() {
        return this.mG;
    }

    public final h cl() {
        return this.mH;
    }
}
