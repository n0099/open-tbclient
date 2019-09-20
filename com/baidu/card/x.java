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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class x<T extends com.baidu.tbadk.core.data.a> implements j, com.baidu.tieba.a.e {
    private T VI;
    private i<T> WB;
    private ThreadCardView WC;
    private RelativeLayout WD;
    private LinearLayout WE;
    private b<T> WF;
    private b<T> WG;
    private List<f> WH;
    private b<T> WI;
    private ArrayList<c> WJ;
    private j WK;
    private y WL;
    private String WM;
    private com.baidu.tieba.card.ab<T> WN;
    private com.baidu.card.a.a WO;
    private int WP;
    private a.C0038a WQ;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> qJ() {
        return this.WG;
    }

    public b<T> qK() {
        return this.WI;
    }

    public List<f> qL() {
        return this.WH;
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
        this.WB = null;
        this.WK = null;
        this.WO = new com.baidu.card.a.a();
        this.WP = 0;
        this.WQ = new a.C0038a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.WC = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.WD = (RelativeLayout) this.WC.findViewById(R.id.card_decor_layer);
        this.WE = (LinearLayout) this.WC.findViewById(R.id.body_root);
        this.mBottomLine = this.WC.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.WF = aVar.WS;
        this.WG = aVar.WT;
        this.WH = aVar.WU;
        this.WI = aVar.WV;
        this.WJ = aVar.WJ;
        this.WL = aVar.WL;
        this.WC.setParent(viewGroup);
        this.WC.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.x.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        x.this.WQ.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        x.this.WQ.setExtraData(false);
                        break;
                }
                x.this.b(x.this.WQ);
                return false;
            }
        });
    }

    public View getView() {
        return this.WC;
    }

    private void initUI() {
        if (this.WL != null) {
            if (this.WE.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.WE.getLayoutParams()).setMargins(this.WL.Xf, this.WL.Xd, this.WL.Xg, this.WL.Xe);
                this.WE.postInvalidate();
            }
            if (this.WL.WZ) {
                qN();
            }
            if (this.WF != null) {
                this.WF.a(this);
                this.WE.addView(this.WF.getView());
                this.WF.qB();
            }
            if (this.WG != null) {
                this.WG.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.WL.Xa;
                this.WE.addView(this.WG.getView(), layoutParams);
                this.WG.qB();
            }
            if (this.WH != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.WH.size()) {
                        break;
                    }
                    f fVar = this.WH.get(i2);
                    if (fVar != null) {
                        fVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = fVar.getTopMargin();
                        this.WE.addView(fVar.getView(), layoutParams2);
                        fVar.qB();
                    }
                    i = i2 + 1;
                }
            }
            if (this.WI != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.WL.Xc;
                this.WI.a(this);
                this.WE.addView(this.WI.getView(), layoutParams3);
                this.WI.qB();
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.WJ)) {
                Iterator<c> it = this.WJ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.qG() != null) {
                        if (next.qD() == null) {
                            this.WD.addView(next.qG(), next.qF());
                        } else {
                            this.WD.addView(next.qG(), next.qF(), next.qD());
                        }
                        next.b(this);
                        next.qB();
                    }
                }
            }
        }
    }

    public void bq(int i) {
        this.WP = i;
    }

    public int qM() {
        return this.WP;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.qG() != null) {
            this.WJ.remove(cVar);
            if (cVar.qG().getParent() != null) {
                ((ViewGroup) cVar.qG().getParent()).removeView(cVar.qG());
                cVar.qE();
                cVar.b(null);
            }
            if (cVar.qD() == null) {
                this.WD.addView(cVar.qG(), cVar.qF());
            } else {
                this.WD.addView(cVar.qG(), cVar.qF(), cVar.qD());
            }
            cVar.b(this);
            cVar.qB();
            this.WJ.add(cVar);
        }
    }

    private void qN() {
        c cVar = new c();
        cVar.K(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.g(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.g(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.WL.Xd;
        layoutParams.rightMargin = -this.WL.Xg;
        cVar.a(layoutParams);
        cVar.bp(-1);
        this.WJ.add(cVar);
    }

    public void b(T t) {
        this.VI = t;
        if (this.WF != null) {
            this.WF.C(t);
        }
        if (this.WG != null) {
            this.WG.C(t);
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.WH)) {
            for (f fVar : this.WH) {
                fVar.C(t);
            }
        }
        if (this.WI != null) {
            this.WI.C(t);
        }
        if (this.WB != null) {
            this.WB.C(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.WO.c(i, bVar);
    }

    public boolean b(a.C0038a c0038a) {
        return this.WO.b(c0038a);
    }

    public void setPosition(int i) {
        if (this.WC != null) {
            this.WC.setPosition(i);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.k(this.WC, this.WL.Xh);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.k(this.mBottomLine, R.color.cp_bg_line_c);
            if (this.WF != null) {
                this.WF.onChangeSkinType(tbPageContext, i);
            }
            if (this.WG != null) {
                this.WG.onChangeSkinType(tbPageContext, i);
            }
            for (f fVar : this.WH) {
                if (fVar != null) {
                    fVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.WI != null) {
                this.WI.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.WJ)) {
                Iterator<c> it = this.WJ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof j)) {
                        ((j) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.WK != null) {
                this.WK.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.WF != null) {
            this.WF.b(abVar);
        }
        if (this.WG != null) {
            this.WG.b(abVar);
        }
        for (f fVar : this.WH) {
            if (fVar != null) {
                fVar.b(abVar);
            }
        }
        if (this.WI != null) {
            this.WI.b(abVar);
        }
        this.WN = abVar;
    }

    public void b(int i, a.b bVar) {
        this.WO.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WM = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private ArrayList<c> WJ;
        private y WL;
        private b WS;
        private b WT;
        private List<f> WU;
        private b WV;
        private Context context;

        public a(Context context, boolean z) {
            this.WS = null;
            this.WT = null;
            this.WV = null;
            this.context = context;
            this.WJ = new ArrayList<>();
            this.WL = new y();
            if (!z) {
                this.WL.bs(0);
            }
            this.WU = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a c(d dVar) {
            this.WS = dVar;
            return this;
        }

        public a a(b bVar) {
            this.WV = bVar;
            return this;
        }

        public a a(f fVar) {
            this.WU.add(fVar);
            return this;
        }

        public a b(b bVar) {
            this.WT = bVar;
            return this;
        }

        public x qP() {
            return new x(this);
        }

        public x a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new x(this, z, viewGroup, rVar);
        }

        public y qO() {
            return this.WL;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public y qO() {
        return this.WL;
    }
}
