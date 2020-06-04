package com.baidu.swan.apps.aa;

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
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aa.b.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.aa.a {
    private a coZ;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(TAG);
        init();
    }

    private void init() {
        start();
        this.coZ = new a(getLooper());
    }

    @Override // com.baidu.swan.apps.aa.a
    public void a(com.baidu.swan.apps.aa.a.c cVar) {
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
            Message.obtain(this.coZ, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        private d cpa;
        private Deque<d> cpb;
        private com.baidu.swan.apps.aa.b.a cpc;
        private int cpd;
        private HashMap<String, Integer> cpe;
        private com.baidu.swan.apps.aa.b.a cpf;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.cpb = new ArrayDeque();
            this.mIsBackground = true;
            this.cpd = 0;
            this.cpc = a.C0283a.me("simple_parser");
            this.cpf = a.C0283a.me("hsv_parser");
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
                    b((com.baidu.swan.apps.aa.a.c) message.obj);
                    return;
                case 2:
                    a((d) message.obj);
                    return;
                case 3:
                    removeMessages(2);
                    removeMessages(8);
                    return;
                case 4:
                    if (((com.baidu.swan.apps.aa.a.b) message.obj).isBackground()) {
                        Sw();
                        return;
                    } else {
                        Su();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.aa.a.a aVar = (com.baidu.swan.apps.aa.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.cpd++;
                            return;
                        } else {
                            this.cpd--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.aa.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.cpb.clear();
                    this.cpa = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.aa.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.aa.a.c) message.obj);
                    return;
                case 10:
                    akb();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.aa.a.c cVar) {
            com.baidu.swan.apps.core.d.d akc = c.akc();
            if (akc != null) {
                String YB = akc.YB();
                com.baidu.swan.apps.adaptation.b.c YG = akc.YG();
                if (b.DEBUG && YG == null) {
                    Log.d(b.TAG, "webview manager is null for id " + YB);
                }
                if (YG != null && !ma(YB)) {
                    d dVar = new d(YB, akc.YF().mPage, cVar.akt(), cVar.aku());
                    this.cpb.addLast(dVar);
                    this.cpa = dVar;
                    YG.a((com.baidu.swan.apps.core.f.c) f.akp());
                    if (this.cpe != null && this.cpe.containsKey(YB)) {
                        this.cpa.cpq = this.cpe.remove(YB).intValue();
                    }
                    if (!this.mIsBackground && dVar.akg() >= 0) {
                        b.this.coZ.sendMessageDelayed(Message.obtain(b.this.coZ, 2, dVar), this.cpa.akg());
                    }
                }
            }
        }

        private boolean ma(String str) {
            return (this.cpa == null || str == null || !TextUtils.equals(str, this.cpa.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && ma(dVar.id)) {
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.aa.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mb(dVar.id);
                        Bitmap atH = ag.atH();
                        if (atH != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.aa.a.d(dVar.id, atH)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.aa.a.d dVar) {
            if (dVar != null && ma(dVar.aks())) {
                Bitmap akv = dVar.akv();
                com.baidu.swan.apps.core.d.d akc = c.akc();
                AbsoluteLayout ls = com.baidu.swan.apps.w.f.ahV().ls(dVar.aks());
                if (akv != null && ls != null && akc != null) {
                    Rect a = c.a(akv, akc, ls);
                    this.cpc.fZ(c.e(akc));
                    this.cpa.akh();
                    if (c.akf() || this.cpd > 0) {
                        this.cpa.cpo = false;
                    } else if (this.cpc.a(akv, a)) {
                        this.cpa.cpo = true;
                        if (ajY()) {
                            this.cpa.m(akv);
                            this.cpa.rect = a;
                        }
                        c.fY(a.h.aiapps_swan_app_error_page_hint);
                        a(this.cpa, 19, false, null);
                    } else {
                        this.cpa.cpo = false;
                    }
                    this.cpa.aki();
                    if (ajY() && this.cpf.a(akv, a)) {
                        a(this.cpa, 28, aka(), akv);
                    }
                }
            }
        }

        private boolean ajY() {
            return this.cpa != null && this.cpa.cps;
        }

        private void Sw() {
            this.mIsBackground = true;
            if (this.cpa != null) {
                if (!this.cpa.isChecked()) {
                    if (b.this.coZ != null) {
                        b.this.coZ.removeMessages(2);
                    }
                    this.cpa.pause();
                } else if (this.cpa.cpo && ajY()) {
                    ajZ();
                }
            }
        }

        private void Su() {
            this.mIsBackground = false;
            if (this.cpa != null && !this.cpa.isChecked()) {
                this.cpa.resume();
                long akg = this.cpa.akg();
                if (akg >= 0) {
                    b.this.coZ.sendMessageDelayed(Message.obtain(b.this.coZ, 2, this.cpa), akg);
                }
            }
        }

        private void a(com.baidu.swan.apps.aa.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aks = eVar.aks();
                Iterator<d> it = this.cpb.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aks)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.cpq++;
                        return;
                    }
                    if (this.cpe == null) {
                        this.cpe = new HashMap<>();
                    }
                    Integer num2 = this.cpe.get(aks);
                    this.cpe.put(aks, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.cpq--;
                } else if (this.cpe != null && (num = this.cpe.get(aks)) != null && num.intValue() > 0) {
                    this.cpe.put(aks, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mb(String str) {
            if (ajY()) {
                com.baidu.swan.apps.w.f.ahV().a(com.baidu.swan.apps.al.b.a(new com.baidu.swan.apps.al.b()));
                com.baidu.swan.apps.w.f.ahV().a(str, com.baidu.swan.apps.al.b.a(new com.baidu.swan.apps.al.b()));
                if (b.DEBUG) {
                    Log.d(b.TAG, "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void ajZ() {
            if (b.DEBUG) {
                Log.d(b.TAG, "recheckAndExit");
            }
            aj.p(new Runnable() { // from class: com.baidu.swan.apps.aa.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity ahF = com.baidu.swan.apps.w.f.ahV().ahF();
                    if (ahF != null && !ahF.isFinishing() && !ahF.isDestroyed() && a.this.cpa != null) {
                        final Bitmap atH = ag.atH();
                        n.atv().execute(new Runnable() { // from class: com.baidu.swan.apps.aa.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cpc.a(atH, a.this.cpa.rect)) {
                                    a.this.a(a.this.cpa, 33, false, null);
                                    aj.p(new Runnable() { // from class: com.baidu.swan.apps.aa.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d(b.TAG, "recheckAndExit call activity finish.");
                                            }
                                            ahF.finish();
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
            JSONObject akd = c.akd();
            try {
                akd.put("page", dVar.url);
                akd.put("firstPage", ajY());
                if (z && bitmap != null) {
                    akd.put("image", c.l(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(5L).bx(i).pt(akd.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.aoF() != null) {
                aVar = com.baidu.swan.apps.runtime.e.aoF().QJ();
            }
            com.baidu.swan.apps.statistic.a.d fm = new com.baidu.swan.apps.statistic.a.d().f(pt).a(aVar).oC(h.gU(com.baidu.swan.apps.runtime.d.aoB().Qz())).oD(com.baidu.swan.apps.runtime.e.aoH()).oF(String.valueOf(this.cpb.size())).fm(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.cpq == 0 ? "0" : "1");
                fm.bt(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (ajY()) {
                fm.bt(com.baidu.swan.apps.al.a.aqT().aqU());
                fm.bt(com.baidu.swan.apps.al.a.aqT().aqV());
            }
            h.b(fm);
        }

        private boolean aka() {
            String string = com.baidu.swan.apps.storage.c.h.arO().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d(b.TAG, "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.aa.a.c cVar) {
            if (cVar.akt() >= 0) {
                com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
                if (QH == null || QH.YS() <= 0) {
                    if (b.DEBUG) {
                        Log.d(b.TAG, "start loading check: remainTime=" + cVar.akt());
                    }
                    b.this.coZ.sendMessageDelayed(Message.obtain(b.this.coZ, 10, cVar), cVar.akt());
                }
            }
        }

        private void akb() {
            boolean z;
            SwanAppActivity ahF = com.baidu.swan.apps.w.f.ahV().ahF();
            if (ahF != null && !ahF.isFinishing() && !ahF.isDestroyed() && ahF.QD() != null && ahF.QD().cMl != null) {
                com.baidu.swan.apps.view.c QD = ahF.QD();
                if (QD == null || QD.cMl == null) {
                    z = false;
                } else {
                    z = QD.cMl.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d(b.TAG, "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(5L).bx(19L).pt("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.aoF() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.aoF().QJ();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().f(pt).a(aVar).oC(h.gU(com.baidu.swan.apps.runtime.d.aoB().Qz())).oD(com.baidu.swan.apps.runtime.d.aoB().getAppId()).oF(String.valueOf(this.cpb.size())).fm(false));
                }
            }
        }
    }
}
