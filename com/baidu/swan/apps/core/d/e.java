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
/* loaded from: classes11.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> bVM = new HashSet();
    public static final int bVN = a.C0281a.aiapps_slide_in_from_right;
    public static final int bVO = a.C0281a.aiapps_slide_out_to_right;
    public static final int bVP = a.C0281a.aiapps_hold;
    private k bVI;
    private a bVL;
    private Queue<Runnable> bVK = new LinkedList();
    private ArrayList<com.baidu.swan.apps.core.d.b> bVJ = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void YV();
    }

    static {
        bVM.add("adLanding");
        bVM.add("wxPay");
        bVM.add("default_webview");
        bVM.add("allianceLogin");
        bVM.add("allianceChooseAddress");
        bVM.add("qrCodePay");
    }

    public e(FragmentActivity fragmentActivity) {
        this.bVI = fragmentActivity.aHx();
    }

    public void a(a aVar) {
        this.bVL = aVar;
    }

    public com.baidu.swan.apps.core.d.b YP() {
        return eM(this.bVJ.size() - 1);
    }

    public <T extends com.baidu.swan.apps.core.d.b> T q(Class<T> cls) {
        for (int size = this.bVJ.size() - 1; size >= 0; size--) {
            T t = (T) this.bVJ.get(size);
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public d YQ() {
        for (int size = this.bVJ.size() - 1; size >= 0; size--) {
            com.baidu.swan.apps.core.d.b bVar = this.bVJ.get(size);
            if (bVar instanceof d) {
                return (d) bVar;
            }
        }
        return null;
    }

    public com.baidu.swan.apps.core.d.b eM(int i) {
        if (this.bVJ.isEmpty() || i < 0 || i >= this.bVJ.size()) {
            return null;
        }
        return this.bVJ.get(i);
    }

    public d YR() {
        if (this.bVJ.isEmpty()) {
            return null;
        }
        int size = this.bVJ.size();
        for (int i = 0; i < size; i++) {
            if (this.bVJ.get(i).XQ()) {
                return (d) this.bVJ.get(i);
            }
        }
        return null;
    }

    public int YS() {
        return this.bVJ.size();
    }

    public b YT() {
        return new b("");
    }

    public b jp(String str) {
        return new b(str);
    }

    /* loaded from: classes11.dex */
    public class b {
        private m bVQ;
        private String bVR;

        public b(String str) {
            this.bVQ = e.this.bVI.aHA();
            this.bVR = str;
        }

        public b ae(int i, int i2) {
            this.bVQ.av(i, i2);
            return this;
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar) {
            return a(str, bVar, false);
        }

        public b a(String str, com.baidu.swan.apps.model.b bVar, boolean z) {
            com.baidu.swan.apps.core.d.b a;
            if ("about".equals(str)) {
                a = com.baidu.swan.apps.core.d.a.XR();
            } else if ("setting".equals(str)) {
                a = g.Zf();
            } else if ("pluginFunPage".equals(str)) {
                a = f.aZ(bVar.mBaseUrl, bVar.mParams);
            } else if (jq(str)) {
                a = h.c(bVar, str);
            } else {
                a = "normal".equals(str) ? d.a(new c.a().lX(bVar.mPage).lY(bVar.mParams).lZ(bVar.mBaseUrl).eo(z).ajS()) : null;
            }
            if (a == null) {
                return null;
            }
            return f(a);
        }

        private boolean jq(String str) {
            return e.bVM.contains(str);
        }

        public b f(com.baidu.swan.apps.core.d.b bVar) {
            g(bVar);
            this.bVQ.a(a.f.ai_apps_container, bVar, "SwanAppFragment");
            e.this.bVJ.add(bVar);
            if (e.this.bVL != null) {
                e.this.bVL.YV();
            }
            return this;
        }

        private void g(final com.baidu.swan.apps.core.d.b bVar) {
            final com.baidu.swan.apps.core.d.b YP = e.this.YP();
            e.this.bVK.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (YP != null && YP.getUserVisibleHint()) {
                        YP.setUserVisibleHint(false);
                    }
                    if (YP instanceof d) {
                        ((d) YP).YO();
                    }
                    bVar.setUserVisibleHint(true);
                }
            });
        }

        private void YW() {
            final com.baidu.swan.apps.core.d.b YP = e.this.YP();
            e.this.bVK.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.2
                @Override // java.lang.Runnable
                public void run() {
                    if (YP != null) {
                        YP.setUserVisibleHint(true);
                    }
                }
            });
        }

        public b eN(int i) {
            int size = e.this.bVJ.size();
            if (!e.this.bVJ.isEmpty() && i >= 0 && i < size) {
                this.bVQ.a((com.baidu.swan.apps.core.d.b) e.this.bVJ.remove(i));
            }
            return this;
        }

        public b YX() {
            return eO(1);
        }

        public b eO(int i) {
            if (!e.this.bVJ.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.bVJ.clone();
                int size = arrayList.size();
                int i2 = size - i;
                final com.baidu.swan.apps.core.d.b bVar = (i2 < 0 || i <= 0) ? null : (com.baidu.swan.apps.core.d.b) arrayList.get(i2);
                int i3 = size - 1;
                while (true) {
                    int i4 = i3;
                    if (i4 <= (size - i) - 1 || i4 < 0) {
                        break;
                    }
                    this.bVQ.a((Fragment) arrayList.get(i4));
                    e.this.bVJ.remove(i4);
                    i3 = i4 - 1;
                }
                e.this.bVK.offer(new Runnable() { // from class: com.baidu.swan.apps.core.d.e.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bVar != null) {
                            bVar.setUserVisibleHint(false);
                        }
                    }
                });
                YW();
            }
            return this;
        }

        public b YY() {
            if (!e.this.bVJ.isEmpty()) {
                ArrayList arrayList = (ArrayList) e.this.bVJ.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((com.baidu.swan.apps.core.d.b) arrayList.get(size)).XQ()) {
                        this.bVQ.a((Fragment) arrayList.get(size));
                        e.this.bVJ.remove(size);
                    }
                }
                YW();
            }
            return this;
        }

        public b YZ() {
            List<Fragment> fragments = e.this.bVI.getFragments();
            if (fragments != null && fragments.size() != e.this.bVJ.size()) {
                for (Fragment fragment : fragments) {
                    if (fragment != null && !e.this.bVJ.contains(fragment)) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                        }
                        this.bVQ.a(fragment);
                    }
                }
            }
            return eO(e.this.bVJ.size());
        }

        public b b(com.baidu.swan.apps.model.b bVar) {
            d YR = e.this.YR();
            if (YR != null) {
                YR.a(bVar);
                return this;
            }
            return a("normal", bVar);
        }

        private void Za() {
            if (!e.this.bVJ.isEmpty()) {
                int size = e.this.bVJ.size();
                for (int i = size - 1; i >= 0; i--) {
                    if (i >= size - 1) {
                        if (e.DEBUG) {
                            Log.d("SwanAppFragmentManager", "show fragment i " + i + " ,size: " + size);
                        }
                        this.bVQ.c((Fragment) e.this.bVJ.get(i));
                    } else {
                        this.bVQ.b((Fragment) e.this.bVJ.get(i));
                    }
                }
            }
        }

        public void h(com.baidu.swan.apps.core.d.b bVar) {
            this.bVQ.c(bVar).commitAllowingStateLoss();
            e.this.bVI.executePendingTransactions();
        }

        public void i(com.baidu.swan.apps.core.d.b bVar) {
            this.bVQ.b(bVar).commitAllowingStateLoss();
            e.this.bVI.executePendingTransactions();
        }

        public void commit() {
            if (!TextUtils.isEmpty(this.bVR)) {
                d.jj(this.bVR);
            }
            while (!e.this.bVK.isEmpty()) {
                if (e.this.bVK.peek() != null) {
                    ((Runnable) e.this.bVK.poll()).run();
                }
            }
            Za();
            this.bVQ.commitAllowingStateLoss();
        }

        public boolean Zb() {
            commit();
            return e.this.bVI.executePendingTransactions();
        }
    }
}
