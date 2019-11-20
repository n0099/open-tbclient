package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.b.b.g;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.apps.y.a;
import com.baidu.swan.apps.y.c;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends HandlerThread implements com.baidu.swan.apps.core.f.b {
    private static volatile f aXB;
    private boolean aXA;
    private int aXC;
    private int aXD;
    private long aXE;
    private com.baidu.swan.apps.y.a aXF;
    private com.baidu.swan.apps.y.a aXG;
    private d aXH;
    private Deque<d> aXI;
    private JSONArray aXJ;
    private b aXK;
    private Handler mHandler;
    private boolean mIsBackground;
    private static final String TAG = f.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void onResult(boolean z);
    }

    static /* synthetic */ int k(f fVar) {
        int i = fVar.aXD;
        fVar.aXD = i + 1;
        return i;
    }

    static /* synthetic */ int l(f fVar) {
        int i = fVar.aXD;
        fVar.aXD = i - 1;
        return i;
    }

    private f() {
        super("SwanAppPageMonitor", 5);
        this.aXC = 0;
        this.aXD = 0;
        this.aXI = new ArrayDeque();
        this.aXJ = new JSONArray();
        this.mIsBackground = true;
        this.aXE = com.baidu.swan.apps.u.a.Jm().Be() * 1000;
        this.aXF = a.C0238a.gf("simple_parser");
        this.aXG = a.C0238a.gf("hsv_parser");
        this.aXA = com.baidu.swan.apps.u.a.Jm().Bp();
        EventBusWrapper.lazyRegister("dialog_event_tag", com.baidu.swan.apps.res.widget.dialog.a.class, new rx.functions.b<com.baidu.swan.apps.res.widget.dialog.a>() { // from class: com.baidu.swan.apps.y.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: b */
            public void call(com.baidu.swan.apps.res.widget.dialog.a aVar) {
                f.this.a(aVar);
            }
        });
        try {
            if (!isAlive()) {
                start();
            }
        } catch (Error | Exception e) {
            e.printStackTrace();
        }
    }

    public static f Mx() {
        if (aXB == null) {
            synchronized (f.class) {
                if (aXB == null) {
                    aXB = new f();
                }
            }
        }
        return aXB;
    }

    private void initHandler() {
        Looper looper;
        if (this.mHandler == null && (looper = getLooper()) != null) {
            this.mHandler = new c(looper);
        }
    }

    @Override // com.baidu.swan.apps.core.f.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
            log("scroll (" + i3 + Constants.ACCEPT_TIME_SEPARATOR_SP + i4 + ") -> (" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2 + ")");
        } else {
            MF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {
        int aXR;

        private c(Looper looper) {
            super(looper);
            this.aXR = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.log("get message " + message.what);
            switch (message.what) {
                case 1:
                    com.baidu.swan.apps.core.d.d Fs = f.this.Fs();
                    if (Fs != null) {
                        String Fc = Fs.Fc();
                        if (!TextUtils.isEmpty(Fc)) {
                            f.this.a(Fs, Fc);
                            this.aXR = 0;
                            return;
                        } else if (this.aXR == 3) {
                            f.this.log("can't get slaveId after retrying 3 times");
                            this.aXR = 0;
                            return;
                        } else {
                            f.this.mHandler.sendEmptyMessageDelayed(1, 1000L);
                            return;
                        }
                    }
                    return;
                case 2:
                default:
                    return;
                case 3:
                    final com.baidu.swan.apps.y.c cVar = (com.baidu.swan.apps.y.c) message.obj;
                    if (cVar != null && f.this.gi(cVar.getToken())) {
                        if (com.baidu.swan.apps.u.a.Jm().Bq()) {
                            f.this.aXF.dK(f.this.d(f.this.Fs()));
                        }
                        f.this.aXH.MJ();
                        f.this.a(cVar, new a() { // from class: com.baidu.swan.apps.y.f.c.1
                            @Override // com.baidu.swan.apps.y.f.a
                            public void onResult(boolean z) {
                                f.this.aXH.aXU = z;
                                if (z) {
                                    f.this.log("simple error report");
                                    f.this.a(cVar);
                                }
                            }
                        });
                        f.this.aXH.MK();
                        if (f.this.MB()) {
                            f.this.a(cVar, f.this.aXG, new a() { // from class: com.baidu.swan.apps.y.f.c.2
                                @Override // com.baidu.swan.apps.y.f.a
                                public void onResult(boolean z) {
                                    if (z) {
                                        f.this.log("grid error report");
                                        f.this.a(cVar, 28, f.this.MA());
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    f.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.swan.apps.y.f.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
                            if (AI != null && AI.Fr() == null) {
                                f.this.a(new c.a().gg("loading").Mw());
                            }
                        }
                    }, 10000L);
                    return;
                case 5:
                    if (f.this.MB() && f.this.aXH.aXU) {
                        f.this.gk((String) message.obj);
                        return;
                    }
                    return;
                case 6:
                    f.this.mIsBackground = message.arg1 == 0;
                    f.this.log("小程序切入" + (f.this.mIsBackground ? "后台" : "前台"));
                    if (f.this.mIsBackground) {
                        f.this.My();
                        return;
                    } else {
                        f.this.Mz();
                        return;
                    }
                case 7:
                    if (message.obj != null) {
                        if ("show".equals(((com.baidu.swan.apps.res.widget.dialog.a) message.obj).getAction())) {
                            f.k(f.this);
                            return;
                        } else {
                            f.l(f.this);
                            return;
                        }
                    }
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void My() {
        if (this.aXH == null) {
            return;
        }
        if (!this.aXH.isChecked()) {
            log("pause");
            if (this.mHandler != null) {
                this.mHandler.removeCallbacks(this.aXK);
            }
            this.aXH.pause();
        } else if (this.aXH.aXU && MB()) {
            gk("background");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mz() {
        if (this.aXH != null && !this.aXH.isChecked()) {
            log("resume");
            this.aXH.resume();
            long MI = this.aXH.MI();
            if (MI >= 0) {
                this.aXK = new b("", this.aXH.id);
                this.mHandler.postDelayed(this.aXK, MI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MA() {
        String string = com.baidu.swan.apps.storage.b.f.ST().getString("screenshot_upload_switch", "1");
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
        this.aXC++;
        String a2 = a(cVar, z);
        log(a2);
        com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(5L).as(i).iL(a2);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.Ra() != null) {
            bVar = com.baidu.swan.apps.ae.b.Ra().AK();
        }
        com.baidu.swan.apps.statistic.a.d cP = new com.baidu.swan.apps.statistic.a.d().a(iL).s(bVar).ia(com.baidu.swan.apps.statistic.e.eL(com.baidu.swan.apps.ae.b.AC())).ib(com.baidu.swan.apps.ae.b.Rm()).ie(String.valueOf(this.aXI.size())).cP(false);
        if (MB() && this.aXJ != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("launchlog", this.aXJ);
                cP.aI(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.statistic.e.b(cP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MB() {
        return this.aXI.size() > 0 && this.aXH == this.aXI.getFirst();
    }

    private String a(com.baidu.swan.apps.y.c cVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", cVar.getUrl());
            if (com.baidu.swan.apps.ae.b.Ra() != null) {
                jSONObject.put("name", com.baidu.swan.apps.ae.b.Ra().getName());
            } else {
                jSONObject.put("name", "UNKNOWN");
            }
            jSONObject.put("errCnt", this.aXC);
            jSONObject.put("firstPage", MB());
            jSONObject.put("zeus", com.baidu.swan.apps.u.a.Jv().aN(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.MP());
            if (z) {
                jSONObject.put("image", k(cVar.Mv()));
            }
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.eT(com.baidu.swan.apps.ae.b.AC()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, @NonNull a aVar) {
        com.baidu.swan.apps.res.widget.floatlayer.a AE = com.baidu.swan.apps.w.e.LE().Lq().AE();
        if (!AE.QB() && !MC()) {
            a(cVar, this.aXF, aVar);
            return;
        }
        log("存在native view: " + AE.QB() + "; 存在dailog：" + MC());
        aVar.onResult(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull a aVar2) {
        if (cVar == null || aVar == null) {
            aVar2.onResult(false);
        } else if (TextUtils.equals(cVar.getToken(), this.aXH.id)) {
            log("start parse");
            aVar2.onResult(aVar.a(cVar.Mv(), cVar.getRect()));
        } else {
            aVar2.onResult(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.core.d.b bVar, String str) {
        String str2 = "";
        if (this.aXH == null || !TextUtils.equals(str, this.aXH.id)) {
            com.baidu.swan.apps.b.c.e eH = com.baidu.swan.apps.w.e.LE().eH(str);
            if (eH != null) {
                eH.a(this);
            }
            this.aXH = new d(str);
            this.aXI.addLast(this.aXH);
            if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                str2 = ((com.baidu.swan.apps.core.d.d) bVar).Ff();
            }
            if (!this.mIsBackground) {
                this.aXK = new b(str2, str);
                this.mHandler.postDelayed(this.aXK, this.aXH.MI());
                return;
            }
            this.aXH.pause();
        }
    }

    private boolean MC() {
        return this.aXD > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gi(@NonNull String str) {
        return this.aXH != null && TextUtils.equals(str, this.aXH.id);
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
            if (f.this.gi(this.token)) {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.f.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap Us;
                        Rect rect;
                        f.this.log("start full capture, slave id: " + b.this.token + "; url:" + b.this.url);
                        AbsoluteLayout fN = com.baidu.swan.apps.w.e.LE().fN(b.this.token);
                        if (fN == null || fN.getWidth() <= 0 || fN.getHeight() <= 0) {
                            f.this.log("invalid webview " + fN);
                            return;
                        }
                        if (f.this.aXA) {
                            f.this.log("get full screenshot");
                            Bitmap as = z.as(fN);
                            int[] iArr = new int[2];
                            fN.getLocationOnScreen(iArr);
                            com.baidu.swan.apps.core.d.d Fs = f.this.Fs();
                            if (Fs != null) {
                                SwanAppActionBar EB = Fs.EB();
                                int[] iArr2 = new int[2];
                                EB.getLocationOnScreen(iArr2);
                                int height = EB.getHeight() + iArr2[1];
                                if (iArr[1] < height) {
                                    iArr[1] = height + 1;
                                }
                            }
                            int measuredWidth = iArr[0] + fN.getMeasuredWidth();
                            if (measuredWidth > as.getWidth()) {
                                measuredWidth = as.getWidth();
                            }
                            int measuredHeight = iArr[1] + fN.getMeasuredHeight();
                            if (measuredHeight > as.getHeight()) {
                                measuredHeight = as.getHeight();
                            }
                            rect = new Rect(iArr[0], iArr[1], measuredWidth, measuredHeight);
                            Us = as;
                        } else {
                            f.this.log("get webview screenshot");
                            Us = z.Us();
                            rect = new Rect(0, 0, fN.getMeasuredWidth(), fN.getMeasuredHeight());
                        }
                        if (Us != null) {
                            com.baidu.swan.apps.y.c Mw = new c.a().c(rect).gh(b.this.token).j(Us).Mw();
                            Message obtainMessage = f.this.mHandler.obtainMessage(3);
                            obtainMessage.obj = Mw;
                            f.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
            }
        }
    }

    private void g(@NonNull SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.e AI;
        initHandler();
        if (this.mHandler != null && (AI = swanAppActivity.AI()) != null) {
            com.baidu.swan.apps.core.d.b Fr = AI.Fr();
            if (Fr == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (Fr instanceof com.baidu.swan.apps.core.d.d) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    public void h(@NonNull SwanAppActivity swanAppActivity) {
        g(swanAppActivity);
    }

    public void MD() {
        log("stop monitor");
        this.aXC = 0;
        MF();
        this.aXI.clear();
        this.aXH = null;
    }

    public void bR(boolean z) {
        log("this aiapp changes to " + (z ? "background" : "foreground"));
        initHandler();
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(6);
            obtainMessage.arg1 = z ? 0 : 1;
            this.mHandler.sendMessageAtFrontOfQueue(obtainMessage);
        }
    }

    private String ME() {
        return com.baidu.swan.apps.ae.b.Ra() != null ? TAG + com.baidu.swan.apps.ae.b.Ra().getName() : TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (DEBUG) {
            Log.d(ME(), str);
        }
    }

    private void MF() {
        log("remove pending actions");
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    private String k(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static void MG() {
        final com.baidu.swan.apps.core.d.b Fr;
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI != null && (Fr = AI.Fr()) != null) {
            j.a(new Runnable() { // from class: com.baidu.swan.apps.y.f.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c Mw = new c.a().j(z.as(com.baidu.swan.apps.core.d.b.this.getView())).Mw();
                    g Js = com.baidu.swan.apps.u.a.Js();
                    if (Js != null) {
                        Js.a(Mw, null, null, null);
                    }
                }
            }, "feedback error page");
        }
    }

    public synchronized void o(JSONArray jSONArray) {
        if (jSONArray != null) {
            if (jSONArray.length() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    try {
                        if (DEBUG) {
                            Log.d(TAG, "add stage " + jSONArray.get(i2).toString());
                        }
                        this.aXJ.put(jSONArray.get(i2));
                    } catch (JSONException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    public void gj(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("actionId", str);
                jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                o(jSONArray);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(final String str) {
        SwanAppActivity Lq = com.baidu.swan.apps.w.e.LE().Lq();
        if (Lq != null) {
            final WeakReference weakReference = new WeakReference(Lq);
            ac.i(new Runnable() { // from class: com.baidu.swan.apps.y.f.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c MH;
                    final SwanAppActivity swanAppActivity = (SwanAppActivity) weakReference.get();
                    if (swanAppActivity != null && !swanAppActivity.isFinishing() && !swanAppActivity.isDestroyed() && (MH = f.this.MH()) != null) {
                        f.this.a(MH, new a() { // from class: com.baidu.swan.apps.y.f.3.1
                            @Override // com.baidu.swan.apps.y.f.a
                            public void onResult(boolean z) {
                                if (z) {
                                    f.this.log("force close swan app");
                                    swanAppActivity.AJ();
                                    com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().ar(5L).as(33L).iL(str);
                                    com.baidu.swan.apps.v.b.b bVar = null;
                                    if (com.baidu.swan.apps.ae.b.Ra() != null) {
                                        bVar = com.baidu.swan.apps.ae.b.Ra().AK();
                                    }
                                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(iL).s(bVar).ia(com.baidu.swan.apps.statistic.e.eL(com.baidu.swan.apps.ae.b.AC())).ib(com.baidu.swan.apps.ae.b.Rm()).ie(String.valueOf(f.this.aXI.size())).cP(false));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.y.c MH() {
        AbsoluteLayout fN = com.baidu.swan.apps.w.e.LE().fN(this.aXH.id);
        if (fN == null || fN.getWidth() <= 0 || fN.getHeight() <= 0) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            fN.getLocationOnScreen(iArr);
            View rootView = fN.getRootView();
            rootView.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache(), iArr[0], iArr[1], 100, fN.getMeasuredHeight());
            rootView.setDrawingCacheEnabled(false);
            return new c.a().j(createBitmap).c(new Rect(0, 0, 100, fN.getMeasuredHeight())).gh(this.aXH.id).Mw();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar != null) {
            com.baidu.swan.apps.ae.a.d EK = dVar.EK();
            if (EK != null) {
                return EK.mBackgroundColor;
            }
            FrameLayout EZ = dVar.EZ();
            if (EZ != null) {
                Drawable background = EZ.getBackground();
                if (background instanceof ColorDrawable) {
                    return ((ColorDrawable) background).getColor();
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.d.d Fs() {
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI != null) {
            com.baidu.swan.apps.core.d.b Fr = AI.Fr();
            if (Fr instanceof com.baidu.swan.apps.core.d.d) {
                return (com.baidu.swan.apps.core.d.d) Fr;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        initHandler();
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(7);
            obtainMessage.obj = aVar;
            this.mHandler.sendMessageAtFrontOfQueue(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        private boolean aXU;
        private int aXV;
        private long aXW;
        private String id;
        private long startTime;

        private d(String str) {
            this.id = str;
            this.startTime = System.currentTimeMillis();
            this.aXW = f.this.aXE;
            this.aXV = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long MI() {
            if (this.aXW > 0) {
                this.aXW -= System.currentTimeMillis() - this.startTime;
            }
            return this.aXW;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pause() {
            if (this.aXW > 0) {
                this.aXW -= System.currentTimeMillis() - this.startTime;
            }
            f.this.log("pause this page, remain time is " + this.aXW);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resume() {
            this.startTime = System.currentTimeMillis();
            f.this.log("resume this page");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void MJ() {
            this.aXV = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void MK() {
            this.aXV = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isChecked() {
            return this.aXV == 2;
        }
    }
}
