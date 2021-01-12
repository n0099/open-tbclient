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
    private VideoPasterContentView aaP;
    private View aaQ;
    private a aaS;
    private com.baidu.afd.videopaster.data.a aaU;
    private int aaW;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean aaV = false;
    private boolean aaX = false;
    private boolean aaY = false;
    private com.baidu.afd.videopaster.b.b aaT = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a aaR = new com.baidu.afd.videopaster.a.a();

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
        this.aaR.a(new a.InterfaceC0027a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0027a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.aaU = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0027a
            public void e(int i, String str) {
                d.this.aaU = null;
            }
        });
        this.aaP = new VideoPasterContentView(context);
        this.aaP.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void ro() {
                d.this.aaT.k(d.this.rk());
                com.baidu.tieba.lego.card.a.c.a(d.this.aaU);
                if (d.this.aaU != null && s.x(d.this.mContext, d.this.aaU.abd, d.this.aaU.adid) == 1) {
                    d.this.aaT.c(d.this.rk(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rp() {
                d.this.aaT.j(d.this.rk());
                com.baidu.tieba.lego.card.a.c.a(d.this.aaU);
                if (d.this.aaU != null && s.x(d.this.mContext, d.this.aaU.abd, d.this.aaU.adid) == 1) {
                    d.this.aaT.c(d.this.rk(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rq() {
                d.this.aaT.l(d.this.rk());
                com.baidu.tieba.lego.card.a.c.a(d.this.aaU);
                if (d.this.aaU != null && s.x(d.this.mContext, d.this.aaU.abd, d.this.aaU.adid) == 1) {
                    d.this.aaT.c(d.this.rk(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rr() {
                d.this.aaX = true;
                d.this.onAdClose();
                d.this.aaT.f(d.this.rk());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rs() {
                d.this.aaT.m(d.this.rk());
                if (d.this.aaS != null) {
                    d.this.aaS.rs();
                }
            }
        });
        this.aaP.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rt() {
                d.this.rg();
                if (d.this.aaS != null) {
                    d.this.aaS.rt();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.aaP.isCompleted()) {
                    i = 0;
                } else if (d.this.aaX) {
                    d.this.aaX = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.aaS != null) {
                    if (i == 0 || i == 1) {
                        d.this.bd(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.aaS.rv()) {
                        if (d.this.aaY) {
                            d.this.aaY = false;
                        } else if (!z) {
                            d.this.bd(i);
                        }
                    }
                }
            }
        });
        this.aaQ = new View(this.mContext);
        this.aaQ.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(int i) {
        this.aaT.b(rk(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.aaT.f(rk());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.aaR != null && !this.aaR.isLoading() && this.aaR.rB() == null && aVar != null) {
            this.mFloor = aVar.qR() + 1;
            this.aaR.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.abj) {
            this.aaT.i(rk());
        }
    }

    public boolean d(boolean z, boolean z2, String str) {
        if (this.aaR.isLoading()) {
            return false;
        }
        this.aaV = z2;
        this.mFrom = str;
        VideoPasterResponseData rB = this.aaR.rB();
        if (rB != null) {
            com.baidu.afd.videopaster.data.a pasterData = rB.getPasterData();
            if (pasterData == null) {
                this.aaR.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.aaT.e(rk());
                this.aaR.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.aaR.reset();
                return false;
            } else {
                this.rootView.removeView(this.aaQ);
                this.rootView.addView(this.aaQ);
                this.rootView.removeView(this.aaP);
                this.rootView.addView(this.aaP);
                if (this.rootView instanceof FrameLayout) {
                    this.aaP.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.aaP.setLayoutParams(layoutParams);
                }
                this.aaP.setData(pasterData);
                this.mStartPosition = this.aaP.getCurDuration();
                if (!re()) {
                    this.aaT.e(rk());
                    com.baidu.tieba.lego.card.a.c.b(this.aaU);
                }
                this.aaP.e(z, z2, str);
                if (this.aaS != null) {
                    this.aaS.ru();
                }
                return true;
            }
        }
        return false;
    }

    public boolean rd() {
        return this.aaV;
    }

    public boolean re() {
        return this.aaP.re();
    }

    public boolean rf() {
        return this.aaP.rf();
    }

    public void reset() {
        rh();
        this.aaV = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdClose() {
        rh();
        if (this.aaS != null) {
            this.aaS.rt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg() {
        this.aaT.h(rk());
        rh();
    }

    private void rh() {
        this.aaR.reset();
        this.aaP.reset();
        this.rootView.removeView(this.aaP);
        this.rootView.removeView(this.aaQ);
    }

    public void resume() {
        this.aaP.resume();
        if (rf()) {
            this.mStartPosition = this.aaP.getCurDuration();
            this.aaW = this.mStartPosition;
            this.aaT.g(rk());
        }
    }

    public void ri() {
        if (this.aaP != null) {
            this.aaP.ri();
        }
    }

    public void stop() {
        this.mPausePosition = this.aaP.getCurDuration();
        if (rf() && !rj()) {
            this.aaT.f(rk());
        }
        this.aaP.stop();
    }

    private boolean rj() {
        if (this.aaP != null) {
            int[] iArr = new int[2];
            this.aaP.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.aaS = aVar;
    }

    public com.baidu.afd.videopaster.b.a rk() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.abB = this.aaW;
        aVar.abC = this.mPausePosition;
        aVar.abz = this.aaP.getTotalDuration();
        aVar.abA = this.aaP.getCurDuration();
        aVar.aby = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.abD = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.abD = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.abD = 2;
        } else {
            aVar.abD = -1;
        }
        if (this.aaU != null) {
            aVar.abE = this.aaU.rw();
            aVar.tplName = this.aaU.tplName;
            aVar.extraParam = this.aaU.extra;
            aVar.abk = this.aaU.abk;
            aVar.abl = this.aaU.abl;
        }
        return aVar;
    }

    public void be(int i) {
        if (this.aaP != null) {
            this.aaP.be(i);
        }
    }

    public void onDestroy() {
        this.aaR.onDestroy();
    }

    public void rl() {
        if (this.aaP != null) {
            this.aaP.rl();
        }
    }

    public void rm() {
        if (this.aaP != null) {
            this.aaP.rm();
        }
    }

    public boolean rn() {
        return this.aaP != null && this.aaP.rn();
    }

    public void az(boolean z) {
        this.aaY = z;
    }
}
