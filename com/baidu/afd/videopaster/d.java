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
    private com.baidu.afd.videopaster.data.a YA;
    private int YC;
    private VideoPasterContentView Yv;
    private View Yw;
    private a Yy;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean YB = false;
    private boolean YD = false;
    private boolean YE = false;
    private com.baidu.afd.videopaster.b.b Yz = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Yx = new com.baidu.afd.videopaster.a.a();

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
        this.Yx.a(new a.InterfaceC0031a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0031a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.YA = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0031a
            public void d(int i, String str) {
                d.this.YA = null;
            }
        });
        this.Yv = new VideoPasterContentView(context);
        this.Yv.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rG() {
                d.this.Yz.k(d.this.rC());
                com.baidu.tieba.lego.card.b.c.a(d.this.YA);
                if (d.this.YA != null && s.aR(d.this.mContext, d.this.YA.YI) == 1) {
                    d.this.Yz.c(d.this.rC(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rH() {
                d.this.Yz.j(d.this.rC());
                com.baidu.tieba.lego.card.b.c.a(d.this.YA);
                if (d.this.YA != null && s.aR(d.this.mContext, d.this.YA.YI) == 1) {
                    d.this.Yz.c(d.this.rC(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rI() {
                d.this.Yz.l(d.this.rC());
                com.baidu.tieba.lego.card.b.c.a(d.this.YA);
                if (d.this.YA != null && s.aR(d.this.mContext, d.this.YA.YI) == 1) {
                    d.this.Yz.c(d.this.rC(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rJ() {
                d.this.YD = true;
                d.this.rx();
                d.this.Yz.f(d.this.rC());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rK() {
                d.this.Yz.m(d.this.rC());
                if (d.this.Yy != null) {
                    d.this.Yy.rK();
                }
            }
        });
        this.Yv.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rL() {
                d.this.ry();
                if (d.this.Yy != null) {
                    d.this.Yy.rL();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Yv.ij()) {
                    i = 0;
                } else if (d.this.YD) {
                    d.this.YD = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Yy != null) {
                    if (i == 0 || i == 1) {
                        d.this.aU(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Yy.rN()) {
                        if (d.this.YE) {
                            d.this.YE = false;
                        } else if (!z) {
                            d.this.aU(i);
                        }
                    }
                }
            }
        });
        this.Yw = new View(this.mContext);
        this.Yw.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i) {
        this.Yz.b(rC(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Yz.f(rC());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Yx != null && !this.Yx.isLoading() && this.Yx.rT() == null && aVar != null) {
            this.mFloor = aVar.ri() + 1;
            this.Yx.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.YO) {
            this.Yz.i(rC());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Yx.isLoading()) {
            return false;
        }
        this.YB = z2;
        this.mFrom = str;
        VideoPasterResponseData rT = this.Yx.rT();
        if (rT != null) {
            com.baidu.afd.videopaster.data.a pasterData = rT.getPasterData();
            if (pasterData == null) {
                this.Yx.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Yz.e(rC());
                this.Yx.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Yx.reset();
                return false;
            } else {
                this.rootView.removeView(this.Yw);
                this.rootView.addView(this.Yw);
                this.rootView.removeView(this.Yv);
                this.rootView.addView(this.Yv);
                if (this.rootView instanceof FrameLayout) {
                    this.Yv.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Yv.setLayoutParams(layoutParams);
                }
                this.Yv.setData(pasterData);
                this.mStartPosition = this.Yv.getCurDuration();
                if (!rv()) {
                    this.Yz.e(rC());
                    com.baidu.tieba.lego.card.b.c.b(this.YA);
                }
                this.Yv.b(z, z2, str);
                if (this.Yy != null) {
                    this.Yy.rM();
                }
                return true;
            }
        }
        return false;
    }

    public boolean ru() {
        return this.YB;
    }

    public boolean rv() {
        return this.Yv.rv();
    }

    public boolean rw() {
        return this.Yv.rw();
    }

    public void reset() {
        rz();
        this.YB = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx() {
        rz();
        if (this.Yy != null) {
            this.Yy.rL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry() {
        this.Yz.h(rC());
        rz();
    }

    private void rz() {
        this.Yx.reset();
        this.Yv.reset();
        this.rootView.removeView(this.Yv);
        this.rootView.removeView(this.Yw);
    }

    public void resume() {
        this.Yv.resume();
        if (rw()) {
            this.mStartPosition = this.Yv.getCurDuration();
            this.YC = this.mStartPosition;
            this.Yz.g(rC());
        }
    }

    public void rA() {
        if (this.Yv != null) {
            this.Yv.rA();
        }
    }

    public void stop() {
        this.mPausePosition = this.Yv.getCurDuration();
        if (rw() && !rB()) {
            this.Yz.f(rC());
        }
        this.Yv.stop();
    }

    private boolean rB() {
        if (this.Yv != null) {
            int[] iArr = new int[2];
            this.Yv.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Yy = aVar;
    }

    public com.baidu.afd.videopaster.b.a rC() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.Zg = this.YC;
        aVar.Zh = this.mPausePosition;
        aVar.Ze = this.Yv.getTotalDuration();
        aVar.Zf = this.Yv.getCurDuration();
        aVar.Zc = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Zi = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Zi = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Zi = 2;
        } else {
            aVar.Zi = -1;
        }
        if (this.YA != null) {
            aVar.Zj = this.YA.rO();
            aVar.tplName = this.YA.tplName;
            aVar.extraParam = this.YA.extra;
            aVar.YP = this.YA.YP;
            aVar.YQ = this.YA.YQ;
        }
        return aVar;
    }

    public void aV(int i) {
        if (this.Yv != null) {
            this.Yv.aV(i);
        }
    }

    public void onDestroy() {
        this.Yx.onDestroy();
    }

    public void rD() {
        if (this.Yv != null) {
            this.Yv.rD();
        }
    }

    public void rE() {
        if (this.Yv != null) {
            this.Yv.rE();
        }
    }

    public boolean rF() {
        return this.Yv != null && this.Yv.rF();
    }

    public void aB(boolean z) {
        this.YE = z;
    }
}
