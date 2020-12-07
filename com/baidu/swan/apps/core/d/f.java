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
/* loaded from: classes25.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cQa = new HashSet();
    public static final int cQb = a.C0379a.aiapps_slide_in_from_right;
    public static final int cQc = a.C0379a.aiapps_slide_out_to_right;
    public static final int cQd = a.C0379a.aiapps_hold;
    private k cPW;
    private Queue<Runnable> cPY = new LinkedList();
    private ArrayList<c> cPX = new ArrayList<>();
    private final List<a> cPZ = new CopyOnWriteArrayList();

    /* loaded from: classes25.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cQa.add("adLanding");
        cQa.add("wxPay");
        cQa.add("default_webview");
        cQa.add("allianceLogin");
        cQa.add("allianceChooseAddress");
        cQa.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cPW = fragmentActivity.bfh();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cPZ.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cPZ.remove(aVar);
        }
    }

    public c arB() {
        return it(this.cPX.size() - 1);
    }

    public <T extends c> T q(Class<T> cls) {
        for (int size = this.cPX.size() - 1; size >= 0; size--) {
            T t = (T) this.cPX.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e arC() {
        for (int size = this.cPX.size() - 1; size >= 0; size--) {
            c cVar = this.cPX.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c it(int i) {
        if (this.cPX.isEmpty() || i < 0 || i >= this.cPX.size()) {
            return null;
        }
        return this.cPX.get(i);
    }

    public e arD() {
        if (this.cPX.isEmpty()) {
            return null;
        }
        int size = this.cPX.size();
        for (int i = 0; i < size; i++) {
            if (this.cPX.get(i).aqq()) {
                return (e) this.cPX.get(i);
            }
        }
        return null;
    }

    public int arE() {
        return this.cPX.size();
    }

    public b arF() {
        return new b("");
    }

    public b nC(String str) {
        return new b(str);
    }

    /* loaded from: classes25.dex */
    public class b {
        private m cQe;
        private String cQf;

        public b(String str) {
            this.cQe = f.this.cPW.bfk();
            this.cQf = str;
        }

        public b an(int i, int i2) {
            this.cQe.aG(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a2;
            if ("about".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.a.aqr();
            } else if ("authority".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.b.aqF();
            } else if ("pluginFunPage".equals(str)) {
                a2 = g.bD(bVar.mBaseUrl, bVar.mParams);
            } else if (nD(str)) {
                a2 = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a2 = h.arO();
            } else {
                a2 = "normal".equals(str) ? e.a(new c.a().qQ(bVar.mPage).qR(bVar.mParams).qS(bVar.mBaseUrl).gb(z).aEA()) : null;
            }
            if (a2 == null) {
                return null;
            }
            return f(a2);
        }

        private boolean nD(String str) {
            return f.cQa.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cQe.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cPX.add(cVar);
            for (a aVar : f.this.cPZ) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c arB = f.this.arB();
            f.this.cPY.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (arB != null && arB.getUserVisibleHint()) {
                        arB.setUserVisibleHint(false);
                    }
                    if (arB instanceof e) {
                        ((e) arB).ary();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void arH() {
            final c arB = f.this.arB();
            f.this.cPY.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (arB != null) {
                        arB.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b iu(int i) {
            int size = f.this.cPX.size();
            if (!f.this.cPX.isEmpty() && i >= 0 && i < size) {
                this.cQe.c((c) f.this.cPX.remove(i));
            }
            return this;
        }

        public b arI() {
            return iv(1);
        }

        public b iv(int i) {
            if (!f.this.cPX.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cPX.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cPZ) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cQe.c((Fragment) arrayList.get(i4));
                    f.this.cPX.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cPY.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                arH();
            }
            return this;
        }

        public b arJ() {
            if (!f.this.cPX.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cPX.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).aqq()) {
                        this.cQe.c((Fragment) arrayList.get(size));
                        f.this.cPX.remove(size);
                    }
                }
                arH();
            }
            return this;
        }

        public b arK() {
            List<Fragment> fragments = f.this.cPW.getFragments();
            if (fragments != null && fragments.size() != f.this.cPX.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cPX.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cPZ) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cQe.c(fragment);
                    }
                }
            }
            return iv(f.this.cPX.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e arD = f.this.arD();
            if (arD != null) {
                arD.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void arL() {
            if (!f.this.cPX.isEmpty()) {
                int size = f.this.cPX.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cQe.e((Fragment) f.this.cPX.get(i));
                    } else {
                        this.cQe.d((Fragment) f.this.cPX.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cQe.e(cVar).commitAllowingStateLoss();
            f.this.cPW.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cQe.d(cVar).commitAllowingStateLoss();
            f.this.cPW.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cQf)) {
                e.nw(this.cQf);
            }
            while (!f.this.cPY.isEmpty()) {
                if (f.this.cPY.peek() != null) {
                    ((Runnable) f.this.cPY.poll()).run();
                }
            }
            arL();
            this.cQe.commitAllowingStateLoss();
        }

        public boolean arM() {
            commit();
            return f.this.cPW.executePendingTransactions();
        }
    }
}
