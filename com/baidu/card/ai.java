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
public class ai<T extends AbsThreadDataSupport> implements o, com.baidu.tieba.a.e {
    private T aea;
    private b<T> afA;
    private List<h> afB;
    private b<T> afC;
    private ArrayList<d> afD;
    private o afE;
    private aj afF;
    private String afG;
    private com.baidu.tieba.card.aa<T> afH;
    private com.baidu.card.a.a afI;
    private int afJ;
    private a.C0098a afK;
    private n<T> afv;
    private ThreadCardView afw;
    private RelativeLayout afx;
    private LinearLayout afy;
    private b<T> afz;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> rX() {
        return this.afA;
    }

    public b<T> rY() {
        return this.afC;
    }

    public List<h> rZ() {
        return this.afB;
    }

    private ai(a aVar) {
        this(aVar, true);
    }

    private ai(a aVar, boolean z) {
        this(aVar, z, null);
    }

    private ai(a aVar, boolean z, ViewGroup viewGroup) {
        this(aVar, z, viewGroup, null);
    }

    private ai(a aVar, boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
        this.mSkinType = 3;
        this.afv = null;
        this.afE = null;
        this.afI = new com.baidu.card.a.a();
        this.afJ = 0;
        this.afK = new a.C0098a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.afw = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.afx = (RelativeLayout) this.afw.findViewById(R.id.card_decor_layer);
        this.afy = (LinearLayout) this.afw.findViewById(R.id.body_root);
        this.mBottomLine = this.afw.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.afz = aVar.afM;
        this.afA = aVar.afN;
        this.afB = aVar.afO;
        this.afC = aVar.afP;
        this.afD = aVar.afD;
        this.afF = aVar.afF;
        this.afw.setParent(viewGroup);
        this.afw.setITypeListView(vVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ai.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ai.this.afK.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ai.this.afK.setExtraData(false);
                        break;
                }
                ai.this.b(ai.this.afK);
                return false;
            }
        });
    }

    public View getView() {
        return this.afw;
    }

    private void initUI() {
        if (this.afF != null) {
            if (this.afy.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.afy.getLayoutParams()).setMargins(this.afF.afZ, this.afF.afX, this.afF.aga, this.afF.afY);
                this.afy.postInvalidate();
            }
            if (this.afF.afT) {
                sb();
            }
            if (this.afz != null) {
                this.afz.a(this);
                this.afy.addView(this.afz.getView());
                this.afz.rI();
            }
            if (this.afA != null) {
                this.afA.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.afF.afU;
                if (this.afB != null) {
                    layoutParams.bottomMargin = this.afF.afV;
                }
                if (this.afA.rK().booleanValue()) {
                    layoutParams.leftMargin = -this.afF.afZ;
                    layoutParams.rightMargin = -this.afF.aga;
                }
                this.afy.addView(this.afA.getView(), layoutParams);
                this.afA.rI();
            }
            if (this.afB != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.afB.size()) {
                        break;
                    }
                    h hVar = this.afB.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.rQ();
                        if (hVar.rK().booleanValue()) {
                            layoutParams2.leftMargin = -this.afF.afZ;
                            layoutParams2.rightMargin = -this.afF.aga;
                        }
                        this.afy.addView(hVar.getView(), layoutParams2);
                        hVar.rI();
                    }
                    i = i2 + 1;
                }
            }
            if (this.afC != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.afF.afW;
                this.afC.a(this);
                this.afy.addView(this.afC.getView(), layoutParams3);
                this.afC.rI();
            }
            if (!com.baidu.tbadk.core.util.w.isEmpty(this.afD)) {
                Iterator<d> it = this.afD.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.rO() != null) {
                        if (next.rL() == null) {
                            this.afx.addView(next.rO(), next.rN());
                        } else {
                            this.afx.addView(next.rO(), next.rN(), next.rL());
                        }
                        next.b(this);
                        next.rI();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.afJ = i;
    }

    public int sa() {
        return this.afJ;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.rO() != null) {
            this.afD.remove(dVar);
            if (dVar.rO().getParent() != null) {
                ((ViewGroup) dVar.rO().getParent()).removeView(dVar.rO());
                dVar.rM();
                dVar.b(null);
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null && dVar.rO() != null) {
            a(dVar);
            dVar.rO().setVisibility(0);
            if (dVar.rL() == null) {
                this.afx.addView(dVar.rO(), dVar.rN());
            } else {
                this.afx.addView(dVar.rO(), dVar.rN(), dVar.rL());
            }
            dVar.b(this);
            dVar.rI();
            this.afD.add(dVar);
        }
    }

    private void sb() {
        d dVar = new d();
        dVar.F(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.afF.afX;
        layoutParams.rightMargin = -this.afF.aga;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.afD.add(dVar);
    }

    public void g(T t) {
        this.aea = t;
        if (this.afz != null) {
            this.afz.D(t);
        }
        if (this.afA != null) {
            this.afA.D(t);
        }
        if (!com.baidu.tbadk.core.util.w.isEmpty(this.afB)) {
            for (h hVar : this.afB) {
                hVar.D(t);
            }
        }
        if (this.afC != null) {
            this.afC.D(t);
        }
        if (this.afv != null) {
            this.afv.D(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.afI.c(i, bVar);
    }

    public boolean b(a.C0098a c0098a) {
        return this.afI.b(c0098a);
    }

    public void setPosition(int i) {
        if (this.afw != null) {
            this.afw.setPosition(i);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.an.setBackgroundResource(this.afw, this.afF.agb);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.an.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            if (this.afz != null) {
                this.afz.onChangeSkinType(tbPageContext, i);
            }
            if (this.afA != null) {
                this.afA.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.afB) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.afC != null) {
                this.afC.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.w.isEmpty(this.afD)) {
                Iterator<d> it = this.afD.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof o)) {
                        ((o) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.afE != null) {
                this.afE.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.aa<T> aaVar) {
        if (this.afz != null) {
            this.afz.setOnCardSubClickListener(aaVar);
        }
        if (this.afA != null) {
            this.afA.setOnCardSubClickListener(aaVar);
        }
        for (h hVar : this.afB) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(aaVar);
            }
        }
        if (this.afC != null) {
            this.afC.setOnCardSubClickListener(aaVar);
        }
        this.afH = aaVar;
    }

    public void b(int i, a.b bVar) {
        this.afI.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afG = str;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private ArrayList<d> afD;
        private aj afF;
        private b afM;
        private b afN;
        private List<h> afO;
        private b afP;
        private Context context;

        public a(Context context, boolean z) {
            this.afM = null;
            this.afN = null;
            this.afP = null;
            this.context = context;
            this.afD = new ArrayList<>();
            this.afF = new aj();
            if (!z) {
                this.afF.bn(0);
            }
            this.afO = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.afM = bVar;
            return this;
        }

        public a b(b bVar) {
            this.afP = bVar;
            return this;
        }

        public a a(h hVar) {
            this.afO.add(hVar);
            return this;
        }

        public a c(b bVar) {
            this.afN = bVar;
            return this;
        }

        public ai sd() {
            return new ai(this);
        }

        public ai a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
            return new ai(this, z, viewGroup, vVar);
        }

        public aj sc() {
            return this.afF;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public aj sc() {
        return this.afF;
    }
}
