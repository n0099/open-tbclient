package com.baidu.platform.comapi.map.b.a;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.b.a;
/* loaded from: classes20.dex */
public class a {
    private long a = 0;
    private boolean b = false;
    private a.C0242a c;
    private InterfaceC0243a d;

    /* renamed from: com.baidu.platform.comapi.map.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public interface InterfaceC0243a {
        boolean a(a aVar);
    }

    public a(InterfaceC0243a interfaceC0243a) {
        this.d = interfaceC0243a;
    }

    private void a() {
        this.b = false;
        this.c = null;
        this.a = 0L;
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2 || this.c == null) {
            return;
        }
        a.C0242a a = a.C0242a.a(motionEvent);
        boolean z = Math.abs(new a.C0242a(this.c.a, a.a).b()) < 20.0d && Math.abs(new a.C0242a(this.c.b, a.b).b()) < 20.0d;
        boolean z2 = System.currentTimeMillis() - this.a < 200;
        if (z && z2 && this.b) {
            this.d.a(this);
        }
    }

    private void c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return;
        }
        this.c = a.C0242a.a(motionEvent);
        this.b = true;
    }

    public void a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.a = System.currentTimeMillis();
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
