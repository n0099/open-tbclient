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
    public static final int aLl = a.C0151a.aiapps_slide_in_from_right;
    public static final int aLm = a.C0151a.aiapps_slide_out_to_right;
    public static final int aLn = a.C0151a.aiapps_hold;
    private k aLh;
    private a aLk;
    private Activity mActivity;
    private Queue<Runnable> aLj = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> aLi = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface a {
        void Fw();
    }

    public e(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        this.aLh = fragmentActivity.abX();
    }

    public void a(a aVar) {
        this.aLk = aVar;
    }

    public com.baidu.swan.apps.core.d.b Fq() {
        return dc(this.aLi.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T i(Class<T> cls) {
        for (int size = this.aLi.size() - 1; size >= 0; size--) {
            T t = (T) this.aLi.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d Fr() {
        for (int size = this.aLi.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.aLi.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b dc(int i) {
        if (this.aLi.isEmpty() || i < 0 || i >= this.aLi.size()) {
            return null;
        }
        return this.aLi.get(i);
    }

    public d Fs() {
        if (this.aLi.isEmpty()) {
            return null;
        }
        int size = this.aLi.size();
        for (int i = 0; i < size; i++) {
            if (this.aLi.get(i).Ev()) {
                return (d) this.aLi.get(i);
            }
        }
        return null;
    }

    public int Ft() {
        return this.aLi.size();
    }

    public b Fu() {
        return new b("");
    }

    public b eC(String str) {
        return new b(str);
    }

    /* loaded from: classes2.dex */
    public class b {
        private m aLo;
        private String aLp;

        public b(String str) {
            this.aLo = e.this.aLh.aca();
            this.aLp = str;
        }

        public b H(int i, int i2) {
            this.aLo.V(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.Ew();
            } else if ("setting".equals(str)) {
                a = f.FG();
            } else if ("wxPay".equals(str) || "adLanding".equals(str)) {
                a = g.a(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().gc(bVar.aTe).gd(bVar.mParams).ge(bVar.mBaseUrl).bS(z).Mp()) : null;
            }
            if (a == null) {
                return null;
            }
            return c(a);
        }

        public b c(com.baidu.swan.apps.core.d.b bVar) {
            d(bVar);
            this.aLo.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.aLi.add(bVar);
            if (e.this.aLk != null) {
                e.this.aLk.Fw();
            }
            return this;
        }

        private void d(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b Fq = e.this.Fq();
            e.this.aLj.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Fq != null && Fq.getUserVisibleHint()) {
                        Fq.setUserVisibleHint(false);
                    }
                    if (Fq instanceof d) {
                        ((d) Fq).Fp();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void Fx() {
            final com.baidu.swan.apps.core.d.b Fq = e.this.Fq();
            e.this.aLj.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Fq != null) {
                        Fq.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b dd(int i) {
            int size = e.this.aLi.size();
            if (!e.this.aLi.isEmpty() && i >= 0 && i < size) {
                this.aLo.a((com.baidu.swan.apps.core.d.b) e.this.aLi.remove(i));
            }
            return this;
        }

        public b Fy() {
            return de(1);
        }

        public b de(int i) {
            if (!e.this.aLi.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aLi.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.aLo.a((Fragment) arrayList.get(i4));
                    e.this.aLi.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.aLj.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                Fx();
            }
            return this;
        }

        public b Fz() {
            if (!e.this.aLi.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aLi.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).Ev()) {
                        this.aLo.a((Fragment) arrayList.get(size));
                        e.this.aLi.remove(size);
                    }
                }
                Fx();
            }
            return this;
        }

        public b FA() {
            List<Fragment> fragments = e.this.aLh.getFragments();
            if (fragments != null && fragments.size() != e.this.aLi.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.aLi.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.aLo.a(fragment);
                    }
                }
            }
            return de(e.this.aLi.size());
        }

        public b d(com.baidu.swan.apps.model.b bVar) {
            d Fs = e.this.Fs();
            if (Fs != null) {
                Fs.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void FB() {
            if (!e.this.aLi.isEmpty()) {
                int size = e.this.aLi.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.aLo.c((Fragment) e.this.aLi.get(i));
                    } else {
                        this.aLo.b((Fragment) e.this.aLi.get(i));
                    }
                }
            }
        }

        public void e(com.baidu.swan.apps.core.d.b bVar) {
            this.aLo.c(bVar).commitAllowingStateLoss();
            e.this.aLh.executePendingTransactions();
        }

        public void f(com.baidu.swan.apps.core.d.b bVar) {
            this.aLo.b(bVar).commitAllowingStateLoss();
            e.this.aLh.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.aLp)) {
                d.ew(this.aLp);
            }
            while (!e.this.aLj.isEmpty()) {
                if (e.this.aLj.peek() != null) {
                    ((Runnable) e.this.aLj.poll()).run();
                }
            }
            FB();
            this.aLo.commitAllowingStateLoss();
        }

        public boolean FC() {
            commit();
            return e.this.aLh.executePendingTransactions();
        }
    }
}
