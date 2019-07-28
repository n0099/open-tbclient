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
    private static volatile f aEg;
    private boolean aEf;
    private int aEh;
    private int aEi;
    private long aEj;
    private com.baidu.swan.apps.y.a aEk;
    private com.baidu.swan.apps.y.a aEl;
    private d aEm;
    private Deque<d> aEn;
    private JSONArray aEo;
    private b aEp;
    private Handler mHandler;
    private boolean mIsBackground;
    private static final String TAG = f.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void bE(boolean z);
    }

    static /* synthetic */ int k(f fVar) {
        int i = fVar.aEi;
        fVar.aEi = i + 1;
        return i;
    }

    static /* synthetic */ int l(f fVar) {
        int i = fVar.aEi;
        fVar.aEi = i - 1;
        return i;
    }

    private f() {
        super("SwanAppPageMonitor", 5);
        this.aEh = 0;
        this.aEi = 0;
        this.aEn = new ArrayDeque();
        this.aEo = new JSONArray();
        this.mIsBackground = true;
        this.aEj = com.baidu.swan.apps.u.a.En().wf() * 1000;
        this.aEk = a.C0197a.fz("simple_parser");
        this.aEl = a.C0197a.fz("hsv_parser");
        this.aEf = com.baidu.swan.apps.u.a.En().wq();
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

    public static f Hy() {
        if (aEg == null) {
            synchronized (f.class) {
                if (aEg == null) {
                    aEg = new f();
                }
            }
        }
        return aEg;
    }

    private void hZ() {
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
            HG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {
        int aEw;

        private c(Looper looper) {
            super(looper);
            this.aEw = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.log("get message " + message.what);
            switch (message.what) {
                case 1:
                    com.baidu.swan.apps.core.d.d As = f.this.As();
                    if (As != null) {
                        String Ac = As.Ac();
                        if (!TextUtils.isEmpty(Ac)) {
                            f.this.a(As, Ac);
                            this.aEw = 0;
                            return;
                        } else if (this.aEw == 3) {
                            f.this.log("can't get slaveId after retrying 3 times");
                            this.aEw = 0;
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
                    if (cVar != null && f.this.fC(cVar.getToken())) {
                        if (com.baidu.swan.apps.u.a.En().wr()) {
                            f.this.aEk.cO(f.this.d(f.this.As()));
                        }
                        f.this.aEm.HK();
                        f.this.a(cVar, new a() { // from class: com.baidu.swan.apps.y.f.c.1
                            @Override // com.baidu.swan.apps.y.f.a
                            public void bE(boolean z) {
                                f.this.aEm.aEz = z;
                                if (z) {
                                    f.this.log("simple error report");
                                    f.this.a(cVar);
                                }
                            }
                        });
                        f.this.aEm.HL();
                        if (f.this.HC()) {
                            f.this.a(cVar, f.this.aEl, new a() { // from class: com.baidu.swan.apps.y.f.c.2
                                @Override // com.baidu.swan.apps.y.f.a
                                public void bE(boolean z) {
                                    if (z) {
                                        f.this.log("grid error report");
                                        f.this.a(cVar, 28, f.this.HB());
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
                            com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
                            if (vJ != null && vJ.Ar() == null) {
                                f.this.a(new c.a().fA("loading").Hx());
                            }
                        }
                    }, 10000L);
                    return;
                case 5:
                    if (f.this.HC() && f.this.aEm.aEz) {
                        f.this.fE((String) message.obj);
                        return;
                    }
                    return;
                case 6:
                    f.this.mIsBackground = message.arg1 == 0;
                    f.this.log("小程序切入" + (f.this.mIsBackground ? "后台" : "前台"));
                    if (f.this.mIsBackground) {
                        f.this.Hz();
                        return;
                    } else {
                        f.this.HA();
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
    public void Hz() {
        if (this.aEm == null) {
            return;
        }
        if (!this.aEm.isChecked()) {
            log("pause");
            if (this.mHandler != null) {
                this.mHandler.removeCallbacks(this.aEp);
            }
            this.aEm.pause();
        } else if (this.aEm.aEz && HC()) {
            fE("background");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HA() {
        if (this.aEm != null && !this.aEm.isChecked()) {
            log("resume");
            this.aEm.resume();
            long HJ = this.aEm.HJ();
            if (HJ >= 0) {
                this.aEp = new b("", this.aEm.id);
                this.mHandler.postDelayed(this.aEp, HJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HB() {
        String string = com.baidu.swan.apps.storage.b.f.NX().getString("screenshot_upload_switch", "1");
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
        String a2 = a(cVar, z);
        log(a2);
        com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(5L).aa(i).ig(a2);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.Md() != null) {
            bVar = com.baidu.swan.apps.ae.b.Md().vL();
        }
        com.baidu.swan.apps.statistic.a.d cy = new com.baidu.swan.apps.statistic.a.d().a(ig).s(bVar).hv(com.baidu.swan.apps.statistic.e.dP(com.baidu.swan.apps.ae.b.vD())).hw(com.baidu.swan.apps.ae.b.Mo()).hy(String.valueOf(this.aEn.size())).cy(false);
        if (HC() && this.aEo != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("launchlog", this.aEo);
                cy.aj(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.statistic.e.b(cy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HC() {
        return this.aEn.size() > 0 && this.aEm == this.aEn.getFirst();
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
            jSONObject.put("firstPage", HC());
            jSONObject.put("zeus", com.baidu.swan.apps.u.a.Ew().aL(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.HQ());
            if (z) {
                jSONObject.put("image", i(cVar.Hw()));
            }
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.dX(com.baidu.swan.apps.ae.b.vD()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, @NonNull a aVar) {
        com.baidu.swan.apps.res.widget.floatlayer.a vF = com.baidu.swan.apps.w.e.GF().Gr().vF();
        if (!vF.LD() && !HD()) {
            a(cVar, this.aEk, aVar);
            return;
        }
        log("存在native view: " + vF.LD() + "; 存在dailog：" + HD());
        aVar.bE(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull a aVar2) {
        if (cVar == null || aVar == null) {
            aVar2.bE(false);
        } else if (TextUtils.equals(cVar.getToken(), this.aEm.id)) {
            log("start parse");
            aVar2.bE(aVar.a(cVar.Hw(), cVar.getRect()));
        } else {
            aVar2.bE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.core.d.b bVar, String str) {
        String str2 = "";
        if (this.aEm == null || !TextUtils.equals(str, this.aEm.id)) {
            com.baidu.swan.apps.b.c.e dY = com.baidu.swan.apps.w.e.GF().dY(str);
            if (dY != null) {
                dY.a(this);
            }
            this.aEm = new d(str);
            this.aEn.addLast(this.aEm);
            if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                str2 = ((com.baidu.swan.apps.core.d.d) bVar).Af();
            }
            if (!this.mIsBackground) {
                this.aEp = new b(str2, str);
                this.mHandler.postDelayed(this.aEp, this.aEm.HJ());
                return;
            }
            this.aEm.pause();
        }
    }

    private boolean HD() {
        return this.aEi > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fC(@NonNull String str) {
        return this.aEm != null && TextUtils.equals(str, this.aEm.id);
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
            if (f.this.fC(this.token)) {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.f.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap PA;
                        Rect rect;
                        f.this.log("start full capture, slave id: " + b.this.token + "; url:" + b.this.url);
                        AbsoluteLayout fe = com.baidu.swan.apps.w.e.GF().fe(b.this.token);
                        if (fe == null || fe.getWidth() <= 0 || fe.getHeight() <= 0) {
                            f.this.log("invalid webview " + fe);
                            return;
                        }
                        if (f.this.aEf) {
                            f.this.log("get full screenshot");
                            Bitmap am = z.am(fe);
                            int[] iArr = new int[2];
                            fe.getLocationOnScreen(iArr);
                            com.baidu.swan.apps.core.d.d As = f.this.As();
                            if (As != null) {
                                SwanAppActionBar zB = As.zB();
                                int[] iArr2 = new int[2];
                                zB.getLocationOnScreen(iArr2);
                                int height = zB.getHeight() + iArr2[1];
                                if (iArr[1] < height) {
                                    iArr[1] = height + 1;
                                }
                            }
                            int measuredWidth = iArr[0] + fe.getMeasuredWidth();
                            if (measuredWidth > am.getWidth()) {
                                measuredWidth = am.getWidth();
                            }
                            int measuredHeight = iArr[1] + fe.getMeasuredHeight();
                            if (measuredHeight > am.getHeight()) {
                                measuredHeight = am.getHeight();
                            }
                            rect = new Rect(iArr[0], iArr[1], measuredWidth, measuredHeight);
                            PA = am;
                        } else {
                            f.this.log("get webview screenshot");
                            PA = z.PA();
                            rect = new Rect(0, 0, fe.getMeasuredWidth(), fe.getMeasuredHeight());
                        }
                        if (PA != null) {
                            com.baidu.swan.apps.y.c Hx = new c.a().e(rect).fB(b.this.token).h(PA).Hx();
                            Message obtainMessage = f.this.mHandler.obtainMessage(3);
                            obtainMessage.obj = Hx;
                            f.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
            }
        }
    }

    private void g(@NonNull SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.e vJ;
        hZ();
        if (this.mHandler != null && (vJ = swanAppActivity.vJ()) != null) {
            com.baidu.swan.apps.core.d.b Ar = vJ.Ar();
            if (Ar == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (Ar instanceof com.baidu.swan.apps.core.d.d) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    public void h(@NonNull SwanAppActivity swanAppActivity) {
        g(swanAppActivity);
    }

    public void HE() {
        log("stop monitor");
        this.aEh = 0;
        HG();
        this.aEn.clear();
        this.aEm = null;
    }

    public void bz(boolean z) {
        log("this aiapp changes to " + (z ? "background" : "foreground"));
        hZ();
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(6);
            obtainMessage.arg1 = z ? 0 : 1;
            this.mHandler.sendMessageAtFrontOfQueue(obtainMessage);
        }
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
    }

    private String i(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static void HH() {
        final com.baidu.swan.apps.core.d.b Ar;
        com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ != null && (Ar = vJ.Ar()) != null) {
            j.a(new Runnable() { // from class: com.baidu.swan.apps.y.f.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c Hx = new c.a().h(z.am(com.baidu.swan.apps.core.d.b.this.getView())).Hx();
                    g Et = com.baidu.swan.apps.u.a.Et();
                    if (Et != null) {
                        Et.a(Hx, null, null, null);
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
                        this.aEo.put(jSONArray.get(i2));
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

    public void fD(String str) {
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
    public void fE(final String str) {
        SwanAppActivity Gr = com.baidu.swan.apps.w.e.GF().Gr();
        if (Gr != null) {
            final WeakReference weakReference = new WeakReference(Gr);
            ac.k(new Runnable() { // from class: com.baidu.swan.apps.y.f.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c HI;
                    final SwanAppActivity swanAppActivity = (SwanAppActivity) weakReference.get();
                    if (swanAppActivity != null && !swanAppActivity.isFinishing() && !swanAppActivity.isDestroyed() && (HI = f.this.HI()) != null) {
                        f.this.a(HI, new a() { // from class: com.baidu.swan.apps.y.f.3.1
                            @Override // com.baidu.swan.apps.y.f.a
                            public void bE(boolean z) {
                                if (z) {
                                    f.this.log("force close swan app");
                                    swanAppActivity.vK();
                                    com.baidu.swan.apps.ak.a ig = new com.baidu.swan.apps.ak.a().Z(5L).aa(33L).ig(str);
                                    com.baidu.swan.apps.v.b.b bVar = null;
                                    if (com.baidu.swan.apps.ae.b.Md() != null) {
                                        bVar = com.baidu.swan.apps.ae.b.Md().vL();
                                    }
                                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(ig).s(bVar).hv(com.baidu.swan.apps.statistic.e.dP(com.baidu.swan.apps.ae.b.vD())).hw(com.baidu.swan.apps.ae.b.Mo()).hy(String.valueOf(f.this.aEn.size())).cy(false));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.y.c HI() {
        AbsoluteLayout fe = com.baidu.swan.apps.w.e.GF().fe(this.aEm.id);
        if (fe == null || fe.getWidth() <= 0 || fe.getHeight() <= 0) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            fe.getLocationOnScreen(iArr);
            View rootView = fe.getRootView();
            rootView.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache(), iArr[0], iArr[1], 100, fe.getMeasuredHeight());
            rootView.setDrawingCacheEnabled(false);
            return new c.a().h(createBitmap).e(new Rect(0, 0, 100, fe.getMeasuredHeight())).fB(this.aEm.id).Hx();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar != null) {
            com.baidu.swan.apps.ae.a.d zK = dVar.zK();
            if (zK != null) {
                return zK.mBackgroundColor;
            }
            FrameLayout zZ = dVar.zZ();
            if (zZ != null) {
                Drawable background = zZ.getBackground();
                if (background instanceof ColorDrawable) {
                    return ((ColorDrawable) background).getColor();
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.d.d As() {
        com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ != null) {
            com.baidu.swan.apps.core.d.b Ar = vJ.Ar();
            if (Ar instanceof com.baidu.swan.apps.core.d.d) {
                return (com.baidu.swan.apps.core.d.d) Ar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.res.widget.dialog.a aVar) {
        hZ();
        if (this.mHandler != null) {
            Message obtainMessage = this.mHandler.obtainMessage(7);
            obtainMessage.obj = aVar;
            this.mHandler.sendMessageAtFrontOfQueue(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d {
        private int aEA;
        private long aEB;
        private boolean aEz;
        private String id;
        private long startTime;

        private d(String str) {
            this.id = str;
            this.startTime = System.currentTimeMillis();
            this.aEB = f.this.aEj;
            this.aEA = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long HJ() {
            if (this.aEB > 0) {
                this.aEB -= System.currentTimeMillis() - this.startTime;
            }
            return this.aEB;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pause() {
            if (this.aEB > 0) {
                this.aEB -= System.currentTimeMillis() - this.startTime;
            }
            f.this.log("pause this page, remain time is " + this.aEB);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resume() {
            this.startTime = System.currentTimeMillis();
            f.this.log("resume this page");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void HK() {
            this.aEA = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void HL() {
            this.aEA = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isChecked() {
            return this.aEA == 2;
        }
    }
}
