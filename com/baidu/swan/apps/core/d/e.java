package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.model.c;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.support.v4.app.k;
import com.baidu.swan.support.v4.app.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final int arw = a.C0110a.aiapps_slide_in_from_right;
    public static final int arx = a.C0110a.aiapps_slide_out_to_right;
    public static final int ary = a.C0110a.aiapps_hold;
    private k ars;
    private a arv;
    private Activity mActivity;
    private Queue<Runnable> aru = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> art = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface a {
        void Ax();
    }

    public e(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        this.ars = fragmentActivity.Xe();
    }

    public void a(a aVar) {
        this.arv = aVar;
    }

    public com.baidu.swan.apps.core.d.b Ar() {
        return cf(this.art.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T k(Class<T> cls) {
        for (int size = this.art.size() - 1; size >= 0; size--) {
            T t = (T) this.art.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d As() {
        for (int size = this.art.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.art.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b cf(int i) {
        if (this.art.isEmpty() || i < 0 || i >= this.art.size()) {
            return null;
        }
        return this.art.get(i);
    }

    public d At() {
        if (this.art.isEmpty()) {
            return null;
        }
        int size = this.art.size();
        for (int i = 0; i < size; i++) {
            if (this.art.get(i).zw()) {
                return (d) this.art.get(i);
            }
        }
        return null;
    }

    public int Au() {
        return this.art.size();
    }

    public b Av() {
        return new b("");
    }

    public b dS(String str) {
        return new b(str);
    }

    /* loaded from: classes2.dex */
    public class b {
        private String arA;
        private m arz;

        public b(String str) {
            this.arz = e.this.ars.Xh();
            this.arA = str;
        }

        public b B(int i, int i2) {
            this.arz.P(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.zx();
            } else if ("setting".equals(str)) {
                a = f.AH();
            } else if ("wxPay".equals(str) || "adLanding".equals(str)) {
                a = g.a(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().fw(bVar.azs).fx(bVar.mParams).fy(bVar.mBaseUrl).bA(z).Hr()) : null;
            }
            if (a == null) {
                return null;
            }
            return c(a);
        }

        public b c(com.baidu.swan.apps.core.d.b bVar) {
            d(bVar);
            this.arz.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.art.add(bVar);
            if (e.this.arv != null) {
                e.this.arv.Ax();
            }
            return this;
        }

        private void d(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b Ar = e.this.Ar();
            e.this.aru.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Ar != null && Ar.getUserVisibleHint()) {
                        Ar.setUserVisibleHint(false);
                    }
                    if (Ar instanceof d) {
                        ((d) Ar).Aq();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void Ay() {
            final com.baidu.swan.apps.core.d.b Ar = e.this.Ar();
            e.this.aru.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Ar != null) {
                        Ar.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b cg(int i) {
            int size = e.this.art.size();
            if (!e.this.art.isEmpty() && i >= 0 && i < size) {
                this.arz.a((com.baidu.swan.apps.core.d.b) e.this.art.remove(i));
            }
            return this;
        }

        public b Az() {
            return ch(1);
        }

        public b ch(int i) {
            if (!e.this.art.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.art.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.arz.a((Fragment) arrayList.get(i4));
                    e.this.art.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.aru.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                Ay();
            }
            return this;
        }

        public b AA() {
            if (!e.this.art.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.art.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).zw()) {
                        this.arz.a((Fragment) arrayList.get(size));
                        e.this.art.remove(size);
                    }
                }
                Ay();
            }
            return this;
        }

        public b AB() {
            List<Fragment> fragments = e.this.ars.getFragments();
            if (fragments != null && fragments.size() != e.this.art.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.art.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.arz.a(fragment);
                    }
                }
            }
            return ch(e.this.art.size());
        }

        public b d(com.baidu.swan.apps.model.b bVar) {
            d At = e.this.At();
            if (At != null) {
                At.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void AC() {
            if (!e.this.art.isEmpty()) {
                int size = e.this.art.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.arz.c((Fragment) e.this.art.get(i));
                    } else {
                        this.arz.b((Fragment) e.this.art.get(i));
                    }
                }
            }
        }

        public void e(com.baidu.swan.apps.core.d.b bVar) {
            this.arz.c(bVar).commitAllowingStateLoss();
            e.this.ars.executePendingTransactions();
        }

        public void f(com.baidu.swan.apps.core.d.b bVar) {
            this.arz.b(bVar).commitAllowingStateLoss();
            e.this.ars.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.arA)) {
                d.dM(this.arA);
            }
            while (!e.this.aru.isEmpty()) {
                if (e.this.aru.peek() != null) {
                    ((Runnable) e.this.aru.poll()).run();
                }
            }
            AC();
            this.arz.commitAllowingStateLoss();
        }

        public boolean AD() {
            commit();
            return e.this.ars.executePendingTransactions();
        }
    }
}
