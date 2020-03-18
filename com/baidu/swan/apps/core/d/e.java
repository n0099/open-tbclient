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
    private static final Set<String> bor = new HashSet();
    public static final int bos = a.C0197a.aiapps_slide_in_from_right;
    public static final int bot = a.C0197a.aiapps_slide_out_to_right;
    public static final int bou = a.C0197a.aiapps_hold;
    private k bon;
    private a boq;
    private Queue<Runnable> bop = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> boo = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void Ow();
    }

    static {
        bor.add("adLanding");
        bor.add("wxPay");
        bor.add("default_webview");
        bor.add("allianceLogin");
        bor.add("allianceChooseAddress");
    }

    public e(FragmentActivity fragmentActivity) {
        this.bon = fragmentActivity.auF();
    }

    public void a(a aVar) {
        this.boq = aVar;
    }

    public com.baidu.swan.apps.core.d.b Oq() {
        return ew(this.boo.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T p(Class<T> cls) {
        for (int size = this.boo.size() - 1; size >= 0; size--) {
            T t = (T) this.boo.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d Or() {
        for (int size = this.boo.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.boo.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b ew(int i) {
        if (this.boo.isEmpty() || i < 0 || i >= this.boo.size()) {
            return null;
        }
        return this.boo.get(i);
    }

    public d Os() {
        if (this.boo.isEmpty()) {
            return null;
        }
        int size = this.boo.size();
        for (int i = 0; i < size; i++) {
            if (this.boo.get(i).Nz()) {
                return (d) this.boo.get(i);
            }
        }
        return null;
    }

    public int Ot() {
        return this.boo.size();
    }

    public b Ou() {
        return new b("");
    }

    public b ha(String str) {
        return new b(str);
    }

    /* loaded from: classes11.dex */
    public class b {
        private m bov;
        private String bow;

        public b(String str) {
            this.bov = e.this.bon.auI();
            this.bow = str;
        }

        public b Y(int i, int i2) {
            this.bov.as(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.NA();
            } else if ("setting".equals(str)) {
                a = g.OF();
            } else if ("pluginFunPage".equals(str)) {
                a = f.az(bVar.mBaseUrl, bVar.mParams);
            } else if (hb(str)) {
                a = h.c(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().jw(bVar.mPage).jx(bVar.mParams).jy(bVar.mBaseUrl).db(z).Yy()) : null;
            }
            if (a == null) {
                return null;
            }
            return e(a);
        }

        private boolean hb(String str) {
            return e.bor.contains(str);
        }

        public b e(com.baidu.swan.apps.core.d.b bVar) {
            f(bVar);
            this.bov.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.boo.add(bVar);
            if (e.this.boq != null) {
                e.this.boq.Ow();
            }
            return this;
        }

        private void f(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b Oq = e.this.Oq();
            e.this.bop.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Oq != null && Oq.getUserVisibleHint()) {
                        Oq.setUserVisibleHint(false);
                    }
                    if (Oq instanceof d) {
                        ((d) Oq).Op();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void Ox() {
            final com.baidu.swan.apps.core.d.b Oq = e.this.Oq();
            e.this.bop.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Oq != null) {
                        Oq.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b ex(int i) {
            int size = e.this.boo.size();
            if (!e.this.boo.isEmpty() && i >= 0 && i < size) {
                this.bov.a((com.baidu.swan.apps.core.d.b) e.this.boo.remove(i));
            }
            return this;
        }

        public b Oy() {
            return ey(1);
        }

        public b ey(int i) {
            if (!e.this.boo.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.boo.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.bov.a((Fragment) arrayList.get(i4));
                    e.this.boo.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.bop.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                Ox();
            }
            return this;
        }

        public b Oz() {
            if (!e.this.boo.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.boo.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((com.baidu.swan.apps.core.d.b) arrayList.get(size)).Nz()) {
                        this.bov.a((Fragment) arrayList.get(size));
                        e.this.boo.remove(size);
                    }
                }
                Ox();
            }
            return this;
        }

        public b OA() {
            List<Fragment> fragments = e.this.bon.getFragments();
            if (fragments != null && fragments.size() != e.this.boo.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.boo.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.bov.a(fragment);
                    }
                }
            }
            return ey(e.this.boo.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            d Os = e.this.Os();
            if (Os != null) {
                Os.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void OB() {
            if (!e.this.boo.isEmpty()) {
                int size = e.this.boo.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.bov.c((Fragment) e.this.boo.get(i));
                    } else {
                        this.bov.b((Fragment) e.this.boo.get(i));
                    }
                }
            }
        }

        public void g(com.baidu.swan.apps.core.d.b bVar) {
            this.bov.c(bVar).commitAllowingStateLoss();
            e.this.bon.executePendingTransactions();
        }

        public void h(com.baidu.swan.apps.core.d.b bVar) {
            this.bov.b(bVar).commitAllowingStateLoss();
            e.this.bon.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.bow)) {
                d.gU(this.bow);
            }
            while (!e.this.bop.isEmpty()) {
                if (e.this.bop.peek() != null) {
                    ((Runnable) e.this.bop.poll()).run();
                }
            }
            OB();
            this.bov.commitAllowingStateLoss();
        }

        public boolean OC() {
            commit();
            return e.this.bon.executePendingTransactions();
        }
    }
}
