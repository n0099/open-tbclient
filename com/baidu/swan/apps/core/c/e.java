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
    public static final int aqJ = a.C0107a.aiapps_slide_in_from_right;
    public static final int aqK = a.C0107a.aiapps_slide_out_to_right;
    public static final int aqL = a.C0107a.aiapps_hold;
    private k aqF;
    private a aqI;
    private Activity mActivity;
    Queue<Runnable> aqH = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.c.b> aqG = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface a {
        void yU();
    }

    public e(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        this.aqF = fragmentActivity.SA();
    }

    public void a(a aVar) {
        this.aqI = aVar;
    }

    public com.baidu.swan.apps.core.c.b yO() {
        return cg(this.aqG.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.c.b> T l(Class<T> cls) {
        for (int size = this.aqG.size() - 1; size >= 0; size--) {
            T t = (T) this.aqG.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d yP() {
        for (int size = this.aqG.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.c.b bVar = this.aqG.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.c.b cg(int i) {
        if (this.aqG.isEmpty() || i < 0 || i >= this.aqG.size()) {
            return null;
        }
        return this.aqG.get(i);
    }

    public d yQ() {
        if (this.aqG.isEmpty()) {
            return null;
        }
        int size = this.aqG.size();
        for (int i = 0; i < size; i++) {
            if (this.aqG.get(i).xY()) {
                return (d) this.aqG.get(i);
            }
        }
        return null;
    }

    public int yR() {
        return this.aqG.size();
    }

    public b yS() {
        return new b("");
    }

    public b dY(String str) {
        return new b(str);
    }

    /* loaded from: classes2.dex */
    public class b {
        private m aqM;
        private String aqN;

        public b(String str) {
            this.aqM = e.this.aqF.SD();
            this.aqN = str;
        }

        public b A(int i, int i2) {
            this.aqM.O(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.c.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.c.a.xZ();
            } else if ("setting".equals(str)) {
                a = f.ze();
            } else if ("wxPay".equals(str) || "adLanding".equals(str)) {
                a = g.a(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().ff(bVar.axI).fg(bVar.mParams).fh(bVar.mBaseUrl).bp(z).EL()) : null;
            }
            if (a == null) {
                return null;
            }
            return b(a);
        }

        public b b(com.baidu.swan.apps.core.c.b bVar) {
            c(bVar);
            this.aqM.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.aqG.add(bVar);
            if (e.this.aqI != null) {
                e.this.aqI.yU();
            }
            return this;
        }

        private void c(final com.baidu.swan.apps.core.c.b bVar) {
            final com.baidu.swan.apps.core.c.b yO = e.this.yO();
            e.this.aqH.offer(new Runnable() { // from class: com.baidu.swan.apps.core.c.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (yO != null && yO.getUserVisibleHint()) {
                        yO.setUserVisibleHint(false);
                    }
                    if (yO instanceof d) {
                        ((d) yO).yN();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void yV() {
            final com.baidu.swan.apps.core.c.b yO = e.this.yO();
            e.this.aqH.offer(new Runnable() { // from class: com.baidu.swan.apps.core.c.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (yO != null) {
                        yO.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b ch(int i) {
            int size = e.this.aqG.size();
            if (!e.this.aqG.isEmpty() && i >= 0 && i < size) {
                this.aqM.a((com.baidu.swan.apps.core.c.b) e.this.aqG.remove(i));
            }
            return this;
        }

        public b yW() {
            return ci(1);
        }

        public b ci(int i) {
            if (!e.this.aqG.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aqG.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.c.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.c.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.aqM.a((Fragment) arrayList.get(i4));
                    e.this.aqG.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.aqH.offer(new Runnable() { // from class: com.baidu.swan.apps.core.c.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                yV();
            }
            return this;
        }

        public b yX() {
            if (!e.this.aqG.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.aqG.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((d) arrayList.get(size)).xY()) {
                        this.aqM.a((Fragment) arrayList.get(size));
                        e.this.aqG.remove(size);
                    }
                }
                yV();
            }
            return this;
        }

        public b yY() {
            List<Fragment> fragments = e.this.aqF.getFragments();
            if (fragments != null && fragments.size() != e.this.aqG.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.aqG.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.aqM.a(fragment);
                    }
                }
            }
            return ci(e.this.aqG.size());
        }

        public b d(com.baidu.swan.apps.model.b bVar) {
            d yQ = e.this.yQ();
            if (yQ != null) {
                yQ.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void yZ() {
            if (!e.this.aqG.isEmpty()) {
                int size = e.this.aqG.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.aqM.c((Fragment) e.this.aqG.get(i));
                    } else {
                        this.aqM.b((Fragment) e.this.aqG.get(i));
                    }
                }
            }
        }

        public void d(com.baidu.swan.apps.core.c.b bVar) {
            this.aqM.c(bVar).commitAllowingStateLoss();
            e.this.aqF.executePendingTransactions();
        }

        public void e(com.baidu.swan.apps.core.c.b bVar) {
            this.aqM.b(bVar).commitAllowingStateLoss();
            e.this.aqF.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.aqN)) {
                d.dT(this.aqN);
            }
            while (!e.this.aqH.isEmpty() && e.this.aqH.size() > 0) {
                if (e.this.aqH.peek() != null) {
                    e.this.aqH.poll().run();
                }
            }
            yZ();
            this.aqM.commitAllowingStateLoss();
        }

        public boolean za() {
            commit();
            return e.this.aqF.executePendingTransactions();
        }
    }
}
