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
import com.baidu.tieba.recapp.r;
/* loaded from: classes20.dex */
public class d {
    private VideoPasterContentView Zm;
    private View Zn;
    private a Zp;
    private com.baidu.afd.videopaster.data.a Zr;
    private int Zt;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean Zs = false;
    private boolean Zu = false;
    private boolean Zv = false;
    private com.baidu.afd.videopaster.b.b Zq = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Zo = new com.baidu.afd.videopaster.a.a();

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
        this.Zo.a(new a.InterfaceC0033a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0033a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Zr = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0033a
            public void d(int i, String str) {
                d.this.Zr = null;
            }
        });
        this.Zm = new VideoPasterContentView(context);
        this.Zm.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rL() {
                d.this.Zq.k(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.Zr);
                if (d.this.Zr != null && r.aV(d.this.mContext, d.this.Zr.Zz) == 1) {
                    d.this.Zq.c(d.this.rH(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rM() {
                d.this.Zq.j(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.Zr);
                if (d.this.Zr != null && r.aV(d.this.mContext, d.this.Zr.Zz) == 1) {
                    d.this.Zq.c(d.this.rH(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rN() {
                d.this.Zq.l(d.this.rH());
                com.baidu.tieba.lego.card.b.c.a(d.this.Zr);
                if (d.this.Zr != null && r.aV(d.this.mContext, d.this.Zr.Zz) == 1) {
                    d.this.Zq.c(d.this.rH(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rO() {
                d.this.Zu = true;
                d.this.rC();
                d.this.Zq.f(d.this.rH());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rP() {
                d.this.Zq.m(d.this.rH());
                if (d.this.Zp != null) {
                    d.this.Zp.rP();
                }
            }
        });
        this.Zm.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rQ() {
                d.this.rD();
                if (d.this.Zp != null) {
                    d.this.Zp.rQ();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Zm.ik()) {
                    i = 0;
                } else if (d.this.Zu) {
                    d.this.Zu = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Zp != null) {
                    if (i == 0 || i == 1) {
                        d.this.aY(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Zp.rS()) {
                        if (d.this.Zv) {
                            d.this.Zv = false;
                        } else if (!z) {
                            d.this.aY(i);
                        }
                    }
                }
            }
        });
        this.Zn = new View(this.mContext);
        this.Zn.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i) {
        this.Zq.b(rH(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Zq.f(rH());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Zo != null && !this.Zo.isLoading() && this.Zo.rY() == null && aVar != null) {
            this.mFloor = aVar.rn() + 1;
            this.Zo.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.ZF) {
            this.Zq.i(rH());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Zo.isLoading()) {
            return false;
        }
        this.Zs = z2;
        this.mFrom = str;
        VideoPasterResponseData rY = this.Zo.rY();
        if (rY != null) {
            com.baidu.afd.videopaster.data.a pasterData = rY.getPasterData();
            if (pasterData == null) {
                this.Zo.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Zq.e(rH());
                this.Zo.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Zo.reset();
                return false;
            } else {
                this.rootView.removeView(this.Zn);
                this.rootView.addView(this.Zn);
                this.rootView.removeView(this.Zm);
                this.rootView.addView(this.Zm);
                if (this.rootView instanceof FrameLayout) {
                    this.Zm.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Zm.setLayoutParams(layoutParams);
                }
                this.Zm.setData(pasterData);
                this.mStartPosition = this.Zm.getCurDuration();
                if (!rA()) {
                    this.Zq.e(rH());
                    com.baidu.tieba.lego.card.b.c.b(this.Zr);
                }
                this.Zm.b(z, z2, str);
                if (this.Zp != null) {
                    this.Zp.rR();
                }
                return true;
            }
        }
        return false;
    }

    public boolean rz() {
        return this.Zs;
    }

    public boolean rA() {
        return this.Zm.rA();
    }

    public boolean rB() {
        return this.Zm.rB();
    }

    public void reset() {
        rE();
        this.Zs = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rC() {
        rE();
        if (this.Zp != null) {
            this.Zp.rQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rD() {
        this.Zq.h(rH());
        rE();
    }

    private void rE() {
        this.Zo.reset();
        this.Zm.reset();
        this.rootView.removeView(this.Zm);
        this.rootView.removeView(this.Zn);
    }

    public void resume() {
        this.Zm.resume();
        if (rB()) {
            this.mStartPosition = this.Zm.getCurDuration();
            this.Zt = this.mStartPosition;
            this.Zq.g(rH());
        }
    }

    public void rF() {
        if (this.Zm != null) {
            this.Zm.rF();
        }
    }

    public void stop() {
        this.mPausePosition = this.Zm.getCurDuration();
        if (rB() && !rG()) {
            this.Zq.f(rH());
        }
        this.Zm.stop();
    }

    private boolean rG() {
        if (this.Zm != null) {
            int[] iArr = new int[2];
            this.Zm.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Zp = aVar;
    }

    public com.baidu.afd.videopaster.b.a rH() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.ZW = this.Zt;
        aVar.ZX = this.mPausePosition;
        aVar.ZU = this.Zm.getTotalDuration();
        aVar.ZV = this.Zm.getCurDuration();
        aVar.ZT = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.ZY = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.ZY = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.ZY = 2;
        } else {
            aVar.ZY = -1;
        }
        if (this.Zr != null) {
            aVar.ZZ = this.Zr.rT();
            aVar.tplName = this.Zr.tplName;
            aVar.extraParam = this.Zr.extra;
            aVar.ZG = this.Zr.ZG;
            aVar.ZH = this.Zr.ZH;
        }
        return aVar;
    }

    public void aZ(int i) {
        if (this.Zm != null) {
            this.Zm.aZ(i);
        }
    }

    public void onDestroy() {
        this.Zo.onDestroy();
    }

    public void rI() {
        if (this.Zm != null) {
            this.Zm.rI();
        }
    }

    public void rJ() {
        if (this.Zm != null) {
            this.Zm.rJ();
        }
    }

    public boolean rK() {
        return this.Zm != null && this.Zm.rK();
    }

    public void aB(boolean z) {
        this.Zv = z;
    }
}
