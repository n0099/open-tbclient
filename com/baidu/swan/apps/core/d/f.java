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
    private static final Set<String> cKR = new HashSet();
    public static final int cKS = a.C0369a.aiapps_slide_in_from_right;
    public static final int cKT = a.C0369a.aiapps_slide_out_to_right;
    public static final int cKU = a.C0369a.aiapps_hold;
    private k cKN;
    private Queue<Runnable> cKP = new LinkedList();
    private ArrayList<c> cKO = new ArrayList<>();
    private final List<a> cKQ = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cKR.add("adLanding");
        cKR.add("wxPay");
        cKR.add("default_webview");
        cKR.add("allianceLogin");
        cKR.add("allianceChooseAddress");
        cKR.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cKN = fragmentActivity.bcJ();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cKQ.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cKQ.remove(aVar);
        }
    }

    public c apb() {
        return hZ(this.cKO.size() - 1);
    }

    public <T extends c> T q(Class<T> cls) {
        for (int size = this.cKO.size() - 1; size >= 0; size--) {
            T t = (T) this.cKO.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e apc() {
        for (int size = this.cKO.size() - 1; size >= 0; size--) {
            c cVar = this.cKO.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c hZ(int i) {
        if (this.cKO.isEmpty() || i < 0 || i >= this.cKO.size()) {
            return null;
        }
        return this.cKO.get(i);
    }

    public e apd() {
        if (this.cKO.isEmpty()) {
            return null;
        }
        int size = this.cKO.size();
        for (int i = 0; i < size; i++) {
            if (this.cKO.get(i).anQ()) {
                return (e) this.cKO.get(i);
            }
        }
        return null;
    }

    public int ape() {
        return this.cKO.size();
    }

    public b apf() {
        return new b("");
    }

    public b nb(String str) {
        return new b(str);
    }

    /* loaded from: classes10.dex */
    public class b {
        private m cKV;
        private String cKW;

        public b(String str) {
            this.cKV = f.this.cKN.bcM();
            this.cKW = str;
        }

        public b al(int i, int i2) {
            this.cKV.aE(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a2;
            if ("about".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.a.anR();
            } else if ("authority".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.b.aof();
            } else if ("pluginFunPage".equals(str)) {
                a2 = g.bx(bVar.mBaseUrl, bVar.mParams);
            } else if (nc(str)) {
                a2 = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a2 = h.app();
            } else {
                a2 = "normal".equals(str) ? e.a(new c.a().qp(bVar.mPage).qq(bVar.mParams).qr(bVar.mBaseUrl).fJ(z).aBZ()) : null;
            }
            if (a2 == null) {
                return null;
            }
            return f(a2);
        }

        private boolean nc(String str) {
            return f.cKR.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cKV.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cKO.add(cVar);
            for (a aVar : f.this.cKQ) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c apb = f.this.apb();
            f.this.cKP.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (apb != null && apb.getUserVisibleHint()) {
                        apb.setUserVisibleHint(false);
                    }
                    if (apb instanceof e) {
                        ((e) apb).aoY();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void aph() {
            final c apb = f.this.apb();
            f.this.cKP.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (apb != null) {
                        apb.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b ia(int i) {
            int size = f.this.cKO.size();
            if (!f.this.cKO.isEmpty() && i >= 0 && i < size) {
                this.cKV.c((c) f.this.cKO.remove(i));
            }
            return this;
        }

        public b apj() {
            return ib(1);
        }

        public b ib(int i) {
            if (!f.this.cKO.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cKO.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cKQ) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cKV.c((Fragment) arrayList.get(i4));
                    f.this.cKO.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cKP.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                aph();
            }
            return this;
        }

        public b apk() {
            if (!f.this.cKO.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cKO.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).anQ()) {
                        this.cKV.c((Fragment) arrayList.get(size));
                        f.this.cKO.remove(size);
                    }
                }
                aph();
            }
            return this;
        }

        public b apl() {
            List<Fragment> fragments = f.this.cKN.getFragments();
            if (fragments != null && fragments.size() != f.this.cKO.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cKO.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cKQ) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cKV.c(fragment);
                    }
                }
            }
            return ib(f.this.cKO.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e apd = f.this.apd();
            if (apd != null) {
                apd.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void apm() {
            if (!f.this.cKO.isEmpty()) {
                int size = f.this.cKO.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cKV.e((Fragment) f.this.cKO.get(i));
                    } else {
                        this.cKV.d((Fragment) f.this.cKO.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cKV.e(cVar).commitAllowingStateLoss();
            f.this.cKN.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cKV.d(cVar).commitAllowingStateLoss();
            f.this.cKN.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cKW)) {
                e.mV(this.cKW);
            }
            while (!f.this.cKP.isEmpty()) {
                if (f.this.cKP.peek() != null) {
                    ((Runnable) f.this.cKP.poll()).run();
                }
            }
            apm();
            this.cKV.commitAllowingStateLoss();
        }

        public boolean apn() {
            commit();
            return f.this.cKN.executePendingTransactions();
        }
    }
}
