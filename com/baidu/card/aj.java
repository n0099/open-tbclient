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
    private T aeW;
    private b<T> agA;
    private b<T> agB;
    private List<h> agC;
    private b<T> agD;
    private ArrayList<d> agE;
    private p agF;
    private ak agG;
    private String agH;
    private com.baidu.tieba.card.aa<T> agI;
    private com.baidu.card.a.a agJ;
    private int agK;
    private a.C0095a agL;
    private o<T> agw;
    private ThreadCardView agx;
    private RelativeLayout agy;
    private LinearLayout agz;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> tK() {
        return this.agB;
    }

    public b<T> tL() {
        return this.agD;
    }

    public List<h> tM() {
        return this.agC;
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
        this.agw = null;
        this.agF = null;
        this.agJ = new com.baidu.card.a.a();
        this.agK = 0;
        this.agL = new a.C0095a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.agx = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.agy = (RelativeLayout) this.agx.findViewById(R.id.card_decor_layer);
        this.agz = (LinearLayout) this.agx.findViewById(R.id.body_root);
        this.agz.setPadding(this.agz.getPaddingLeft(), this.agz.getPaddingTop(), this.agz.getPaddingRight(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), com.baidu.tbadk.a.b.a.aL(R.dimen.tbds20, R.dimen.tbds0)));
        this.mBottomLine = this.agx.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.agA = aVar.agN;
        this.agB = aVar.agO;
        this.agC = aVar.agP;
        this.agD = aVar.agQ;
        this.agE = aVar.agE;
        this.agG = aVar.agG;
        this.agx.setParent(viewGroup);
        this.agx.setITypeListView(vVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.aj.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        aj.this.agL.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        aj.this.agL.setExtraData(false);
                        break;
                }
                aj.this.b(aj.this.agL);
                return false;
            }
        });
    }

    public View getView() {
        return this.agx;
    }

    private void initUI() {
        if (this.agG != null) {
            if (this.agz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.agz.getLayoutParams()).setMargins(this.agG.aha, this.agG.agY, this.agG.ahb, this.agG.agZ);
                this.agz.postInvalidate();
            }
            if (this.agG.agU) {
                tO();
            }
            if (this.agA != null) {
                this.agA.a(this);
                this.agz.addView(this.agA.getView());
                this.agA.tv();
            }
            if (this.agB != null) {
                this.agB.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.agG.agV;
                if (this.agC != null) {
                    layoutParams.bottomMargin = this.agG.agW;
                }
                if (this.agB.tx().booleanValue()) {
                    layoutParams.leftMargin = -this.agG.aha;
                    layoutParams.rightMargin = -this.agG.ahb;
                }
                this.agz.addView(this.agB.getView(), layoutParams);
                this.agB.tv();
            }
            if (this.agC != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.agC.size()) {
                        break;
                    }
                    h hVar = this.agC.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.tD();
                        if (hVar.tx().booleanValue()) {
                            layoutParams2.leftMargin = -this.agG.aha;
                            layoutParams2.rightMargin = -this.agG.ahb;
                        }
                        this.agz.addView(hVar.getView(), layoutParams2);
                        hVar.tv();
                    }
                    i = i2 + 1;
                }
            }
            if (this.agD != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.agG.agX;
                this.agD.a(this);
                this.agz.addView(this.agD.getView(), layoutParams3);
                this.agD.tv();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.agE)) {
                Iterator<d> it = this.agE.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.tB() != null) {
                        if (next.ty() == null) {
                            this.agy.addView(next.tB(), next.tA());
                        } else {
                            this.agy.addView(next.tB(), next.tA(), next.ty());
                        }
                        next.b(this);
                        next.tv();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.agK = i;
    }

    public int tN() {
        return this.agK;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.tB() != null) {
            this.agE.remove(dVar);
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
                this.agy.addView(dVar.tB(), dVar.tA());
            } else {
                this.agy.addView(dVar.tB(), dVar.tA(), dVar.ty());
            }
            dVar.b(this);
            dVar.tv();
            this.agE.add(dVar);
        }
    }

    private void tO() {
        d dVar = new d();
        dVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.agG.agY;
        layoutParams.rightMargin = -this.agG.ahb;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.agE.add(dVar);
    }

    public void g(T t) {
        this.aeW = t;
        if (this.agA != null) {
            this.agA.F(t);
        }
        if (this.agB != null) {
            this.agB.F(t);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.agC)) {
            for (h hVar : this.agC) {
                hVar.F(t);
            }
        }
        if (this.agD != null) {
            this.agD.F(t);
        }
        if (this.agw != null) {
            this.agw.F(t);
        }
        k(this.agz);
        k(this.agy);
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
        this.agJ.c(i, bVar);
    }

    public boolean b(a.C0095a c0095a) {
        return this.agJ.b(c0095a);
    }

    public void setPosition(int i) {
        if (this.agx != null) {
            this.agx.setPosition(i);
        }
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.agx, this.agG.ahc);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            com.baidu.tbadk.a.b.a.aW(this.mBottomLine);
            if (this.agA != null) {
                this.agA.onChangeSkinType(tbPageContext, i);
            }
            if (this.agB != null) {
                this.agB.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.agC) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.agD != null) {
                this.agD.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.agE)) {
                Iterator<d> it = this.agE.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof p)) {
                        ((p) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.agF != null) {
                this.agF.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.aa<T> aaVar) {
        if (this.agA != null) {
            this.agA.setOnCardSubClickListener(aaVar);
        }
        if (this.agB != null) {
            this.agB.setOnCardSubClickListener(aaVar);
        }
        for (h hVar : this.agC) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(aaVar);
            }
        }
        if (this.agD != null) {
            this.agD.setOnCardSubClickListener(aaVar);
        }
        this.agI = aaVar;
    }

    public void b(int i, a.b bVar) {
        this.agJ.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.agH = str;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private ArrayList<d> agE;
        private ak agG;
        private b agN;
        private b agO;
        private List<h> agP;
        private b agQ;
        private Context context;

        public a(Context context, boolean z) {
            this.agN = null;
            this.agO = null;
            this.agQ = null;
            this.context = context;
            this.agE = new ArrayList<>();
            this.agG = new ak();
            if (!z) {
                this.agG.bu(0);
            }
            this.agP = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.agN = bVar;
            return this;
        }

        public a b(b bVar) {
            this.agQ = bVar;
            return this;
        }

        public a a(h hVar) {
            this.agP.add(hVar);
            return this;
        }

        public a c(b bVar) {
            this.agO = bVar;
            return this;
        }

        public aj tQ() {
            return new aj(this);
        }

        public aj a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
            return new aj(this, z, viewGroup, vVar);
        }

        public ak tP() {
            return this.agG;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public ak tP() {
        return this.agG;
    }
}
