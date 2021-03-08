package com.baidu.swan.apps.core.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes8.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cTY = new HashSet();
    public static final int cTZ = a.C0358a.aiapps_slide_in_from_right;
    public static final int cUa = a.C0358a.aiapps_slide_out_to_right;
    public static final int cUb = a.C0358a.aiapps_hold;
    private k cTU;
    private Queue<Runnable> cTW = new LinkedList();
    private ArrayList<c> cTV = new ArrayList<>();
    private final List<a> cTX = new CopyOnWriteArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cTY.add("adLanding");
        cTY.add("wxPay");
        cTY.add("default_webview");
        cTY.add("allianceLogin");
        cTY.add("allianceChooseAddress");
        cTY.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cTU = fragmentActivity.bea();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cTX.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cTX.remove(aVar);
        }
    }

    public c apA() {
        return gM(this.cTV.size() - 1);
    }

    public <T extends c> T j(Class<T> cls) {
        for (int size = this.cTV.size() - 1; size >= 0; size--) {
            T t = (T) this.cTV.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e apB() {
        for (int size = this.cTV.size() - 1; size >= 0; size--) {
            c cVar = this.cTV.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c gM(int i) {
        if (this.cTV.isEmpty() || i < 0 || i >= this.cTV.size()) {
            return null;
        }
        return this.cTV.get(i);
    }

    public e apC() {
        if (this.cTV.isEmpty()) {
            return null;
        }
        int size = this.cTV.size();
        for (int i = 0; i < size; i++) {
            if (this.cTV.get(i).aoj()) {
                return (e) this.cTV.get(i);
            }
        }
        return null;
    }

    public int apD() {
        return this.cTV.size();
    }

    public b apE() {
        return new b("");
    }

    public b mJ(String str) {
        return new b(str);
    }

    /* loaded from: classes8.dex */
    public class b {
        private m cUc;
        private String cUd;

        public b(String str) {
            this.cUc = f.this.cTU.bed();
            this.cUd = str;
        }

        public b af(int i, int i2) {
            this.cUc.aA(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a2;
            if ("about".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.a.aok();
            } else if ("authority".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.b.aoy();
            } else if ("pluginFunPage".equals(str)) {
                a2 = g.bv(bVar.mBaseUrl, bVar.mParams);
            } else if (mK(str)) {
                a2 = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a2 = h.apN();
            } else {
                a2 = "normal".equals(str) ? e.a(new c.a().pY(bVar.mPage).pZ(bVar.mParams).qa(bVar.mBaseUrl).gi(z).aCA()) : null;
            }
            if (a2 == null) {
                return null;
            }
            return f(a2);
        }

        private boolean mK(String str) {
            return f.cTY.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cUc.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cTV.add(cVar);
            for (a aVar : f.this.cTX) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c apA = f.this.apA();
            f.this.cTW.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (apA != null && apA.getUserVisibleHint()) {
                        apA.setUserVisibleHint(false);
                    }
                    if (apA instanceof e) {
                        ((e) apA).apx();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void apG() {
            final c apA = f.this.apA();
            f.this.cTW.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (apA != null) {
                        apA.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b gN(int i) {
            int size = f.this.cTV.size();
            if (!f.this.cTV.isEmpty() && i >= 0 && i < size) {
                this.cUc.c((c) f.this.cTV.remove(i));
            }
            return this;
        }

        public b apH() {
            return gO(1);
        }

        public b gO(int i) {
            if (!f.this.cTV.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cTV.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cTX) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cUc.c((Fragment) arrayList.get(i4));
                    f.this.cTV.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cTW.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                apG();
            }
            return this;
        }

        public b apI() {
            if (!f.this.cTV.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cTV.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).aoj()) {
                        this.cUc.c((Fragment) arrayList.get(size));
                        f.this.cTV.remove(size);
                    }
                }
                apG();
            }
            return this;
        }

        public b apJ() {
            List<Fragment> fragments = f.this.cTU.getFragments();
            if (fragments != null && fragments.size() != f.this.cTV.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cTV.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cTX) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cUc.c(fragment);
                    }
                }
            }
            return gO(f.this.cTV.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e apC = f.this.apC();
            if (apC != null) {
                apC.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void apK() {
            if (!f.this.cTV.isEmpty()) {
                int size = f.this.cTV.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cUc.e((Fragment) f.this.cTV.get(i));
                    } else {
                        this.cUc.d((Fragment) f.this.cTV.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cUc.e(cVar).commitAllowingStateLoss();
            f.this.cTU.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cUc.d(cVar).commitAllowingStateLoss();
            f.this.cTU.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cUd)) {
                e.mD(this.cUd);
            }
            while (!f.this.cTW.isEmpty()) {
                if (f.this.cTW.peek() != null) {
                    ((Runnable) f.this.cTW.poll()).run();
                }
            }
            apK();
            this.cUc.commitAllowingStateLoss();
        }

        public boolean apL() {
            commit();
            return f.this.cTU.executePendingTransactions();
        }
    }
}
