package com.baidu.swan.games.n;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.storage.b.f;
import com.baidu.swan.apps.y.a;
import com.baidu.swan.apps.y.c;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends HandlerThread {
    private static volatile a bjK;
    private int aEF;
    private com.baidu.swan.apps.y.a aEI;
    private com.baidu.swan.apps.y.a aEJ;
    private volatile boolean bjL;
    private String bjM;
    private Handler mHandler;
    private long mStartTime;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0219a {
        void bE(boolean z);
    }

    private a() {
        super("SwanGamePageMonitor", 5);
        this.bjL = false;
        this.aEF = 0;
        this.aEI = a.C0206a.fB("solid_parser");
        this.aEJ = a.C0206a.fB("hsv_parser");
    }

    public static a SC() {
        if (bjK == null) {
            synchronized (a.class) {
                if (bjK == null) {
                    bjK = new a();
                }
            }
        }
        return bjK;
    }

    private void hZ() {
        Looper looper = getLooper();
        if (looper != null) {
            this.mHandler = new c(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {
        private c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a.this.log("get message " + message.what);
            if (a.this.bjL) {
                a.this.log("aiapp is in background, ignore message");
                return;
            }
            switch (message.what) {
                case 1:
                    e vN = com.baidu.swan.apps.w.e.GJ().vN();
                    if (vN != null) {
                        com.baidu.swan.apps.core.d.b Av = vN.Av();
                        if (!(Av instanceof h)) {
                            a.this.log("top fragment is not SwanGameFragment");
                            return;
                        } else {
                            a.this.jN(Av.toString());
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    final com.baidu.swan.apps.y.c cVar = (com.baidu.swan.apps.y.c) message.obj;
                    a.this.a(cVar, a.this.aEI, new InterfaceC0219a() { // from class: com.baidu.swan.games.n.a.c.1
                        @Override // com.baidu.swan.games.n.a.InterfaceC0219a
                        public void bE(boolean z) {
                            if (z) {
                                a.this.log("simple error report");
                                a.this.a(cVar);
                            }
                        }
                    });
                    a.this.a(cVar, a.this.aEJ, new InterfaceC0219a() { // from class: com.baidu.swan.games.n.a.c.2
                        @Override // com.baidu.swan.games.n.a.InterfaceC0219a
                        public void bE(boolean z) {
                            if (z) {
                                a.this.log("grid error report");
                                a.this.a(cVar, 28, a.this.HF());
                            }
                        }
                    });
                    return;
                case 4:
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.n.a.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e vN2 = com.baidu.swan.apps.w.e.GJ().vN();
                            if (vN2 != null && vN2.Av() == null) {
                                a.this.a(new c.a().fC("loading").HB());
                            }
                        }
                    }, 10000L);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HF() {
        String string = f.Ob().getString("screenshot_upload_switch", "1");
        if (DEBUG) {
            Log.d(TAG, "Screenshot upload cloud switch: status = " + string);
        }
        return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar) {
        a(cVar, 19, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, int i, boolean z) {
        this.aEF++;
        String a = a(cVar, z);
        log("detail=" + a);
        com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(i).ii(a);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.Mh() != null) {
            bVar = com.baidu.swan.apps.ae.b.Mh().vP();
        }
        d dVar = new d();
        dVar.k("errorList", com.baidu.swan.games.r.b.Tj().Tk());
        com.baidu.swan.apps.statistic.e.b(dVar.a(ii).s(bVar).hx(com.baidu.swan.apps.statistic.e.dQ(1)).hy(com.baidu.swan.apps.ae.b.Ms()).cy(false));
    }

    private String a(com.baidu.swan.apps.y.c cVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", cVar.getUrl());
            if (com.baidu.swan.apps.ae.b.Mh() != null) {
                jSONObject.put("name", com.baidu.swan.apps.ae.b.Mh().getName());
            } else {
                jSONObject.put("name", "UNKNOWN");
            }
            jSONObject.put("errCnt", this.aEF);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("net", SwanAppNetworkUtils.HU());
            if (z) {
                jSONObject.put("image", i(cVar.HA()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull InterfaceC0219a interfaceC0219a) {
        if (cVar == null || aVar == null) {
            interfaceC0219a.bE(false);
        } else if (TextUtils.equals(cVar.getToken(), this.bjM)) {
            log("start parse");
            interfaceC0219a.bE(aVar.a(cVar.HA(), cVar.getRect()));
        } else {
            log("page has changed from " + cVar.getToken() + " => " + this.bjM);
            interfaceC0219a.bE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jN(String str) {
        if (!TextUtils.equals(str, this.bjM)) {
            this.bjM = str;
            log("monitorNewPage token = " + str);
            this.mHandler.postDelayed(new b(str), 6000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final String token;

        private b(String str) {
            this.token = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.equals(this.token, a.this.bjM)) {
                a.this.log("FullMonitor invalid token = " + this.token + ";mCurToken = " + a.this.bjM);
            } else {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jO(b.this.token);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.n.a.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.Sm();
                            }
                        }, 500L);
                    }
                });
            }
        }
    }

    private void i(@NonNull SwanAppActivity swanAppActivity) {
        e vN;
        if (this.mHandler == null) {
            hZ();
        }
        if (this.mHandler != null && (vN = swanAppActivity.vN()) != null) {
            HK();
            com.baidu.swan.apps.core.d.b Av = vN.Av();
            if (Av == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (Av instanceof h) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000L);
            }
            this.mStartTime = System.currentTimeMillis();
        }
    }

    public void h(@NonNull SwanAppActivity swanAppActivity) {
        try {
            if (!isAlive()) {
                start();
            }
            log("start monitor");
            i(swanAppActivity);
        } catch (Error | Exception e) {
            e.printStackTrace();
        }
    }

    public void HI() {
        this.aEF = 0;
        this.bjM = null;
        log("stop monitor");
        HK();
    }

    public void bz(boolean z) {
        log("change to " + (z ? "background" : "foreground"));
        if (z) {
            HK();
        }
        this.bjL = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jO(final String str) {
        DuMixGameSurfaceView SD = SD();
        if (SD != null) {
            SD.a(new DuMixGameSurfaceView.b() { // from class: com.baidu.swan.games.n.a.1
                @Override // com.baidu.swan.games.glsurface.DuMixGameSurfaceView.b
                public void b(final int[] iArr, final int i, final int i2) {
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int[] c2 = a.this.c(iArr, i, i2);
                            if (c2 != null) {
                                Bitmap createBitmap = Bitmap.createBitmap(c2, i, i2, Bitmap.Config.ARGB_8888);
                                a.this.log("screenshot = " + createBitmap);
                                if (createBitmap != null) {
                                    com.baidu.swan.apps.y.c HB = new c.a().fD(str).h(createBitmap).HB();
                                    Message obtainMessage = a.this.mHandler.obtainMessage(3);
                                    obtainMessage.obj = HB;
                                    a.this.mHandler.sendMessage(obtainMessage);
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sm() {
        DuMixGameSurfaceView SD = SD();
        if (SD != null) {
            SD.Sm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] c(int[] iArr, int i, int i2) {
        if (iArr == null || i <= 0 || i2 <= 0 || iArr.length != i * i2) {
            return null;
        }
        int[] iArr2 = new int[i * i2];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = iArr[(i3 * i) + i4];
                iArr2[(((i2 - i3) - 1) * i) + i4] = (i5 & (-16711936)) | ((i5 << 16) & 16711680) | ((i5 >> 16) & 255);
            }
        }
        return iArr2;
    }

    private DuMixGameSurfaceView SD() {
        e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN == null) {
            return null;
        }
        h hVar = (h) vN.k(h.class);
        if (hVar == null || hVar.getView() == null) {
            return null;
        }
        View childAt = ((ViewGroup) hVar.getView()).getChildAt(0);
        if (childAt instanceof DuMixGameSurfaceView) {
            return (DuMixGameSurfaceView) childAt;
        }
        return null;
    }

    private String HJ() {
        return com.baidu.swan.apps.ae.b.Mh() != null ? TAG + com.baidu.swan.apps.ae.b.Mh().getName() : TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.d(HJ(), str);
        }
    }

    private void HK() {
        log("remove pending actions");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        Sm();
    }

    private String i(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }
}
