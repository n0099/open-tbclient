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
/* loaded from: classes6.dex */
public class d {
    private VideoPasterContentView Dp;
    private View Dq;
    private a Ds;
    private com.baidu.afd.videopaster.data.a Du;
    private int Dw;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean Dv = false;
    private boolean Dx = false;
    private boolean Dy = false;
    private QuickVideoView Dn = this.Dn;
    private QuickVideoView Dn = this.Dn;
    private n Do = this.Do;
    private n Do = this.Do;
    private com.baidu.afd.videopaster.b.b Dt = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Dr = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes6.dex */
    public interface a {
        void kU();

        void kV();

        void kW();

        boolean kX();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.Dr.a(new a.InterfaceC0030a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0030a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Du = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0030a
            public void f(int i, String str) {
                d.this.Du = null;
            }
        });
        this.Dp = new VideoPasterContentView(context);
        this.Dp.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kQ() {
                d.this.Dt.k(d.this.kM());
                com.baidu.tieba.lego.card.b.c.a(d.this.Du);
                if (d.this.Du != null && s.be(d.this.mContext, d.this.Du.DD) == 1) {
                    d.this.Dt.c(d.this.kM(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kR() {
                d.this.Dt.j(d.this.kM());
                com.baidu.tieba.lego.card.b.c.a(d.this.Du);
                if (d.this.Du != null && s.be(d.this.mContext, d.this.Du.DD) == 1) {
                    d.this.Dt.c(d.this.kM(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kS() {
                d.this.Dt.l(d.this.kM());
                com.baidu.tieba.lego.card.b.c.a(d.this.Du);
                if (d.this.Du != null && s.be(d.this.mContext, d.this.Du.DD) == 1) {
                    d.this.Dt.c(d.this.kM(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kT() {
                d.this.Dx = true;
                d.this.kH();
                d.this.Dt.f(d.this.kM());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kU() {
                d.this.Dt.m(d.this.kM());
                if (d.this.Ds != null) {
                    d.this.Ds.kU();
                }
            }
        });
        this.Dp.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void kV() {
                d.this.kI();
                if (d.this.Ds != null) {
                    d.this.Ds.kV();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Dp.aW()) {
                    i = 0;
                } else if (d.this.Dx) {
                    d.this.Dx = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Ds != null) {
                    if (i == 0 || i == 1) {
                        d.this.at(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Ds.kX()) {
                        if (d.this.Dy) {
                            d.this.Dy = false;
                        } else if (!z) {
                            d.this.at(i);
                        }
                    }
                }
            }
        });
        this.Dq = new View(this.mContext);
        this.Dq.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(int i) {
        this.Dt.b(kM(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Dt.f(kM());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Dr != null && !this.Dr.isLoading() && this.Dr.ld() == null && aVar != null) {
            this.mFloor = aVar.ks() + 1;
            this.Dr.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.DK) {
            this.Dt.i(kM());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Dr.isLoading()) {
            return false;
        }
        this.Dv = z2;
        this.mFrom = str;
        VideoPasterResponseData ld = this.Dr.ld();
        if (ld != null) {
            com.baidu.afd.videopaster.data.a pasterData = ld.getPasterData();
            if (pasterData == null) {
                this.Dr.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Dt.e(kM());
                this.Dr.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Dr.reset();
                return false;
            } else {
                this.rootView.removeView(this.Dq);
                this.rootView.addView(this.Dq);
                this.rootView.removeView(this.Dp);
                this.rootView.addView(this.Dp);
                if (this.rootView instanceof FrameLayout) {
                    this.Dp.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Dp.setLayoutParams(layoutParams);
                }
                this.Dp.setData(pasterData);
                this.mStartPosition = this.Dp.getCurDuration();
                if (!kF()) {
                    this.Dt.e(kM());
                    com.baidu.tieba.lego.card.b.c.b(this.Du);
                }
                this.Dp.b(z, z2, str);
                if (this.Ds != null) {
                    this.Ds.kW();
                }
                return true;
            }
        }
        return false;
    }

    public boolean kE() {
        return this.Dv;
    }

    public boolean kF() {
        return this.Dp.kF();
    }

    public boolean kG() {
        return this.Dp.kG();
    }

    public void reset() {
        kJ();
        this.Dv = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kH() {
        kJ();
        if (this.Ds != null) {
            this.Ds.kV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kI() {
        this.Dt.h(kM());
        kJ();
    }

    private void kJ() {
        this.Dr.reset();
        this.Dp.reset();
        this.rootView.removeView(this.Dp);
        this.rootView.removeView(this.Dq);
    }

    public void resume() {
        this.Dp.resume();
        if (kG()) {
            this.mStartPosition = this.Dp.getCurDuration();
            this.Dw = this.mStartPosition;
            this.Dt.g(kM());
        }
    }

    public void kK() {
        if (this.Dp != null) {
            this.Dp.kK();
        }
    }

    public void stop() {
        this.mPausePosition = this.Dp.getCurDuration();
        if (kG() && !kL()) {
            this.Dt.f(kM());
        }
        this.Dp.stop();
    }

    private boolean kL() {
        if (this.Dp != null) {
            int[] iArr = new int[2];
            this.Dp.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Ds = aVar;
    }

    public com.baidu.afd.videopaster.b.a kM() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.Ed = this.Dw;
        aVar.Ee = this.mPausePosition;
        aVar.Eb = this.Dp.getTotalDuration();
        aVar.Ec = this.Dp.getCurDuration();
        aVar.Ea = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Ef = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Ef = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Ef = 2;
        } else {
            aVar.Ef = -1;
        }
        if (this.Du != null) {
            aVar.Eg = this.Du.kY();
            aVar.tplName = this.Du.tplName;
            aVar.extraParam = this.Du.extra;
            aVar.DM = this.Du.DM;
            aVar.DN = this.Du.DN;
        }
        return aVar;
    }

    public void au(int i) {
        if (this.Dp != null) {
            this.Dp.au(i);
        }
    }

    public void onDestroy() {
        this.Dr.onDestroy();
    }

    public void kN() {
        if (this.Dp != null) {
            this.Dp.kN();
        }
    }

    public void kO() {
        if (this.Dp != null) {
            this.Dp.kO();
        }
    }

    public boolean kP() {
        return this.Dp != null && this.Dp.kP();
    }

    public void V(boolean z) {
        this.Dy = z;
    }
}
