package com.baidu.swan.apps.z;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.z.b.a;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.z.a {
    private a cvP;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(TAG);
        init();
    }

    private void init() {
        start();
        this.cvP = new a(getLooper());
    }

    @Override // com.baidu.swan.apps.z.a
    public void a(com.baidu.swan.apps.z.a.c cVar) {
        if (!isAlive()) {
            if (DEBUG) {
                Log.d(TAG, "thread is not alive");
            }
            try {
                init();
            } catch (Error | Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (cVar != null) {
            Message.obtain(this.cvP, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends Handler {
        private d cvQ;
        private Deque<d> cvR;
        private com.baidu.swan.apps.z.b.a cvS;
        private int cvT;
        private HashMap<String, Integer> cvU;
        private com.baidu.swan.apps.z.b.a cvV;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.cvR = new ArrayDeque();
            this.mIsBackground = true;
            this.cvT = 0;
            this.cvS = a.C0416a.mK("simple_parser");
            this.cvV = a.C0416a.mK("hsv_parser");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (b.DEBUG) {
                Log.d(b.TAG, "get message " + message.what);
            }
            switch (message.what) {
                case 1:
                    removeMessages(9);
                    removeMessages(10);
                    b((com.baidu.swan.apps.z.a.c) message.obj);
                    return;
                case 2:
                    a((d) message.obj);
                    return;
                case 3:
                    removeMessages(2);
                    removeMessages(8);
                    return;
                case 4:
                    if (((com.baidu.swan.apps.z.a.b) message.obj).isBackground()) {
                        Uc();
                        return;
                    } else {
                        Ua();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.z.a.a aVar = (com.baidu.swan.apps.z.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.cvT++;
                            return;
                        } else {
                            this.cvT--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.z.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.cvR.clear();
                    this.cvQ = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.z.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.z.a.c) message.obj);
                    return;
                case 10:
                    amy();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.z.a.c cVar) {
            com.baidu.swan.apps.core.d.e amz = c.amz();
            if (amz != null) {
                String aaL = amz.aaL();
                com.baidu.swan.apps.adaptation.b.c aaQ = amz.aaQ();
                if (b.DEBUG && aaQ == null) {
                    Log.d(b.TAG, "webview manager is null for id " + aaL);
                }
                if (aaQ != null && !mG(aaL)) {
                    d dVar = new d(aaL, amz.aaP().mPage, cVar.amQ(), cVar.amR());
                    this.cvR.addLast(dVar);
                    this.cvQ = dVar;
                    aaQ.a((com.baidu.swan.apps.core.f.c) f.amM());
                    if (this.cvU != null && this.cvU.containsKey(aaL)) {
                        this.cvQ.cwh = this.cvU.remove(aaL).intValue();
                    }
                    if (!this.mIsBackground && dVar.amD() >= 0) {
                        b.this.cvP.sendMessageDelayed(Message.obtain(b.this.cvP, 2, dVar), this.cvQ.amD());
                    }
                }
            }
        }

        private boolean mG(String str) {
            return (this.cvQ == null || str == null || !TextUtils.equals(str, this.cvQ.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && mG(dVar.id)) {
                al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.z.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mH(dVar.id);
                        Bitmap awT = ai.awT();
                        if (awT != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.z.a.d(dVar.id, awT)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.z.a.d dVar) {
            if (dVar != null && mG(dVar.amP())) {
                Bitmap amS = dVar.amS();
                com.baidu.swan.apps.core.d.e amz = c.amz();
                AbsoluteLayout mb = com.baidu.swan.apps.v.f.akr().mb(dVar.amP());
                if (amS != null && mb != null && amz != null) {
                    Rect a = c.a(amS, amz, mb);
                    this.cvS.gu(c.e(amz));
                    this.cvQ.amE();
                    if (c.amC() || this.cvT > 0) {
                        this.cvQ.cwf = false;
                    } else if (this.cvS.a(amS, a)) {
                        this.cvQ.cwf = true;
                        boolean amv = amv();
                        if (amv) {
                            this.cvQ.p(amS);
                            this.cvQ.rect = a;
                        }
                        c.eF(amv);
                        a(this.cvQ, 19, false, null);
                    } else {
                        this.cvQ.cwf = false;
                    }
                    this.cvQ.amF();
                    if (amv() && this.cvV.a(amS, a)) {
                        a(this.cvQ, 28, amx(), amS);
                    }
                }
            }
        }

        private boolean amv() {
            return this.cvQ != null && this.cvQ.cwj;
        }

        private void Uc() {
            this.mIsBackground = true;
            if (this.cvQ != null) {
                if (!this.cvQ.isChecked()) {
                    if (b.this.cvP != null) {
                        b.this.cvP.removeMessages(2);
                    }
                    this.cvQ.pause();
                } else if (this.cvQ.cwf && amv()) {
                    amw();
                }
            }
        }

        private void Ua() {
            this.mIsBackground = false;
            if (this.cvQ != null && !this.cvQ.isChecked()) {
                this.cvQ.resume();
                long amD = this.cvQ.amD();
                if (amD >= 0) {
                    b.this.cvP.sendMessageDelayed(Message.obtain(b.this.cvP, 2, this.cvQ), amD);
                }
            }
        }

        private void a(com.baidu.swan.apps.z.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String amP = eVar.amP();
                Iterator<d> it = this.cvR.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, amP)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.cwh++;
                        return;
                    }
                    if (this.cvU == null) {
                        this.cvU = new HashMap<>();
                    }
                    Integer num2 = this.cvU.get(amP);
                    this.cvU.put(amP, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.cwh--;
                } else if (this.cvU != null && (num = this.cvU.get(amP)) != null && num.intValue() > 0) {
                    this.cvU.put(amP, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mH(String str) {
            if (amv()) {
                com.baidu.swan.apps.v.f.akr().a(com.baidu.swan.apps.al.b.a(new com.baidu.swan.apps.al.b()));
                com.baidu.swan.apps.v.f.akr().a(str, com.baidu.swan.apps.al.b.a(new com.baidu.swan.apps.al.b()));
                if (b.DEBUG) {
                    Log.d(b.TAG, "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void amw() {
            if (b.DEBUG) {
                Log.d(b.TAG, "recheckAndExit");
            }
            al.p(new Runnable() { // from class: com.baidu.swan.apps.z.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
                    if (akb != null && !akb.isFinishing() && !akb.isDestroyed() && a.this.cvQ != null) {
                        final Bitmap awT = ai.awT();
                        p.awD().execute(new Runnable() { // from class: com.baidu.swan.apps.z.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cvS.a(awT, a.this.cvQ.rect)) {
                                    a.this.a(a.this.cvQ, 33, false, null);
                                    al.p(new Runnable() { // from class: com.baidu.swan.apps.z.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d(b.TAG, "recheckAndExit call activity finish.");
                                            }
                                            akb.finish();
                                        }
                                    });
                                }
                            }
                        }, "SwanPageMonitorRecheck");
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar, int i, boolean z, Bitmap bitmap) {
            if (b.DEBUG) {
                Log.d(b.TAG, "errorReport: error report with error=" + i);
            }
            JSONObject amA = c.amA();
            try {
                amA.put("page", dVar.url);
                amA.put("firstPage", amv());
                if (z && bitmap != null) {
                    amA.put("image", c.o(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(i).qm(amA.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.arv() != null) {
                aVar = com.baidu.swan.apps.runtime.e.arv().Se();
            }
            com.baidu.swan.apps.statistic.a.d fA = new com.baidu.swan.apps.statistic.a.d().f(qm).a(aVar).pu(h.ho(com.baidu.swan.apps.runtime.d.arr().RU())).pv(com.baidu.swan.apps.runtime.e.arx()).px(String.valueOf(this.cvR.size())).fA(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.cwh == 0 ? "0" : "1");
                fA.bF(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (amv()) {
                fA.bF(com.baidu.swan.apps.al.a.atW().atX());
                fA.bF(com.baidu.swan.apps.al.a.atW().atY());
            }
            h.b(fA);
        }

        private boolean amx() {
            String string = com.baidu.swan.apps.storage.c.h.auW().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d(b.TAG, "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.z.a.c cVar) {
            if (cVar.amQ() >= 0) {
                com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
                if (Sc == null || Sc.abc() <= 0) {
                    if (b.DEBUG) {
                        Log.d(b.TAG, "start loading check: remainTime=" + cVar.amQ());
                    }
                    b.this.cvP.sendMessageDelayed(Message.obtain(b.this.cvP, 10, cVar), cVar.amQ());
                }
            }
        }

        private void amy() {
            boolean z;
            SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
            if (akb != null && !akb.isFinishing() && !akb.isDestroyed() && akb.RY() != null && akb.RY().cUw != null) {
                com.baidu.swan.apps.view.c RY = akb.RY();
                if (RY == null || RY.cUw == null) {
                    z = false;
                } else {
                    z = RY.cUw.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d(b.TAG, "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(5L).bK(19L).qm("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.arv() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.arv().Se();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().f(qm).a(aVar).pu(h.ho(com.baidu.swan.apps.runtime.d.arr().RU())).pv(com.baidu.swan.apps.runtime.d.arr().getAppId()).px(String.valueOf(this.cvR.size())).fA(false));
                }
            }
        }
    }
}
