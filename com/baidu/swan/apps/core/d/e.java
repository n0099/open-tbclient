package com.baidu.swan.apps.core.d;

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
/* loaded from: classes10.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bjT = new HashSet();
    public static final int bjU = a.C0187a.aiapps_slide_in_from_right;
    public static final int bjV = a.C0187a.aiapps_slide_out_to_right;
    public static final int bjW = a.C0187a.aiapps_hold;
    private k bjP;
    private a bjS;
    private Queue<Runnable> bjR = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> bjQ = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface a {
        void Md();
    }

    static {
        bjT.add("adLanding");
        bjT.add("wxPay");
        bjT.add("default_webview");
        bjT.add("allianceLogin");
        bjT.add("allianceChooseAddress");
    }

    public e(FragmentActivity fragmentActivity) {
        this.bjP = fragmentActivity.asm();
    }

    public void a(a aVar) {
        this.bjS = aVar;
    }

    public com.baidu.swan.apps.core.d.b LX() {
        return eg(this.bjQ.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T p(Class<T> cls) {
        for (int size = this.bjQ.size() - 1; size >= 0; size--) {
            T t = (T) this.bjQ.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d LY() {
        for (int size = this.bjQ.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.bjQ.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b eg(int i) {
        if (this.bjQ.isEmpty() || i < 0 || i >= this.bjQ.size()) {
            return null;
        }
        return this.bjQ.get(i);
    }

    public d LZ() {
        if (this.bjQ.isEmpty()) {
            return null;
        }
        int size = this.bjQ.size();
        for (int i = 0; i < size; i++) {
            if (this.bjQ.get(i).Lf()) {
                return (d) this.bjQ.get(i);
            }
        }
        return null;
    }

    public int Ma() {
        return this.bjQ.size();
    }

    public b Mb() {
        return new b("");
    }

    public b gM(String str) {
        return new b(str);
    }

    /* loaded from: classes10.dex */
    public class b {
        private m bjX;
        private String bjY;

        public b(String str) {
            this.bjX = e.this.bjP.asp();
            this.bjY = str;
        }

        public b Y(int i, int i2) {
            this.bjX.as(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.Lg();
            } else if ("setting".equals(str)) {
                a = g.Mm();
            } else if ("pluginFunPage".equals(str)) {
                a = f.aq(bVar.mBaseUrl, bVar.mParams);
            } else if (gN(str)) {
                a = h.c(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().ji(bVar.mPage).jj(bVar.mParams).jk(bVar.mBaseUrl).cT(z).Wf()) : null;
            }
            if (a == null) {
                return null;
            }
            return e(a);
        }

        private boolean gN(String str) {
            return e.bjT.contains(str);
        }

        public b e(com.baidu.swan.apps.core.d.b bVar) {
            f(bVar);
            this.bjX.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.bjQ.add(bVar);
            if (e.this.bjS != null) {
                e.this.bjS.Md();
            }
            return this;
        }

        private void f(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b LX = e.this.LX();
            e.this.bjR.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LX != null && LX.getUserVisibleHint()) {
                        LX.setUserVisibleHint(false);
                    }
                    if (LX instanceof d) {
                        ((d) LX).LW();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void Me() {
            final com.baidu.swan.apps.core.d.b LX = e.this.LX();
            e.this.bjR.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LX != null) {
                        LX.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b eh(int i) {
            int size = e.this.bjQ.size();
            if (!e.this.bjQ.isEmpty() && i >= 0 && i < size) {
                this.bjX.a((com.baidu.swan.apps.core.d.b) e.this.bjQ.remove(i));
            }
            return this;
        }

        public b Mf() {
            return ei(1);
        }

        public b ei(int i) {
            if (!e.this.bjQ.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.bjQ.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.bjX.a((Fragment) arrayList.get(i4));
                    e.this.bjQ.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.bjR.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                Me();
            }
            return this;
        }

        public b Mg() {
            if (!e.this.bjQ.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.bjQ.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((com.baidu.swan.apps.core.d.b) arrayList.get(size)).Lf()) {
                        this.bjX.a((Fragment) arrayList.get(size));
                        e.this.bjQ.remove(size);
                    }
                }
                Me();
            }
            return this;
        }

        public b Mh() {
            List<Fragment> fragments = e.this.bjP.getFragments();
            if (fragments != null && fragments.size() != e.this.bjQ.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.bjQ.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.bjX.a(fragment);
                    }
                }
            }
            return ei(e.this.bjQ.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            d LZ = e.this.LZ();
            if (LZ != null) {
                LZ.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void Mi() {
            if (!e.this.bjQ.isEmpty()) {
                int size = e.this.bjQ.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.bjX.c((Fragment) e.this.bjQ.get(i));
                    } else {
                        this.bjX.b((Fragment) e.this.bjQ.get(i));
                    }
                }
            }
        }

        public void g(com.baidu.swan.apps.core.d.b bVar) {
            this.bjX.c(bVar).commitAllowingStateLoss();
            e.this.bjP.executePendingTransactions();
        }

        public void h(com.baidu.swan.apps.core.d.b bVar) {
            this.bjX.b(bVar).commitAllowingStateLoss();
            e.this.bjP.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.bjY)) {
                d.gG(this.bjY);
            }
            while (!e.this.bjR.isEmpty()) {
                if (e.this.bjR.peek() != null) {
                    ((Runnable) e.this.bjR.poll()).run();
                }
            }
            Mi();
            this.bjX.commitAllowingStateLoss();
        }

        public boolean Mj() {
            commit();
            return e.this.bjP.executePendingTransactions();
        }
    }
}
