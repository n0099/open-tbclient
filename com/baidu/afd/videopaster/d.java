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
    private VideoPasterContentView Zh;
    private View Zi;
    private a Zk;
    private com.baidu.afd.videopaster.data.a Zm;
    private int Zo;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean Zn = false;
    private boolean Zp = false;
    private boolean Zq = false;
    private com.baidu.afd.videopaster.b.b Zl = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Zj = new com.baidu.afd.videopaster.a.a();

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
        this.Zj.a(new a.InterfaceC0033a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0033a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Zm = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0033a
            public void d(int i, String str) {
                d.this.Zm = null;
            }
        });
        this.Zh = new VideoPasterContentView(context);
        this.Zh.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rL() {
                d.this.Zl.k(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.Zm);
                if (d.this.Zm != null && s.aY(d.this.mContext, d.this.Zm.Zu) == 1) {
                    d.this.Zl.c(d.this.rH(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rM() {
                d.this.Zl.j(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.Zm);
                if (d.this.Zm != null && s.aY(d.this.mContext, d.this.Zm.Zu) == 1) {
                    d.this.Zl.c(d.this.rH(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rN() {
                d.this.Zl.l(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.Zm);
                if (d.this.Zm != null && s.aY(d.this.mContext, d.this.Zm.Zu) == 1) {
                    d.this.Zl.c(d.this.rH(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rO() {
                d.this.Zp = true;
                d.this.rC();
                d.this.Zl.f(d.this.rH());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rP() {
                d.this.Zl.m(d.this.rH());
                if (d.this.Zk != null) {
                    d.this.Zk.rP();
                }
            }
        });
        this.Zh.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rQ() {
                d.this.rD();
                if (d.this.Zk != null) {
                    d.this.Zk.rQ();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Zh.ik()) {
                    i = 0;
                } else if (d.this.Zp) {
                    d.this.Zp = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Zk != null) {
                    if (i == 0 || i == 1) {
                        d.this.aY(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Zk.rS()) {
                        if (d.this.Zq) {
                            d.this.Zq = false;
                        } else if (!z) {
                            d.this.aY(i);
                        }
                    }
                }
            }
        });
        this.Zi = new View(this.mContext);
        this.Zi.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i) {
        this.Zl.b(rH(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Zl.f(rH());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Zj != null && !this.Zj.isLoading() && this.Zj.rY() == null && aVar != null) {
            this.mFloor = aVar.rn() + 1;
            this.Zj.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.ZA) {
            this.Zl.i(rH());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Zj.isLoading()) {
            return false;
        }
        this.Zn = z2;
        this.mFrom = str;
        VideoPasterResponseData rY = this.Zj.rY();
        if (rY != null) {
            com.baidu.afd.videopaster.data.a pasterData = rY.getPasterData();
            if (pasterData == null) {
                this.Zj.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Zl.e(rH());
                this.Zj.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Zj.reset();
                return false;
            } else {
                this.rootView.removeView(this.Zi);
                this.rootView.addView(this.Zi);
                this.rootView.removeView(this.Zh);
                this.rootView.addView(this.Zh);
                if (this.rootView instanceof FrameLayout) {
                    this.Zh.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Zh.setLayoutParams(layoutParams);
                }
                this.Zh.setData(pasterData);
                this.mStartPosition = this.Zh.getCurDuration();
                if (!rA()) {
                    this.Zl.e(rH());
                    com.baidu.tieba.lego.card.b.c.b(this.Zm);
                }
                this.Zh.b(z, z2, str);
                if (this.Zk != null) {
                    this.Zk.rR();
                }
                return true;
            }
        }
        return false;
    }

    public boolean rz() {
        return this.Zn;
    }

    public boolean rA() {
        return this.Zh.rA();
    }

    public boolean rB() {
        return this.Zh.rB();
    }

    public void reset() {
        rE();
        this.Zn = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC() {
        rE();
        if (this.Zk != null) {
            this.Zk.rQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rD() {
        this.Zl.h(rH());
        rE();
    }

    private void rE() {
        this.Zj.reset();
        this.Zh.reset();
        this.rootView.removeView(this.Zh);
        this.rootView.removeView(this.Zi);
    }

    public void resume() {
        this.Zh.resume();
        if (rB()) {
            this.mStartPosition = this.Zh.getCurDuration();
            this.Zo = this.mStartPosition;
            this.Zl.g(rH());
        }
    }

    public void rF() {
        if (this.Zh != null) {
            this.Zh.rF();
        }
    }

    public void stop() {
        this.mPausePosition = this.Zh.getCurDuration();
        if (rB() && !rG()) {
            this.Zl.f(rH());
        }
        this.Zh.stop();
    }

    private boolean rG() {
        if (this.Zh != null) {
            int[] iArr = new int[2];
            this.Zh.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Zk = aVar;
    }

    public com.baidu.afd.videopaster.b.a rH() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.ZR = this.Zo;
        aVar.ZS = this.mPausePosition;
        aVar.ZP = this.Zh.getTotalDuration();
        aVar.ZQ = this.Zh.getCurDuration();
        aVar.ZO = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.ZT = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.ZT = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.ZT = 2;
        } else {
            aVar.ZT = -1;
        }
        if (this.Zm != null) {
            aVar.ZU = this.Zm.rT();
            aVar.tplName = this.Zm.tplName;
            aVar.extraParam = this.Zm.extra;
            aVar.ZB = this.Zm.ZB;
            aVar.ZC = this.Zm.ZC;
        }
        return aVar;
    }

    public void aZ(int i) {
        if (this.Zh != null) {
            this.Zh.aZ(i);
        }
    }

    public void onDestroy() {
        this.Zj.onDestroy();
    }

    public void rI() {
        if (this.Zh != null) {
            this.Zh.rI();
        }
    }

    public void rJ() {
        if (this.Zh != null) {
            this.Zh.rJ();
        }
    }

    public boolean rK() {
        return this.Zh != null && this.Zh.rK();
    }

    public void aB(boolean z) {
        this.Zq = z;
    }
}
