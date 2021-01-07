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
/* loaded from: classes9.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cUX = new HashSet();
    public static final int cUY = a.C0372a.aiapps_slide_in_from_right;
    public static final int cUZ = a.C0372a.aiapps_slide_out_to_right;
    public static final int cVa = a.C0372a.aiapps_hold;
    private k cUT;
    private Queue<Runnable> cUV = new LinkedList();
    private ArrayList<c> cUU = new ArrayList<>();
    private final List<a> cUW = new CopyOnWriteArrayList();

    /* loaded from: classes9.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cUX.add("adLanding");
        cUX.add("wxPay");
        cUX.add("default_webview");
        cUX.add("allianceLogin");
        cUX.add("allianceChooseAddress");
        cUX.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cUT = fragmentActivity.bhF();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cUW.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cUW.remove(aVar);
        }
    }

    public c asU() {
        return io(this.cUU.size() - 1);
    }

    public <T extends c> T j(Class<T> cls) {
        for (int size = this.cUU.size() - 1; size >= 0; size--) {
            T t = (T) this.cUU.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e asV() {
        for (int size = this.cUU.size() - 1; size >= 0; size--) {
            c cVar = this.cUU.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c io(int i) {
        if (this.cUU.isEmpty() || i < 0 || i >= this.cUU.size()) {
            return null;
        }
        return this.cUU.get(i);
    }

    public e asW() {
        if (this.cUU.isEmpty()) {
            return null;
        }
        int size = this.cUU.size();
        for (int i = 0; i < size; i++) {
            if (this.cUU.get(i).arD()) {
                return (e) this.cUU.get(i);
            }
        }
        return null;
    }

    public int asX() {
        return this.cUU.size();
    }

    public b asY() {
        return new b("");
    }

    public b nv(String str) {
        return new b(str);
    }

    /* loaded from: classes9.dex */
    public class b {
        private m cVb;
        private String cVc;

        public b(String str) {
            this.cVb = f.this.cUT.bhI();
            this.cVc = str;
        }

        public b ai(int i, int i2) {
            this.cVb.aD(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a2;
            if ("about".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.a.arE();
            } else if ("authority".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.b.arS();
            } else if ("pluginFunPage".equals(str)) {
                a2 = g.bC(bVar.mBaseUrl, bVar.mParams);
            } else if (nw(str)) {
                a2 = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a2 = h.ath();
            } else {
                a2 = "normal".equals(str) ? e.a(new c.a().qK(bVar.mPage).qL(bVar.mParams).qM(bVar.mBaseUrl).gk(z).aFU()) : null;
            }
            if (a2 == null) {
                return null;
            }
            return f(a2);
        }

        private boolean nw(String str) {
            return f.cUX.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cVb.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cUU.add(cVar);
            for (a aVar : f.this.cUW) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c asU = f.this.asU();
            f.this.cUV.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (asU != null && asU.getUserVisibleHint()) {
                        asU.setUserVisibleHint(false);
                    }
                    if (asU instanceof e) {
                        ((e) asU).asR();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void ata() {
            final c asU = f.this.asU();
            f.this.cUV.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (asU != null) {
                        asU.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b ip(int i) {
            int size = f.this.cUU.size();
            if (!f.this.cUU.isEmpty() && i >= 0 && i < size) {
                this.cVb.c((c) f.this.cUU.remove(i));
            }
            return this;
        }

        public b atb() {
            return iq(1);
        }

        public b iq(int i) {
            if (!f.this.cUU.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cUU.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cUW) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cVb.c((Fragment) arrayList.get(i4));
                    f.this.cUU.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cUV.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                ata();
            }
            return this;
        }

        public b atc() {
            if (!f.this.cUU.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cUU.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).arD()) {
                        this.cVb.c((Fragment) arrayList.get(size));
                        f.this.cUU.remove(size);
                    }
                }
                ata();
            }
            return this;
        }

        public b atd() {
            List<Fragment> fragments = f.this.cUT.getFragments();
            if (fragments != null && fragments.size() != f.this.cUU.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cUU.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cUW) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cVb.c(fragment);
                    }
                }
            }
            return iq(f.this.cUU.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e asW = f.this.asW();
            if (asW != null) {
                asW.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void ate() {
            if (!f.this.cUU.isEmpty()) {
                int size = f.this.cUU.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cVb.e((Fragment) f.this.cUU.get(i));
                    } else {
                        this.cVb.d((Fragment) f.this.cUU.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cVb.e(cVar).commitAllowingStateLoss();
            f.this.cUT.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cVb.d(cVar).commitAllowingStateLoss();
            f.this.cUT.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cVc)) {
                e.np(this.cVc);
            }
            while (!f.this.cUV.isEmpty()) {
                if (f.this.cUV.peek() != null) {
                    ((Runnable) f.this.cUV.poll()).run();
                }
            }
            ate();
            this.cVb.commitAllowingStateLoss();
        }

        public boolean atf() {
            commit();
            return f.this.cUT.executePendingTransactions();
        }
    }
}
