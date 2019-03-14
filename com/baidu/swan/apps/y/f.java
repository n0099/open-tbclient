package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b.b.g;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.y.a;
import com.baidu.swan.apps.y.c;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends HandlerThread implements com.baidu.swan.apps.core.e.b {
    private static volatile f aBQ;
    private boolean aBN;
    private String aBO;
    private JSONArray aBP;
    private volatile boolean aBR;
    private int aBS;
    private long aBT;
    private int aBU;
    private com.baidu.swan.apps.y.a aBV;
    private com.baidu.swan.apps.y.a aBW;
    private Handler mHandler;
    private long mStartTime;
    private static final String TAG = f.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void bt(boolean z);
    }

    private f() {
        super("SwanAppPageMonitor", 5);
        this.aBR = false;
        this.aBS = 0;
        this.aBU = 0;
        this.aBT = com.baidu.swan.apps.u.a.CB().vd() * 1000;
        this.aBV = a.C0187a.fi("simple_parser");
        this.aBW = a.C0187a.fi("hsv_parser");
        this.aBN = com.baidu.swan.apps.u.a.CB().vo();
    }

    public static f ER() {
        if (aBQ == null) {
            synchronized (f.class) {
                if (aBQ == null) {
                    aBQ = new f();
                }
            }
        }
        return aBQ;
    }

    private void iX() {
        Looper looper = getLooper();
        if (looper != null) {
            this.mHandler = new c(looper);
        }
    }

    @Override // com.baidu.swan.apps.core.e.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
            log("scroll (" + i3 + Constants.ACCEPT_TIME_SEPARATOR_SP + i4 + ") -> (" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + ")");
        } else {
            EW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {
        int aCa;

        private c(Looper looper) {
            super(looper);
            this.aCa = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.log("get message " + message.what);
            if (f.this.aBR) {
                f.this.log("aiapp is in background, ignore message");
                return;
            }
            switch (message.what) {
                case 1:
                    com.baidu.swan.apps.core.c.e uz = com.baidu.swan.apps.w.e.Ec().uz();
                    if (uz != null) {
                        com.baidu.swan.apps.core.c.b yO = uz.yO();
                        if (!(yO instanceof com.baidu.swan.apps.core.c.d)) {
                            f.this.log("top fragment is not aiappfragment");
                            return;
                        }
                        String yB = ((com.baidu.swan.apps.core.c.d) yO).yB();
                        if (TextUtils.isEmpty(yB)) {
                            if (this.aCa == 3) {
                                f.this.log("can't get slaveId after retrying 3 times");
                                this.aCa = 0;
                                return;
                            }
                            f.this.mHandler.sendEmptyMessageDelayed(1, 1000L);
                            return;
                        }
                        com.baidu.swan.apps.b.c.e ee = com.baidu.swan.apps.w.e.Ec().ee(yB);
                        if (ee != null) {
                            ee.a(f.this);
                        }
                        f.this.a(yO, yB);
                        this.aCa = 0;
                        return;
                    }
                    return;
                case 2:
                    final com.baidu.swan.apps.y.c cVar = (com.baidu.swan.apps.y.c) message.obj;
                    f.this.a(cVar, f.this.aBV, new a() { // from class: com.baidu.swan.apps.y.f.c.1
                        @Override // com.baidu.swan.apps.y.f.a
                        public void bt(boolean z) {
                            if (z) {
                                c.this.post(new b(cVar.getUrl(), cVar.getToken()));
                            }
                        }
                    });
                    return;
                case 3:
                    final com.baidu.swan.apps.y.c cVar2 = (com.baidu.swan.apps.y.c) message.obj;
                    f.this.a(cVar2, f.this.aBV, new a() { // from class: com.baidu.swan.apps.y.f.c.2
                        @Override // com.baidu.swan.apps.y.f.a
                        public void bt(boolean z) {
                            if (z) {
                                f.this.log("simple error report");
                                f.this.a(cVar2);
                            }
                        }
                    });
                    if (f.this.ET()) {
                        f.this.a(cVar2, f.this.aBW, new a() { // from class: com.baidu.swan.apps.y.f.c.3
                            @Override // com.baidu.swan.apps.y.f.a
                            public void bt(boolean z) {
                                if (z) {
                                    f.this.log("grid error report");
                                    f.this.a(cVar2, 28, f.this.ES());
                                }
                            }
                        });
                        return;
                    }
                    return;
                case 4:
                    f.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.y.f.c.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.core.c.e uz2 = com.baidu.swan.apps.w.e.Ec().uz();
                            if (uz2 != null && uz2.yO() == null) {
                                f.this.a(new c.a().fj("loading").EQ());
                            }
                        }
                    }, 10000L);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ES() {
        return new Random().nextInt(10) % 3 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar) {
        a(cVar, 19, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, int i, boolean z) {
        this.aBS++;
        String a2 = a(cVar, z);
        log(a2);
        com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(i).hw(a2);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.IX() != null) {
            bVar = com.baidu.swan.apps.ae.b.IX().uB();
        }
        com.baidu.swan.apps.statistic.a.d cg = new com.baidu.swan.apps.statistic.a.d().a(hw).r(bVar).gR(com.baidu.swan.apps.statistic.c.dC(com.baidu.swan.apps.ae.b.ut())).gS(com.baidu.swan.apps.ae.b.Ji()).gU(String.valueOf(this.aBU)).cg(false);
        if (ET() && this.aBP != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("launchlog", this.aBP);
                cg.ai(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.statistic.c.a(cg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ET() {
        return this.aBU == 1;
    }

    private String a(com.baidu.swan.apps.y.c cVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", cVar.getUrl());
            if (com.baidu.swan.apps.ae.b.IX() != null) {
                jSONObject.put("name", com.baidu.swan.apps.ae.b.IX().getName());
            } else {
                jSONObject.put("name", "UNKNOWN");
            }
            jSONObject.put("slaveId", this.aBO);
            jSONObject.put("errCnt", this.aBS);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("monitorCnt", this.aBU);
            jSONObject.put("firstPage", ET());
            jSONObject.put("zeus", com.baidu.swan.apps.u.a.CK().bs(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.Fc());
            if (z) {
                jSONObject.put("image", i(cVar.EP()));
            }
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.dK(com.baidu.swan.apps.ae.b.ut()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull a aVar2) {
        if (cVar == null || aVar == null) {
            aVar2.bt(false);
        } else if (TextUtils.equals(cVar.getToken(), this.aBO)) {
            log("start parse");
            aVar2.bt(aVar.a(cVar.EP(), cVar.getRect()));
        } else {
            log("page has changed from " + cVar.getToken() + " => " + this.aBO);
            aVar2.bt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.core.c.b bVar, String str) {
        String str2 = "";
        if (bVar instanceof com.baidu.swan.apps.core.c.d) {
            str2 = ((com.baidu.swan.apps.core.c.d) bVar).yE();
        }
        if (!TextUtils.equals(str, this.aBO)) {
            this.aBO = str;
            this.mHandler.postDelayed(new b(str2, str), this.aBT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final String token;
        final String url;

        private b(String str, String str2) {
            this.url = str;
            this.token = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.equals(this.token, f.this.aBO)) {
                aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.f.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap Mf;
                        Rect rect;
                        f.this.log("start full capture, slave id: " + b.this.token + "; url:" + b.this.url);
                        AbsoluteLayout eO = com.baidu.swan.apps.w.e.Ec().eO(b.this.token);
                        if (eO == null || eO.getWidth() <= 0 || eO.getHeight() <= 0) {
                            f.this.log("invalid webview " + eO);
                            return;
                        }
                        if (f.this.aBN) {
                            f.this.log("get full screenshot");
                            Mf = x.ah(eO);
                            int[] iArr = new int[2];
                            eO.getLocationOnScreen(iArr);
                            rect = new Rect(iArr[0], iArr[1], iArr[0] + eO.getMeasuredWidth(), eO.getMeasuredHeight() + iArr[1]);
                        } else {
                            f.this.log("get webview screenshot");
                            Mf = x.Mf();
                            rect = new Rect(0, 0, eO.getMeasuredWidth(), eO.getMeasuredHeight());
                        }
                        if (Mf != null) {
                            com.baidu.swan.apps.y.c EQ = new c.a().e(rect).fk(b.this.token).h(Mf).EQ();
                            Message obtainMessage = f.this.mHandler.obtainMessage(3);
                            obtainMessage.obj = EQ;
                            f.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
            }
        }
    }

    private void g(@NonNull SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.c.e uz;
        if (this.mHandler == null) {
            iX();
        }
        if (this.mHandler != null && (uz = swanAppActivity.uz()) != null) {
            EW();
            com.baidu.swan.apps.core.c.b yO = uz.yO();
            if (yO == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (yO instanceof com.baidu.swan.apps.core.c.d) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000L);
                this.aBU++;
                log("page count: " + this.aBU);
            }
            this.mStartTime = System.currentTimeMillis();
        }
    }

    public void h(@NonNull SwanAppActivity swanAppActivity) {
        try {
            if (!isAlive()) {
                start();
            }
            g(swanAppActivity);
        } catch (Error | Exception e) {
            e.printStackTrace();
        }
    }

    public void EU() {
        log("stop monitor");
        this.aBU = 0;
        this.aBS = 0;
        EW();
        this.aBP = null;
    }

    public void bo(boolean z) {
        log("this aiapp changes to " + (z ? "background" : "foreground"));
        if (z) {
            EW();
        }
        this.aBR = z;
    }

    private String EV() {
        return com.baidu.swan.apps.ae.b.IX() != null ? TAG + com.baidu.swan.apps.ae.b.IX().getName() : TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.d(EV(), str);
        }
    }

    private void EW() {
        log("remove pending actions");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    private String i(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static void EX() {
        final com.baidu.swan.apps.core.c.b yO;
        com.baidu.swan.apps.core.c.e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz != null && (yO = uz.yO()) != null) {
            j.a(new Runnable() { // from class: com.baidu.swan.apps.y.f.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c EQ = new c.a().h(x.ah(com.baidu.swan.apps.core.c.b.this.getView())).EQ();
                    g CH = com.baidu.swan.apps.u.a.CH();
                    if (CH != null) {
                        CH.a(EQ, null, null, null);
                    }
                }
            }, "feedback error page");
        }
    }

    public void i(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            if (this.aBP == null) {
                this.aBP = new JSONArray();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    log("stage " + jSONArray.getJSONObject(i).toString());
                    this.aBP.put(jSONArray.getJSONObject(i));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void fl(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.equals(str, "frame_create") || TextUtils.equals(str, "frame_new_intent")) {
                this.aBP = null;
            }
            log("stage " + str);
            try {
                if (this.aBP == null) {
                    this.aBP = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("actionId", str);
                jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
                this.aBP.put(jSONObject);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }
}
