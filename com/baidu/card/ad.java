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
    private T ada;
    private com.baidu.card.a.a aeA;
    private int aeB;
    private a.C0074a aeC;
    private m<T> aen;
    private ThreadCardView aeo;
    private RelativeLayout aep;
    private LinearLayout aeq;
    private b<T> aer;
    private b<T> aes;
    private List<h> aet;
    private b<T> aeu;
    private ArrayList<d> aev;
    private n aew;
    private ae aex;
    private String aey;
    private com.baidu.tieba.card.z<T> aez;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> rw() {
        return this.aes;
    }

    public b<T> rx() {
        return this.aeu;
    }

    public List<h> ry() {
        return this.aet;
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
        this.aen = null;
        this.aew = null;
        this.aeA = new com.baidu.card.a.a();
        this.aeB = 0;
        this.aeC = new a.C0074a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.aeo = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.aep = (RelativeLayout) this.aeo.findViewById(R.id.card_decor_layer);
        this.aeq = (LinearLayout) this.aeo.findViewById(R.id.body_root);
        this.mBottomLine = this.aeo.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.aer = aVar.aeE;
        this.aes = aVar.aeF;
        this.aet = aVar.aeG;
        this.aeu = aVar.aeH;
        this.aev = aVar.aev;
        this.aex = aVar.aex;
        this.aeo.setParent(viewGroup);
        this.aeo.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ad.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ad.this.aeC.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ad.this.aeC.setExtraData(false);
                        break;
                }
                ad.this.b(ad.this.aeC);
                return false;
            }
        });
    }

    public View getView() {
        return this.aeo;
    }

    private void initUI() {
        if (this.aex != null) {
            if (this.aeq.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.aeq.getLayoutParams()).setMargins(this.aex.aeR, this.aex.aeP, this.aex.aeS, this.aex.aeQ);
                this.aeq.postInvalidate();
            }
            if (this.aex.aeL) {
                rA();
            }
            if (this.aer != null) {
                this.aer.a(this);
                this.aeq.addView(this.aer.getView());
                this.aer.rk();
            }
            if (this.aes != null) {
                this.aes.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.aex.aeM;
                if (this.aet != null) {
                    layoutParams.bottomMargin = this.aex.aeN;
                }
                if (this.aes.rm().booleanValue()) {
                    layoutParams.leftMargin = -this.aex.aeR;
                    layoutParams.rightMargin = -this.aex.aeS;
                }
                this.aeq.addView(this.aes.getView(), layoutParams);
                this.aes.rk();
            }
            if (this.aet != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aet.size()) {
                        break;
                    }
                    h hVar = this.aet.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.rs();
                        if (hVar.rm().booleanValue()) {
                            layoutParams2.leftMargin = -this.aex.aeR;
                            layoutParams2.rightMargin = -this.aex.aeS;
                        }
                        this.aeq.addView(hVar.getView(), layoutParams2);
                        hVar.rk();
                    }
                    i = i2 + 1;
                }
            }
            if (this.aeu != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.aex.aeO;
                this.aeu.a(this);
                this.aeq.addView(this.aeu.getView(), layoutParams3);
                this.aeu.rk();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.aev)) {
                Iterator<d> it = this.aev.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.rq() != null) {
                        if (next.rn() == null) {
                            this.aep.addView(next.rq(), next.rp());
                        } else {
                            this.aep.addView(next.rq(), next.rp(), next.rn());
                        }
                        next.b(this);
                        next.rk();
                    }
                }
            }
        }
    }

    public void bc(int i) {
        this.aeB = i;
    }

    public int rz() {
        return this.aeB;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.rq() != null) {
            this.aev.remove(dVar);
            if (dVar.rq().getParent() != null) {
                ((ViewGroup) dVar.rq().getParent()).removeView(dVar.rq());
                dVar.ro();
                dVar.b(null);
            }
            if (dVar.rn() == null) {
                this.aep.addView(dVar.rq(), dVar.rp());
            } else {
                this.aep.addView(dVar.rq(), dVar.rp(), dVar.rn());
            }
            dVar.b(this);
            dVar.rk();
            this.aev.add(dVar);
        }
    }

    private void rA() {
        d dVar = new d();
        dVar.F(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.aex.aeP;
        layoutParams.rightMargin = -this.aex.aeS;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.aev.add(dVar);
    }

    public void c(T t) {
        this.ada = t;
        if (this.aer != null) {
            this.aer.A(t);
        }
        if (this.aes != null) {
            this.aes.A(t);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.aet)) {
            for (h hVar : this.aet) {
                hVar.A(t);
            }
        }
        if (this.aeu != null) {
            this.aeu.A(t);
        }
        if (this.aen != null) {
            this.aen.A(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.aeA.c(i, bVar);
    }

    public boolean b(a.C0074a c0074a) {
        return this.aeA.b(c0074a);
    }

    public void setPosition(int i) {
        if (this.aeo != null) {
            this.aeo.setPosition(i);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.aeo, this.aex.aeT);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            if (this.aer != null) {
                this.aer.onChangeSkinType(tbPageContext, i);
            }
            if (this.aes != null) {
                this.aes.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.aet) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.aeu != null) {
                this.aeu.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.aev)) {
                Iterator<d> it = this.aev.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof n)) {
                        ((n) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.aew != null) {
                this.aew.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.z<T> zVar) {
        if (this.aer != null) {
            this.aer.setOnCardSubClickListener(zVar);
        }
        if (this.aes != null) {
            this.aes.setOnCardSubClickListener(zVar);
        }
        for (h hVar : this.aet) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(zVar);
            }
        }
        if (this.aeu != null) {
            this.aeu.setOnCardSubClickListener(zVar);
        }
        this.aez = zVar;
    }

    public void b(int i, a.b bVar) {
        this.aeA.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aey = str;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private b aeE;
        private b aeF;
        private List<h> aeG;
        private b aeH;
        private ArrayList<d> aev;
        private ae aex;
        private Context context;

        public a(Context context, boolean z) {
            this.aeE = null;
            this.aeF = null;
            this.aeH = null;
            this.context = context;
            this.aev = new ArrayList<>();
            this.aex = new ae();
            if (!z) {
                this.aex.bg(0);
            }
            this.aeG = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.aeE = bVar;
            return this;
        }

        public a b(b bVar) {
            this.aeH = bVar;
            return this;
        }

        public a a(h hVar) {
            this.aeG.add(hVar);
            return this;
        }

        public a c(b bVar) {
            this.aeF = bVar;
            return this;
        }

        public ad rC() {
            return new ad(this);
        }

        public ad a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new ad(this, z, viewGroup, rVar);
        }

        public ae rB() {
            return this.aex;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public ae rB() {
        return this.aex;
    }
}
