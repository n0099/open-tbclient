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
import com.baidu.tieba.recapp.s;
/* loaded from: classes15.dex */
public class d {
    private VideoPasterContentView XP;
    private View XQ;
    private a XS;
    private com.baidu.afd.videopaster.data.a XU;
    private int XW;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean XV = false;
    private boolean XX = false;
    private boolean XY = false;
    private com.baidu.afd.videopaster.b.b XT = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a XR = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes15.dex */
    public interface a {
        void ql();

        void qm();

        void qn();

        boolean qo();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.XR.a(new a.InterfaceC0034a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0034a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.XU = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0034a
            public void e(int i, String str) {
                d.this.XU = null;
            }
        });
        this.XP = new VideoPasterContentView(context);
        this.XP.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qh() {
                d.this.XT.k(d.this.qd());
                com.baidu.tieba.lego.card.b.c.a(d.this.XU);
                if (d.this.XU != null && s.aN(d.this.mContext, d.this.XU.Yc) == 1) {
                    d.this.XT.c(d.this.qd(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qi() {
                d.this.XT.j(d.this.qd());
                com.baidu.tieba.lego.card.b.c.a(d.this.XU);
                if (d.this.XU != null && s.aN(d.this.mContext, d.this.XU.Yc) == 1) {
                    d.this.XT.c(d.this.qd(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qj() {
                d.this.XT.l(d.this.qd());
                com.baidu.tieba.lego.card.b.c.a(d.this.XU);
                if (d.this.XU != null && s.aN(d.this.mContext, d.this.XU.Yc) == 1) {
                    d.this.XT.c(d.this.qd(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qk() {
                d.this.XX = true;
                d.this.pY();
                d.this.XT.f(d.this.qd());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void ql() {
                d.this.XT.m(d.this.qd());
                if (d.this.XS != null) {
                    d.this.XS.ql();
                }
            }
        });
        this.XP.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void qm() {
                d.this.pZ();
                if (d.this.XS != null) {
                    d.this.XS.qm();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.XP.gJ()) {
                    i = 0;
                } else if (d.this.XX) {
                    d.this.XX = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.XS != null) {
                    if (i == 0 || i == 1) {
                        d.this.aR(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.XS.qo()) {
                        if (d.this.XY) {
                            d.this.XY = false;
                        } else if (!z) {
                            d.this.aR(i);
                        }
                    }
                }
            }
        });
        this.XQ = new View(this.mContext);
        this.XQ.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(int i) {
        this.XT.b(qd(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.XT.f(qd());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.XR != null && !this.XR.isLoading() && this.XR.qu() == null && aVar != null) {
            this.mFloor = aVar.pJ() + 1;
            this.XR.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Yj) {
            this.XT.i(qd());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.XR.isLoading()) {
            return false;
        }
        this.XV = z2;
        this.mFrom = str;
        VideoPasterResponseData qu = this.XR.qu();
        if (qu != null) {
            com.baidu.afd.videopaster.data.a pasterData = qu.getPasterData();
            if (pasterData == null) {
                this.XR.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.XT.e(qd());
                this.XR.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.XR.reset();
                return false;
            } else {
                this.rootView.removeView(this.XQ);
                this.rootView.addView(this.XQ);
                this.rootView.removeView(this.XP);
                this.rootView.addView(this.XP);
                if (this.rootView instanceof FrameLayout) {
                    this.XP.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.XP.setLayoutParams(layoutParams);
                }
                this.XP.setData(pasterData);
                this.mStartPosition = this.XP.getCurDuration();
                if (!pW()) {
                    this.XT.e(qd());
                    com.baidu.tieba.lego.card.b.c.b(this.XU);
                }
                this.XP.b(z, z2, str);
                if (this.XS != null) {
                    this.XS.qn();
                }
                return true;
            }
        }
        return false;
    }

    public boolean pV() {
        return this.XV;
    }

    public boolean pW() {
        return this.XP.pW();
    }

    public boolean pX() {
        return this.XP.pX();
    }

    public void reset() {
        qa();
        this.XV = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY() {
        qa();
        if (this.XS != null) {
            this.XS.qm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ() {
        this.XT.h(qd());
        qa();
    }

    private void qa() {
        this.XR.reset();
        this.XP.reset();
        this.rootView.removeView(this.XP);
        this.rootView.removeView(this.XQ);
    }

    public void resume() {
        this.XP.resume();
        if (pX()) {
            this.mStartPosition = this.XP.getCurDuration();
            this.XW = this.mStartPosition;
            this.XT.g(qd());
        }
    }

    public void qb() {
        if (this.XP != null) {
            this.XP.qb();
        }
    }

    public void stop() {
        this.mPausePosition = this.XP.getCurDuration();
        if (pX() && !qc()) {
            this.XT.f(qd());
        }
        this.XP.stop();
    }

    private boolean qc() {
        if (this.XP != null) {
            int[] iArr = new int[2];
            this.XP.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.XS = aVar;
    }

    public com.baidu.afd.videopaster.b.a qd() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.YA = this.XW;
        aVar.YB = this.mPausePosition;
        aVar.Yy = this.XP.getTotalDuration();
        aVar.Yz = this.XP.getCurDuration();
        aVar.Yx = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.YC = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.YC = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.YC = 2;
        } else {
            aVar.YC = -1;
        }
        if (this.XU != null) {
            aVar.YD = this.XU.qp();
            aVar.tplName = this.XU.tplName;
            aVar.extraParam = this.XU.extra;
            aVar.Yk = this.XU.Yk;
            aVar.Yl = this.XU.Yl;
        }
        return aVar;
    }

    public void aS(int i) {
        if (this.XP != null) {
            this.XP.aS(i);
        }
    }

    public void onDestroy() {
        this.XR.onDestroy();
    }

    public void qe() {
        if (this.XP != null) {
            this.XP.qe();
        }
    }

    public void qf() {
        if (this.XP != null) {
            this.XP.qf();
        }
    }

    public boolean qg() {
        return this.XP != null && this.XP.qg();
    }

    public void aA(boolean z) {
        this.XY = z;
    }
}
