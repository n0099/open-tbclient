package com.baidu.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.card.a.a;
import com.baidu.card.view.ThreadCardView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class aj<T extends AbsThreadDataSupport> implements p, com.baidu.tieba.a.e {
    private T aeY;
    private RelativeLayout agA;
    private LinearLayout agB;
    private b<T> agC;
    private b<T> agD;
    private List<h> agE;
    private b<T> agF;
    private ArrayList<d> agG;
    private p agH;
    private ak agI;
    private String agJ;
    private com.baidu.tieba.card.aa<T> agK;
    private com.baidu.card.a.a agL;
    private int agM;
    private a.C0095a agN;
    private o<T> agy;
    private ThreadCardView agz;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> tK() {
        return this.agD;
    }

    public b<T> tL() {
        return this.agF;
    }

    public List<h> tM() {
        return this.agE;
    }

    private aj(a aVar) {
        this(aVar, true);
    }

    private aj(a aVar, boolean z) {
        this(aVar, z, null);
    }

    private aj(a aVar, boolean z, ViewGroup viewGroup) {
        this(aVar, z, viewGroup, null);
    }

    private aj(a aVar, boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
        this.mSkinType = 3;
        this.agy = null;
        this.agH = null;
        this.agL = new com.baidu.card.a.a();
        this.agM = 0;
        this.agN = new a.C0095a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.agz = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.agA = (RelativeLayout) this.agz.findViewById(R.id.card_decor_layer);
        this.agB = (LinearLayout) this.agz.findViewById(R.id.body_root);
        this.agB.setPadding(this.agB.getPaddingLeft(), this.agB.getPaddingTop(), this.agB.getPaddingRight(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), com.baidu.tbadk.a.b.a.aL(R.dimen.tbds20, R.dimen.tbds0)));
        this.mBottomLine = this.agz.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.agC = aVar.agP;
        this.agD = aVar.agQ;
        this.agE = aVar.agR;
        this.agF = aVar.agS;
        this.agG = aVar.agG;
        this.agI = aVar.agI;
        this.agz.setParent(viewGroup);
        this.agz.setITypeListView(vVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.aj.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        aj.this.agN.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        aj.this.agN.setExtraData(false);
                        break;
                }
                aj.this.b(aj.this.agN);
                return false;
            }
        });
    }

    public View getView() {
        return this.agz;
    }

    private void initUI() {
        if (this.agI != null) {
            if (this.agB.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.agB.getLayoutParams()).setMargins(this.agI.ahc, this.agI.aha, this.agI.ahd, this.agI.ahb);
                this.agB.postInvalidate();
            }
            if (this.agI.agW) {
                tO();
            }
            if (this.agC != null) {
                this.agC.a(this);
                this.agB.addView(this.agC.getView());
                this.agC.tv();
            }
            if (this.agD != null) {
                this.agD.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.agI.agX;
                if (this.agE != null) {
                    layoutParams.bottomMargin = this.agI.agY;
                }
                if (this.agD.tx().booleanValue()) {
                    layoutParams.leftMargin = -this.agI.ahc;
                    layoutParams.rightMargin = -this.agI.ahd;
                }
                this.agB.addView(this.agD.getView(), layoutParams);
                this.agD.tv();
            }
            if (this.agE != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.agE.size()) {
                        break;
                    }
                    h hVar = this.agE.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.tD();
                        if (hVar.tx().booleanValue()) {
                            layoutParams2.leftMargin = -this.agI.ahc;
                            layoutParams2.rightMargin = -this.agI.ahd;
                        }
                        this.agB.addView(hVar.getView(), layoutParams2);
                        hVar.tv();
                    }
                    i = i2 + 1;
                }
            }
            if (this.agF != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.agI.agZ;
                this.agF.a(this);
                this.agB.addView(this.agF.getView(), layoutParams3);
                this.agF.tv();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.agG)) {
                Iterator<d> it = this.agG.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.tB() != null) {
                        if (next.ty() == null) {
                            this.agA.addView(next.tB(), next.tA());
                        } else {
                            this.agA.addView(next.tB(), next.tA(), next.ty());
                        }
                        next.b(this);
                        next.tv();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.agM = i;
    }

    public int tN() {
        return this.agM;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.tB() != null) {
            this.agG.remove(dVar);
            if (dVar.tB().getParent() != null) {
                ((ViewGroup) dVar.tB().getParent()).removeView(dVar.tB());
                dVar.tz();
                dVar.b(null);
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null && dVar.tB() != null) {
            a(dVar);
            dVar.tB().setVisibility(0);
            if (dVar.ty() == null) {
                this.agA.addView(dVar.tB(), dVar.tA());
            } else {
                this.agA.addView(dVar.tB(), dVar.tA(), dVar.ty());
            }
            dVar.b(this);
            dVar.tv();
            this.agG.add(dVar);
        }
    }

    private void tO() {
        d dVar = new d();
        dVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.agI.aha;
        layoutParams.rightMargin = -this.agI.ahd;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.agG.add(dVar);
    }

    public void g(T t) {
        this.aeY = t;
        if (this.agC != null) {
            this.agC.F(t);
        }
        if (this.agD != null) {
            this.agD.F(t);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.agE)) {
            for (h hVar : this.agE) {
                hVar.F(t);
            }
        }
        if (this.agF != null) {
            this.agF.F(t);
        }
        if (this.agy != null) {
            this.agy.F(t);
        }
        k(this.agB);
        k(this.agA);
        com.baidu.tbadk.a.b.a.a(this.mBottomLine, t);
    }

    private void k(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            z = 8 != viewGroup.getChildAt(i).getVisibility();
            if (z) {
                break;
            }
        }
        viewGroup.setVisibility(z ? 0 : 8);
    }

    public void a(int i, a.b bVar) {
        this.agL.c(i, bVar);
    }

    public boolean b(a.C0095a c0095a) {
        return this.agL.b(c0095a);
    }

    public void setPosition(int i) {
        if (this.agz != null) {
            this.agz.setPosition(i);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.agz, this.agI.ahe);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            com.baidu.tbadk.a.b.a.aW(this.mBottomLine);
            if (this.agC != null) {
                this.agC.onChangeSkinType(tbPageContext, i);
            }
            if (this.agD != null) {
                this.agD.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.agE) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.agF != null) {
                this.agF.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.agG)) {
                Iterator<d> it = this.agG.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof p)) {
                        ((p) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.agH != null) {
                this.agH.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.aa<T> aaVar) {
        if (this.agC != null) {
            this.agC.setOnCardSubClickListener(aaVar);
        }
        if (this.agD != null) {
            this.agD.setOnCardSubClickListener(aaVar);
        }
        for (h hVar : this.agE) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(aaVar);
            }
        }
        if (this.agF != null) {
            this.agF.setOnCardSubClickListener(aaVar);
        }
        this.agK = aaVar;
    }

    public void b(int i, a.b bVar) {
        this.agL.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agJ = str;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private ArrayList<d> agG;
        private ak agI;
        private b agP;
        private b agQ;
        private List<h> agR;
        private b agS;
        private Context context;

        public a(Context context, boolean z) {
            this.agP = null;
            this.agQ = null;
            this.agS = null;
            this.context = context;
            this.agG = new ArrayList<>();
            this.agI = new ak();
            if (!z) {
                this.agI.bu(0);
            }
            this.agR = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.agP = bVar;
            return this;
        }

        public a b(b bVar) {
            this.agS = bVar;
            return this;
        }

        public a a(h hVar) {
            this.agR.add(hVar);
            return this;
        }

        public a c(b bVar) {
            this.agQ = bVar;
            return this;
        }

        public aj tQ() {
            return new aj(this);
        }

        public aj a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
            return new aj(this, z, viewGroup, vVar);
        }

        public ak tP() {
            return this.agI;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public ak tP() {
        return this.agI;
    }
}
