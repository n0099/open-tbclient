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
/* loaded from: classes20.dex */
public class d {
    private VideoPasterContentView YP;
    private View YQ;
    private a YS;
    private com.baidu.afd.videopaster.data.a YU;
    private int YW;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean YV = false;
    private boolean YX = false;
    private boolean YY = false;
    private com.baidu.afd.videopaster.b.b YT = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a YR = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes20.dex */
    public interface a {
        void rP();

        void rQ();

        void rR();

        boolean rS();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.YR.a(new a.InterfaceC0032a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0032a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.YU = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0032a
            public void d(int i, String str) {
                d.this.YU = null;
            }
        });
        this.YP = new VideoPasterContentView(context);
        this.YP.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rL() {
                d.this.YT.k(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.YU);
                if (d.this.YU != null && s.aU(d.this.mContext, d.this.YU.Zc) == 1) {
                    d.this.YT.c(d.this.rH(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rM() {
                d.this.YT.j(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.YU);
                if (d.this.YU != null && s.aU(d.this.mContext, d.this.YU.Zc) == 1) {
                    d.this.YT.c(d.this.rH(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rN() {
                d.this.YT.l(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.YU);
                if (d.this.YU != null && s.aU(d.this.mContext, d.this.YU.Zc) == 1) {
                    d.this.YT.c(d.this.rH(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rO() {
                d.this.YX = true;
                d.this.rC();
                d.this.YT.f(d.this.rH());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rP() {
                d.this.YT.m(d.this.rH());
                if (d.this.YS != null) {
                    d.this.YS.rP();
                }
            }
        });
        this.YP.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rQ() {
                d.this.rD();
                if (d.this.YS != null) {
                    d.this.YS.rQ();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.YP.ij()) {
                    i = 0;
                } else if (d.this.YX) {
                    d.this.YX = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.YS != null) {
                    if (i == 0 || i == 1) {
                        d.this.aY(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.YS.rS()) {
                        if (d.this.YY) {
                            d.this.YY = false;
                        } else if (!z) {
                            d.this.aY(i);
                        }
                    }
                }
            }
        });
        this.YQ = new View(this.mContext);
        this.YQ.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i) {
        this.YT.b(rH(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.YT.f(rH());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.YR != null && !this.YR.isLoading() && this.YR.rY() == null && aVar != null) {
            this.mFloor = aVar.rn() + 1;
            this.YR.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Zj) {
            this.YT.i(rH());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.YR.isLoading()) {
            return false;
        }
        this.YV = z2;
        this.mFrom = str;
        VideoPasterResponseData rY = this.YR.rY();
        if (rY != null) {
            com.baidu.afd.videopaster.data.a pasterData = rY.getPasterData();
            if (pasterData == null) {
                this.YR.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.YT.e(rH());
                this.YR.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.YR.reset();
                return false;
            } else {
                this.rootView.removeView(this.YQ);
                this.rootView.addView(this.YQ);
                this.rootView.removeView(this.YP);
                this.rootView.addView(this.YP);
                if (this.rootView instanceof FrameLayout) {
                    this.YP.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.YP.setLayoutParams(layoutParams);
                }
                this.YP.setData(pasterData);
                this.mStartPosition = this.YP.getCurDuration();
                if (!rA()) {
                    this.YT.e(rH());
                    com.baidu.tieba.lego.card.b.c.b(this.YU);
                }
                this.YP.b(z, z2, str);
                if (this.YS != null) {
                    this.YS.rR();
                }
                return true;
            }
        }
        return false;
    }

    public boolean rz() {
        return this.YV;
    }

    public boolean rA() {
        return this.YP.rA();
    }

    public boolean rB() {
        return this.YP.rB();
    }

    public void reset() {
        rE();
        this.YV = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC() {
        rE();
        if (this.YS != null) {
            this.YS.rQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rD() {
        this.YT.h(rH());
        rE();
    }

    private void rE() {
        this.YR.reset();
        this.YP.reset();
        this.rootView.removeView(this.YP);
        this.rootView.removeView(this.YQ);
    }

    public void resume() {
        this.YP.resume();
        if (rB()) {
            this.mStartPosition = this.YP.getCurDuration();
            this.YW = this.mStartPosition;
            this.YT.g(rH());
        }
    }

    public void rF() {
        if (this.YP != null) {
            this.YP.rF();
        }
    }

    public void stop() {
        this.mPausePosition = this.YP.getCurDuration();
        if (rB() && !rG()) {
            this.YT.f(rH());
        }
        this.YP.stop();
    }

    private boolean rG() {
        if (this.YP != null) {
            int[] iArr = new int[2];
            this.YP.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.YS = aVar;
    }

    public com.baidu.afd.videopaster.b.a rH() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.ZA = this.YW;
        aVar.ZB = this.mPausePosition;
        aVar.Zy = this.YP.getTotalDuration();
        aVar.Zz = this.YP.getCurDuration();
        aVar.Zx = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.ZC = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.ZC = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.ZC = 2;
        } else {
            aVar.ZC = -1;
        }
        if (this.YU != null) {
            aVar.ZD = this.YU.rT();
            aVar.tplName = this.YU.tplName;
            aVar.extraParam = this.YU.extra;
            aVar.Zk = this.YU.Zk;
            aVar.Zl = this.YU.Zl;
        }
        return aVar;
    }

    public void aZ(int i) {
        if (this.YP != null) {
            this.YP.aZ(i);
        }
    }

    public void onDestroy() {
        this.YR.onDestroy();
    }

    public void rI() {
        if (this.YP != null) {
            this.YP.rI();
        }
    }

    public void rJ() {
        if (this.YP != null) {
            this.YP.rJ();
        }
    }

    public boolean rK() {
        return this.YP != null && this.YP.rK();
    }

    public void aB(boolean z) {
        this.YY = z;
    }
}
