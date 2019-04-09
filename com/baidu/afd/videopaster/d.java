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
    private ViewGroup TH;
    private VideoPasterContentView TI;
    private View TJ;
    private a TL;
    private com.baidu.afd.videopaster.data.a TO;
    private int TQ;
    private int TR;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mStartPosition;
    private boolean TP = false;
    private boolean TS = false;
    private boolean TT = false;
    private QuickVideoView TF = this.TF;
    private QuickVideoView TF = this.TF;
    private n TG = this.TG;
    private n TG = this.TG;
    private com.baidu.afd.videopaster.b.b TM = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a TK = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes3.dex */
    public interface a {
        void qq();

        void qr();

        void qs();

        boolean qt();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.TH = viewGroup;
        this.TK.a(new a.InterfaceC0028a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.TO = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void g(int i, String str) {
                d.this.TO = null;
            }
        });
        this.TI = new VideoPasterContentView(context);
        this.TI.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qm() {
                d.this.TM.k(d.this.qi());
                com.baidu.tieba.lego.card.b.c.a(d.this.TO);
                if (d.this.TO != null && s.aS(d.this.mContext, d.this.TO.TX) == 1) {
                    d.this.TM.c(d.this.qi(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qn() {
                d.this.TM.j(d.this.qi());
                com.baidu.tieba.lego.card.b.c.a(d.this.TO);
                if (d.this.TO != null && s.aS(d.this.mContext, d.this.TO.TX) == 1) {
                    d.this.TM.c(d.this.qi(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qo() {
                d.this.TM.l(d.this.qi());
                com.baidu.tieba.lego.card.b.c.a(d.this.TO);
                if (d.this.TO != null && s.aS(d.this.mContext, d.this.TO.TX) == 1) {
                    d.this.TM.c(d.this.qi(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qp() {
                d.this.TS = true;
                d.this.qd();
                d.this.TM.f(d.this.qi());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qq() {
                d.this.TM.m(d.this.qi());
                if (d.this.TL != null) {
                    d.this.TL.qq();
                }
            }
        });
        this.TI.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void qr() {
                d.this.qe();
                if (d.this.TL != null) {
                    d.this.TL.qr();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.TI.isCompleted()) {
                    i = 0;
                } else if (d.this.TS) {
                    d.this.TS = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.TL != null) {
                    if (i == 0 || i == 1) {
                        d.this.bi(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.TL.qt()) {
                        if (d.this.TT) {
                            d.this.TT = false;
                        } else if (!z) {
                            d.this.bi(i);
                        }
                    }
                }
            }
        });
        this.TJ = new View(this.mContext);
        this.TJ.setBackgroundResource(d.C0277d.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(int i) {
        this.TM.b(qi(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.TM.f(qi());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.TK != null && !this.TK.qz() && this.TK.qA() == null && aVar != null) {
            this.mFloor = aVar.pO() + 1;
            this.TK.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Ud) {
            this.TM.i(qi());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.TK.qz()) {
            return false;
        }
        this.TP = z2;
        this.mFrom = str;
        VideoPasterResponseData qA = this.TK.qA();
        if (qA != null) {
            com.baidu.afd.videopaster.data.a pasterData = qA.getPasterData();
            if (pasterData == null) {
                this.TK.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.TM.e(qi());
                this.TK.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.TK.reset();
                return false;
            } else {
                this.TH.removeView(this.TJ);
                this.TH.addView(this.TJ);
                this.TH.removeView(this.TI);
                this.TH.addView(this.TI);
                if (this.TH instanceof FrameLayout) {
                    this.TI.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.TH instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.TI.setLayoutParams(layoutParams);
                }
                this.TI.setData(pasterData);
                this.mStartPosition = this.TI.getCurDuration();
                if (!qb()) {
                    this.TM.e(qi());
                    com.baidu.tieba.lego.card.b.c.b(this.TO);
                }
                this.TI.b(z, z2, str);
                if (this.TL != null) {
                    this.TL.qs();
                }
                return true;
            }
        }
        return false;
    }

    public boolean qa() {
        return this.TP;
    }

    public boolean qb() {
        return this.TI.qb();
    }

    public boolean qc() {
        return this.TI.qc();
    }

    public void reset() {
        qf();
        this.TP = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd() {
        qf();
        if (this.TL != null) {
            this.TL.qr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe() {
        this.TM.h(qi());
        qf();
    }

    private void qf() {
        this.TK.reset();
        this.TI.reset();
        this.TH.removeView(this.TI);
        this.TH.removeView(this.TJ);
    }

    public void resume() {
        this.TI.resume();
        if (qc()) {
            this.mStartPosition = this.TI.getCurDuration();
            this.TR = this.mStartPosition;
            this.TM.g(qi());
        }
    }

    public void qg() {
        if (this.TI != null) {
            this.TI.qg();
        }
    }

    public void stop() {
        this.TQ = this.TI.getCurDuration();
        if (qc() && !qh()) {
            this.TM.f(qi());
        }
        this.TI.stop();
    }

    private boolean qh() {
        if (this.TI != null) {
            int[] iArr = new int[2];
            this.TI.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.TL = aVar;
    }

    public com.baidu.afd.videopaster.b.a qi() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.Uu = this.mStartPosition;
        aVar.Uv = this.TR;
        aVar.Uw = this.TQ;
        aVar.Us = this.TI.getTotalDuration();
        aVar.Ut = this.TI.getCurDuration();
        aVar.Ur = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Ux = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Ux = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Ux = 2;
        } else {
            aVar.Ux = -1;
        }
        if (this.TO != null) {
            aVar.Uy = this.TO.qu();
            aVar.tplName = this.TO.tplName;
            aVar.extraParam = this.TO.extra;
            aVar.Ue = this.TO.Ue;
            aVar.Uf = this.TO.Uf;
        }
        return aVar;
    }

    public void bj(int i) {
        if (this.TI != null) {
            this.TI.bj(i);
        }
    }

    public void onDestroy() {
        this.TK.onDestroy();
    }

    public void qj() {
        if (this.TI != null) {
            this.TI.qj();
        }
    }

    public void qk() {
        if (this.TI != null) {
            this.TI.qk();
        }
    }

    public boolean ql() {
        return this.TI != null && this.TI.ql();
    }

    public void aC(boolean z) {
        this.TT = z;
    }
}
