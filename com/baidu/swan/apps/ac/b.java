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
/* loaded from: classes9.dex */
public class b extends HandlerThread implements com.baidu.swan.apps.ac.a {
    private a bAx;
    private static final String TAG = f.TAG;
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        super(TAG);
        init();
    }

    private void init() {
        start();
        this.bAx = new a(getLooper());
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
            Message.obtain(this.bAx, cVar.getId(), cVar).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends Handler {
        private com.baidu.swan.apps.ac.b.a bAA;
        private int bAB;
        private HashMap<String, Integer> bAC;
        private com.baidu.swan.apps.ac.b.a bAD;
        private d bAy;
        private Deque<d> bAz;
        private boolean mIsBackground;

        a(Looper looper) {
            super(looper);
            this.bAz = new ArrayDeque();
            this.mIsBackground = true;
            this.bAB = 0;
            this.bAA = a.C0188a.jm("simple_parser");
            this.bAD = a.C0188a.jm("hsv_parser");
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
                        Fe();
                        return;
                    } else {
                        Fc();
                        return;
                    }
                case 5:
                    com.baidu.swan.apps.ac.a.a aVar = (com.baidu.swan.apps.ac.a.a) message.obj;
                    if (aVar != null) {
                        if (aVar.isShow()) {
                            this.bAB++;
                            return;
                        } else {
                            this.bAB--;
                            return;
                        }
                    }
                    return;
                case 6:
                    a((com.baidu.swan.apps.ac.a.e) message.obj);
                    return;
                case 7:
                    removeMessages(-1, null);
                    this.bAz.clear();
                    this.bAy = null;
                    return;
                case 8:
                    a((com.baidu.swan.apps.ac.a.d) message.obj);
                    return;
                case 9:
                    c((com.baidu.swan.apps.ac.a.c) message.obj);
                    return;
                case 10:
                    VN();
                    return;
                default:
                    return;
            }
        }

        private void b(com.baidu.swan.apps.ac.a.c cVar) {
            com.baidu.swan.apps.core.d.d VO = c.VO();
            if (VO != null) {
                String Ln = VO.Ln();
                com.baidu.swan.apps.adaptation.b.c Lr = VO.Lr();
                if (b.DEBUG && Lr == null) {
                    Log.d(b.TAG, "webview manager is null for id " + Ln);
                }
                if (Lr != null && !ji(Ln)) {
                    d dVar = new d(Ln, VO.Lq().mPage, cVar.Wf(), cVar.Wg());
                    this.bAz.addLast(dVar);
                    this.bAy = dVar;
                    Lr.a((com.baidu.swan.apps.core.f.c) f.Wb());
                    if (this.bAC != null && this.bAC.containsKey(Ln)) {
                        this.bAy.bAP = this.bAC.remove(Ln).intValue();
                    }
                    if (!this.mIsBackground && dVar.VS() >= 0) {
                        b.this.bAx.sendMessageDelayed(Message.obtain(b.this.bAx, 2, dVar), this.bAy.VS());
                    }
                }
            }
        }

        private boolean ji(String str) {
            return (this.bAy == null || str == null || !TextUtils.equals(str, this.bAy.id)) ? false : true;
        }

        private void a(final d dVar) {
            if (dVar != null && ji(dVar.id)) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jj(dVar.id);
                        Bitmap aeo = af.aeo();
                        if (aeo != null) {
                            Message.obtain(a.this, 8, new com.baidu.swan.apps.ac.a.d(dVar.id, aeo)).sendToTarget();
                        }
                    }
                });
            }
        }

        private void a(com.baidu.swan.apps.ac.a.d dVar) {
            if (dVar != null && ji(dVar.We())) {
                Bitmap Wh = dVar.Wh();
                com.baidu.swan.apps.core.d.d VO = c.VO();
                AbsoluteLayout iB = com.baidu.swan.apps.y.f.Uf().iB(dVar.We());
                if (Wh != null && iB != null && VO != null) {
                    Rect a = c.a(Wh, VO, iB);
                    this.bAA.fk(c.e(VO));
                    this.bAy.VT();
                    if (c.VR() || this.bAB > 0) {
                        this.bAy.bAM = false;
                    } else if (this.bAA.a(Wh, a)) {
                        this.bAy.bAM = true;
                        if (VK()) {
                            this.bAy.k(Wh);
                            this.bAy.rect = a;
                        }
                        c.fj(a.h.aiapps_swan_app_error_page_hint);
                        a(this.bAy, 19, false, null);
                    } else {
                        this.bAy.bAM = false;
                    }
                    this.bAy.VU();
                    if (VK() && this.bAD.a(Wh, a)) {
                        a(this.bAy, 28, VM(), Wh);
                    }
                }
            }
        }

        private boolean VK() {
            return this.bAy != null && this.bAy.isFirstPage;
        }

        private void Fe() {
            this.mIsBackground = true;
            if (this.bAy != null) {
                if (!this.bAy.isChecked()) {
                    if (b.this.bAx != null) {
                        b.this.bAx.removeMessages(2);
                    }
                    this.bAy.pause();
                } else if (this.bAy.bAM && VK()) {
                    VL();
                }
            }
        }

        private void Fc() {
            this.mIsBackground = false;
            if (this.bAy != null && !this.bAy.isChecked()) {
                this.bAy.resume();
                long VS = this.bAy.VS();
                if (VS >= 0) {
                    b.this.bAx.sendMessageDelayed(Message.obtain(b.this.bAx, 2, this.bAy), VS);
                }
            }
        }

        private void a(com.baidu.swan.apps.ac.a.e eVar) {
            d dVar;
            Integer num;
            if (eVar != null) {
                String We = eVar.We();
                Iterator<d> it = this.bAz.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (TextUtils.equals(dVar.id, We)) {
                        break;
                    }
                }
                if (eVar.isAdd()) {
                    if (dVar != null) {
                        dVar.bAP++;
                        return;
                    }
                    if (this.bAC == null) {
                        this.bAC = new HashMap<>();
                    }
                    Integer num2 = this.bAC.get(We);
                    this.bAC.put(We, Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                } else if (dVar != null) {
                    dVar.bAP--;
                } else if (this.bAC != null && (num = this.bAC.get(We)) != null && num.intValue() > 0) {
                    this.bAC.put(We, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void jj(String str) {
            if (VK()) {
                com.baidu.swan.apps.y.f.Uf().a(com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                com.baidu.swan.apps.y.f.Uf().a(str, com.baidu.swan.apps.an.b.a(new com.baidu.swan.apps.an.b()));
                if (b.DEBUG) {
                    Log.d(b.TAG, "Send master/slave white screen event to fe, done");
                }
            }
        }

        private void VL() {
            if (b.DEBUG) {
                Log.d(b.TAG, "recheckAndExit");
            }
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    final SwanAppActivity TQ = com.baidu.swan.apps.y.f.Uf().TQ();
                    if (TQ != null && !TQ.isFinishing() && !TQ.isDestroyed() && a.this.bAy != null) {
                        final Bitmap aeo = af.aeo();
                        m.aed().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.bAA.a(aeo, a.this.bAy.rect)) {
                                    a.this.a(a.this.bAy, 33, false, null);
                                    ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.b.a.2.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (b.DEBUG) {
                                                Log.d(b.TAG, "recheckAndExit call activity finish.");
                                            }
                                            TQ.finish();
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
            JSONObject VP = c.VP();
            try {
                VP.put("page", dVar.url);
                VP.put("firstPage", VK());
                if (z && bitmap != null) {
                    VP.put("image", c.j(bitmap));
                }
            } catch (JSONException e) {
                if (b.DEBUG) {
                    e.printStackTrace();
                }
            }
            com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(i).mh(VP.toString());
            b.a aVar = null;
            if (com.baidu.swan.apps.runtime.e.ZS() != null) {
                aVar = com.baidu.swan.apps.runtime.e.ZS().DR();
            }
            com.baidu.swan.apps.statistic.a.d dJ = new com.baidu.swan.apps.statistic.a.d().e(mh).a(aVar).lv(com.baidu.swan.apps.statistic.f.ga(com.baidu.swan.apps.runtime.d.ZP().DH())).lw(com.baidu.swan.apps.runtime.e.ZU()).ly(String.valueOf(this.bAz.size())).dJ(false);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isH5Componet", dVar.bAP == 0 ? "0" : "1");
                dJ.aZ(jSONObject);
            } catch (JSONException e2) {
                if (b.DEBUG) {
                    e2.printStackTrace();
                }
            }
            if (VK()) {
                dJ.aZ(com.baidu.swan.apps.an.a.abU().abV());
                dJ.aZ(com.baidu.swan.apps.an.a.abU().abW());
            }
            com.baidu.swan.apps.statistic.f.b(dJ);
        }

        private boolean VM() {
            String string = h.acE().getString("screenshot_upload_switch", "1");
            if (b.DEBUG) {
                Log.d(b.TAG, "Screenshot upload cloud switch: status = " + string);
            }
            return TextUtils.equals(string, "1") && new Random().nextInt(10) % 3 == 0;
        }

        private void c(@NonNull com.baidu.swan.apps.ac.a.c cVar) {
            if (cVar.Wf() >= 0) {
                com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
                if (DP == null || DP.LE() <= 0) {
                    if (b.DEBUG) {
                        Log.d(b.TAG, "start loading check: remainTime=" + cVar.Wf());
                    }
                    b.this.bAx.sendMessageDelayed(Message.obtain(b.this.bAx, 10, cVar), cVar.Wf());
                }
            }
        }

        private void VN() {
            SwanAppActivity TQ = com.baidu.swan.apps.y.f.Uf().TQ();
            if (TQ != null && !TQ.isFinishing() && !TQ.isDestroyed()) {
                boolean z = TQ.DL().bVG.getVisibility() == 0;
                if (b.DEBUG) {
                    Log.d(b.TAG, "Loading check result: " + z);
                }
                if (z) {
                    com.baidu.swan.apps.ap.a mh = new com.baidu.swan.apps.ap.a().aB(5L).aC(19L).mh("loading=true");
                    b.a aVar = null;
                    if (com.baidu.swan.apps.runtime.e.ZS() != null) {
                        aVar = com.baidu.swan.apps.runtime.e.ZS().DR();
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().e(mh).a(aVar).lv(com.baidu.swan.apps.statistic.f.ga(com.baidu.swan.apps.runtime.d.ZP().DH())).lw(com.baidu.swan.apps.runtime.d.ZP().getAppId()).ly(String.valueOf(this.bAz.size())).dJ(false));
                }
            }
        }
    }
}
