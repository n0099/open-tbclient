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
    private int RA;
    private ViewGroup Rr;
    private VideoPasterContentView Rs;
    private View Rt;
    private a Rv;
    private com.baidu.afd.videopaster.data.a Rx;
    private int Rz;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mStartPosition;
    private boolean Ry = false;
    private boolean RB = false;
    private boolean RC = false;
    private QuickVideoView Rp = this.Rp;
    private QuickVideoView Rp = this.Rp;
    private n Rq = this.Rq;
    private n Rq = this.Rq;
    private com.baidu.afd.videopaster.b.b Rw = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Ru = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes3.dex */
    public interface a {
        void pl();

        void pm();

        void pn();

        boolean po();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.Rr = viewGroup;
        this.Ru.a(new a.InterfaceC0028a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Rx = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void g(int i, String str) {
                d.this.Rx = null;
            }
        });
        this.Rs = new VideoPasterContentView(context);
        this.Rs.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void ph() {
                d.this.Rw.k(d.this.pd());
                com.baidu.tieba.lego.card.b.c.a(d.this.Rx);
                if (d.this.Rx != null && s.aG(d.this.mContext, d.this.Rx.RG) == 1) {
                    d.this.Rw.c(d.this.pd(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pi() {
                d.this.Rw.j(d.this.pd());
                com.baidu.tieba.lego.card.b.c.a(d.this.Rx);
                if (d.this.Rx != null && s.aG(d.this.mContext, d.this.Rx.RG) == 1) {
                    d.this.Rw.c(d.this.pd(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pj() {
                d.this.Rw.l(d.this.pd());
                com.baidu.tieba.lego.card.b.c.a(d.this.Rx);
                if (d.this.Rx != null && s.aG(d.this.mContext, d.this.Rx.RG) == 1) {
                    d.this.Rw.c(d.this.pd(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pk() {
                d.this.RB = true;
                d.this.oY();
                d.this.Rw.f(d.this.pd());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pl() {
                d.this.Rw.m(d.this.pd());
                if (d.this.Rv != null) {
                    d.this.Rv.pl();
                }
            }
        });
        this.Rs.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void pm() {
                d.this.oZ();
                if (d.this.Rv != null) {
                    d.this.Rv.pm();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Rs.isCompleted()) {
                    i = 0;
                } else if (d.this.RB) {
                    d.this.RB = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Rv != null) {
                    if (i == 0 || i == 1) {
                        d.this.bb(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Rv.po()) {
                        if (d.this.RC) {
                            d.this.RC = false;
                        } else if (!z) {
                            d.this.bb(i);
                        }
                    }
                }
            }
        });
        this.Rt = new View(this.mContext);
        this.Rt.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i) {
        this.Rw.b(pd(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Rw.f(pd());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Ru != null && !this.Ru.pu() && this.Ru.pv() == null && aVar != null) {
            this.mFloor = aVar.oJ() + 1;
            this.Ru.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.RO) {
            this.Rw.i(pd());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Ru.pu()) {
            return false;
        }
        this.Ry = z2;
        this.mFrom = str;
        VideoPasterResponseData pv = this.Ru.pv();
        if (pv != null) {
            com.baidu.afd.videopaster.data.a pasterData = pv.getPasterData();
            if (pasterData == null) {
                this.Ru.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Rw.e(pd());
                this.Ru.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Ru.reset();
                return false;
            } else {
                this.Rr.removeView(this.Rt);
                this.Rr.addView(this.Rt);
                this.Rr.removeView(this.Rs);
                this.Rr.addView(this.Rs);
                if (this.Rr instanceof FrameLayout) {
                    this.Rs.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.Rr instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Rs.setLayoutParams(layoutParams);
                }
                this.Rs.setData(pasterData);
                this.mStartPosition = this.Rs.getCurDuration();
                if (!oW()) {
                    this.Rw.e(pd());
                    com.baidu.tieba.lego.card.b.c.b(this.Rx);
                }
                this.Rs.b(z, z2, str);
                if (this.Rv != null) {
                    this.Rv.pn();
                }
                return true;
            }
        }
        return false;
    }

    public boolean oV() {
        return this.Ry;
    }

    public boolean oW() {
        return this.Rs.oW();
    }

    public boolean oX() {
        return this.Rs.oX();
    }

    public void reset() {
        pa();
        this.Ry = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oY() {
        pa();
        if (this.Rv != null) {
            this.Rv.pm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oZ() {
        this.Rw.h(pd());
        pa();
    }

    private void pa() {
        this.Ru.reset();
        this.Rs.reset();
        this.Rr.removeView(this.Rs);
        this.Rr.removeView(this.Rt);
    }

    public void resume() {
        this.Rs.resume();
        if (oX()) {
            this.mStartPosition = this.Rs.getCurDuration();
            this.RA = this.mStartPosition;
            this.Rw.g(pd());
        }
    }

    public void pb() {
        if (this.Rs != null) {
            this.Rs.pb();
        }
    }

    public void stop() {
        this.Rz = this.Rs.getCurDuration();
        if (oX() && !pc()) {
            this.Rw.f(pd());
        }
        this.Rs.stop();
    }

    private boolean pc() {
        if (this.Rs != null) {
            int[] iArr = new int[2];
            this.Rs.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Rv = aVar;
    }

    public com.baidu.afd.videopaster.b.a pd() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.Sg = this.mStartPosition;
        aVar.Sh = this.RA;
        aVar.Si = this.Rz;
        aVar.Se = this.Rs.getTotalDuration();
        aVar.Sf = this.Rs.getCurDuration();
        aVar.Sd = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Sj = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Sj = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Sj = 2;
        } else {
            aVar.Sj = -1;
        }
        if (this.Rx != null) {
            aVar.Sk = this.Rx.pp();
            aVar.tplName = this.Rx.tplName;
            aVar.extraParam = this.Rx.extra;
            aVar.RP = this.Rx.RP;
            aVar.RQ = this.Rx.RQ;
        }
        return aVar;
    }

    public void bc(int i) {
        if (this.Rs != null) {
            this.Rs.bc(i);
        }
    }

    public void onDestroy() {
        this.Ru.onDestroy();
    }

    public void pe() {
        if (this.Rs != null) {
            this.Rs.pe();
        }
    }

    public void pf() {
        if (this.Rs != null) {
            this.Rs.pf();
        }
    }

    public boolean pg() {
        return this.Rs != null && this.Rs.pg();
    }

    public void au(boolean z) {
        this.RC = z;
    }
}
