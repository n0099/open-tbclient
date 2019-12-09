package com.baidu.swan.apps.core.d;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.model.c;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.support.v4.app.k;
import com.baidu.swan.support.v4.app.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final int aKT = a.C0146a.aiapps_slide_in_from_right;
    public static final int aKU = a.C0146a.aiapps_slide_out_to_right;
    public static final int aKV = a.C0146a.aiapps_hold;
    private k aKP;
    private a aKS;
    private Activity mActivity;
    private Queue<Runnable> aKR = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> aKQ = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface a {
        void Fx();
    }

    public e(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        this.aKP = fragmentActivity.abV();
    }

    public void a(a aVar) {
        this.aKS = aVar;
    }

    public com.baidu.swan.apps.core.d.b Fr() {
        return dc(this.aKQ.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T i(Class<T> cls) {
        for (int size = this.aKQ.size() - 1; size >= 0; size--) {
            T t = (T) this.aKQ.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d Fs() {
        for (int size = this.aKQ.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.aKQ.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b dc(int i) {
        if (this.aKQ.isEmpty() || i < 0 || i >= this.aKQ.size()) {
            return null;
        }
        return this.aKQ.get(i);
    }

    public d Ft() {
        if (this.aKQ.isEmpty()) {
            return null;
        }
        int size = this.aKQ.size();
        for (int i = 0; i < size; i++) {
            if (this.aKQ.get(i).Ew()) {
                return (d) this.aKQ.get(i);
            }
        }
        return null;
    }

    public int Fu() {
        return this.aKQ.size();
    }

    public b Fv() {
        return new b("");
    }

    public b eC(String str) {
        return new b(str);
    }

    /* loaded from: classes2.dex */
    public class b {
        private m aKW;
        private String aKX;

        public b(String str) {
            this.aKW = e.this.aKP.abY();
            this.aKX = str;
        }

        public b F(int i, int i2) {
            this.aKW.T(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.Ex();
            } else if ("setting".equals(str)) {
                a = f.FH();
            } else if ("wxPay".equals(str) || "adLanding".equals(str)) {
                a = g.a(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().gc(bVar.aSM).gd(bVar.mParams).ge(bVar.mBaseUrl).bS(z).Mq()) : null;
            }
            if (a == null) {
                return null;
            }
            return c(a);
        }

        public b c(com.baidu.swan.apps.core.d.b bVar) {
            d(bVar);
            this.aKW.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.aKQ.add(bVar);
            if (e.this.aKS != null) {
                e.this.aKS.Fx();
            }
            return this;
        }

        private void d(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b Fr = e.this.Fr();
            e.this.aKR.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Fr != null && Fr.getUserVisibleHint()) {
                        Fr.setUserVisibleHint(false);
                    }
                    if (Fr instanceof d) {
                        ((d) Fr).Fq();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void Fy() {
            final com.baidu.swan.apps.core.d.b Fr = e.this.Fr();
            e.this.aKR.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Fr != null) {
                        Fr.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b dd(int i) {
            int size = e.this.aKQ.size();
            if (!e.this.aKQ.isEmpty() && i >= 0 && i < size) {
                this.aKW.a((com.baidu.swan.apps.core.d.b) e.this.aKQ.remove(i));
            }
            return this;
        }

        public b Fz() {
            return de(1);
        }

        public b de(int i) {
            if (!e.this.aKQ.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aKQ.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.aKW.a((Fragment) arrayList.get(i4));
                    e.this.aKQ.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.aKR.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                Fy();
            }
            return this;
        }

        public b FA() {
            if (!e.this.aKQ.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aKQ.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).Ew()) {
                        this.aKW.a((Fragment) arrayList.get(size));
                        e.this.aKQ.remove(size);
                    }
                }
                Fy();
            }
            return this;
        }

        public b FB() {
            List<Fragment> fragments = e.this.aKP.getFragments();
            if (fragments != null && fragments.size() != e.this.aKQ.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.aKQ.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.aKW.a(fragment);
                    }
                }
            }
            return de(e.this.aKQ.size());
        }

        public b d(com.baidu.swan.apps.model.b bVar) {
            d Ft = e.this.Ft();
            if (Ft != null) {
                Ft.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void FC() {
            if (!e.this.aKQ.isEmpty()) {
                int size = e.this.aKQ.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.aKW.c((Fragment) e.this.aKQ.get(i));
                    } else {
                        this.aKW.b((Fragment) e.this.aKQ.get(i));
                    }
                }
            }
        }

        public void e(com.baidu.swan.apps.core.d.b bVar) {
            this.aKW.c(bVar).commitAllowingStateLoss();
            e.this.aKP.executePendingTransactions();
        }

        public void f(com.baidu.swan.apps.core.d.b bVar) {
            this.aKW.b(bVar).commitAllowingStateLoss();
            e.this.aKP.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.aKX)) {
                d.ew(this.aKX);
            }
            while (!e.this.aKR.isEmpty()) {
                if (e.this.aKR.peek() != null) {
                    ((Runnable) e.this.aKR.poll()).run();
                }
            }
            FC();
            this.aKW.commitAllowingStateLoss();
        }

        public boolean FD() {
            commit();
            return e.this.aKP.executePendingTransactions();
        }
    }
}
