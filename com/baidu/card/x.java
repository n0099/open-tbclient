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
    private T Xy;
    private String YA;
    private com.baidu.tieba.card.ab<T> YB;
    private com.baidu.card.a.a YC;
    private int YD;
    private a.C0039a YE;
    private i<T> Yp;
    private ThreadCardView Yq;
    private RelativeLayout Yr;
    private LinearLayout Ys;
    private b<T> Yt;
    private b<T> Yu;
    private List<f> Yv;
    private b<T> Yw;
    private ArrayList<c> Yx;
    private j Yy;
    private y Yz;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> rq() {
        return this.Yu;
    }

    public b<T> rr() {
        return this.Yw;
    }

    public List<f> rs() {
        return this.Yv;
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
        this.Yp = null;
        this.Yy = null;
        this.YC = new com.baidu.card.a.a();
        this.YD = 0;
        this.YE = new a.C0039a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(d.h.thread_card_layout, viewGroup, false);
        this.Yq = (ThreadCardView) inflate.findViewById(d.g.thread_card_root);
        this.Yr = (RelativeLayout) this.Yq.findViewById(d.g.card_decor_layer);
        this.Ys = (LinearLayout) this.Yq.findViewById(d.g.body_root);
        this.mBottomLine = this.Yq.findViewById(d.g.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.Yt = aVar.YG;
        this.Yu = aVar.YH;
        this.Yv = aVar.YI;
        this.Yw = aVar.YJ;
        this.Yx = aVar.Yx;
        this.Yz = aVar.Yz;
        this.Yq.setParent(viewGroup);
        this.Yq.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.x.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        x.this.YE.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        x.this.YE.setExtraData(false);
                        break;
                }
                x.this.b(x.this.YE);
                return false;
            }
        });
    }

    public View getView() {
        return this.Yq;
    }

    private void initUI() {
        if (this.Yz != null) {
            if (this.Ys.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.Ys.getLayoutParams()).setMargins(this.Yz.YT, this.Yz.YR, this.Yz.YU, this.Yz.YS);
                this.Ys.postInvalidate();
            }
            if (this.Yz.YN) {
                ru();
            }
            if (this.Yt != null) {
                this.Yt.a(this);
                this.Ys.addView(this.Yt.getView());
                this.Yt.rj();
            }
            if (this.Yu != null) {
                this.Yu.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.Yz.YO;
                this.Ys.addView(this.Yu.getView(), layoutParams);
                this.Yu.rj();
            }
            if (this.Yv != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Yv.size()) {
                        break;
                    }
                    f fVar = this.Yv.get(i2);
                    if (fVar != null) {
                        fVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = fVar.getTopMargin();
                        this.Ys.addView(fVar.getView(), layoutParams2);
                        fVar.rj();
                    }
                    i = i2 + 1;
                }
            }
            if (this.Yw != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.Yz.YQ;
                this.Yw.a(this);
                this.Ys.addView(this.Yw.getView(), layoutParams3);
                this.Yw.rj();
            }
            if (!com.baidu.tbadk.core.util.v.T(this.Yx)) {
                Iterator<c> it = this.Yx.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.getDecorView() != null) {
                        if (next.rl() == null) {
                            this.Yr.addView(next.getDecorView(), next.rn());
                        } else {
                            this.Yr.addView(next.getDecorView(), next.rn(), next.rl());
                        }
                        next.b(this);
                        next.rj();
                    }
                }
            }
        }
    }

    public void bx(int i) {
        this.YD = i;
    }

    public int rt() {
        return this.YD;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.getDecorView() != null) {
            this.Yx.remove(cVar);
            if (cVar.getDecorView().getParent() != null) {
                ((ViewGroup) cVar.getDecorView().getParent()).removeView(cVar.getDecorView());
                cVar.rm();
                cVar.b(null);
            }
            if (cVar.rl() == null) {
                this.Yr.addView(cVar.getDecorView(), cVar.rn());
            } else {
                this.Yr.addView(cVar.getDecorView(), cVar.rn(), cVar.rl());
            }
            cVar.b(this);
            cVar.rj();
            this.Yx.add(cVar);
        }
    }

    private void ru() {
        c cVar = new c();
        cVar.I(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.h(this.context, d.e.ds180), com.baidu.adp.lib.util.l.h(this.context, d.e.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.Yz.YR;
        layoutParams.rightMargin = -this.Yz.YU;
        cVar.a(layoutParams);
        cVar.bw(-1);
        this.Yx.add(cVar);
    }

    public void b(T t) {
        this.Xy = t;
        if (this.Yt != null) {
            this.Yt.C(t);
        }
        if (this.Yu != null) {
            this.Yu.C(t);
        }
        if (!com.baidu.tbadk.core.util.v.T(this.Yv)) {
            for (f fVar : this.Yv) {
                fVar.C(t);
            }
        }
        if (this.Yw != null) {
            this.Yw.C(t);
        }
        if (this.Yp != null) {
            this.Yp.C(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.YC.c(i, bVar);
    }

    public boolean b(a.C0039a c0039a) {
        return this.YC.b(c0039a);
    }

    public void setPosition(int i) {
        if (this.Yq != null) {
            this.Yq.setPosition(i);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        al.k(this.Yq, this.Yz.YV);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(this.mBottomLine, d.C0277d.cp_bg_line_e);
            if (this.Yt != null) {
                this.Yt.onChangeSkinType(tbPageContext, i);
            }
            if (this.Yu != null) {
                this.Yu.onChangeSkinType(tbPageContext, i);
            }
            for (f fVar : this.Yv) {
                if (fVar != null) {
                    fVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.Yw != null) {
                this.Yw.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.T(this.Yx)) {
                Iterator<c> it = this.Yx.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof j)) {
                        ((j) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.Yy != null) {
                this.Yy.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.Yt != null) {
            this.Yt.b(abVar);
        }
        if (this.Yu != null) {
            this.Yu.b(abVar);
        }
        for (f fVar : this.Yv) {
            if (fVar != null) {
                fVar.b(abVar);
            }
        }
        if (this.Yw != null) {
            this.Yw.b(abVar);
        }
        this.YB = abVar;
    }

    public void b(int i, a.b bVar) {
        this.YC.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.YA = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private b YG;
        private b YH;
        private List<f> YI;
        private b YJ;
        private ArrayList<c> Yx;
        private y Yz;
        private Context context;

        public a(Context context, boolean z) {
            this.YG = null;
            this.YH = null;
            this.YJ = null;
            this.context = context;
            this.Yx = new ArrayList<>();
            this.Yz = new y();
            if (!z) {
                this.Yz.by(0);
            }
            this.YI = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a c(d dVar) {
            this.YG = dVar;
            return this;
        }

        public a a(b bVar) {
            this.YJ = bVar;
            return this;
        }

        public a a(f fVar) {
            this.YI.add(fVar);
            return this;
        }

        public a b(b bVar) {
            this.YH = bVar;
            return this;
        }

        public x rw() {
            return new x(this);
        }

        public x a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new x(this, z, viewGroup, rVar);
        }

        public y rv() {
            return this.Yz;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public y rv() {
        return this.Yz;
    }
}
