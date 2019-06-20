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
import com.baidu.sapi2.views.SmsLoginView;
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
    private static volatile f aDy;
    private int aDA;
    private long aDB;
    private com.baidu.swan.apps.y.a aDC;
    private com.baidu.swan.apps.y.a aDD;
    private d aDE;
    private Deque<d> aDF;
    private JSONArray aDG;
    private b aDH;
    private boolean aDx;
    private int aDz;
    private Handler mHandler;
    private boolean mIsBackground;
    private static final String TAG = f.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void bB(boolean z);
    }

    static /* synthetic */ int k(f fVar) {
        int i = fVar.aDA;
        fVar.aDA = i + 1;
        return i;
    }

    static /* synthetic */ int l(f fVar) {
        int i = fVar.aDA;
        fVar.aDA = i - 1;
        return i;
    }

    private f() {
        super("SwanAppPageMonitor", 5);
        this.aDz = 0;
        this.aDA = 0;
        this.aDF = new ArrayDeque();
        this.aDG = new JSONArray();
        this.mIsBackground = true;
        this.aDB = com.baidu.swan.apps.u.a.DE().vE() * 1000;
        this.aDC = a.C0195a.fu("simple_parser");
        this.aDD = a.C0195a.fu("hsv_parser");
        this.aDx = com.baidu.swan.apps.u.a.DE().vP();
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

    public static f GN() {
        if (aDy == null) {
            synchronized (f.class) {
                if (aDy == null) {
                    aDy = new f();
                }
            }
        }
        return aDy;
    }

    private void hP() {
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
            GV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {
        int aDO;

        private c(Looper looper) {
            super(looper);
            this.aDO = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.log("get message " + message.what);
            switch (message.what) {
                case 1:
                    com.baidu.swan.apps.core.d.d zL = f.this.zL();
                    if (zL != null) {
                        String zv = zL.zv();
                        if (!TextUtils.isEmpty(zv)) {
                            f.this.a(zL, zv);
                            this.aDO = 0;
                            return;
                        } else if (this.aDO == 3) {
                            f.this.log("can't get slaveId after retrying 3 times");
                            this.aDO = 0;
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
                    if (cVar != null && f.this.fx(cVar.getToken())) {
                        if (com.baidu.swan.apps.u.a.DE().vQ()) {
                            f.this.aDC.cL(f.this.d(f.this.zL()));
                        }
                        f.this.aDE.GZ();
                        f.this.a(cVar, new a() { // from class: com.baidu.swan.apps.y.f.c.1
                            @Override // com.baidu.swan.apps.y.f.a
                            public void bB(boolean z) {
                                f.this.aDE.aDR = z;
                                if (z) {
                                    f.this.log("simple error report");
                                    f.this.a(cVar);
                                }
                            }
                        });
                        f.this.aDE.Ha();
                        if (f.this.GR()) {
                            f.this.a(cVar, f.this.aDD, new a() { // from class: com.baidu.swan.apps.y.f.c.2
                                @Override // com.baidu.swan.apps.y.f.a
                                public void bB(boolean z) {
                                    if (z) {
                                        f.this.log("grid error report");
                                        f.this.a(cVar, 28, f.this.GQ());
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
                            com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
                            if (vi != null && vi.zK() == null) {
                                f.this.a(new c.a().fv("loading").GM());
                            }
                        }
                    }, 10000L);
                    return;
                case 5:
                    if (f.this.GR() && f.this.aDE.aDR) {
                        f.this.fz((String) message.obj);
                        return;
                    }
                    return;
                case 6:
                    f.this.mIsBackground = message.arg1 == 0;
                    f.this.log("小程序切入" + (f.this.mIsBackground ? "后台" : "前台"));
                    if (f.this.mIsBackground) {
                        f.this.GO();
                        return;
                    } else {
                        f.this.GP();
                        return;
                    }
                case 7:
                    if (message.obj != null) {
                        if (SmsLoginView.StatEvent.LOGIN_SHOW.equals(((com.baidu.swan.apps.res.widget.dialog.a) message.obj).getAction())) {
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
    public void GO() {
        if (this.aDE == null) {
            return;
        }
        if (!this.aDE.isChecked()) {
            log("pause");
            if (this.mHandler != null) {
                this.mHandler.removeCallbacks(this.aDH);
            }
            this.aDE.pause();
        } else if (this.aDE.aDR && GR()) {
            fz("background");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP() {
        if (this.aDE != null && !this.aDE.isChecked()) {
            log("resume");
            this.aDE.resume();
            long GY = this.aDE.GY();
            if (GY >= 0) {
                this.aDH = new b("", this.aDE.id);
                this.mHandler.postDelayed(this.aDH, GY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GQ() {
        String string = com.baidu.swan.apps.storage.b.f.Ni().getString("screenshot_upload_switch", "1");
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
        String a2 = a(cVar, z);
        log(a2);
        com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(5L).Z(i).hY(a2);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.Lq() != null) {
            bVar = com.baidu.swan.apps.ae.b.Lq().vk();
        }
        com.baidu.swan.apps.statistic.a.d cv = new com.baidu.swan.apps.statistic.a.d().a(hY).s(bVar).ho(com.baidu.swan.apps.statistic.e.dM(com.baidu.swan.apps.ae.b.vc())).hp(com.baidu.swan.apps.ae.b.LB()).hr(String.valueOf(this.aDF.size())).cv(false);
        if (GR() && this.aDG != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("launchlog", this.aDG);
                cv.aj(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.statistic.e.b(cv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean GR() {
        return this.aDF.size() > 0 && this.aDE == this.aDF.getFirst();
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
            jSONObject.put("firstPage", GR());
            jSONObject.put("zeus", com.baidu.swan.apps.u.a.DN().aL(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.Hf());
            if (z) {
                jSONObject.put("image", i(cVar.GL()));
            }
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.dU(com.baidu.swan.apps.ae.b.vc()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, @NonNull a aVar) {
        com.baidu.swan.apps.res.widget.floatlayer.a ve = com.baidu.swan.apps.w.e.FV().FH().ve();
        if (!ve.KQ() && !GS()) {
            a(cVar, this.aDC, aVar);
            return;
        }
        log("存在native view: " + ve.KQ() + "; 存在dailog：" + GS());
        aVar.bB(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull a aVar2) {
        if (cVar == null || aVar == null) {
            aVar2.bB(false);
        } else if (TextUtils.equals(cVar.getToken(), this.aDE.id)) {
            log("start parse");
            aVar2.bB(aVar.a(cVar.GL(), cVar.getRect()));
        } else {
            aVar2.bB(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.core.d.b bVar, String str) {
        String str2 = "";
        if (this.aDE == null || !TextUtils.equals(str, this.aDE.id)) {
            com.baidu.swan.apps.b.c.e dT = com.baidu.swan.apps.w.e.FV().dT(str);
            if (dT != null) {
                dT.a(this);
            }
            this.aDE = new d(str);
            this.aDF.addLast(this.aDE);
            if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                str2 = ((com.baidu.swan.apps.core.d.d) bVar).zy();
            }
            if (!this.mIsBackground) {
                this.aDH = new b(str2, str);
                this.mHandler.postDelayed(this.aDH, this.aDE.GY());
                return;
            }
            this.aDE.pause();
        }
    }

    private boolean GS() {
        return this.aDA > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fx(@NonNull String str) {
        return this.aDE != null && TextUtils.equals(str, this.aDE.id);
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
            if (f.this.fx(this.token)) {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.f.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap OK;
                        Rect rect;
                        f.this.log("start full capture, slave id: " + b.this.token + "; url:" + b.this.url);
                        AbsoluteLayout eZ = com.baidu.swan.apps.w.e.FV().eZ(b.this.token);
                        if (eZ == null || eZ.getWidth() <= 0 || eZ.getHeight() <= 0) {
                            f.this.log("invalid webview " + eZ);
                            return;
                        }
                        if (f.this.aDx) {
                            f.this.log("get full screenshot");
                            Bitmap ak = z.ak(eZ);
                            int[] iArr = new int[2];
                            eZ.getLocationOnScreen(iArr);
                            com.baidu.swan.apps.core.d.d zL = f.this.zL();
                            if (zL != null) {
                                SwanAppActionBar yU = zL.yU();
                                int[] iArr2 = new int[2];
                                yU.getLocationOnScreen(iArr2);
                                int height = yU.getHeight() + iArr2[1];
                                if (iArr[1] < height) {
                                    iArr[1] = height + 1;
                                }
                            }
                            int measuredWidth = iArr[0] + eZ.getMeasuredWidth();
                            if (measuredWidth > ak.getWidth()) {
                                measuredWidth = ak.getWidth();
                            }
                            int measuredHeight = iArr[1] + eZ.getMeasuredHeight();
                            if (measuredHeight > ak.getHeight()) {
                                measuredHeight = ak.getHeight();
                            }
                            rect = new Rect(iArr[0], iArr[1], measuredWidth, measuredHeight);
                            OK = ak;
                        } else {
                            f.this.log("get webview screenshot");
                            OK = z.OK();
                            rect = new Rect(0, 0, eZ.getMeasuredWidth(), eZ.getMeasuredHeight());
                        }
                        if (OK != null) {
                            com.baidu.swan.apps.y.c GM = new c.a().e(rect).fw(b.this.token).h(OK).GM();
                            Message obtainMessage = f.this.mHandler.obtainMessage(3);
                            obtainMessage.obj = GM;
                            f.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
            }
        }
    }

    private void g(@NonNull SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.e vi;
        hP();
        if (this.mHandler != null && (vi = swanAppActivity.vi()) != null) {
            com.baidu.swan.apps.core.d.b zK = vi.zK();
            if (zK == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (zK instanceof com.baidu.swan.apps.core.d.d) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    public void h(@NonNull SwanAppActivity swanAppActivity) {
        g(swanAppActivity);
    }

    public void GT() {
        log("stop monitor");
        this.aDz = 0;
        GV();
        this.aDF.clear();
        this.aDE = null;
    }

    public void bw(boolean z) {
        log("this aiapp changes to " + (z ? "background" : "foreground"));
        hP();
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(6);
            obtainMessage.arg1 = z ? 0 : 1;
            this.mHandler.sendMessageAtFrontOfQueue(obtainMessage);
        }
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
    }

    private String i(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static void GW() {
        final com.baidu.swan.apps.core.d.b zK;
        com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi != null && (zK = vi.zK()) != null) {
            j.a(new Runnable() { // from class: com.baidu.swan.apps.y.f.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c GM = new c.a().h(z.ak(com.baidu.swan.apps.core.d.b.this.getView())).GM();
                    g DK = com.baidu.swan.apps.u.a.DK();
                    if (DK != null) {
                        DK.a(GM, null, null, null);
                    }
                }
            }, "feedback error page");
        }
    }

    public synchronized void g(JSONArray jSONArray) {
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
                        this.aDG.put(jSONArray.get(i2));
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

    public void fy(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("actionId", str);
                jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                g(jSONArray);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(final String str) {
        SwanAppActivity FH = com.baidu.swan.apps.w.e.FV().FH();
        if (FH != null) {
            final WeakReference weakReference = new WeakReference(FH);
            ac.k(new Runnable() { // from class: com.baidu.swan.apps.y.f.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c GX;
                    final SwanAppActivity swanAppActivity = (SwanAppActivity) weakReference.get();
                    if (swanAppActivity != null && !swanAppActivity.isFinishing() && !swanAppActivity.isDestroyed() && (GX = f.this.GX()) != null) {
                        f.this.a(GX, new a() { // from class: com.baidu.swan.apps.y.f.3.1
                            @Override // com.baidu.swan.apps.y.f.a
                            public void bB(boolean z) {
                                if (z) {
                                    f.this.log("force close swan app");
                                    swanAppActivity.vj();
                                    com.baidu.swan.apps.ak.a hY = new com.baidu.swan.apps.ak.a().Y(5L).Z(33L).hY(str);
                                    com.baidu.swan.apps.v.b.b bVar = null;
                                    if (com.baidu.swan.apps.ae.b.Lq() != null) {
                                        bVar = com.baidu.swan.apps.ae.b.Lq().vk();
                                    }
                                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(hY).s(bVar).ho(com.baidu.swan.apps.statistic.e.dM(com.baidu.swan.apps.ae.b.vc())).hp(com.baidu.swan.apps.ae.b.LB()).hr(String.valueOf(f.this.aDF.size())).cv(false));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.y.c GX() {
        AbsoluteLayout eZ = com.baidu.swan.apps.w.e.FV().eZ(this.aDE.id);
        if (eZ == null || eZ.getWidth() <= 0 || eZ.getHeight() <= 0) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            eZ.getLocationOnScreen(iArr);
            View rootView = eZ.getRootView();
            rootView.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache(), iArr[0], iArr[1], 100, eZ.getMeasuredHeight());
            rootView.setDrawingCacheEnabled(false);
            return new c.a().h(createBitmap).e(new Rect(0, 0, 100, eZ.getMeasuredHeight())).fw(this.aDE.id).GM();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar != null) {
            com.baidu.swan.apps.ae.a.d zd = dVar.zd();
            if (zd != null) {
                return zd.mBackgroundColor;
            }
            FrameLayout zs = dVar.zs();
            if (zs != null) {
                Drawable background = zs.getBackground();
                if (background instanceof ColorDrawable) {
                    return ((ColorDrawable) background).getColor();
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.d.d zL() {
        com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi != null) {
            com.baidu.swan.apps.core.d.b zK = vi.zK();
            if (zK instanceof com.baidu.swan.apps.core.d.d) {
                return (com.baidu.swan.apps.core.d.d) zK;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        hP();
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(7);
            obtainMessage.obj = aVar;
            this.mHandler.sendMessageAtFrontOfQueue(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        private boolean aDR;
        private int aDS;
        private long aDT;
        private String id;
        private long startTime;

        private d(String str) {
            this.id = str;
            this.startTime = System.currentTimeMillis();
            this.aDT = f.this.aDB;
            this.aDS = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long GY() {
            if (this.aDT > 0) {
                this.aDT -= System.currentTimeMillis() - this.startTime;
            }
            return this.aDT;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pause() {
            if (this.aDT > 0) {
                this.aDT -= System.currentTimeMillis() - this.startTime;
            }
            f.this.log("pause this page, remain time is " + this.aDT);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resume() {
            this.startTime = System.currentTimeMillis();
            f.this.log("resume this page");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void GZ() {
            this.aDS = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Ha() {
            this.aDS = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isChecked() {
            return this.aDS == 2;
        }
    }
}
