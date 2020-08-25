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
/* loaded from: classes8.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cif = new HashSet();
    public static final int cig = a.C0331a.aiapps_slide_in_from_right;
    public static final int cih = a.C0331a.aiapps_slide_out_to_right;
    public static final int cii = a.C0331a.aiapps_hold;
    private k cia;
    private Queue<Runnable> cic = new LinkedList();
    private ArrayList<c> cib = new ArrayList<>();
    private final List<a> cie = new CopyOnWriteArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cif.add("adLanding");
        cif.add("wxPay");
        cif.add("default_webview");
        cif.add("allianceLogin");
        cif.add("allianceChooseAddress");
        cif.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cia = fragmentActivity.aUV();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cie.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cie.remove(aVar);
        }
    }

    public c ahm() {
        return gY(this.cib.size() - 1);
    }

    public <T extends c> T q(Class<T> cls) {
        for (int size = this.cib.size() - 1; size >= 0; size--) {
            T t = (T) this.cib.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e ahn() {
        for (int size = this.cib.size() - 1; size >= 0; size--) {
            c cVar = this.cib.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c gY(int i) {
        if (this.cib.isEmpty() || i < 0 || i >= this.cib.size()) {
            return null;
        }
        return this.cib.get(i);
    }

    public e aho() {
        if (this.cib.isEmpty()) {
            return null;
        }
        int size = this.cib.size();
        for (int i = 0; i < size; i++) {
            if (this.cib.get(i).agb()) {
                return (e) this.cib.get(i);
            }
        }
        return null;
    }

    public int ahp() {
        return this.cib.size();
    }

    public b ahq() {
        return new b("");
    }

    public b ln(String str) {
        return new b(str);
    }

    /* loaded from: classes8.dex */
    public class b {
        private m cij;
        private String cik;

        public b(String str) {
            this.cij = f.this.cia.aUY();
            this.cik = str;
        }

        public b al(int i, int i2) {
            this.cij.aE(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.agc();
            } else if ("authority".equals(str)) {
                a = com.baidu.swan.apps.core.d.b.agq();
            } else if ("pluginFunPage".equals(str)) {
                a = g.bl(bVar.mBaseUrl, bVar.mParams);
            } else if (lo(str)) {
                a = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a = h.ahz();
            } else {
                a = "normal".equals(str) ? e.a(new c.a().oC(bVar.mPage).oD(bVar.mParams).oE(bVar.mBaseUrl).eS(z).aul()) : null;
            }
            if (a == null) {
                return null;
            }
            return f(a);
        }

        private boolean lo(String str) {
            return f.cif.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cij.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cib.add(cVar);
            for (a aVar : f.this.cie) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c ahm = f.this.ahm();
            f.this.cic.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ahm != null && ahm.getUserVisibleHint()) {
                        ahm.setUserVisibleHint(false);
                    }
                    if (ahm instanceof e) {
                        ((e) ahm).ahj();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void ahs() {
            final c ahm = f.this.ahm();
            f.this.cic.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ahm != null) {
                        ahm.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b gZ(int i) {
            int size = f.this.cib.size();
            if (!f.this.cib.isEmpty() && i >= 0 && i < size) {
                this.cij.c((c) f.this.cib.remove(i));
            }
            return this;
        }

        public b aht() {
            return ha(1);
        }

        public b ha(int i) {
            if (!f.this.cib.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cib.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cie) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cij.c((Fragment) arrayList.get(i4));
                    f.this.cib.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cic.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                ahs();
            }
            return this;
        }

        public b ahu() {
            if (!f.this.cib.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cib.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).agb()) {
                        this.cij.c((Fragment) arrayList.get(size));
                        f.this.cib.remove(size);
                    }
                }
                ahs();
            }
            return this;
        }

        public b ahv() {
            List<Fragment> fragments = f.this.cia.getFragments();
            if (fragments != null && fragments.size() != f.this.cib.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cib.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cie) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cij.c(fragment);
                    }
                }
            }
            return ha(f.this.cib.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e aho = f.this.aho();
            if (aho != null) {
                aho.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void ahw() {
            if (!f.this.cib.isEmpty()) {
                int size = f.this.cib.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cij.e((Fragment) f.this.cib.get(i));
                    } else {
                        this.cij.d((Fragment) f.this.cib.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cij.e(cVar).commitAllowingStateLoss();
            f.this.cia.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cij.d(cVar).commitAllowingStateLoss();
            f.this.cia.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cik)) {
                e.lh(this.cik);
            }
            while (!f.this.cic.isEmpty()) {
                if (f.this.cic.peek() != null) {
                    ((Runnable) f.this.cic.poll()).run();
                }
            }
            ahw();
            this.cij.commitAllowingStateLoss();
        }

        public boolean ahx() {
            commit();
            return f.this.cia.executePendingTransactions();
        }
    }
}
