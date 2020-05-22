package com.baidu.swan.support.v4.c;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes11.dex */
public class a {
    static final InterfaceC0459a doU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.support.v4.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0459a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes11.dex */
    static class b implements InterfaceC0459a {
        b() {
        }

        @Override // com.baidu.swan.support.v4.c.a.InterfaceC0459a
        public void a(LayoutInflater layoutInflater, e eVar) {
            com.baidu.swan.support.v4.c.b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes11.dex */
    static class c extends b {
        c() {
        }

        @Override // com.baidu.swan.support.v4.c.a.b, com.baidu.swan.support.v4.c.a.InterfaceC0459a
        public void a(LayoutInflater layoutInflater, e eVar) {
            com.baidu.swan.support.v4.c.c.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes11.dex */
    static class d extends c {
        d() {
        }

        @Override // com.baidu.swan.support.v4.c.a.c, com.baidu.swan.support.v4.c.a.b, com.baidu.swan.support.v4.c.a.InterfaceC0459a
        public void a(LayoutInflater layoutInflater, e eVar) {
            com.baidu.swan.support.v4.c.d.a(layoutInflater, eVar);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            doU = new d();
        } else if (i >= 11) {
            doU = new c();
        } else {
            doU = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        doU.a(layoutInflater, eVar);
    }
}
