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
    com.baidu.swan.apps.ae.a.c aNN;
    com.baidu.swan.games.o.a.a aNO;
    private com.baidu.swan.apps.storage.c aNP;
    private com.baidu.swan.apps.setting.a aNQ;
    private com.baidu.swan.apps.a.b aNR;
    private j aNS;
    private com.baidu.swan.games.network.b aNT;
    private com.baidu.swan.apps.af.a.a aNU;
    private com.baidu.swan.apps.media.audio.d aNV;
    private k aNW;
    private d aNX;
    private Map<String, String> aNY;
    private com.baidu.swan.apps.v.b.b ajy;
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
        return e.Jm().aOb.get();
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
        this.aNU = new com.baidu.swan.apps.af.a.a();
        this.aNU.gr(str);
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
        if (this.aNX != null) {
            this.aNX.onDestroy();
        }
        com.baidu.swan.c.b.deleteFile(com.baidu.swan.apps.storage.b.gY(Jg()));
        if (this.aNV != null) {
            this.aNV.release();
        }
        if (this.aNU != null) {
            this.aNU.release();
        }
        if (this.aNW != null) {
            this.aNW.release();
        }
        this.aNP = null;
        this.aNQ = null;
        this.aNT = null;
    }

    public void c(com.baidu.swan.apps.ae.a.c cVar) {
        this.aNN = cVar;
    }

    public com.baidu.swan.apps.ae.a.c IW() {
        return this.aNN;
    }

    public void a(com.baidu.swan.games.o.a.a aVar) {
        this.aNO = aVar;
    }

    public com.baidu.swan.games.o.a.a IX() {
        return this.aNO;
    }

    public void o(com.baidu.swan.apps.v.b.b bVar) {
        this.ajy = bVar;
    }

    @Nullable
    public com.baidu.swan.apps.v.b.b uA() {
        return this.ajy;
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public com.baidu.swan.apps.storage.c IY() {
        if (this.aNP == null) {
            this.aNP = new com.baidu.swan.apps.storage.c(this);
        }
        return this.aNP;
    }

    @NonNull
    public com.baidu.swan.apps.setting.a IZ() {
        if (this.aNQ == null) {
            this.aNQ = new com.baidu.swan.apps.setting.a(this);
        }
        return this.aNQ;
    }

    public com.baidu.swan.apps.a.b Ja() {
        if (this.aNR == null) {
            this.aNR = new com.baidu.swan.apps.a.b(this);
        }
        return this.aNR;
    }

    public synchronized j Jb() {
        if (this.aNS == null) {
            this.aNS = new j(this);
        }
        return this.aNS;
    }

    public synchronized com.baidu.swan.games.network.b Jc() {
        if (this.aNT == null) {
            this.aNT = com.baidu.swan.games.network.b.OD();
        }
        return this.aNT;
    }

    public k Jd() {
        if (this.aNW == null) {
            this.aNW = new k();
        }
        return this.aNW;
    }

    public com.baidu.swan.apps.media.audio.d Je() {
        if (this.aNV == null) {
            this.aNV = new com.baidu.swan.apps.media.audio.d(this);
        }
        return this.aNV;
    }

    @NonNull
    public d Jf() {
        if (this.aNX == null) {
            this.aNX = new d(this);
        }
        return this.aNX;
    }

    @Nullable
    @Deprecated
    public com.baidu.swan.apps.process.messaging.client.a BP() {
        return com.baidu.swan.apps.process.messaging.client.a.Go();
    }

    public String getAppKey() {
        return (this.ajy == null || TextUtils.isEmpty(this.ajy.mAppKey)) ? "" : this.ajy.mAppKey;
    }

    @Nullable
    public static String Jg() {
        if (IV() == null) {
            return null;
        }
        return IV().id;
    }

    public static int us() {
        if (IV() == null || IV().ajy == null) {
            return 0;
        }
        return IV().ajy.ayb;
    }

    public boolean Jh() {
        return this.ajy != null && this.ajy.ayb == 1;
    }

    public String getName() {
        return this.ajy == null ? "" : this.ajy.axH;
    }

    public String getVersion() {
        return this.ajy != null ? this.ajy.mVersion : "";
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
        if (this.aNU == null) {
            this.aNU = new com.baidu.swan.apps.af.a.a();
        }
        return this.aNU;
    }

    public boolean gg(String str) {
        if (TextUtils.isEmpty(str) || this.aNN == null || this.aNN.aOk == null) {
            return false;
        }
        return this.aNN.aOk.gp(str);
    }

    public boolean gh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.aNN != null && this.aNN.aOl != null && this.aNN.aOl.aOy != null && this.aNN.aOl.aOy.containsKey(str)) {
            if (DEBUG) {
                Log.i("SwanApp", "内存中查询分包是否存在信息");
            }
            return this.aNN.aOl.aOy.get(str).booleanValue();
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
        if (!TextUtils.isEmpty(str) && this.aNN != null && this.aNN.aOl != null && this.aNN.aOl.aOy != null) {
            if (DEBUG) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.aNN.aOl.aOy.put(str, Boolean.valueOf(z));
        }
    }

    public String gi(String str) {
        if (this.aNN == null || this.aNN.aOl == null || this.aNN.aOl.aOz == null) {
            return null;
        }
        return this.aNN.aOl.aOz.get(str);
    }

    public String gj(String str) {
        if (this.aNN == null || this.aNN.aOm == null || this.aNN.aOm.aOA == null) {
            return null;
        }
        return this.aNN.aOm.aOA.get(str);
    }

    public String Jj() {
        com.baidu.swan.apps.v.b.b uA = uA();
        return uA != null ? dx(uA.mType) : "0";
    }

    private String dx(int i) {
        if (i == 0) {
            String str = this.ajy != null ? this.ajy.aul : "";
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
            if (this.aNY == null) {
                this.aNY = new HashMap();
            }
            if (DEBUG) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.aNY.put(str2, str);
        }
    }

    @Nullable
    public String gk(String str) {
        if (TextUtils.isEmpty(str) || this.aNY == null) {
            return null;
        }
        return this.aNY.get(str);
    }
}
