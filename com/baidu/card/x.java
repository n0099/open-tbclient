package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.card.a.a;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class x<T extends com.baidu.tbadk.core.data.a> implements j, com.baidu.tieba.a.e {
    private T Xx;
    private com.baidu.tieba.card.ab<T> YA;
    private com.baidu.card.a.a YB;
    private int YC;
    private a.C0037a YD;
    private i<T> Yo;
    private ThreadCardView Yp;
    private RelativeLayout Yq;
    private LinearLayout Yr;
    private b<T> Ys;
    private b<T> Yt;
    private List<f> Yu;
    private b<T> Yv;
    private ArrayList<c> Yw;
    private j Yx;
    private y Yy;
    private String Yz;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> rq() {
        return this.Yt;
    }

    public b<T> rr() {
        return this.Yv;
    }

    public List<f> rs() {
        return this.Yu;
    }

    private x(a aVar) {
        this(aVar, true);
    }

    private x(a aVar, boolean z) {
        this(aVar, z, null);
    }

    private x(a aVar, boolean z, ViewGroup viewGroup) {
        this(aVar, z, viewGroup, null);
    }

    private x(a aVar, boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
        this.mSkinType = 3;
        this.Yo = null;
        this.Yx = null;
        this.YB = new com.baidu.card.a.a();
        this.YC = 0;
        this.YD = new a.C0037a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(d.h.thread_card_layout, viewGroup, false);
        this.Yp = (ThreadCardView) inflate.findViewById(d.g.thread_card_root);
        this.Yq = (RelativeLayout) this.Yp.findViewById(d.g.card_decor_layer);
        this.Yr = (LinearLayout) this.Yp.findViewById(d.g.body_root);
        this.mBottomLine = this.Yp.findViewById(d.g.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.Ys = aVar.YF;
        this.Yt = aVar.YG;
        this.Yu = aVar.YH;
        this.Yv = aVar.YI;
        this.Yw = aVar.Yw;
        this.Yy = aVar.Yy;
        this.Yp.setParent(viewGroup);
        this.Yp.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.x.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        x.this.YD.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        x.this.YD.setExtraData(false);
                        break;
                }
                x.this.b(x.this.YD);
                return false;
            }
        });
    }

    public View getView() {
        return this.Yp;
    }

    private void initUI() {
        if (this.Yy != null) {
            if (this.Yr.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.Yr.getLayoutParams()).setMargins(this.Yy.YS, this.Yy.YQ, this.Yy.YT, this.Yy.YR);
                this.Yr.postInvalidate();
            }
            if (this.Yy.YM) {
                ru();
            }
            if (this.Ys != null) {
                this.Ys.a(this);
                this.Yr.addView(this.Ys.getView());
                this.Ys.rj();
            }
            if (this.Yt != null) {
                this.Yt.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.Yy.YN;
                this.Yr.addView(this.Yt.getView(), layoutParams);
                this.Yt.rj();
            }
            if (this.Yu != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Yu.size()) {
                        break;
                    }
                    f fVar = this.Yu.get(i2);
                    if (fVar != null) {
                        fVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = fVar.getTopMargin();
                        this.Yr.addView(fVar.getView(), layoutParams2);
                        fVar.rj();
                    }
                    i = i2 + 1;
                }
            }
            if (this.Yv != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.Yy.YP;
                this.Yv.a(this);
                this.Yr.addView(this.Yv.getView(), layoutParams3);
                this.Yv.rj();
            }
            if (!com.baidu.tbadk.core.util.v.T(this.Yw)) {
                Iterator<c> it = this.Yw.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.getDecorView() != null) {
                        if (next.rl() == null) {
                            this.Yq.addView(next.getDecorView(), next.rn());
                        } else {
                            this.Yq.addView(next.getDecorView(), next.rn(), next.rl());
                        }
                        next.b(this);
                        next.rj();
                    }
                }
            }
        }
    }

    public void by(int i) {
        this.YC = i;
    }

    public int rt() {
        return this.YC;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.getDecorView() != null) {
            this.Yw.remove(cVar);
            if (cVar.getDecorView().getParent() != null) {
                ((ViewGroup) cVar.getDecorView().getParent()).removeView(cVar.getDecorView());
                cVar.rm();
                cVar.b(null);
            }
            if (cVar.rl() == null) {
                this.Yq.addView(cVar.getDecorView(), cVar.rn());
            } else {
                this.Yq.addView(cVar.getDecorView(), cVar.rn(), cVar.rl());
            }
            cVar.b(this);
            cVar.rj();
            this.Yw.add(cVar);
        }
    }

    private void ru() {
        c cVar = new c();
        cVar.I(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.h(this.context, d.e.ds180), com.baidu.adp.lib.util.l.h(this.context, d.e.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.Yy.YQ;
        layoutParams.rightMargin = -this.Yy.YT;
        cVar.a(layoutParams);
        cVar.bx(-1);
        this.Yw.add(cVar);
    }

    public void b(T t) {
        this.Xx = t;
        if (this.Ys != null) {
            this.Ys.C(t);
        }
        if (this.Yt != null) {
            this.Yt.C(t);
        }
        if (!com.baidu.tbadk.core.util.v.T(this.Yu)) {
            for (f fVar : this.Yu) {
                fVar.C(t);
            }
        }
        if (this.Yv != null) {
            this.Yv.C(t);
        }
        if (this.Yo != null) {
            this.Yo.C(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.YB.c(i, bVar);
    }

    public boolean b(a.C0037a c0037a) {
        return this.YB.b(c0037a);
    }

    public void setPosition(int i) {
        if (this.Yp != null) {
            this.Yp.setPosition(i);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        al.k(this.Yp, this.Yy.YU);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(this.mBottomLine, d.C0236d.cp_bg_line_e);
            if (this.Ys != null) {
                this.Ys.onChangeSkinType(tbPageContext, i);
            }
            if (this.Yt != null) {
                this.Yt.onChangeSkinType(tbPageContext, i);
            }
            for (f fVar : this.Yu) {
                if (fVar != null) {
                    fVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.Yv != null) {
                this.Yv.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.T(this.Yw)) {
                Iterator<c> it = this.Yw.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof j)) {
                        ((j) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.Yx != null) {
                this.Yx.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.Ys != null) {
            this.Ys.b(abVar);
        }
        if (this.Yt != null) {
            this.Yt.b(abVar);
        }
        for (f fVar : this.Yu) {
            if (fVar != null) {
                fVar.b(abVar);
            }
        }
        if (this.Yv != null) {
            this.Yv.b(abVar);
        }
        this.YA = abVar;
    }

    public void b(int i, a.b bVar) {
        this.YB.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Yz = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private b YF;
        private b YG;
        private List<f> YH;
        private b YI;
        private ArrayList<c> Yw;
        private y Yy;
        private Context context;

        public a(Context context, boolean z) {
            this.YF = null;
            this.YG = null;
            this.YI = null;
            this.context = context;
            this.Yw = new ArrayList<>();
            this.Yy = new y();
            if (!z) {
                this.Yy.bz(0);
            }
            this.YH = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a c(d dVar) {
            this.YF = dVar;
            return this;
        }

        public a a(b bVar) {
            this.YI = bVar;
            return this;
        }

        public a a(f fVar) {
            this.YH.add(fVar);
            return this;
        }

        public a b(b bVar) {
            this.YG = bVar;
            return this;
        }

        public x rw() {
            return new x(this);
        }

        public x a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new x(this, z, viewGroup, rVar);
        }

        public y rv() {
            return this.Yy;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public y rv() {
        return this.Yy;
    }
}
