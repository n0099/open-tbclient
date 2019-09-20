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
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
    private static volatile f aEE;
    private boolean aED;
    private int aEF;
    private int aEG;
    private long aEH;
    private com.baidu.swan.apps.y.a aEI;
    private com.baidu.swan.apps.y.a aEJ;
    private d aEK;
    private Deque<d> aEL;
    private JSONArray aEM;
    private b aEN;
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
        int i = fVar.aEG;
        fVar.aEG = i + 1;
        return i;
    }

    static /* synthetic */ int l(f fVar) {
        int i = fVar.aEG;
        fVar.aEG = i - 1;
        return i;
    }

    private f() {
        super("SwanAppPageMonitor", 5);
        this.aEF = 0;
        this.aEG = 0;
        this.aEL = new ArrayDeque();
        this.aEM = new JSONArray();
        this.mIsBackground = true;
        this.aEH = com.baidu.swan.apps.u.a.Er().wj() * 1000;
        this.aEI = a.C0206a.fB("simple_parser");
        this.aEJ = a.C0206a.fB("hsv_parser");
        this.aED = com.baidu.swan.apps.u.a.Er().wu();
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

    public static f HC() {
        if (aEE == null) {
            synchronized (f.class) {
                if (aEE == null) {
                    aEE = new f();
                }
            }
        }
        return aEE;
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
            HK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {
        int aEU;

        private c(Looper looper) {
            super(looper);
            this.aEU = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            f.this.log("get message " + message.what);
            switch (message.what) {
                case 1:
                    com.baidu.swan.apps.core.d.d Aw = f.this.Aw();
                    if (Aw != null) {
                        String Ag = Aw.Ag();
                        if (!TextUtils.isEmpty(Ag)) {
                            f.this.a(Aw, Ag);
                            this.aEU = 0;
                            return;
                        } else if (this.aEU == 3) {
                            f.this.log("can't get slaveId after retrying 3 times");
                            this.aEU = 0;
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
                    if (cVar != null && f.this.fE(cVar.getToken())) {
                        if (com.baidu.swan.apps.u.a.Er().wv()) {
                            f.this.aEI.cP(f.this.d(f.this.Aw()));
                        }
                        f.this.aEK.HO();
                        f.this.a(cVar, new a() { // from class: com.baidu.swan.apps.y.f.c.1
                            @Override // com.baidu.swan.apps.y.f.a
                            public void bE(boolean z) {
                                f.this.aEK.aEX = z;
                                if (z) {
                                    f.this.log("simple error report");
                                    f.this.a(cVar);
                                }
                            }
                        });
                        f.this.aEK.HP();
                        if (f.this.HG()) {
                            f.this.a(cVar, f.this.aEJ, new a() { // from class: com.baidu.swan.apps.y.f.c.2
                                @Override // com.baidu.swan.apps.y.f.a
                                public void bE(boolean z) {
                                    if (z) {
                                        f.this.log("grid error report");
                                        f.this.a(cVar, 28, f.this.HF());
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
                            com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
                            if (vN != null && vN.Av() == null) {
                                f.this.a(new c.a().fC("loading").HB());
                            }
                        }
                    }, 10000L);
                    return;
                case 5:
                    if (f.this.HG() && f.this.aEK.aEX) {
                        f.this.fG((String) message.obj);
                        return;
                    }
                    return;
                case 6:
                    f.this.mIsBackground = message.arg1 == 0;
                    f.this.log("小程序切入" + (f.this.mIsBackground ? "后台" : "前台"));
                    if (f.this.mIsBackground) {
                        f.this.HD();
                        return;
                    } else {
                        f.this.HE();
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
    public void HD() {
        if (this.aEK == null) {
            return;
        }
        if (!this.aEK.isChecked()) {
            log("pause");
            if (this.mHandler != null) {
                this.mHandler.removeCallbacks(this.aEN);
            }
            this.aEK.pause();
        } else if (this.aEK.aEX && HG()) {
            fG("background");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HE() {
        if (this.aEK != null && !this.aEK.isChecked()) {
            log("resume");
            this.aEK.resume();
            long HN = this.aEK.HN();
            if (HN >= 0) {
                this.aEN = new b("", this.aEK.id);
                this.mHandler.postDelayed(this.aEN, HN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HF() {
        String string = com.baidu.swan.apps.storage.b.f.Ob().getString("screenshot_upload_switch", "1");
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
        String a2 = a(cVar, z);
        log(a2);
        com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(i).ii(a2);
        com.baidu.swan.apps.v.b.b bVar = null;
        if (com.baidu.swan.apps.ae.b.Mh() != null) {
            bVar = com.baidu.swan.apps.ae.b.Mh().vP();
        }
        com.baidu.swan.apps.statistic.a.d cy = new com.baidu.swan.apps.statistic.a.d().a(ii).s(bVar).hx(com.baidu.swan.apps.statistic.e.dQ(com.baidu.swan.apps.ae.b.vH())).hy(com.baidu.swan.apps.ae.b.Ms()).hA(String.valueOf(this.aEL.size())).cy(false);
        if (HG() && this.aEM != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("launchlog", this.aEM);
                cy.aj(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        com.baidu.swan.apps.statistic.e.b(cy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean HG() {
        return this.aEL.size() > 0 && this.aEK == this.aEL.getFirst();
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
            jSONObject.put("firstPage", HG());
            jSONObject.put("zeus", com.baidu.swan.apps.u.a.EA().aL(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.HU());
            if (z) {
                jSONObject.put("image", i(cVar.HA()));
            }
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.dY(com.baidu.swan.apps.ae.b.vH()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, @NonNull a aVar) {
        com.baidu.swan.apps.res.widget.floatlayer.a vJ = com.baidu.swan.apps.w.e.GJ().Gv().vJ();
        if (!vJ.LH() && !HH()) {
            a(cVar, this.aEI, aVar);
            return;
        }
        log("存在native view: " + vJ.LH() + "; 存在dailog：" + HH());
        aVar.bE(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.y.c cVar, com.baidu.swan.apps.y.a aVar, @NonNull a aVar2) {
        if (cVar == null || aVar == null) {
            aVar2.bE(false);
        } else if (TextUtils.equals(cVar.getToken(), this.aEK.id)) {
            log("start parse");
            aVar2.bE(aVar.a(cVar.HA(), cVar.getRect()));
        } else {
            aVar2.bE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.core.d.b bVar, String str) {
        String str2 = "";
        if (this.aEK == null || !TextUtils.equals(str, this.aEK.id)) {
            com.baidu.swan.apps.b.c.e ea = com.baidu.swan.apps.w.e.GJ().ea(str);
            if (ea != null) {
                ea.a(this);
            }
            this.aEK = new d(str);
            this.aEL.addLast(this.aEK);
            if (bVar instanceof com.baidu.swan.apps.core.d.d) {
                str2 = ((com.baidu.swan.apps.core.d.d) bVar).Aj();
            }
            if (!this.mIsBackground) {
                this.aEN = new b(str2, str);
                this.mHandler.postDelayed(this.aEN, this.aEK.HN());
                return;
            }
            this.aEK.pause();
        }
    }

    private boolean HH() {
        return this.aEG > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fE(@NonNull String str) {
        return this.aEK != null && TextUtils.equals(str, this.aEK.id);
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
            if (f.this.fE(this.token)) {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.f.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap PE;
                        Rect rect;
                        f.this.log("start full capture, slave id: " + b.this.token + "; url:" + b.this.url);
                        AbsoluteLayout fg = com.baidu.swan.apps.w.e.GJ().fg(b.this.token);
                        if (fg == null || fg.getWidth() <= 0 || fg.getHeight() <= 0) {
                            f.this.log("invalid webview " + fg);
                            return;
                        }
                        if (f.this.aED) {
                            f.this.log("get full screenshot");
                            Bitmap am = z.am(fg);
                            int[] iArr = new int[2];
                            fg.getLocationOnScreen(iArr);
                            com.baidu.swan.apps.core.d.d Aw = f.this.Aw();
                            if (Aw != null) {
                                SwanAppActionBar zF = Aw.zF();
                                int[] iArr2 = new int[2];
                                zF.getLocationOnScreen(iArr2);
                                int height = zF.getHeight() + iArr2[1];
                                if (iArr[1] < height) {
                                    iArr[1] = height + 1;
                                }
                            }
                            int measuredWidth = iArr[0] + fg.getMeasuredWidth();
                            if (measuredWidth > am.getWidth()) {
                                measuredWidth = am.getWidth();
                            }
                            int measuredHeight = iArr[1] + fg.getMeasuredHeight();
                            if (measuredHeight > am.getHeight()) {
                                measuredHeight = am.getHeight();
                            }
                            rect = new Rect(iArr[0], iArr[1], measuredWidth, measuredHeight);
                            PE = am;
                        } else {
                            f.this.log("get webview screenshot");
                            PE = z.PE();
                            rect = new Rect(0, 0, fg.getMeasuredWidth(), fg.getMeasuredHeight());
                        }
                        if (PE != null) {
                            com.baidu.swan.apps.y.c HB = new c.a().e(rect).fD(b.this.token).h(PE).HB();
                            Message obtainMessage = f.this.mHandler.obtainMessage(3);
                            obtainMessage.obj = HB;
                            f.this.mHandler.sendMessage(obtainMessage);
                        }
                    }
                });
            }
        }
    }

    private void g(@NonNull SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.e vN;
        hZ();
        if (this.mHandler != null && (vN = swanAppActivity.vN()) != null) {
            com.baidu.swan.apps.core.d.b Av = vN.Av();
            if (Av == null) {
                this.mHandler.sendEmptyMessage(4);
            } else if (Av instanceof com.baidu.swan.apps.core.d.d) {
                this.mHandler.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    public void h(@NonNull SwanAppActivity swanAppActivity) {
        g(swanAppActivity);
    }

    public void HI() {
        log("stop monitor");
        this.aEF = 0;
        HK();
        this.aEL.clear();
        this.aEK = null;
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
    }

    private String i(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static void HL() {
        final com.baidu.swan.apps.core.d.b Av;
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN != null && (Av = vN.Av()) != null) {
            j.a(new Runnable() { // from class: com.baidu.swan.apps.y.f.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c HB = new c.a().h(z.am(com.baidu.swan.apps.core.d.b.this.getView())).HB();
                    g Ex = com.baidu.swan.apps.u.a.Ex();
                    if (Ex != null) {
                        Ex.a(HB, null, null, null);
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
                        this.aEM.put(jSONArray.get(i2));
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

    public void fF(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("actionId", str);
                jSONObject.put(DpStatConstants.KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
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
    public void fG(final String str) {
        SwanAppActivity Gv = com.baidu.swan.apps.w.e.GJ().Gv();
        if (Gv != null) {
            final WeakReference weakReference = new WeakReference(Gv);
            ac.k(new Runnable() { // from class: com.baidu.swan.apps.y.f.3
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.y.c HM;
                    final SwanAppActivity swanAppActivity = (SwanAppActivity) weakReference.get();
                    if (swanAppActivity != null && !swanAppActivity.isFinishing() && !swanAppActivity.isDestroyed() && (HM = f.this.HM()) != null) {
                        f.this.a(HM, new a() { // from class: com.baidu.swan.apps.y.f.3.1
                            @Override // com.baidu.swan.apps.y.f.a
                            public void bE(boolean z) {
                                if (z) {
                                    f.this.log("force close swan app");
                                    swanAppActivity.vO();
                                    com.baidu.swan.apps.ak.a ii = new com.baidu.swan.apps.ak.a().Z(5L).aa(33L).ii(str);
                                    com.baidu.swan.apps.v.b.b bVar = null;
                                    if (com.baidu.swan.apps.ae.b.Mh() != null) {
                                        bVar = com.baidu.swan.apps.ae.b.Mh().vP();
                                    }
                                    com.baidu.swan.apps.statistic.e.b(new com.baidu.swan.apps.statistic.a.d().a(ii).s(bVar).hx(com.baidu.swan.apps.statistic.e.dQ(com.baidu.swan.apps.ae.b.vH())).hy(com.baidu.swan.apps.ae.b.Ms()).hA(String.valueOf(f.this.aEL.size())).cy(false));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.y.c HM() {
        AbsoluteLayout fg = com.baidu.swan.apps.w.e.GJ().fg(this.aEK.id);
        if (fg == null || fg.getWidth() <= 0 || fg.getHeight() <= 0) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            fg.getLocationOnScreen(iArr);
            View rootView = fg.getRootView();
            rootView.setDrawingCacheEnabled(true);
            Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache(), iArr[0], iArr[1], 100, fg.getMeasuredHeight());
            rootView.setDrawingCacheEnabled(false);
            return new c.a().h(createBitmap).e(new Rect(0, 0, 100, fg.getMeasuredHeight())).fD(this.aEK.id).HB();
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar != null) {
            com.baidu.swan.apps.ae.a.d zO = dVar.zO();
            if (zO != null) {
                return zO.mBackgroundColor;
            }
            FrameLayout Ad = dVar.Ad();
            if (Ad != null) {
                Drawable background = Ad.getBackground();
                if (background instanceof ColorDrawable) {
                    return ((ColorDrawable) background).getColor();
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.core.d.d Aw() {
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN != null) {
            com.baidu.swan.apps.core.d.b Av = vN.Av();
            if (Av instanceof com.baidu.swan.apps.core.d.d) {
                return (com.baidu.swan.apps.core.d.d) Av;
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
        private boolean aEX;
        private int aEY;
        private long aEZ;
        private String id;
        private long startTime;

        private d(String str) {
            this.id = str;
            this.startTime = System.currentTimeMillis();
            this.aEZ = f.this.aEH;
            this.aEY = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long HN() {
            if (this.aEZ > 0) {
                this.aEZ -= System.currentTimeMillis() - this.startTime;
            }
            return this.aEZ;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pause() {
            if (this.aEZ > 0) {
                this.aEZ -= System.currentTimeMillis() - this.startTime;
            }
            f.this.log("pause this page, remain time is " + this.aEZ);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resume() {
            this.startTime = System.currentTimeMillis();
            f.this.log("resume this page");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void HO() {
            this.aEY = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void HP() {
            this.aEY = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isChecked() {
            return this.aEY == 2;
        }
    }
}
