package com.baidu.swan.apps.core.c;

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
    public static final int aqN = a.C0107a.aiapps_slide_in_from_right;
    public static final int aqO = a.C0107a.aiapps_slide_out_to_right;
    public static final int aqP = a.C0107a.aiapps_hold;
    private k aqJ;
    private a aqM;
    private Activity mActivity;
    Queue<Runnable> aqL = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.c.b> aqK = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface a {
        void yT();
    }

    public e(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        this.aqJ = fragmentActivity.Sy();
    }

    public void a(a aVar) {
        this.aqM = aVar;
    }

    public com.baidu.swan.apps.core.c.b yN() {
        return cf(this.aqK.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.c.b> T l(Class<T> cls) {
        for (int size = this.aqK.size() - 1; size >= 0; size--) {
            T t = (T) this.aqK.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d yO() {
        for (int size = this.aqK.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.c.b bVar = this.aqK.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.c.b cf(int i) {
        if (this.aqK.isEmpty() || i < 0 || i >= this.aqK.size()) {
            return null;
        }
        return this.aqK.get(i);
    }

    public d yP() {
        if (this.aqK.isEmpty()) {
            return null;
        }
        int size = this.aqK.size();
        for (int i = 0; i < size; i++) {
            if (this.aqK.get(i).xX()) {
                return (d) this.aqK.get(i);
            }
        }
        return null;
    }

    public int yQ() {
        return this.aqK.size();
    }

    public b yR() {
        return new b("");
    }

    public b ea(String str) {
        return new b(str);
    }

    /* loaded from: classes2.dex */
    public class b {
        private m aqQ;
        private String aqR;

        public b(String str) {
            this.aqQ = e.this.aqJ.SB();
            this.aqR = str;
        }

        public b A(int i, int i2) {
            this.aqQ.O(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.c.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.c.a.xY();
            } else if ("setting".equals(str)) {
                a = f.zd();
            } else if ("wxPay".equals(str) || "adLanding".equals(str)) {
                a = g.a(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().fg(bVar.axL).fh(bVar.mParams).fi(bVar.mBaseUrl).bp(z).EJ()) : null;
            }
            if (a == null) {
                return null;
            }
            return b(a);
        }

        public b b(com.baidu.swan.apps.core.c.b bVar) {
            c(bVar);
            this.aqQ.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.aqK.add(bVar);
            if (e.this.aqM != null) {
                e.this.aqM.yT();
            }
            return this;
        }

        private void c(final com.baidu.swan.apps.core.c.b bVar) {
            final com.baidu.swan.apps.core.c.b yN = e.this.yN();
            e.this.aqL.offer(new Runnable() { // from class: com.baidu.swan.apps.core.c.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (yN != null && yN.getUserVisibleHint()) {
                        yN.setUserVisibleHint(false);
                    }
                    if (yN instanceof d) {
                        ((d) yN).yM();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void yU() {
            final com.baidu.swan.apps.core.c.b yN = e.this.yN();
            e.this.aqL.offer(new Runnable() { // from class: com.baidu.swan.apps.core.c.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (yN != null) {
                        yN.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b cg(int i) {
            int size = e.this.aqK.size();
            if (!e.this.aqK.isEmpty() && i >= 0 && i < size) {
                this.aqQ.a((com.baidu.swan.apps.core.c.b) e.this.aqK.remove(i));
            }
            return this;
        }

        public b yV() {
            return ch(1);
        }

        public b ch(int i) {
            if (!e.this.aqK.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aqK.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.c.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.c.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.aqQ.a((Fragment) arrayList.get(i4));
                    e.this.aqK.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.aqL.offer(new Runnable() { // from class: com.baidu.swan.apps.core.c.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                yU();
            }
            return this;
        }

        public b yW() {
            if (!e.this.aqK.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aqK.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).xX()) {
                        this.aqQ.a((Fragment) arrayList.get(size));
                        e.this.aqK.remove(size);
                    }
                }
                yU();
            }
            return this;
        }

        public b yX() {
            List<Fragment> fragments = e.this.aqJ.getFragments();
            if (fragments != null && fragments.size() != e.this.aqK.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.aqK.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.aqQ.a(fragment);
                    }
                }
            }
            return ch(e.this.aqK.size());
        }

        public b d(com.baidu.swan.apps.model.b bVar) {
            d yP = e.this.yP();
            if (yP != null) {
                yP.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void yY() {
            if (!e.this.aqK.isEmpty()) {
                int size = e.this.aqK.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.aqQ.c((Fragment) e.this.aqK.get(i));
                    } else {
                        this.aqQ.b((Fragment) e.this.aqK.get(i));
                    }
                }
            }
        }

        public void d(com.baidu.swan.apps.core.c.b bVar) {
            this.aqQ.c(bVar).commitAllowingStateLoss();
            e.this.aqJ.executePendingTransactions();
        }

        public void e(com.baidu.swan.apps.core.c.b bVar) {
            this.aqQ.b(bVar).commitAllowingStateLoss();
            e.this.aqJ.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.aqR)) {
                d.dV(this.aqR);
            }
            while (!e.this.aqL.isEmpty() && e.this.aqL.size() > 0) {
                if (e.this.aqL.peek() != null) {
                    e.this.aqL.poll().run();
                }
            }
            yY();
            this.aqQ.commitAllowingStateLoss();
        }

        public boolean yZ() {
            commit();
            return e.this.aqJ.executePendingTransactions();
        }
    }
}
