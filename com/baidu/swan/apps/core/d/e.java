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
    public static final int aqT = a.C0108a.aiapps_slide_in_from_right;
    public static final int aqU = a.C0108a.aiapps_slide_out_to_right;
    public static final int aqV = a.C0108a.aiapps_hold;
    private k aqP;
    private a aqS;
    private Activity mActivity;
    private Queue<Runnable> aqR = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> aqQ = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface a {
        void zQ();
    }

    public e(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        this.aqP = fragmentActivity.Wk();
    }

    public void a(a aVar) {
        this.aqS = aVar;
    }

    public com.baidu.swan.apps.core.d.b zK() {
        return cf(this.aqQ.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T k(Class<T> cls) {
        for (int size = this.aqQ.size() - 1; size >= 0; size--) {
            T t = (T) this.aqQ.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d zL() {
        for (int size = this.aqQ.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.aqQ.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b cf(int i) {
        if (this.aqQ.isEmpty() || i < 0 || i >= this.aqQ.size()) {
            return null;
        }
        return this.aqQ.get(i);
    }

    public d zM() {
        if (this.aqQ.isEmpty()) {
            return null;
        }
        int size = this.aqQ.size();
        for (int i = 0; i < size; i++) {
            if (this.aqQ.get(i).yP()) {
                return (d) this.aqQ.get(i);
            }
        }
        return null;
    }

    public int zN() {
        return this.aqQ.size();
    }

    public b zO() {
        return new b("");
    }

    public b dN(String str) {
        return new b(str);
    }

    /* loaded from: classes2.dex */
    public class b {
        private m aqW;
        private String aqX;

        public b(String str) {
            this.aqW = e.this.aqP.Wn();
            this.aqX = str;
        }

        public b y(int i, int i2) {
            this.aqW.M(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.yQ();
            } else if ("setting".equals(str)) {
                a = f.Aa();
            } else if ("wxPay".equals(str) || "adLanding".equals(str)) {
                a = g.a(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().fr(bVar.ayL).fs(bVar.mParams).ft(bVar.mBaseUrl).bx(z).GH()) : null;
            }
            if (a == null) {
                return null;
            }
            return c(a);
        }

        public b c(com.baidu.swan.apps.core.d.b bVar) {
            d(bVar);
            this.aqW.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.aqQ.add(bVar);
            if (e.this.aqS != null) {
                e.this.aqS.zQ();
            }
            return this;
        }

        private void d(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b zK = e.this.zK();
            e.this.aqR.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zK != null && zK.getUserVisibleHint()) {
                        zK.setUserVisibleHint(false);
                    }
                    if (zK instanceof d) {
                        ((d) zK).zJ();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void zR() {
            final com.baidu.swan.apps.core.d.b zK = e.this.zK();
            e.this.aqR.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (zK != null) {
                        zK.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b cg(int i) {
            int size = e.this.aqQ.size();
            if (!e.this.aqQ.isEmpty() && i >= 0 && i < size) {
                this.aqW.a((com.baidu.swan.apps.core.d.b) e.this.aqQ.remove(i));
            }
            return this;
        }

        public b zS() {
            return ch(1);
        }

        public b ch(int i) {
            if (!e.this.aqQ.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aqQ.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.aqW.a((Fragment) arrayList.get(i4));
                    e.this.aqQ.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.aqR.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                zR();
            }
            return this;
        }

        public b zT() {
            if (!e.this.aqQ.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aqQ.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).yP()) {
                        this.aqW.a((Fragment) arrayList.get(size));
                        e.this.aqQ.remove(size);
                    }
                }
                zR();
            }
            return this;
        }

        public b zU() {
            List<Fragment> fragments = e.this.aqP.getFragments();
            if (fragments != null && fragments.size() != e.this.aqQ.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.aqQ.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.aqW.a(fragment);
                    }
                }
            }
            return ch(e.this.aqQ.size());
        }

        public b d(com.baidu.swan.apps.model.b bVar) {
            d zM = e.this.zM();
            if (zM != null) {
                zM.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void zV() {
            if (!e.this.aqQ.isEmpty()) {
                int size = e.this.aqQ.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.aqW.c((Fragment) e.this.aqQ.get(i));
                    } else {
                        this.aqW.b((Fragment) e.this.aqQ.get(i));
                    }
                }
            }
        }

        public void e(com.baidu.swan.apps.core.d.b bVar) {
            this.aqW.c(bVar).commitAllowingStateLoss();
            e.this.aqP.executePendingTransactions();
        }

        public void f(com.baidu.swan.apps.core.d.b bVar) {
            this.aqW.b(bVar).commitAllowingStateLoss();
            e.this.aqP.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.aqX)) {
                d.dH(this.aqX);
            }
            while (!e.this.aqR.isEmpty()) {
                if (e.this.aqR.peek() != null) {
                    ((Runnable) e.this.aqR.poll()).run();
                }
            }
            zV();
            this.aqW.commitAllowingStateLoss();
        }

        public boolean zW() {
            commit();
            return e.this.aqP.executePendingTransactions();
        }
    }
}
