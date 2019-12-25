package com.baidu.swan.apps.core.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.model.c;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.support.v4.app.k;
import com.baidu.swan.support.v4.app.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes9.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bje = new HashSet();
    public static final int bjf = a.C0185a.aiapps_slide_in_from_right;
    public static final int bjg = a.C0185a.aiapps_slide_out_to_right;
    public static final int bjh = a.C0185a.aiapps_hold;
    private k bja;
    private a bjd;
    private Queue<Runnable> bjc = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> bjb = new ArrayList<>();

    /* loaded from: classes9.dex */
    public interface a {
        void LH();
    }

    static {
        bje.add("adLanding");
        bje.add("wxPay");
        bje.add("default_webview");
        bje.add("allianceLogin");
        bje.add("allianceChooseAddress");
    }

    public e(FragmentActivity fragmentActivity) {
        this.bja = fragmentActivity.arT();
    }

    public void a(a aVar) {
        this.bjd = aVar;
    }

    public com.baidu.swan.apps.core.d.b LB() {
        return ef(this.bjb.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T p(Class<T> cls) {
        for (int size = this.bjb.size() - 1; size >= 0; size--) {
            T t = (T) this.bjb.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d LC() {
        for (int size = this.bjb.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.bjb.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b ef(int i) {
        if (this.bjb.isEmpty() || i < 0 || i >= this.bjb.size()) {
            return null;
        }
        return this.bjb.get(i);
    }

    public d LD() {
        if (this.bjb.isEmpty()) {
            return null;
        }
        int size = this.bjb.size();
        for (int i = 0; i < size; i++) {
            if (this.bjb.get(i).KJ()) {
                return (d) this.bjb.get(i);
            }
        }
        return null;
    }

    public int LE() {
        return this.bjb.size();
    }

    public b LF() {
        return new b("");
    }

    public b gJ(String str) {
        return new b(str);
    }

    /* loaded from: classes9.dex */
    public class b {
        private m bji;
        private String bjj;

        public b(String str) {
            this.bji = e.this.bja.arW();
            this.bjj = str;
        }

        public b U(int i, int i2) {
            this.bji.ao(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.KK();
            } else if ("setting".equals(str)) {
                a = g.LQ();
            } else if ("pluginFunPage".equals(str)) {
                a = f.ap(bVar.mBaseUrl, bVar.mParams);
            } else if (gK(str)) {
                a = h.c(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().jf(bVar.mPage).jg(bVar.mParams).jh(bVar.mBaseUrl).cO(z).VI()) : null;
            }
            if (a == null) {
                return null;
            }
            return e(a);
        }

        private boolean gK(String str) {
            return e.bje.contains(str);
        }

        public b e(com.baidu.swan.apps.core.d.b bVar) {
            f(bVar);
            this.bji.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.bjb.add(bVar);
            if (e.this.bjd != null) {
                e.this.bjd.LH();
            }
            return this;
        }

        private void f(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b LB = e.this.LB();
            e.this.bjc.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LB != null && LB.getUserVisibleHint()) {
                        LB.setUserVisibleHint(false);
                    }
                    if (LB instanceof d) {
                        ((d) LB).LA();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void LI() {
            final com.baidu.swan.apps.core.d.b LB = e.this.LB();
            e.this.bjc.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LB != null) {
                        LB.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b eg(int i) {
            int size = e.this.bjb.size();
            if (!e.this.bjb.isEmpty() && i >= 0 && i < size) {
                this.bji.a((com.baidu.swan.apps.core.d.b) e.this.bjb.remove(i));
            }
            return this;
        }

        public b LJ() {
            return eh(1);
        }

        public b eh(int i) {
            if (!e.this.bjb.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.bjb.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.bji.a((Fragment) arrayList.get(i4));
                    e.this.bjb.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.bjc.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                LI();
            }
            return this;
        }

        public b LK() {
            if (!e.this.bjb.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.bjb.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((com.baidu.swan.apps.core.d.b) arrayList.get(size)).KJ()) {
                        this.bji.a((Fragment) arrayList.get(size));
                        e.this.bjb.remove(size);
                    }
                }
                LI();
            }
            return this;
        }

        public b LL() {
            List<Fragment> fragments = e.this.bja.getFragments();
            if (fragments != null && fragments.size() != e.this.bjb.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.bjb.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.bji.a(fragment);
                    }
                }
            }
            return eh(e.this.bjb.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            d LD = e.this.LD();
            if (LD != null) {
                LD.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void LM() {
            if (!e.this.bjb.isEmpty()) {
                int size = e.this.bjb.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.bji.c((Fragment) e.this.bjb.get(i));
                    } else {
                        this.bji.b((Fragment) e.this.bjb.get(i));
                    }
                }
            }
        }

        public void g(com.baidu.swan.apps.core.d.b bVar) {
            this.bji.c(bVar).commitAllowingStateLoss();
            e.this.bja.executePendingTransactions();
        }

        public void h(com.baidu.swan.apps.core.d.b bVar) {
            this.bji.b(bVar).commitAllowingStateLoss();
            e.this.bja.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.bjj)) {
                d.gD(this.bjj);
            }
            while (!e.this.bjc.isEmpty()) {
                if (e.this.bjc.peek() != null) {
                    ((Runnable) e.this.bjc.poll()).run();
                }
            }
            LM();
            this.bji.commitAllowingStateLoss();
        }

        public boolean LN() {
            commit();
            return e.this.bja.executePendingTransactions();
        }
    }
}
