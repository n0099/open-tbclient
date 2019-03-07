package cn.jiguang.d.b.a.a;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public final class f implements Runnable {
    private final LinkedList<i> a = new LinkedList<>();
    private final cn.jiguang.d.b.a.d ll;

    public f(Context context, cn.jiguang.d.b.g gVar, long j) {
        this.ll = new cn.jiguang.d.b.a.d(context, gVar, j);
        this.a.add(new h(this.ll, true));
        this.a.add(new a(this.ll));
        this.a.add(new k(this.ll));
        this.a.add(new d(this.ll));
        this.a.add(new e(this.ll));
        this.a.add(new g(this.ll));
        this.a.add(new j(this.ll));
        this.a.add(new b(this.ll));
        this.a.add(new h(this.ll, false));
    }

    public final void a() {
        try {
            cn.jiguang.api.e.a(this, new int[0]);
        } catch (Throwable th) {
        }
    }

    public final int b() {
        Iterator<i> it = this.a.iterator();
        while (it.hasNext()) {
            try {
                switch (it.next().a()) {
                    case 0:
                        return 0;
                    case 2:
                        return 2;
                }
            } catch (Throwable th) {
            }
        }
        return -1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.ll.f();
    }
}
