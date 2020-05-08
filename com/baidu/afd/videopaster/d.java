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
    private VideoPasterContentView Xg;
    private View Xh;
    private a Xj;
    private com.baidu.afd.videopaster.data.a Xl;
    private int Xn;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean Xm = false;
    private boolean Xo = false;
    private boolean Xp = false;
    private QuickVideoView Xe = this.Xe;
    private QuickVideoView Xe = this.Xe;
    private n Xf = this.Xf;
    private n Xf = this.Xf;
    private com.baidu.afd.videopaster.b.b Xk = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Xi = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes8.dex */
    public interface a {
        void pN();

        void pO();

        void pP();

        boolean pQ();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.Xi.a(new a.InterfaceC0032a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0032a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Xl = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0032a
            public void e(int i, String str) {
                d.this.Xl = null;
            }
        });
        this.Xg = new VideoPasterContentView(context);
        this.Xg.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pJ() {
                d.this.Xk.k(d.this.pF());
                com.baidu.tieba.lego.card.b.c.a(d.this.Xl);
                if (d.this.Xl != null && r.aN(d.this.mContext, d.this.Xl.Xt) == 1) {
                    d.this.Xk.c(d.this.pF(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pK() {
                d.this.Xk.j(d.this.pF());
                com.baidu.tieba.lego.card.b.c.a(d.this.Xl);
                if (d.this.Xl != null && r.aN(d.this.mContext, d.this.Xl.Xt) == 1) {
                    d.this.Xk.c(d.this.pF(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pL() {
                d.this.Xk.l(d.this.pF());
                com.baidu.tieba.lego.card.b.c.a(d.this.Xl);
                if (d.this.Xl != null && r.aN(d.this.mContext, d.this.Xl.Xt) == 1) {
                    d.this.Xk.c(d.this.pF(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pM() {
                d.this.Xo = true;
                d.this.pA();
                d.this.Xk.f(d.this.pF());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pN() {
                d.this.Xk.m(d.this.pF());
                if (d.this.Xj != null) {
                    d.this.Xj.pN();
                }
            }
        });
        this.Xg.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void pO() {
                d.this.pB();
                if (d.this.Xj != null) {
                    d.this.Xj.pO();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Xg.gt()) {
                    i = 0;
                } else if (d.this.Xo) {
                    d.this.Xo = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Xj != null) {
                    if (i == 0 || i == 1) {
                        d.this.aI(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Xj.pQ()) {
                        if (d.this.Xp) {
                            d.this.Xp = false;
                        } else if (!z) {
                            d.this.aI(i);
                        }
                    }
                }
            }
        });
        this.Xh = new View(this.mContext);
        this.Xh.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(int i) {
        this.Xk.b(pF(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Xk.f(pF());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Xi != null && !this.Xi.isLoading() && this.Xi.pW() == null && aVar != null) {
            this.mFloor = aVar.pl() + 1;
            this.Xi.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Xz) {
            this.Xk.i(pF());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Xi.isLoading()) {
            return false;
        }
        this.Xm = z2;
        this.mFrom = str;
        VideoPasterResponseData pW = this.Xi.pW();
        if (pW != null) {
            com.baidu.afd.videopaster.data.a pasterData = pW.getPasterData();
            if (pasterData == null) {
                this.Xi.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Xk.e(pF());
                this.Xi.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Xi.reset();
                return false;
            } else {
                this.rootView.removeView(this.Xh);
                this.rootView.addView(this.Xh);
                this.rootView.removeView(this.Xg);
                this.rootView.addView(this.Xg);
                if (this.rootView instanceof FrameLayout) {
                    this.Xg.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Xg.setLayoutParams(layoutParams);
                }
                this.Xg.setData(pasterData);
                this.mStartPosition = this.Xg.getCurDuration();
                if (!py()) {
                    this.Xk.e(pF());
                    com.baidu.tieba.lego.card.b.c.b(this.Xl);
                }
                this.Xg.b(z, z2, str);
                if (this.Xj != null) {
                    this.Xj.pP();
                }
                return true;
            }
        }
        return false;
    }

    public boolean px() {
        return this.Xm;
    }

    public boolean py() {
        return this.Xg.py();
    }

    public boolean pz() {
        return this.Xg.pz();
    }

    public void reset() {
        pC();
        this.Xm = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA() {
        pC();
        if (this.Xj != null) {
            this.Xj.pO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pB() {
        this.Xk.h(pF());
        pC();
    }

    private void pC() {
        this.Xi.reset();
        this.Xg.reset();
        this.rootView.removeView(this.Xg);
        this.rootView.removeView(this.Xh);
    }

    public void resume() {
        this.Xg.resume();
        if (pz()) {
            this.mStartPosition = this.Xg.getCurDuration();
            this.Xn = this.mStartPosition;
            this.Xk.g(pF());
        }
    }

    public void pD() {
        if (this.Xg != null) {
            this.Xg.pD();
        }
    }

    public void stop() {
        this.mPausePosition = this.Xg.getCurDuration();
        if (pz() && !pE()) {
            this.Xk.f(pF());
        }
        this.Xg.stop();
    }

    private boolean pE() {
        if (this.Xg != null) {
            int[] iArr = new int[2];
            this.Xg.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Xj = aVar;
    }

    public com.baidu.afd.videopaster.b.a pF() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.XQ = this.Xn;
        aVar.XR = this.mPausePosition;
        aVar.XO = this.Xg.getTotalDuration();
        aVar.XP = this.Xg.getCurDuration();
        aVar.XN = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.XS = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.XS = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.XS = 2;
        } else {
            aVar.XS = -1;
        }
        if (this.Xl != null) {
            aVar.XT = this.Xl.pR();
            aVar.tplName = this.Xl.tplName;
            aVar.extraParam = this.Xl.extra;
            aVar.XA = this.Xl.XA;
            aVar.XB = this.Xl.XB;
        }
        return aVar;
    }

    public void aJ(int i) {
        if (this.Xg != null) {
            this.Xg.aJ(i);
        }
    }

    public void onDestroy() {
        this.Xi.onDestroy();
    }

    public void pG() {
        if (this.Xg != null) {
            this.Xg.pG();
        }
    }

    public void pH() {
        if (this.Xg != null) {
            this.Xg.pH();
        }
    }

    public boolean pI() {
        return this.Xg != null && this.Xg.pI();
    }

    public void ax(boolean z) {
        this.Xp = z;
    }
}
