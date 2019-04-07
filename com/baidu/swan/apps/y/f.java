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
    private static volatile f aBT;
    private boolean aBQ;
    private String aBR;
    private JSONArray aBS;
    private volatile boolean aBU;
    private int aBV;
    private long aBW;
    private int aBX;
    private com.baidu.swan.apps.y.a aBY;
    private com.baidu.swan.apps.y.a aBZ;
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
        this.aBU = false;
        this.aBV = 0;
        this.aBX = 0;
        this.aBW = com.baidu.swan.apps.u.a.Cz().vc() * 1000;
        this.aBY = a.C0187a.fj("simple_parser");
        this.aBZ = a.C0187a.fj("hsv_parser");
        this.aBQ = com.baidu.swan.apps.u.a.Cz().vn();
    }

    public static f EP() {
        if (aBT == null) {
            synchronized (f.class) {
                if (aBT == null) {
                    aBT = new f();
                }
            }
        }
        return aBT;
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
            EU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {
        int aCd;

        private c(Looper looper) {
            super(looper);
            this.aCd = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.log("get message " + message.what);
            if (f.this.aBU) {
                f.this.log("aiapp is in background, ignore message");
                return;
            }
            switch (message.what) {
                case 1:
                    com.baidu.swan.apps.core.c.e uy = com.baidu.swan.apps.w.e.Ea().uy();
                    if (uy != null) {
                        com.baidu.swan.apps.core.c.b yN = uy.yN();
                        if (!(yN instanceof com.baidu.swan.apps.core.c.d)) {
                            f.this.log("top fragment is not aiappfragment");
                            return;
                        }
                        String yA = ((com.baidu.swan.apps.core.c.d) yN).yA();
                        if (TextUtils.isEmpty(yA)) {
                            if (this.aCd == 3) {
                                f.this.log("can't get slaveId after retrying 3 times");
                                this.aCd = 0;
                                return;
                            }
                            f.this.mHandler.sendEmptyMessageDelayed(1, 1000L);
                            return;
                        }
                        com.baidu.swan.apps.b.c.e eg = com.baidu.swan.apps.w.e.Ea().eg(yA);
                        if (eg != null) {
                            eg.a(f.this);
                        }
                        f.this.a(yN, yA);
                        this.aCd = 0;
                        return;
                    }
                    return;
                case 2:
                    final com.baidu.swan.apps.y.c cVar = (com.baidu.swan.apps.y.c) message.obj;
                    f.this.a(cVar, f.this.aBY, new a() { // from class: com.baidu.swan.apps.y.f.c.1
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
                    f.this.a(cVar2, f.this.aBY, new a() { // from class: com.baidu.swan.apps.y.f.c.2
                        @Override // com.baidu.swan.apps.y.f.a
                        public void bt(boolean z) {
                            if (z) {
                                f.this.log("simple error report");
                                f.this.a(cVar2);
                            }
                        }
                    });
                    if (f.this.ER()) {
                        f.this.a(cVar2, f.this.aBZ, new a() { // from class: com.baidu.swan.apps.y.f.c.3
                            @Override // com.baidu.swan.apps.y.f.a
                            public void bt(boolean z) {
                                if (z) {
                                    f.this.log("grid error report");
                                    f.this.a(cVar2, 28, f.this.EQ());
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
                            com.baidu.swan.apps.core.c.e uy2 = com.baidu.swan.apps.w.e.Ea().uy();
                            if (uy2 != null && uy2.yN() == null) {
                                f.this.a(new c.a().fk("loading").EO());
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
    public boolean EQ() {
        return new Random().nextInt(10) % 3 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar) {
        a(cVar, 19, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, int i, boolean z) {
        this.aBV++;
        String a2 = a(cVar, z);
        log(a2);
        com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(5L).M(i).hx(a2);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.IV() != null) {
            bVar = com.baidu.swan.apps.ae.b.IV().uA();
        }
        com.baidu.swan.apps.statistic.a.d cg = new com.baidu.swan.apps.statistic.a.d().a(hx).r(bVar).gS(com.baidu.swan.apps.statistic.c.dB(com.baidu.swan.apps.ae.b.us())).gT(com.baidu.swan.apps.ae.b.Jg()).gV(String.valueOf(this.aBX)).cg(false);
        if (ER() && this.aBS != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("launchlog", this.aBS);
                cg.ai(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.statistic.c.a(cg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ER() {
        return this.aBX == 1;
    }

    private String a(com.baidu.swan.apps.y.c cVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", cVar.getUrl());
            if (com.baidu.swan.apps.ae.b.IV() != null) {
                jSONObject.put("name", com.baidu.swan.apps.ae.b.IV().getName());
            } else {
                jSONObject.put("name", "UNKNOWN");
            }
            jSONObject.put("slaveId", this.aBR);
            jSONObject.put("errCnt", this.aBV);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("monitorCnt", this.aBX);
            jSONObject.put("firstPage", ER());
            jSONObject.put("zeus", com.baidu.swan.apps.u.a.CI().bs(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.Fa());
            if (z) {
                jSONObject.put("image", i(cVar.EN()));
            }
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.dJ(com.baidu.swan.apps.ae.b.us()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull a aVar2) {
        if (cVar == null || aVar == null) {
            aVar2.bt(false);
        } else if (TextUtils.equals(cVar.getToken(), this.aBR)) {
            log("start parse");
            aVar2.bt(aVar.a(cVar.EN(), cVar.getRect()));
        } else {
            log("page has changed from " + cVar.getToken() + " => " + this.aBR);
            aVar2.bt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.core.c.b bVar, String str) {
        String str2 = "";
        if (bVar instanceof com.baidu.swan.apps.core.c.d) {
            str2 = ((com.baidu.swan.apps.core.c.d) bVar).yD();
        }
        if (!TextUtils.equals(str, this.aBR)) {
            this.aBR = str;
            this.mHandler.postDelayed(new b(str2, str), this.aBW);
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
            if (TextUtils.equals(this.token, f.this.aBR)) {
                aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.f.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap Md;
                        Rect rect;
                        f.this.log("start full capture, slave id: " + b.this.token + "; url:" + b.this.url);
                        AbsoluteLayout eP = com.baidu.swan.apps.w.e.Ea().eP(b.this.token);
                        if (eP == null || eP.getWidth() <= 0 || eP.getHeight() <= 0) {
                            f.this.log("invalid webview " + eP);
                            return;
                        }
                        if (f.this.aBQ) {
                            f.this.log("get full screenshot");
                            Md = x.ah(eP);
                            int[] iArr = new int[2];
                            eP.getLocationOnScreen(iArr);
                            rect = new Rect(iArr[0], iArr[1], iArr[0] + eP.getMeasuredWidth(), eP.getMeasuredHeight() + iArr[1]);
                        } else {
                            f.this.log("get webview screenshot");
                            Md = x.Md();
                            rect = new Rect(0, 0, eP.getMeasuredWidth(), eP.getMeasuredHeight());
                        }
                        if (Md != null) {
                            com.baidu.swan.apps.y.c EO = new c.a().e(rect).fl(b.this.token).h(Md).EO();
                            Message obtainMessage = f.this.mHandler.obtainMessage(3);
                            obtainMessage.obj = EO;
                            f.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
            }
        }
    }

    private void g(@NonNull SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.c.e uy;
        if (this.mHandler == null) {
            iX();
        }
        if (this.mHandler != null && (uy = swanAppActivity.uy()) != null) {
            EU();
            com.baidu.swan.apps.core.c.b yN = uy.yN();
            if (yN == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (yN instanceof com.baidu.swan.apps.core.c.d) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000L);
                this.aBX++;
                log("page count: " + this.aBX);
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

    public void ES() {
        log("stop monitor");
        this.aBX = 0;
        this.aBV = 0;
        EU();
        this.aBS = null;
    }

    public void bo(boolean z) {
        log("this aiapp changes to " + (z ? "background" : "foreground"));
        if (z) {
            EU();
        }
        this.aBU = z;
    }

    private String ET() {
        return com.baidu.swan.apps.ae.b.IV() != null ? TAG + com.baidu.swan.apps.ae.b.IV().getName() : TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.d(ET(), str);
        }
    }

    private void EU() {
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

    public static void EV() {
        final com.baidu.swan.apps.core.c.b yN;
        com.baidu.swan.apps.core.c.e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy != null && (yN = uy.yN()) != null) {
            j.a(new Runnable() { // from class: com.baidu.swan.apps.y.f.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c EO = new c.a().h(x.ah(com.baidu.swan.apps.core.c.b.this.getView())).EO();
                    g CF = com.baidu.swan.apps.u.a.CF();
                    if (CF != null) {
                        CF.a(EO, null, null, null);
                    }
                }
            }, "feedback error page");
        }
    }

    public void i(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            if (this.aBS == null) {
                this.aBS = new JSONArray();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    log("stage " + jSONArray.getJSONObject(i).toString());
                    this.aBS.put(jSONArray.getJSONObject(i));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void fm(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.equals(str, "frame_create") || TextUtils.equals(str, "frame_new_intent")) {
                this.aBS = null;
            }
            log("stage " + str);
            try {
                if (this.aBS == null) {
                    this.aBS = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("actionId", str);
                jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
                this.aBS.put(jSONObject);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }
}
