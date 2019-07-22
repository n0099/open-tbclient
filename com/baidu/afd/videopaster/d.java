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
    private ViewGroup RI;
    private VideoPasterContentView RJ;
    private View RK;
    private a RO;
    private com.baidu.afd.videopaster.data.a RQ;
    private int RT;
    private int RU;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mStartPosition;
    private boolean RR = false;
    private boolean RV = false;
    private boolean RW = false;
    private QuickVideoView RG = this.RG;
    private QuickVideoView RG = this.RG;
    private n RH = this.RH;
    private n RH = this.RH;
    private com.baidu.afd.videopaster.b.b RP = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a RL = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes3.dex */
    public interface a {
        void pG();

        void pH();

        void pI();

        boolean pJ();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.RI = viewGroup;
        this.RL.a(new a.InterfaceC0028a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.RQ = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void g(int i, String str) {
                d.this.RQ = null;
            }
        });
        this.RJ = new VideoPasterContentView(context);
        this.RJ.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pC() {
                d.this.RP.k(d.this.py());
                com.baidu.tieba.lego.card.b.c.a(d.this.RQ);
                if (d.this.RQ != null && s.aH(d.this.mContext, d.this.RQ.Sa) == 1) {
                    d.this.RP.c(d.this.py(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pD() {
                d.this.RP.j(d.this.py());
                com.baidu.tieba.lego.card.b.c.a(d.this.RQ);
                if (d.this.RQ != null && s.aH(d.this.mContext, d.this.RQ.Sa) == 1) {
                    d.this.RP.c(d.this.py(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pE() {
                d.this.RP.l(d.this.py());
                com.baidu.tieba.lego.card.b.c.a(d.this.RQ);
                if (d.this.RQ != null && s.aH(d.this.mContext, d.this.RQ.Sa) == 1) {
                    d.this.RP.c(d.this.py(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pF() {
                d.this.RV = true;
                d.this.pt();
                d.this.RP.f(d.this.py());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pG() {
                d.this.RP.m(d.this.py());
                if (d.this.RO != null) {
                    d.this.RO.pG();
                }
            }
        });
        this.RJ.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void pH() {
                d.this.pu();
                if (d.this.RO != null) {
                    d.this.RO.pH();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.RJ.bh()) {
                    i = 0;
                } else if (d.this.RV) {
                    d.this.RV = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.RO != null) {
                    if (i == 0 || i == 1) {
                        d.this.bb(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.RO.pJ()) {
                        if (d.this.RW) {
                            d.this.RW = false;
                        } else if (!z) {
                            d.this.bb(i);
                        }
                    }
                }
            }
        });
        this.RK = new View(this.mContext);
        this.RK.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i) {
        this.RP.b(py(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.RP.f(py());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.RL != null && !this.RL.pP() && this.RL.pQ() == null && aVar != null) {
            this.mFloor = aVar.pe() + 1;
            this.RL.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Sg) {
            this.RP.i(py());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.RL.pP()) {
            return false;
        }
        this.RR = z2;
        this.mFrom = str;
        VideoPasterResponseData pQ = this.RL.pQ();
        if (pQ != null) {
            com.baidu.afd.videopaster.data.a pasterData = pQ.getPasterData();
            if (pasterData == null) {
                this.RL.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.RP.e(py());
                this.RL.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.RL.reset();
                return false;
            } else {
                this.RI.removeView(this.RK);
                this.RI.addView(this.RK);
                this.RI.removeView(this.RJ);
                this.RI.addView(this.RJ);
                if (this.RI instanceof FrameLayout) {
                    this.RJ.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.RI instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.RJ.setLayoutParams(layoutParams);
                }
                this.RJ.setData(pasterData);
                this.mStartPosition = this.RJ.getCurDuration();
                if (!pr()) {
                    this.RP.e(py());
                    com.baidu.tieba.lego.card.b.c.b(this.RQ);
                }
                this.RJ.b(z, z2, str);
                if (this.RO != null) {
                    this.RO.pI();
                }
                return true;
            }
        }
        return false;
    }

    public boolean pq() {
        return this.RR;
    }

    public boolean pr() {
        return this.RJ.pr();
    }

    public boolean ps() {
        return this.RJ.ps();
    }

    public void reset() {
        pv();
        this.RR = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt() {
        pv();
        if (this.RO != null) {
            this.RO.pH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu() {
        this.RP.h(py());
        pv();
    }

    private void pv() {
        this.RL.reset();
        this.RJ.reset();
        this.RI.removeView(this.RJ);
        this.RI.removeView(this.RK);
    }

    public void resume() {
        this.RJ.resume();
        if (ps()) {
            this.mStartPosition = this.RJ.getCurDuration();
            this.RU = this.mStartPosition;
            this.RP.g(py());
        }
    }

    public void pw() {
        if (this.RJ != null) {
            this.RJ.pw();
        }
    }

    public void stop() {
        this.RT = this.RJ.getCurDuration();
        if (ps() && !px()) {
            this.RP.f(py());
        }
        this.RJ.stop();
    }

    private boolean px() {
        if (this.RJ != null) {
            int[] iArr = new int[2];
            this.RJ.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.RO = aVar;
    }

    public com.baidu.afd.videopaster.b.a py() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.Sx = this.mStartPosition;
        aVar.Sy = this.RU;
        aVar.Sz = this.RT;
        aVar.Sv = this.RJ.getTotalDuration();
        aVar.Sw = this.RJ.getCurDuration();
        aVar.Su = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.SA = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.SA = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.SA = 2;
        } else {
            aVar.SA = -1;
        }
        if (this.RQ != null) {
            aVar.SB = this.RQ.pK();
            aVar.tplName = this.RQ.tplName;
            aVar.extraParam = this.RQ.extra;
            aVar.Sh = this.RQ.Sh;
            aVar.Si = this.RQ.Si;
        }
        return aVar;
    }

    public void bc(int i) {
        if (this.RJ != null) {
            this.RJ.bc(i);
        }
    }

    public void onDestroy() {
        this.RL.onDestroy();
    }

    public void pz() {
        if (this.RJ != null) {
            this.RJ.pz();
        }
    }

    public void pA() {
        if (this.RJ != null) {
            this.RJ.pA();
        }
    }

    public boolean pB() {
        return this.RJ != null && this.RJ.pB();
    }

    public void ax(boolean z) {
        this.RW = z;
    }
}
