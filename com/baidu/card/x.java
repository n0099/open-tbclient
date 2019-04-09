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
    private T Xz;
    private y YA;
    private String YB;
    private com.baidu.tieba.card.ab<T> YC;
    private com.baidu.card.a.a YD;
    private int YE;
    private a.C0039a YF;
    private i<T> Yq;
    private ThreadCardView Yr;
    private RelativeLayout Ys;
    private LinearLayout Yt;
    private b<T> Yu;
    private b<T> Yv;
    private List<f> Yw;
    private b<T> Yx;
    private ArrayList<c> Yy;
    private j Yz;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> rq() {
        return this.Yv;
    }

    public b<T> rr() {
        return this.Yx;
    }

    public List<f> rs() {
        return this.Yw;
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
        this.Yq = null;
        this.Yz = null;
        this.YD = new com.baidu.card.a.a();
        this.YE = 0;
        this.YF = new a.C0039a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(d.h.thread_card_layout, viewGroup, false);
        this.Yr = (ThreadCardView) inflate.findViewById(d.g.thread_card_root);
        this.Ys = (RelativeLayout) this.Yr.findViewById(d.g.card_decor_layer);
        this.Yt = (LinearLayout) this.Yr.findViewById(d.g.body_root);
        this.mBottomLine = this.Yr.findViewById(d.g.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.Yu = aVar.YH;
        this.Yv = aVar.YI;
        this.Yw = aVar.YJ;
        this.Yx = aVar.YK;
        this.Yy = aVar.Yy;
        this.YA = aVar.YA;
        this.Yr.setParent(viewGroup);
        this.Yr.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.x.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        x.this.YF.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        x.this.YF.setExtraData(false);
                        break;
                }
                x.this.b(x.this.YF);
                return false;
            }
        });
    }

    public View getView() {
        return this.Yr;
    }

    private void initUI() {
        if (this.YA != null) {
            if (this.Yt.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.Yt.getLayoutParams()).setMargins(this.YA.YU, this.YA.YS, this.YA.YV, this.YA.YT);
                this.Yt.postInvalidate();
            }
            if (this.YA.YO) {
                ru();
            }
            if (this.Yu != null) {
                this.Yu.a(this);
                this.Yt.addView(this.Yu.getView());
                this.Yu.rj();
            }
            if (this.Yv != null) {
                this.Yv.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.YA.YP;
                this.Yt.addView(this.Yv.getView(), layoutParams);
                this.Yv.rj();
            }
            if (this.Yw != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Yw.size()) {
                        break;
                    }
                    f fVar = this.Yw.get(i2);
                    if (fVar != null) {
                        fVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = fVar.getTopMargin();
                        this.Yt.addView(fVar.getView(), layoutParams2);
                        fVar.rj();
                    }
                    i = i2 + 1;
                }
            }
            if (this.Yx != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.YA.YR;
                this.Yx.a(this);
                this.Yt.addView(this.Yx.getView(), layoutParams3);
                this.Yx.rj();
            }
            if (!com.baidu.tbadk.core.util.v.T(this.Yy)) {
                Iterator<c> it = this.Yy.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.getDecorView() != null) {
                        if (next.rl() == null) {
                            this.Ys.addView(next.getDecorView(), next.rn());
                        } else {
                            this.Ys.addView(next.getDecorView(), next.rn(), next.rl());
                        }
                        next.b(this);
                        next.rj();
                    }
                }
            }
        }
    }

    public void bx(int i) {
        this.YE = i;
    }

    public int rt() {
        return this.YE;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.getDecorView() != null) {
            this.Yy.remove(cVar);
            if (cVar.getDecorView().getParent() != null) {
                ((ViewGroup) cVar.getDecorView().getParent()).removeView(cVar.getDecorView());
                cVar.rm();
                cVar.b(null);
            }
            if (cVar.rl() == null) {
                this.Ys.addView(cVar.getDecorView(), cVar.rn());
            } else {
                this.Ys.addView(cVar.getDecorView(), cVar.rn(), cVar.rl());
            }
            cVar.b(this);
            cVar.rj();
            this.Yy.add(cVar);
        }
    }

    private void ru() {
        c cVar = new c();
        cVar.I(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.h(this.context, d.e.ds180), com.baidu.adp.lib.util.l.h(this.context, d.e.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.YA.YS;
        layoutParams.rightMargin = -this.YA.YV;
        cVar.a(layoutParams);
        cVar.bw(-1);
        this.Yy.add(cVar);
    }

    public void b(T t) {
        this.Xz = t;
        if (this.Yu != null) {
            this.Yu.C(t);
        }
        if (this.Yv != null) {
            this.Yv.C(t);
        }
        if (!com.baidu.tbadk.core.util.v.T(this.Yw)) {
            for (f fVar : this.Yw) {
                fVar.C(t);
            }
        }
        if (this.Yx != null) {
            this.Yx.C(t);
        }
        if (this.Yq != null) {
            this.Yq.C(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.YD.c(i, bVar);
    }

    public boolean b(a.C0039a c0039a) {
        return this.YD.b(c0039a);
    }

    public void setPosition(int i) {
        if (this.Yr != null) {
            this.Yr.setPosition(i);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        al.k(this.Yr, this.YA.YW);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(this.mBottomLine, d.C0277d.cp_bg_line_e);
            if (this.Yu != null) {
                this.Yu.onChangeSkinType(tbPageContext, i);
            }
            if (this.Yv != null) {
                this.Yv.onChangeSkinType(tbPageContext, i);
            }
            for (f fVar : this.Yw) {
                if (fVar != null) {
                    fVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.Yx != null) {
                this.Yx.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.T(this.Yy)) {
                Iterator<c> it = this.Yy.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof j)) {
                        ((j) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.Yz != null) {
                this.Yz.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.Yu != null) {
            this.Yu.b(abVar);
        }
        if (this.Yv != null) {
            this.Yv.b(abVar);
        }
        for (f fVar : this.Yw) {
            if (fVar != null) {
                fVar.b(abVar);
            }
        }
        if (this.Yx != null) {
            this.Yx.b(abVar);
        }
        this.YC = abVar;
    }

    public void b(int i, a.b bVar) {
        this.YD.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YB = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private y YA;
        private b YH;
        private b YI;
        private List<f> YJ;
        private b YK;
        private ArrayList<c> Yy;
        private Context context;

        public a(Context context, boolean z) {
            this.YH = null;
            this.YI = null;
            this.YK = null;
            this.context = context;
            this.Yy = new ArrayList<>();
            this.YA = new y();
            if (!z) {
                this.YA.by(0);
            }
            this.YJ = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a c(d dVar) {
            this.YH = dVar;
            return this;
        }

        public a a(b bVar) {
            this.YK = bVar;
            return this;
        }

        public a a(f fVar) {
            this.YJ.add(fVar);
            return this;
        }

        public a b(b bVar) {
            this.YI = bVar;
            return this;
        }

        public x rw() {
            return new x(this);
        }

        public x a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new x(this, z, viewGroup, rVar);
        }

        public y rv() {
            return this.YA;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public y rv() {
        return this.YA;
    }
}
