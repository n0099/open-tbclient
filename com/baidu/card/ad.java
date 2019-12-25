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
/* loaded from: classes5.dex */
public class ad<T extends com.baidu.tbadk.core.data.a> implements n, com.baidu.tieba.a.e {
    private T JB;
    private m<T> KP;
    private ThreadCardView KQ;
    private RelativeLayout KR;
    private LinearLayout KS;
    private b<T> KT;
    private b<T> KU;
    private List<h> KV;
    private b<T> KW;
    private ArrayList<d> KX;
    private n KY;
    private ae KZ;
    private String La;
    private com.baidu.tieba.card.z<T> Lb;
    private com.baidu.card.a.a Lc;
    private int Le;
    private a.C0050a Lf;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> mM() {
        return this.KU;
    }

    public b<T> mN() {
        return this.KW;
    }

    public List<h> mO() {
        return this.KV;
    }

    private ad(a aVar) {
        this(aVar, true);
    }

    private ad(a aVar, boolean z) {
        this(aVar, z, null);
    }

    private ad(a aVar, boolean z, ViewGroup viewGroup) {
        this(aVar, z, viewGroup, null);
    }

    private ad(a aVar, boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
        this.mSkinType = 3;
        this.KP = null;
        this.KY = null;
        this.Lc = new com.baidu.card.a.a();
        this.Le = 0;
        this.Lf = new a.C0050a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.KQ = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.KR = (RelativeLayout) this.KQ.findViewById(R.id.card_decor_layer);
        this.KS = (LinearLayout) this.KQ.findViewById(R.id.body_root);
        this.mBottomLine = this.KQ.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.KT = aVar.Lh;
        this.KU = aVar.Li;
        this.KV = aVar.Lj;
        this.KW = aVar.Lk;
        this.KX = aVar.KX;
        this.KZ = aVar.KZ;
        this.KQ.setParent(viewGroup);
        this.KQ.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ad.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ad.this.Lf.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ad.this.Lf.setExtraData(false);
                        break;
                }
                ad.this.b(ad.this.Lf);
                return false;
            }
        });
    }

    public View getView() {
        return this.KQ;
    }

    private void initUI() {
        if (this.KZ != null) {
            if (this.KS.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.KS.getLayoutParams()).setMargins(this.KZ.Lu, this.KZ.Ls, this.KZ.Lv, this.KZ.Lt);
                this.KS.postInvalidate();
            }
            if (this.KZ.Lo) {
                mQ();
            }
            if (this.KT != null) {
                this.KT.a(this);
                this.KS.addView(this.KT.getView());
                this.KT.mD();
            }
            if (this.KU != null) {
                this.KU.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.KZ.Lp;
                if (this.KV != null) {
                    layoutParams.bottomMargin = this.KZ.Lq;
                }
                if (this.KU.mF().booleanValue()) {
                    layoutParams.leftMargin = -this.KZ.Lu;
                    layoutParams.rightMargin = -this.KZ.Lv;
                }
                this.KS.addView(this.KU.getView(), layoutParams);
                this.KU.mD();
            }
            if (this.KV != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.KV.size()) {
                        break;
                    }
                    h hVar = this.KV.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        if (hVar.mF().booleanValue()) {
                            layoutParams2.leftMargin = -this.KZ.Lu;
                            layoutParams2.rightMargin = -this.KZ.Lv;
                        }
                        this.KS.addView(hVar.getView(), layoutParams2);
                        hVar.mD();
                    }
                    i = i2 + 1;
                }
            }
            if (this.KW != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.KZ.Lr;
                this.KW.a(this);
                this.KS.addView(this.KW.getView(), layoutParams3);
                this.KW.mD();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.KX)) {
                Iterator<d> it = this.KX.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.mJ() != null) {
                        if (next.mG() == null) {
                            this.KR.addView(next.mJ(), next.mI());
                        } else {
                            this.KR.addView(next.mJ(), next.mI(), next.mG());
                        }
                        next.b(this);
                        next.mD();
                    }
                }
            }
        }
    }

    public void aM(int i) {
        this.Le = i;
    }

    public int mP() {
        return this.Le;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.mJ() != null) {
            this.KX.remove(dVar);
            if (dVar.mJ().getParent() != null) {
                ((ViewGroup) dVar.mJ().getParent()).removeView(dVar.mJ());
                dVar.mH();
                dVar.b(null);
            }
            if (dVar.mG() == null) {
                this.KR.addView(dVar.mJ(), dVar.mI());
            } else {
                this.KR.addView(dVar.mJ(), dVar.mI(), dVar.mG());
            }
            dVar.b(this);
            dVar.mD();
            this.KX.add(dVar);
        }
    }

    private void mQ() {
        d dVar = new d();
        dVar.F(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.KZ.Ls;
        layoutParams.rightMargin = -this.KZ.Lv;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.KX.add(dVar);
    }

    public void c(T t) {
        this.JB = t;
        if (this.KT != null) {
            this.KT.A(t);
        }
        if (this.KU != null) {
            this.KU.A(t);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.KV)) {
            for (h hVar : this.KV) {
                hVar.A(t);
            }
        }
        if (this.KW != null) {
            this.KW.A(t);
        }
        if (this.KP != null) {
            this.KP.A(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.Lc.c(i, bVar);
    }

    public boolean b(a.C0050a c0050a) {
        return this.Lc.b(c0050a);
    }

    public void setPosition(int i) {
        if (this.KQ != null) {
            this.KQ.setPosition(i);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.KQ, this.KZ.Lw);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            if (this.KT != null) {
                this.KT.onChangeSkinType(tbPageContext, i);
            }
            if (this.KU != null) {
                this.KU.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.KV) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.KW != null) {
                this.KW.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.KX)) {
                Iterator<d> it = this.KX.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof n)) {
                        ((n) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.KY != null) {
                this.KY.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.z<T> zVar) {
        if (this.KT != null) {
            this.KT.setOnCardSubClickListener(zVar);
        }
        if (this.KU != null) {
            this.KU.setOnCardSubClickListener(zVar);
        }
        for (h hVar : this.KV) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(zVar);
            }
        }
        if (this.KW != null) {
            this.KW.setOnCardSubClickListener(zVar);
        }
        this.Lb = zVar;
    }

    public void b(int i, a.b bVar) {
        this.Lc.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.La = str;
    }

    /* loaded from: classes5.dex */
    public static class a {
        private ArrayList<d> KX;
        private ae KZ;
        private b Lh;
        private b Li;
        private List<h> Lj;
        private b Lk;
        private Context context;

        public a(Context context, boolean z) {
            this.Lh = null;
            this.Li = null;
            this.Lk = null;
            this.context = context;
            this.KX = new ArrayList<>();
            this.KZ = new ae();
            if (!z) {
                this.KZ.aQ(0);
            }
            this.Lj = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.Lh = bVar;
            return this;
        }

        public a b(b bVar) {
            this.Lk = bVar;
            return this;
        }

        public a a(h hVar) {
            this.Lj.add(hVar);
            return this;
        }

        public a c(b bVar) {
            this.Li = bVar;
            return this;
        }

        public ad mS() {
            return new ad(this);
        }

        public ad a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new ad(this, z, viewGroup, rVar);
        }

        public ae mR() {
            return this.KZ;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public ae mR() {
        return this.KZ;
    }
}
