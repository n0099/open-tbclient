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
/* loaded from: classes21.dex */
public class ak<T extends AbsThreadDataSupport> implements q, com.baidu.tieba.a.e {
    private T afH;
    private p<T> ahi;
    private ThreadCardView ahj;
    private RelativeLayout ahk;
    private LinearLayout ahl;
    private b<T> ahm;
    private b<T> ahn;
    private List<i> aho;
    private b<T> ahp;
    private ArrayList<d> ahq;
    private q ahr;
    private al ahs;
    private String aht;
    private com.baidu.tieba.card.aa<T> ahu;
    private com.baidu.card.a.a ahv;
    private int ahw;
    private a.C0097a ahx;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> tP() {
        return this.ahn;
    }

    public b<T> tQ() {
        return this.ahp;
    }

    public List<i> tR() {
        return this.aho;
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
        this.ahi = null;
        this.ahr = null;
        this.ahv = new com.baidu.card.a.a();
        this.ahw = 0;
        this.ahx = new a.C0097a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.ahj = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.ahk = (RelativeLayout) this.ahj.findViewById(R.id.card_decor_layer);
        this.ahl = (LinearLayout) this.ahj.findViewById(R.id.body_root);
        this.ahl.setPadding(this.ahl.getPaddingLeft(), this.ahl.getPaddingTop(), this.ahl.getPaddingRight(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), com.baidu.tbadk.a.b.a.aK(R.dimen.tbds20, R.dimen.tbds0)));
        this.mBottomLine = this.ahj.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.ahm = aVar.ahz;
        this.ahn = aVar.ahA;
        this.aho = aVar.ahB;
        this.ahp = aVar.ahC;
        this.ahq = aVar.ahq;
        this.ahs = aVar.ahs;
        this.ahj.setParent(viewGroup);
        this.ahj.setITypeListView(vVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ak.this.ahx.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ak.this.ahx.setExtraData(false);
                        break;
                }
                ak.this.b(ak.this.ahx);
                return false;
            }
        });
    }

    public View getView() {
        return this.ahj;
    }

    private void initUI() {
        if (this.ahs != null) {
            if (this.ahl.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ahl.getLayoutParams()).setMargins(this.ahs.ahM, this.ahs.ahK, this.ahs.ahN, this.ahs.ahL);
                this.ahl.postInvalidate();
            }
            if (this.ahs.ahG) {
                tT();
            }
            if (this.ahm != null) {
                this.ahm.a(this);
                this.ahl.addView(this.ahm.getView());
                this.ahm.tA();
            }
            if (this.ahn != null) {
                this.ahn.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.ahs.ahH;
                if (this.aho != null) {
                    layoutParams.bottomMargin = this.ahs.ahI;
                }
                if (this.ahn.tC().booleanValue()) {
                    layoutParams.leftMargin = -this.ahs.ahM;
                    layoutParams.rightMargin = -this.ahs.ahN;
                }
                this.ahl.addView(this.ahn.getView(), layoutParams);
                this.ahn.tA();
            }
            if (this.aho != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aho.size()) {
                        break;
                    }
                    i iVar = this.aho.get(i2);
                    if (iVar != null) {
                        iVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = iVar.getTopMargin();
                        layoutParams2.bottomMargin = iVar.tI();
                        if (iVar.tC().booleanValue()) {
                            layoutParams2.leftMargin = -this.ahs.ahM;
                            layoutParams2.rightMargin = -this.ahs.ahN;
                        }
                        this.ahl.addView(iVar.getView(), layoutParams2);
                        iVar.tA();
                    }
                    i = i2 + 1;
                }
            }
            if (this.ahp != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.ahs.ahJ;
                this.ahp.a(this);
                this.ahl.addView(this.ahp.getView(), layoutParams3);
                this.ahp.tA();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.ahq)) {
                Iterator<d> it = this.ahq.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.tG() != null) {
                        if (next.tD() == null) {
                            this.ahk.addView(next.tG(), next.tF());
                        } else {
                            this.ahk.addView(next.tG(), next.tF(), next.tD());
                        }
                        next.b(this);
                        next.tA();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.ahw = i;
    }

    public int tS() {
        return this.ahw;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.tG() != null) {
            this.ahq.remove(dVar);
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
                this.ahk.addView(dVar.tG(), dVar.tF());
            } else {
                this.ahk.addView(dVar.tG(), dVar.tF(), dVar.tD());
            }
            dVar.b(this);
            dVar.tA();
            this.ahq.add(dVar);
        }
    }

    private void tT() {
        d dVar = new d();
        dVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.ahs.ahK;
        layoutParams.rightMargin = -this.ahs.ahN;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.ahq.add(dVar);
    }

    public void h(T t) {
        this.afH = t;
        if (this.ahm != null) {
            this.ahm.H(t);
        }
        if (this.ahn != null) {
            this.ahn.H(t);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.aho)) {
            for (i iVar : this.aho) {
                iVar.H(t);
            }
        }
        if (this.ahp != null) {
            this.ahp.H(t);
        }
        if (this.ahi != null) {
            this.ahi.H(t);
        }
        l(this.ahl);
        l(this.ahk);
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
        this.ahv.c(i, bVar);
    }

    public boolean b(a.C0097a c0097a) {
        return this.ahv.b(c0097a);
    }

    public void setPosition(int i) {
        if (this.ahj != null) {
            this.ahj.setPosition(i);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ahj, this.ahs.ahO);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            com.baidu.tbadk.a.b.a.aZ(this.mBottomLine);
            if (this.ahm != null) {
                this.ahm.onChangeSkinType(tbPageContext, i);
            }
            if (this.ahn != null) {
                this.ahn.onChangeSkinType(tbPageContext, i);
            }
            for (i iVar : this.aho) {
                if (iVar != null) {
                    iVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.ahp != null) {
                this.ahp.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.ahq)) {
                Iterator<d> it = this.ahq.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof q)) {
                        ((q) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.ahr != null) {
                this.ahr.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.aa<T> aaVar) {
        if (this.ahm != null) {
            this.ahm.setOnCardSubClickListener(aaVar);
        }
        if (this.ahn != null) {
            this.ahn.setOnCardSubClickListener(aaVar);
        }
        for (i iVar : this.aho) {
            if (iVar != null) {
                iVar.setOnCardSubClickListener(aaVar);
            }
        }
        if (this.ahp != null) {
            this.ahp.setOnCardSubClickListener(aaVar);
        }
        this.ahu = aaVar;
    }

    public void b(int i, a.b bVar) {
        this.ahv.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aht = str;
    }

    /* loaded from: classes21.dex */
    public static class a {
        private b ahA;
        private List<i> ahB;
        private b ahC;
        private ArrayList<d> ahq;
        private al ahs;
        private b ahz;
        private Context context;

        public a(Context context, boolean z) {
            this.ahz = null;
            this.ahA = null;
            this.ahC = null;
            this.context = context;
            this.ahq = new ArrayList<>();
            this.ahs = new al();
            if (!z) {
                this.ahs.by(0);
            }
            this.ahB = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.ahz = bVar;
            return this;
        }

        public a b(b bVar) {
            this.ahC = bVar;
            return this;
        }

        public a a(i iVar) {
            this.ahB.add(iVar);
            return this;
        }

        public a c(b bVar) {
            this.ahA = bVar;
            return this;
        }

        public ak tV() {
            return new ak(this);
        }

        public ak a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
            return new ak(this, z, viewGroup, vVar);
        }

        public al tU() {
            return this.ahs;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public al tU() {
        return this.ahs;
    }
}
