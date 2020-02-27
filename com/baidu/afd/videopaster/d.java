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
import com.baidu.tieba.recapp.s;
/* loaded from: classes8.dex */
public class d {
    private VideoPasterContentView DK;
    private View DM;
    private a DO;
    private com.baidu.afd.videopaster.data.a DR;
    private int DT;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean DS = false;
    private boolean DU = false;
    private boolean DV = false;
    private QuickVideoView DI = this.DI;
    private QuickVideoView DI = this.DI;
    private n DJ = this.DJ;
    private n DJ = this.DJ;
    private com.baidu.afd.videopaster.b.b DQ = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a DN = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes8.dex */
    public interface a {
        void lj();

        void lk();

        void ll();

        boolean lm();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.DN.a(new a.InterfaceC0030a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0030a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.DR = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0030a
            public void f(int i, String str) {
                d.this.DR = null;
            }
        });
        this.DK = new VideoPasterContentView(context);
        this.DK.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void lf() {
                d.this.DQ.k(d.this.lb());
                com.baidu.tieba.lego.card.b.c.a(d.this.DR);
                if (d.this.DR != null && s.be(d.this.mContext, d.this.DR.DZ) == 1) {
                    d.this.DQ.c(d.this.lb(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void lg() {
                d.this.DQ.j(d.this.lb());
                com.baidu.tieba.lego.card.b.c.a(d.this.DR);
                if (d.this.DR != null && s.be(d.this.mContext, d.this.DR.DZ) == 1) {
                    d.this.DQ.c(d.this.lb(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void lh() {
                d.this.DQ.l(d.this.lb());
                com.baidu.tieba.lego.card.b.c.a(d.this.DR);
                if (d.this.DR != null && s.be(d.this.mContext, d.this.DR.DZ) == 1) {
                    d.this.DQ.c(d.this.lb(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void li() {
                d.this.DU = true;
                d.this.kW();
                d.this.DQ.f(d.this.lb());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void lj() {
                d.this.DQ.m(d.this.lb());
                if (d.this.DO != null) {
                    d.this.DO.lj();
                }
            }
        });
        this.DK.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void lk() {
                d.this.kX();
                if (d.this.DO != null) {
                    d.this.DO.lk();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.DK.aW()) {
                    i = 0;
                } else if (d.this.DU) {
                    d.this.DU = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.DO != null) {
                    if (i == 0 || i == 1) {
                        d.this.aw(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.DO.lm()) {
                        if (d.this.DV) {
                            d.this.DV = false;
                        } else if (!z) {
                            d.this.aw(i);
                        }
                    }
                }
            }
        });
        this.DM = new View(this.mContext);
        this.DM.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(int i) {
        this.DQ.b(lb(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.DQ.f(lb());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.DN != null && !this.DN.isLoading() && this.DN.ls() == null && aVar != null) {
            this.mFloor = aVar.kH() + 1;
            this.DN.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Ef) {
            this.DQ.i(lb());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.DN.isLoading()) {
            return false;
        }
        this.DS = z2;
        this.mFrom = str;
        VideoPasterResponseData ls = this.DN.ls();
        if (ls != null) {
            com.baidu.afd.videopaster.data.a pasterData = ls.getPasterData();
            if (pasterData == null) {
                this.DN.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.DQ.e(lb());
                this.DN.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.DN.reset();
                return false;
            } else {
                this.rootView.removeView(this.DM);
                this.rootView.addView(this.DM);
                this.rootView.removeView(this.DK);
                this.rootView.addView(this.DK);
                if (this.rootView instanceof FrameLayout) {
                    this.DK.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.DK.setLayoutParams(layoutParams);
                }
                this.DK.setData(pasterData);
                this.mStartPosition = this.DK.getCurDuration();
                if (!kU()) {
                    this.DQ.e(lb());
                    com.baidu.tieba.lego.card.b.c.b(this.DR);
                }
                this.DK.b(z, z2, str);
                if (this.DO != null) {
                    this.DO.ll();
                }
                return true;
            }
        }
        return false;
    }

    public boolean kT() {
        return this.DS;
    }

    public boolean kU() {
        return this.DK.kU();
    }

    public boolean kV() {
        return this.DK.kV();
    }

    public void reset() {
        kY();
        this.DS = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW() {
        kY();
        if (this.DO != null) {
            this.DO.lk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kX() {
        this.DQ.h(lb());
        kY();
    }

    private void kY() {
        this.DN.reset();
        this.DK.reset();
        this.rootView.removeView(this.DK);
        this.rootView.removeView(this.DM);
    }

    public void resume() {
        this.DK.resume();
        if (kV()) {
            this.mStartPosition = this.DK.getCurDuration();
            this.DT = this.mStartPosition;
            this.DQ.g(lb());
        }
    }

    public void kZ() {
        if (this.DK != null) {
            this.DK.kZ();
        }
    }

    public void stop() {
        this.mPausePosition = this.DK.getCurDuration();
        if (kV() && !la()) {
            this.DQ.f(lb());
        }
        this.DK.stop();
    }

    private boolean la() {
        if (this.DK != null) {
            int[] iArr = new int[2];
            this.DK.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.DO = aVar;
    }

    public com.baidu.afd.videopaster.b.a lb() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.Ew = this.DT;
        aVar.Ex = this.mPausePosition;
        aVar.Eu = this.DK.getTotalDuration();
        aVar.Ev = this.DK.getCurDuration();
        aVar.Et = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Ey = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Ey = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Ey = 2;
        } else {
            aVar.Ey = -1;
        }
        if (this.DR != null) {
            aVar.Ez = this.DR.ln();
            aVar.tplName = this.DR.tplName;
            aVar.extraParam = this.DR.extra;
            aVar.Eg = this.DR.Eg;
            aVar.Eh = this.DR.Eh;
        }
        return aVar;
    }

    public void ax(int i) {
        if (this.DK != null) {
            this.DK.ax(i);
        }
    }

    public void onDestroy() {
        this.DN.onDestroy();
    }

    public void lc() {
        if (this.DK != null) {
            this.DK.lc();
        }
    }

    public void ld() {
        if (this.DK != null) {
            this.DK.ld();
        }
    }

    public boolean le() {
        return this.DK != null && this.DK.le();
    }

    public void Y(boolean z) {
        this.DV = z;
    }
}
