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
/* loaded from: classes7.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cch = new HashSet();
    public static final int cci = a.C0290a.aiapps_slide_in_from_right;
    public static final int ccj = a.C0290a.aiapps_slide_out_to_right;
    public static final int cck = a.C0290a.aiapps_hold;
    private k ccd;
    private a ccg;
    private Queue<Runnable> ccf = new LinkedList();
    private ArrayList<c> cce = new ArrayList<>();

    /* loaded from: classes7.dex */
    public interface a {
        void abf();
    }

    static {
        cch.add("adLanding");
        cch.add("wxPay");
        cch.add("default_webview");
        cch.add("allianceLogin");
        cch.add("allianceChooseAddress");
        cch.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.ccd = fragmentActivity.aMv();
    }

    public void a(a aVar) {
        this.ccg = aVar;
    }

    public c aaZ() {
        return fc(this.cce.size() - 1);
    }

    public <T extends c> T q(Class<T> cls) {
        for (int size = this.cce.size() - 1; size >= 0; size--) {
            T t = (T) this.cce.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e aba() {
        for (int size = this.cce.size() - 1; size >= 0; size--) {
            c cVar = this.cce.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c fc(int i) {
        if (this.cce.isEmpty() || i < 0 || i >= this.cce.size()) {
            return null;
        }
        return this.cce.get(i);
    }

    public e abb() {
        if (this.cce.isEmpty()) {
            return null;
        }
        int size = this.cce.size();
        for (int i = 0; i < size; i++) {
            if (this.cce.get(i).ZR()) {
                return (e) this.cce.get(i);
            }
        }
        return null;
    }

    public int abc() {
        return this.cce.size();
    }

    public b abd() {
        return new b("");
    }

    public b jO(String str) {
        return new b(str);
    }

    /* loaded from: classes7.dex */
    public class b {
        private m ccl;
        private String ccm;

        public b(String str) {
            this.ccl = f.this.ccd.aMy();
            this.ccm = str;
        }

        public b ag(int i, int i2) {
            this.ccl.ax(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.ZS();
            } else if ("authority".equals(str)) {
                a = com.baidu.swan.apps.core.d.b.aag();
            } else if ("pluginFunPage".equals(str)) {
                a = g.bd(bVar.mBaseUrl, bVar.mParams);
            } else if (jP(str)) {
                a = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a = h.abn();
            } else {
                a = "normal".equals(str) ? e.a(new c.a().mD(bVar.mPage).mE(bVar.mParams).mF(bVar.mBaseUrl).eB(z).amp()) : null;
            }
            if (a == null) {
                return null;
            }
            return f(a);
        }

        private boolean jP(String str) {
            return f.cch.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.ccl.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cce.add(cVar);
            if (f.this.ccg != null) {
                f.this.ccg.abf();
            }
            return this;
        }

        private void g(final c cVar) {
            final c aaZ = f.this.aaZ();
            f.this.ccf.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aaZ != null && aaZ.getUserVisibleHint()) {
                        aaZ.setUserVisibleHint(false);
                    }
                    if (aaZ instanceof e) {
                        ((e) aaZ).aaY();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void abg() {
            final c aaZ = f.this.aaZ();
            f.this.ccf.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (aaZ != null) {
                        aaZ.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b fd(int i) {
            int size = f.this.cce.size();
            if (!f.this.cce.isEmpty() && i >= 0 && i < size) {
                this.ccl.a((c) f.this.cce.remove(i));
            }
            return this;
        }

        public b abh() {
            return fe(1);
        }

        public b fe(int i) {
            if (!f.this.cce.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cce.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.ccl.a((Fragment) arrayList.get(i4));
                    f.this.cce.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.ccf.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                abg();
            }
            return this;
        }

        public b abi() {
            if (!f.this.cce.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cce.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).ZR()) {
                        this.ccl.a((Fragment) arrayList.get(size));
                        f.this.cce.remove(size);
                    }
                }
                abg();
            }
            return this;
        }

        public b abj() {
            List<Fragment> fragments = f.this.ccd.getFragments();
            if (fragments != null && fragments.size() != f.this.cce.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cce.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.ccl.a(fragment);
                    }
                }
            }
            return fe(f.this.cce.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e abb = f.this.abb();
            if (abb != null) {
                abb.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void abk() {
            if (!f.this.cce.isEmpty()) {
                int size = f.this.cce.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.ccl.c((Fragment) f.this.cce.get(i));
                    } else {
                        this.ccl.b((Fragment) f.this.cce.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.ccl.c(cVar).commitAllowingStateLoss();
            f.this.ccd.executePendingTransactions();
        }

        public void i(c cVar) {
            this.ccl.b(cVar).commitAllowingStateLoss();
            f.this.ccd.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.ccm)) {
                e.jI(this.ccm);
            }
            while (!f.this.ccf.isEmpty()) {
                if (f.this.ccf.peek() != null) {
                    ((Runnable) f.this.ccf.poll()).run();
                }
            }
            abk();
            this.ccl.commitAllowingStateLoss();
        }

        public boolean abl() {
            commit();
            return f.this.ccd.executePendingTransactions();
        }
    }
}
