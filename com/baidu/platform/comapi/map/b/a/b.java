package com.baidu.platform.comapi.map.b.a;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.b.a;
import com.baidu.platform.comapi.map.b.f;
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a.C0290a f2904a;
    public a.C0290a b;
    public a.C0290a c;
    public MotionEvent d;
    private a f;
    public f e = new f();
    private boolean g = false;

    /* loaded from: classes26.dex */
    public interface a {
        boolean a(b bVar);

        boolean b(b bVar);

        boolean c(b bVar);
    }

    public b(a aVar) {
        this.f = aVar;
    }

    private void a() {
        this.e.a();
        this.f2904a = null;
        this.b = null;
        this.c = null;
        this.g = true;
        this.f.a(this);
    }

    private void b() {
        this.e.b();
        this.g = false;
        this.f.c(this);
    }

    private void b(MotionEvent motionEvent) {
        this.e.a(motionEvent);
        Pair<a.d, a.d> c = this.e.c();
        if (motionEvent.getPointerCount() == 2) {
            if (Math.abs(((a.d) c.first).f2907a) > 0.0d || Math.abs(((a.d) c.first).b) > 0.0d || Math.abs(((a.d) c.second).f2907a) > 0.0d || Math.abs(((a.d) c.second).b) > 0.0d) {
                c(motionEvent);
                this.f.b(this);
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        a.C0290a a2 = a.C0290a.a(motionEvent);
        this.b = this.c != null ? this.c : a2;
        this.c = a2;
        if (this.f2904a == null) {
            this.f2904a = a2;
        }
    }

    public void a(MotionEvent motionEvent) {
        this.d = motionEvent;
        switch (motionEvent.getAction()) {
            case 2:
                if (this.g) {
                    b(motionEvent);
                    return;
                } else if (motionEvent.getPointerCount() == 2) {
                    a();
                    return;
                } else {
                    return;
                }
            case 5:
            case 261:
                if (this.g) {
                    return;
                }
                a();
                return;
            case 6:
            case 262:
                if (this.g) {
                    b();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
