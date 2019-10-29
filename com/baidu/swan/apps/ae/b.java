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
    private com.baidu.swan.apps.v.b.b aEi;
    com.baidu.swan.apps.ae.a.c bkc;
    com.baidu.swan.games.p.a.a bkd;
    private com.baidu.swan.apps.storage.c bke;
    private com.baidu.swan.apps.setting.a bkf;
    private com.baidu.swan.apps.a.b bkg;
    private j bkh;
    private com.baidu.swan.games.network.b bki;
    private com.baidu.swan.apps.af.a.a bkj;
    private com.baidu.swan.apps.media.audio.d bkk;
    private k bkl;
    private d bkm;
    private Map<String, String> bkn;
    public final String id;
    private Activity mActivity;

    /* loaded from: classes2.dex */
    static abstract class a implements com.baidu.swan.apps.an.d.b<b> {
        abstract String Ro();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.b
        /* renamed from: Rp */
        public b Ba() {
            String Ro = Ro();
            if (TextUtils.isEmpty(Ro)) {
                return null;
            }
            return new b(Ro);
        }
    }

    @Nullable
    public static b QZ() {
        return e.Rr().bkq.get();
    }

    @Deprecated
    public static synchronized void n(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            e.Rr().p(bVar);
        }
    }

    @Deprecated
    public static synchronized void terminate() {
        synchronized (b.class) {
            e.Rr().terminate();
        }
    }

    public void purge() {
        Rd().Sa();
        Rc().L(true);
    }

    private b(String str) {
        super(AppRuntime.getApplication());
        this.id = str;
        this.bkj = new com.baidu.swan.apps.af.a.a();
        this.bkj.hy(str);
    }

    public void K(Activity activity) {
        this.mActivity = activity;
    }

    public void L(Activity activity) {
        Rd().L(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + Rk());
        }
        if (this.bkm != null) {
            this.bkm.onDestroy();
        }
        com.baidu.swan.c.a.deleteFile(com.baidu.swan.apps.storage.b.ik(Rk()));
        if (this.bkk != null) {
            this.bkk.release();
        }
        if (this.bkj != null) {
            this.bkj.release();
        }
        if (this.bkl != null) {
            this.bkl.release();
        }
        this.bke = null;
        this.bkf = null;
        this.bki = null;
    }

    public void c(com.baidu.swan.apps.ae.a.c cVar) {
        this.bkc = cVar;
    }

    public com.baidu.swan.apps.ae.a.c Ra() {
        return this.bkc;
    }

    public void a(com.baidu.swan.games.p.a.a aVar) {
        this.bkd = aVar;
    }

    public com.baidu.swan.games.p.a.a Rb() {
        return this.bkd;
    }

    public void o(com.baidu.swan.apps.v.b.b bVar) {
        this.aEi = bVar;
    }

    @Nullable
    public com.baidu.swan.apps.v.b.b AJ() {
        return this.aEi;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public com.baidu.swan.apps.storage.c Rc() {
        if (this.bke == null) {
            this.bke = new com.baidu.swan.apps.storage.c(this);
        }
        return this.bke;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a Rd() {
        if (this.bkf == null) {
            this.bkf = new com.baidu.swan.apps.setting.a(this);
        }
        return this.bkf;
    }

    public com.baidu.swan.apps.a.b Re() {
        if (this.bkg == null) {
            this.bkg = new com.baidu.swan.apps.a.b(this);
        }
        return this.bkg;
    }

    public synchronized j Rf() {
        if (this.bkh == null) {
            this.bkh = new j(this);
        }
        return this.bkh;
    }

    public synchronized com.baidu.swan.games.network.b Rg() {
        if (this.bki == null) {
            this.bki = com.baidu.swan.games.network.b.Xw();
        }
        return this.bki;
    }

    public k Rh() {
        if (this.bkl == null) {
            this.bkl = new k();
        }
        return this.bkl;
    }

    public com.baidu.swan.apps.media.audio.d Ri() {
        if (this.bkk == null) {
            this.bkk = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.bkk;
    }

    @NonNull
    public d Rj() {
        if (this.bkm == null) {
            this.bkm = new d(this);
        }
        return this.bkm;
    }

    @Nullable
    @Deprecated
    public com.baidu.swan.apps.process.messaging.client.a Iy() {
        return com.baidu.swan.apps.process.messaging.client.a.Op();
    }

    public String getAppKey() {
        return (this.aEi == null || TextUtils.isEmpty(this.aEi.getAppKey())) ? "" : this.aEi.getAppKey();
    }

    @Nullable
    public static String Rk() {
        if (QZ() == null) {
            return null;
        }
        return QZ().id;
    }

    public static int AB() {
        if (QZ() == null || QZ().aEi == null) {
            return 0;
        }
        return QZ().aEi.KO();
    }

    public boolean Rl() {
        return this.aEi != null && this.aEi.KO() == 1;
    }

    public String getName() {
        return this.aEi == null ? "" : this.aEi.Ht();
    }

    public String getVersion() {
        return this.aEi != null ? this.aEi.getVersion() : "";
    }

    public static boolean isDataValid() {
        if (DEBUG) {
            Log.d("SwanApp isDataValid:", "SwanApp.get() != null " + (QZ() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.getSwanAppId() != null " + (Rk() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.get().getLaunchInfo() != null " + ((QZ() == null || QZ().AJ() == null) ? false : true));
        }
        return (QZ() == null || Rk() == null || QZ().AJ() == null) ? false : true;
    }

    public com.baidu.swan.apps.af.a.a Rm() {
        if (this.bkj == null) {
            this.bkj = new com.baidu.swan.apps.af.a.a();
        }
        return this.bkj;
    }

    public boolean hl(String str) {
        if (TextUtils.isEmpty(str) || this.bkc == null || this.bkc.bkz == null) {
            return false;
        }
        return this.bkc.bkz.hw(str);
    }

    public boolean hm(String str) {
        if (TextUtils.isEmpty(str) || this.bkc == null || this.bkc.bkA == null || this.bkc.bkA.bkN == null || !this.bkc.bkA.bkN.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.bkc.bkA.bkN.get(str).booleanValue();
    }

    public boolean hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.apps.database.subpackage.a.HI().q(this.id, getVersion(), str);
    }

    public boolean ho(String str) {
        return new File(com.baidu.swan.apps.w.e.LD().Lm(), str).exists();
    }

    public void w(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bkc != null && this.bkc.bkA != null && this.bkc.bkA.bkN != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bkc.bkA.bkN.put(str, Boolean.valueOf(z));
        }
    }

    public String hp(String str) {
        if (this.bkc == null || this.bkc.bkA == null || this.bkc.bkA.bkO == null) {
            return null;
        }
        return this.bkc.bkA.bkO.get(str);
    }

    public String hq(String str) {
        if (this.bkc == null || this.bkc.bkB == null || this.bkc.bkB.bkP == null) {
            return null;
        }
        return this.bkc.bkB.bkP.get(str);
    }

    public String Rn() {
        com.baidu.swan.apps.v.b.b AJ = AJ();
        return AJ != null ? eH(AJ.getType()) : "0";
    }

    private String eH(int i) {
        if (i == 0) {
            String versionCode = this.aEi != null ? this.aEi.getVersionCode() : "";
            if (TextUtils.isEmpty(versionCode)) {
                versionCode = getVersion();
            }
            String jd = ac.jd(versionCode);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(jd) ? " version is empty " : jd);
            return jd;
        }
        return "0";
    }

    public void aC(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.bkn == null) {
                this.bkn = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.bkn.put(str2, str);
        }
    }

    @Nullable
    public String hr(String str) {
        if (TextUtils.isEmpty(str) || this.bkn == null) {
            return null;
        }
        return this.bkn.get(str);
    }
}
