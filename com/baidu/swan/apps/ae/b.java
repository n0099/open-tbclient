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
    com.baidu.swan.apps.ae.a.c aQY;
    com.baidu.swan.games.p.a.a aQZ;
    private com.baidu.swan.apps.storage.c aRa;
    private com.baidu.swan.apps.setting.a aRb;
    private com.baidu.swan.apps.a.b aRc;
    private j aRd;
    private com.baidu.swan.games.network.b aRe;
    private com.baidu.swan.apps.af.a.a aRf;
    private com.baidu.swan.apps.media.audio.d aRg;
    private k aRh;
    private d aRi;
    private Map<String, String> aRj;
    private com.baidu.swan.apps.v.b.b akM;
    public final String id;
    private Activity mActivity;

    /* loaded from: classes2.dex */
    static abstract class a implements com.baidu.swan.apps.an.d.b<b> {
        abstract String Mw();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.b
        /* renamed from: Mx */
        public b wg() {
            String Mw = Mw();
            if (TextUtils.isEmpty(Mw)) {
                return null;
            }
            return new b(Mw);
        }
    }

    @Nullable
    public static b Mh() {
        return e.Mz().aRm.get();
    }

    @Deprecated
    public static synchronized void n(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            e.Mz().p(bVar);
        }
    }

    @Deprecated
    public static synchronized void terminate() {
        synchronized (b.class) {
            e.Mz().terminate();
        }
    }

    public void purge() {
        Ml().Nk();
        Mk().ak(true);
    }

    private b(String str) {
        super(AppRuntime.getApplication());
        this.id = str;
        this.aRf = new com.baidu.swan.apps.af.a.a();
        this.aRf.gU(str);
    }

    public void L(Activity activity) {
        this.mActivity = activity;
    }

    public void M(Activity activity) {
        Ml().M(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + Ms());
        }
        if (this.aRi != null) {
            this.aRi.onDestroy();
        }
        com.baidu.swan.c.a.deleteFile(com.baidu.swan.apps.storage.b.hG(Ms()));
        if (this.aRg != null) {
            this.aRg.release();
        }
        if (this.aRf != null) {
            this.aRf.release();
        }
        if (this.aRh != null) {
            this.aRh.release();
        }
        this.aRa = null;
        this.aRb = null;
        this.aRe = null;
    }

    public void c(com.baidu.swan.apps.ae.a.c cVar) {
        this.aQY = cVar;
    }

    public com.baidu.swan.apps.ae.a.c Mi() {
        return this.aQY;
    }

    public void a(com.baidu.swan.games.p.a.a aVar) {
        this.aQZ = aVar;
    }

    public com.baidu.swan.games.p.a.a Mj() {
        return this.aQZ;
    }

    public void o(com.baidu.swan.apps.v.b.b bVar) {
        this.akM = bVar;
    }

    @Nullable
    public com.baidu.swan.apps.v.b.b vP() {
        return this.akM;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public com.baidu.swan.apps.storage.c Mk() {
        if (this.aRa == null) {
            this.aRa = new com.baidu.swan.apps.storage.c(this);
        }
        return this.aRa;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a Ml() {
        if (this.aRb == null) {
            this.aRb = new com.baidu.swan.apps.setting.a(this);
        }
        return this.aRb;
    }

    public com.baidu.swan.apps.a.b Mm() {
        if (this.aRc == null) {
            this.aRc = new com.baidu.swan.apps.a.b(this);
        }
        return this.aRc;
    }

    public synchronized j Mn() {
        if (this.aRd == null) {
            this.aRd = new j(this);
        }
        return this.aRd;
    }

    public synchronized com.baidu.swan.games.network.b Mo() {
        if (this.aRe == null) {
            this.aRe = com.baidu.swan.games.network.b.SF();
        }
        return this.aRe;
    }

    public k Mp() {
        if (this.aRh == null) {
            this.aRh = new k();
        }
        return this.aRh;
    }

    public com.baidu.swan.apps.media.audio.d Mq() {
        if (this.aRg == null) {
            this.aRg = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.aRg;
    }

    @NonNull
    public d Mr() {
        if (this.aRi == null) {
            this.aRi = new d(this);
        }
        return this.aRi;
    }

    @Nullable
    @Deprecated
    public com.baidu.swan.apps.process.messaging.client.a DE() {
        return com.baidu.swan.apps.process.messaging.client.a.Jv();
    }

    public String getAppKey() {
        return (this.akM == null || TextUtils.isEmpty(this.akM.getAppKey())) ? "" : this.akM.getAppKey();
    }

    @Nullable
    public static String Ms() {
        if (Mh() == null) {
            return null;
        }
        return Mh().id;
    }

    public static int vH() {
        if (Mh() == null || Mh().akM == null) {
            return 0;
        }
        return Mh().akM.FU();
    }

    public boolean Mt() {
        return this.akM != null && this.akM.FU() == 1;
    }

    public String getName() {
        return this.akM == null ? "" : this.akM.Cz();
    }

    public String getVersion() {
        return this.akM != null ? this.akM.getVersion() : "";
    }

    public static boolean isDataValid() {
        if (DEBUG) {
            Log.d("SwanApp isDataValid:", "SwanApp.get() != null " + (Mh() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.getSwanAppId() != null " + (Ms() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.get().getLaunchInfo() != null " + ((Mh() == null || Mh().vP() == null) ? false : true));
        }
        return (Mh() == null || Ms() == null || Mh().vP() == null) ? false : true;
    }

    public com.baidu.swan.apps.af.a.a Mu() {
        if (this.aRf == null) {
            this.aRf = new com.baidu.swan.apps.af.a.a();
        }
        return this.aRf;
    }

    public boolean gH(String str) {
        if (TextUtils.isEmpty(str) || this.aQY == null || this.aQY.aRv == null) {
            return false;
        }
        return this.aQY.aRv.gS(str);
    }

    public boolean gI(String str) {
        if (TextUtils.isEmpty(str) || this.aQY == null || this.aQY.aRw == null || this.aQY.aRw.aRJ == null || !this.aQY.aRw.aRJ.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.aQY.aRw.aRJ.get(str).booleanValue();
    }

    public boolean gJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.apps.database.subpackage.a.CO().m(this.id, getVersion(), str);
    }

    public boolean gK(String str) {
        return new File(com.baidu.swan.apps.w.e.GJ().Gs(), str).exists();
    }

    public void t(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.aQY != null && this.aQY.aRw != null && this.aQY.aRw.aRJ != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.aQY.aRw.aRJ.put(str, Boolean.valueOf(z));
        }
    }

    public String gL(String str) {
        if (this.aQY == null || this.aQY.aRw == null || this.aQY.aRw.aRK == null) {
            return null;
        }
        return this.aQY.aRw.aRK.get(str);
    }

    public String gM(String str) {
        if (this.aQY == null || this.aQY.aRx == null || this.aQY.aRx.aRL == null) {
            return null;
        }
        return this.aQY.aRx.aRL.get(str);
    }

    public String Mv() {
        com.baidu.swan.apps.v.b.b vP = vP();
        return vP != null ? dM(vP.getType()) : "0";
    }

    private String dM(int i) {
        if (i == 0) {
            String versionCode = this.akM != null ? this.akM.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String iA = ac.iA(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(iA) ? " version is empty " : iA);
            return iA;
        }
        return "0";
    }

    public void au(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.aRj == null) {
                this.aRj = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.aRj.put(str2, str);
        }
    }

    @Nullable
    public String gN(String str) {
        if (TextUtils.isEmpty(str) || this.aRj == null) {
            return null;
        }
        return this.aRj.get(str);
    }
}
