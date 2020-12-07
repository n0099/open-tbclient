package com.baidu.platform.comapi.map.b.a;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.b.a;
/* loaded from: classes26.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private long f2902a = 0;
    private boolean b = false;
    private a.C0290a c;
    private InterfaceC0291a d;

    /* renamed from: com.baidu.platform.comapi.map.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC0291a {
        boolean a(a aVar);
    }

    public a(InterfaceC0291a interfaceC0291a) {
        this.d = interfaceC0291a;
    }

    private void a() {
        this.b = false;
        this.c = null;
        this.f2902a = 0L;
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2 || this.c == null) {
            return;
        }
        a.C0290a a2 = a.C0290a.a(motionEvent);
        boolean z = Math.abs(new a.C0290a(this.c.f2903a, a2.f2903a).b()) < 20.0d && Math.abs(new a.C0290a(this.c.b, a2.b).b()) < 20.0d;
        boolean z2 = System.currentTimeMillis() - this.f2902a < 200;
        if (z && z2 && this.b) {
            this.d.a(this);
        }
    }

    private void c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return;
        }
        this.c = a.C0290a.a(motionEvent);
        this.b = true;
    }

    public void a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f2902a = System.currentTimeMillis();
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
