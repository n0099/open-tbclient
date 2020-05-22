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
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.n;
import com.baidu.tieba.recapp.r;
/* loaded from: classes8.dex */
public class d {
    private com.baidu.afd.videopaster.data.a XA;
    private int XC;
    private VideoPasterContentView Xv;
    private View Xw;
    private a Xy;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean XB = false;
    private boolean XD = false;
    private boolean XE = false;
    private QuickVideoView Xt = this.Xt;
    private QuickVideoView Xt = this.Xt;
    private n Xu = this.Xu;
    private n Xu = this.Xu;
    private com.baidu.afd.videopaster.b.b Xz = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Xx = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes8.dex */
    public interface a {
        void pT();

        void pU();

        void pV();

        boolean pW();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.Xx.a(new a.InterfaceC0034a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0034a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.XA = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0034a
            public void e(int i, String str) {
                d.this.XA = null;
            }
        });
        this.Xv = new VideoPasterContentView(context);
        this.Xv.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pP() {
                d.this.Xz.k(d.this.pL());
                com.baidu.tieba.lego.card.b.c.a(d.this.XA);
                if (d.this.XA != null && r.aO(d.this.mContext, d.this.XA.XI) == 1) {
                    d.this.Xz.c(d.this.pL(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pQ() {
                d.this.Xz.j(d.this.pL());
                com.baidu.tieba.lego.card.b.c.a(d.this.XA);
                if (d.this.XA != null && r.aO(d.this.mContext, d.this.XA.XI) == 1) {
                    d.this.Xz.c(d.this.pL(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pR() {
                d.this.Xz.l(d.this.pL());
                com.baidu.tieba.lego.card.b.c.a(d.this.XA);
                if (d.this.XA != null && r.aO(d.this.mContext, d.this.XA.XI) == 1) {
                    d.this.Xz.c(d.this.pL(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pS() {
                d.this.XD = true;
                d.this.pG();
                d.this.Xz.f(d.this.pL());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pT() {
                d.this.Xz.m(d.this.pL());
                if (d.this.Xy != null) {
                    d.this.Xy.pT();
                }
            }
        });
        this.Xv.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void pU() {
                d.this.pH();
                if (d.this.Xy != null) {
                    d.this.Xy.pU();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Xv.gt()) {
                    i = 0;
                } else if (d.this.XD) {
                    d.this.XD = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Xy != null) {
                    if (i == 0 || i == 1) {
                        d.this.aJ(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Xy.pW()) {
                        if (d.this.XE) {
                            d.this.XE = false;
                        } else if (!z) {
                            d.this.aJ(i);
                        }
                    }
                }
            }
        });
        this.Xw = new View(this.mContext);
        this.Xw.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(int i) {
        this.Xz.b(pL(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Xz.f(pL());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Xx != null && !this.Xx.isLoading() && this.Xx.qc() == null && aVar != null) {
            this.mFloor = aVar.pr() + 1;
            this.Xx.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.XO) {
            this.Xz.i(pL());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Xx.isLoading()) {
            return false;
        }
        this.XB = z2;
        this.mFrom = str;
        VideoPasterResponseData qc = this.Xx.qc();
        if (qc != null) {
            com.baidu.afd.videopaster.data.a pasterData = qc.getPasterData();
            if (pasterData == null) {
                this.Xx.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Xz.e(pL());
                this.Xx.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Xx.reset();
                return false;
            } else {
                this.rootView.removeView(this.Xw);
                this.rootView.addView(this.Xw);
                this.rootView.removeView(this.Xv);
                this.rootView.addView(this.Xv);
                if (this.rootView instanceof FrameLayout) {
                    this.Xv.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Xv.setLayoutParams(layoutParams);
                }
                this.Xv.setData(pasterData);
                this.mStartPosition = this.Xv.getCurDuration();
                if (!pE()) {
                    this.Xz.e(pL());
                    com.baidu.tieba.lego.card.b.c.b(this.XA);
                }
                this.Xv.b(z, z2, str);
                if (this.Xy != null) {
                    this.Xy.pV();
                }
                return true;
            }
        }
        return false;
    }

    public boolean pD() {
        return this.XB;
    }

    public boolean pE() {
        return this.Xv.pE();
    }

    public boolean pF() {
        return this.Xv.pF();
    }

    public void reset() {
        pI();
        this.XB = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pG() {
        pI();
        if (this.Xy != null) {
            this.Xy.pU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pH() {
        this.Xz.h(pL());
        pI();
    }

    private void pI() {
        this.Xx.reset();
        this.Xv.reset();
        this.rootView.removeView(this.Xv);
        this.rootView.removeView(this.Xw);
    }

    public void resume() {
        this.Xv.resume();
        if (pF()) {
            this.mStartPosition = this.Xv.getCurDuration();
            this.XC = this.mStartPosition;
            this.Xz.g(pL());
        }
    }

    public void pJ() {
        if (this.Xv != null) {
            this.Xv.pJ();
        }
    }

    public void stop() {
        this.mPausePosition = this.Xv.getCurDuration();
        if (pF() && !pK()) {
            this.Xz.f(pL());
        }
        this.Xv.stop();
    }

    private boolean pK() {
        if (this.Xv != null) {
            int[] iArr = new int[2];
            this.Xv.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Xy = aVar;
    }

    public com.baidu.afd.videopaster.b.a pL() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.Yg = this.XC;
        aVar.Yh = this.mPausePosition;
        aVar.Ye = this.Xv.getTotalDuration();
        aVar.Yf = this.Xv.getCurDuration();
        aVar.Yc = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Yi = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Yi = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Yi = 2;
        } else {
            aVar.Yi = -1;
        }
        if (this.XA != null) {
            aVar.Yj = this.XA.pX();
            aVar.tplName = this.XA.tplName;
            aVar.extraParam = this.XA.extra;
            aVar.XP = this.XA.XP;
            aVar.XQ = this.XA.XQ;
        }
        return aVar;
    }

    public void aK(int i) {
        if (this.Xv != null) {
            this.Xv.aK(i);
        }
    }

    public void onDestroy() {
        this.Xx.onDestroy();
    }

    public void pM() {
        if (this.Xv != null) {
            this.Xv.pM();
        }
    }

    public void pN() {
        if (this.Xv != null) {
            this.Xv.pN();
        }
    }

    public boolean pO() {
        return this.Xv != null && this.Xv.pO();
    }

    public void az(boolean z) {
        this.XE = z;
    }
}
