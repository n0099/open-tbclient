package com.baidu.afd.videopaster;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.afd.videopaster.a.a;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.afd.videopaster.view.VideoPasterContentView;
import com.baidu.afd.videopaster.view.VideoPasterOverlayView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.t;
/* loaded from: classes.dex */
public class d {
    private VideoPasterContentView acf;
    private View acg;
    private a aci;
    private com.baidu.afd.videopaster.data.a acm;
    private int aco;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean acn = false;
    private boolean acp = false;
    private boolean acq = false;
    private com.baidu.afd.videopaster.b.b acj = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a ach = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes.dex */
    public interface a {
        void rq();

        void rr();

        void rs();

        boolean rt();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.ach.a(new a.InterfaceC0033a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0033a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.acm = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0033a
            public void e(int i, String str) {
                d.this.acm = null;
            }
        });
        this.acf = new VideoPasterContentView(context);
        this.acf.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rm() {
                d.this.acj.k(d.this.ri());
                com.baidu.tieba.lego.card.a.c.a(d.this.acm);
                if (d.this.acm != null) {
                    d.this.c(d.this.ri(), t.i(d.this.mContext, d.this.acm.acv, d.this.acm.adid, d.this.acm.extra));
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rn() {
                d.this.acj.j(d.this.ri());
                com.baidu.tieba.lego.card.a.c.a(d.this.acm);
                if (d.this.acm != null) {
                    d.this.c(d.this.ri(), t.i(d.this.mContext, d.this.acm.acv, d.this.acm.adid, d.this.acm.extra));
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void ro() {
                d.this.acj.l(d.this.ri());
                com.baidu.tieba.lego.card.a.c.a(d.this.acm);
                if (d.this.acm != null) {
                    d.this.c(d.this.ri(), t.i(d.this.mContext, d.this.acm.acv, d.this.acm.adid, d.this.acm.extra));
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rp() {
                d.this.acp = true;
                d.this.onAdClose();
                d.this.acj.f(d.this.ri());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rq() {
                d.this.acj.m(d.this.ri());
                if (d.this.aci != null) {
                    d.this.aci.rq();
                }
            }
        });
        this.acf.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rr() {
                d.this.re();
                if (d.this.aci != null) {
                    d.this.aci.rr();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.acf.isCompleted()) {
                    i = 0;
                } else if (d.this.acp) {
                    d.this.acp = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.aci != null) {
                    if (i == 0 || i == 1) {
                        d.this.be(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.aci.rt()) {
                        if (d.this.acq) {
                            d.this.acq = false;
                        } else if (!z) {
                            d.this.be(i);
                        }
                    }
                }
            }
        });
        this.acg = new View(this.mContext);
        this.acg.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i) {
        this.acj.d(ri(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.acj.f(ri());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.ach != null && !this.ach.isLoading() && this.ach.rz() == null && aVar != null) {
            this.mFloor = aVar.qP() + 1;
            this.ach.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.acC) {
            this.acj.i(ri());
        }
    }

    public boolean b(boolean z, boolean z2, String str) {
        if (this.ach.isLoading()) {
            return false;
        }
        this.acn = z2;
        this.mFrom = str;
        VideoPasterResponseData rz = this.ach.rz();
        if (rz != null) {
            com.baidu.afd.videopaster.data.a pasterData = rz.getPasterData();
            if (pasterData == null) {
                this.ach.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.acj.e(ri());
                this.ach.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.ach.reset();
                return false;
            } else {
                this.rootView.removeView(this.acg);
                this.rootView.addView(this.acg);
                this.rootView.removeView(this.acf);
                this.rootView.addView(this.acf);
                if (this.rootView instanceof FrameLayout) {
                    this.acf.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.acf.setLayoutParams(layoutParams);
                }
                this.acf.setData(pasterData);
                this.mStartPosition = this.acf.getCurDuration();
                if (!rc()) {
                    this.acj.e(ri());
                    com.baidu.tieba.lego.card.a.c.b(this.acm);
                }
                this.acf.c(z, z2, str);
                if (this.aci != null) {
                    this.aci.rs();
                }
                return true;
            }
        }
        return false;
    }

    public boolean rb() {
        return this.acn;
    }

    public boolean rc() {
        return this.acf.rc();
    }

    public boolean rd() {
        return this.acf.rd();
    }

    public void reset() {
        rf();
        this.acn = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClose() {
        rf();
        if (this.aci != null) {
            this.aci.rr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
        this.acj.h(ri());
        rf();
    }

    private void rf() {
        this.ach.reset();
        this.acf.reset();
        this.rootView.removeView(this.acf);
        this.rootView.removeView(this.acg);
    }

    public void resume() {
        this.acf.resume();
        if (rd()) {
            this.mStartPosition = this.acf.getCurDuration();
            this.aco = this.mStartPosition;
            this.acj.g(ri());
        }
    }

    public void rg() {
        if (this.acf != null) {
            this.acf.rg();
        }
    }

    public void stop() {
        this.mPausePosition = this.acf.getCurDuration();
        if (rd() && !rh()) {
            this.acj.f(ri());
        }
        this.acf.stop();
    }

    private boolean rh() {
        if (this.acf != null) {
            int[] iArr = new int[2];
            this.acf.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.aci = aVar;
    }

    public com.baidu.afd.videopaster.b.a ri() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.acS = this.aco;
        aVar.acT = this.mPausePosition;
        aVar.totalDuration = this.acf.getTotalDuration();
        aVar.acR = this.acf.getCurDuration();
        aVar.acQ = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.acU = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.acU = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.acU = 2;
        } else {
            aVar.acU = -1;
        }
        if (this.acm != null) {
            aVar.acV = this.acm.ru();
            aVar.tplName = this.acm.tplName;
            aVar.extraParam = this.acm.extra;
            aVar.acD = this.acm.acD;
            aVar.acE = this.acm.acE;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.afd.videopaster.b.a aVar, int i) {
        if (t.HO(i)) {
            this.acj.e(aVar, i);
        }
    }

    public void bf(int i) {
        if (this.acf != null) {
            this.acf.bf(i);
        }
    }

    public void onDestroy() {
        this.ach.onDestroy();
    }

    public void rj() {
        if (this.acf != null) {
            this.acf.rj();
        }
    }

    public void rk() {
        if (this.acf != null) {
            this.acf.rk();
        }
    }

    public boolean rl() {
        return this.acf != null && this.acf.rl();
    }

    public void az(boolean z) {
        this.acq = z;
    }
}
