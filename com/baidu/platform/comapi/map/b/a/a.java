package com.baidu.platform.comapi.map.b.a;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.b.a;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f2900a = 0;
    private boolean b = false;
    private a.C0279a c;
    private InterfaceC0280a d;

    /* renamed from: com.baidu.platform.comapi.map.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0280a {
        boolean a(a aVar);
    }

    public a(InterfaceC0280a interfaceC0280a) {
        this.d = interfaceC0280a;
    }

    private void a() {
        this.b = false;
        this.c = null;
        this.f2900a = 0L;
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2 || this.c == null) {
            return;
        }
        a.C0279a a2 = a.C0279a.a(motionEvent);
        boolean z = Math.abs(new a.C0279a(this.c.f2901a, a2.f2901a).b()) < 20.0d && Math.abs(new a.C0279a(this.c.b, a2.b).b()) < 20.0d;
        boolean z2 = System.currentTimeMillis() - this.f2900a < 200;
        if (z && z2 && this.b) {
            this.d.a(this);
        }
    }

    private void c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return;
        }
        this.c = a.C0279a.a(motionEvent);
        this.b = true;
    }

    public void a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f2900a = System.currentTimeMillis();
                return;
            case 5:
            case 261:
                c(motionEvent);
                return;
            case 6:
            case 262:
                b(motionEvent);
                a();
                return;
            default:
                return;
        }
    }
}
