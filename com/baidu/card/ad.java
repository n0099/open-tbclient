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
/* loaded from: classes8.dex */
public class ad<T extends com.baidu.tbadk.core.data.a> implements n, com.baidu.tieba.a.e {
    private T Kc;
    private n LA;
    private ae LB;
    private String LC;
    private com.baidu.tieba.card.z<T> LD;
    private com.baidu.card.a.a LH;
    private int LI;
    private a.C0052a LJ;
    private m<T> Lr;
    private ThreadCardView Ls;
    private RelativeLayout Lt;
    private LinearLayout Lu;
    private b<T> Lv;
    private b<T> Lw;
    private List<h> Lx;
    private b<T> Ly;
    private ArrayList<d> Lz;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> nd() {
        return this.Lw;
    }

    public b<T> ne() {
        return this.Ly;
    }

    public List<h> nf() {
        return this.Lx;
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
        this.Lr = null;
        this.LA = null;
        this.LH = new com.baidu.card.a.a();
        this.LI = 0;
        this.LJ = new a.C0052a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.Ls = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.Lt = (RelativeLayout) this.Ls.findViewById(R.id.card_decor_layer);
        this.Lu = (LinearLayout) this.Ls.findViewById(R.id.body_root);
        this.mBottomLine = this.Ls.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.Lv = aVar.LM;
        this.Lw = aVar.LN;
        this.Lx = aVar.LO;
        this.Ly = aVar.LQ;
        this.Lz = aVar.Lz;
        this.LB = aVar.LB;
        this.Ls.setParent(viewGroup);
        this.Ls.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ad.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ad.this.LJ.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ad.this.LJ.setExtraData(false);
                        break;
                }
                ad.this.b(ad.this.LJ);
                return false;
            }
        });
    }

    public View getView() {
        return this.Ls;
    }

    private void initUI() {
        if (this.LB != null) {
            if (this.Lu.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.Lu.getLayoutParams()).setMargins(this.LB.Mb, this.LB.LZ, this.LB.Mc, this.LB.Ma);
                this.Lu.postInvalidate();
            }
            if (this.LB.LV) {
                nh();
            }
            if (this.Lv != null) {
                this.Lv.a(this);
                this.Lu.addView(this.Lv.getView());
                this.Lv.mS();
            }
            if (this.Lw != null) {
                this.Lw.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.LB.LW;
                if (this.Lx != null) {
                    layoutParams.bottomMargin = this.LB.LX;
                }
                if (this.Lw.mU().booleanValue()) {
                    layoutParams.leftMargin = -this.LB.Mb;
                    layoutParams.rightMargin = -this.LB.Mc;
                }
                this.Lu.addView(this.Lw.getView(), layoutParams);
                this.Lw.mS();
            }
            if (this.Lx != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Lx.size()) {
                        break;
                    }
                    h hVar = this.Lx.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.na();
                        if (hVar.mU().booleanValue()) {
                            layoutParams2.leftMargin = -this.LB.Mb;
                            layoutParams2.rightMargin = -this.LB.Mc;
                        }
                        this.Lu.addView(hVar.getView(), layoutParams2);
                        hVar.mS();
                    }
                    i = i2 + 1;
                }
            }
            if (this.Ly != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.LB.LY;
                this.Ly.a(this);
                this.Lu.addView(this.Ly.getView(), layoutParams3);
                this.Ly.mS();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.Lz)) {
                Iterator<d> it = this.Lz.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.mY() != null) {
                        if (next.mV() == null) {
                            this.Lt.addView(next.mY(), next.mX());
                        } else {
                            this.Lt.addView(next.mY(), next.mX(), next.mV());
                        }
                        next.b(this);
                        next.mS();
                    }
                }
            }
        }
    }

    public void aQ(int i) {
        this.LI = i;
    }

    public int ng() {
        return this.LI;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.mY() != null) {
            this.Lz.remove(dVar);
            if (dVar.mY().getParent() != null) {
                ((ViewGroup) dVar.mY().getParent()).removeView(dVar.mY());
                dVar.mW();
                dVar.b(null);
            }
            if (dVar.mV() == null) {
                this.Lt.addView(dVar.mY(), dVar.mX());
            } else {
                this.Lt.addView(dVar.mY(), dVar.mX(), dVar.mV());
            }
            dVar.b(this);
            dVar.mS();
            this.Lz.add(dVar);
        }
    }

    private void nh() {
        d dVar = new d();
        dVar.F(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.LB.LZ;
        layoutParams.rightMargin = -this.LB.Mc;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.Lz.add(dVar);
    }

    public void c(T t) {
        this.Kc = t;
        if (this.Lv != null) {
            this.Lv.A(t);
        }
        if (this.Lw != null) {
            this.Lw.A(t);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.Lx)) {
            for (h hVar : this.Lx) {
                hVar.A(t);
            }
        }
        if (this.Ly != null) {
            this.Ly.A(t);
        }
        if (this.Lr != null) {
            this.Lr.A(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.LH.c(i, bVar);
    }

    public boolean b(a.C0052a c0052a) {
        return this.LH.b(c0052a);
    }

    public void setPosition(int i) {
        if (this.Ls != null) {
            this.Ls.setPosition(i);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.Ls, this.LB.Me);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            if (this.Lv != null) {
                this.Lv.onChangeSkinType(tbPageContext, i);
            }
            if (this.Lw != null) {
                this.Lw.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.Lx) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.Ly != null) {
                this.Ly.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.Lz)) {
                Iterator<d> it = this.Lz.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof n)) {
                        ((n) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.LA != null) {
                this.LA.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.z<T> zVar) {
        if (this.Lv != null) {
            this.Lv.setOnCardSubClickListener(zVar);
        }
        if (this.Lw != null) {
            this.Lw.setOnCardSubClickListener(zVar);
        }
        for (h hVar : this.Lx) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(zVar);
            }
        }
        if (this.Ly != null) {
            this.Ly.setOnCardSubClickListener(zVar);
        }
        this.LD = zVar;
    }

    public void b(int i, a.b bVar) {
        this.LH.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.LC = str;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private ae LB;
        private b LM;
        private b LN;
        private List<h> LO;
        private b LQ;
        private ArrayList<d> Lz;
        private Context context;

        public a(Context context, boolean z) {
            this.LM = null;
            this.LN = null;
            this.LQ = null;
            this.context = context;
            this.Lz = new ArrayList<>();
            this.LB = new ae();
            if (!z) {
                this.LB.aU(0);
            }
            this.LO = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.LM = bVar;
            return this;
        }

        public a b(b bVar) {
            this.LQ = bVar;
            return this;
        }

        public a a(h hVar) {
            this.LO.add(hVar);
            return this;
        }

        public a c(b bVar) {
            this.LN = bVar;
            return this;
        }

        public ad nj() {
            return new ad(this);
        }

        public ad a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new ad(this, z, viewGroup, rVar);
        }

        public ae ni() {
            return this.LB;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public ae ni() {
        return this.LB;
    }
}
