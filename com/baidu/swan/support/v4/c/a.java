package com.baidu.swan.support.v4.c;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes6.dex */
public class a {
    static final InterfaceC0561a elb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.support.v4.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0561a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes6.dex */
    static class b implements InterfaceC0561a {
        b() {
        }

        @Override // com.baidu.swan.support.v4.c.a.InterfaceC0561a
        public void a(LayoutInflater layoutInflater, e eVar) {
            com.baidu.swan.support.v4.c.b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes6.dex */
    static class c extends b {
        c() {
        }

        @Override // com.baidu.swan.support.v4.c.a.b, com.baidu.swan.support.v4.c.a.InterfaceC0561a
        public void a(LayoutInflater layoutInflater, e eVar) {
            com.baidu.swan.support.v4.c.c.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes6.dex */
    static class d extends c {
        d() {
        }

        @Override // com.baidu.swan.support.v4.c.a.c, com.baidu.swan.support.v4.c.a.b, com.baidu.swan.support.v4.c.a.InterfaceC0561a
        public void a(LayoutInflater layoutInflater, e eVar) {
            com.baidu.swan.support.v4.c.d.a(layoutInflater, eVar);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            elb = new d();
        } else if (i >= 11) {
            elb = new c();
        } else {
            elb = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        elb.a(layoutInflater, eVar);
    }
}
