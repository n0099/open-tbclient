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
    private static final Set<String> caA = new HashSet();
    public static final int caB = a.C0287a.aiapps_slide_in_from_right;
    public static final int caC = a.C0287a.aiapps_slide_out_to_right;
    public static final int caD = a.C0287a.aiapps_hold;
    private k caw;
    private a caz;
    private Queue<Runnable> cay = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> cax = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void aab();
    }

    static {
        caA.add("adLanding");
        caA.add("wxPay");
        caA.add("default_webview");
        caA.add("allianceLogin");
        caA.add("allianceChooseAddress");
        caA.add("qrCodePay");
    }

    public e(FragmentActivity fragmentActivity) {
        this.caw = fragmentActivity.aID();
    }

    public void a(a aVar) {
        this.caz = aVar;
    }

    public com.baidu.swan.apps.core.d.b ZV() {
        return eX(this.cax.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T q(Class<T> cls) {
        for (int size = this.cax.size() - 1; size >= 0; size--) {
            T t = (T) this.cax.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d ZW() {
        for (int size = this.cax.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.cax.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b eX(int i) {
        if (this.cax.isEmpty() || i < 0 || i >= this.cax.size()) {
            return null;
        }
        return this.cax.get(i);
    }

    public d ZX() {
        if (this.cax.isEmpty()) {
            return null;
        }
        int size = this.cax.size();
        for (int i = 0; i < size; i++) {
            if (this.cax.get(i).YW()) {
                return (d) this.cax.get(i);
            }
        }
        return null;
    }

    public int ZY() {
        return this.cax.size();
    }

    public b ZZ() {
        return new b("");
    }

    public b jx(String str) {
        return new b(str);
    }

    /* loaded from: classes11.dex */
    public class b {
        private m caE;
        private String caF;

        public b(String str) {
            this.caE = e.this.caw.aIG();
            this.caF = str;
        }

        public b ag(int i, int i2) {
            this.caE.ax(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.YX();
            } else if ("setting".equals(str)) {
                a = g.aal();
            } else if ("pluginFunPage".equals(str)) {
                a = f.bb(bVar.mBaseUrl, bVar.mParams);
            } else if (jy(str)) {
                a = h.c(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().mf(bVar.mPage).mg(bVar.mParams).mh(bVar.mBaseUrl).et(z).akY()) : null;
            }
            if (a == null) {
                return null;
            }
            return f(a);
        }

        private boolean jy(String str) {
            return e.caA.contains(str);
        }

        public b f(com.baidu.swan.apps.core.d.b bVar) {
            g(bVar);
            this.caE.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.cax.add(bVar);
            if (e.this.caz != null) {
                e.this.caz.aab();
            }
            return this;
        }

        private void g(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b ZV = e.this.ZV();
            e.this.cay.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ZV != null && ZV.getUserVisibleHint()) {
                        ZV.setUserVisibleHint(false);
                    }
                    if (ZV instanceof d) {
                        ((d) ZV).ZU();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void aac() {
            final com.baidu.swan.apps.core.d.b ZV = e.this.ZV();
            e.this.cay.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ZV != null) {
                        ZV.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b eY(int i) {
            int size = e.this.cax.size();
            if (!e.this.cax.isEmpty() && i >= 0 && i < size) {
                this.caE.a((com.baidu.swan.apps.core.d.b) e.this.cax.remove(i));
            }
            return this;
        }

        public b aad() {
            return eZ(1);
        }

        public b eZ(int i) {
            if (!e.this.cax.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.cax.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.caE.a((Fragment) arrayList.get(i4));
                    e.this.cax.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.cay.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                aac();
            }
            return this;
        }

        public b aae() {
            if (!e.this.cax.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.cax.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((com.baidu.swan.apps.core.d.b) arrayList.get(size)).YW()) {
                        this.caE.a((Fragment) arrayList.get(size));
                        e.this.cax.remove(size);
                    }
                }
                aac();
            }
            return this;
        }

        public b aaf() {
            List<Fragment> fragments = e.this.caw.getFragments();
            if (fragments != null && fragments.size() != e.this.cax.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.cax.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.caE.a(fragment);
                    }
                }
            }
            return eZ(e.this.cax.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            d ZX = e.this.ZX();
            if (ZX != null) {
                ZX.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void aag() {
            if (!e.this.cax.isEmpty()) {
                int size = e.this.cax.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.caE.c((Fragment) e.this.cax.get(i));
                    } else {
                        this.caE.b((Fragment) e.this.cax.get(i));
                    }
                }
            }
        }

        public void h(com.baidu.swan.apps.core.d.b bVar) {
            this.caE.c(bVar).commitAllowingStateLoss();
            e.this.caw.executePendingTransactions();
        }

        public void i(com.baidu.swan.apps.core.d.b bVar) {
            this.caE.b(bVar).commitAllowingStateLoss();
            e.this.caw.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.caF)) {
                d.jr(this.caF);
            }
            while (!e.this.cay.isEmpty()) {
                if (e.this.cay.peek() != null) {
                    ((Runnable) e.this.cay.poll()).run();
                }
            }
            aag();
            this.caE.commitAllowingStateLoss();
        }

        public boolean aah() {
            commit();
            return e.this.caw.executePendingTransactions();
        }
    }
}
