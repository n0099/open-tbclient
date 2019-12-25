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
/* loaded from: classes5.dex */
public class d {
    private VideoPasterContentView Dk;
    private View Dl;
    private a Dn;
    private com.baidu.afd.videopaster.data.a Dp;
    private int Dr;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean Dq = false;
    private boolean Ds = false;
    private boolean Dt = false;
    private QuickVideoView Di = this.Di;
    private QuickVideoView Di = this.Di;
    private n Dj = this.Dj;
    private n Dj = this.Dj;
    private com.baidu.afd.videopaster.b.b Do = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Dm = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes5.dex */
    public interface a {
        void kT();

        void kU();

        void kV();

        boolean kW();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.Dm.a(new a.InterfaceC0030a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0030a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Dp = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0030a
            public void f(int i, String str) {
                d.this.Dp = null;
            }
        });
        this.Dk = new VideoPasterContentView(context);
        this.Dk.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kP() {
                d.this.Do.k(d.this.kL());
                com.baidu.tieba.lego.card.b.c.a(d.this.Dp);
                if (d.this.Dp != null && s.bd(d.this.mContext, d.this.Dp.Dx) == 1) {
                    d.this.Do.c(d.this.kL(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kQ() {
                d.this.Do.j(d.this.kL());
                com.baidu.tieba.lego.card.b.c.a(d.this.Dp);
                if (d.this.Dp != null && s.bd(d.this.mContext, d.this.Dp.Dx) == 1) {
                    d.this.Do.c(d.this.kL(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kR() {
                d.this.Do.l(d.this.kL());
                com.baidu.tieba.lego.card.b.c.a(d.this.Dp);
                if (d.this.Dp != null && s.bd(d.this.mContext, d.this.Dp.Dx) == 1) {
                    d.this.Do.c(d.this.kL(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kS() {
                d.this.Ds = true;
                d.this.kG();
                d.this.Do.f(d.this.kL());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kT() {
                d.this.Do.m(d.this.kL());
                if (d.this.Dn != null) {
                    d.this.Dn.kT();
                }
            }
        });
        this.Dk.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void kU() {
                d.this.kH();
                if (d.this.Dn != null) {
                    d.this.Dn.kU();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Dk.aW()) {
                    i = 0;
                } else if (d.this.Ds) {
                    d.this.Ds = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Dn != null) {
                    if (i == 0 || i == 1) {
                        d.this.at(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Dn.kW()) {
                        if (d.this.Dt) {
                            d.this.Dt = false;
                        } else if (!z) {
                            d.this.at(i);
                        }
                    }
                }
            }
        });
        this.Dl = new View(this.mContext);
        this.Dl.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(int i) {
        this.Do.b(kL(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Do.f(kL());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Dm != null && !this.Dm.isLoading() && this.Dm.lc() == null && aVar != null) {
            this.mFloor = aVar.kr() + 1;
            this.Dm.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.DE) {
            this.Do.i(kL());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Dm.isLoading()) {
            return false;
        }
        this.Dq = z2;
        this.mFrom = str;
        VideoPasterResponseData lc = this.Dm.lc();
        if (lc != null) {
            com.baidu.afd.videopaster.data.a pasterData = lc.getPasterData();
            if (pasterData == null) {
                this.Dm.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Do.e(kL());
                this.Dm.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Dm.reset();
                return false;
            } else {
                this.rootView.removeView(this.Dl);
                this.rootView.addView(this.Dl);
                this.rootView.removeView(this.Dk);
                this.rootView.addView(this.Dk);
                if (this.rootView instanceof FrameLayout) {
                    this.Dk.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Dk.setLayoutParams(layoutParams);
                }
                this.Dk.setData(pasterData);
                this.mStartPosition = this.Dk.getCurDuration();
                if (!kE()) {
                    this.Do.e(kL());
                    com.baidu.tieba.lego.card.b.c.b(this.Dp);
                }
                this.Dk.b(z, z2, str);
                if (this.Dn != null) {
                    this.Dn.kV();
                }
                return true;
            }
        }
        return false;
    }

    public boolean kD() {
        return this.Dq;
    }

    public boolean kE() {
        return this.Dk.kE();
    }

    public boolean kF() {
        return this.Dk.kF();
    }

    public void reset() {
        kI();
        this.Dq = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kG() {
        kI();
        if (this.Dn != null) {
            this.Dn.kU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kH() {
        this.Do.h(kL());
        kI();
    }

    private void kI() {
        this.Dm.reset();
        this.Dk.reset();
        this.rootView.removeView(this.Dk);
        this.rootView.removeView(this.Dl);
    }

    public void resume() {
        this.Dk.resume();
        if (kF()) {
            this.mStartPosition = this.Dk.getCurDuration();
            this.Dr = this.mStartPosition;
            this.Do.g(kL());
        }
    }

    public void kJ() {
        if (this.Dk != null) {
            this.Dk.kJ();
        }
    }

    public void stop() {
        this.mPausePosition = this.Dk.getCurDuration();
        if (kF() && !kK()) {
            this.Do.f(kL());
        }
        this.Dk.stop();
    }

    private boolean kK() {
        if (this.Dk != null) {
            int[] iArr = new int[2];
            this.Dk.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Dn = aVar;
    }

    public com.baidu.afd.videopaster.b.a kL() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.DY = this.Dr;
        aVar.DZ = this.mPausePosition;
        aVar.DW = this.Dk.getTotalDuration();
        aVar.DX = this.Dk.getCurDuration();
        aVar.DV = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Ea = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Ea = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Ea = 2;
        } else {
            aVar.Ea = -1;
        }
        if (this.Dp != null) {
            aVar.Eb = this.Dp.kX();
            aVar.tplName = this.Dp.tplName;
            aVar.extraParam = this.Dp.extra;
            aVar.DG = this.Dp.DG;
            aVar.DH = this.Dp.DH;
        }
        return aVar;
    }

    public void au(int i) {
        if (this.Dk != null) {
            this.Dk.au(i);
        }
    }

    public void onDestroy() {
        this.Dm.onDestroy();
    }

    public void kM() {
        if (this.Dk != null) {
            this.Dk.kM();
        }
    }

    public void kN() {
        if (this.Dk != null) {
            this.Dk.kN();
        }
    }

    public boolean kO() {
        return this.Dk != null && this.Dk.kO();
    }

    public void V(boolean z) {
        this.Dt = z;
    }
}
