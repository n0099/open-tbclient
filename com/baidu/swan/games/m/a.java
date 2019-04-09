package com.baidu.swan.games.m;

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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.core.c.e;
import com.baidu.swan.apps.core.c.h;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.y.a;
import com.baidu.swan.apps.y.c;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends HandlerThread {
    private static volatile a bej;
    private String aBS;
    private int aBW;
    private com.baidu.swan.apps.y.a aBZ;
    private com.baidu.swan.apps.y.a aCa;
    private volatile boolean bek;
    private Handler mHandler;
    private long mStartTime;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0198a {
        void bt(boolean z);
    }

    private a() {
        super("SwanGamePageMonitor", 5);
        this.bek = false;
        this.aBW = 0;
        this.aBZ = a.C0187a.fj("solid_parser");
        this.aCa = a.C0187a.fj("hsv_parser");
    }

    public static a OA() {
        if (bej == null) {
            synchronized (a.class) {
                if (bej == null) {
                    bej = new a();
                }
            }
        }
        return bej;
    }

    private void iX() {
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
            if (a.this.bek) {
                a.this.log("aiapp is in background, ignore message");
                return;
            }
            switch (message.what) {
                case 1:
                    e uy = com.baidu.swan.apps.w.e.Ea().uy();
                    if (uy != null) {
                        com.baidu.swan.apps.core.c.b yN = uy.yN();
                        if (!(yN instanceof h)) {
                            a.this.log("top fragment is not SwanGameFragment");
                            return;
                        } else {
                            a.this.iS(yN.toString());
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    final com.baidu.swan.apps.y.c cVar = (com.baidu.swan.apps.y.c) message.obj;
                    a.this.a(cVar, a.this.aBZ, new InterfaceC0198a() { // from class: com.baidu.swan.games.m.a.c.1
                        @Override // com.baidu.swan.games.m.a.InterfaceC0198a
                        public void bt(boolean z) {
                            if (z) {
                                a.this.log("simple error report");
                                a.this.a(cVar);
                            }
                        }
                    });
                    a.this.a(cVar, a.this.aCa, new InterfaceC0198a() { // from class: com.baidu.swan.games.m.a.c.2
                        @Override // com.baidu.swan.games.m.a.InterfaceC0198a
                        public void bt(boolean z) {
                            if (z) {
                                a.this.log("grid error report");
                                a.this.a(cVar, 28, a.this.EQ());
                            }
                        }
                    });
                    return;
                case 4:
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.m.a.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e uy2 = com.baidu.swan.apps.w.e.Ea().uy();
                            if (uy2 != null && uy2.yN() == null) {
                                a.this.a(new c.a().fk("loading").EO());
                            }
                        }
                    }, 10000L);
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
        this.aBW++;
        String a = a(cVar, z);
        log("detail=" + a);
        com.baidu.swan.apps.ak.a hx = new com.baidu.swan.apps.ak.a().L(5L).M(i).hx(a);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.IV() != null) {
            bVar = com.baidu.swan.apps.ae.b.IV().uA();
        }
        com.baidu.swan.apps.statistic.c.a(new d().a(hx).r(bVar).gS(com.baidu.swan.apps.statistic.c.dB(1)).gT(com.baidu.swan.apps.ae.b.Jg()).cg(false));
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
            jSONObject.put("errCnt", this.aBW);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("net", SwanAppNetworkUtils.Fa());
            if (z) {
                jSONObject.put("image", i(cVar.EN()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull InterfaceC0198a interfaceC0198a) {
        if (cVar == null || aVar == null) {
            interfaceC0198a.bt(false);
        } else if (TextUtils.equals(cVar.getToken(), this.aBS)) {
            log("start parse");
            interfaceC0198a.bt(aVar.a(cVar.EN(), cVar.getRect()));
        } else {
            log("page has changed from " + cVar.getToken() + " => " + this.aBS);
            interfaceC0198a.bt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(String str) {
        if (!TextUtils.equals(str, this.aBS)) {
            this.aBS = str;
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
            if (!TextUtils.equals(this.token, a.this.aBS)) {
                a.this.log("FullMonitor invalid token = " + this.token + ";mCurToken = " + a.this.aBS);
            } else {
                aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.iT(b.this.token);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.m.a.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.Op();
                            }
                        }, 500L);
                    }
                });
            }
        }
    }

    private void g(@NonNull SwanAppActivity swanAppActivity) {
        e uy;
        if (this.mHandler == null) {
            iX();
        }
        if (this.mHandler != null && (uy = swanAppActivity.uy()) != null) {
            EU();
            com.baidu.swan.apps.core.c.b yN = uy.yN();
            if (yN == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (yN instanceof h) {
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
            g(swanAppActivity);
        } catch (Error | Exception e) {
            e.printStackTrace();
        }
    }

    public void ES() {
        this.aBW = 0;
        this.aBS = null;
        log("stop monitor");
        EU();
    }

    public void bo(boolean z) {
        log("change to " + (z ? "background" : "foreground"));
        if (z) {
            EU();
        }
        this.bek = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(final String str) {
        DuMixGameSurfaceView OB = OB();
        if (OB != null) {
            OB.a(new DuMixGameSurfaceView.b() { // from class: com.baidu.swan.games.m.a.1
                @Override // com.baidu.swan.games.glsurface.DuMixGameSurfaceView.b
                public void b(final int[] iArr, final int i, final int i2) {
                    aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int[] c2 = a.this.c(iArr, i, i2);
                            if (c2 != null) {
                                Bitmap createBitmap = Bitmap.createBitmap(c2, i, i2, Bitmap.Config.ARGB_8888);
                                a.this.log("screenshot = " + createBitmap);
                                if (createBitmap != null) {
                                    com.baidu.swan.apps.y.c EO = new c.a().fl(str).h(createBitmap).EO();
                                    Message obtainMessage = a.this.mHandler.obtainMessage(3);
                                    obtainMessage.obj = EO;
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
    public void Op() {
        DuMixGameSurfaceView OB = OB();
        if (OB != null) {
            OB.Op();
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

    private DuMixGameSurfaceView OB() {
        e uy = com.baidu.swan.apps.w.e.Ea().uy();
        if (uy == null) {
            return null;
        }
        h hVar = (h) uy.l(h.class);
        if (hVar == null || hVar.getView() == null) {
            return null;
        }
        View childAt = ((ViewGroup) hVar.getView()).getChildAt(0);
        if (childAt instanceof DuMixGameSurfaceView) {
            return (DuMixGameSurfaceView) childAt;
        }
        return null;
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
        Op();
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
