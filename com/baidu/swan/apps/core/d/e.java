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
    private static final Set<String> bod = new HashSet();
    public static final int boe = a.C0197a.aiapps_slide_in_from_right;
    public static final int bof = a.C0197a.aiapps_slide_out_to_right;
    public static final int bog = a.C0197a.aiapps_hold;
    private k bnZ;
    private a boc;
    private Queue<Runnable> bob = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> boa = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void Or();
    }

    static {
        bod.add("adLanding");
        bod.add("wxPay");
        bod.add("default_webview");
        bod.add("allianceLogin");
        bod.add("allianceChooseAddress");
    }

    public e(FragmentActivity fragmentActivity) {
        this.bnZ = fragmentActivity.auA();
    }

    public void a(a aVar) {
        this.boc = aVar;
    }

    public com.baidu.swan.apps.core.d.b Ol() {
        return ew(this.boa.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T p(Class<T> cls) {
        for (int size = this.boa.size() - 1; size >= 0; size--) {
            T t = (T) this.boa.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d Om() {
        for (int size = this.boa.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.boa.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b ew(int i) {
        if (this.boa.isEmpty() || i < 0 || i >= this.boa.size()) {
            return null;
        }
        return this.boa.get(i);
    }

    public d On() {
        if (this.boa.isEmpty()) {
            return null;
        }
        int size = this.boa.size();
        for (int i = 0; i < size; i++) {
            if (this.boa.get(i).Nu()) {
                return (d) this.boa.get(i);
            }
        }
        return null;
    }

    public int Oo() {
        return this.boa.size();
    }

    public b Op() {
        return new b("");
    }

    public b hb(String str) {
        return new b(str);
    }

    /* loaded from: classes11.dex */
    public class b {
        private m boh;
        private String boi;

        public b(String str) {
            this.boh = e.this.bnZ.auD();
            this.boi = str;
        }

        public b Y(int i, int i2) {
            this.boh.as(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.Nv();
            } else if ("setting".equals(str)) {
                a = g.OA();
            } else if ("pluginFunPage".equals(str)) {
                a = f.aA(bVar.mBaseUrl, bVar.mParams);
            } else if (hc(str)) {
                a = h.c(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().jx(bVar.mPage).jy(bVar.mParams).jz(bVar.mBaseUrl).da(z).Yt()) : null;
            }
            if (a == null) {
                return null;
            }
            return e(a);
        }

        private boolean hc(String str) {
            return e.bod.contains(str);
        }

        public b e(com.baidu.swan.apps.core.d.b bVar) {
            f(bVar);
            this.boh.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.boa.add(bVar);
            if (e.this.boc != null) {
                e.this.boc.Or();
            }
            return this;
        }

        private void f(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b Ol = e.this.Ol();
            e.this.bob.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Ol != null && Ol.getUserVisibleHint()) {
                        Ol.setUserVisibleHint(false);
                    }
                    if (Ol instanceof d) {
                        ((d) Ol).Ok();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void Os() {
            final com.baidu.swan.apps.core.d.b Ol = e.this.Ol();
            e.this.bob.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Ol != null) {
                        Ol.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b ex(int i) {
            int size = e.this.boa.size();
            if (!e.this.boa.isEmpty() && i >= 0 && i < size) {
                this.boh.a((com.baidu.swan.apps.core.d.b) e.this.boa.remove(i));
            }
            return this;
        }

        public b Ot() {
            return ey(1);
        }

        public b ey(int i) {
            if (!e.this.boa.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.boa.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.boh.a((Fragment) arrayList.get(i4));
                    e.this.boa.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.bob.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                Os();
            }
            return this;
        }

        public b Ou() {
            if (!e.this.boa.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.boa.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((com.baidu.swan.apps.core.d.b) arrayList.get(size)).Nu()) {
                        this.boh.a((Fragment) arrayList.get(size));
                        e.this.boa.remove(size);
                    }
                }
                Os();
            }
            return this;
        }

        public b Ov() {
            List<Fragment> fragments = e.this.bnZ.getFragments();
            if (fragments != null && fragments.size() != e.this.boa.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.boa.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.boh.a(fragment);
                    }
                }
            }
            return ey(e.this.boa.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            d On = e.this.On();
            if (On != null) {
                On.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void Ow() {
            if (!e.this.boa.isEmpty()) {
                int size = e.this.boa.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.boh.c((Fragment) e.this.boa.get(i));
                    } else {
                        this.boh.b((Fragment) e.this.boa.get(i));
                    }
                }
            }
        }

        public void g(com.baidu.swan.apps.core.d.b bVar) {
            this.boh.c(bVar).commitAllowingStateLoss();
            e.this.bnZ.executePendingTransactions();
        }

        public void h(com.baidu.swan.apps.core.d.b bVar) {
            this.boh.b(bVar).commitAllowingStateLoss();
            e.this.bnZ.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.boi)) {
                d.gV(this.boi);
            }
            while (!e.this.bob.isEmpty()) {
                if (e.this.bob.peek() != null) {
                    ((Runnable) e.this.bob.poll()).run();
                }
            }
            Ow();
            this.boh.commitAllowingStateLoss();
        }

        public boolean Ox() {
            commit();
            return e.this.bnZ.executePendingTransactions();
        }
    }
}
