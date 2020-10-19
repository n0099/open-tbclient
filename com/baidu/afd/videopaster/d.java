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
/* loaded from: classes21.dex */
public class d {
    private VideoPasterContentView Zg;
    private View Zh;
    private a Zj;
    private com.baidu.afd.videopaster.data.a Zl;
    private int Zn;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean Zm = false;
    private boolean Zo = false;
    private boolean Zp = false;
    private com.baidu.afd.videopaster.b.b Zk = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Zi = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes21.dex */
    public interface a {
        void rP();

        void rQ();

        void rR();

        boolean rS();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.Zi.a(new a.InterfaceC0033a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0033a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Zl = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0033a
            public void d(int i, String str) {
                d.this.Zl = null;
            }
        });
        this.Zg = new VideoPasterContentView(context);
        this.Zg.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rL() {
                d.this.Zk.k(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.Zl);
                if (d.this.Zl != null && s.aW(d.this.mContext, d.this.Zl.Zt) == 1) {
                    d.this.Zk.c(d.this.rH(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rM() {
                d.this.Zk.j(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.Zl);
                if (d.this.Zl != null && s.aW(d.this.mContext, d.this.Zl.Zt) == 1) {
                    d.this.Zk.c(d.this.rH(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rN() {
                d.this.Zk.l(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.Zl);
                if (d.this.Zl != null && s.aW(d.this.mContext, d.this.Zl.Zt) == 1) {
                    d.this.Zk.c(d.this.rH(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rO() {
                d.this.Zo = true;
                d.this.rC();
                d.this.Zk.f(d.this.rH());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rP() {
                d.this.Zk.m(d.this.rH());
                if (d.this.Zj != null) {
                    d.this.Zj.rP();
                }
            }
        });
        this.Zg.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rQ() {
                d.this.rD();
                if (d.this.Zj != null) {
                    d.this.Zj.rQ();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Zg.ik()) {
                    i = 0;
                } else if (d.this.Zo) {
                    d.this.Zo = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Zj != null) {
                    if (i == 0 || i == 1) {
                        d.this.aY(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Zj.rS()) {
                        if (d.this.Zp) {
                            d.this.Zp = false;
                        } else if (!z) {
                            d.this.aY(i);
                        }
                    }
                }
            }
        });
        this.Zh = new View(this.mContext);
        this.Zh.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i) {
        this.Zk.b(rH(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Zk.f(rH());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Zi != null && !this.Zi.isLoading() && this.Zi.rY() == null && aVar != null) {
            this.mFloor = aVar.rn() + 1;
            this.Zi.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Zz) {
            this.Zk.i(rH());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Zi.isLoading()) {
            return false;
        }
        this.Zm = z2;
        this.mFrom = str;
        VideoPasterResponseData rY = this.Zi.rY();
        if (rY != null) {
            com.baidu.afd.videopaster.data.a pasterData = rY.getPasterData();
            if (pasterData == null) {
                this.Zi.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Zk.e(rH());
                this.Zi.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Zi.reset();
                return false;
            } else {
                this.rootView.removeView(this.Zh);
                this.rootView.addView(this.Zh);
                this.rootView.removeView(this.Zg);
                this.rootView.addView(this.Zg);
                if (this.rootView instanceof FrameLayout) {
                    this.Zg.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Zg.setLayoutParams(layoutParams);
                }
                this.Zg.setData(pasterData);
                this.mStartPosition = this.Zg.getCurDuration();
                if (!rA()) {
                    this.Zk.e(rH());
                    com.baidu.tieba.lego.card.b.c.b(this.Zl);
                }
                this.Zg.b(z, z2, str);
                if (this.Zj != null) {
                    this.Zj.rR();
                }
                return true;
            }
        }
        return false;
    }

    public boolean rz() {
        return this.Zm;
    }

    public boolean rA() {
        return this.Zg.rA();
    }

    public boolean rB() {
        return this.Zg.rB();
    }

    public void reset() {
        rE();
        this.Zm = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC() {
        rE();
        if (this.Zj != null) {
            this.Zj.rQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rD() {
        this.Zk.h(rH());
        rE();
    }

    private void rE() {
        this.Zi.reset();
        this.Zg.reset();
        this.rootView.removeView(this.Zg);
        this.rootView.removeView(this.Zh);
    }

    public void resume() {
        this.Zg.resume();
        if (rB()) {
            this.mStartPosition = this.Zg.getCurDuration();
            this.Zn = this.mStartPosition;
            this.Zk.g(rH());
        }
    }

    public void rF() {
        if (this.Zg != null) {
            this.Zg.rF();
        }
    }

    public void stop() {
        this.mPausePosition = this.Zg.getCurDuration();
        if (rB() && !rG()) {
            this.Zk.f(rH());
        }
        this.Zg.stop();
    }

    private boolean rG() {
        if (this.Zg != null) {
            int[] iArr = new int[2];
            this.Zg.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Zj = aVar;
    }

    public com.baidu.afd.videopaster.b.a rH() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.ZQ = this.Zn;
        aVar.ZR = this.mPausePosition;
        aVar.ZO = this.Zg.getTotalDuration();
        aVar.ZP = this.Zg.getCurDuration();
        aVar.ZN = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.ZS = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.ZS = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.ZS = 2;
        } else {
            aVar.ZS = -1;
        }
        if (this.Zl != null) {
            aVar.ZT = this.Zl.rT();
            aVar.tplName = this.Zl.tplName;
            aVar.extraParam = this.Zl.extra;
            aVar.ZA = this.Zl.ZA;
            aVar.ZB = this.Zl.ZB;
        }
        return aVar;
    }

    public void aZ(int i) {
        if (this.Zg != null) {
            this.Zg.aZ(i);
        }
    }

    public void onDestroy() {
        this.Zi.onDestroy();
    }

    public void rI() {
        if (this.Zg != null) {
            this.Zg.rI();
        }
    }

    public void rJ() {
        if (this.Zg != null) {
            this.Zg.rJ();
        }
    }

    public boolean rK() {
        return this.Zg != null && this.Zg.rK();
    }

    public void aB(boolean z) {
        this.Zp = z;
    }
}
