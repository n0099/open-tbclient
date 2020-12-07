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
    private VideoPasterContentView aai;
    private View aaj;
    private a aal;
    private com.baidu.afd.videopaster.data.a aan;
    private int aap;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mPausePosition;
    private int mStartPosition;
    private ViewGroup rootView;
    private boolean aao = false;
    private boolean aaq = false;
    private boolean aar = false;
    private com.baidu.afd.videopaster.b.b aam = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a aak = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes21.dex */
    public interface a {
        void rR();

        void rS();

        void rT();

        boolean rU();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.rootView = viewGroup;
        this.aak.a(new a.InterfaceC0033a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0033a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.aan = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0033a
            public void d(int i, String str) {
                d.this.aan = null;
            }
        });
        this.aai = new VideoPasterContentView(context);
        this.aai.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rN() {
                d.this.aam.k(d.this.rJ());
                com.baidu.tieba.lego.card.b.c.a(d.this.aan);
                if (d.this.aan != null && s.aZ(d.this.mContext, d.this.aan.aav) == 1) {
                    d.this.aam.c(d.this.rJ(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rO() {
                d.this.aam.j(d.this.rJ());
                com.baidu.tieba.lego.card.b.c.a(d.this.aan);
                if (d.this.aan != null && s.aZ(d.this.mContext, d.this.aan.aav) == 1) {
                    d.this.aam.c(d.this.rJ(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rP() {
                d.this.aam.l(d.this.rJ());
                com.baidu.tieba.lego.card.b.c.a(d.this.aan);
                if (d.this.aan != null && s.aZ(d.this.mContext, d.this.aan.aav) == 1) {
                    d.this.aam.c(d.this.rJ(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rQ() {
                d.this.aaq = true;
                d.this.rE();
                d.this.aam.f(d.this.rJ());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void rR() {
                d.this.aam.m(d.this.rJ());
                if (d.this.aal != null) {
                    d.this.aal.rR();
                }
            }
        });
        this.aai.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void rS() {
                d.this.rF();
                if (d.this.aal != null) {
                    d.this.aal.rS();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.aai.ik()) {
                    i = 0;
                } else if (d.this.aaq) {
                    d.this.aaq = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.aal != null) {
                    if (i == 0 || i == 1) {
                        d.this.bc(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.aal.rU()) {
                        if (d.this.aar) {
                            d.this.aar = false;
                        } else if (!z) {
                            d.this.bc(i);
                        }
                    }
                }
            }
        });
        this.aaj = new View(this.mContext);
        this.aaj.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(int i) {
        this.aam.b(rJ(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.aam.f(rJ());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.aak != null && !this.aak.isLoading() && this.aak.sa() == null && aVar != null) {
            this.mFloor = aVar.rp() + 1;
            this.aak.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.aaB) {
            this.aam.i(rJ());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.aak.isLoading()) {
            return false;
        }
        this.aao = z2;
        this.mFrom = str;
        VideoPasterResponseData sa = this.aak.sa();
        if (sa != null) {
            com.baidu.afd.videopaster.data.a pasterData = sa.getPasterData();
            if (pasterData == null) {
                this.aak.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.aam.e(rJ());
                this.aak.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.aak.reset();
                return false;
            } else {
                this.rootView.removeView(this.aaj);
                this.rootView.addView(this.aaj);
                this.rootView.removeView(this.aai);
                this.rootView.addView(this.aai);
                if (this.rootView instanceof FrameLayout) {
                    this.aai.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.rootView instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.aai.setLayoutParams(layoutParams);
                }
                this.aai.setData(pasterData);
                this.mStartPosition = this.aai.getCurDuration();
                if (!rC()) {
                    this.aam.e(rJ());
                    com.baidu.tieba.lego.card.b.c.b(this.aan);
                }
                this.aai.b(z, z2, str);
                if (this.aal != null) {
                    this.aal.rT();
                }
                return true;
            }
        }
        return false;
    }

    public boolean rB() {
        return this.aao;
    }

    public boolean rC() {
        return this.aai.rC();
    }

    public boolean rD() {
        return this.aai.rD();
    }

    public void reset() {
        rG();
        this.aao = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rE() {
        rG();
        if (this.aal != null) {
            this.aal.rS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rF() {
        this.aam.h(rJ());
        rG();
    }

    private void rG() {
        this.aak.reset();
        this.aai.reset();
        this.rootView.removeView(this.aai);
        this.rootView.removeView(this.aaj);
    }

    public void resume() {
        this.aai.resume();
        if (rD()) {
            this.mStartPosition = this.aai.getCurDuration();
            this.aap = this.mStartPosition;
            this.aam.g(rJ());
        }
    }

    public void rH() {
        if (this.aai != null) {
            this.aai.rH();
        }
    }

    public void stop() {
        this.mPausePosition = this.aai.getCurDuration();
        if (rD() && !rI()) {
            this.aam.f(rJ());
        }
        this.aai.stop();
    }

    private boolean rI() {
        if (this.aai != null) {
            int[] iArr = new int[2];
            this.aai.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.aal = aVar;
    }

    public com.baidu.afd.videopaster.b.a rJ() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.startPosition = this.mStartPosition;
        aVar.aaS = this.aap;
        aVar.aaT = this.mPausePosition;
        aVar.aaQ = this.aai.getTotalDuration();
        aVar.aaR = this.aai.getCurDuration();
        aVar.aaP = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.aaU = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.aaU = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.aaU = 2;
        } else {
            aVar.aaU = -1;
        }
        if (this.aan != null) {
            aVar.aaV = this.aan.rV();
            aVar.tplName = this.aan.tplName;
            aVar.extraParam = this.aan.extra;
            aVar.aaC = this.aan.aaC;
            aVar.aaD = this.aan.aaD;
        }
        return aVar;
    }

    public void bd(int i) {
        if (this.aai != null) {
            this.aai.bd(i);
        }
    }

    public void onDestroy() {
        this.aak.onDestroy();
    }

    public void rK() {
        if (this.aai != null) {
            this.aai.rK();
        }
    }

    public void rL() {
        if (this.aai != null) {
            this.aai.rL();
        }
    }

    public boolean rM() {
        return this.aai != null && this.aai.rM();
    }

    public void aA(boolean z) {
        this.aar = z;
    }
}
