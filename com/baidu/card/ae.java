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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ae<T extends AbsThreadDataSupport> implements o, com.baidu.tieba.a.e {
    private T adw;
    private n<T> aeM;
    private ThreadCardView aeN;
    private RelativeLayout aeO;
    private LinearLayout aeP;
    private b<T> aeQ;
    private b<T> aeR;
    private List<h> aeS;
    private b<T> aeT;
    private ArrayList<d> aeU;
    private o aeV;
    private af aeW;
    private String aeX;
    private com.baidu.tieba.card.aa<T> aeY;
    private com.baidu.card.a.a aeZ;
    private int afa;
    private a.C0097a afb;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> rF() {
        return this.aeR;
    }

    public b<T> rG() {
        return this.aeT;
    }

    public List<h> rH() {
        return this.aeS;
    }

    private ae(a aVar) {
        this(aVar, true);
    }

    private ae(a aVar, boolean z) {
        this(aVar, z, null);
    }

    private ae(a aVar, boolean z, ViewGroup viewGroup) {
        this(aVar, z, viewGroup, null);
    }

    private ae(a aVar, boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.t tVar) {
        this.mSkinType = 3;
        this.aeM = null;
        this.aeV = null;
        this.aeZ = new com.baidu.card.a.a();
        this.afa = 0;
        this.afb = new a.C0097a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.aeN = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.aeO = (RelativeLayout) this.aeN.findViewById(R.id.card_decor_layer);
        this.aeP = (LinearLayout) this.aeN.findViewById(R.id.body_root);
        this.mBottomLine = this.aeN.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.aeQ = aVar.afd;
        this.aeR = aVar.afe;
        this.aeS = aVar.aff;
        this.aeT = aVar.afg;
        this.aeU = aVar.aeU;
        this.aeW = aVar.aeW;
        this.aeN.setParent(viewGroup);
        this.aeN.setITypeListView(tVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ae.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ae.this.afb.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ae.this.afb.setExtraData(false);
                        break;
                }
                ae.this.b(ae.this.afb);
                return false;
            }
        });
    }

    public View getView() {
        return this.aeN;
    }

    private void initUI() {
        if (this.aeW != null) {
            if (this.aeP.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.aeP.getLayoutParams()).setMargins(this.aeW.afq, this.aeW.afo, this.aeW.afr, this.aeW.afp);
                this.aeP.postInvalidate();
            }
            if (this.aeW.afk) {
                rJ();
            }
            if (this.aeQ != null) {
                this.aeQ.a(this);
                this.aeP.addView(this.aeQ.getView());
                this.aeQ.rr();
            }
            if (this.aeR != null) {
                this.aeR.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.aeW.afl;
                if (this.aeS != null) {
                    layoutParams.bottomMargin = this.aeW.afm;
                }
                if (this.aeR.rt().booleanValue()) {
                    layoutParams.leftMargin = -this.aeW.afq;
                    layoutParams.rightMargin = -this.aeW.afr;
                }
                this.aeP.addView(this.aeR.getView(), layoutParams);
                this.aeR.rr();
            }
            if (this.aeS != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aeS.size()) {
                        break;
                    }
                    h hVar = this.aeS.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.rz();
                        if (hVar.rt().booleanValue()) {
                            layoutParams2.leftMargin = -this.aeW.afq;
                            layoutParams2.rightMargin = -this.aeW.afr;
                        }
                        this.aeP.addView(hVar.getView(), layoutParams2);
                        hVar.rr();
                    }
                    i = i2 + 1;
                }
            }
            if (this.aeT != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.aeW.afn;
                this.aeT.a(this);
                this.aeP.addView(this.aeT.getView(), layoutParams3);
                this.aeT.rr();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.aeU)) {
                Iterator<d> it = this.aeU.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.rx() != null) {
                        if (next.ru() == null) {
                            this.aeO.addView(next.rx(), next.rw());
                        } else {
                            this.aeO.addView(next.rx(), next.rw(), next.ru());
                        }
                        next.b(this);
                        next.rr();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.afa = i;
    }

    public int rI() {
        return this.afa;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.rx() != null) {
            this.aeU.remove(dVar);
            if (dVar.rx().getParent() != null) {
                ((ViewGroup) dVar.rx().getParent()).removeView(dVar.rx());
                dVar.rv();
                dVar.b(null);
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null && dVar.rx() != null) {
            a(dVar);
            dVar.rx().setVisibility(0);
            if (dVar.ru() == null) {
                this.aeO.addView(dVar.rx(), dVar.rw());
            } else {
                this.aeO.addView(dVar.rx(), dVar.rw(), dVar.ru());
            }
            dVar.b(this);
            dVar.rr();
            this.aeU.add(dVar);
        }
    }

    private void rJ() {
        d dVar = new d();
        dVar.F(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.aeW.afo;
        layoutParams.rightMargin = -this.aeW.afr;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.aeU.add(dVar);
    }

    public void f(T t) {
        this.adw = t;
        if (this.aeQ != null) {
            this.aeQ.D(t);
        }
        if (this.aeR != null) {
            this.aeR.D(t);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.aeS)) {
            for (h hVar : this.aeS) {
                hVar.D(t);
            }
        }
        if (this.aeT != null) {
            this.aeT.D(t);
        }
        if (this.aeM != null) {
            this.aeM.D(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.aeZ.c(i, bVar);
    }

    public boolean b(a.C0097a c0097a) {
        return this.aeZ.b(c0097a);
    }

    public void setPosition(int i) {
        if (this.aeN != null) {
            this.aeN.setPosition(i);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.am.setBackgroundResource(this.aeN, this.aeW.afs);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            if (this.aeQ != null) {
                this.aeQ.onChangeSkinType(tbPageContext, i);
            }
            if (this.aeR != null) {
                this.aeR.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.aeS) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.aeT != null) {
                this.aeT.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.aeU)) {
                Iterator<d> it = this.aeU.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof o)) {
                        ((o) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.aeV != null) {
                this.aeV.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.aa<T> aaVar) {
        if (this.aeQ != null) {
            this.aeQ.setOnCardSubClickListener(aaVar);
        }
        if (this.aeR != null) {
            this.aeR.setOnCardSubClickListener(aaVar);
        }
        for (h hVar : this.aeS) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(aaVar);
            }
        }
        if (this.aeT != null) {
            this.aeT.setOnCardSubClickListener(aaVar);
        }
        this.aeY = aaVar;
    }

    public void b(int i, a.b bVar) {
        this.aeZ.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeX = str;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private ArrayList<d> aeU;
        private af aeW;
        private b afd;
        private b afe;
        private List<h> aff;
        private b afg;
        private Context context;

        public a(Context context, boolean z) {
            this.afd = null;
            this.afe = null;
            this.afg = null;
            this.context = context;
            this.aeU = new ArrayList<>();
            this.aeW = new af();
            if (!z) {
                this.aeW.bh(0);
            }
            this.aff = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.afd = bVar;
            return this;
        }

        public a b(b bVar) {
            this.afg = bVar;
            return this;
        }

        public a a(h hVar) {
            this.aff.add(hVar);
            return this;
        }

        public a c(b bVar) {
            this.afe = bVar;
            return this;
        }

        public ae rL() {
            return new ae(this);
        }

        public ae a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.t tVar) {
            return new ae(this, z, viewGroup, tVar);
        }

        public af rK() {
            return this.aeW;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public af rK() {
        return this.aeW;
    }
}
