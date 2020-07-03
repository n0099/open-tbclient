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
    private a ctN;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(TAG);
        init();
    }

    private void init() {
        start();
        this.ctN = new a(getLooper());
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
            Message.obtain(this.ctN, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        private d ctO;
        private Deque<d> ctP;
        private com.baidu.swan.apps.aa.b.a ctQ;
        private int ctR;
        private HashMap<String, Integer> ctS;
        private com.baidu.swan.apps.aa.b.a ctT;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.ctP = new ArrayDeque();
            this.mIsBackground = true;
            this.ctR = 0;
            this.ctQ = a.C0289a.mm("simple_parser");
            this.ctT = a.C0289a.mm("hsv_parser");
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
                        TC();
                        return;
                    } else {
                        TA();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.aa.a.a aVar = (com.baidu.swan.apps.aa.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.ctR++;
                            return;
                        } else {
                            this.ctR--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.aa.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.ctP.clear();
                    this.ctO = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.aa.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.aa.a.c) message.obj);
                    return;
                case 10:
                    alh();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.aa.a.c cVar) {
            com.baidu.swan.apps.core.d.d ali = c.ali();
            if (ali != null) {
                String ZH = ali.ZH();
                com.baidu.swan.apps.adaptation.b.c ZM = ali.ZM();
                if (b.DEBUG && ZM == null) {
                    Log.d(b.TAG, "webview manager is null for id " + ZH);
                }
                if (ZM != null && !mi(ZH)) {
                    d dVar = new d(ZH, ali.ZL().mPage, cVar.alz(), cVar.alA());
                    this.ctP.addLast(dVar);
                    this.ctO = dVar;
                    ZM.a((com.baidu.swan.apps.core.f.c) f.alv());
                    if (this.ctS != null && this.ctS.containsKey(ZH)) {
                        this.ctO.cue = this.ctS.remove(ZH).intValue();
                    }
                    if (!this.mIsBackground && dVar.alm() >= 0) {
                        b.this.ctN.sendMessageDelayed(Message.obtain(b.this.ctN, 2, dVar), this.ctO.alm());
                    }
                }
            }
        }

        private boolean mi(String str) {
            return (this.ctO == null || str == null || !TextUtils.equals(str, this.ctO.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && mi(dVar.id)) {
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.aa.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.mj(dVar.id);
                        Bitmap auN = ag.auN();
                        if (auN != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.aa.a.d(dVar.id, auN)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.aa.a.d dVar) {
            if (dVar != null && mi(dVar.aly())) {
                Bitmap alB = dVar.alB();
                com.baidu.swan.apps.core.d.d ali = c.ali();
                AbsoluteLayout lA = com.baidu.swan.apps.w.f.ajb().lA(dVar.aly());
                if (alB != null && lA != null && ali != null) {
                    Rect a = c.a(alB, ali, lA);
                    this.ctQ.gk(c.e(ali));
                    this.ctO.aln();
                    if (c.all() || this.ctR > 0) {
                        this.ctO.cuc = false;
                    } else if (this.ctQ.a(alB, a)) {
                        this.ctO.cuc = true;
                        if (ale()) {
                            this.ctO.m(alB);
                            this.ctO.rect = a;
                        }
                        c.gj(a.h.aiapps_swan_app_error_page_hint);
                        a(this.ctO, 19, false, null);
                    } else {
                        this.ctO.cuc = false;
                    }
                    this.ctO.alo();
                    if (ale() && this.ctT.a(alB, a)) {
                        a(this.ctO, 28, alg(), alB);
                    }
                }
            }
        }

        private boolean ale() {
            return this.ctO != null && this.ctO.cug;
        }

        private void TC() {
            this.mIsBackground = true;
            if (this.ctO != null) {
                if (!this.ctO.isChecked()) {
                    if (b.this.ctN != null) {
                        b.this.ctN.removeMessages(2);
                    }
                    this.ctO.pause();
                } else if (this.ctO.cuc && ale()) {
                    alf();
                }
            }
        }

        private void TA() {
            this.mIsBackground = false;
            if (this.ctO != null && !this.ctO.isChecked()) {
                this.ctO.resume();
                long alm = this.ctO.alm();
                if (alm >= 0) {
                    b.this.ctN.sendMessageDelayed(Message.obtain(b.this.ctN, 2, this.ctO), alm);
                }
            }
        }

        private void a(com.baidu.swan.apps.aa.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String aly = eVar.aly();
                Iterator<d> it = this.ctP.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, aly)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.cue++;
                        return;
                    }
                    if (this.ctS == null) {
                        this.ctS = new HashMap<>();
                    }
                    Integer num2 = this.ctS.get(aly);
                    this.ctS.put(aly, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.cue--;
                } else if (this.ctS != null && (num = this.ctS.get(aly)) != null && num.intValue() > 0) {
                    this.ctS.put(aly, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mj(String str) {
            if (ale()) {
                com.baidu.swan.apps.w.f.ajb().a(com.baidu.swan.apps.al.b.a(new com.baidu.swan.apps.al.b()));
                com.baidu.swan.apps.w.f.ajb().a(str, com.baidu.swan.apps.al.b.a(new com.baidu.swan.apps.al.b()));
                if (b.DEBUG) {
                    Log.d(b.TAG, "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void alf() {
            if (b.DEBUG) {
                Log.d(b.TAG, "recheckAndExit");
            }
            aj.p(new Runnable() { // from class: com.baidu.swan.apps.aa.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity aiL = com.baidu.swan.apps.w.f.ajb().aiL();
                    if (aiL != null && !aiL.isFinishing() && !aiL.isDestroyed() && a.this.ctO != null) {
                        final Bitmap auN = ag.auN();
                        n.auB().execute(new Runnable() { // from class: com.baidu.swan.apps.aa.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.ctQ.a(auN, a.this.ctO.rect)) {
                                    a.this.a(a.this.ctO, 33, false, null);
                                    aj.p(new Runnable() { // from class: com.baidu.swan.apps.aa.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d(b.TAG, "recheckAndExit call activity finish.");
                                            }
                                            aiL.finish();
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
            JSONObject alj = c.alj();
            try {
                alj.put("page", dVar.url);
                alj.put("firstPage", ale());
                if (z && bitmap != null) {
                    alj.put("image", c.l(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(i).pB(alj.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.apM() != null) {
                aVar = com.baidu.swan.apps.runtime.e.apM().RP();
            }
            com.baidu.swan.apps.statistic.a.d fr = new com.baidu.swan.apps.statistic.a.d().f(pB).a(aVar).oK(h.hf(com.baidu.swan.apps.runtime.d.apI().RF())).oL(com.baidu.swan.apps.runtime.e.apO()).oN(String.valueOf(this.ctP.size())).fr(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.cue == 0 ? "0" : "1");
                fr.bA(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (ale()) {
                fr.bA(com.baidu.swan.apps.al.a.arZ().asa());
                fr.bA(com.baidu.swan.apps.al.a.arZ().asb());
            }
            h.b(fr);
        }

        private boolean alg() {
            String string = com.baidu.swan.apps.storage.c.h.asV().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d(b.TAG, "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.aa.a.c cVar) {
            if (cVar.alz() >= 0) {
                com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
                if (RN == null || RN.ZY() <= 0) {
                    if (b.DEBUG) {
                        Log.d(b.TAG, "start loading check: remainTime=" + cVar.alz());
                    }
                    b.this.ctN.sendMessageDelayed(Message.obtain(b.this.ctN, 10, cVar), cVar.alz());
                }
            }
        }

        private void alh() {
            boolean z;
            SwanAppActivity aiL = com.baidu.swan.apps.w.f.ajb().aiL();
            if (aiL != null && !aiL.isFinishing() && !aiL.isDestroyed() && aiL.RJ() != null && aiL.RJ().cQV != null) {
                com.baidu.swan.apps.view.c RJ = aiL.RJ();
                if (RJ == null || RJ.cQV == null) {
                    z = false;
                } else {
                    z = RJ.cQV.getVisibility() == 0;
                }
                if (b.DEBUG) {
                    Log.d(b.TAG, "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(19L).pB("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.apM() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.apM().RP();
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().f(pB).a(aVar).oK(h.hf(com.baidu.swan.apps.runtime.d.apI().RF())).oL(com.baidu.swan.apps.runtime.d.apI().getAppId()).oN(String.valueOf(this.ctP.size())).fr(false));
                }
            }
        }
    }
}
