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
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.n;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class d {
    private ViewGroup TG;
    private VideoPasterContentView TH;
    private View TI;
    private a TK;
    private com.baidu.afd.videopaster.data.a TM;
    private int TP;
    private int TQ;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mStartPosition;
    private boolean TO = false;
    private boolean TR = false;
    private boolean TS = false;
    private QuickVideoView TD = this.TD;
    private QuickVideoView TD = this.TD;
    private n TF = this.TF;
    private n TF = this.TF;
    private com.baidu.afd.videopaster.b.b TL = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a TJ = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes3.dex */
    public interface a {
        void qq();

        void qr();

        void qs();

        boolean qt();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.TG = viewGroup;
        this.TJ.a(new a.InterfaceC0028a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.TM = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void g(int i, String str) {
                d.this.TM = null;
            }
        });
        this.TH = new VideoPasterContentView(context);
        this.TH.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qm() {
                d.this.TL.k(d.this.qi());
                com.baidu.tieba.lego.card.b.c.a(d.this.TM);
                if (d.this.TM != null && s.aS(d.this.mContext, d.this.TM.TW) == 1) {
                    d.this.TL.c(d.this.qi(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qn() {
                d.this.TL.j(d.this.qi());
                com.baidu.tieba.lego.card.b.c.a(d.this.TM);
                if (d.this.TM != null && s.aS(d.this.mContext, d.this.TM.TW) == 1) {
                    d.this.TL.c(d.this.qi(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qo() {
                d.this.TL.l(d.this.qi());
                com.baidu.tieba.lego.card.b.c.a(d.this.TM);
                if (d.this.TM != null && s.aS(d.this.mContext, d.this.TM.TW) == 1) {
                    d.this.TL.c(d.this.qi(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qp() {
                d.this.TR = true;
                d.this.qd();
                d.this.TL.f(d.this.qi());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qq() {
                d.this.TL.m(d.this.qi());
                if (d.this.TK != null) {
                    d.this.TK.qq();
                }
            }
        });
        this.TH.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void qr() {
                d.this.qe();
                if (d.this.TK != null) {
                    d.this.TK.qr();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.TH.isCompleted()) {
                    i = 0;
                } else if (d.this.TR) {
                    d.this.TR = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.TK != null) {
                    if (i == 0 || i == 1) {
                        d.this.bi(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.TK.qt()) {
                        if (d.this.TS) {
                            d.this.TS = false;
                        } else if (!z) {
                            d.this.bi(i);
                        }
                    }
                }
            }
        });
        this.TI = new View(this.mContext);
        this.TI.setBackgroundResource(d.C0277d.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(int i) {
        this.TL.b(qi(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.TL.f(qi());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.TJ != null && !this.TJ.qz() && this.TJ.qA() == null && aVar != null) {
            this.mFloor = aVar.pO() + 1;
            this.TJ.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Uc) {
            this.TL.i(qi());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.TJ.qz()) {
            return false;
        }
        this.TO = z2;
        this.mFrom = str;
        VideoPasterResponseData qA = this.TJ.qA();
        if (qA != null) {
            com.baidu.afd.videopaster.data.a pasterData = qA.getPasterData();
            if (pasterData == null) {
                this.TJ.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.TL.e(qi());
                this.TJ.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.TJ.reset();
                return false;
            } else {
                this.TG.removeView(this.TI);
                this.TG.addView(this.TI);
                this.TG.removeView(this.TH);
                this.TG.addView(this.TH);
                if (this.TG instanceof FrameLayout) {
                    this.TH.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.TG instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.TH.setLayoutParams(layoutParams);
                }
                this.TH.setData(pasterData);
                this.mStartPosition = this.TH.getCurDuration();
                if (!qb()) {
                    this.TL.e(qi());
                    com.baidu.tieba.lego.card.b.c.b(this.TM);
                }
                this.TH.b(z, z2, str);
                if (this.TK != null) {
                    this.TK.qs();
                }
                return true;
            }
        }
        return false;
    }

    public boolean qa() {
        return this.TO;
    }

    public boolean qb() {
        return this.TH.qb();
    }

    public boolean qc() {
        return this.TH.qc();
    }

    public void reset() {
        qf();
        this.TO = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd() {
        qf();
        if (this.TK != null) {
            this.TK.qr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe() {
        this.TL.h(qi());
        qf();
    }

    private void qf() {
        this.TJ.reset();
        this.TH.reset();
        this.TG.removeView(this.TH);
        this.TG.removeView(this.TI);
    }

    public void resume() {
        this.TH.resume();
        if (qc()) {
            this.mStartPosition = this.TH.getCurDuration();
            this.TQ = this.mStartPosition;
            this.TL.g(qi());
        }
    }

    public void qg() {
        if (this.TH != null) {
            this.TH.qg();
        }
    }

    public void stop() {
        this.TP = this.TH.getCurDuration();
        if (qc() && !qh()) {
            this.TL.f(qi());
        }
        this.TH.stop();
    }

    private boolean qh() {
        if (this.TH != null) {
            int[] iArr = new int[2];
            this.TH.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.TK = aVar;
    }

    public com.baidu.afd.videopaster.b.a qi() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.Ut = this.mStartPosition;
        aVar.Uu = this.TQ;
        aVar.Uv = this.TP;
        aVar.Ur = this.TH.getTotalDuration();
        aVar.Us = this.TH.getCurDuration();
        aVar.Uq = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Uw = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Uw = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Uw = 2;
        } else {
            aVar.Uw = -1;
        }
        if (this.TM != null) {
            aVar.Ux = this.TM.qu();
            aVar.tplName = this.TM.tplName;
            aVar.extraParam = this.TM.extra;
            aVar.Ud = this.TM.Ud;
            aVar.Ue = this.TM.Ue;
        }
        return aVar;
    }

    public void bj(int i) {
        if (this.TH != null) {
            this.TH.bj(i);
        }
    }

    public void onDestroy() {
        this.TJ.onDestroy();
    }

    public void qj() {
        if (this.TH != null) {
            this.TH.qj();
        }
    }

    public void qk() {
        if (this.TH != null) {
            this.TH.qk();
        }
    }

    public boolean ql() {
        return this.TH != null && this.TH.ql();
    }

    public void aC(boolean z) {
        this.TS = z;
    }
}
