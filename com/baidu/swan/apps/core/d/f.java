package com.baidu.swan.apps.core.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cwC = new HashSet();
    public static final int cwD = a.C0343a.aiapps_slide_in_from_right;
    public static final int cwE = a.C0343a.aiapps_slide_out_to_right;
    public static final int cwF = a.C0343a.aiapps_hold;
    private k cwy;
    private Queue<Runnable> cwA = new LinkedList();
    private ArrayList<c> cwz = new ArrayList<>();
    private final List<a> cwB = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cwC.add("adLanding");
        cwC.add("wxPay");
        cwC.add("default_webview");
        cwC.add("allianceLogin");
        cwC.add("allianceChooseAddress");
        cwC.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cwy = fragmentActivity.aYq();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cwB.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cwB.remove(aVar);
        }
    }

    public c akH() {
        return hE(this.cwz.size() - 1);
    }

    public <T extends c> T q(Class<T> cls) {
        for (int size = this.cwz.size() - 1; size >= 0; size--) {
            T t = (T) this.cwz.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e akI() {
        for (int size = this.cwz.size() - 1; size >= 0; size--) {
            c cVar = this.cwz.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c hE(int i) {
        if (this.cwz.isEmpty() || i < 0 || i >= this.cwz.size()) {
            return null;
        }
        return this.cwz.get(i);
    }

    public e akJ() {
        if (this.cwz.isEmpty()) {
            return null;
        }
        int size = this.cwz.size();
        for (int i = 0; i < size; i++) {
            if (this.cwz.get(i).ajw()) {
                return (e) this.cwz.get(i);
            }
        }
        return null;
    }

    public int akK() {
        return this.cwz.size();
    }

    public b akL() {
        return new b("");
    }

    public b mt(String str) {
        return new b(str);
    }

    /* loaded from: classes10.dex */
    public class b {
        private m cwG;
        private String cwH;

        public b(String str) {
            this.cwG = f.this.cwy.aYt();
            this.cwH = str;
        }

        public b ak(int i, int i2) {
            this.cwG.aD(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a2;
            if ("about".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.a.ajx();
            } else if ("authority".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.b.ajL();
            } else if ("pluginFunPage".equals(str)) {
                a2 = g.bq(bVar.mBaseUrl, bVar.mParams);
            } else if (mu(str)) {
                a2 = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a2 = h.akU();
            } else {
                a2 = "normal".equals(str) ? e.a(new c.a().pI(bVar.mPage).pJ(bVar.mParams).pK(bVar.mBaseUrl).fn(z).axF()) : null;
            }
            if (a2 == null) {
                return null;
            }
            return f(a2);
        }

        private boolean mu(String str) {
            return f.cwC.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cwG.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cwz.add(cVar);
            for (a aVar : f.this.cwB) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c akH = f.this.akH();
            f.this.cwA.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (akH != null && akH.getUserVisibleHint()) {
                        akH.setUserVisibleHint(false);
                    }
                    if (akH instanceof e) {
                        ((e) akH).akE();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void akN() {
            final c akH = f.this.akH();
            f.this.cwA.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (akH != null) {
                        akH.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b hF(int i) {
            int size = f.this.cwz.size();
            if (!f.this.cwz.isEmpty() && i >= 0 && i < size) {
                this.cwG.c((c) f.this.cwz.remove(i));
            }
            return this;
        }

        public b akO() {
            return hG(1);
        }

        public b hG(int i) {
            if (!f.this.cwz.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cwz.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cwB) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cwG.c((Fragment) arrayList.get(i4));
                    f.this.cwz.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cwA.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                akN();
            }
            return this;
        }

        public b akP() {
            if (!f.this.cwz.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cwz.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).ajw()) {
                        this.cwG.c((Fragment) arrayList.get(size));
                        f.this.cwz.remove(size);
                    }
                }
                akN();
            }
            return this;
        }

        public b akQ() {
            List<Fragment> fragments = f.this.cwy.getFragments();
            if (fragments != null && fragments.size() != f.this.cwz.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cwz.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cwB) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cwG.c(fragment);
                    }
                }
            }
            return hG(f.this.cwz.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e akJ = f.this.akJ();
            if (akJ != null) {
                akJ.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void akR() {
            if (!f.this.cwz.isEmpty()) {
                int size = f.this.cwz.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cwG.e((Fragment) f.this.cwz.get(i));
                    } else {
                        this.cwG.d((Fragment) f.this.cwz.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cwG.e(cVar).commitAllowingStateLoss();
            f.this.cwy.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cwG.d(cVar).commitAllowingStateLoss();
            f.this.cwy.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cwH)) {
                e.mn(this.cwH);
            }
            while (!f.this.cwA.isEmpty()) {
                if (f.this.cwA.peek() != null) {
                    ((Runnable) f.this.cwA.poll()).run();
                }
            }
            akR();
            this.cwG.commitAllowingStateLoss();
        }

        public boolean akS() {
            commit();
            return f.this.cwy.executePendingTransactions();
        }
    }
}
