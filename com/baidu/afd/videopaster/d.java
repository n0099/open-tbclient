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
    private ViewGroup AE;
    private VideoPasterContentView AF;
    private View AG;
    private a AI;
    private com.baidu.afd.videopaster.data.a AK;
    private int AN;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private boolean AM = false;
    private boolean AO = false;
    private boolean AP = false;
    private QuickVideoView AC = this.AC;
    private QuickVideoView AC = this.AC;
    private n AD = this.AD;
    private n AD = this.AD;
    private com.baidu.afd.videopaster.b.b AJ = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a AH = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes3.dex */
    public interface a {
        void kC();

        void kD();

        void kE();

        boolean kF();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.AE = viewGroup;
        this.AH.a(new a.InterfaceC0028a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.AK = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void f(int i, String str) {
                d.this.AK = null;
            }
        });
        this.AF = new VideoPasterContentView(context);
        this.AF.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void ky() {
                d.this.AJ.k(d.this.ku());
                com.baidu.tieba.lego.card.b.c.a(d.this.AK);
                if (d.this.AK != null && s.aL(d.this.mContext, d.this.AK.AU) == 1) {
                    d.this.AJ.c(d.this.ku(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kz() {
                d.this.AJ.j(d.this.ku());
                com.baidu.tieba.lego.card.b.c.a(d.this.AK);
                if (d.this.AK != null && s.aL(d.this.mContext, d.this.AK.AU) == 1) {
                    d.this.AJ.c(d.this.ku(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kA() {
                d.this.AJ.l(d.this.ku());
                com.baidu.tieba.lego.card.b.c.a(d.this.AK);
                if (d.this.AK != null && s.aL(d.this.mContext, d.this.AK.AU) == 1) {
                    d.this.AJ.c(d.this.ku(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kB() {
                d.this.AO = true;
                d.this.kp();
                d.this.AJ.f(d.this.ku());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void kC() {
                d.this.AJ.m(d.this.ku());
                if (d.this.AI != null) {
                    d.this.AI.kC();
                }
            }
        });
        this.AF.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void kD() {
                d.this.kq();
                if (d.this.AI != null) {
                    d.this.AI.kD();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.AF.aK()) {
                    i = 0;
                } else if (d.this.AO) {
                    d.this.AO = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.AI != null) {
                    if (i == 0 || i == 1) {
                        d.this.aq(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.AI.kF()) {
                        if (d.this.AP) {
                            d.this.AP = false;
                        } else if (!z) {
                            d.this.aq(i);
                        }
                    }
                }
            }
        });
        this.AG = new View(this.mContext);
        this.AG.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(int i) {
        this.AJ.b(ku(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.AJ.f(ku());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.AH != null && !this.AH.isLoading() && this.AH.kL() == null && aVar != null) {
            this.mFloor = aVar.ka() + 1;
            this.AH.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.Ba) {
            this.AJ.i(ku());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.AH.isLoading()) {
            return false;
        }
        this.AM = z2;
        this.mFrom = str;
        VideoPasterResponseData kL = this.AH.kL();
        if (kL != null) {
            com.baidu.afd.videopaster.data.a pasterData = kL.getPasterData();
            if (pasterData == null) {
                this.AH.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.AJ.e(ku());
                this.AH.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.AH.reset();
                return false;
            } else {
                this.AE.removeView(this.AG);
                this.AE.addView(this.AG);
                this.AE.removeView(this.AF);
                this.AE.addView(this.AF);
                if (this.AE instanceof FrameLayout) {
                    this.AF.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.AE instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.AF.setLayoutParams(layoutParams);
                }
                this.AF.setData(pasterData);
                this.mStartPosition = this.AF.getCurDuration();
                if (!kn()) {
                    this.AJ.e(ku());
                    com.baidu.tieba.lego.card.b.c.b(this.AK);
                }
                this.AF.b(z, z2, str);
                if (this.AI != null) {
                    this.AI.kE();
                }
                return true;
            }
        }
        return false;
    }

    public boolean km() {
        return this.AM;
    }

    public boolean kn() {
        return this.AF.kn();
    }

    public boolean ko() {
        return this.AF.ko();
    }

    public void reset() {
        kr();
        this.AM = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp() {
        kr();
        if (this.AI != null) {
            this.AI.kD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq() {
        this.AJ.h(ku());
        kr();
    }

    private void kr() {
        this.AH.reset();
        this.AF.reset();
        this.AE.removeView(this.AF);
        this.AE.removeView(this.AG);
    }

    public void resume() {
        this.AF.resume();
        if (ko()) {
            this.mStartPosition = this.AF.getCurDuration();
            this.AN = this.mStartPosition;
            this.AJ.g(ku());
        }
    }

    public void ks() {
        if (this.AF != null) {
            this.AF.ks();
        }
    }

    public void stop() {
        this.mPausePosition = this.AF.getCurDuration();
        if (ko() && !kt()) {
            this.AJ.f(ku());
        }
        this.AF.stop();
    }

    private boolean kt() {
        if (this.AF != null) {
            int[] iArr = new int[2];
            this.AF.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.AI = aVar;
    }

    public com.baidu.afd.videopaster.b.a ku() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.Br = this.mStartPosition;
        aVar.Bs = this.AN;
        aVar.Bt = this.mPausePosition;
        aVar.Bp = this.AF.getTotalDuration();
        aVar.Bq = this.AF.getCurDuration();
        aVar.Bo = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Bu = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Bu = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Bu = 2;
        } else {
            aVar.Bu = -1;
        }
        if (this.AK != null) {
            aVar.Bv = this.AK.kG();
            aVar.tplName = this.AK.tplName;
            aVar.extraParam = this.AK.extra;
            aVar.Bb = this.AK.Bb;
            aVar.Bc = this.AK.Bc;
        }
        return aVar;
    }

    public void ar(int i) {
        if (this.AF != null) {
            this.AF.ar(i);
        }
    }

    public void onDestroy() {
        this.AH.onDestroy();
    }

    public void kv() {
        if (this.AF != null) {
            this.AF.kv();
        }
    }

    public void kw() {
        if (this.AF != null) {
            this.AF.kw();
        }
    }

    public boolean kx() {
        return this.AF != null && this.AF.kx();
    }

    public void Q(boolean z) {
        this.AP = z;
    }
}
