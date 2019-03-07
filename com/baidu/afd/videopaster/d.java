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
    private ViewGroup TF;
    private VideoPasterContentView TG;
    private View TH;
    private a TJ;
    private com.baidu.afd.videopaster.data.a TL;
    private int TO;
    private int TP;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mStartPosition;
    private boolean TM = false;
    private boolean TQ = false;
    private boolean TR = false;
    private QuickVideoView TC = this.TC;
    private QuickVideoView TC = this.TC;
    private n TD = this.TD;
    private n TD = this.TD;
    private com.baidu.afd.videopaster.b.b TK = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a TI = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes3.dex */
    public interface a {
        void qq();

        void qr();

        void qs();

        boolean qt();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.TF = viewGroup;
        this.TI.a(new a.InterfaceC0028a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.TL = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void g(int i, String str) {
                d.this.TL = null;
            }
        });
        this.TG = new VideoPasterContentView(context);
        this.TG.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qm() {
                d.this.TK.k(d.this.qi());
                com.baidu.tieba.lego.card.b.c.a(d.this.TL);
                if (d.this.TL != null && s.aT(d.this.mContext, d.this.TL.TV) == 1) {
                    d.this.TK.c(d.this.qi(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qn() {
                d.this.TK.j(d.this.qi());
                com.baidu.tieba.lego.card.b.c.a(d.this.TL);
                if (d.this.TL != null && s.aT(d.this.mContext, d.this.TL.TV) == 1) {
                    d.this.TK.c(d.this.qi(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qo() {
                d.this.TK.l(d.this.qi());
                com.baidu.tieba.lego.card.b.c.a(d.this.TL);
                if (d.this.TL != null && s.aT(d.this.mContext, d.this.TL.TV) == 1) {
                    d.this.TK.c(d.this.qi(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qp() {
                d.this.TQ = true;
                d.this.qd();
                d.this.TK.f(d.this.qi());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qq() {
                d.this.TK.m(d.this.qi());
                if (d.this.TJ != null) {
                    d.this.TJ.qq();
                }
            }
        });
        this.TG.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void qr() {
                d.this.qe();
                if (d.this.TJ != null) {
                    d.this.TJ.qr();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.TG.isCompleted()) {
                    i = 0;
                } else if (d.this.TQ) {
                    d.this.TQ = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.TJ != null) {
                    if (i == 0 || i == 1) {
                        d.this.bj(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.TJ.qt()) {
                        if (d.this.TR) {
                            d.this.TR = false;
                        } else if (!z) {
                            d.this.bj(i);
                        }
                    }
                }
            }
        });
        this.TH = new View(this.mContext);
        this.TH.setBackgroundResource(d.C0236d.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(int i) {
        this.TK.b(qi(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.TK.f(qi());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.TI != null && !this.TI.qz() && this.TI.qA() == null && aVar != null) {
            this.mFloor = aVar.pO() + 1;
            this.TI.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Ub) {
            this.TK.i(qi());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.TI.qz()) {
            return false;
        }
        this.TM = z2;
        this.mFrom = str;
        VideoPasterResponseData qA = this.TI.qA();
        if (qA != null) {
            com.baidu.afd.videopaster.data.a pasterData = qA.getPasterData();
            if (pasterData == null) {
                this.TI.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.TK.e(qi());
                this.TI.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.TI.reset();
                return false;
            } else {
                this.TF.removeView(this.TH);
                this.TF.addView(this.TH);
                this.TF.removeView(this.TG);
                this.TF.addView(this.TG);
                if (this.TF instanceof FrameLayout) {
                    this.TG.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.TF instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.TG.setLayoutParams(layoutParams);
                }
                this.TG.setData(pasterData);
                this.mStartPosition = this.TG.getCurDuration();
                if (!qb()) {
                    this.TK.e(qi());
                    com.baidu.tieba.lego.card.b.c.b(this.TL);
                }
                this.TG.b(z, z2, str);
                if (this.TJ != null) {
                    this.TJ.qs();
                }
                return true;
            }
        }
        return false;
    }

    public boolean qa() {
        return this.TM;
    }

    public boolean qb() {
        return this.TG.qb();
    }

    public boolean qc() {
        return this.TG.qc();
    }

    public void reset() {
        qf();
        this.TM = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd() {
        qf();
        if (this.TJ != null) {
            this.TJ.qr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe() {
        this.TK.h(qi());
        qf();
    }

    private void qf() {
        this.TI.reset();
        this.TG.reset();
        this.TF.removeView(this.TG);
        this.TF.removeView(this.TH);
    }

    public void resume() {
        this.TG.resume();
        if (qc()) {
            this.mStartPosition = this.TG.getCurDuration();
            this.TP = this.mStartPosition;
            this.TK.g(qi());
        }
    }

    public void qg() {
        if (this.TG != null) {
            this.TG.qg();
        }
    }

    public void stop() {
        this.TO = this.TG.getCurDuration();
        if (qc() && !qh()) {
            this.TK.f(qi());
        }
        this.TG.stop();
    }

    private boolean qh() {
        if (this.TG != null) {
            int[] iArr = new int[2];
            this.TG.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.TJ = aVar;
    }

    public com.baidu.afd.videopaster.b.a qi() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.Us = this.mStartPosition;
        aVar.Ut = this.TP;
        aVar.Uu = this.TO;
        aVar.Uq = this.TG.getTotalDuration();
        aVar.Ur = this.TG.getCurDuration();
        aVar.Up = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Uv = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Uv = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Uv = 2;
        } else {
            aVar.Uv = -1;
        }
        if (this.TL != null) {
            aVar.Uw = this.TL.qu();
            aVar.tplName = this.TL.tplName;
            aVar.extraParam = this.TL.extra;
            aVar.Uc = this.TL.Uc;
            aVar.Ud = this.TL.Ud;
        }
        return aVar;
    }

    public void bk(int i) {
        if (this.TG != null) {
            this.TG.bk(i);
        }
    }

    public void onDestroy() {
        this.TI.onDestroy();
    }

    public void qj() {
        if (this.TG != null) {
            this.TG.qj();
        }
    }

    public void qk() {
        if (this.TG != null) {
            this.TG.qk();
        }
    }

    public boolean ql() {
        return this.TG != null && this.TG.ql();
    }

    public void aC(boolean z) {
        this.TR = z;
    }
}
