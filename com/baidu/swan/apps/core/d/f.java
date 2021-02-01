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
    private k cSu;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cSy = new HashSet();
    public static final int cSz = a.C0352a.aiapps_slide_in_from_right;
    public static final int cSA = a.C0352a.aiapps_slide_out_to_right;
    public static final int cSB = a.C0352a.aiapps_hold;
    private Queue<Runnable> cSw = new LinkedList();
    private ArrayList<c> cSv = new ArrayList<>();
    private final List<a> cSx = new CopyOnWriteArrayList();

    /* loaded from: classes9.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    static {
        cSy.add("adLanding");
        cSy.add("wxPay");
        cSy.add("default_webview");
        cSy.add("allianceLogin");
        cSy.add("allianceChooseAddress");
        cSy.add("qrCodePay");
    }

    public f(FragmentActivity fragmentActivity) {
        this.cSu = fragmentActivity.bdY();
    }

    public void a(@Nullable a aVar) {
        if (aVar != null) {
            this.cSx.add(aVar);
        }
    }

    public void b(@Nullable a aVar) {
        if (aVar != null) {
            this.cSx.remove(aVar);
        }
    }

    public c apx() {
        return gL(this.cSv.size() - 1);
    }

    public <T extends c> T j(Class<T> cls) {
        for (int size = this.cSv.size() - 1; size >= 0; size--) {
            T t = (T) this.cSv.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public e apy() {
        for (int size = this.cSv.size() - 1; size >= 0; size--) {
            c cVar = this.cSv.get(size);
            if (cVar instanceof e) {
                return (e) cVar;
            }
        }
        return null;
    }

    public c gL(int i) {
        if (this.cSv.isEmpty() || i < 0 || i >= this.cSv.size()) {
            return null;
        }
        return this.cSv.get(i);
    }

    public e apz() {
        if (this.cSv.isEmpty()) {
            return null;
        }
        int size = this.cSv.size();
        for (int i = 0; i < size; i++) {
            if (this.cSv.get(i).aog()) {
                return (e) this.cSv.get(i);
            }
        }
        return null;
    }

    public int apA() {
        return this.cSv.size();
    }

    public b apB() {
        return new b("");
    }

    public b mC(String str) {
        return new b(str);
    }

    /* loaded from: classes9.dex */
    public class b {
        private m cSC;
        private String cSD;

        public b(String str) {
            this.cSC = f.this.cSu.beb();
            this.cSD = str;
        }

        public b af(int i, int i2) {
            this.cSC.aA(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            c a2;
            if ("about".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.a.aoh();
            } else if ("authority".equals(str)) {
                a2 = com.baidu.swan.apps.core.d.b.aov();
            } else if ("pluginFunPage".equals(str)) {
                a2 = g.bv(bVar.mBaseUrl, bVar.mParams);
            } else if (mD(str)) {
                a2 = i.c(bVar, str);
            } else if (TextUtils.equals("settings", str)) {
                a2 = h.apK();
            } else {
                a2 = "normal".equals(str) ? e.a(new c.a().pR(bVar.mPage).pS(bVar.mParams).pT(bVar.mBaseUrl).gi(z).aCx()) : null;
            }
            if (a2 == null) {
                return null;
            }
            return f(a2);
        }

        private boolean mD(String str) {
            return f.cSy.contains(str);
        }

        public b f(c cVar) {
            g(cVar);
            this.cSC.a(a.f.ai_apps_container, cVar, "SwanAppFragment");
            f.this.cSv.add(cVar);
            for (a aVar : f.this.cSx) {
                if (aVar != null) {
                    aVar.a(cVar);
                }
            }
            return this;
        }

        private void g(final c cVar) {
            final c apx = f.this.apx();
            f.this.cSw.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (apx != null && apx.getUserVisibleHint()) {
                        apx.setUserVisibleHint(false);
                    }
                    if (apx instanceof e) {
                        ((e) apx).apu();
                    }
                    cVar.setUserVisibleHint(true);
                }
            });
        }

        private void apD() {
            final c apx = f.this.apx();
            f.this.cSw.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (apx != null) {
                        apx.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b gM(int i) {
            int size = f.this.cSv.size();
            if (!f.this.cSv.isEmpty() && i >= 0 && i < size) {
                this.cSC.c((c) f.this.cSv.remove(i));
            }
            return this;
        }

        public b apE() {
            return gN(1);
        }

        public b gN(int i) {
            if (!f.this.cSv.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cSv.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final c cVar = (i2 < 0 || i <= 0) ? null : (c) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    for (a aVar : f.this.cSx) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(i4));
                        }
                    }
                    this.cSC.c((Fragment) arrayList.get(i4));
                    f.this.cSv.remove(i4);
                    i3 = i4 - 1;
                }
                f.this.cSw.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.f.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (cVar != null) {
                            cVar.setUserVisibleHint(false);
                        }
                    }
                });
                apD();
            }
            return this;
        }

        public b apF() {
            if (!f.this.cSv.isEmpty()) {
                ArrayList arrayList = (ArrayList) f.this.cSv.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((c) arrayList.get(size)).aog()) {
                        this.cSC.c((Fragment) arrayList.get(size));
                        f.this.cSv.remove(size);
                    }
                }
                apD();
            }
            return this;
        }

        public b apG() {
            List<Fragment> fragments = f.this.cSu.getFragments();
            if (fragments != null && fragments.size() != f.this.cSv.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !f.this.cSv.contains(fragment)) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        for (a aVar : f.this.cSx) {
                            if (aVar != null) {
                                aVar.b(fragment);
                            }
                        }
                        this.cSC.c(fragment);
                    }
                }
            }
            return gN(f.this.cSv.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            e apz = f.this.apz();
            if (apz != null) {
                apz.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void apH() {
            if (!f.this.cSv.isEmpty()) {
                int size = f.this.cSv.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (f.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.cSC.e((Fragment) f.this.cSv.get(i));
                    } else {
                        this.cSC.d((Fragment) f.this.cSv.get(i));
                    }
                }
            }
        }

        public void h(c cVar) {
            this.cSC.e(cVar).commitAllowingStateLoss();
            f.this.cSu.executePendingTransactions();
        }

        public void i(c cVar) {
            this.cSC.d(cVar).commitAllowingStateLoss();
            f.this.cSu.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.cSD)) {
                e.mw(this.cSD);
            }
            while (!f.this.cSw.isEmpty()) {
                if (f.this.cSw.peek() != null) {
                    ((Runnable) f.this.cSw.poll()).run();
                }
            }
            apH();
            this.cSC.commitAllowingStateLoss();
        }

        public boolean apI() {
            commit();
            return f.this.cSu.executePendingTransactions();
        }
    }
}
