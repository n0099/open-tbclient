package com.baidu.swan.apps.ae;

import android.app.Activity;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.network.j;
import com.baidu.swan.apps.network.k;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends ContextWrapper {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    com.baidu.swan.apps.ae.a.c aPQ;
    com.baidu.swan.games.p.a.a aPR;
    private com.baidu.swan.apps.storage.c aPS;
    private com.baidu.swan.apps.setting.a aPT;
    private com.baidu.swan.apps.a.b aPU;
    private j aPV;
    private com.baidu.swan.games.network.b aPW;
    private com.baidu.swan.apps.af.a.a aPX;
    private com.baidu.swan.apps.media.audio.d aPY;
    private k aPZ;
    private d aQa;
    private Map<String, String> aQb;
    private com.baidu.swan.apps.v.b.b ajM;
    public final String id;
    private Activity mActivity;

    /* loaded from: classes2.dex */
    static abstract class a implements com.baidu.swan.apps.an.d.b<b> {
        abstract String id();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.b
        /* renamed from: LF */
        public b vB() {
            String id = id();
            if (TextUtils.isEmpty(id)) {
                return null;
            }
            return new b(id);
        }
    }

    @Nullable
    public static b Lq() {
        return e.LH().aQe.get();
    }

    @Deprecated
    public static synchronized void n(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            e.LH().p(bVar);
        }
    }

    @Deprecated
    public static synchronized void terminate() {
        synchronized (b.class) {
            e.LH().terminate();
        }
    }

    public void purge() {
        Lu().Ms();
        Lt().clear(true);
    }

    private b(String str) {
        super(AppRuntime.getApplication());
        this.id = str;
        this.aPX = new com.baidu.swan.apps.af.a.a();
        this.aPX.gL(str);
    }

    public void I(Activity activity) {
        this.mActivity = activity;
    }

    public void J(Activity activity) {
        Lu().J(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + LB());
        }
        if (this.aQa != null) {
            this.aQa.onDestroy();
        }
        com.baidu.swan.c.a.deleteFile(com.baidu.swan.apps.storage.b.hx(LB()));
        if (this.aPY != null) {
            this.aPY.release();
        }
        if (this.aPX != null) {
            this.aPX.release();
        }
        if (this.aPZ != null) {
            this.aPZ.release();
        }
        this.aPS = null;
        this.aPT = null;
        this.aPW = null;
    }

    public void c(com.baidu.swan.apps.ae.a.c cVar) {
        this.aPQ = cVar;
    }

    public com.baidu.swan.apps.ae.a.c Lr() {
        return this.aPQ;
    }

    public void a(com.baidu.swan.games.p.a.a aVar) {
        this.aPR = aVar;
    }

    public com.baidu.swan.games.p.a.a Ls() {
        return this.aPR;
    }

    public void o(com.baidu.swan.apps.v.b.b bVar) {
        this.ajM = bVar;
    }

    @Nullable
    public com.baidu.swan.apps.v.b.b vk() {
        return this.ajM;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public com.baidu.swan.apps.storage.c Lt() {
        if (this.aPS == null) {
            this.aPS = new com.baidu.swan.apps.storage.c(this);
        }
        return this.aPS;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a Lu() {
        if (this.aPT == null) {
            this.aPT = new com.baidu.swan.apps.setting.a(this);
        }
        return this.aPT;
    }

    public com.baidu.swan.apps.a.b Lv() {
        if (this.aPU == null) {
            this.aPU = new com.baidu.swan.apps.a.b(this);
        }
        return this.aPU;
    }

    public synchronized j Lw() {
        if (this.aPV == null) {
            this.aPV = new j(this);
        }
        return this.aPV;
    }

    public synchronized com.baidu.swan.games.network.b Lx() {
        if (this.aPW == null) {
            this.aPW = com.baidu.swan.games.network.b.RI();
        }
        return this.aPW;
    }

    public k Ly() {
        if (this.aPZ == null) {
            this.aPZ = new k();
        }
        return this.aPZ;
    }

    public com.baidu.swan.apps.media.audio.d Lz() {
        if (this.aPY == null) {
            this.aPY = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.aPY;
    }

    @NonNull
    public d LA() {
        if (this.aQa == null) {
            this.aQa = new d(this);
        }
        return this.aQa;
    }

    @Nullable
    @Deprecated
    public com.baidu.swan.apps.process.messaging.client.a CR() {
        return com.baidu.swan.apps.process.messaging.client.a.IE();
    }

    public String getAppKey() {
        return (this.ajM == null || TextUtils.isEmpty(this.ajM.getAppKey())) ? "" : this.ajM.getAppKey();
    }

    @Nullable
    public static String LB() {
        if (Lq() == null) {
            return null;
        }
        return Lq().id;
    }

    public static int vc() {
        if (Lq() == null || Lq().ajM == null) {
            return 0;
        }
        return Lq().ajM.Fg();
    }

    public boolean LC() {
        return this.ajM != null && this.ajM.Fg() == 1;
    }

    public String getName() {
        return this.ajM == null ? "" : this.ajM.BM();
    }

    public String getVersion() {
        return this.ajM != null ? this.ajM.getVersion() : "";
    }

    public static boolean isDataValid() {
        if (DEBUG) {
            Log.d("SwanApp isDataValid:", "SwanApp.get() != null " + (Lq() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.getSwanAppId() != null " + (LB() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.get().getLaunchInfo() != null " + ((Lq() == null || Lq().vk() == null) ? false : true));
        }
        return (Lq() == null || LB() == null || Lq().vk() == null) ? false : true;
    }

    public com.baidu.swan.apps.af.a.a LD() {
        if (this.aPX == null) {
            this.aPX = new com.baidu.swan.apps.af.a.a();
        }
        return this.aPX;
    }

    public boolean gy(String str) {
        if (TextUtils.isEmpty(str) || this.aPQ == null || this.aPQ.aQn == null) {
            return false;
        }
        return this.aPQ.aQn.gJ(str);
    }

    public boolean gz(String str) {
        if (TextUtils.isEmpty(str) || this.aPQ == null || this.aPQ.aQo == null || this.aPQ.aQo.aQB == null || !this.aPQ.aQo.aQB.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.aPQ.aQo.aQB.get(str).booleanValue();
    }

    public boolean gA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.apps.database.subpackage.a.Cb().m(this.id, getVersion(), str);
    }

    public boolean gB(String str) {
        return new File(com.baidu.swan.apps.w.e.FV().FE(), str).exists();
    }

    public void s(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.aPQ != null && this.aPQ.aQo != null && this.aPQ.aQo.aQB != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.aPQ.aQo.aQB.put(str, Boolean.valueOf(z));
        }
    }

    public String gC(String str) {
        if (this.aPQ == null || this.aPQ.aQo == null || this.aPQ.aQo.aQC == null) {
            return null;
        }
        return this.aPQ.aQo.aQC.get(str);
    }

    public String gD(String str) {
        if (this.aPQ == null || this.aPQ.aQp == null || this.aPQ.aQp.aQD == null) {
            return null;
        }
        return this.aPQ.aQp.aQD.get(str);
    }

    public String LE() {
        com.baidu.swan.apps.v.b.b vk = vk();
        return vk != null ? dI(vk.getType()) : "0";
    }

    private String dI(int i) {
        if (i == 0) {
            String versionCode = this.ajM != null ? this.ajM.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String ir = ac.ir(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(ir) ? " version is empty " : ir);
            return ir;
        }
        return "0";
    }

    public void au(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.aQb == null) {
                this.aQb = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.aQb.put(str2, str);
        }
    }

    @Nullable
    public String gE(String str) {
        if (TextUtils.isEmpty(str) || this.aQb == null) {
            return null;
        }
        return this.aQb.get(str);
    }
}
