package com.baidu.platform.comapi.map.b.a;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.b.a;
/* loaded from: classes3.dex */
public class a {
    private long a = 0;
    private boolean b = false;
    private a.C0240a c;
    private InterfaceC0241a d;

    /* renamed from: com.baidu.platform.comapi.map.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0241a {
        boolean a(a aVar);
    }

    public a(InterfaceC0241a interfaceC0241a) {
        this.d = interfaceC0241a;
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
        a.C0240a a = a.C0240a.a(motionEvent);
        boolean z = Math.abs(new a.C0240a(this.c.a, a.a).b()) < 20.0d && Math.abs(new a.C0240a(this.c.b, a.b).b()) < 20.0d;
        boolean z2 = System.currentTimeMillis() - this.a < 200;
        if (z && z2 && this.b) {
            this.d.a(this);
        }
    }

    private void c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return;
        }
        this.c = a.C0240a.a(motionEvent);
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
