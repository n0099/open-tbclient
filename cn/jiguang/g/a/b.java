package cn.jiguang.g.a;

import android.os.IBinder;
import cn.jiguang.d.a.d;
/* loaded from: classes3.dex */
final class b implements IBinder.DeathRecipient {
    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        cn.jiguang.d.a.a(cn.jiguang.d.a.d, false);
        d.c(cn.jiguang.d.a.d, false);
    }
}
