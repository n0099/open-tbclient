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
    private VideoPasterContentView XZ;
    private View Ya;
    private a Yc;
    private com.baidu.afd.videopaster.data.a Yf;
    private int Yh;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean Yg = false;
    private boolean Yi = false;
    private boolean Yj = false;
    private QuickVideoView XX = this.XX;
    private QuickVideoView XX = this.XX;
    private n XY = this.XY;
    private n XY = this.XY;
    private com.baidu.afd.videopaster.b.b Ye = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Yb = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes8.dex */
    public interface a {
        void qk();

        void ql();

        void qm();

        boolean qn();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.Yb.a(new a.InterfaceC0034a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0034a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Yf = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0034a
            public void e(int i, String str) {
                d.this.Yf = null;
            }
        });
        this.XZ = new VideoPasterContentView(context);
        this.XZ.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qg() {
                d.this.Ye.k(d.this.qc());
                com.baidu.tieba.lego.card.b.c.a(d.this.Yf);
                if (d.this.Yf != null && r.aO(d.this.mContext, d.this.Yf.Yn) == 1) {
                    d.this.Ye.c(d.this.qc(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qh() {
                d.this.Ye.j(d.this.qc());
                com.baidu.tieba.lego.card.b.c.a(d.this.Yf);
                if (d.this.Yf != null && r.aO(d.this.mContext, d.this.Yf.Yn) == 1) {
                    d.this.Ye.c(d.this.qc(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qi() {
                d.this.Ye.l(d.this.qc());
                com.baidu.tieba.lego.card.b.c.a(d.this.Yf);
                if (d.this.Yf != null && r.aO(d.this.mContext, d.this.Yf.Yn) == 1) {
                    d.this.Ye.c(d.this.qc(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qj() {
                d.this.Yi = true;
                d.this.pX();
                d.this.Ye.f(d.this.qc());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void qk() {
                d.this.Ye.m(d.this.qc());
                if (d.this.Yc != null) {
                    d.this.Yc.qk();
                }
            }
        });
        this.XZ.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void ql() {
                d.this.pY();
                if (d.this.Yc != null) {
                    d.this.Yc.ql();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.XZ.gJ()) {
                    i = 0;
                } else if (d.this.Yi) {
                    d.this.Yi = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Yc != null) {
                    if (i == 0 || i == 1) {
                        d.this.aP(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Yc.qn()) {
                        if (d.this.Yj) {
                            d.this.Yj = false;
                        } else if (!z) {
                            d.this.aP(i);
                        }
                    }
                }
            }
        });
        this.Ya = new View(this.mContext);
        this.Ya.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i) {
        this.Ye.b(qc(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Ye.f(qc());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Yb != null && !this.Yb.isLoading() && this.Yb.qt() == null && aVar != null) {
            this.mFloor = aVar.pI() + 1;
            this.Yb.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Yt) {
            this.Ye.i(qc());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Yb.isLoading()) {
            return false;
        }
        this.Yg = z2;
        this.mFrom = str;
        VideoPasterResponseData qt = this.Yb.qt();
        if (qt != null) {
            com.baidu.afd.videopaster.data.a pasterData = qt.getPasterData();
            if (pasterData == null) {
                this.Yb.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Ye.e(qc());
                this.Yb.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Yb.reset();
                return false;
            } else {
                this.rootView.removeView(this.Ya);
                this.rootView.addView(this.Ya);
                this.rootView.removeView(this.XZ);
                this.rootView.addView(this.XZ);
                if (this.rootView instanceof FrameLayout) {
                    this.XZ.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.XZ.setLayoutParams(layoutParams);
                }
                this.XZ.setData(pasterData);
                this.mStartPosition = this.XZ.getCurDuration();
                if (!pV()) {
                    this.Ye.e(qc());
                    com.baidu.tieba.lego.card.b.c.b(this.Yf);
                }
                this.XZ.b(z, z2, str);
                if (this.Yc != null) {
                    this.Yc.qm();
                }
                return true;
            }
        }
        return false;
    }

    public boolean pU() {
        return this.Yg;
    }

    public boolean pV() {
        return this.XZ.pV();
    }

    public boolean pW() {
        return this.XZ.pW();
    }

    public void reset() {
        pZ();
        this.Yg = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX() {
        pZ();
        if (this.Yc != null) {
            this.Yc.ql();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY() {
        this.Ye.h(qc());
        pZ();
    }

    private void pZ() {
        this.Yb.reset();
        this.XZ.reset();
        this.rootView.removeView(this.XZ);
        this.rootView.removeView(this.Ya);
    }

    public void resume() {
        this.XZ.resume();
        if (pW()) {
            this.mStartPosition = this.XZ.getCurDuration();
            this.Yh = this.mStartPosition;
            this.Ye.g(qc());
        }
    }

    public void qa() {
        if (this.XZ != null) {
            this.XZ.qa();
        }
    }

    public void stop() {
        this.mPausePosition = this.XZ.getCurDuration();
        if (pW() && !qb()) {
            this.Ye.f(qc());
        }
        this.XZ.stop();
    }

    private boolean qb() {
        if (this.XZ != null) {
            int[] iArr = new int[2];
            this.XZ.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Yc = aVar;
    }

    public com.baidu.afd.videopaster.b.a qc() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.YK = this.Yh;
        aVar.YL = this.mPausePosition;
        aVar.YI = this.XZ.getTotalDuration();
        aVar.YJ = this.XZ.getCurDuration();
        aVar.YH = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.YM = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.YM = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.YM = 2;
        } else {
            aVar.YM = -1;
        }
        if (this.Yf != null) {
            aVar.YN = this.Yf.qo();
            aVar.tplName = this.Yf.tplName;
            aVar.extraParam = this.Yf.extra;
            aVar.Yu = this.Yf.Yu;
            aVar.Yv = this.Yf.Yv;
        }
        return aVar;
    }

    public void aQ(int i) {
        if (this.XZ != null) {
            this.XZ.aQ(i);
        }
    }

    public void onDestroy() {
        this.Yb.onDestroy();
    }

    public void qd() {
        if (this.XZ != null) {
            this.XZ.qd();
        }
    }

    public void qe() {
        if (this.XZ != null) {
            this.XZ.qe();
        }
    }

    public boolean qf() {
        return this.XZ != null && this.XZ.qf();
    }

    public void aA(boolean z) {
        this.Yj = z;
    }
}
