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
/* loaded from: classes20.dex */
public class ak<T extends AbsThreadDataSupport> implements q, com.baidu.tieba.a.e {
    private T afq;
    private p<T> agR;
    private ThreadCardView agS;
    private RelativeLayout agT;
    private LinearLayout agU;
    private b<T> agV;
    private b<T> agW;
    private List<i> agX;
    private b<T> agY;
    private ArrayList<d> agZ;
    private q aha;
    private al ahb;
    private String ahc;
    private com.baidu.tieba.card.aa<T> ahd;
    private com.baidu.card.a.a ahe;
    private int ahf;
    private a.C0096a ahg;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> tP() {
        return this.agW;
    }

    public b<T> tQ() {
        return this.agY;
    }

    public List<i> tR() {
        return this.agX;
    }

    private ak(a aVar) {
        this(aVar, true);
    }

    private ak(a aVar, boolean z) {
        this(aVar, z, null);
    }

    private ak(a aVar, boolean z, ViewGroup viewGroup) {
        this(aVar, z, viewGroup, null);
    }

    private ak(a aVar, boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
        this.mSkinType = 3;
        this.agR = null;
        this.aha = null;
        this.ahe = new com.baidu.card.a.a();
        this.ahf = 0;
        this.ahg = new a.C0096a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.agS = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.agT = (RelativeLayout) this.agS.findViewById(R.id.card_decor_layer);
        this.agU = (LinearLayout) this.agS.findViewById(R.id.body_root);
        this.agU.setPadding(this.agU.getPaddingLeft(), this.agU.getPaddingTop(), this.agU.getPaddingRight(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), com.baidu.tbadk.a.b.a.aL(R.dimen.tbds20, R.dimen.tbds0)));
        this.mBottomLine = this.agS.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.agV = aVar.ahi;
        this.agW = aVar.ahj;
        this.agX = aVar.ahk;
        this.agY = aVar.ahl;
        this.agZ = aVar.agZ;
        this.ahb = aVar.ahb;
        this.agS.setParent(viewGroup);
        this.agS.setITypeListView(vVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ak.this.ahg.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ak.this.ahg.setExtraData(false);
                        break;
                }
                ak.this.b(ak.this.ahg);
                return false;
            }
        });
    }

    public View getView() {
        return this.agS;
    }

    private void initUI() {
        if (this.ahb != null) {
            if (this.agU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.agU.getLayoutParams()).setMargins(this.ahb.ahv, this.ahb.aht, this.ahb.ahw, this.ahb.ahu);
                this.agU.postInvalidate();
            }
            if (this.ahb.ahp) {
                tT();
            }
            if (this.agV != null) {
                this.agV.a(this);
                this.agU.addView(this.agV.getView());
                this.agV.tA();
            }
            if (this.agW != null) {
                this.agW.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.ahb.ahq;
                if (this.agX != null) {
                    layoutParams.bottomMargin = this.ahb.ahr;
                }
                if (this.agW.tC().booleanValue()) {
                    layoutParams.leftMargin = -this.ahb.ahv;
                    layoutParams.rightMargin = -this.ahb.ahw;
                }
                this.agU.addView(this.agW.getView(), layoutParams);
                this.agW.tA();
            }
            if (this.agX != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.agX.size()) {
                        break;
                    }
                    i iVar = this.agX.get(i2);
                    if (iVar != null) {
                        iVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = iVar.getTopMargin();
                        layoutParams2.bottomMargin = iVar.tI();
                        if (iVar.tC().booleanValue()) {
                            layoutParams2.leftMargin = -this.ahb.ahv;
                            layoutParams2.rightMargin = -this.ahb.ahw;
                        }
                        this.agU.addView(iVar.getView(), layoutParams2);
                        iVar.tA();
                    }
                    i = i2 + 1;
                }
            }
            if (this.agY != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.ahb.ahs;
                this.agY.a(this);
                this.agU.addView(this.agY.getView(), layoutParams3);
                this.agY.tA();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.agZ)) {
                Iterator<d> it = this.agZ.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.tG() != null) {
                        if (next.tD() == null) {
                            this.agT.addView(next.tG(), next.tF());
                        } else {
                            this.agT.addView(next.tG(), next.tF(), next.tD());
                        }
                        next.b(this);
                        next.tA();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.ahf = i;
    }

    public int tS() {
        return this.ahf;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.tG() != null) {
            this.agZ.remove(dVar);
            if (dVar.tG().getParent() != null) {
                ((ViewGroup) dVar.tG().getParent()).removeView(dVar.tG());
                dVar.tE();
                dVar.b(null);
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null && dVar.tG() != null) {
            a(dVar);
            dVar.tG().setVisibility(0);
            if (dVar.tD() == null) {
                this.agT.addView(dVar.tG(), dVar.tF());
            } else {
                this.agT.addView(dVar.tG(), dVar.tF(), dVar.tD());
            }
            dVar.b(this);
            dVar.tA();
            this.agZ.add(dVar);
        }
    }

    private void tT() {
        d dVar = new d();
        dVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.ahb.aht;
        layoutParams.rightMargin = -this.ahb.ahw;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.agZ.add(dVar);
    }

    public void h(T t) {
        this.afq = t;
        if (this.agV != null) {
            this.agV.G(t);
        }
        if (this.agW != null) {
            this.agW.G(t);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.agX)) {
            for (i iVar : this.agX) {
                iVar.G(t);
            }
        }
        if (this.agY != null) {
            this.agY.G(t);
        }
        if (this.agR != null) {
            this.agR.G(t);
        }
        l(this.agU);
        l(this.agT);
        com.baidu.tbadk.a.b.a.a(this.mBottomLine, t);
    }

    private void l(ViewGroup viewGroup) {
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
        this.ahe.c(i, bVar);
    }

    public boolean b(a.C0096a c0096a) {
        return this.ahe.b(c0096a);
    }

    public void setPosition(int i) {
        if (this.agS != null) {
            this.agS.setPosition(i);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.agS, this.ahb.ahx);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            com.baidu.tbadk.a.b.a.aY(this.mBottomLine);
            if (this.agV != null) {
                this.agV.onChangeSkinType(tbPageContext, i);
            }
            if (this.agW != null) {
                this.agW.onChangeSkinType(tbPageContext, i);
            }
            for (i iVar : this.agX) {
                if (iVar != null) {
                    iVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.agY != null) {
                this.agY.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.agZ)) {
                Iterator<d> it = this.agZ.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof q)) {
                        ((q) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.aha != null) {
                this.aha.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.aa<T> aaVar) {
        if (this.agV != null) {
            this.agV.setOnCardSubClickListener(aaVar);
        }
        if (this.agW != null) {
            this.agW.setOnCardSubClickListener(aaVar);
        }
        for (i iVar : this.agX) {
            if (iVar != null) {
                iVar.setOnCardSubClickListener(aaVar);
            }
        }
        if (this.agY != null) {
            this.agY.setOnCardSubClickListener(aaVar);
        }
        this.ahd = aaVar;
    }

    public void b(int i, a.b bVar) {
        this.ahe.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahc = str;
    }

    /* loaded from: classes20.dex */
    public static class a {
        private ArrayList<d> agZ;
        private al ahb;
        private b ahi;
        private b ahj;
        private List<i> ahk;
        private b ahl;
        private Context context;

        public a(Context context, boolean z) {
            this.ahi = null;
            this.ahj = null;
            this.ahl = null;
            this.context = context;
            this.agZ = new ArrayList<>();
            this.ahb = new al();
            if (!z) {
                this.ahb.by(0);
            }
            this.ahk = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.ahi = bVar;
            return this;
        }

        public a b(b bVar) {
            this.ahl = bVar;
            return this;
        }

        public a a(i iVar) {
            this.ahk.add(iVar);
            return this;
        }

        public a c(b bVar) {
            this.ahj = bVar;
            return this;
        }

        public ak tV() {
            return new ak(this);
        }

        public ak a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
            return new ak(this, z, viewGroup, vVar);
        }

        public al tU() {
            return this.ahb;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public al tU() {
        return this.ahb;
    }
}
