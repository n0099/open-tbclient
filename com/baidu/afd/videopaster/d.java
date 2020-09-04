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
    private a YA;
    private com.baidu.afd.videopaster.data.a YC;
    private int YE;
    private VideoPasterContentView Yx;
    private View Yy;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean YD = false;
    private boolean YF = false;
    private boolean YG = false;
    private com.baidu.afd.videopaster.b.b YB = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Yz = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes15.dex */
    public interface a {
        void rK();

        void rL();

        void rM();

        boolean rN();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.Yz.a(new a.InterfaceC0031a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0031a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.YC = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0031a
            public void d(int i, String str) {
                d.this.YC = null;
            }
        });
        this.Yx = new VideoPasterContentView(context);
        this.Yx.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rG() {
                d.this.YB.k(d.this.rC());
                com.baidu.tieba.lego.card.b.c.a(d.this.YC);
                if (d.this.YC != null && s.aR(d.this.mContext, d.this.YC.YK) == 1) {
                    d.this.YB.c(d.this.rC(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rH() {
                d.this.YB.j(d.this.rC());
                com.baidu.tieba.lego.card.b.c.a(d.this.YC);
                if (d.this.YC != null && s.aR(d.this.mContext, d.this.YC.YK) == 1) {
                    d.this.YB.c(d.this.rC(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rI() {
                d.this.YB.l(d.this.rC());
                com.baidu.tieba.lego.card.b.c.a(d.this.YC);
                if (d.this.YC != null && s.aR(d.this.mContext, d.this.YC.YK) == 1) {
                    d.this.YB.c(d.this.rC(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rJ() {
                d.this.YF = true;
                d.this.rx();
                d.this.YB.f(d.this.rC());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rK() {
                d.this.YB.m(d.this.rC());
                if (d.this.YA != null) {
                    d.this.YA.rK();
                }
            }
        });
        this.Yx.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rL() {
                d.this.ry();
                if (d.this.YA != null) {
                    d.this.YA.rL();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Yx.ij()) {
                    i = 0;
                } else if (d.this.YF) {
                    d.this.YF = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.YA != null) {
                    if (i == 0 || i == 1) {
                        d.this.aU(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.YA.rN()) {
                        if (d.this.YG) {
                            d.this.YG = false;
                        } else if (!z) {
                            d.this.aU(i);
                        }
                    }
                }
            }
        });
        this.Yy = new View(this.mContext);
        this.Yy.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i) {
        this.YB.b(rC(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.YB.f(rC());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Yz != null && !this.Yz.isLoading() && this.Yz.rT() == null && aVar != null) {
            this.mFloor = aVar.ri() + 1;
            this.Yz.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.YQ) {
            this.YB.i(rC());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Yz.isLoading()) {
            return false;
        }
        this.YD = z2;
        this.mFrom = str;
        VideoPasterResponseData rT = this.Yz.rT();
        if (rT != null) {
            com.baidu.afd.videopaster.data.a pasterData = rT.getPasterData();
            if (pasterData == null) {
                this.Yz.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.YB.e(rC());
                this.Yz.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Yz.reset();
                return false;
            } else {
                this.rootView.removeView(this.Yy);
                this.rootView.addView(this.Yy);
                this.rootView.removeView(this.Yx);
                this.rootView.addView(this.Yx);
                if (this.rootView instanceof FrameLayout) {
                    this.Yx.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Yx.setLayoutParams(layoutParams);
                }
                this.Yx.setData(pasterData);
                this.mStartPosition = this.Yx.getCurDuration();
                if (!rv()) {
                    this.YB.e(rC());
                    com.baidu.tieba.lego.card.b.c.b(this.YC);
                }
                this.Yx.b(z, z2, str);
                if (this.YA != null) {
                    this.YA.rM();
                }
                return true;
            }
        }
        return false;
    }

    public boolean ru() {
        return this.YD;
    }

    public boolean rv() {
        return this.Yx.rv();
    }

    public boolean rw() {
        return this.Yx.rw();
    }

    public void reset() {
        rz();
        this.YD = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx() {
        rz();
        if (this.YA != null) {
            this.YA.rL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry() {
        this.YB.h(rC());
        rz();
    }

    private void rz() {
        this.Yz.reset();
        this.Yx.reset();
        this.rootView.removeView(this.Yx);
        this.rootView.removeView(this.Yy);
    }

    public void resume() {
        this.Yx.resume();
        if (rw()) {
            this.mStartPosition = this.Yx.getCurDuration();
            this.YE = this.mStartPosition;
            this.YB.g(rC());
        }
    }

    public void rA() {
        if (this.Yx != null) {
            this.Yx.rA();
        }
    }

    public void stop() {
        this.mPausePosition = this.Yx.getCurDuration();
        if (rw() && !rB()) {
            this.YB.f(rC());
        }
        this.Yx.stop();
    }

    private boolean rB() {
        if (this.Yx != null) {
            int[] iArr = new int[2];
            this.Yx.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.YA = aVar;
    }

    public com.baidu.afd.videopaster.b.a rC() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.Zi = this.YE;
        aVar.Zj = this.mPausePosition;
        aVar.Zg = this.Yx.getTotalDuration();
        aVar.Zh = this.Yx.getCurDuration();
        aVar.Zf = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Zk = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Zk = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Zk = 2;
        } else {
            aVar.Zk = -1;
        }
        if (this.YC != null) {
            aVar.Zl = this.YC.rO();
            aVar.tplName = this.YC.tplName;
            aVar.extraParam = this.YC.extra;
            aVar.YR = this.YC.YR;
            aVar.YS = this.YC.YS;
        }
        return aVar;
    }

    public void aV(int i) {
        if (this.Yx != null) {
            this.Yx.aV(i);
        }
    }

    public void onDestroy() {
        this.Yz.onDestroy();
    }

    public void rD() {
        if (this.Yx != null) {
            this.Yx.rD();
        }
    }

    public void rE() {
        if (this.Yx != null) {
            this.Yx.rE();
        }
    }

    public boolean rF() {
        return this.Yx != null && this.Yx.rF();
    }

    public void aB(boolean z) {
        this.YG = z;
    }
}
