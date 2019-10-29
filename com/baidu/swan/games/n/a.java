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
    private static volatile a bCy;
    private int aXU;
    private com.baidu.swan.apps.y.a aXX;
    private com.baidu.swan.apps.y.a aXY;
    private String bCA;
    private volatile boolean bCz;
    private Handler mHandler;
    private long mStartTime;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0251a {
        void onResult(boolean z);
    }

    private a() {
        super("SwanGamePageMonitor", 5);
        this.bCz = false;
        this.aXU = 0;
        this.aXX = a.C0238a.gf("solid_parser");
        this.aXY = a.C0238a.gf("hsv_parser");
    }

    public static a Xt() {
        if (bCy == null) {
            synchronized (a.class) {
                if (bCy == null) {
                    bCy = new a();
                }
            }
        }
        return bCy;
    }

    private void initHandler() {
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
            if (a.this.bCz) {
                a.this.log("aiapp is in background, ignore message");
                return;
            }
            switch (message.what) {
                case 1:
                    e AH = com.baidu.swan.apps.w.e.LD().AH();
                    if (AH != null) {
                        com.baidu.swan.apps.core.d.b Fq = AH.Fq();
                        if (!(Fq instanceof h)) {
                            a.this.log("top fragment is not SwanGameFragment");
                            return;
                        } else {
                            a.this.kp(Fq.toString());
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    final com.baidu.swan.apps.y.c cVar = (com.baidu.swan.apps.y.c) message.obj;
                    a.this.a(cVar, a.this.aXX, new InterfaceC0251a() { // from class: com.baidu.swan.games.n.a.c.1
                        @Override // com.baidu.swan.games.n.a.InterfaceC0251a
                        public void onResult(boolean z) {
                            if (z) {
                                a.this.log("simple error report");
                                a.this.a(cVar);
                            }
                        }
                    });
                    a.this.a(cVar, a.this.aXY, new InterfaceC0251a() { // from class: com.baidu.swan.games.n.a.c.2
                        @Override // com.baidu.swan.games.n.a.InterfaceC0251a
                        public void onResult(boolean z) {
                            if (z) {
                                a.this.log("grid error report");
                                a.this.a(cVar, 28, a.this.Mz());
                            }
                        }
                    });
                    return;
                case 4:
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.n.a.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e AH2 = com.baidu.swan.apps.w.e.LD().AH();
                            if (AH2 != null && AH2.Fq() == null) {
                                a.this.a(new c.a().gg("loading").Mv());
                            }
                        }
                    }, 10000L);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Mz() {
        String string = f.SR().getString("screenshot_upload_switch", "1");
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
        this.aXU++;
        String a = a(cVar, z);
        log("detail=" + a);
        com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(5L).at(i).iL(a);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.QZ() != null) {
            bVar = com.baidu.swan.apps.ae.b.QZ().AJ();
        }
        d dVar = new d();
        dVar.h("errorList", com.baidu.swan.games.r.b.Ya().Yb());
        com.baidu.swan.apps.statistic.e.b(dVar.a(iL).s(bVar).ia(com.baidu.swan.apps.statistic.e.eL(1)).ib(com.baidu.swan.apps.ae.b.Rk()).cP(false));
    }

    private String a(com.baidu.swan.apps.y.c cVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", cVar.getUrl());
            if (com.baidu.swan.apps.ae.b.QZ() != null) {
                jSONObject.put("name", com.baidu.swan.apps.ae.b.QZ().getName());
            } else {
                jSONObject.put("name", "UNKNOWN");
            }
            jSONObject.put("errCnt", this.aXU);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("net", SwanAppNetworkUtils.MO());
            if (z) {
                jSONObject.put("image", k(cVar.Mu()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull InterfaceC0251a interfaceC0251a) {
        if (cVar == null || aVar == null) {
            interfaceC0251a.onResult(false);
        } else if (TextUtils.equals(cVar.getToken(), this.bCA)) {
            log("start parse");
            interfaceC0251a.onResult(aVar.a(cVar.Mu(), cVar.getRect()));
        } else {
            log("page has changed from " + cVar.getToken() + " => " + this.bCA);
            interfaceC0251a.onResult(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp(String str) {
        if (!TextUtils.equals(str, this.bCA)) {
            this.bCA = str;
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
            if (!TextUtils.equals(this.token, a.this.bCA)) {
                a.this.log("FullMonitor invalid token = " + this.token + ";mCurToken = " + a.this.bCA);
            } else {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.kq(b.this.token);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.n.a.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.Xd();
                            }
                        }, 500L);
                    }
                });
            }
        }
    }

    private void i(@NonNull SwanAppActivity swanAppActivity) {
        e AH;
        if (this.mHandler == null) {
            initHandler();
        }
        if (this.mHandler != null && (AH = swanAppActivity.AH()) != null) {
            ME();
            com.baidu.swan.apps.core.d.b Fq = AH.Fq();
            if (Fq == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (Fq instanceof h) {
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

    public void MC() {
        this.aXU = 0;
        this.bCA = null;
        log("stop monitor");
        ME();
    }

    public void bR(boolean z) {
        log("change to " + (z ? "background" : "foreground"));
        if (z) {
            ME();
        }
        this.bCz = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq(final String str) {
        DuMixGameSurfaceView Xu = Xu();
        if (Xu != null) {
            Xu.a(new DuMixGameSurfaceView.b() { // from class: com.baidu.swan.games.n.a.1
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
                                    com.baidu.swan.apps.y.c Mv = new c.a().gh(str).j(createBitmap).Mv();
                                    Message obtainMessage = a.this.mHandler.obtainMessage(3);
                                    obtainMessage.obj = Mv;
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
    public void Xd() {
        DuMixGameSurfaceView Xu = Xu();
        if (Xu != null) {
            Xu.Xd();
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

    private DuMixGameSurfaceView Xu() {
        e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH == null) {
            return null;
        }
        h hVar = (h) AH.i(h.class);
        if (hVar == null || hVar.getView() == null) {
            return null;
        }
        View childAt = ((ViewGroup) hVar.getView()).getChildAt(0);
        if (childAt instanceof DuMixGameSurfaceView) {
            return (DuMixGameSurfaceView) childAt;
        }
        return null;
    }

    private String MD() {
        return com.baidu.swan.apps.ae.b.QZ() != null ? TAG + com.baidu.swan.apps.ae.b.QZ().getName() : TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.d(MD(), str);
        }
    }

    private void ME() {
        log("remove pending actions");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        Xd();
    }

    private String k(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }
}
