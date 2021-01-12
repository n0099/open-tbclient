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
    private static final Set<String> cQl = new HashSet();
    public static final int cQm = a.C0355a.aiapps_slide_in_from_right;
    public static final int cQn = a.C0355a.aiapps_slide_out_to_right;
    public static final int cQo = a.C0355a.aiapps_hold;
    private k cQh;
    private Queue<Runnable> cQj = new LinkedList();
    private ArrayList<c> cQi = new ArrayList<>();
    private final List<a> cQk = new CopyOnWriteArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cQl.add("adLanding");
        cQl.add("wxPay");
        cQl.add("default_webview");
        cQl.add("allianceLogin");
        cQl.add("allianceChooseAddress");
        cQl.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cQh = fragmentActivity.bdL();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cQk.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cQk.remove(aVar);
        }
    }

    public c aoY() {
        return gI(this.cQi.size() - 1);
    }

    public <T extends c> T j(Class<T> cls) {
        for (int size = this.cQi.size() - 1; size >= 0; size--) {
            T t = (T) this.cQi.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e aoZ() {
        for (int size = this.cQi.size() - 1; size >= 0; size--) {
            c cVar = this.cQi.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c gI(int i) {
        if (this.cQi.isEmpty() || i < 0 || i >= this.cQi.size()) {
            return null;
        }
        return this.cQi.get(i);
    }

    public e apa() {
        if (this.cQi.isEmpty()) {
            return null;
        }
        int size = this.cQi.size();
        for (int i = 0; i < size; i++) {
            if (this.cQi.get(i).anI()) {
                return (e) this.cQi.get(i);
            }
        }
        return null;
    }

    public int apb() {
        return this.cQi.size();
    }

    public b apc() {
        return new b("");
    }

    public b mk(String str) {
        return new b(str);
    }

    /* loaded from: classes8.dex */
    public class b {
        private m cQp;
        private String cQq;

        public b(String str) {
            this.cQp = f.this.cQh.bdO();
            this.cQq = str;
        }

        public b ai(int i, int i2) {
            this.cQp.aD(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a2;
            if ("about".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.a.anJ();
            } else if ("authority".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.b.anX();
            } else if ("pluginFunPage".equals(str)) {
                a2 = g.bB(bVar.mBaseUrl, bVar.mParams);
            } else if (ml(str)) {
                a2 = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a2 = h.apm();
            } else {
                a2 = "normal".equals(str) ? e.a(new c.a().pz(bVar.mPage).pA(bVar.mParams).pB(bVar.mBaseUrl).gg(z).aCa()) : null;
            }
            if (a2 == null) {
                return null;
            }
            return f(a2);
        }

        private boolean ml(String str) {
            return f.cQl.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cQp.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cQi.add(cVar);
            for (a aVar : f.this.cQk) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c aoY = f.this.aoY();
            f.this.cQj.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aoY != null && aoY.getUserVisibleHint()) {
                        aoY.setUserVisibleHint(false);
                    }
                    if (aoY instanceof e) {
                        ((e) aoY).aoV();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void ape() {
            final c aoY = f.this.aoY();
            f.this.cQj.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (aoY != null) {
                        aoY.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b gJ(int i) {
            int size = f.this.cQi.size();
            if (!f.this.cQi.isEmpty() && i >= 0 && i < size) {
                this.cQp.c((c) f.this.cQi.remove(i));
            }
            return this;
        }

        public b apf() {
            return gK(1);
        }

        public b gK(int i) {
            if (!f.this.cQi.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cQi.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cQk) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cQp.c((Fragment) arrayList.get(i4));
                    f.this.cQi.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cQj.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                ape();
            }
            return this;
        }

        public b apg() {
            if (!f.this.cQi.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cQi.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).anI()) {
                        this.cQp.c((Fragment) arrayList.get(size));
                        f.this.cQi.remove(size);
                    }
                }
                ape();
            }
            return this;
        }

        public b aph() {
            List<Fragment> fragments = f.this.cQh.getFragments();
            if (fragments != null && fragments.size() != f.this.cQi.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cQi.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cQk) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cQp.c(fragment);
                    }
                }
            }
            return gK(f.this.cQi.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e apa = f.this.apa();
            if (apa != null) {
                apa.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void apj() {
            if (!f.this.cQi.isEmpty()) {
                int size = f.this.cQi.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cQp.e((Fragment) f.this.cQi.get(i));
                    } else {
                        this.cQp.d((Fragment) f.this.cQi.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cQp.e(cVar).commitAllowingStateLoss();
            f.this.cQh.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cQp.d(cVar).commitAllowingStateLoss();
            f.this.cQh.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cQq)) {
                e.me(this.cQq);
            }
            while (!f.this.cQj.isEmpty()) {
                if (f.this.cQj.peek() != null) {
                    ((Runnable) f.this.cQj.poll()).run();
                }
            }
            apj();
            this.cQp.commitAllowingStateLoss();
        }

        public boolean apk() {
            commit();
            return f.this.cQh.executePendingTransactions();
        }
    }
}
