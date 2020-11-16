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
/* loaded from: classes7.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cJh = new HashSet();
    public static final int cJi = a.C0367a.aiapps_slide_in_from_right;
    public static final int cJj = a.C0367a.aiapps_slide_out_to_right;
    public static final int cJk = a.C0367a.aiapps_hold;
    private k cJd;
    private Queue<Runnable> cJf = new LinkedList();
    private ArrayList<c> cJe = new ArrayList<>();
    private final List<a> cJg = new CopyOnWriteArrayList();

    /* loaded from: classes7.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cJh.add("adLanding");
        cJh.add("wxPay");
        cJh.add("default_webview");
        cJh.add("allianceLogin");
        cJh.add("allianceChooseAddress");
        cJh.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cJd = fragmentActivity.bcc();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cJg.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cJg.remove(aVar);
        }
    }

    public c aot() {
        return hV(this.cJe.size() - 1);
    }

    public <T extends c> T q(Class<T> cls) {
        for (int size = this.cJe.size() - 1; size >= 0; size--) {
            T t = (T) this.cJe.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e aou() {
        for (int size = this.cJe.size() - 1; size >= 0; size--) {
            c cVar = this.cJe.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c hV(int i) {
        if (this.cJe.isEmpty() || i < 0 || i >= this.cJe.size()) {
            return null;
        }
        return this.cJe.get(i);
    }

    public e aov() {
        if (this.cJe.isEmpty()) {
            return null;
        }
        int size = this.cJe.size();
        for (int i = 0; i < size; i++) {
            if (this.cJe.get(i).ani()) {
                return (e) this.cJe.get(i);
            }
        }
        return null;
    }

    public int aow() {
        return this.cJe.size();
    }

    public b aox() {
        return new b("");
    }

    public b mV(String str) {
        return new b(str);
    }

    /* loaded from: classes7.dex */
    public class b {
        private m cJl;
        private String cJm;

        public b(String str) {
            this.cJl = f.this.cJd.bcf();
            this.cJm = str;
        }

        public b al(int i, int i2) {
            this.cJl.aE(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a2;
            if ("about".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.a.anj();
            } else if ("authority".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.b.anx();
            } else if ("pluginFunPage".equals(str)) {
                a2 = g.bw(bVar.mBaseUrl, bVar.mParams);
            } else if (mW(str)) {
                a2 = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a2 = h.aoG();
            } else {
                a2 = "normal".equals(str) ? e.a(new c.a().qj(bVar.mPage).qk(bVar.mParams).ql(bVar.mBaseUrl).fM(z).aBr()) : null;
            }
            if (a2 == null) {
                return null;
            }
            return f(a2);
        }

        private boolean mW(String str) {
            return f.cJh.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cJl.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cJe.add(cVar);
            for (a aVar : f.this.cJg) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c aot = f.this.aot();
            f.this.cJf.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aot != null && aot.getUserVisibleHint()) {
                        aot.setUserVisibleHint(false);
                    }
                    if (aot instanceof e) {
                        ((e) aot).aoq();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void aoz() {
            final c aot = f.this.aot();
            f.this.cJf.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (aot != null) {
                        aot.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b hW(int i) {
            int size = f.this.cJe.size();
            if (!f.this.cJe.isEmpty() && i >= 0 && i < size) {
                this.cJl.c((c) f.this.cJe.remove(i));
            }
            return this;
        }

        public b aoA() {
            return hX(1);
        }

        public b hX(int i) {
            if (!f.this.cJe.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cJe.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cJg) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cJl.c((Fragment) arrayList.get(i4));
                    f.this.cJe.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cJf.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                aoz();
            }
            return this;
        }

        public b aoB() {
            if (!f.this.cJe.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cJe.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).ani()) {
                        this.cJl.c((Fragment) arrayList.get(size));
                        f.this.cJe.remove(size);
                    }
                }
                aoz();
            }
            return this;
        }

        public b aoC() {
            List<Fragment> fragments = f.this.cJd.getFragments();
            if (fragments != null && fragments.size() != f.this.cJe.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cJe.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cJg) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cJl.c(fragment);
                    }
                }
            }
            return hX(f.this.cJe.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e aov = f.this.aov();
            if (aov != null) {
                aov.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void aoD() {
            if (!f.this.cJe.isEmpty()) {
                int size = f.this.cJe.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cJl.e((Fragment) f.this.cJe.get(i));
                    } else {
                        this.cJl.d((Fragment) f.this.cJe.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cJl.e(cVar).commitAllowingStateLoss();
            f.this.cJd.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cJl.d(cVar).commitAllowingStateLoss();
            f.this.cJd.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cJm)) {
                e.mP(this.cJm);
            }
            while (!f.this.cJf.isEmpty()) {
                if (f.this.cJf.peek() != null) {
                    ((Runnable) f.this.cJf.poll()).run();
                }
            }
            aoD();
            this.cJl.commitAllowingStateLoss();
        }

        public boolean aoE() {
            commit();
            return f.this.cJd.executePendingTransactions();
        }
    }
}
