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
    private T Vq;
    private i<T> Wi;
    private ThreadCardView Wj;
    private RelativeLayout Wk;
    private LinearLayout Wl;
    private b<T> Wm;
    private b<T> Wn;
    private List<f> Wo;
    private b<T> Wp;
    private ArrayList<c> Wq;
    private j Wr;
    private y Ws;
    private String Wt;
    private com.baidu.tieba.card.ab<T> Wu;
    private com.baidu.card.a.a Wv;
    private int Ww;
    private a.C0038a Wx;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> ql() {
        return this.Wn;
    }

    public b<T> qm() {
        return this.Wp;
    }

    public List<f> qn() {
        return this.Wo;
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
        this.Wi = null;
        this.Wr = null;
        this.Wv = new com.baidu.card.a.a();
        this.Ww = 0;
        this.Wx = new a.C0038a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.Wj = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.Wk = (RelativeLayout) this.Wj.findViewById(R.id.card_decor_layer);
        this.Wl = (LinearLayout) this.Wj.findViewById(R.id.body_root);
        this.mBottomLine = this.Wj.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.Wm = aVar.Wz;
        this.Wn = aVar.WA;
        this.Wo = aVar.WB;
        this.Wp = aVar.WC;
        this.Wq = aVar.Wq;
        this.Ws = aVar.Ws;
        this.Wj.setParent(viewGroup);
        this.Wj.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.x.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        x.this.Wx.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        x.this.Wx.setExtraData(false);
                        break;
                }
                x.this.b(x.this.Wx);
                return false;
            }
        });
    }

    public View getView() {
        return this.Wj;
    }

    private void initUI() {
        if (this.Ws != null) {
            if (this.Wl.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.Wl.getLayoutParams()).setMargins(this.Ws.WM, this.Ws.WK, this.Ws.WN, this.Ws.WL);
                this.Wl.postInvalidate();
            }
            if (this.Ws.WG) {
                qp();
            }
            if (this.Wm != null) {
                this.Wm.a(this);
                this.Wl.addView(this.Wm.getView());
                this.Wm.qe();
            }
            if (this.Wn != null) {
                this.Wn.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.Ws.WH;
                this.Wl.addView(this.Wn.getView(), layoutParams);
                this.Wn.qe();
            }
            if (this.Wo != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Wo.size()) {
                        break;
                    }
                    f fVar = this.Wo.get(i2);
                    if (fVar != null) {
                        fVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = fVar.getTopMargin();
                        this.Wl.addView(fVar.getView(), layoutParams2);
                        fVar.qe();
                    }
                    i = i2 + 1;
                }
            }
            if (this.Wp != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.Ws.WJ;
                this.Wp.a(this);
                this.Wl.addView(this.Wp.getView(), layoutParams3);
                this.Wp.qe();
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.Wq)) {
                Iterator<c> it = this.Wq.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.getDecorView() != null) {
                        if (next.qg() == null) {
                            this.Wk.addView(next.getDecorView(), next.qi());
                        } else {
                            this.Wk.addView(next.getDecorView(), next.qi(), next.qg());
                        }
                        next.b(this);
                        next.qe();
                    }
                }
            }
        }
    }

    public void bq(int i) {
        this.Ww = i;
    }

    public int qo() {
        return this.Ww;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.getDecorView() != null) {
            this.Wq.remove(cVar);
            if (cVar.getDecorView().getParent() != null) {
                ((ViewGroup) cVar.getDecorView().getParent()).removeView(cVar.getDecorView());
                cVar.qh();
                cVar.b(null);
            }
            if (cVar.qg() == null) {
                this.Wk.addView(cVar.getDecorView(), cVar.qi());
            } else {
                this.Wk.addView(cVar.getDecorView(), cVar.qi(), cVar.qg());
            }
            cVar.b(this);
            cVar.qe();
            this.Wq.add(cVar);
        }
    }

    private void qp() {
        c cVar = new c();
        cVar.I(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.g(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.g(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.Ws.WK;
        layoutParams.rightMargin = -this.Ws.WN;
        cVar.a(layoutParams);
        cVar.bp(-1);
        this.Wq.add(cVar);
    }

    public void b(T t) {
        this.Vq = t;
        if (this.Wm != null) {
            this.Wm.C(t);
        }
        if (this.Wn != null) {
            this.Wn.C(t);
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.Wo)) {
            for (f fVar : this.Wo) {
                fVar.C(t);
            }
        }
        if (this.Wp != null) {
            this.Wp.C(t);
        }
        if (this.Wi != null) {
            this.Wi.C(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.Wv.c(i, bVar);
    }

    public boolean b(a.C0038a c0038a) {
        return this.Wv.b(c0038a);
    }

    public void setPosition(int i) {
        if (this.Wj != null) {
            this.Wj.setPosition(i);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        al.k(this.Wj, this.Ws.WO);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.k(this.mBottomLine, R.color.cp_bg_line_e);
            if (this.Wm != null) {
                this.Wm.onChangeSkinType(tbPageContext, i);
            }
            if (this.Wn != null) {
                this.Wn.onChangeSkinType(tbPageContext, i);
            }
            for (f fVar : this.Wo) {
                if (fVar != null) {
                    fVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.Wp != null) {
                this.Wp.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.Wq)) {
                Iterator<c> it = this.Wq.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof j)) {
                        ((j) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.Wr != null) {
                this.Wr.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.Wm != null) {
            this.Wm.b(abVar);
        }
        if (this.Wn != null) {
            this.Wn.b(abVar);
        }
        for (f fVar : this.Wo) {
            if (fVar != null) {
                fVar.b(abVar);
            }
        }
        if (this.Wp != null) {
            this.Wp.b(abVar);
        }
        this.Wu = abVar;
    }

    public void b(int i, a.b bVar) {
        this.Wv.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Wt = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private b WA;
        private List<f> WB;
        private b WC;
        private ArrayList<c> Wq;
        private y Ws;
        private b Wz;
        private Context context;

        public a(Context context, boolean z) {
            this.Wz = null;
            this.WA = null;
            this.WC = null;
            this.context = context;
            this.Wq = new ArrayList<>();
            this.Ws = new y();
            if (!z) {
                this.Ws.bs(0);
            }
            this.WB = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a c(d dVar) {
            this.Wz = dVar;
            return this;
        }

        public a a(b bVar) {
            this.WC = bVar;
            return this;
        }

        public a a(f fVar) {
            this.WB.add(fVar);
            return this;
        }

        public a b(b bVar) {
            this.WA = bVar;
            return this;
        }

        public x qr() {
            return new x(this);
        }

        public x a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new x(this, z, viewGroup, rVar);
        }

        public y qq() {
            return this.Ws;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public y qq() {
        return this.Ws;
    }
}
