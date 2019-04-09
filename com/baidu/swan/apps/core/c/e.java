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
    public static final int aqO = a.C0107a.aiapps_slide_in_from_right;
    public static final int aqP = a.C0107a.aiapps_slide_out_to_right;
    public static final int aqQ = a.C0107a.aiapps_hold;
    private k aqK;
    private a aqN;
    private Activity mActivity;
    Queue<Runnable> aqM = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.c.b> aqL = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface a {
        void yT();
    }

    public e(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        this.aqK = fragmentActivity.Sy();
    }

    public void a(a aVar) {
        this.aqN = aVar;
    }

    public com.baidu.swan.apps.core.c.b yN() {
        return cf(this.aqL.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.c.b> T l(Class<T> cls) {
        for (int size = this.aqL.size() - 1; size >= 0; size--) {
            T t = (T) this.aqL.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d yO() {
        for (int size = this.aqL.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.c.b bVar = this.aqL.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.c.b cf(int i) {
        if (this.aqL.isEmpty() || i < 0 || i >= this.aqL.size()) {
            return null;
        }
        return this.aqL.get(i);
    }

    public d yP() {
        if (this.aqL.isEmpty()) {
            return null;
        }
        int size = this.aqL.size();
        for (int i = 0; i < size; i++) {
            if (this.aqL.get(i).xX()) {
                return (d) this.aqL.get(i);
            }
        }
        return null;
    }

    public int yQ() {
        return this.aqL.size();
    }

    public b yR() {
        return new b("");
    }

    public b ea(String str) {
        return new b(str);
    }

    /* loaded from: classes2.dex */
    public class b {
        private m aqR;
        private String aqS;

        public b(String str) {
            this.aqR = e.this.aqK.SB();
            this.aqS = str;
        }

        public b A(int i, int i2) {
            this.aqR.O(i, i2);
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
                a = "normal".equals(str) ? d.a(new c.a().fg(bVar.axM).fh(bVar.mParams).fi(bVar.mBaseUrl).bp(z).EJ()) : null;
            }
            if (a == null) {
                return null;
            }
            return b(a);
        }

        public b b(com.baidu.swan.apps.core.c.b bVar) {
            c(bVar);
            this.aqR.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.aqL.add(bVar);
            if (e.this.aqN != null) {
                e.this.aqN.yT();
            }
            return this;
        }

        private void c(final com.baidu.swan.apps.core.c.b bVar) {
            final com.baidu.swan.apps.core.c.b yN = e.this.yN();
            e.this.aqM.offer(new Runnable() { // from class: com.baidu.swan.apps.core.c.e.b.1
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
            e.this.aqM.offer(new Runnable() { // from class: com.baidu.swan.apps.core.c.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (yN != null) {
                        yN.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b cg(int i) {
            int size = e.this.aqL.size();
            if (!e.this.aqL.isEmpty() && i >= 0 && i < size) {
                this.aqR.a((com.baidu.swan.apps.core.c.b) e.this.aqL.remove(i));
            }
            return this;
        }

        public b yV() {
            return ch(1);
        }

        public b ch(int i) {
            if (!e.this.aqL.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aqL.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.c.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.c.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.aqR.a((Fragment) arrayList.get(i4));
                    e.this.aqL.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.aqM.offer(new Runnable() { // from class: com.baidu.swan.apps.core.c.e.b.3
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
            if (!e.this.aqL.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aqL.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).xX()) {
                        this.aqR.a((Fragment) arrayList.get(size));
                        e.this.aqL.remove(size);
                    }
                }
                yU();
            }
            return this;
        }

        public b yX() {
            List<Fragment> fragments = e.this.aqK.getFragments();
            if (fragments != null && fragments.size() != e.this.aqL.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.aqL.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.aqR.a(fragment);
                    }
                }
            }
            return ch(e.this.aqL.size());
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
            if (!e.this.aqL.isEmpty()) {
                int size = e.this.aqL.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.aqR.c((Fragment) e.this.aqL.get(i));
                    } else {
                        this.aqR.b((Fragment) e.this.aqL.get(i));
                    }
                }
            }
        }

        public void d(com.baidu.swan.apps.core.c.b bVar) {
            this.aqR.c(bVar).commitAllowingStateLoss();
            e.this.aqK.executePendingTransactions();
        }

        public void e(com.baidu.swan.apps.core.c.b bVar) {
            this.aqR.b(bVar).commitAllowingStateLoss();
            e.this.aqK.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.aqS)) {
                d.dV(this.aqS);
            }
            while (!e.this.aqM.isEmpty() && e.this.aqM.size() > 0) {
                if (e.this.aqM.peek() != null) {
                    e.this.aqM.poll().run();
                }
            }
            yY();
            this.aqR.commitAllowingStateLoss();
        }

        public boolean yZ() {
            commit();
            return e.this.aqK.executePendingTransactions();
        }
    }
}
