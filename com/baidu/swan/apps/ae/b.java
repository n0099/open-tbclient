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
    com.baidu.swan.apps.ae.a.c aNM;
    com.baidu.swan.games.o.a.a aNN;
    private com.baidu.swan.apps.storage.c aNO;
    private com.baidu.swan.apps.setting.a aNP;
    private com.baidu.swan.apps.a.b aNQ;
    private j aNR;
    private com.baidu.swan.games.network.b aNS;
    private com.baidu.swan.apps.af.a.a aNT;
    private com.baidu.swan.apps.media.audio.d aNU;
    private k aNV;
    private d aNW;
    private Map<String, String> aNX;
    private com.baidu.swan.apps.v.b.b ajx;
    public final String id;
    private Activity mActivity;

    /* loaded from: classes2.dex */
    static abstract class a implements com.baidu.swan.apps.an.c.b<b> {
        abstract String id();

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.an.c.b
        /* renamed from: Jk */
        public b uR() {
            String id = id();
            if (TextUtils.isEmpty(id)) {
                return null;
            }
            return new b(id);
        }
    }

    @Nullable
    public static b IV() {
        return e.Jm().aOa.get();
    }

    @Deprecated
    public static synchronized void n(com.baidu.swan.apps.v.b.b bVar) {
        synchronized (b.class) {
            e.Jm().p(bVar);
        }
    }

    @Deprecated
    public static synchronized void terminate() {
        synchronized (b.class) {
            e.Jm().terminate();
        }
    }

    public void purge() {
        IZ().JS();
        IY().clear(true);
    }

    private b(String str) {
        super(AppRuntime.getApplication());
        this.id = str;
        this.aNT = new com.baidu.swan.apps.af.a.a();
        this.aNT.gr(str);
    }

    public void H(Activity activity) {
        this.mActivity = activity;
    }

    public void I(Activity activity) {
        IZ().I(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        if (DEBUG) {
            Log.d("SwanApp", "——> release client Id " + Jg());
        }
        if (this.aNW != null) {
            this.aNW.onDestroy();
        }
        com.baidu.swan.c.b.deleteFile(com.baidu.swan.apps.storage.b.gY(Jg()));
        if (this.aNU != null) {
            this.aNU.release();
        }
        if (this.aNT != null) {
            this.aNT.release();
        }
        if (this.aNV != null) {
            this.aNV.release();
        }
        this.aNO = null;
        this.aNP = null;
        this.aNS = null;
    }

    public void c(com.baidu.swan.apps.ae.a.c cVar) {
        this.aNM = cVar;
    }

    public com.baidu.swan.apps.ae.a.c IW() {
        return this.aNM;
    }

    public void a(com.baidu.swan.games.o.a.a aVar) {
        this.aNN = aVar;
    }

    public com.baidu.swan.games.o.a.a IX() {
        return this.aNN;
    }

    public void o(com.baidu.swan.apps.v.b.b bVar) {
        this.ajx = bVar;
    }

    @Nullable
    public com.baidu.swan.apps.v.b.b uA() {
        return this.ajx;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public com.baidu.swan.apps.storage.c IY() {
        if (this.aNO == null) {
            this.aNO = new com.baidu.swan.apps.storage.c(this);
        }
        return this.aNO;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a IZ() {
        if (this.aNP == null) {
            this.aNP = new com.baidu.swan.apps.setting.a(this);
        }
        return this.aNP;
    }

    public com.baidu.swan.apps.a.b Ja() {
        if (this.aNQ == null) {
            this.aNQ = new com.baidu.swan.apps.a.b(this);
        }
        return this.aNQ;
    }

    public synchronized j Jb() {
        if (this.aNR == null) {
            this.aNR = new j(this);
        }
        return this.aNR;
    }

    public synchronized com.baidu.swan.games.network.b Jc() {
        if (this.aNS == null) {
            this.aNS = com.baidu.swan.games.network.b.OD();
        }
        return this.aNS;
    }

    public k Jd() {
        if (this.aNV == null) {
            this.aNV = new k();
        }
        return this.aNV;
    }

    public com.baidu.swan.apps.media.audio.d Je() {
        if (this.aNU == null) {
            this.aNU = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.aNU;
    }

    @NonNull
    public d Jf() {
        if (this.aNW == null) {
            this.aNW = new d(this);
        }
        return this.aNW;
    }

    @Nullable
    @Deprecated
    public com.baidu.swan.apps.process.messaging.client.a BP() {
        return com.baidu.swan.apps.process.messaging.client.a.Go();
    }

    public String getAppKey() {
        return (this.ajx == null || TextUtils.isEmpty(this.ajx.mAppKey)) ? "" : this.ajx.mAppKey;
    }

    @Nullable
    public static String Jg() {
        if (IV() == null) {
            return null;
        }
        return IV().id;
    }

    public static int us() {
        if (IV() == null || IV().ajx == null) {
            return 0;
        }
        return IV().ajx.aya;
    }

    public boolean Jh() {
        return this.ajx != null && this.ajx.aya == 1;
    }

    public String getName() {
        return this.ajx == null ? "" : this.ajx.axG;
    }

    public String getVersion() {
        return this.ajx != null ? this.ajx.mVersion : "";
    }

    public static boolean isDataValid() {
        if (DEBUG) {
            Log.d("SwanApp isDataValid:", "SwanApp.get() != null " + (IV() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.getSwanAppId() != null " + (Jg() != null));
            Log.d("SwanApp isDataValid:", "SwanApp.get().getLaunchInfo() != null " + ((IV() == null || IV().uA() == null) ? false : true));
        }
        return (IV() == null || Jg() == null || IV().uA() == null) ? false : true;
    }

    public com.baidu.swan.apps.af.a.a Ji() {
        if (this.aNT == null) {
            this.aNT = new com.baidu.swan.apps.af.a.a();
        }
        return this.aNT;
    }

    public boolean gg(String str) {
        if (TextUtils.isEmpty(str) || this.aNM == null || this.aNM.aOj == null) {
            return false;
        }
        return this.aNM.aOj.gp(str);
    }

    public boolean gh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.aNM != null && this.aNM.aOk != null && this.aNM.aOk.aOx != null && this.aNM.aOk.aOx.containsKey(str)) {
            if (DEBUG) {
                Log.i("SwanApp", "内存中查询分包是否存在信息");
            }
            return this.aNM.aOk.aOx.get(str).booleanValue();
        }
        if (DEBUG) {
            Log.i("SwanApp", "DB中查询分包是否存在信息");
        }
        boolean m = com.baidu.swan.apps.database.subpackage.a.AT().m(this.id, getVersion(), str);
        if (m) {
            s(str, true);
            return m;
        }
        return m;
    }

    public void s(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.aNM != null && this.aNM.aOk != null && this.aNM.aOk.aOx != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.aNM.aOk.aOx.put(str, Boolean.valueOf(z));
        }
    }

    public String gi(String str) {
        if (this.aNM == null || this.aNM.aOk == null || this.aNM.aOk.aOy == null) {
            return null;
        }
        return this.aNM.aOk.aOy.get(str);
    }

    public String gj(String str) {
        if (this.aNM == null || this.aNM.aOl == null || this.aNM.aOl.aOz == null) {
            return null;
        }
        return this.aNM.aOl.aOz.get(str);
    }

    public String Jj() {
        com.baidu.swan.apps.v.b.b uA = uA();
        return uA != null ? dx(uA.mType) : "0";
    }

    private String dx(int i) {
        if (i == 0) {
            String str = this.ajx != null ? this.ajx.auk : "";
            if (TextUtils.isEmpty(str)) {
                str = getVersion();
            }
            String hO = aa.hO(str);
            com.baidu.swan.apps.console.c.e("SwanApp", TextUtils.isEmpty(hO) ? " version is empty " : hO);
            return hO;
        }
        return "0";
    }

    public void au(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.aNX == null) {
                this.aNX = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.aNX.put(str2, str);
        }
    }

    @Nullable
    public String gk(String str) {
        if (TextUtils.isEmpty(str) || this.aNX == null) {
            return null;
        }
        return this.aNX.get(str);
    }
}
