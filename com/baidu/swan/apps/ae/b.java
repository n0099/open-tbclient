package com.baidu.swan.apps.ae;

import android.app.Activity;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.network.j;
import com.baidu.swan.apps.network.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends ContextWrapper {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    com.baidu.swan.apps.ae.a.c aNJ;
    com.baidu.swan.games.o.a.a aNK;
    private com.baidu.swan.apps.storage.c aNL;
    private com.baidu.swan.apps.setting.a aNM;
    private com.baidu.swan.apps.a.b aNN;
    private j aNO;
    private com.baidu.swan.games.network.b aNP;
    private com.baidu.swan.apps.af.a.a aNQ;
    private com.baidu.swan.apps.media.audio.d aNR;
    private k aNS;
    private d aNT;
    private Map<String, String> aNU;
    private com.baidu.swan.apps.v.b.b ajt;
    public final String id;
    private Activity mActivity;

    /* loaded from: classes2.dex */
    static abstract class a implements com.baidu.swan.apps.an.c.b<b> {
        abstract String id();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.c.b
        /* renamed from: Jm */
        public b uS() {
            String id = id();
            if (TextUtils.isEmpty(id)) {
                return null;
            }
            return new b(id);
        }
    }

    @Nullable
    public static b IX() {
        return e.Jo().aNX.get();
    }

    @Deprecated
    public static synchronized void n(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            e.Jo().p(bVar);
        }
    }

    @Deprecated
    public static synchronized void terminate() {
        synchronized (b.class) {
            e.Jo().terminate();
        }
    }

    public void purge() {
        Jb().JU();
        Ja().clear(true);
    }

    private b(String str) {
        super(AppRuntime.getApplication());
        this.id = str;
        this.aNQ = new com.baidu.swan.apps.af.a.a();
        this.aNQ.gq(str);
    }

    public void H(Activity activity) {
        this.mActivity = activity;
    }

    public void I(Activity activity) {
        Jb().I(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + Ji());
        }
        if (this.aNT != null) {
            this.aNT.onDestroy();
        }
        com.baidu.swan.c.b.deleteFile(com.baidu.swan.apps.storage.b.gX(Ji()));
        if (this.aNR != null) {
            this.aNR.release();
        }
        if (this.aNQ != null) {
            this.aNQ.release();
        }
        if (this.aNS != null) {
            this.aNS.release();
        }
        this.aNL = null;
        this.aNM = null;
        this.aNP = null;
    }

    public void c(com.baidu.swan.apps.ae.a.c cVar) {
        this.aNJ = cVar;
    }

    public com.baidu.swan.apps.ae.a.c IY() {
        return this.aNJ;
    }

    public void a(com.baidu.swan.games.o.a.a aVar) {
        this.aNK = aVar;
    }

    public com.baidu.swan.games.o.a.a IZ() {
        return this.aNK;
    }

    public void o(com.baidu.swan.apps.v.b.b bVar) {
        this.ajt = bVar;
    }

    @Nullable
    public com.baidu.swan.apps.v.b.b uB() {
        return this.ajt;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public com.baidu.swan.apps.storage.c Ja() {
        if (this.aNL == null) {
            this.aNL = new com.baidu.swan.apps.storage.c(this);
        }
        return this.aNL;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a Jb() {
        if (this.aNM == null) {
            this.aNM = new com.baidu.swan.apps.setting.a(this);
        }
        return this.aNM;
    }

    public com.baidu.swan.apps.a.b Jc() {
        if (this.aNN == null) {
            this.aNN = new com.baidu.swan.apps.a.b(this);
        }
        return this.aNN;
    }

    public synchronized j Jd() {
        if (this.aNO == null) {
            this.aNO = new j(this);
        }
        return this.aNO;
    }

    public synchronized com.baidu.swan.games.network.b Je() {
        if (this.aNP == null) {
            this.aNP = com.baidu.swan.games.network.b.OF();
        }
        return this.aNP;
    }

    public k Jf() {
        if (this.aNS == null) {
            this.aNS = new k();
        }
        return this.aNS;
    }

    public com.baidu.swan.apps.media.audio.d Jg() {
        if (this.aNR == null) {
            this.aNR = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.aNR;
    }

    @NonNull
    public d Jh() {
        if (this.aNT == null) {
            this.aNT = new d(this);
        }
        return this.aNT;
    }

    @Nullable
    @Deprecated
    public com.baidu.swan.apps.process.messaging.client.a BR() {
        return com.baidu.swan.apps.process.messaging.client.a.Gq();
    }

    public String getAppKey() {
        return (this.ajt == null || TextUtils.isEmpty(this.ajt.mAppKey)) ? "" : this.ajt.mAppKey;
    }

    @Nullable
    public static String Ji() {
        if (IX() == null) {
            return null;
        }
        return IX().id;
    }

    public static int ut() {
        if (IX() == null || IX().ajt == null) {
            return 0;
        }
        return IX().ajt.axX;
    }

    public boolean Jj() {
        return this.ajt != null && this.ajt.axX == 1;
    }

    public String getName() {
        return this.ajt == null ? "" : this.ajt.axD;
    }

    public String getVersion() {
        return this.ajt != null ? this.ajt.mVersion : "";
    }

    public static boolean isDataValid() {
        if (DEBUG) {
            Log.d("SwanApp isDataValid:", "SwanApp.get() != null " + (IX() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.getSwanAppId() != null " + (Ji() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.get().getLaunchInfo() != null " + ((IX() == null || IX().uB() == null) ? false : true));
        }
        return (IX() == null || Ji() == null || IX().uB() == null) ? false : true;
    }

    public com.baidu.swan.apps.af.a.a Jk() {
        if (this.aNQ == null) {
            this.aNQ = new com.baidu.swan.apps.af.a.a();
        }
        return this.aNQ;
    }

    public boolean gf(String str) {
        if (TextUtils.isEmpty(str) || this.aNJ == null || this.aNJ.aOg == null) {
            return false;
        }
        return this.aNJ.aOg.go(str);
    }

    public boolean gg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.aNJ != null && this.aNJ.aOh != null && this.aNJ.aOh.aOu != null && this.aNJ.aOh.aOu.containsKey(str)) {
            if (DEBUG) {
                Log.i("SwanApp", "内存中查询分包是否存在信息");
            }
            return this.aNJ.aOh.aOu.get(str).booleanValue();
        }
        if (DEBUG) {
            Log.i("SwanApp", "DB中查询分包是否存在信息");
        }
        boolean m = com.baidu.swan.apps.database.subpackage.a.AV().m(this.id, getVersion(), str);
        if (m) {
            s(str, true);
            return m;
        }
        return m;
    }

    public void s(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.aNJ != null && this.aNJ.aOh != null && this.aNJ.aOh.aOu != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.aNJ.aOh.aOu.put(str, Boolean.valueOf(z));
        }
    }

    public String gh(String str) {
        if (this.aNJ == null || this.aNJ.aOh == null || this.aNJ.aOh.aOv == null) {
            return null;
        }
        return this.aNJ.aOh.aOv.get(str);
    }

    public String gi(String str) {
        if (this.aNJ == null || this.aNJ.aOi == null || this.aNJ.aOi.aOw == null) {
            return null;
        }
        return this.aNJ.aOi.aOw.get(str);
    }

    public String Jl() {
        com.baidu.swan.apps.v.b.b uB = uB();
        return uB != null ? dy(uB.mType) : "0";
    }

    private String dy(int i) {
        if (i == 0) {
            String str = this.ajt != null ? this.ajt.aug : "";
            if (TextUtils.isEmpty(str)) {
                str = getVersion();
            }
            String hN = aa.hN(str);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(hN) ? " version is empty " : hN);
            return hN;
        }
        return "0";
    }

    public void au(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.aNU == null) {
                this.aNU = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.aNU.put(str2, str);
        }
    }

    @Nullable
    public String gj(String str) {
        if (TextUtils.isEmpty(str) || this.aNU == null) {
            return null;
        }
        return this.aNU.get(str);
    }
}
