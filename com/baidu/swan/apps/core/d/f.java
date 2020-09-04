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
    private static final Set<String> cij = new HashSet();
    public static final int cik = a.C0331a.aiapps_slide_in_from_right;
    public static final int cil = a.C0331a.aiapps_slide_out_to_right;
    public static final int cim = a.C0331a.aiapps_hold;
    private k cif;
    private Queue<Runnable> cih = new LinkedList();
    private ArrayList<c> cig = new ArrayList<>();
    private final List<a> cii = new CopyOnWriteArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cij.add("adLanding");
        cij.add("wxPay");
        cij.add("default_webview");
        cij.add("allianceLogin");
        cij.add("allianceChooseAddress");
        cij.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cif = fragmentActivity.aUV();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cii.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cii.remove(aVar);
        }
    }

    public c ahm() {
        return gY(this.cig.size() - 1);
    }

    public <T extends c> T q(Class<T> cls) {
        for (int size = this.cig.size() - 1; size >= 0; size--) {
            T t = (T) this.cig.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e ahn() {
        for (int size = this.cig.size() - 1; size >= 0; size--) {
            c cVar = this.cig.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c gY(int i) {
        if (this.cig.isEmpty() || i < 0 || i >= this.cig.size()) {
            return null;
        }
        return this.cig.get(i);
    }

    public e aho() {
        if (this.cig.isEmpty()) {
            return null;
        }
        int size = this.cig.size();
        for (int i = 0; i < size; i++) {
            if (this.cig.get(i).agb()) {
                return (e) this.cig.get(i);
            }
        }
        return null;
    }

    public int ahp() {
        return this.cig.size();
    }

    public b ahq() {
        return new b("");
    }

    public b lo(String str) {
        return new b(str);
    }

    /* loaded from: classes8.dex */
    public class b {
        private m cin;
        private String cio;

        public b(String str) {
            this.cin = f.this.cif.aUY();
            this.cio = str;
        }

        public b al(int i, int i2) {
            this.cin.aE(i, i2);
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
            } else if (lp(str)) {
                a = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a = h.ahz();
            } else {
                a = "normal".equals(str) ? e.a(new c.a().oD(bVar.mPage).oE(bVar.mParams).oF(bVar.mBaseUrl).eT(z).aul()) : null;
            }
            if (a == null) {
                return null;
            }
            return f(a);
        }

        private boolean lp(String str) {
            return f.cij.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cin.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cig.add(cVar);
            for (a aVar : f.this.cii) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c ahm = f.this.ahm();
            f.this.cih.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
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
            f.this.cih.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ahm != null) {
                        ahm.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b gZ(int i) {
            int size = f.this.cig.size();
            if (!f.this.cig.isEmpty() && i >= 0 && i < size) {
                this.cin.c((c) f.this.cig.remove(i));
            }
            return this;
        }

        public b aht() {
            return ha(1);
        }

        public b ha(int i) {
            if (!f.this.cig.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cig.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cii) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cin.c((Fragment) arrayList.get(i4));
                    f.this.cig.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cih.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
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
            if (!f.this.cig.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cig.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).agb()) {
                        this.cin.c((Fragment) arrayList.get(size));
                        f.this.cig.remove(size);
                    }
                }
                ahs();
            }
            return this;
        }

        public b ahv() {
            List<Fragment> fragments = f.this.cif.getFragments();
            if (fragments != null && fragments.size() != f.this.cig.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cig.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cii) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cin.c(fragment);
                    }
                }
            }
            return ha(f.this.cig.size());
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
            if (!f.this.cig.isEmpty()) {
                int size = f.this.cig.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cin.e((Fragment) f.this.cig.get(i));
                    } else {
                        this.cin.d((Fragment) f.this.cig.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cin.e(cVar).commitAllowingStateLoss();
            f.this.cif.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cin.d(cVar).commitAllowingStateLoss();
            f.this.cif.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cio)) {
                e.li(this.cio);
            }
            while (!f.this.cih.isEmpty()) {
                if (f.this.cih.peek() != null) {
                    ((Runnable) f.this.cih.poll()).run();
                }
            }
            ahw();
            this.cin.commitAllowingStateLoss();
        }

        public boolean ahx() {
            commit();
            return f.this.cif.executePendingTransactions();
        }
    }
}
