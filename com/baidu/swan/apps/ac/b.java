package com.baidu.swan.apps.ac;

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
import com.baidu.swan.apps.ac.b.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.x.b.b;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.ac.a {
    private a ces;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(TAG);
        init();
    }

    private void init() {
        start();
        this.ces = new a(getLooper());
    }

    @Override // com.baidu.swan.apps.ac.a
    public void a(com.baidu.swan.apps.ac.a.c cVar) {
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
            Message.obtain(this.ces, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends Handler {
        private d cet;
        private Deque<d> ceu;
        private com.baidu.swan.apps.ac.b.a cev;
        private int cew;
        private HashMap<String, Integer> cex;
        private com.baidu.swan.apps.ac.b.a cey;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.ceu = new ArrayDeque();
            this.mIsBackground = true;
            this.cew = 0;
            this.cev = a.C0251a.kQ("simple_parser");
            this.cey = a.C0251a.kQ("hsv_parser");
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
                    b((com.baidu.swan.apps.ac.a.c) message.obj);
                    return;
                case 2:
                    a((d) message.obj);
                    return;
                case 3:
                    removeMessages(2);
                    removeMessages(8);
                    return;
                case 4:
                    if (((com.baidu.swan.apps.ac.a.b) message.obj).isBackground()) {
                        PF();
                        return;
                    } else {
                        PD();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.ac.a.a aVar = (com.baidu.swan.apps.ac.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.cew++;
                            return;
                        } else {
                            this.cew--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.ac.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.ceu.clear();
                    this.cet = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.ac.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.ac.a.c) message.obj);
                    return;
                case 10:
                    agI();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.ac.a.c cVar) {
            com.baidu.swan.apps.core.d.d agJ = c.agJ();
            if (agJ != null) {
                String VP = agJ.VP();
                com.baidu.swan.apps.adaptation.b.c VT = agJ.VT();
                if (b.DEBUG && VT == null) {
                    Log.d(b.TAG, "webview manager is null for id " + VP);
                }
                if (VT != null && !kM(VP)) {
                    d dVar = new d(VP, agJ.VS().mPage, cVar.aha(), cVar.ahb());
                    this.ceu.addLast(dVar);
                    this.cet = dVar;
                    VT.a((com.baidu.swan.apps.core.f.c) f.agW());
                    if (this.cex != null && this.cex.containsKey(VP)) {
                        this.cet.ceJ = this.cex.remove(VP).intValue();
                    }
                    if (!this.mIsBackground && dVar.agN() >= 0) {
                        b.this.ces.sendMessageDelayed(Message.obtain(b.this.ces, 2, dVar), this.cet.agN());
                    }
                }
            }
        }

        private boolean kM(String str) {
            return (this.cet == null || str == null || !TextUtils.equals(str, this.cet.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && kM(dVar.id)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.kN(dVar.id);
                        Bitmap apg = af.apg();
                        if (apg != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.ac.a.d(dVar.id, apg)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.ac.a.d dVar) {
            if (dVar != null && kM(dVar.agZ())) {
                Bitmap ahc = dVar.ahc();
                com.baidu.swan.apps.core.d.d agJ = c.agJ();
                AbsoluteLayout kf = com.baidu.swan.apps.y.f.aeJ().kf(dVar.agZ());
                if (ahc != null && kf != null && agJ != null) {
                    Rect a = c.a(ahc, agJ, kf);
                    this.cev.fI(c.e(agJ));
                    this.cet.agO();
                    if (c.agM() || this.cew > 0) {
                        this.cet.ceH = false;
                    } else if (this.cev.a(ahc, a)) {
                        this.cet.ceH = true;
                        if (agF()) {
                            this.cet.m(ahc);
                            this.cet.rect = a;
                        }
                        c.fH(a.h.aiapps_swan_app_error_page_hint);
                        a(this.cet, 19, false, null);
                    } else {
                        this.cet.ceH = false;
                    }
                    this.cet.agP();
                    if (agF() && this.cey.a(ahc, a)) {
                        a(this.cet, 28, agH(), ahc);
                    }
                }
            }
        }

        private boolean agF() {
            return this.cet != null && this.cet.ceL;
        }

        private void PF() {
            this.mIsBackground = true;
            if (this.cet != null) {
                if (!this.cet.isChecked()) {
                    if (b.this.ces != null) {
                        b.this.ces.removeMessages(2);
                    }
                    this.cet.pause();
                } else if (this.cet.ceH && agF()) {
                    agG();
                }
            }
        }

        private void PD() {
            this.mIsBackground = false;
            if (this.cet != null && !this.cet.isChecked()) {
                this.cet.resume();
                long agN = this.cet.agN();
                if (agN >= 0) {
                    b.this.ces.sendMessageDelayed(Message.obtain(b.this.ces, 2, this.cet), agN);
                }
            }
        }

        private void a(com.baidu.swan.apps.ac.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String agZ = eVar.agZ();
                Iterator<d> it = this.ceu.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, agZ)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.ceJ++;
                        return;
                    }
                    if (this.cex == null) {
                        this.cex = new HashMap<>();
                    }
                    Integer num2 = this.cex.get(agZ);
                    this.cex.put(agZ, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.ceJ--;
                } else if (this.cex != null && (num = this.cex.get(agZ)) != null && num.intValue() > 0) {
                    this.cex.put(agZ, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void kN(String str) {
            if (agF()) {
                com.baidu.swan.apps.y.f.aeJ().a(com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                com.baidu.swan.apps.y.f.aeJ().a(str, com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                if (b.DEBUG) {
                    Log.d(b.TAG, "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void agG() {
            if (b.DEBUG) {
                Log.d(b.TAG, "recheckAndExit");
            }
            ai.o(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity aeu = com.baidu.swan.apps.y.f.aeJ().aeu();
                    if (aeu != null && !aeu.isFinishing() && !aeu.isDestroyed() && a.this.cet != null) {
                        final Bitmap apg = af.apg();
                        m.aoU().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.cev.a(apg, a.this.cet.rect)) {
                                    a.this.a(a.this.cet, 33, false, null);
                                    ai.o(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d(b.TAG, "recheckAndExit call activity finish.");
                                            }
                                            aeu.finish();
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
            JSONObject agK = c.agK();
            try {
                agK.put("page", dVar.url);
                agK.put("firstPage", agF());
                if (z && bitmap != null) {
                    agK.put("image", c.l(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(i).nL(agK.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.akM() != null) {
                aVar = com.baidu.swan.apps.runtime.e.akM().Ov();
            }
            com.baidu.swan.apps.statistic.a.d eS = new com.baidu.swan.apps.statistic.a.d().e(nL).a(aVar).mZ(com.baidu.swan.apps.statistic.f.gz(com.baidu.swan.apps.runtime.d.akJ().Ol())).na(com.baidu.swan.apps.runtime.e.akO()).nc(String.valueOf(this.ceu.size())).eS(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.ceJ == 0 ? "0" : "1");
                eS.bk(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (agF()) {
                eS.bk(com.baidu.swan.apps.an.a.amO().amP());
                eS.bk(com.baidu.swan.apps.an.a.amO().amQ());
            }
            com.baidu.swan.apps.statistic.f.b(eS);
        }

        private boolean agH() {
            String string = h.any().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d(b.TAG, "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.ac.a.c cVar) {
            if (cVar.aha() >= 0) {
                com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
                if (Ot == null || Ot.Wg() <= 0) {
                    if (b.DEBUG) {
                        Log.d(b.TAG, "start loading check: remainTime=" + cVar.aha());
                    }
                    b.this.ces.sendMessageDelayed(Message.obtain(b.this.ces, 10, cVar), cVar.aha());
                }
            }
        }

        private void agI() {
            SwanAppActivity aeu = com.baidu.swan.apps.y.f.aeJ().aeu();
            if (aeu != null && !aeu.isFinishing() && !aeu.isDestroyed() && aeu.Op() != null && aeu.Op().czq != null) {
                boolean z = aeu.Op().czq.getVisibility() == 0;
                if (b.DEBUG) {
                    Log.d(b.TAG, "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(19L).nL("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.akM() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.akM().Ov();
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(nL).a(aVar).mZ(com.baidu.swan.apps.statistic.f.gz(com.baidu.swan.apps.runtime.d.akJ().Ol())).na(com.baidu.swan.apps.runtime.d.akJ().getAppId()).nc(String.valueOf(this.ceu.size())).eS(false));
                }
            }
        }
    }
}
