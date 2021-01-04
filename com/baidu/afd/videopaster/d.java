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
/* loaded from: classes.dex */
public class d {
    private VideoPasterContentView aaR;
    private View aaS;
    private a aaU;
    private com.baidu.afd.videopaster.data.a aaW;
    private int aaY;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean aaX = false;
    private boolean aaZ = false;
    private boolean aba = false;
    private com.baidu.afd.videopaster.b.b aaV = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a aaT = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes.dex */
    public interface a {
        void rs();

        void rt();

        void ru();

        boolean rv();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.aaT.a(new a.InterfaceC0027a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0027a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.aaW = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0027a
            public void d(int i, String str) {
                d.this.aaW = null;
            }
        });
        this.aaR = new VideoPasterContentView(context);
        this.aaR.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void ro() {
                d.this.aaV.k(d.this.rk());
                com.baidu.tieba.lego.card.a.c.a(d.this.aaW);
                if (d.this.aaW != null && s.x(d.this.mContext, d.this.aaW.abf, d.this.aaW.adid) == 1) {
                    d.this.aaV.c(d.this.rk(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rp() {
                d.this.aaV.j(d.this.rk());
                com.baidu.tieba.lego.card.a.c.a(d.this.aaW);
                if (d.this.aaW != null && s.x(d.this.mContext, d.this.aaW.abf, d.this.aaW.adid) == 1) {
                    d.this.aaV.c(d.this.rk(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rq() {
                d.this.aaV.l(d.this.rk());
                com.baidu.tieba.lego.card.a.c.a(d.this.aaW);
                if (d.this.aaW != null && s.x(d.this.mContext, d.this.aaW.abf, d.this.aaW.adid) == 1) {
                    d.this.aaV.c(d.this.rk(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rr() {
                d.this.aaZ = true;
                d.this.onAdClose();
                d.this.aaV.f(d.this.rk());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rs() {
                d.this.aaV.m(d.this.rk());
                if (d.this.aaU != null) {
                    d.this.aaU.rs();
                }
            }
        });
        this.aaR.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rt() {
                d.this.rg();
                if (d.this.aaU != null) {
                    d.this.aaU.rt();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.aaR.isCompleted()) {
                    i = 0;
                } else if (d.this.aaZ) {
                    d.this.aaZ = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.aaU != null) {
                    if (i == 0 || i == 1) {
                        d.this.bd(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.aaU.rv()) {
                        if (d.this.aba) {
                            d.this.aba = false;
                        } else if (!z) {
                            d.this.bd(i);
                        }
                    }
                }
            }
        });
        this.aaS = new View(this.mContext);
        this.aaS.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(int i) {
        this.aaV.b(rk(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.aaV.f(rk());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.aaT != null && !this.aaT.isLoading() && this.aaT.rB() == null && aVar != null) {
            this.mFloor = aVar.qR() + 1;
            this.aaT.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.abl) {
            this.aaV.i(rk());
        }
    }

    public boolean d(boolean z, boolean z2, String str) {
        if (this.aaT.isLoading()) {
            return false;
        }
        this.aaX = z2;
        this.mFrom = str;
        VideoPasterResponseData rB = this.aaT.rB();
        if (rB != null) {
            com.baidu.afd.videopaster.data.a pasterData = rB.getPasterData();
            if (pasterData == null) {
                this.aaT.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.aaV.e(rk());
                this.aaT.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.aaT.reset();
                return false;
            } else {
                this.rootView.removeView(this.aaS);
                this.rootView.addView(this.aaS);
                this.rootView.removeView(this.aaR);
                this.rootView.addView(this.aaR);
                if (this.rootView instanceof FrameLayout) {
                    this.aaR.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.aaR.setLayoutParams(layoutParams);
                }
                this.aaR.setData(pasterData);
                this.mStartPosition = this.aaR.getCurDuration();
                if (!re()) {
                    this.aaV.e(rk());
                    com.baidu.tieba.lego.card.a.c.b(this.aaW);
                }
                this.aaR.e(z, z2, str);
                if (this.aaU != null) {
                    this.aaU.ru();
                }
                return true;
            }
        }
        return false;
    }

    public boolean rd() {
        return this.aaX;
    }

    public boolean re() {
        return this.aaR.re();
    }

    public boolean rf() {
        return this.aaR.rf();
    }

    public void reset() {
        rh();
        this.aaX = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClose() {
        rh();
        if (this.aaU != null) {
            this.aaU.rt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg() {
        this.aaV.h(rk());
        rh();
    }

    private void rh() {
        this.aaT.reset();
        this.aaR.reset();
        this.rootView.removeView(this.aaR);
        this.rootView.removeView(this.aaS);
    }

    public void resume() {
        this.aaR.resume();
        if (rf()) {
            this.mStartPosition = this.aaR.getCurDuration();
            this.aaY = this.mStartPosition;
            this.aaV.g(rk());
        }
    }

    public void ri() {
        if (this.aaR != null) {
            this.aaR.ri();
        }
    }

    public void stop() {
        this.mPausePosition = this.aaR.getCurDuration();
        if (rf() && !rj()) {
            this.aaV.f(rk());
        }
        this.aaR.stop();
    }

    private boolean rj() {
        if (this.aaR != null) {
            int[] iArr = new int[2];
            this.aaR.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.aaU = aVar;
    }

    public com.baidu.afd.videopaster.b.a rk() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.abD = this.aaY;
        aVar.abE = this.mPausePosition;
        aVar.abB = this.aaR.getTotalDuration();
        aVar.abC = this.aaR.getCurDuration();
        aVar.abA = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.abF = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.abF = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.abF = 2;
        } else {
            aVar.abF = -1;
        }
        if (this.aaW != null) {
            aVar.abG = this.aaW.rw();
            aVar.tplName = this.aaW.tplName;
            aVar.extraParam = this.aaW.extra;
            aVar.abm = this.aaW.abm;
            aVar.abn = this.aaW.abn;
        }
        return aVar;
    }

    public void be(int i) {
        if (this.aaR != null) {
            this.aaR.be(i);
        }
    }

    public void onDestroy() {
        this.aaT.onDestroy();
    }

    public void rl() {
        if (this.aaR != null) {
            this.aaR.rl();
        }
    }

    public void rm() {
        if (this.aaR != null) {
            this.aaR.rm();
        }
    }

    public boolean rn() {
        return this.aaR != null && this.aaR.rn();
    }

    public void az(boolean z) {
        this.aba = z;
    }
}
