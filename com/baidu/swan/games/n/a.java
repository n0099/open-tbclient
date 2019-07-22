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
    private static volatile a bjm;
    private int aEh;
    private com.baidu.swan.apps.y.a aEk;
    private com.baidu.swan.apps.y.a aEl;
    private volatile boolean bjn;
    private String bjo;
    private Handler mHandler;
    private long mStartTime;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0205a {
        void bE(boolean z);
    }

    private a() {
        super("SwanGamePageMonitor", 5);
        this.bjn = false;
        this.aEh = 0;
        this.aEk = a.C0192a.fz("solid_parser");
        this.aEl = a.C0192a.fz("hsv_parser");
    }

    public static a Sy() {
        if (bjm == null) {
            synchronized (a.class) {
                if (bjm == null) {
                    bjm = new a();
                }
            }
        }
        return bjm;
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
            if (a.this.bjn) {
                a.this.log("aiapp is in background, ignore message");
                return;
            }
            switch (message.what) {
                case 1:
                    e vJ = com.baidu.swan.apps.w.e.GF().vJ();
                    if (vJ != null) {
                        com.baidu.swan.apps.core.d.b Ar = vJ.Ar();
                        if (!(Ar instanceof h)) {
                            a.this.log("top fragment is not SwanGameFragment");
                            return;
                        } else {
                            a.this.jL(Ar.toString());
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    final com.baidu.swan.apps.y.c cVar = (com.baidu.swan.apps.y.c) message.obj;
                    a.this.a(cVar, a.this.aEk, new InterfaceC0205a() { // from class: com.baidu.swan.games.n.a.c.1
                        @Override // com.baidu.swan.games.n.a.InterfaceC0205a
                        public void bE(boolean z) {
                            if (z) {
                                a.this.log("simple error report");
                                a.this.a(cVar);
                            }
                        }
                    });
                    a.this.a(cVar, a.this.aEl, new InterfaceC0205a() { // from class: com.baidu.swan.games.n.a.c.2
                        @Override // com.baidu.swan.games.n.a.InterfaceC0205a
                        public void bE(boolean z) {
                            if (z) {
                                a.this.log("grid error report");
                                a.this.a(cVar, 28, a.this.HB());
                            }
                        }
                    });
                    return;
                case 4:
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.n.a.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e vJ2 = com.baidu.swan.apps.w.e.GF().vJ();
                            if (vJ2 != null && vJ2.Ar() == null) {
                                a.this.a(new c.a().fA("loading").Hx());
                            }
                        }
                    }, 10000L);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HB() {
        String string = f.NX().getString("screenshot_upload_switch", "1");
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
        this.aEh++;
        String a = a(cVar, z);
        log("detail=" + a);
        com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(5L).aa(i).ig(a);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.Md() != null) {
            bVar = com.baidu.swan.apps.ae.b.Md().vL();
        }
        d dVar = new d();
        dVar.k("errorList", com.baidu.swan.games.r.b.Tf().Tg());
        com.baidu.swan.apps.statistic.e.b(dVar.a(ig).s(bVar).hv(com.baidu.swan.apps.statistic.e.dP(1)).hw(com.baidu.swan.apps.ae.b.Mo()).cy(false));
    }

    private String a(com.baidu.swan.apps.y.c cVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", cVar.getUrl());
            if (com.baidu.swan.apps.ae.b.Md() != null) {
                jSONObject.put("name", com.baidu.swan.apps.ae.b.Md().getName());
            } else {
                jSONObject.put("name", "UNKNOWN");
            }
            jSONObject.put("errCnt", this.aEh);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("net", SwanAppNetworkUtils.HQ());
            if (z) {
                jSONObject.put("image", i(cVar.Hw()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull InterfaceC0205a interfaceC0205a) {
        if (cVar == null || aVar == null) {
            interfaceC0205a.bE(false);
        } else if (TextUtils.equals(cVar.getToken(), this.bjo)) {
            log("start parse");
            interfaceC0205a.bE(aVar.a(cVar.Hw(), cVar.getRect()));
        } else {
            log("page has changed from " + cVar.getToken() + " => " + this.bjo);
            interfaceC0205a.bE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL(String str) {
        if (!TextUtils.equals(str, this.bjo)) {
            this.bjo = str;
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
            if (!TextUtils.equals(this.token, a.this.bjo)) {
                a.this.log("FullMonitor invalid token = " + this.token + ";mCurToken = " + a.this.bjo);
            } else {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jM(b.this.token);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.n.a.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.Si();
                            }
                        }, 500L);
                    }
                });
            }
        }
    }

    private void i(@NonNull SwanAppActivity swanAppActivity) {
        e vJ;
        if (this.mHandler == null) {
            hZ();
        }
        if (this.mHandler != null && (vJ = swanAppActivity.vJ()) != null) {
            HG();
            com.baidu.swan.apps.core.d.b Ar = vJ.Ar();
            if (Ar == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (Ar instanceof h) {
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

    public void HE() {
        this.aEh = 0;
        this.bjo = null;
        log("stop monitor");
        HG();
    }

    public void bz(boolean z) {
        log("change to " + (z ? "background" : "foreground"));
        if (z) {
            HG();
        }
        this.bjn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jM(final String str) {
        DuMixGameSurfaceView Sz = Sz();
        if (Sz != null) {
            Sz.a(new DuMixGameSurfaceView.b() { // from class: com.baidu.swan.games.n.a.1
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
                                    com.baidu.swan.apps.y.c Hx = new c.a().fB(str).h(createBitmap).Hx();
                                    Message obtainMessage = a.this.mHandler.obtainMessage(3);
                                    obtainMessage.obj = Hx;
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
    public void Si() {
        DuMixGameSurfaceView Sz = Sz();
        if (Sz != null) {
            Sz.Si();
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

    private DuMixGameSurfaceView Sz() {
        e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ == null) {
            return null;
        }
        h hVar = (h) vJ.k(h.class);
        if (hVar == null || hVar.getView() == null) {
            return null;
        }
        View childAt = ((ViewGroup) hVar.getView()).getChildAt(0);
        if (childAt instanceof DuMixGameSurfaceView) {
            return (DuMixGameSurfaceView) childAt;
        }
        return null;
    }

    private String HF() {
        return com.baidu.swan.apps.ae.b.Md() != null ? TAG + com.baidu.swan.apps.ae.b.Md().getName() : TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.d(HF(), str);
        }
    }

    private void HG() {
        log("remove pending actions");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        Si();
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
