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
/* loaded from: classes3.dex */
public class d {
    private ViewGroup RH;
    private VideoPasterContentView RI;
    private View RJ;
    private a RL;
    private com.baidu.afd.videopaster.data.a RP;
    private int RR;
    private int RT;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mStartPosition;
    private boolean RQ = false;
    private boolean RU = false;
    private boolean RV = false;
    private QuickVideoView RF = this.RF;
    private QuickVideoView RF = this.RF;
    private n RG = this.RG;
    private n RG = this.RG;
    private com.baidu.afd.videopaster.b.b RO = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a RK = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes3.dex */
    public interface a {
        void pH();

        void pI();

        void pJ();

        boolean pK();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.RH = viewGroup;
        this.RK.a(new a.InterfaceC0028a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.RP = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void g(int i, String str) {
                d.this.RP = null;
            }
        });
        this.RI = new VideoPasterContentView(context);
        this.RI.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pD() {
                d.this.RO.k(d.this.pz());
                com.baidu.tieba.lego.card.b.c.a(d.this.RP);
                if (d.this.RP != null && s.aO(d.this.mContext, d.this.RP.RZ) == 1) {
                    d.this.RO.c(d.this.pz(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pE() {
                d.this.RO.j(d.this.pz());
                com.baidu.tieba.lego.card.b.c.a(d.this.RP);
                if (d.this.RP != null && s.aO(d.this.mContext, d.this.RP.RZ) == 1) {
                    d.this.RO.c(d.this.pz(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pF() {
                d.this.RO.l(d.this.pz());
                com.baidu.tieba.lego.card.b.c.a(d.this.RP);
                if (d.this.RP != null && s.aO(d.this.mContext, d.this.RP.RZ) == 1) {
                    d.this.RO.c(d.this.pz(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pG() {
                d.this.RU = true;
                d.this.pu();
                d.this.RO.f(d.this.pz());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pH() {
                d.this.RO.m(d.this.pz());
                if (d.this.RL != null) {
                    d.this.RL.pH();
                }
            }
        });
        this.RI.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void pI() {
                d.this.pv();
                if (d.this.RL != null) {
                    d.this.RL.pI();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.RI.bh()) {
                    i = 0;
                } else if (d.this.RU) {
                    d.this.RU = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.RL != null) {
                    if (i == 0 || i == 1) {
                        d.this.bb(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.RL.pK()) {
                        if (d.this.RV) {
                            d.this.RV = false;
                        } else if (!z) {
                            d.this.bb(i);
                        }
                    }
                }
            }
        });
        this.RJ = new View(this.mContext);
        this.RJ.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i) {
        this.RO.b(pz(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.RO.f(pz());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.RK != null && !this.RK.pQ() && this.RK.pR() == null && aVar != null) {
            this.mFloor = aVar.pf() + 1;
            this.RK.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Sf) {
            this.RO.i(pz());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.RK.pQ()) {
            return false;
        }
        this.RQ = z2;
        this.mFrom = str;
        VideoPasterResponseData pR = this.RK.pR();
        if (pR != null) {
            com.baidu.afd.videopaster.data.a pasterData = pR.getPasterData();
            if (pasterData == null) {
                this.RK.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.RO.e(pz());
                this.RK.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.RK.reset();
                return false;
            } else {
                this.RH.removeView(this.RJ);
                this.RH.addView(this.RJ);
                this.RH.removeView(this.RI);
                this.RH.addView(this.RI);
                if (this.RH instanceof FrameLayout) {
                    this.RI.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.RH instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.RI.setLayoutParams(layoutParams);
                }
                this.RI.setData(pasterData);
                this.mStartPosition = this.RI.getCurDuration();
                if (!ps()) {
                    this.RO.e(pz());
                    com.baidu.tieba.lego.card.b.c.b(this.RP);
                }
                this.RI.b(z, z2, str);
                if (this.RL != null) {
                    this.RL.pJ();
                }
                return true;
            }
        }
        return false;
    }

    public boolean pr() {
        return this.RQ;
    }

    public boolean ps() {
        return this.RI.ps();
    }

    public boolean pt() {
        return this.RI.pt();
    }

    public void reset() {
        pw();
        this.RQ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu() {
        pw();
        if (this.RL != null) {
            this.RL.pI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pv() {
        this.RO.h(pz());
        pw();
    }

    private void pw() {
        this.RK.reset();
        this.RI.reset();
        this.RH.removeView(this.RI);
        this.RH.removeView(this.RJ);
    }

    public void resume() {
        this.RI.resume();
        if (pt()) {
            this.mStartPosition = this.RI.getCurDuration();
            this.RT = this.mStartPosition;
            this.RO.g(pz());
        }
    }

    public void px() {
        if (this.RI != null) {
            this.RI.px();
        }
    }

    public void stop() {
        this.RR = this.RI.getCurDuration();
        if (pt() && !py()) {
            this.RO.f(pz());
        }
        this.RI.stop();
    }

    private boolean py() {
        if (this.RI != null) {
            int[] iArr = new int[2];
            this.RI.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.RL = aVar;
    }

    public com.baidu.afd.videopaster.b.a pz() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.Sw = this.mStartPosition;
        aVar.Sx = this.RT;
        aVar.Sy = this.RR;
        aVar.Su = this.RI.getTotalDuration();
        aVar.Sv = this.RI.getCurDuration();
        aVar.St = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Sz = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Sz = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Sz = 2;
        } else {
            aVar.Sz = -1;
        }
        if (this.RP != null) {
            aVar.SA = this.RP.pL();
            aVar.tplName = this.RP.tplName;
            aVar.extraParam = this.RP.extra;
            aVar.Sg = this.RP.Sg;
            aVar.Sh = this.RP.Sh;
        }
        return aVar;
    }

    public void bc(int i) {
        if (this.RI != null) {
            this.RI.bc(i);
        }
    }

    public void onDestroy() {
        this.RK.onDestroy();
    }

    public void pA() {
        if (this.RI != null) {
            this.RI.pA();
        }
    }

    public void pB() {
        if (this.RI != null) {
            this.RI.pB();
        }
    }

    public boolean pC() {
        return this.RI != null && this.RI.pC();
    }

    public void ax(boolean z) {
        this.RV = z;
    }
}
