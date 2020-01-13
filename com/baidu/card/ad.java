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
/* loaded from: classes6.dex */
public class ad<T extends com.baidu.tbadk.core.data.a> implements n, com.baidu.tieba.a.e {
    private T JH;
    private m<T> KU;
    private ThreadCardView KV;
    private RelativeLayout KW;
    private LinearLayout KX;
    private b<T> KY;
    private b<T> KZ;
    private List<h> La;
    private b<T> Lb;
    private ArrayList<d> Lc;
    private n Le;
    private ae Lf;
    private String Lg;
    private com.baidu.tieba.card.z<T> Lh;
    private com.baidu.card.a.a Li;
    private int Lj;
    private a.C0050a Lk;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> mN() {
        return this.KZ;
    }

    public b<T> mO() {
        return this.Lb;
    }

    public List<h> mP() {
        return this.La;
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
        this.KU = null;
        this.Le = null;
        this.Li = new com.baidu.card.a.a();
        this.Lj = 0;
        this.Lk = new a.C0050a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.KV = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.KW = (RelativeLayout) this.KV.findViewById(R.id.card_decor_layer);
        this.KX = (LinearLayout) this.KV.findViewById(R.id.body_root);
        this.mBottomLine = this.KV.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.KY = aVar.Lm;
        this.KZ = aVar.Ln;
        this.La = aVar.Lo;
        this.Lb = aVar.Lp;
        this.Lc = aVar.Lc;
        this.Lf = aVar.Lf;
        this.KV.setParent(viewGroup);
        this.KV.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ad.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ad.this.Lk.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ad.this.Lk.setExtraData(false);
                        break;
                }
                ad.this.b(ad.this.Lk);
                return false;
            }
        });
    }

    public View getView() {
        return this.KV;
    }

    private void initUI() {
        if (this.Lf != null) {
            if (this.KX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.KX.getLayoutParams()).setMargins(this.Lf.Lz, this.Lf.Lx, this.Lf.LA, this.Lf.Ly);
                this.KX.postInvalidate();
            }
            if (this.Lf.Lt) {
                mR();
            }
            if (this.KY != null) {
                this.KY.a(this);
                this.KX.addView(this.KY.getView());
                this.KY.mD();
            }
            if (this.KZ != null) {
                this.KZ.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.Lf.Lu;
                if (this.La != null) {
                    layoutParams.bottomMargin = this.Lf.Lv;
                }
                if (this.KZ.mF().booleanValue()) {
                    layoutParams.leftMargin = -this.Lf.Lz;
                    layoutParams.rightMargin = -this.Lf.LA;
                }
                this.KX.addView(this.KZ.getView(), layoutParams);
                this.KZ.mD();
            }
            if (this.La != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.La.size()) {
                        break;
                    }
                    h hVar = this.La.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        if (hVar.mF().booleanValue()) {
                            layoutParams2.leftMargin = -this.Lf.Lz;
                            layoutParams2.rightMargin = -this.Lf.LA;
                        }
                        this.KX.addView(hVar.getView(), layoutParams2);
                        hVar.mD();
                    }
                    i = i2 + 1;
                }
            }
            if (this.Lb != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.Lf.Lw;
                this.Lb.a(this);
                this.KX.addView(this.Lb.getView(), layoutParams3);
                this.Lb.mD();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.Lc)) {
                Iterator<d> it = this.Lc.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.mJ() != null) {
                        if (next.mG() == null) {
                            this.KW.addView(next.mJ(), next.mI());
                        } else {
                            this.KW.addView(next.mJ(), next.mI(), next.mG());
                        }
                        next.b(this);
                        next.mD();
                    }
                }
            }
        }
    }

    public void aM(int i) {
        this.Lj = i;
    }

    public int mQ() {
        return this.Lj;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.mJ() != null) {
            this.Lc.remove(dVar);
            if (dVar.mJ().getParent() != null) {
                ((ViewGroup) dVar.mJ().getParent()).removeView(dVar.mJ());
                dVar.mH();
                dVar.b(null);
            }
            if (dVar.mG() == null) {
                this.KW.addView(dVar.mJ(), dVar.mI());
            } else {
                this.KW.addView(dVar.mJ(), dVar.mI(), dVar.mG());
            }
            dVar.b(this);
            dVar.mD();
            this.Lc.add(dVar);
        }
    }

    private void mR() {
        d dVar = new d();
        dVar.F(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.Lf.Lx;
        layoutParams.rightMargin = -this.Lf.LA;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.Lc.add(dVar);
    }

    public void c(T t) {
        this.JH = t;
        if (this.KY != null) {
            this.KY.A(t);
        }
        if (this.KZ != null) {
            this.KZ.A(t);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.La)) {
            for (h hVar : this.La) {
                hVar.A(t);
            }
        }
        if (this.Lb != null) {
            this.Lb.A(t);
        }
        if (this.KU != null) {
            this.KU.A(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.Li.c(i, bVar);
    }

    public boolean b(a.C0050a c0050a) {
        return this.Li.b(c0050a);
    }

    public void setPosition(int i) {
        if (this.KV != null) {
            this.KV.setPosition(i);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.KV, this.Lf.LB);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            if (this.KY != null) {
                this.KY.onChangeSkinType(tbPageContext, i);
            }
            if (this.KZ != null) {
                this.KZ.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.La) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.Lb != null) {
                this.Lb.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.Lc)) {
                Iterator<d> it = this.Lc.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof n)) {
                        ((n) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.Le != null) {
                this.Le.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.z<T> zVar) {
        if (this.KY != null) {
            this.KY.setOnCardSubClickListener(zVar);
        }
        if (this.KZ != null) {
            this.KZ.setOnCardSubClickListener(zVar);
        }
        for (h hVar : this.La) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(zVar);
            }
        }
        if (this.Lb != null) {
            this.Lb.setOnCardSubClickListener(zVar);
        }
        this.Lh = zVar;
    }

    public void b(int i, a.b bVar) {
        this.Li.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Lg = str;
    }

    /* loaded from: classes6.dex */
    public static class a {
        private ArrayList<d> Lc;
        private ae Lf;
        private b Lm;
        private b Ln;
        private List<h> Lo;
        private b Lp;
        private Context context;

        public a(Context context, boolean z) {
            this.Lm = null;
            this.Ln = null;
            this.Lp = null;
            this.context = context;
            this.Lc = new ArrayList<>();
            this.Lf = new ae();
            if (!z) {
                this.Lf.aQ(0);
            }
            this.Lo = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.Lm = bVar;
            return this;
        }

        public a b(b bVar) {
            this.Lp = bVar;
            return this;
        }

        public a a(h hVar) {
            this.Lo.add(hVar);
            return this;
        }

        public a c(b bVar) {
            this.Ln = bVar;
            return this;
        }

        public ad mT() {
            return new ad(this);
        }

        public ad a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new ad(this, z, viewGroup, rVar);
        }

        public ae mS() {
            return this.Lf;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public ae mS() {
        return this.Lf;
    }
}
