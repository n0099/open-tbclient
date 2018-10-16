package cn.jiguang.d.i;

import android.content.Context;
import cn.jiguang.api.SdkType;
import cn.jpush.android.service.DownloadProvider;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class f {
    private static f mJ;
    private AtomicBoolean c = new AtomicBoolean(false);
    private e mH;
    private h mI;

    private f() {
        this.mH = null;
        this.mI = null;
        this.mH = new e();
        this.mI = new h();
    }

    public static f ck() {
        if (mJ == null) {
            synchronized (f.class) {
                if (mJ == null) {
                    mJ = new f();
                }
            }
        }
        return mJ;
    }

    public final void a(Context context) {
        if (this.c.get()) {
            return;
        }
        String b = cn.jiguang.d.a.b(context);
        if (b == null) {
            b = "";
        }
        this.mH.c(cn.jiguang.api.e.bC());
        this.mH.d("cn.jpush.android.service.PushService");
        this.mH.e(DownloadProvider.class);
        this.mH.a(3600L);
        this.mH.b(cn.jiguang.d.a.d.c(context));
        this.mH.a(b);
        this.mI.a(3600L);
        h hVar = this.mI;
        cn.jiguang.d.d.e.bU();
        hVar.b(cn.jiguang.d.d.e.j(SdkType.JPUSH.name(), ""));
        this.mI.a(b);
        this.c.set(true);
    }

    public final void a(Context context, boolean z) {
        try {
            cn.jiguang.api.e.a(new g(this, context, z), new int[0]);
        } catch (Throwable th) {
        }
    }

    public final e cl() {
        return this.mH;
    }

    public final h cm() {
        return this.mI;
    }
}
