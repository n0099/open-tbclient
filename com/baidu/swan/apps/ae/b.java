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
    com.baidu.swan.apps.ae.a.c aQA;
    com.baidu.swan.games.p.a.a aQB;
    private com.baidu.swan.apps.storage.c aQC;
    private com.baidu.swan.apps.setting.a aQD;
    private com.baidu.swan.apps.a.b aQE;
    private j aQF;
    private com.baidu.swan.games.network.b aQG;
    private com.baidu.swan.apps.af.a.a aQH;
    private com.baidu.swan.apps.media.audio.d aQI;
    private k aQJ;
    private d aQK;
    private Map<String, String> aQL;
    private com.baidu.swan.apps.v.b.b ako;
    public final String id;
    private Activity mActivity;

    /* loaded from: classes2.dex */
    static abstract class a implements com.baidu.swan.apps.an.d.b<b> {
        abstract String Ms();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.b
        /* renamed from: Mt */
        public b wc() {
            String Ms = Ms();
            if (TextUtils.isEmpty(Ms)) {
                return null;
            }
            return new b(Ms);
        }
    }

    @Nullable
    public static b Md() {
        return e.Mv().aQO.get();
    }

    @Deprecated
    public static synchronized void n(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            e.Mv().p(bVar);
        }
    }

    @Deprecated
    public static synchronized void terminate() {
        synchronized (b.class) {
            e.Mv().terminate();
        }
    }

    public void purge() {
        Mh().Ng();
        Mg().ak(true);
    }

    private b(String str) {
        super(AppRuntime.getApplication());
        this.id = str;
        this.aQH = new com.baidu.swan.apps.af.a.a();
        this.aQH.gS(str);
    }

    public void L(Activity activity) {
        this.mActivity = activity;
    }

    public void M(Activity activity) {
        Mh().M(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + Mo());
        }
        if (this.aQK != null) {
            this.aQK.onDestroy();
        }
        com.baidu.swan.c.a.deleteFile(com.baidu.swan.apps.storage.b.hE(Mo()));
        if (this.aQI != null) {
            this.aQI.release();
        }
        if (this.aQH != null) {
            this.aQH.release();
        }
        if (this.aQJ != null) {
            this.aQJ.release();
        }
        this.aQC = null;
        this.aQD = null;
        this.aQG = null;
    }

    public void c(com.baidu.swan.apps.ae.a.c cVar) {
        this.aQA = cVar;
    }

    public com.baidu.swan.apps.ae.a.c Me() {
        return this.aQA;
    }

    public void a(com.baidu.swan.games.p.a.a aVar) {
        this.aQB = aVar;
    }

    public com.baidu.swan.games.p.a.a Mf() {
        return this.aQB;
    }

    public void o(com.baidu.swan.apps.v.b.b bVar) {
        this.ako = bVar;
    }

    @Nullable
    public com.baidu.swan.apps.v.b.b vL() {
        return this.ako;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public com.baidu.swan.apps.storage.c Mg() {
        if (this.aQC == null) {
            this.aQC = new com.baidu.swan.apps.storage.c(this);
        }
        return this.aQC;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a Mh() {
        if (this.aQD == null) {
            this.aQD = new com.baidu.swan.apps.setting.a(this);
        }
        return this.aQD;
    }

    public com.baidu.swan.apps.a.b Mi() {
        if (this.aQE == null) {
            this.aQE = new com.baidu.swan.apps.a.b(this);
        }
        return this.aQE;
    }

    public synchronized j Mj() {
        if (this.aQF == null) {
            this.aQF = new j(this);
        }
        return this.aQF;
    }

    public synchronized com.baidu.swan.games.network.b Mk() {
        if (this.aQG == null) {
            this.aQG = com.baidu.swan.games.network.b.SB();
        }
        return this.aQG;
    }

    public k Ml() {
        if (this.aQJ == null) {
            this.aQJ = new k();
        }
        return this.aQJ;
    }

    public com.baidu.swan.apps.media.audio.d Mm() {
        if (this.aQI == null) {
            this.aQI = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.aQI;
    }

    @NonNull
    public d Mn() {
        if (this.aQK == null) {
            this.aQK = new d(this);
        }
        return this.aQK;
    }

    @Nullable
    @Deprecated
    public com.baidu.swan.apps.process.messaging.client.a DA() {
        return com.baidu.swan.apps.process.messaging.client.a.Jr();
    }

    public String getAppKey() {
        return (this.ako == null || TextUtils.isEmpty(this.ako.getAppKey())) ? "" : this.ako.getAppKey();
    }

    @Nullable
    public static String Mo() {
        if (Md() == null) {
            return null;
        }
        return Md().id;
    }

    public static int vD() {
        if (Md() == null || Md().ako == null) {
            return 0;
        }
        return Md().ako.FQ();
    }

    public boolean Mp() {
        return this.ako != null && this.ako.FQ() == 1;
    }

    public String getName() {
        return this.ako == null ? "" : this.ako.Cv();
    }

    public String getVersion() {
        return this.ako != null ? this.ako.getVersion() : "";
    }

    public static boolean isDataValid() {
        if (DEBUG) {
            Log.d("SwanApp isDataValid:", "SwanApp.get() != null " + (Md() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.getSwanAppId() != null " + (Mo() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.get().getLaunchInfo() != null " + ((Md() == null || Md().vL() == null) ? false : true));
        }
        return (Md() == null || Mo() == null || Md().vL() == null) ? false : true;
    }

    public com.baidu.swan.apps.af.a.a Mq() {
        if (this.aQH == null) {
            this.aQH = new com.baidu.swan.apps.af.a.a();
        }
        return this.aQH;
    }

    public boolean gF(String str) {
        if (TextUtils.isEmpty(str) || this.aQA == null || this.aQA.aQX == null) {
            return false;
        }
        return this.aQA.aQX.gQ(str);
    }

    public boolean gG(String str) {
        if (TextUtils.isEmpty(str) || this.aQA == null || this.aQA.aQY == null || this.aQA.aQY.aRl == null || !this.aQA.aQY.aRl.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.aQA.aQY.aRl.get(str).booleanValue();
    }

    public boolean gH(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.apps.database.subpackage.a.CK().m(this.id, getVersion(), str);
    }

    public boolean gI(String str) {
        return new File(com.baidu.swan.apps.w.e.GF().Go(), str).exists();
    }

    public void t(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.aQA != null && this.aQA.aQY != null && this.aQA.aQY.aRl != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.aQA.aQY.aRl.put(str, Boolean.valueOf(z));
        }
    }

    public String gJ(String str) {
        if (this.aQA == null || this.aQA.aQY == null || this.aQA.aQY.aRm == null) {
            return null;
        }
        return this.aQA.aQY.aRm.get(str);
    }

    public String gK(String str) {
        if (this.aQA == null || this.aQA.aQZ == null || this.aQA.aQZ.aRn == null) {
            return null;
        }
        return this.aQA.aQZ.aRn.get(str);
    }

    public String Mr() {
        com.baidu.swan.apps.v.b.b vL = vL();
        return vL != null ? dL(vL.getType()) : "0";
    }

    private String dL(int i) {
        if (i == 0) {
            String versionCode = this.ako != null ? this.ako.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String iy = ac.iy(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(iy) ? " version is empty " : iy);
            return iy;
        }
        return "0";
    }

    public void au(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.aQL == null) {
                this.aQL = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.aQL.put(str2, str);
        }
    }

    @Nullable
    public String gL(String str) {
        if (TextUtils.isEmpty(str) || this.aQL == null) {
            return null;
        }
        return this.aQL.get(str);
    }
}
