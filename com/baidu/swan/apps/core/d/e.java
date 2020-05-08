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
/* loaded from: classes11.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bMD = new HashSet();
    public static final int bME = a.C0248a.aiapps_slide_in_from_right;
    public static final int bMF = a.C0248a.aiapps_slide_out_to_right;
    public static final int bMG = a.C0248a.aiapps_hold;
    private a bMC;
    private k bMz;
    private Queue<Runnable> bMB = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> bMA = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void Wj();
    }

    static {
        bMD.add("adLanding");
        bMD.add("wxPay");
        bMD.add("default_webview");
        bMD.add("allianceLogin");
        bMD.add("allianceChooseAddress");
    }

    public e(FragmentActivity fragmentActivity) {
        this.bMz = fragmentActivity.aCQ();
    }

    public void a(a aVar) {
        this.bMC = aVar;
    }

    public com.baidu.swan.apps.core.d.b Wd() {
        return eB(this.bMA.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T q(Class<T> cls) {
        for (int size = this.bMA.size() - 1; size >= 0; size--) {
            T t = (T) this.bMA.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d We() {
        for (int size = this.bMA.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.bMA.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b eB(int i) {
        if (this.bMA.isEmpty() || i < 0 || i >= this.bMA.size()) {
            return null;
        }
        return this.bMA.get(i);
    }

    public d Wf() {
        if (this.bMA.isEmpty()) {
            return null;
        }
        int size = this.bMA.size();
        for (int i = 0; i < size; i++) {
            if (this.bMA.get(i).Vl()) {
                return (d) this.bMA.get(i);
            }
        }
        return null;
    }

    public int Wg() {
        return this.bMA.size();
    }

    public b Wh() {
        return new b("");
    }

    public b io(String str) {
        return new b(str);
    }

    /* loaded from: classes11.dex */
    public class b {
        private m bMH;
        private String bMI;

        public b(String str) {
            this.bMH = e.this.bMz.aCT();
            this.bMI = str;
        }

        public b ab(int i, int i2) {
            this.bMH.av(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.Vm();
            } else if ("setting".equals(str)) {
                a = g.Wt();
            } else if ("pluginFunPage".equals(str)) {
                a = f.aI(bVar.mBaseUrl, bVar.mParams);
            } else if (ip(str)) {
                a = h.c(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().kJ(bVar.mPage).kK(bVar.mParams).kL(bVar.mBaseUrl).dX(z).agD()) : null;
            }
            if (a == null) {
                return null;
            }
            return e(a);
        }

        private boolean ip(String str) {
            return e.bMD.contains(str);
        }

        public b e(com.baidu.swan.apps.core.d.b bVar) {
            f(bVar);
            this.bMH.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.bMA.add(bVar);
            if (e.this.bMC != null) {
                e.this.bMC.Wj();
            }
            return this;
        }

        private void f(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b Wd = e.this.Wd();
            e.this.bMB.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Wd != null && Wd.getUserVisibleHint()) {
                        Wd.setUserVisibleHint(false);
                    }
                    if (Wd instanceof d) {
                        ((d) Wd).Wc();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void Wk() {
            final com.baidu.swan.apps.core.d.b Wd = e.this.Wd();
            e.this.bMB.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Wd != null) {
                        Wd.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b eC(int i) {
            int size = e.this.bMA.size();
            if (!e.this.bMA.isEmpty() && i >= 0 && i < size) {
                this.bMH.a((com.baidu.swan.apps.core.d.b) e.this.bMA.remove(i));
            }
            return this;
        }

        public b Wl() {
            return eD(1);
        }

        public b eD(int i) {
            if (!e.this.bMA.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.bMA.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.bMH.a((Fragment) arrayList.get(i4));
                    e.this.bMA.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.bMB.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                Wk();
            }
            return this;
        }

        public b Wm() {
            if (!e.this.bMA.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.bMA.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((com.baidu.swan.apps.core.d.b) arrayList.get(size)).Vl()) {
                        this.bMH.a((Fragment) arrayList.get(size));
                        e.this.bMA.remove(size);
                    }
                }
                Wk();
            }
            return this;
        }

        public b Wn() {
            List<Fragment> fragments = e.this.bMz.getFragments();
            if (fragments != null && fragments.size() != e.this.bMA.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.bMA.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.bMH.a(fragment);
                    }
                }
            }
            return eD(e.this.bMA.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            d Wf = e.this.Wf();
            if (Wf != null) {
                Wf.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void Wo() {
            if (!e.this.bMA.isEmpty()) {
                int size = e.this.bMA.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.bMH.c((Fragment) e.this.bMA.get(i));
                    } else {
                        this.bMH.b((Fragment) e.this.bMA.get(i));
                    }
                }
            }
        }

        public void g(com.baidu.swan.apps.core.d.b bVar) {
            this.bMH.c(bVar).commitAllowingStateLoss();
            e.this.bMz.executePendingTransactions();
        }

        public void h(com.baidu.swan.apps.core.d.b bVar) {
            this.bMH.b(bVar).commitAllowingStateLoss();
            e.this.bMz.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.bMI)) {
                d.ii(this.bMI);
            }
            while (!e.this.bMB.isEmpty()) {
                if (e.this.bMB.peek() != null) {
                    ((Runnable) e.this.bMB.poll()).run();
                }
            }
            Wo();
            this.bMH.commitAllowingStateLoss();
        }

        public boolean Wp() {
            commit();
            return e.this.bMz.executePendingTransactions();
        }
    }
}
