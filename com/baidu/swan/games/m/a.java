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
    private static volatile a bed;
    private String aBN;
    private int aBR;
    private com.baidu.swan.apps.y.a aBU;
    private com.baidu.swan.apps.y.a aBV;
    private volatile boolean bee;
    private Handler mHandler;
    private long mStartTime;
    private static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0169a {
        void bt(boolean z);
    }

    private a() {
        super("SwanGamePageMonitor", 5);
        this.bee = false;
        this.aBR = 0;
        this.aBU = a.C0158a.fi("solid_parser");
        this.aBV = a.C0158a.fi("hsv_parser");
    }

    public static a OC() {
        if (bed == null) {
            synchronized (a.class) {
                if (bed == null) {
                    bed = new a();
                }
            }
        }
        return bed;
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
            if (a.this.bee) {
                a.this.log("aiapp is in background, ignore message");
                return;
            }
            switch (message.what) {
                case 1:
                    e uz = com.baidu.swan.apps.w.e.Ec().uz();
                    if (uz != null) {
                        com.baidu.swan.apps.core.c.b yO = uz.yO();
                        if (!(yO instanceof h)) {
                            a.this.log("top fragment is not SwanGameFragment");
                            return;
                        } else {
                            a.this.iR(yO.toString());
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    final com.baidu.swan.apps.y.c cVar = (com.baidu.swan.apps.y.c) message.obj;
                    a.this.a(cVar, a.this.aBU, new InterfaceC0169a() { // from class: com.baidu.swan.games.m.a.c.1
                        @Override // com.baidu.swan.games.m.a.InterfaceC0169a
                        public void bt(boolean z) {
                            if (z) {
                                a.this.log("simple error report");
                                a.this.a(cVar);
                            }
                        }
                    });
                    a.this.a(cVar, a.this.aBV, new InterfaceC0169a() { // from class: com.baidu.swan.games.m.a.c.2
                        @Override // com.baidu.swan.games.m.a.InterfaceC0169a
                        public void bt(boolean z) {
                            if (z) {
                                a.this.log("grid error report");
                                a.this.a(cVar, 28, a.this.ES());
                            }
                        }
                    });
                    return;
                case 4:
                    a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.m.a.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e uz2 = com.baidu.swan.apps.w.e.Ec().uz();
                            if (uz2 != null && uz2.yO() == null) {
                                a.this.a(new c.a().fj("loading").EQ());
                            }
                        }
                    }, 10000L);
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
        this.aBR++;
        String a = a(cVar, z);
        log("detail=" + a);
        com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(5L).M(i).hw(a);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.IX() != null) {
            bVar = com.baidu.swan.apps.ae.b.IX().uB();
        }
        com.baidu.swan.apps.statistic.c.a(new d().a(hw).r(bVar).gR(com.baidu.swan.apps.statistic.c.dC(1)).gS(com.baidu.swan.apps.ae.b.Ji()).cg(false));
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
            jSONObject.put("errCnt", this.aBR);
            jSONObject.put("startTime", this.mStartTime);
            jSONObject.put("net", SwanAppNetworkUtils.Fc());
            if (z) {
                jSONObject.put("image", i(cVar.EP()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull InterfaceC0169a interfaceC0169a) {
        if (cVar == null || aVar == null) {
            interfaceC0169a.bt(false);
        } else if (TextUtils.equals(cVar.getToken(), this.aBN)) {
            log("start parse");
            interfaceC0169a.bt(aVar.a(cVar.EP(), cVar.getRect()));
        } else {
            log("page has changed from " + cVar.getToken() + " => " + this.aBN);
            interfaceC0169a.bt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iR(String str) {
        if (!TextUtils.equals(str, this.aBN)) {
            this.aBN = str;
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
            if (!TextUtils.equals(this.token, a.this.aBN)) {
                a.this.log("FullMonitor invalid token = " + this.token + ";mCurToken = " + a.this.aBN);
            } else {
                aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.m.a.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.iS(b.this.token);
                        a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.games.m.a.b.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.Or();
                            }
                        }, 500L);
                    }
                });
            }
        }
    }

    private void g(@NonNull SwanAppActivity swanAppActivity) {
        e uz;
        if (this.mHandler == null) {
            iX();
        }
        if (this.mHandler != null && (uz = swanAppActivity.uz()) != null) {
            EW();
            com.baidu.swan.apps.core.c.b yO = uz.yO();
            if (yO == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (yO instanceof h) {
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

    public void EU() {
        this.aBR = 0;
        this.aBN = null;
        log("stop monitor");
        EW();
    }

    public void bo(boolean z) {
        log("change to " + (z ? "background" : "foreground"));
        if (z) {
            EW();
        }
        this.bee = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(final String str) {
        DuMixGameSurfaceView OD = OD();
        if (OD != null) {
            OD.a(new DuMixGameSurfaceView.b() { // from class: com.baidu.swan.games.m.a.1
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
                                    com.baidu.swan.apps.y.c EQ = new c.a().fk(str).h(createBitmap).EQ();
                                    Message obtainMessage = a.this.mHandler.obtainMessage(3);
                                    obtainMessage.obj = EQ;
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
    public void Or() {
        DuMixGameSurfaceView OD = OD();
        if (OD != null) {
            OD.Or();
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

    private DuMixGameSurfaceView OD() {
        e uz = com.baidu.swan.apps.w.e.Ec().uz();
        if (uz == null) {
            return null;
        }
        h hVar = (h) uz.l(h.class);
        if (hVar == null || hVar.getView() == null) {
            return null;
        }
        View childAt = ((ViewGroup) hVar.getView()).getChildAt(0);
        if (childAt instanceof DuMixGameSurfaceView) {
            return (DuMixGameSurfaceView) childAt;
        }
        return null;
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
        Or();
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
