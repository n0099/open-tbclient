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
    private static final Set<String> bof = new HashSet();
    public static final int bog = a.C0197a.aiapps_slide_in_from_right;
    public static final int boh = a.C0197a.aiapps_slide_out_to_right;
    public static final int boi = a.C0197a.aiapps_hold;
    private k bob;
    private a boe;
    private Queue<Runnable> bod = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> boc = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void Ot();
    }

    static {
        bof.add("adLanding");
        bof.add("wxPay");
        bof.add("default_webview");
        bof.add("allianceLogin");
        bof.add("allianceChooseAddress");
    }

    public e(FragmentActivity fragmentActivity) {
        this.bob = fragmentActivity.auC();
    }

    public void a(a aVar) {
        this.boe = aVar;
    }

    public com.baidu.swan.apps.core.d.b On() {
        return ew(this.boc.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T p(Class<T> cls) {
        for (int size = this.boc.size() - 1; size >= 0; size--) {
            T t = (T) this.boc.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d Oo() {
        for (int size = this.boc.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.boc.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b ew(int i) {
        if (this.boc.isEmpty() || i < 0 || i >= this.boc.size()) {
            return null;
        }
        return this.boc.get(i);
    }

    public d Op() {
        if (this.boc.isEmpty()) {
            return null;
        }
        int size = this.boc.size();
        for (int i = 0; i < size; i++) {
            if (this.boc.get(i).Nw()) {
                return (d) this.boc.get(i);
            }
        }
        return null;
    }

    public int Oq() {
        return this.boc.size();
    }

    public b Or() {
        return new b("");
    }

    public b hb(String str) {
        return new b(str);
    }

    /* loaded from: classes11.dex */
    public class b {
        private m boj;
        private String bok;

        public b(String str) {
            this.boj = e.this.bob.auF();
            this.bok = str;
        }

        public b Y(int i, int i2) {
            this.boj.as(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.Nx();
            } else if ("setting".equals(str)) {
                a = g.OC();
            } else if ("pluginFunPage".equals(str)) {
                a = f.aA(bVar.mBaseUrl, bVar.mParams);
            } else if (hc(str)) {
                a = h.c(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().jx(bVar.mPage).jy(bVar.mParams).jz(bVar.mBaseUrl).da(z).Yv()) : null;
            }
            if (a == null) {
                return null;
            }
            return e(a);
        }

        private boolean hc(String str) {
            return e.bof.contains(str);
        }

        public b e(com.baidu.swan.apps.core.d.b bVar) {
            f(bVar);
            this.boj.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.boc.add(bVar);
            if (e.this.boe != null) {
                e.this.boe.Ot();
            }
            return this;
        }

        private void f(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b On = e.this.On();
            e.this.bod.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (On != null && On.getUserVisibleHint()) {
                        On.setUserVisibleHint(false);
                    }
                    if (On instanceof d) {
                        ((d) On).Om();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void Ou() {
            final com.baidu.swan.apps.core.d.b On = e.this.On();
            e.this.bod.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (On != null) {
                        On.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b ex(int i) {
            int size = e.this.boc.size();
            if (!e.this.boc.isEmpty() && i >= 0 && i < size) {
                this.boj.a((com.baidu.swan.apps.core.d.b) e.this.boc.remove(i));
            }
            return this;
        }

        public b Ov() {
            return ey(1);
        }

        public b ey(int i) {
            if (!e.this.boc.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.boc.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.boj.a((Fragment) arrayList.get(i4));
                    e.this.boc.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.bod.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                Ou();
            }
            return this;
        }

        public b Ow() {
            if (!e.this.boc.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.boc.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((com.baidu.swan.apps.core.d.b) arrayList.get(size)).Nw()) {
                        this.boj.a((Fragment) arrayList.get(size));
                        e.this.boc.remove(size);
                    }
                }
                Ou();
            }
            return this;
        }

        public b Ox() {
            List<Fragment> fragments = e.this.bob.getFragments();
            if (fragments != null && fragments.size() != e.this.boc.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.boc.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.boj.a(fragment);
                    }
                }
            }
            return ey(e.this.boc.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            d Op = e.this.Op();
            if (Op != null) {
                Op.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void Oy() {
            if (!e.this.boc.isEmpty()) {
                int size = e.this.boc.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.boj.c((Fragment) e.this.boc.get(i));
                    } else {
                        this.boj.b((Fragment) e.this.boc.get(i));
                    }
                }
            }
        }

        public void g(com.baidu.swan.apps.core.d.b bVar) {
            this.boj.c(bVar).commitAllowingStateLoss();
            e.this.bob.executePendingTransactions();
        }

        public void h(com.baidu.swan.apps.core.d.b bVar) {
            this.boj.b(bVar).commitAllowingStateLoss();
            e.this.bob.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.bok)) {
                d.gV(this.bok);
            }
            while (!e.this.bod.isEmpty()) {
                if (e.this.bod.peek() != null) {
                    ((Runnable) e.this.bod.poll()).run();
                }
            }
            Oy();
            this.boj.commitAllowingStateLoss();
        }

        public boolean Oz() {
            commit();
            return e.this.bob.executePendingTransactions();
        }
    }
}
