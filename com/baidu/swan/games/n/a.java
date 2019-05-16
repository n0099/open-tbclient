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
    private static volatile a biz;
    private com.baidu.swan.apps.y.a aDC;
    private com.baidu.swan.apps.y.a aDD;
    private int aDz;
    private volatile boolean biA;
    private String biB;
    private Handler mHandler;
    private long mStartTime;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0208a {
        void bB(boolean z);
    }

    private a() {
        super("SwanGamePageMonitor", 5);
        this.biA = false;
        this.aDz = 0;
        this.aDC = a.C0195a.fv("solid_parser");
        this.aDD = a.C0195a.fv("hsv_parser");
    }

    public static a RF() {
        if (biz == null) {
            synchronized (a.class) {
                if (biz == null) {
                    biz = new a();
                }
            }
        }
        return biz;
    }

    private void hP() {
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
            if (a.this.biA) {
                a.this.log("aiapp is in background, ignore message");
                return;
            }
            switch (message.what) {
                case 1:
                    e vi = com.baidu.swan.apps.w.e.FV().vi();
                    if (vi != null) {
                        com.baidu.swan.apps.core.d.b zK = vi.zK();
                        if (!(zK instanceof h)) {
                            a.this.log("top fragment is not SwanGameFragment");
                            return;
                        } else {
                            a.this.jE(zK.toString());
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    final com.baidu.swan.apps.y.c cVar = (com.baidu.swan.apps.y.c) message.obj;
                    a.this.a(cVar, a.this.aDC, new InterfaceC0208a() { // from class: com.baidu.swan.games.n.a.c.1
                        @Override // com.baidu.swan.games.n.a.InterfaceC0208a
                        public void bB(boolean z) {
                            if (z) {
                                a.this.log("simple error report");
                                a.this.a(cVar);
                            }
                        }
                    });
                    a.this.a(cVar, a.this.aDD, new InterfaceC0208a() { // from class: com.baidu.swan.games.n.a.c.2
                        @Override // com.baidu.swan.games.n.a.InterfaceC0208a
                        public void bB(boolean z) {
                            if (z) {
                                a.this.log("grid error report");
                                a.this.a(cVar, 28, a.this.GQ());
                            }
                        }
                    });
                    return;
                case 4:
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.n.a.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e vi2 = com.baidu.swan.apps.w.e.FV().vi();
                            if (vi2 != null && vi2.zK() == null) {
                                a.this.a(new c.a().fw("loading").GM());
                            }
                        }
                    }, 10000L);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GQ() {
        String string = f.Ni().getString("screenshot_upload_switch", "1");
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
        this.aDz++;
        String a = a(cVar, z);
        log("detail=" + a);
        com.baidu.swan.apps.ak.a hZ = new com.baidu.swan.apps.ak.a().Y(5L).Z(i).hZ(a);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.Lq() != null) {
            bVar = com.baidu.swan.apps.ae.b.Lq().vk();
        }
        d dVar = new d();
        dVar.k("errorList", com.baidu.swan.games.r.b.Sm().Sn());
        com.baidu.swan.apps.statistic.e.b(dVar.a(hZ).s(bVar).hp(com.baidu.swan.apps.statistic.e.dM(1)).hq(com.baidu.swan.apps.ae.b.LB()).cv(false));
    }

    private String a(com.baidu.swan.apps.y.c cVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", cVar.getUrl());
            if (com.baidu.swan.apps.ae.b.Lq() != null) {
                jSONObject.put("name", com.baidu.swan.apps.ae.b.Lq().getName());
            } else {
                jSONObject.put("name", "UNKNOWN");
            }
            jSONObject.put("errCnt", this.aDz);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("net", SwanAppNetworkUtils.Hf());
            if (z) {
                jSONObject.put("image", i(cVar.GL()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull InterfaceC0208a interfaceC0208a) {
        if (cVar == null || aVar == null) {
            interfaceC0208a.bB(false);
        } else if (TextUtils.equals(cVar.getToken(), this.biB)) {
            log("start parse");
            interfaceC0208a.bB(aVar.a(cVar.GL(), cVar.getRect()));
        } else {
            log("page has changed from " + cVar.getToken() + " => " + this.biB);
            interfaceC0208a.bB(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jE(String str) {
        if (!TextUtils.equals(str, this.biB)) {
            this.biB = str;
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
            if (!TextUtils.equals(this.token, a.this.biB)) {
                a.this.log("FullMonitor invalid token = " + this.token + ";mCurToken = " + a.this.biB);
            } else {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jF(b.this.token);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.n.a.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.Rp();
                            }
                        }, 500L);
                    }
                });
            }
        }
    }

    private void i(@NonNull SwanAppActivity swanAppActivity) {
        e vi;
        if (this.mHandler == null) {
            hP();
        }
        if (this.mHandler != null && (vi = swanAppActivity.vi()) != null) {
            GV();
            com.baidu.swan.apps.core.d.b zK = vi.zK();
            if (zK == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (zK instanceof h) {
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

    public void GT() {
        this.aDz = 0;
        this.biB = null;
        log("stop monitor");
        GV();
    }

    public void bw(boolean z) {
        log("change to " + (z ? "background" : "foreground"));
        if (z) {
            GV();
        }
        this.biA = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jF(final String str) {
        DuMixGameSurfaceView RG = RG();
        if (RG != null) {
            RG.a(new DuMixGameSurfaceView.b() { // from class: com.baidu.swan.games.n.a.1
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
                                    com.baidu.swan.apps.y.c GM = new c.a().fx(str).h(createBitmap).GM();
                                    Message obtainMessage = a.this.mHandler.obtainMessage(3);
                                    obtainMessage.obj = GM;
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
    public void Rp() {
        DuMixGameSurfaceView RG = RG();
        if (RG != null) {
            RG.Rp();
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

    private DuMixGameSurfaceView RG() {
        e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null) {
            return null;
        }
        h hVar = (h) vi.k(h.class);
        if (hVar == null || hVar.getView() == null) {
            return null;
        }
        View childAt = ((ViewGroup) hVar.getView()).getChildAt(0);
        if (childAt instanceof DuMixGameSurfaceView) {
            return (DuMixGameSurfaceView) childAt;
        }
        return null;
    }

    private String GU() {
        return com.baidu.swan.apps.ae.b.Lq() != null ? TAG + com.baidu.swan.apps.ae.b.Lq().getName() : TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.d(GU(), str);
        }
    }

    private void GV() {
        log("remove pending actions");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        Rp();
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
