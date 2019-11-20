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
    private com.baidu.swan.apps.v.b.b aDQ;
    com.baidu.swan.apps.ae.a.c bjK;
    com.baidu.swan.games.p.a.a bjL;
    private com.baidu.swan.apps.storage.c bjM;
    private com.baidu.swan.apps.setting.a bjN;
    private com.baidu.swan.apps.a.b bjO;
    private j bjP;
    private com.baidu.swan.games.network.b bjQ;
    private com.baidu.swan.apps.af.a.a bjR;
    private com.baidu.swan.apps.media.audio.d bjS;
    private k bjT;
    private d bjU;
    private Map<String, String> bjV;
    public final String id;
    private Activity mActivity;

    /* loaded from: classes2.dex */
    static abstract class a implements com.baidu.swan.apps.an.d.b<b> {
        abstract String Rq();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.d.b
        /* renamed from: Rr */
        public b Bb() {
            String Rq = Rq();
            if (TextUtils.isEmpty(Rq)) {
                return null;
            }
            return new b(Rq);
        }
    }

    @Nullable
    public static b Ra() {
        return e.Rt().bjY.get();
    }

    @Deprecated
    public static synchronized void n(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            e.Rt().p(bVar);
        }
    }

    @Deprecated
    public static synchronized void terminate() {
        synchronized (b.class) {
            e.Rt().terminate();
        }
    }

    public void Rb() {
        Rf().Sc();
        Re().L(true);
    }

    private b(String str) {
        super(AppRuntime.getApplication());
        this.id = str;
        this.bjR = new com.baidu.swan.apps.af.a.a();
        this.bjR.hy(str);
    }

    public void K(Activity activity) {
        this.mActivity = activity;
    }

    public void L(Activity activity) {
        Rf().L(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + Rm());
        }
        if (this.bjU != null) {
            this.bjU.onDestroy();
        }
        com.baidu.swan.c.a.deleteFile(com.baidu.swan.apps.storage.b.ik(Rm()));
        if (this.bjS != null) {
            this.bjS.release();
        }
        if (this.bjR != null) {
            this.bjR.release();
        }
        if (this.bjT != null) {
            this.bjT.release();
        }
        this.bjM = null;
        this.bjN = null;
        this.bjQ = null;
    }

    public void c(com.baidu.swan.apps.ae.a.c cVar) {
        this.bjK = cVar;
    }

    public com.baidu.swan.apps.ae.a.c Rc() {
        return this.bjK;
    }

    public void a(com.baidu.swan.games.p.a.a aVar) {
        this.bjL = aVar;
    }

    public com.baidu.swan.games.p.a.a Rd() {
        return this.bjL;
    }

    public void o(com.baidu.swan.apps.v.b.b bVar) {
        this.aDQ = bVar;
    }

    @Nullable
    public com.baidu.swan.apps.v.b.b AK() {
        return this.aDQ;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public com.baidu.swan.apps.storage.c Re() {
        if (this.bjM == null) {
            this.bjM = new com.baidu.swan.apps.storage.c(this);
        }
        return this.bjM;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a Rf() {
        if (this.bjN == null) {
            this.bjN = new com.baidu.swan.apps.setting.a(this);
        }
        return this.bjN;
    }

    public com.baidu.swan.apps.a.b Rg() {
        if (this.bjO == null) {
            this.bjO = new com.baidu.swan.apps.a.b(this);
        }
        return this.bjO;
    }

    public synchronized j Rh() {
        if (this.bjP == null) {
            this.bjP = new j(this);
        }
        return this.bjP;
    }

    public synchronized com.baidu.swan.games.network.b Ri() {
        if (this.bjQ == null) {
            this.bjQ = com.baidu.swan.games.network.b.Xu();
        }
        return this.bjQ;
    }

    public k Rj() {
        if (this.bjT == null) {
            this.bjT = new k();
        }
        return this.bjT;
    }

    public com.baidu.swan.apps.media.audio.d Rk() {
        if (this.bjS == null) {
            this.bjS = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.bjS;
    }

    @NonNull
    public d Rl() {
        if (this.bjU == null) {
            this.bjU = new d(this);
        }
        return this.bjU;
    }

    @Nullable
    @Deprecated
    public com.baidu.swan.apps.process.messaging.client.a Iz() {
        return com.baidu.swan.apps.process.messaging.client.a.Oq();
    }

    public String getAppKey() {
        return (this.aDQ == null || TextUtils.isEmpty(this.aDQ.getAppKey())) ? "" : this.aDQ.getAppKey();
    }

    @Nullable
    public static String Rm() {
        if (Ra() == null) {
            return null;
        }
        return Ra().id;
    }

    public static int AC() {
        if (Ra() == null || Ra().aDQ == null) {
            return 0;
        }
        return Ra().aDQ.KP();
    }

    public boolean Rn() {
        return this.aDQ != null && this.aDQ.KP() == 1;
    }

    public String getName() {
        return this.aDQ == null ? "" : this.aDQ.Hu();
    }

    public String getVersion() {
        return this.aDQ != null ? this.aDQ.getVersion() : "";
    }

    public static boolean isDataValid() {
        if (DEBUG) {
            Log.d("SwanApp isDataValid:", "SwanApp.get() != null " + (Ra() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.getSwanAppId() != null " + (Rm() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.get().getLaunchInfo() != null " + ((Ra() == null || Ra().AK() == null) ? false : true));
        }
        return (Ra() == null || Rm() == null || Ra().AK() == null) ? false : true;
    }

    public com.baidu.swan.apps.af.a.a Ro() {
        if (this.bjR == null) {
            this.bjR = new com.baidu.swan.apps.af.a.a();
        }
        return this.bjR;
    }

    public boolean hl(String str) {
        if (TextUtils.isEmpty(str) || this.bjK == null || this.bjK.bkh == null) {
            return false;
        }
        return this.bjK.bkh.hw(str);
    }

    public boolean hm(String str) {
        if (TextUtils.isEmpty(str) || this.bjK == null || this.bjK.bki == null || this.bjK.bki.bkv == null || !this.bjK.bki.bkv.containsKey(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanApp", "内存中查询分包是否存在信息");
        }
        return this.bjK.bki.bkv.get(str).booleanValue();
    }

    public boolean hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.baidu.swan.apps.database.subpackage.a.HJ().q(this.id, getVersion(), str);
    }

    public boolean ho(String str) {
        return new File(com.baidu.swan.apps.w.e.LE().Ln(), str).exists();
    }

    public void w(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.bjK != null && this.bjK.bki != null && this.bjK.bki.bkv != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.bjK.bki.bkv.put(str, Boolean.valueOf(z));
        }
    }

    public String hp(String str) {
        if (this.bjK == null || this.bjK.bki == null || this.bjK.bki.bkw == null) {
            return null;
        }
        return this.bjK.bki.bkw.get(str);
    }

    public String hq(String str) {
        if (this.bjK == null || this.bjK.bkj == null || this.bjK.bkj.bkx == null) {
            return null;
        }
        return this.bjK.bkj.bkx.get(str);
    }

    public String Rp() {
        com.baidu.swan.apps.v.b.b AK = AK();
        return AK != null ? eH(AK.getType()) : "0";
    }

    private String eH(int i) {
        if (i == 0) {
            String versionCode = this.aDQ != null ? this.aDQ.getVersionCode() : "";
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
            if (this.bjV == null) {
                this.bjV = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.bjV.put(str2, str);
        }
    }

    @Nullable
    public String hr(String str) {
        if (TextUtils.isEmpty(str) || this.bjV == null) {
            return null;
        }
        return this.bjV.get(str);
    }
}
