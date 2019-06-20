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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class x<T extends com.baidu.tbadk.core.data.a> implements j, com.baidu.tieba.a.e {
    private T Vp;
    private i<T> Wh;
    private ThreadCardView Wi;
    private RelativeLayout Wj;
    private LinearLayout Wk;
    private b<T> Wl;
    private b<T> Wm;
    private List<f> Wn;
    private b<T> Wo;
    private ArrayList<c> Wp;
    private j Wq;
    private y Wr;
    private String Ws;
    private com.baidu.tieba.card.ab<T> Wt;
    private com.baidu.card.a.a Wu;
    private int Wv;
    private a.C0038a Ww;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> ql() {
        return this.Wm;
    }

    public b<T> qm() {
        return this.Wo;
    }

    public List<f> qn() {
        return this.Wn;
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
        this.Wh = null;
        this.Wq = null;
        this.Wu = new com.baidu.card.a.a();
        this.Wv = 0;
        this.Ww = new a.C0038a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.Wi = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.Wj = (RelativeLayout) this.Wi.findViewById(R.id.card_decor_layer);
        this.Wk = (LinearLayout) this.Wi.findViewById(R.id.body_root);
        this.mBottomLine = this.Wi.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.Wl = aVar.Wy;
        this.Wm = aVar.Wz;
        this.Wn = aVar.WA;
        this.Wo = aVar.WB;
        this.Wp = aVar.Wp;
        this.Wr = aVar.Wr;
        this.Wi.setParent(viewGroup);
        this.Wi.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.x.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        x.this.Ww.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        x.this.Ww.setExtraData(false);
                        break;
                }
                x.this.b(x.this.Ww);
                return false;
            }
        });
    }

    public View getView() {
        return this.Wi;
    }

    private void initUI() {
        if (this.Wr != null) {
            if (this.Wk.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.Wk.getLayoutParams()).setMargins(this.Wr.WL, this.Wr.WJ, this.Wr.WM, this.Wr.WK);
                this.Wk.postInvalidate();
            }
            if (this.Wr.WF) {
                qp();
            }
            if (this.Wl != null) {
                this.Wl.a(this);
                this.Wk.addView(this.Wl.getView());
                this.Wl.qe();
            }
            if (this.Wm != null) {
                this.Wm.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.Wr.WG;
                this.Wk.addView(this.Wm.getView(), layoutParams);
                this.Wm.qe();
            }
            if (this.Wn != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Wn.size()) {
                        break;
                    }
                    f fVar = this.Wn.get(i2);
                    if (fVar != null) {
                        fVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = fVar.getTopMargin();
                        this.Wk.addView(fVar.getView(), layoutParams2);
                        fVar.qe();
                    }
                    i = i2 + 1;
                }
            }
            if (this.Wo != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.Wr.WI;
                this.Wo.a(this);
                this.Wk.addView(this.Wo.getView(), layoutParams3);
                this.Wo.qe();
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.Wp)) {
                Iterator<c> it = this.Wp.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.getDecorView() != null) {
                        if (next.qg() == null) {
                            this.Wj.addView(next.getDecorView(), next.qi());
                        } else {
                            this.Wj.addView(next.getDecorView(), next.qi(), next.qg());
                        }
                        next.b(this);
                        next.qe();
                    }
                }
            }
        }
    }

    public void bq(int i) {
        this.Wv = i;
    }

    public int qo() {
        return this.Wv;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.getDecorView() != null) {
            this.Wp.remove(cVar);
            if (cVar.getDecorView().getParent() != null) {
                ((ViewGroup) cVar.getDecorView().getParent()).removeView(cVar.getDecorView());
                cVar.qh();
                cVar.b(null);
            }
            if (cVar.qg() == null) {
                this.Wj.addView(cVar.getDecorView(), cVar.qi());
            } else {
                this.Wj.addView(cVar.getDecorView(), cVar.qi(), cVar.qg());
            }
            cVar.b(this);
            cVar.qe();
            this.Wp.add(cVar);
        }
    }

    private void qp() {
        c cVar = new c();
        cVar.I(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.g(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.g(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.Wr.WJ;
        layoutParams.rightMargin = -this.Wr.WM;
        cVar.a(layoutParams);
        cVar.bp(-1);
        this.Wp.add(cVar);
    }

    public void b(T t) {
        this.Vp = t;
        if (this.Wl != null) {
            this.Wl.C(t);
        }
        if (this.Wm != null) {
            this.Wm.C(t);
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.Wn)) {
            for (f fVar : this.Wn) {
                fVar.C(t);
            }
        }
        if (this.Wo != null) {
            this.Wo.C(t);
        }
        if (this.Wh != null) {
            this.Wh.C(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.Wu.c(i, bVar);
    }

    public boolean b(a.C0038a c0038a) {
        return this.Wu.b(c0038a);
    }

    public void setPosition(int i) {
        if (this.Wi != null) {
            this.Wi.setPosition(i);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        al.k(this.Wi, this.Wr.WN);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(this.mBottomLine, R.color.cp_bg_line_e);
            if (this.Wl != null) {
                this.Wl.onChangeSkinType(tbPageContext, i);
            }
            if (this.Wm != null) {
                this.Wm.onChangeSkinType(tbPageContext, i);
            }
            for (f fVar : this.Wn) {
                if (fVar != null) {
                    fVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.Wo != null) {
                this.Wo.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.Wp)) {
                Iterator<c> it = this.Wp.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof j)) {
                        ((j) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.Wq != null) {
                this.Wq.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.Wl != null) {
            this.Wl.b(abVar);
        }
        if (this.Wm != null) {
            this.Wm.b(abVar);
        }
        for (f fVar : this.Wn) {
            if (fVar != null) {
                fVar.b(abVar);
            }
        }
        if (this.Wo != null) {
            this.Wo.b(abVar);
        }
        this.Wt = abVar;
    }

    public void b(int i, a.b bVar) {
        this.Wu.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Ws = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private List<f> WA;
        private b WB;
        private ArrayList<c> Wp;
        private y Wr;
        private b Wy;
        private b Wz;
        private Context context;

        public a(Context context, boolean z) {
            this.Wy = null;
            this.Wz = null;
            this.WB = null;
            this.context = context;
            this.Wp = new ArrayList<>();
            this.Wr = new y();
            if (!z) {
                this.Wr.bs(0);
            }
            this.WA = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a c(d dVar) {
            this.Wy = dVar;
            return this;
        }

        public a a(b bVar) {
            this.WB = bVar;
            return this;
        }

        public a a(f fVar) {
            this.WA.add(fVar);
            return this;
        }

        public a b(b bVar) {
            this.Wz = bVar;
            return this;
        }

        public x qr() {
            return new x(this);
        }

        public x a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new x(this, z, viewGroup, rVar);
        }

        public y qq() {
            return this.Wr;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public y qq() {
        return this.Wr;
    }
}
