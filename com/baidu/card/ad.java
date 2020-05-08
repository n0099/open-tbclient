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
    private T ade;
    private ae aeA;
    private String aeB;
    private com.baidu.tieba.card.z<T> aeC;
    private com.baidu.card.a.a aeD;
    private int aeE;
    private a.C0095a aeF;
    private m<T> aeq;
    private ThreadCardView aer;
    private RelativeLayout aes;
    private LinearLayout aet;
    private b<T> aeu;
    private b<T> aev;
    private List<h> aew;
    private b<T> aex;
    private ArrayList<d> aey;
    private n aez;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> rw() {
        return this.aev;
    }

    public b<T> rx() {
        return this.aex;
    }

    public List<h> ry() {
        return this.aew;
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
        this.aeq = null;
        this.aez = null;
        this.aeD = new com.baidu.card.a.a();
        this.aeE = 0;
        this.aeF = new a.C0095a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.aer = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.aes = (RelativeLayout) this.aer.findViewById(R.id.card_decor_layer);
        this.aet = (LinearLayout) this.aer.findViewById(R.id.body_root);
        this.mBottomLine = this.aer.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.aeu = aVar.aeH;
        this.aev = aVar.aeI;
        this.aew = aVar.aeJ;
        this.aex = aVar.aeK;
        this.aey = aVar.aey;
        this.aeA = aVar.aeA;
        this.aer.setParent(viewGroup);
        this.aer.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ad.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ad.this.aeF.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ad.this.aeF.setExtraData(false);
                        break;
                }
                ad.this.b(ad.this.aeF);
                return false;
            }
        });
    }

    public View getView() {
        return this.aer;
    }

    private void initUI() {
        if (this.aeA != null) {
            if (this.aet.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.aet.getLayoutParams()).setMargins(this.aeA.aeU, this.aeA.aeS, this.aeA.aeV, this.aeA.aeT);
                this.aet.postInvalidate();
            }
            if (this.aeA.aeO) {
                rA();
            }
            if (this.aeu != null) {
                this.aeu.a(this);
                this.aet.addView(this.aeu.getView());
                this.aeu.rk();
            }
            if (this.aev != null) {
                this.aev.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.aeA.aeP;
                if (this.aew != null) {
                    layoutParams.bottomMargin = this.aeA.aeQ;
                }
                if (this.aev.rm().booleanValue()) {
                    layoutParams.leftMargin = -this.aeA.aeU;
                    layoutParams.rightMargin = -this.aeA.aeV;
                }
                this.aet.addView(this.aev.getView(), layoutParams);
                this.aev.rk();
            }
            if (this.aew != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aew.size()) {
                        break;
                    }
                    h hVar = this.aew.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.rs();
                        if (hVar.rm().booleanValue()) {
                            layoutParams2.leftMargin = -this.aeA.aeU;
                            layoutParams2.rightMargin = -this.aeA.aeV;
                        }
                        this.aet.addView(hVar.getView(), layoutParams2);
                        hVar.rk();
                    }
                    i = i2 + 1;
                }
            }
            if (this.aex != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.aeA.aeR;
                this.aex.a(this);
                this.aet.addView(this.aex.getView(), layoutParams3);
                this.aex.rk();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.aey)) {
                Iterator<d> it = this.aey.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.rq() != null) {
                        if (next.rn() == null) {
                            this.aes.addView(next.rq(), next.rp());
                        } else {
                            this.aes.addView(next.rq(), next.rp(), next.rn());
                        }
                        next.b(this);
                        next.rk();
                    }
                }
            }
        }
    }

    public void bc(int i) {
        this.aeE = i;
    }

    public int rz() {
        return this.aeE;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.rq() != null) {
            this.aey.remove(dVar);
            if (dVar.rq().getParent() != null) {
                ((ViewGroup) dVar.rq().getParent()).removeView(dVar.rq());
                dVar.ro();
                dVar.b(null);
            }
            if (dVar.rn() == null) {
                this.aes.addView(dVar.rq(), dVar.rp());
            } else {
                this.aes.addView(dVar.rq(), dVar.rp(), dVar.rn());
            }
            dVar.b(this);
            dVar.rk();
            this.aey.add(dVar);
        }
    }

    private void rA() {
        d dVar = new d();
        dVar.F(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.aeA.aeS;
        layoutParams.rightMargin = -this.aeA.aeV;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.aey.add(dVar);
    }

    public void c(T t) {
        this.ade = t;
        if (this.aeu != null) {
            this.aeu.B(t);
        }
        if (this.aev != null) {
            this.aev.B(t);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.aew)) {
            for (h hVar : this.aew) {
                hVar.B(t);
            }
        }
        if (this.aex != null) {
            this.aex.B(t);
        }
        if (this.aeq != null) {
            this.aeq.B(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.aeD.c(i, bVar);
    }

    public boolean b(a.C0095a c0095a) {
        return this.aeD.b(c0095a);
    }

    public void setPosition(int i) {
        if (this.aer != null) {
            this.aer.setPosition(i);
        }
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.aer, this.aeA.aeW);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            if (this.aeu != null) {
                this.aeu.onChangeSkinType(tbPageContext, i);
            }
            if (this.aev != null) {
                this.aev.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.aew) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.aex != null) {
                this.aex.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.aey)) {
                Iterator<d> it = this.aey.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof n)) {
                        ((n) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.aez != null) {
                this.aez.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.z<T> zVar) {
        if (this.aeu != null) {
            this.aeu.setOnCardSubClickListener(zVar);
        }
        if (this.aev != null) {
            this.aev.setOnCardSubClickListener(zVar);
        }
        for (h hVar : this.aew) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(zVar);
            }
        }
        if (this.aex != null) {
            this.aex.setOnCardSubClickListener(zVar);
        }
        this.aeC = zVar;
    }

    public void b(int i, a.b bVar) {
        this.aeD.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aeB = str;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private ae aeA;
        private b aeH;
        private b aeI;
        private List<h> aeJ;
        private b aeK;
        private ArrayList<d> aey;
        private Context context;

        public a(Context context, boolean z) {
            this.aeH = null;
            this.aeI = null;
            this.aeK = null;
            this.context = context;
            this.aey = new ArrayList<>();
            this.aeA = new ae();
            if (!z) {
                this.aeA.bg(0);
            }
            this.aeJ = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.aeH = bVar;
            return this;
        }

        public a b(b bVar) {
            this.aeK = bVar;
            return this;
        }

        public a a(h hVar) {
            this.aeJ.add(hVar);
            return this;
        }

        public a c(b bVar) {
            this.aeI = bVar;
            return this;
        }

        public ad rC() {
            return new ad(this);
        }

        public ad a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new ad(this, z, viewGroup, rVar);
        }

        public ae rB() {
            return this.aeA;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public ae rB() {
        return this.aeA;
    }
}
