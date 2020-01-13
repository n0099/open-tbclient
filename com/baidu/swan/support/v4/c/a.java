package com.baidu.swan.support.v4.c;

import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes10.dex */
public class a {
    static final InterfaceC0357a czO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.support.v4.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0357a {
        void a(LayoutInflater layoutInflater, e eVar);
    }

    /* loaded from: classes10.dex */
    static class b implements InterfaceC0357a {
        b() {
        }

        @Override // com.baidu.swan.support.v4.c.a.InterfaceC0357a
        public void a(LayoutInflater layoutInflater, e eVar) {
            com.baidu.swan.support.v4.c.b.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes10.dex */
    static class c extends b {
        c() {
        }

        @Override // com.baidu.swan.support.v4.c.a.b, com.baidu.swan.support.v4.c.a.InterfaceC0357a
        public void a(LayoutInflater layoutInflater, e eVar) {
            com.baidu.swan.support.v4.c.c.a(layoutInflater, eVar);
        }
    }

    /* loaded from: classes10.dex */
    static class d extends c {
        d() {
        }

        @Override // com.baidu.swan.support.v4.c.a.c, com.baidu.swan.support.v4.c.a.b, com.baidu.swan.support.v4.c.a.InterfaceC0357a
        public void a(LayoutInflater layoutInflater, e eVar) {
            com.baidu.swan.support.v4.c.d.a(layoutInflater, eVar);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            czO = new d();
        } else if (i >= 11) {
            czO = new c();
        } else {
            czO = new b();
        }
    }

    public static void a(LayoutInflater layoutInflater, e eVar) {
        czO.a(layoutInflater, eVar);
    }
}
