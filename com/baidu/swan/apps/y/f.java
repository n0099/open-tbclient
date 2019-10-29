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
    private static volatile f aXT;
    private boolean aXS;
    private int aXU;
    private int aXV;
    private long aXW;
    private com.baidu.swan.apps.y.a aXX;
    private com.baidu.swan.apps.y.a aXY;
    private d aXZ;
    private Deque<d> aYa;
    private JSONArray aYb;
    private b aYc;
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
        int i = fVar.aXV;
        fVar.aXV = i + 1;
        return i;
    }

    static /* synthetic */ int l(f fVar) {
        int i = fVar.aXV;
        fVar.aXV = i - 1;
        return i;
    }

    private f() {
        super("SwanAppPageMonitor", 5);
        this.aXU = 0;
        this.aXV = 0;
        this.aYa = new ArrayDeque();
        this.aYb = new JSONArray();
        this.mIsBackground = true;
        this.aXW = com.baidu.swan.apps.u.a.Jl().Bd() * 1000;
        this.aXX = a.C0238a.gf("simple_parser");
        this.aXY = a.C0238a.gf("hsv_parser");
        this.aXS = com.baidu.swan.apps.u.a.Jl().Bo();
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

    public static f Mw() {
        if (aXT == null) {
            synchronized (f.class) {
                if (aXT == null) {
                    aXT = new f();
                }
            }
        }
        return aXT;
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
            ME();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {
        int aYj;

        private c(Looper looper) {
            super(looper);
            this.aYj = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.log("get message " + message.what);
            switch (message.what) {
                case 1:
                    com.baidu.swan.apps.core.d.d Fr = f.this.Fr();
                    if (Fr != null) {
                        String Fb = Fr.Fb();
                        if (!TextUtils.isEmpty(Fb)) {
                            f.this.a(Fr, Fb);
                            this.aYj = 0;
                            return;
                        } else if (this.aYj == 3) {
                            f.this.log("can't get slaveId after retrying 3 times");
                            this.aYj = 0;
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
                        if (com.baidu.swan.apps.u.a.Jl().Bp()) {
                            f.this.aXX.dK(f.this.d(f.this.Fr()));
                        }
                        f.this.aXZ.MI();
                        f.this.a(cVar, new a() { // from class: com.baidu.swan.apps.y.f.c.1
                            @Override // com.baidu.swan.apps.y.f.a
                            public void onResult(boolean z) {
                                f.this.aXZ.aYm = z;
                                if (z) {
                                    f.this.log("simple error report");
                                    f.this.a(cVar);
                                }
                            }
                        });
                        f.this.aXZ.MJ();
                        if (f.this.MA()) {
                            f.this.a(cVar, f.this.aXY, new a() { // from class: com.baidu.swan.apps.y.f.c.2
                                @Override // com.baidu.swan.apps.y.f.a
                                public void onResult(boolean z) {
                                    if (z) {
                                        f.this.log("grid error report");
                                        f.this.a(cVar, 28, f.this.Mz());
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
                            com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
                            if (AH != null && AH.Fq() == null) {
                                f.this.a(new c.a().gg("loading").Mv());
                            }
                        }
                    }, 10000L);
                    return;
                case 5:
                    if (f.this.MA() && f.this.aXZ.aYm) {
                        f.this.gk((String) message.obj);
                        return;
                    }
                    return;
                case 6:
                    f.this.mIsBackground = message.arg1 == 0;
                    f.this.log("小程序切入" + (f.this.mIsBackground ? "后台" : "前台"));
                    if (f.this.mIsBackground) {
                        f.this.Mx();
                        return;
                    } else {
                        f.this.My();
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
    public void Mx() {
        if (this.aXZ == null) {
            return;
        }
        if (!this.aXZ.isChecked()) {
            log("pause");
            if (this.mHandler != null) {
                this.mHandler.removeCallbacks(this.aYc);
            }
            this.aXZ.pause();
        } else if (this.aXZ.aYm && MA()) {
            gk("background");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void My() {
        if (this.aXZ != null && !this.aXZ.isChecked()) {
            log("resume");
            this.aXZ.resume();
            long MH = this.aXZ.MH();
            if (MH >= 0) {
                this.aYc = new b("", this.aXZ.id);
                this.mHandler.postDelayed(this.aYc, MH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Mz() {
        String string = com.baidu.swan.apps.storage.b.f.SR().getString("screenshot_upload_switch", "1");
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
        String a2 = a(cVar, z);
        log(a2);
        com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(5L).at(i).iL(a2);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.QZ() != null) {
            bVar = com.baidu.swan.apps.ae.b.QZ().AJ();
        }
        com.baidu.swan.apps.statistic.a.d cP = new com.baidu.swan.apps.statistic.a.d().a(iL).s(bVar).ia(com.baidu.swan.apps.statistic.e.eL(com.baidu.swan.apps.ae.b.AB())).ib(com.baidu.swan.apps.ae.b.Rk()).ie(String.valueOf(this.aYa.size())).cP(false);
        if (MA() && this.aYb != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("launchlog", this.aYb);
                cP.aH(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.statistic.e.b(cP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MA() {
        return this.aYa.size() > 0 && this.aXZ == this.aYa.getFirst();
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
            jSONObject.put("firstPage", MA());
            jSONObject.put("zeus", com.baidu.swan.apps.u.a.Ju().aN(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.MO());
            if (z) {
                jSONObject.put("image", k(cVar.Mu()));
            }
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.eT(com.baidu.swan.apps.ae.b.AB()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, @NonNull a aVar) {
        com.baidu.swan.apps.res.widget.floatlayer.a AD = com.baidu.swan.apps.w.e.LD().Lp().AD();
        if (!AD.QA() && !MB()) {
            a(cVar, this.aXX, aVar);
            return;
        }
        log("存在native view: " + AD.QA() + "; 存在dailog：" + MB());
        aVar.onResult(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull a aVar2) {
        if (cVar == null || aVar == null) {
            aVar2.onResult(false);
        } else if (TextUtils.equals(cVar.getToken(), this.aXZ.id)) {
            log("start parse");
            aVar2.onResult(aVar.a(cVar.Mu(), cVar.getRect()));
        } else {
            aVar2.onResult(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.core.d.b bVar, String str) {
        String str2 = "";
        if (this.aXZ == null || !TextUtils.equals(str, this.aXZ.id)) {
            com.baidu.swan.apps.b.c.e eH = com.baidu.swan.apps.w.e.LD().eH(str);
            if (eH != null) {
                eH.a(this);
            }
            this.aXZ = new d(str);
            this.aYa.addLast(this.aXZ);
            if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                str2 = ((com.baidu.swan.apps.core.d.d) bVar).Fe();
            }
            if (!this.mIsBackground) {
                this.aYc = new b(str2, str);
                this.mHandler.postDelayed(this.aYc, this.aXZ.MH());
                return;
            }
            this.aXZ.pause();
        }
    }

    private boolean MB() {
        return this.aXV > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gi(@NonNull String str) {
        return this.aXZ != null && TextUtils.equals(str, this.aXZ.id);
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
                        Bitmap Uu;
                        Rect rect;
                        f.this.log("start full capture, slave id: " + b.this.token + "; url:" + b.this.url);
                        AbsoluteLayout fN = com.baidu.swan.apps.w.e.LD().fN(b.this.token);
                        if (fN == null || fN.getWidth() <= 0 || fN.getHeight() <= 0) {
                            f.this.log("invalid webview " + fN);
                            return;
                        }
                        if (f.this.aXS) {
                            f.this.log("get full screenshot");
                            Bitmap as = z.as(fN);
                            int[] iArr = new int[2];
                            fN.getLocationOnScreen(iArr);
                            com.baidu.swan.apps.core.d.d Fr = f.this.Fr();
                            if (Fr != null) {
                                SwanAppActionBar EA = Fr.EA();
                                int[] iArr2 = new int[2];
                                EA.getLocationOnScreen(iArr2);
                                int height = EA.getHeight() + iArr2[1];
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
                            Uu = as;
                        } else {
                            f.this.log("get webview screenshot");
                            Uu = z.Uu();
                            rect = new Rect(0, 0, fN.getMeasuredWidth(), fN.getMeasuredHeight());
                        }
                        if (Uu != null) {
                            com.baidu.swan.apps.y.c Mv = new c.a().c(rect).gh(b.this.token).j(Uu).Mv();
                            Message obtainMessage = f.this.mHandler.obtainMessage(3);
                            obtainMessage.obj = Mv;
                            f.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
            }
        }
    }

    private void g(@NonNull SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.e AH;
        initHandler();
        if (this.mHandler != null && (AH = swanAppActivity.AH()) != null) {
            com.baidu.swan.apps.core.d.b Fq = AH.Fq();
            if (Fq == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (Fq instanceof com.baidu.swan.apps.core.d.d) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    public void h(@NonNull SwanAppActivity swanAppActivity) {
        g(swanAppActivity);
    }

    public void MC() {
        log("stop monitor");
        this.aXU = 0;
        ME();
        this.aYa.clear();
        this.aXZ = null;
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
    }

    private String k(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static void MF() {
        final com.baidu.swan.apps.core.d.b Fq;
        com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH != null && (Fq = AH.Fq()) != null) {
            j.a(new Runnable() { // from class: com.baidu.swan.apps.y.f.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c Mv = new c.a().j(z.as(com.baidu.swan.apps.core.d.b.this.getView())).Mv();
                    g Jr = com.baidu.swan.apps.u.a.Jr();
                    if (Jr != null) {
                        Jr.a(Mv, null, null, null);
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
                        this.aYb.put(jSONArray.get(i2));
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
        SwanAppActivity Lp = com.baidu.swan.apps.w.e.LD().Lp();
        if (Lp != null) {
            final WeakReference weakReference = new WeakReference(Lp);
            ac.i(new Runnable() { // from class: com.baidu.swan.apps.y.f.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c MG;
                    final SwanAppActivity swanAppActivity = (SwanAppActivity) weakReference.get();
                    if (swanAppActivity != null && !swanAppActivity.isFinishing() && !swanAppActivity.isDestroyed() && (MG = f.this.MG()) != null) {
                        f.this.a(MG, new a() { // from class: com.baidu.swan.apps.y.f.3.1
                            @Override // com.baidu.swan.apps.y.f.a
                            public void onResult(boolean z) {
                                if (z) {
                                    f.this.log("force close swan app");
                                    swanAppActivity.AI();
                                    com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(5L).at(33L).iL(str);
                                    com.baidu.swan.apps.v.b.b bVar = null;
                                    if (com.baidu.swan.apps.ae.b.QZ() != null) {
                                        bVar = com.baidu.swan.apps.ae.b.QZ().AJ();
                                    }
                                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(iL).s(bVar).ia(com.baidu.swan.apps.statistic.e.eL(com.baidu.swan.apps.ae.b.AB())).ib(com.baidu.swan.apps.ae.b.Rk()).ie(String.valueOf(f.this.aYa.size())).cP(false));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.y.c MG() {
        AbsoluteLayout fN = com.baidu.swan.apps.w.e.LD().fN(this.aXZ.id);
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
            return new c.a().j(createBitmap).c(new Rect(0, 0, 100, fN.getMeasuredHeight())).gh(this.aXZ.id).Mv();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar != null) {
            com.baidu.swan.apps.ae.a.d EJ = dVar.EJ();
            if (EJ != null) {
                return EJ.mBackgroundColor;
            }
            FrameLayout EY = dVar.EY();
            if (EY != null) {
                Drawable background = EY.getBackground();
                if (background instanceof ColorDrawable) {
                    return ((ColorDrawable) background).getColor();
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.d.d Fr() {
        com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH != null) {
            com.baidu.swan.apps.core.d.b Fq = AH.Fq();
            if (Fq instanceof com.baidu.swan.apps.core.d.d) {
                return (com.baidu.swan.apps.core.d.d) Fq;
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
        private boolean aYm;
        private int aYn;
        private long aYo;
        private String id;
        private long startTime;

        private d(String str) {
            this.id = str;
            this.startTime = System.currentTimeMillis();
            this.aYo = f.this.aXW;
            this.aYn = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long MH() {
            if (this.aYo > 0) {
                this.aYo -= System.currentTimeMillis() - this.startTime;
            }
            return this.aYo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pause() {
            if (this.aYo > 0) {
                this.aYo -= System.currentTimeMillis() - this.startTime;
            }
            f.this.log("pause this page, remain time is " + this.aYo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resume() {
            this.startTime = System.currentTimeMillis();
            f.this.log("resume this page");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void MI() {
            this.aYn = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void MJ() {
            this.aYn = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isChecked() {
            return this.aYn == 2;
        }
    }
}
