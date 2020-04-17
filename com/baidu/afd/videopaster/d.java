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
    private VideoPasterContentView Xd;
    private View Xe;
    private a Xg;
    private com.baidu.afd.videopaster.data.a Xi;
    private int Xk;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean Xj = false;
    private boolean Xl = false;
    private boolean Xm = false;
    private QuickVideoView Xb = this.Xb;
    private QuickVideoView Xb = this.Xb;
    private n Xc = this.Xc;
    private n Xc = this.Xc;
    private com.baidu.afd.videopaster.b.b Xh = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Xf = new com.baidu.afd.videopaster.a.a();

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
        this.Xf.a(new a.InterfaceC0032a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0032a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Xi = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0032a
            public void e(int i, String str) {
                d.this.Xi = null;
            }
        });
        this.Xd = new VideoPasterContentView(context);
        this.Xd.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pJ() {
                d.this.Xh.k(d.this.pF());
                com.baidu.tieba.lego.card.b.c.a(d.this.Xi);
                if (d.this.Xi != null && r.aZ(d.this.mContext, d.this.Xi.Xq) == 1) {
                    d.this.Xh.c(d.this.pF(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pK() {
                d.this.Xh.j(d.this.pF());
                com.baidu.tieba.lego.card.b.c.a(d.this.Xi);
                if (d.this.Xi != null && r.aZ(d.this.mContext, d.this.Xi.Xq) == 1) {
                    d.this.Xh.c(d.this.pF(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pL() {
                d.this.Xh.l(d.this.pF());
                com.baidu.tieba.lego.card.b.c.a(d.this.Xi);
                if (d.this.Xi != null && r.aZ(d.this.mContext, d.this.Xi.Xq) == 1) {
                    d.this.Xh.c(d.this.pF(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pM() {
                d.this.Xl = true;
                d.this.pA();
                d.this.Xh.f(d.this.pF());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pN() {
                d.this.Xh.m(d.this.pF());
                if (d.this.Xg != null) {
                    d.this.Xg.pN();
                }
            }
        });
        this.Xd.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void pO() {
                d.this.pB();
                if (d.this.Xg != null) {
                    d.this.Xg.pO();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Xd.gt()) {
                    i = 0;
                } else if (d.this.Xl) {
                    d.this.Xl = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Xg != null) {
                    if (i == 0 || i == 1) {
                        d.this.aI(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Xg.pQ()) {
                        if (d.this.Xm) {
                            d.this.Xm = false;
                        } else if (!z) {
                            d.this.aI(i);
                        }
                    }
                }
            }
        });
        this.Xe = new View(this.mContext);
        this.Xe.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(int i) {
        this.Xh.b(pF(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Xh.f(pF());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Xf != null && !this.Xf.isLoading() && this.Xf.pW() == null && aVar != null) {
            this.mFloor = aVar.pl() + 1;
            this.Xf.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Xw) {
            this.Xh.i(pF());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Xf.isLoading()) {
            return false;
        }
        this.Xj = z2;
        this.mFrom = str;
        VideoPasterResponseData pW = this.Xf.pW();
        if (pW != null) {
            com.baidu.afd.videopaster.data.a pasterData = pW.getPasterData();
            if (pasterData == null) {
                this.Xf.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Xh.e(pF());
                this.Xf.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Xf.reset();
                return false;
            } else {
                this.rootView.removeView(this.Xe);
                this.rootView.addView(this.Xe);
                this.rootView.removeView(this.Xd);
                this.rootView.addView(this.Xd);
                if (this.rootView instanceof FrameLayout) {
                    this.Xd.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Xd.setLayoutParams(layoutParams);
                }
                this.Xd.setData(pasterData);
                this.mStartPosition = this.Xd.getCurDuration();
                if (!py()) {
                    this.Xh.e(pF());
                    com.baidu.tieba.lego.card.b.c.b(this.Xi);
                }
                this.Xd.b(z, z2, str);
                if (this.Xg != null) {
                    this.Xg.pP();
                }
                return true;
            }
        }
        return false;
    }

    public boolean px() {
        return this.Xj;
    }

    public boolean py() {
        return this.Xd.py();
    }

    public boolean pz() {
        return this.Xd.pz();
    }

    public void reset() {
        pC();
        this.Xj = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA() {
        pC();
        if (this.Xg != null) {
            this.Xg.pO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pB() {
        this.Xh.h(pF());
        pC();
    }

    private void pC() {
        this.Xf.reset();
        this.Xd.reset();
        this.rootView.removeView(this.Xd);
        this.rootView.removeView(this.Xe);
    }

    public void resume() {
        this.Xd.resume();
        if (pz()) {
            this.mStartPosition = this.Xd.getCurDuration();
            this.Xk = this.mStartPosition;
            this.Xh.g(pF());
        }
    }

    public void pD() {
        if (this.Xd != null) {
            this.Xd.pD();
        }
    }

    public void stop() {
        this.mPausePosition = this.Xd.getCurDuration();
        if (pz() && !pE()) {
            this.Xh.f(pF());
        }
        this.Xd.stop();
    }

    private boolean pE() {
        if (this.Xd != null) {
            int[] iArr = new int[2];
            this.Xd.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Xg = aVar;
    }

    public com.baidu.afd.videopaster.b.a pF() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.XN = this.Xk;
        aVar.XO = this.mPausePosition;
        aVar.XL = this.Xd.getTotalDuration();
        aVar.XM = this.Xd.getCurDuration();
        aVar.XK = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.XP = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.XP = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.XP = 2;
        } else {
            aVar.XP = -1;
        }
        if (this.Xi != null) {
            aVar.XQ = this.Xi.pR();
            aVar.tplName = this.Xi.tplName;
            aVar.extraParam = this.Xi.extra;
            aVar.Xx = this.Xi.Xx;
            aVar.Xy = this.Xi.Xy;
        }
        return aVar;
    }

    public void aJ(int i) {
        if (this.Xd != null) {
            this.Xd.aJ(i);
        }
    }

    public void onDestroy() {
        this.Xf.onDestroy();
    }

    public void pG() {
        if (this.Xd != null) {
            this.Xd.pG();
        }
    }

    public void pH() {
        if (this.Xd != null) {
            this.Xd.pH();
        }
    }

    public boolean pI() {
        return this.Xd != null && this.Xd.pI();
    }

    public void ax(boolean z) {
        this.Xm = z;
    }
}
