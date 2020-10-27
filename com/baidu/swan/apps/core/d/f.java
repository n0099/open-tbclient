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
    private static final Set<String> cEY = new HashSet();
    public static final int cEZ = a.C0357a.aiapps_slide_in_from_right;
    public static final int cFa = a.C0357a.aiapps_slide_out_to_right;
    public static final int cFb = a.C0357a.aiapps_hold;
    private k cEU;
    private Queue<Runnable> cEW = new LinkedList();
    private ArrayList<c> cEV = new ArrayList<>();
    private final List<a> cEX = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cEY.add("adLanding");
        cEY.add("wxPay");
        cEY.add("default_webview");
        cEY.add("allianceLogin");
        cEY.add("allianceChooseAddress");
        cEY.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cEU = fragmentActivity.baj();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cEX.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cEX.remove(aVar);
        }
    }

    public c amB() {
        return hP(this.cEV.size() - 1);
    }

    public <T extends c> T q(Class<T> cls) {
        for (int size = this.cEV.size() - 1; size >= 0; size--) {
            T t = (T) this.cEV.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e amC() {
        for (int size = this.cEV.size() - 1; size >= 0; size--) {
            c cVar = this.cEV.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c hP(int i) {
        if (this.cEV.isEmpty() || i < 0 || i >= this.cEV.size()) {
            return null;
        }
        return this.cEV.get(i);
    }

    public e amD() {
        if (this.cEV.isEmpty()) {
            return null;
        }
        int size = this.cEV.size();
        for (int i = 0; i < size; i++) {
            if (this.cEV.get(i).alq()) {
                return (e) this.cEV.get(i);
            }
        }
        return null;
    }

    public int amE() {
        return this.cEV.size();
    }

    public b amF() {
        return new b("");
    }

    public b mM(String str) {
        return new b(str);
    }

    /* loaded from: classes10.dex */
    public class b {
        private m cFc;
        private String cFd;

        public b(String str) {
            this.cFc = f.this.cEU.bam();
            this.cFd = str;
        }

        public b al(int i, int i2) {
            this.cFc.aE(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a2;
            if ("about".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.a.alr();
            } else if ("authority".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.b.alF();
            } else if ("pluginFunPage".equals(str)) {
                a2 = g.bx(bVar.mBaseUrl, bVar.mParams);
            } else if (mN(str)) {
                a2 = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a2 = h.amO();
            } else {
                a2 = "normal".equals(str) ? e.a(new c.a().qb(bVar.mPage).qc(bVar.mParams).qd(bVar.mBaseUrl).fA(z).azz()) : null;
            }
            if (a2 == null) {
                return null;
            }
            return f(a2);
        }

        private boolean mN(String str) {
            return f.cEY.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cFc.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cEV.add(cVar);
            for (a aVar : f.this.cEX) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c amB = f.this.amB();
            f.this.cEW.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (amB != null && amB.getUserVisibleHint()) {
                        amB.setUserVisibleHint(false);
                    }
                    if (amB instanceof e) {
                        ((e) amB).amy();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void amH() {
            final c amB = f.this.amB();
            f.this.cEW.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (amB != null) {
                        amB.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b hQ(int i) {
            int size = f.this.cEV.size();
            if (!f.this.cEV.isEmpty() && i >= 0 && i < size) {
                this.cFc.c((c) f.this.cEV.remove(i));
            }
            return this;
        }

        public b amI() {
            return hR(1);
        }

        public b hR(int i) {
            if (!f.this.cEV.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cEV.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cEX) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cFc.c((Fragment) arrayList.get(i4));
                    f.this.cEV.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cEW.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                amH();
            }
            return this;
        }

        public b amJ() {
            if (!f.this.cEV.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cEV.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).alq()) {
                        this.cFc.c((Fragment) arrayList.get(size));
                        f.this.cEV.remove(size);
                    }
                }
                amH();
            }
            return this;
        }

        public b amK() {
            List<Fragment> fragments = f.this.cEU.getFragments();
            if (fragments != null && fragments.size() != f.this.cEV.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cEV.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cEX) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cFc.c(fragment);
                    }
                }
            }
            return hR(f.this.cEV.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e amD = f.this.amD();
            if (amD != null) {
                amD.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void amL() {
            if (!f.this.cEV.isEmpty()) {
                int size = f.this.cEV.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cFc.e((Fragment) f.this.cEV.get(i));
                    } else {
                        this.cFc.d((Fragment) f.this.cEV.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cFc.e(cVar).commitAllowingStateLoss();
            f.this.cEU.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cFc.d(cVar).commitAllowingStateLoss();
            f.this.cEU.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cFd)) {
                e.mG(this.cFd);
            }
            while (!f.this.cEW.isEmpty()) {
                if (f.this.cEW.peek() != null) {
                    ((Runnable) f.this.cEW.poll()).run();
                }
            }
            amL();
            this.cFc.commitAllowingStateLoss();
        }

        public boolean amM() {
            commit();
            return f.this.cEU.executePendingTransactions();
        }
    }
}
