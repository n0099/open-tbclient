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
/* loaded from: classes3.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> ckk = new HashSet();
    public static final int ckl = a.C0326a.aiapps_slide_in_from_right;
    public static final int ckm = a.C0326a.aiapps_slide_out_to_right;
    public static final int ckn = a.C0326a.aiapps_hold;
    private k ckg;
    private Queue<Runnable> cki = new LinkedList();
    private ArrayList<c> ckh = new ArrayList<>();
    private final List<a> ckj = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        ckk.add("adLanding");
        ckk.add("wxPay");
        ckk.add("default_webview");
        ckk.add("allianceLogin");
        ckk.add("allianceChooseAddress");
        ckk.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.ckg = fragmentActivity.aVH();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.ckj.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.ckj.remove(aVar);
        }
    }

    public c ahW() {
        return hh(this.ckh.size() - 1);
    }

    public <T extends c> T q(Class<T> cls) {
        for (int size = this.ckh.size() - 1; size >= 0; size--) {
            T t = (T) this.ckh.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e ahX() {
        for (int size = this.ckh.size() - 1; size >= 0; size--) {
            c cVar = this.ckh.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c hh(int i) {
        if (this.ckh.isEmpty() || i < 0 || i >= this.ckh.size()) {
            return null;
        }
        return this.ckh.get(i);
    }

    public e ahY() {
        if (this.ckh.isEmpty()) {
            return null;
        }
        int size = this.ckh.size();
        for (int i = 0; i < size; i++) {
            if (this.ckh.get(i).agL()) {
                return (e) this.ckh.get(i);
            }
        }
        return null;
    }

    public int ahZ() {
        return this.ckh.size();
    }

    public b aia() {
        return new b("");
    }

    public b lH(String str) {
        return new b(str);
    }

    /* loaded from: classes3.dex */
    public class b {
        private m cko;
        private String ckp;

        public b(String str) {
            this.cko = f.this.ckg.aVK();
            this.ckp = str;
        }

        public b al(int i, int i2) {
            this.cko.aE(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.agM();
            } else if ("authority".equals(str)) {
                a = com.baidu.swan.apps.core.d.b.aha();
            } else if ("pluginFunPage".equals(str)) {
                a = g.bl(bVar.mBaseUrl, bVar.mParams);
            } else if (lI(str)) {
                a = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a = h.aij();
            } else {
                a = "normal".equals(str) ? e.a(new c.a().oW(bVar.mPage).oX(bVar.mParams).oY(bVar.mBaseUrl).eR(z).auU()) : null;
            }
            if (a == null) {
                return null;
            }
            return f(a);
        }

        private boolean lI(String str) {
            return f.ckk.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cko.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.ckh.add(cVar);
            for (a aVar : f.this.ckj) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c ahW = f.this.ahW();
            f.this.cki.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ahW != null && ahW.getUserVisibleHint()) {
                        ahW.setUserVisibleHint(false);
                    }
                    if (ahW instanceof e) {
                        ((e) ahW).ahT();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void aic() {
            final c ahW = f.this.ahW();
            f.this.cki.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ahW != null) {
                        ahW.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b hi(int i) {
            int size = f.this.ckh.size();
            if (!f.this.ckh.isEmpty() && i >= 0 && i < size) {
                this.cko.c((c) f.this.ckh.remove(i));
            }
            return this;
        }

        public b aid() {
            return hj(1);
        }

        public b hj(int i) {
            if (!f.this.ckh.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.ckh.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.ckj) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cko.c((Fragment) arrayList.get(i4));
                    f.this.ckh.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cki.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                aic();
            }
            return this;
        }

        public b aie() {
            if (!f.this.ckh.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.ckh.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).agL()) {
                        this.cko.c((Fragment) arrayList.get(size));
                        f.this.ckh.remove(size);
                    }
                }
                aic();
            }
            return this;
        }

        public b aif() {
            List<Fragment> fragments = f.this.ckg.getFragments();
            if (fragments != null && fragments.size() != f.this.ckh.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.ckh.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.ckj) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cko.c(fragment);
                    }
                }
            }
            return hj(f.this.ckh.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e ahY = f.this.ahY();
            if (ahY != null) {
                ahY.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void aig() {
            if (!f.this.ckh.isEmpty()) {
                int size = f.this.ckh.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cko.e((Fragment) f.this.ckh.get(i));
                    } else {
                        this.cko.d((Fragment) f.this.ckh.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cko.e(cVar).commitAllowingStateLoss();
            f.this.ckg.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cko.d(cVar).commitAllowingStateLoss();
            f.this.ckg.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.ckp)) {
                e.lB(this.ckp);
            }
            while (!f.this.cki.isEmpty()) {
                if (f.this.cki.peek() != null) {
                    ((Runnable) f.this.cki.poll()).run();
                }
            }
            aig();
            this.cko.commitAllowingStateLoss();
        }

        public boolean aih() {
            commit();
            return f.this.ckg.executePendingTransactions();
        }
    }
}
