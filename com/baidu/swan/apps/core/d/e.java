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
    public static final int arU = a.C0119a.aiapps_slide_in_from_right;
    public static final int arV = a.C0119a.aiapps_slide_out_to_right;
    public static final int arW = a.C0119a.aiapps_hold;
    private k arQ;
    private a arT;
    private Activity mActivity;
    private Queue<Runnable> arS = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> arR = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface a {
        void AB();
    }

    public e(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        this.arQ = fragmentActivity.Xi();
    }

    public void a(a aVar) {
        this.arT = aVar;
    }

    public com.baidu.swan.apps.core.d.b Av() {
        return cg(this.arR.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T k(Class<T> cls) {
        for (int size = this.arR.size() - 1; size >= 0; size--) {
            T t = (T) this.arR.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d Aw() {
        for (int size = this.arR.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.arR.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b cg(int i) {
        if (this.arR.isEmpty() || i < 0 || i >= this.arR.size()) {
            return null;
        }
        return this.arR.get(i);
    }

    public d Ax() {
        if (this.arR.isEmpty()) {
            return null;
        }
        int size = this.arR.size();
        for (int i = 0; i < size; i++) {
            if (this.arR.get(i).zA()) {
                return (d) this.arR.get(i);
            }
        }
        return null;
    }

    public int Ay() {
        return this.arR.size();
    }

    public b Az() {
        return new b("");
    }

    public b dU(String str) {
        return new b(str);
    }

    /* loaded from: classes2.dex */
    public class b {
        private m arX;
        private String arY;

        public b(String str) {
            this.arX = e.this.arQ.Xl();
            this.arY = str;
        }

        public b B(int i, int i2) {
            this.arX.P(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.zB();
            } else if ("setting".equals(str)) {
                a = f.AL();
            } else if ("wxPay".equals(str) || "adLanding".equals(str)) {
                a = g.a(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().fy(bVar.azQ).fz(bVar.mParams).fA(bVar.mBaseUrl).bA(z).Hv()) : null;
            }
            if (a == null) {
                return null;
            }
            return c(a);
        }

        public b c(com.baidu.swan.apps.core.d.b bVar) {
            d(bVar);
            this.arX.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.arR.add(bVar);
            if (e.this.arT != null) {
                e.this.arT.AB();
            }
            return this;
        }

        private void d(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b Av = e.this.Av();
            e.this.arS.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Av != null && Av.getUserVisibleHint()) {
                        Av.setUserVisibleHint(false);
                    }
                    if (Av instanceof d) {
                        ((d) Av).Au();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void AC() {
            final com.baidu.swan.apps.core.d.b Av = e.this.Av();
            e.this.arS.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Av != null) {
                        Av.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b ch(int i) {
            int size = e.this.arR.size();
            if (!e.this.arR.isEmpty() && i >= 0 && i < size) {
                this.arX.a((com.baidu.swan.apps.core.d.b) e.this.arR.remove(i));
            }
            return this;
        }

        public b AD() {
            return ci(1);
        }

        public b ci(int i) {
            if (!e.this.arR.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.arR.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.arX.a((Fragment) arrayList.get(i4));
                    e.this.arR.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.arS.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                AC();
            }
            return this;
        }

        public b AE() {
            if (!e.this.arR.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.arR.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).zA()) {
                        this.arX.a((Fragment) arrayList.get(size));
                        e.this.arR.remove(size);
                    }
                }
                AC();
            }
            return this;
        }

        public b AF() {
            List<Fragment> fragments = e.this.arQ.getFragments();
            if (fragments != null && fragments.size() != e.this.arR.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.arR.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.arX.a(fragment);
                    }
                }
            }
            return ci(e.this.arR.size());
        }

        public b d(com.baidu.swan.apps.model.b bVar) {
            d Ax = e.this.Ax();
            if (Ax != null) {
                Ax.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void AG() {
            if (!e.this.arR.isEmpty()) {
                int size = e.this.arR.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.arX.c((Fragment) e.this.arR.get(i));
                    } else {
                        this.arX.b((Fragment) e.this.arR.get(i));
                    }
                }
            }
        }

        public void e(com.baidu.swan.apps.core.d.b bVar) {
            this.arX.c(bVar).commitAllowingStateLoss();
            e.this.arQ.executePendingTransactions();
        }

        public void f(com.baidu.swan.apps.core.d.b bVar) {
            this.arX.b(bVar).commitAllowingStateLoss();
            e.this.arQ.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.arY)) {
                d.dO(this.arY);
            }
            while (!e.this.arS.isEmpty()) {
                if (e.this.arS.peek() != null) {
                    ((Runnable) e.this.arS.poll()).run();
                }
            }
            AG();
            this.arX.commitAllowingStateLoss();
        }

        public boolean AH() {
            commit();
            return e.this.arQ.executePendingTransactions();
        }
    }
}
