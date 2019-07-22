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
    private T VJ;
    private i<T> WC;
    private ThreadCardView WD;
    private RelativeLayout WE;
    private LinearLayout WF;
    private b<T> WG;
    private b<T> WH;
    private List<f> WI;
    private b<T> WJ;
    private ArrayList<c> WK;
    private j WL;
    private y WM;
    private String WN;
    private com.baidu.tieba.card.ab<T> WO;
    private com.baidu.card.a.a WP;
    private int WQ;
    private a.C0038a WR;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> qI() {
        return this.WH;
    }

    public b<T> qJ() {
        return this.WJ;
    }

    public List<f> qK() {
        return this.WI;
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
        this.WC = null;
        this.WL = null;
        this.WP = new com.baidu.card.a.a();
        this.WQ = 0;
        this.WR = new a.C0038a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.WD = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.WE = (RelativeLayout) this.WD.findViewById(R.id.card_decor_layer);
        this.WF = (LinearLayout) this.WD.findViewById(R.id.body_root);
        this.mBottomLine = this.WD.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.WG = aVar.WT;
        this.WH = aVar.WU;
        this.WI = aVar.WV;
        this.WJ = aVar.WW;
        this.WK = aVar.WK;
        this.WM = aVar.WM;
        this.WD.setParent(viewGroup);
        this.WD.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.x.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        x.this.WR.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        x.this.WR.setExtraData(false);
                        break;
                }
                x.this.b(x.this.WR);
                return false;
            }
        });
    }

    public View getView() {
        return this.WD;
    }

    private void initUI() {
        if (this.WM != null) {
            if (this.WF.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.WF.getLayoutParams()).setMargins(this.WM.Xg, this.WM.Xe, this.WM.Xh, this.WM.Xf);
                this.WF.postInvalidate();
            }
            if (this.WM.Xa) {
                qM();
            }
            if (this.WG != null) {
                this.WG.a(this);
                this.WF.addView(this.WG.getView());
                this.WG.qA();
            }
            if (this.WH != null) {
                this.WH.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.WM.Xb;
                this.WF.addView(this.WH.getView(), layoutParams);
                this.WH.qA();
            }
            if (this.WI != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.WI.size()) {
                        break;
                    }
                    f fVar = this.WI.get(i2);
                    if (fVar != null) {
                        fVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = fVar.getTopMargin();
                        this.WF.addView(fVar.getView(), layoutParams2);
                        fVar.qA();
                    }
                    i = i2 + 1;
                }
            }
            if (this.WJ != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.WM.Xd;
                this.WJ.a(this);
                this.WF.addView(this.WJ.getView(), layoutParams3);
                this.WJ.qA();
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.WK)) {
                Iterator<c> it = this.WK.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.qF() != null) {
                        if (next.qC() == null) {
                            this.WE.addView(next.qF(), next.qE());
                        } else {
                            this.WE.addView(next.qF(), next.qE(), next.qC());
                        }
                        next.b(this);
                        next.qA();
                    }
                }
            }
        }
    }

    public void bq(int i) {
        this.WQ = i;
    }

    public int qL() {
        return this.WQ;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.qF() != null) {
            this.WK.remove(cVar);
            if (cVar.qF().getParent() != null) {
                ((ViewGroup) cVar.qF().getParent()).removeView(cVar.qF());
                cVar.qD();
                cVar.b(null);
            }
            if (cVar.qC() == null) {
                this.WE.addView(cVar.qF(), cVar.qE());
            } else {
                this.WE.addView(cVar.qF(), cVar.qE(), cVar.qC());
            }
            cVar.b(this);
            cVar.qA();
            this.WK.add(cVar);
        }
    }

    private void qM() {
        c cVar = new c();
        cVar.K(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.g(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.g(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.WM.Xe;
        layoutParams.rightMargin = -this.WM.Xh;
        cVar.a(layoutParams);
        cVar.bp(-1);
        this.WK.add(cVar);
    }

    public void b(T t) {
        this.VJ = t;
        if (this.WG != null) {
            this.WG.C(t);
        }
        if (this.WH != null) {
            this.WH.C(t);
        }
        if (!com.baidu.tbadk.core.util.v.aa(this.WI)) {
            for (f fVar : this.WI) {
                fVar.C(t);
            }
        }
        if (this.WJ != null) {
            this.WJ.C(t);
        }
        if (this.WC != null) {
            this.WC.C(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.WP.c(i, bVar);
    }

    public boolean b(a.C0038a c0038a) {
        return this.WP.b(c0038a);
    }

    public void setPosition(int i) {
        if (this.WD != null) {
            this.WD.setPosition(i);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.k(this.WD, this.WM.Xi);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.k(this.mBottomLine, R.color.cp_bg_line_e);
            if (this.WG != null) {
                this.WG.onChangeSkinType(tbPageContext, i);
            }
            if (this.WH != null) {
                this.WH.onChangeSkinType(tbPageContext, i);
            }
            for (f fVar : this.WI) {
                if (fVar != null) {
                    fVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.WJ != null) {
                this.WJ.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.aa(this.WK)) {
                Iterator<c> it = this.WK.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof j)) {
                        ((j) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.WL != null) {
                this.WL.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.WG != null) {
            this.WG.b(abVar);
        }
        if (this.WH != null) {
            this.WH.b(abVar);
        }
        for (f fVar : this.WI) {
            if (fVar != null) {
                fVar.b(abVar);
            }
        }
        if (this.WJ != null) {
            this.WJ.b(abVar);
        }
        this.WO = abVar;
    }

    public void b(int i, a.b bVar) {
        this.WP.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.WN = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private ArrayList<c> WK;
        private y WM;
        private b WT;
        private b WU;
        private List<f> WV;
        private b WW;
        private Context context;

        public a(Context context, boolean z) {
            this.WT = null;
            this.WU = null;
            this.WW = null;
            this.context = context;
            this.WK = new ArrayList<>();
            this.WM = new y();
            if (!z) {
                this.WM.bs(0);
            }
            this.WV = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a c(d dVar) {
            this.WT = dVar;
            return this;
        }

        public a a(b bVar) {
            this.WW = bVar;
            return this;
        }

        public a a(f fVar) {
            this.WV.add(fVar);
            return this;
        }

        public a b(b bVar) {
            this.WU = bVar;
            return this;
        }

        public x qO() {
            return new x(this);
        }

        public x a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new x(this, z, viewGroup, rVar);
        }

        public y qN() {
            return this.WM;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public y qN() {
        return this.WM;
    }
}
