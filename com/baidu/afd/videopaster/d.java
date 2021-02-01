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
import com.baidu.tieba.recapp.s;
/* loaded from: classes.dex */
public class d {
    private VideoPasterContentView aaL;
    private View aaM;
    private a aaO;
    private com.baidu.afd.videopaster.data.a aaQ;
    private int aaS;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean aaR = false;
    private boolean aaT = false;
    private boolean aaU = false;
    private com.baidu.afd.videopaster.b.b aaP = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a aaN = new com.baidu.afd.videopaster.a.a();

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
        this.aaN.a(new a.InterfaceC0027a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0027a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.aaQ = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0027a
            public void e(int i, String str) {
                d.this.aaQ = null;
            }
        });
        this.aaL = new VideoPasterContentView(context);
        this.aaL.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rm() {
                d.this.aaP.k(d.this.ri());
                com.baidu.tieba.lego.card.a.c.a(d.this.aaQ);
                if (d.this.aaQ != null) {
                    d.this.c(d.this.ri(), s.x(d.this.mContext, d.this.aaQ.aaY, d.this.aaQ.adid));
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rn() {
                d.this.aaP.j(d.this.ri());
                com.baidu.tieba.lego.card.a.c.a(d.this.aaQ);
                if (d.this.aaQ != null) {
                    d.this.c(d.this.ri(), s.x(d.this.mContext, d.this.aaQ.aaY, d.this.aaQ.adid));
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void ro() {
                d.this.aaP.l(d.this.ri());
                com.baidu.tieba.lego.card.a.c.a(d.this.aaQ);
                if (d.this.aaQ != null) {
                    d.this.c(d.this.ri(), s.x(d.this.mContext, d.this.aaQ.aaY, d.this.aaQ.adid));
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rp() {
                d.this.aaT = true;
                d.this.onAdClose();
                d.this.aaP.f(d.this.ri());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rq() {
                d.this.aaP.m(d.this.ri());
                if (d.this.aaO != null) {
                    d.this.aaO.rq();
                }
            }
        });
        this.aaL.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rr() {
                d.this.re();
                if (d.this.aaO != null) {
                    d.this.aaO.rr();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.aaL.isCompleted()) {
                    i = 0;
                } else if (d.this.aaT) {
                    d.this.aaT = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.aaO != null) {
                    if (i == 0 || i == 1) {
                        d.this.bd(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.aaO.rt()) {
                        if (d.this.aaU) {
                            d.this.aaU = false;
                        } else if (!z) {
                            d.this.bd(i);
                        }
                    }
                }
            }
        });
        this.aaM = new View(this.mContext);
        this.aaM.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(int i) {
        this.aaP.d(ri(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.aaP.f(ri());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.aaN != null && !this.aaN.isLoading() && this.aaN.rz() == null && aVar != null) {
            this.mFloor = aVar.qP() + 1;
            this.aaN.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.abf) {
            this.aaP.i(ri());
        }
    }

    public boolean d(boolean z, boolean z2, String str) {
        if (this.aaN.isLoading()) {
            return false;
        }
        this.aaR = z2;
        this.mFrom = str;
        VideoPasterResponseData rz = this.aaN.rz();
        if (rz != null) {
            com.baidu.afd.videopaster.data.a pasterData = rz.getPasterData();
            if (pasterData == null) {
                this.aaN.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.aaP.e(ri());
                this.aaN.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.aaN.reset();
                return false;
            } else {
                this.rootView.removeView(this.aaM);
                this.rootView.addView(this.aaM);
                this.rootView.removeView(this.aaL);
                this.rootView.addView(this.aaL);
                if (this.rootView instanceof FrameLayout) {
                    this.aaL.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.aaL.setLayoutParams(layoutParams);
                }
                this.aaL.setData(pasterData);
                this.mStartPosition = this.aaL.getCurDuration();
                if (!rc()) {
                    this.aaP.e(ri());
                    com.baidu.tieba.lego.card.a.c.b(this.aaQ);
                }
                this.aaL.e(z, z2, str);
                if (this.aaO != null) {
                    this.aaO.rs();
                }
                return true;
            }
        }
        return false;
    }

    public boolean rb() {
        return this.aaR;
    }

    public boolean rc() {
        return this.aaL.rc();
    }

    public boolean rd() {
        return this.aaL.rd();
    }

    public void reset() {
        rf();
        this.aaR = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClose() {
        rf();
        if (this.aaO != null) {
            this.aaO.rr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
        this.aaP.h(ri());
        rf();
    }

    private void rf() {
        this.aaN.reset();
        this.aaL.reset();
        this.rootView.removeView(this.aaL);
        this.rootView.removeView(this.aaM);
    }

    public void resume() {
        this.aaL.resume();
        if (rd()) {
            this.mStartPosition = this.aaL.getCurDuration();
            this.aaS = this.mStartPosition;
            this.aaP.g(ri());
        }
    }

    public void rg() {
        if (this.aaL != null) {
            this.aaL.rg();
        }
    }

    public void stop() {
        this.mPausePosition = this.aaL.getCurDuration();
        if (rd() && !rh()) {
            this.aaP.f(ri());
        }
        this.aaL.stop();
    }

    private boolean rh() {
        if (this.aaL != null) {
            int[] iArr = new int[2];
            this.aaL.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.aaO = aVar;
    }

    public com.baidu.afd.videopaster.b.a ri() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.abw = this.aaS;
        aVar.abx = this.mPausePosition;
        aVar.totalDuration = this.aaL.getTotalDuration();
        aVar.abv = this.aaL.getCurDuration();
        aVar.abu = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.aby = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.aby = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.aby = 2;
        } else {
            aVar.aby = -1;
        }
        if (this.aaQ != null) {
            aVar.abz = this.aaQ.ru();
            aVar.tplName = this.aaQ.tplName;
            aVar.extraParam = this.aaQ.extra;
            aVar.abg = this.aaQ.abg;
            aVar.abh = this.aaQ.abh;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.afd.videopaster.b.a aVar, int i) {
        if (!s.HL(i)) {
            this.aaP.e(aVar, i);
        }
    }

    public void be(int i) {
        if (this.aaL != null) {
            this.aaL.be(i);
        }
    }

    public void onDestroy() {
        this.aaN.onDestroy();
    }

    public void rj() {
        if (this.aaL != null) {
            this.aaL.rj();
        }
    }

    public void rk() {
        if (this.aaL != null) {
            this.aaL.rk();
        }
    }

    public boolean rl() {
        return this.aaL != null && this.aaL.rl();
    }

    public void az(boolean z) {
        this.aaU = z;
    }
}
