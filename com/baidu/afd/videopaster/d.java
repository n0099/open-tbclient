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
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class d {
    private ViewGroup Bg;
    private VideoPasterContentView Bh;
    private View Bi;
    private a Bk;
    private com.baidu.afd.videopaster.data.a Bm;
    private int Bo;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private boolean Bn = false;
    private boolean Bp = false;
    private boolean Bq = false;
    private QuickVideoView Be = this.Be;
    private QuickVideoView Be = this.Be;
    private n Bf = this.Bf;
    private n Bf = this.Bf;
    private com.baidu.afd.videopaster.b.b Bl = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Bj = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes3.dex */
    public interface a {
        void kC();

        void kD();

        void kE();

        boolean kF();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.Bg = viewGroup;
        this.Bj.a(new a.InterfaceC0028a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Bm = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void f(int i, String str) {
                d.this.Bm = null;
            }
        });
        this.Bh = new VideoPasterContentView(context);
        this.Bh.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void ky() {
                d.this.Bl.k(d.this.ku());
                com.baidu.tieba.lego.card.b.c.a(d.this.Bm);
                if (d.this.Bm != null && s.aL(d.this.mContext, d.this.Bm.Bu) == 1) {
                    d.this.Bl.c(d.this.ku(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kz() {
                d.this.Bl.j(d.this.ku());
                com.baidu.tieba.lego.card.b.c.a(d.this.Bm);
                if (d.this.Bm != null && s.aL(d.this.mContext, d.this.Bm.Bu) == 1) {
                    d.this.Bl.c(d.this.ku(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kA() {
                d.this.Bl.l(d.this.ku());
                com.baidu.tieba.lego.card.b.c.a(d.this.Bm);
                if (d.this.Bm != null && s.aL(d.this.mContext, d.this.Bm.Bu) == 1) {
                    d.this.Bl.c(d.this.ku(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kB() {
                d.this.Bp = true;
                d.this.kp();
                d.this.Bl.f(d.this.ku());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kC() {
                d.this.Bl.m(d.this.ku());
                if (d.this.Bk != null) {
                    d.this.Bk.kC();
                }
            }
        });
        this.Bh.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void kD() {
                d.this.kq();
                if (d.this.Bk != null) {
                    d.this.Bk.kD();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Bh.aK()) {
                    i = 0;
                } else if (d.this.Bp) {
                    d.this.Bp = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Bk != null) {
                    if (i == 0 || i == 1) {
                        d.this.aq(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Bk.kF()) {
                        if (d.this.Bq) {
                            d.this.Bq = false;
                        } else if (!z) {
                            d.this.aq(i);
                        }
                    }
                }
            }
        });
        this.Bi = new View(this.mContext);
        this.Bi.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(int i) {
        this.Bl.b(ku(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Bl.f(ku());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Bj != null && !this.Bj.isLoading() && this.Bj.kL() == null && aVar != null) {
            this.mFloor = aVar.ka() + 1;
            this.Bj.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.BA) {
            this.Bl.i(ku());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Bj.isLoading()) {
            return false;
        }
        this.Bn = z2;
        this.mFrom = str;
        VideoPasterResponseData kL = this.Bj.kL();
        if (kL != null) {
            com.baidu.afd.videopaster.data.a pasterData = kL.getPasterData();
            if (pasterData == null) {
                this.Bj.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Bl.e(ku());
                this.Bj.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Bj.reset();
                return false;
            } else {
                this.Bg.removeView(this.Bi);
                this.Bg.addView(this.Bi);
                this.Bg.removeView(this.Bh);
                this.Bg.addView(this.Bh);
                if (this.Bg instanceof FrameLayout) {
                    this.Bh.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.Bg instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Bh.setLayoutParams(layoutParams);
                }
                this.Bh.setData(pasterData);
                this.mStartPosition = this.Bh.getCurDuration();
                if (!kn()) {
                    this.Bl.e(ku());
                    com.baidu.tieba.lego.card.b.c.b(this.Bm);
                }
                this.Bh.b(z, z2, str);
                if (this.Bk != null) {
                    this.Bk.kE();
                }
                return true;
            }
        }
        return false;
    }

    public boolean km() {
        return this.Bn;
    }

    public boolean kn() {
        return this.Bh.kn();
    }

    public boolean ko() {
        return this.Bh.ko();
    }

    public void reset() {
        kr();
        this.Bn = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp() {
        kr();
        if (this.Bk != null) {
            this.Bk.kD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq() {
        this.Bl.h(ku());
        kr();
    }

    private void kr() {
        this.Bj.reset();
        this.Bh.reset();
        this.Bg.removeView(this.Bh);
        this.Bg.removeView(this.Bi);
    }

    public void resume() {
        this.Bh.resume();
        if (ko()) {
            this.mStartPosition = this.Bh.getCurDuration();
            this.Bo = this.mStartPosition;
            this.Bl.g(ku());
        }
    }

    public void ks() {
        if (this.Bh != null) {
            this.Bh.ks();
        }
    }

    public void stop() {
        this.mPausePosition = this.Bh.getCurDuration();
        if (ko() && !kt()) {
            this.Bl.f(ku());
        }
        this.Bh.stop();
    }

    private boolean kt() {
        if (this.Bh != null) {
            int[] iArr = new int[2];
            this.Bh.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Bk = aVar;
    }

    public com.baidu.afd.videopaster.b.a ku() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.BR = this.mStartPosition;
        aVar.BS = this.Bo;
        aVar.BT = this.mPausePosition;
        aVar.BP = this.Bh.getTotalDuration();
        aVar.BQ = this.Bh.getCurDuration();
        aVar.BO = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.BU = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.BU = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.BU = 2;
        } else {
            aVar.BU = -1;
        }
        if (this.Bm != null) {
            aVar.BV = this.Bm.kG();
            aVar.tplName = this.Bm.tplName;
            aVar.extraParam = this.Bm.extra;
            aVar.BB = this.Bm.BB;
            aVar.BC = this.Bm.BC;
        }
        return aVar;
    }

    public void ar(int i) {
        if (this.Bh != null) {
            this.Bh.ar(i);
        }
    }

    public void onDestroy() {
        this.Bj.onDestroy();
    }

    public void kv() {
        if (this.Bh != null) {
            this.Bh.kv();
        }
    }

    public void kw() {
        if (this.Bh != null) {
            this.Bh.kw();
        }
    }

    public boolean kx() {
        return this.Bh != null && this.Bh.kx();
    }

    public void Q(boolean z) {
        this.Bq = z;
    }
}
