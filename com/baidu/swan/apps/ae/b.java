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
    public static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    com.baidu.swan.apps.ae.a.c aNI;
    com.baidu.swan.games.o.a.a aNJ;
    private com.baidu.swan.apps.storage.c aNK;
    private com.baidu.swan.apps.setting.a aNL;
    private com.baidu.swan.apps.a.b aNM;
    private j aNN;
    private com.baidu.swan.games.network.b aNO;
    private com.baidu.swan.apps.af.a.a aNP;
    private com.baidu.swan.apps.media.audio.d aNQ;
    private k aNR;
    private d aNS;
    private Map<String, String> aNT;
    private com.baidu.swan.apps.v.b.b ajs;
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
        return e.Jo().aNW.get();
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
        this.aNP = new com.baidu.swan.apps.af.a.a();
        this.aNP.gq(str);
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
        if (this.aNS != null) {
            this.aNS.onDestroy();
        }
        com.baidu.swan.c.b.deleteFile(com.baidu.swan.apps.storage.b.gX(Ji()));
        if (this.aNQ != null) {
            this.aNQ.release();
        }
        if (this.aNP != null) {
            this.aNP.release();
        }
        if (this.aNR != null) {
            this.aNR.release();
        }
        this.aNK = null;
        this.aNL = null;
        this.aNO = null;
    }

    public void c(com.baidu.swan.apps.ae.a.c cVar) {
        this.aNI = cVar;
    }

    public com.baidu.swan.apps.ae.a.c IY() {
        return this.aNI;
    }

    public void a(com.baidu.swan.games.o.a.a aVar) {
        this.aNJ = aVar;
    }

    public com.baidu.swan.games.o.a.a IZ() {
        return this.aNJ;
    }

    public void o(com.baidu.swan.apps.v.b.b bVar) {
        this.ajs = bVar;
    }

    @Nullable
    public com.baidu.swan.apps.v.b.b uB() {
        return this.ajs;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public com.baidu.swan.apps.storage.c Ja() {
        if (this.aNK == null) {
            this.aNK = new com.baidu.swan.apps.storage.c(this);
        }
        return this.aNK;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a Jb() {
        if (this.aNL == null) {
            this.aNL = new com.baidu.swan.apps.setting.a(this);
        }
        return this.aNL;
    }

    public com.baidu.swan.apps.a.b Jc() {
        if (this.aNM == null) {
            this.aNM = new com.baidu.swan.apps.a.b(this);
        }
        return this.aNM;
    }

    public synchronized j Jd() {
        if (this.aNN == null) {
            this.aNN = new j(this);
        }
        return this.aNN;
    }

    public synchronized com.baidu.swan.games.network.b Je() {
        if (this.aNO == null) {
            this.aNO = com.baidu.swan.games.network.b.OF();
        }
        return this.aNO;
    }

    public k Jf() {
        if (this.aNR == null) {
            this.aNR = new k();
        }
        return this.aNR;
    }

    public com.baidu.swan.apps.media.audio.d Jg() {
        if (this.aNQ == null) {
            this.aNQ = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.aNQ;
    }

    @NonNull
    public d Jh() {
        if (this.aNS == null) {
            this.aNS = new d(this);
        }
        return this.aNS;
    }

    @Nullable
    @Deprecated
    public com.baidu.swan.apps.process.messaging.client.a BR() {
        return com.baidu.swan.apps.process.messaging.client.a.Gq();
    }

    public String getAppKey() {
        return (this.ajs == null || TextUtils.isEmpty(this.ajs.mAppKey)) ? "" : this.ajs.mAppKey;
    }

    @Nullable
    public static String Ji() {
        if (IX() == null) {
            return null;
        }
        return IX().id;
    }

    public static int ut() {
        if (IX() == null || IX().ajs == null) {
            return 0;
        }
        return IX().ajs.axW;
    }

    public boolean Jj() {
        return this.ajs != null && this.ajs.axW == 1;
    }

    public String getName() {
        return this.ajs == null ? "" : this.ajs.axC;
    }

    public String getVersion() {
        return this.ajs != null ? this.ajs.mVersion : "";
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
        if (this.aNP == null) {
            this.aNP = new com.baidu.swan.apps.af.a.a();
        }
        return this.aNP;
    }

    public boolean gf(String str) {
        if (TextUtils.isEmpty(str) || this.aNI == null || this.aNI.aOf == null) {
            return false;
        }
        return this.aNI.aOf.go(str);
    }

    public boolean gg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.aNI != null && this.aNI.aOg != null && this.aNI.aOg.aOt != null && this.aNI.aOg.aOt.containsKey(str)) {
            if (DEBUG) {
                Log.i("SwanApp", "内存中查询分包是否存在信息");
            }
            return this.aNI.aOg.aOt.get(str).booleanValue();
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
        if (!TextUtils.isEmpty(str) && this.aNI != null && this.aNI.aOg != null && this.aNI.aOg.aOt != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.aNI.aOg.aOt.put(str, Boolean.valueOf(z));
        }
    }

    public String gh(String str) {
        if (this.aNI == null || this.aNI.aOg == null || this.aNI.aOg.aOu == null) {
            return null;
        }
        return this.aNI.aOg.aOu.get(str);
    }

    public String gi(String str) {
        if (this.aNI == null || this.aNI.aOh == null || this.aNI.aOh.aOv == null) {
            return null;
        }
        return this.aNI.aOh.aOv.get(str);
    }

    public String Jl() {
        com.baidu.swan.apps.v.b.b uB = uB();
        return uB != null ? dy(uB.mType) : "0";
    }

    private String dy(int i) {
        if (i == 0) {
            String str = this.ajs != null ? this.ajs.auf : "";
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
            if (this.aNT == null) {
                this.aNT = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.aNT.put(str2, str);
        }
    }

    @Nullable
    public String gj(String str) {
        if (TextUtils.isEmpty(str) || this.aNT == null) {
            return null;
        }
        return this.aNT.get(str);
    }
}
