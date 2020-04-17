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
    private k bMu;
    private a bMx;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bMy = new HashSet();
    public static final int bMz = a.C0227a.aiapps_slide_in_from_right;
    public static final int bMA = a.C0227a.aiapps_slide_out_to_right;
    public static final int bMB = a.C0227a.aiapps_hold;
    private Queue<Runnable> bMw = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> bMv = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void Wk();
    }

    static {
        bMy.add("adLanding");
        bMy.add("wxPay");
        bMy.add("default_webview");
        bMy.add("allianceLogin");
        bMy.add("allianceChooseAddress");
    }

    public e(FragmentActivity fragmentActivity) {
        this.bMu = fragmentActivity.aCQ();
    }

    public void a(a aVar) {
        this.bMx = aVar;
    }

    public com.baidu.swan.apps.core.d.b We() {
        return eB(this.bMv.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T q(Class<T> cls) {
        for (int size = this.bMv.size() - 1; size >= 0; size--) {
            T t = (T) this.bMv.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d Wf() {
        for (int size = this.bMv.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.bMv.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b eB(int i) {
        if (this.bMv.isEmpty() || i < 0 || i >= this.bMv.size()) {
            return null;
        }
        return this.bMv.get(i);
    }

    public d Wg() {
        if (this.bMv.isEmpty()) {
            return null;
        }
        int size = this.bMv.size();
        for (int i = 0; i < size; i++) {
            if (this.bMv.get(i).Vm()) {
                return (d) this.bMv.get(i);
            }
        }
        return null;
    }

    public int Wh() {
        return this.bMv.size();
    }

    public b Wi() {
        return new b("");
    }

    public b io(String str) {
        return new b(str);
    }

    /* loaded from: classes11.dex */
    public class b {
        private m bMC;
        private String bMD;

        public b(String str) {
            this.bMC = e.this.bMu.aCT();
            this.bMD = str;
        }

        public b ab(int i, int i2) {
            this.bMC.av(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.Vn();
            } else if ("setting".equals(str)) {
                a = g.Wu();
            } else if ("pluginFunPage".equals(str)) {
                a = f.aI(bVar.mBaseUrl, bVar.mParams);
            } else if (ip(str)) {
                a = h.c(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().kJ(bVar.mPage).kK(bVar.mParams).kL(bVar.mBaseUrl).dX(z).agE()) : null;
            }
            if (a == null) {
                return null;
            }
            return e(a);
        }

        private boolean ip(String str) {
            return e.bMy.contains(str);
        }

        public b e(com.baidu.swan.apps.core.d.b bVar) {
            f(bVar);
            this.bMC.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.bMv.add(bVar);
            if (e.this.bMx != null) {
                e.this.bMx.Wk();
            }
            return this;
        }

        private void f(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b We = e.this.We();
            e.this.bMw.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (We != null && We.getUserVisibleHint()) {
                        We.setUserVisibleHint(false);
                    }
                    if (We instanceof d) {
                        ((d) We).Wd();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void Wl() {
            final com.baidu.swan.apps.core.d.b We = e.this.We();
            e.this.bMw.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (We != null) {
                        We.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b eC(int i) {
            int size = e.this.bMv.size();
            if (!e.this.bMv.isEmpty() && i >= 0 && i < size) {
                this.bMC.a((com.baidu.swan.apps.core.d.b) e.this.bMv.remove(i));
            }
            return this;
        }

        public b Wm() {
            return eD(1);
        }

        public b eD(int i) {
            if (!e.this.bMv.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.bMv.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.bMC.a((Fragment) arrayList.get(i4));
                    e.this.bMv.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.bMw.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                Wl();
            }
            return this;
        }

        public b Wn() {
            if (!e.this.bMv.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.bMv.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((com.baidu.swan.apps.core.d.b) arrayList.get(size)).Vm()) {
                        this.bMC.a((Fragment) arrayList.get(size));
                        e.this.bMv.remove(size);
                    }
                }
                Wl();
            }
            return this;
        }

        public b Wo() {
            List<Fragment> fragments = e.this.bMu.getFragments();
            if (fragments != null && fragments.size() != e.this.bMv.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.bMv.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.bMC.a(fragment);
                    }
                }
            }
            return eD(e.this.bMv.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            d Wg = e.this.Wg();
            if (Wg != null) {
                Wg.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void Wp() {
            if (!e.this.bMv.isEmpty()) {
                int size = e.this.bMv.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.bMC.c((Fragment) e.this.bMv.get(i));
                    } else {
                        this.bMC.b((Fragment) e.this.bMv.get(i));
                    }
                }
            }
        }

        public void g(com.baidu.swan.apps.core.d.b bVar) {
            this.bMC.c(bVar).commitAllowingStateLoss();
            e.this.bMu.executePendingTransactions();
        }

        public void h(com.baidu.swan.apps.core.d.b bVar) {
            this.bMC.b(bVar).commitAllowingStateLoss();
            e.this.bMu.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.bMD)) {
                d.ii(this.bMD);
            }
            while (!e.this.bMw.isEmpty()) {
                if (e.this.bMw.peek() != null) {
                    ((Runnable) e.this.bMw.poll()).run();
                }
            }
            Wp();
            this.bMC.commitAllowingStateLoss();
        }

        public boolean Wq() {
            commit();
            return e.this.bMu.executePendingTransactions();
        }
    }
}
