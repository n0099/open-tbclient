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
    private ViewGroup Rq;
    private VideoPasterContentView Rr;
    private View Rs;
    private a Ru;
    private com.baidu.afd.videopaster.data.a Rw;
    private int Ry;
    private int Rz;
    private Context mContext;
    private int mFloor;
    private String mFrom;
    private int mStartPosition;
    private boolean Rx = false;
    private boolean RA = false;
    private boolean RB = false;
    private QuickVideoView Ro = this.Ro;
    private QuickVideoView Ro = this.Ro;
    private n Rp = this.Rp;
    private n Rp = this.Rp;
    private com.baidu.afd.videopaster.b.b Rv = new com.baidu.afd.videopaster.b.b();
    private com.baidu.afd.videopaster.a.a Rt = new com.baidu.afd.videopaster.a.a();

    /* loaded from: classes3.dex */
    public interface a {
        void pl();

        void pm();

        void pn();

        boolean po();
    }

    public d(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.Rq = viewGroup;
        this.Rt.a(new a.InterfaceC0028a() { // from class: com.baidu.afd.videopaster.d.1
            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void b(com.baidu.afd.videopaster.data.a aVar) {
                d.this.Rw = aVar;
                d.this.a(aVar);
            }

            @Override // com.baidu.afd.videopaster.a.a.InterfaceC0028a
            public void g(int i, String str) {
                d.this.Rw = null;
            }
        });
        this.Rr = new VideoPasterContentView(context);
        this.Rr.setOverlayViewCallback(new VideoPasterOverlayView.a() { // from class: com.baidu.afd.videopaster.d.2
            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void ph() {
                d.this.Rv.k(d.this.pd());
                com.baidu.tieba.lego.card.b.c.a(d.this.Rw);
                if (d.this.Rw != null && s.aG(d.this.mContext, d.this.Rw.RF) == 1) {
                    d.this.Rv.c(d.this.pd(), "title");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pi() {
                d.this.Rv.j(d.this.pd());
                com.baidu.tieba.lego.card.b.c.a(d.this.Rw);
                if (d.this.Rw != null && s.aG(d.this.mContext, d.this.Rw.RF) == 1) {
                    d.this.Rv.c(d.this.pd(), "hotarea");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pj() {
                d.this.Rv.l(d.this.pd());
                com.baidu.tieba.lego.card.b.c.a(d.this.Rw);
                if (d.this.Rw != null && s.aG(d.this.mContext, d.this.Rw.RF) == 1) {
                    d.this.Rv.c(d.this.pd(), "button");
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pk() {
                d.this.RA = true;
                d.this.oY();
                d.this.Rv.f(d.this.pd());
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterOverlayView.a
            public void pl() {
                d.this.Rv.m(d.this.pd());
                if (d.this.Ru != null) {
                    d.this.Ru.pl();
                }
            }
        });
        this.Rr.setContentViewCallback(new VideoPasterContentView.a() { // from class: com.baidu.afd.videopaster.d.3
            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void pm() {
                d.this.oZ();
                if (d.this.Ru != null) {
                    d.this.Ru.pm();
                }
            }

            @Override // com.baidu.afd.videopaster.view.VideoPasterContentView.a
            public void onDetachedFromWindow() {
                int i;
                boolean z = true;
                if (d.this.Rr.isCompleted()) {
                    i = 0;
                } else if (d.this.RA) {
                    d.this.RA = false;
                    i = 1;
                } else {
                    i = 2;
                }
                if (d.this.Ru != null) {
                    if (i == 0 || i == 1) {
                        d.this.bb(i);
                    } else {
                        z = false;
                    }
                    if (!d.this.Ru.po()) {
                        if (d.this.RB) {
                            d.this.RB = false;
                        } else if (!z) {
                            d.this.bb(i);
                        }
                    }
                }
            }
        });
        this.Rs = new View(this.mContext);
        this.Rs.setBackgroundResource(R.color.black_alpha100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i) {
        this.Rv.b(pd(), i);
        if (TextUtils.equals(this.mFrom, "VIDEO_LIST") && i == 2) {
            this.Rv.f(pd());
        }
    }

    public void a(com.baidu.afd.videopaster.a aVar) {
        if (this.Rt != null && !this.Rt.pu() && this.Rt.pv() == null && aVar != null) {
            this.mFloor = aVar.oJ() + 1;
            this.Rt.a(new VideoPasterRequestData(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.afd.videopaster.data.a aVar) {
        if (aVar != null && aVar.RL) {
            this.Rv.i(pd());
        }
    }

    public boolean a(boolean z, boolean z2, String str) {
        if (this.Rt.pu()) {
            return false;
        }
        this.Rx = z2;
        this.mFrom = str;
        VideoPasterResponseData pv = this.Rt.pv();
        if (pv != null) {
            com.baidu.afd.videopaster.data.a pasterData = pv.getPasterData();
            if (pasterData == null) {
                this.Rt.reset();
                return false;
            } else if (pasterData.isEmpty()) {
                this.Rv.e(pd());
                this.Rt.reset();
                return false;
            } else if (!pasterData.isValid()) {
                this.Rt.reset();
                return false;
            } else {
                this.Rq.removeView(this.Rs);
                this.Rq.addView(this.Rs);
                this.Rq.removeView(this.Rr);
                this.Rq.addView(this.Rr);
                if (this.Rq instanceof FrameLayout) {
                    this.Rr.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
                } else if (this.Rq instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    this.Rr.setLayoutParams(layoutParams);
                }
                this.Rr.setData(pasterData);
                this.mStartPosition = this.Rr.getCurDuration();
                if (!oW()) {
                    this.Rv.e(pd());
                    com.baidu.tieba.lego.card.b.c.b(this.Rw);
                }
                this.Rr.b(z, z2, str);
                if (this.Ru != null) {
                    this.Ru.pn();
                }
                return true;
            }
        }
        return false;
    }

    public boolean oV() {
        return this.Rx;
    }

    public boolean oW() {
        return this.Rr.oW();
    }

    public boolean oX() {
        return this.Rr.oX();
    }

    public void reset() {
        pa();
        this.Rx = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oY() {
        pa();
        if (this.Ru != null) {
            this.Ru.pm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oZ() {
        this.Rv.h(pd());
        pa();
    }

    private void pa() {
        this.Rt.reset();
        this.Rr.reset();
        this.Rq.removeView(this.Rr);
        this.Rq.removeView(this.Rs);
    }

    public void resume() {
        this.Rr.resume();
        if (oX()) {
            this.mStartPosition = this.Rr.getCurDuration();
            this.Rz = this.mStartPosition;
            this.Rv.g(pd());
        }
    }

    public void pb() {
        if (this.Rr != null) {
            this.Rr.pb();
        }
    }

    public void stop() {
        this.Ry = this.Rr.getCurDuration();
        if (oX() && !pc()) {
            this.Rv.f(pd());
        }
        this.Rr.stop();
    }

    private boolean pc() {
        if (this.Rr != null) {
            int[] iArr = new int[2];
            this.Rr.getLocationOnScreen(iArr);
            int i = iArr[1];
            if (UtilHelper.getRealScreenOrientation(this.mContext) == 1 && i == 0 && TextUtils.equals(this.mFrom, "VIDEO_LIST")) {
                return true;
            }
        }
        return false;
    }

    public void a(a aVar) {
        this.Ru = aVar;
    }

    public com.baidu.afd.videopaster.b.a pd() {
        com.baidu.afd.videopaster.b.a aVar = new com.baidu.afd.videopaster.b.a();
        aVar.Sf = this.mStartPosition;
        aVar.Sg = this.Rz;
        aVar.Sh = this.Ry;
        aVar.Sd = this.Rr.getTotalDuration();
        aVar.Se = this.Rr.getCurDuration();
        aVar.Sc = this.mFloor;
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 1) {
            aVar.Si = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            aVar.Si = 1;
        } else if (UtilHelper.getRealScreenOrientation(this.mContext) == 0) {
            aVar.Si = 2;
        } else {
            aVar.Si = -1;
        }
        if (this.Rw != null) {
            aVar.Sj = this.Rw.pp();
            aVar.tplName = this.Rw.tplName;
            aVar.extraParam = this.Rw.extra;
            aVar.RO = this.Rw.RO;
            aVar.RP = this.Rw.RP;
        }
        return aVar;
    }

    public void bc(int i) {
        if (this.Rr != null) {
            this.Rr.bc(i);
        }
    }

    public void onDestroy() {
        this.Rt.onDestroy();
    }

    public void pe() {
        if (this.Rr != null) {
            this.Rr.pe();
        }
    }

    public void pf() {
        if (this.Rr != null) {
            this.Rr.pf();
        }
    }

    public boolean pg() {
        return this.Rr != null && this.Rr.pg();
    }

    public void au(boolean z) {
        this.RB = z;
    }
}
