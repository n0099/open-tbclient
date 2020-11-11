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
    private T afI;
    private p<T> ahj;
    private ThreadCardView ahk;
    private RelativeLayout ahl;
    private LinearLayout ahm;
    private b<T> ahn;
    private b<T> aho;
    private List<i> ahp;
    private b<T> ahq;
    private ArrayList<d> ahr;
    private q ahs;
    private al aht;
    private String ahu;
    private com.baidu.tieba.card.ab<T> ahv;
    private com.baidu.card.a.a ahw;
    private int ahx;
    private a.C0097a ahy;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> tP() {
        return this.aho;
    }

    public b<T> tQ() {
        return this.ahq;
    }

    public List<i> tR() {
        return this.ahp;
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
        this.ahj = null;
        this.ahs = null;
        this.ahw = new com.baidu.card.a.a();
        this.ahx = 0;
        this.ahy = new a.C0097a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.ahk = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.ahl = (RelativeLayout) this.ahk.findViewById(R.id.card_decor_layer);
        this.ahm = (LinearLayout) this.ahk.findViewById(R.id.body_root);
        this.ahm.setPadding(this.ahm.getPaddingLeft(), this.ahm.getPaddingTop(), this.ahm.getPaddingRight(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), com.baidu.tbadk.a.b.a.aL(R.dimen.tbds20, R.dimen.tbds0)));
        this.mBottomLine = this.ahk.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.ahn = aVar.ahA;
        this.aho = aVar.ahB;
        this.ahp = aVar.ahC;
        this.ahq = aVar.ahD;
        this.ahr = aVar.ahr;
        this.aht = aVar.aht;
        this.ahk.setParent(viewGroup);
        this.ahk.setITypeListView(vVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ak.this.ahy.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ak.this.ahy.setExtraData(false);
                        break;
                }
                ak.this.b(ak.this.ahy);
                return false;
            }
        });
    }

    public View getView() {
        return this.ahk;
    }

    private void initUI() {
        if (this.aht != null) {
            if (this.ahm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ahm.getLayoutParams()).setMargins(this.aht.ahN, this.aht.ahL, this.aht.ahO, this.aht.ahM);
                this.ahm.postInvalidate();
            }
            if (this.aht.ahH) {
                tT();
            }
            if (this.ahn != null) {
                this.ahn.a(this);
                this.ahm.addView(this.ahn.getView());
                this.ahn.tA();
            }
            if (this.aho != null) {
                this.aho.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.aht.ahI;
                if (this.ahp != null) {
                    layoutParams.bottomMargin = this.aht.ahJ;
                }
                if (this.aho.tC().booleanValue()) {
                    layoutParams.leftMargin = -this.aht.ahN;
                    layoutParams.rightMargin = -this.aht.ahO;
                }
                this.ahm.addView(this.aho.getView(), layoutParams);
                this.aho.tA();
            }
            if (this.ahp != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.ahp.size()) {
                        break;
                    }
                    i iVar = this.ahp.get(i2);
                    if (iVar != null) {
                        iVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = iVar.getTopMargin();
                        layoutParams2.bottomMargin = iVar.tI();
                        if (iVar.tC().booleanValue()) {
                            layoutParams2.leftMargin = -this.aht.ahN;
                            layoutParams2.rightMargin = -this.aht.ahO;
                        }
                        this.ahm.addView(iVar.getView(), layoutParams2);
                        iVar.tA();
                    }
                    i = i2 + 1;
                }
            }
            if (this.ahq != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.aht.ahK;
                this.ahq.a(this);
                this.ahm.addView(this.ahq.getView(), layoutParams3);
                this.ahq.tA();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.ahr)) {
                Iterator<d> it = this.ahr.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.tG() != null) {
                        if (next.tD() == null) {
                            this.ahl.addView(next.tG(), next.tF());
                        } else {
                            this.ahl.addView(next.tG(), next.tF(), next.tD());
                        }
                        next.b(this);
                        next.tA();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.ahx = i;
    }

    public int tS() {
        return this.ahx;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.tG() != null) {
            this.ahr.remove(dVar);
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
                this.ahl.addView(dVar.tG(), dVar.tF());
            } else {
                this.ahl.addView(dVar.tG(), dVar.tF(), dVar.tD());
            }
            dVar.b(this);
            dVar.tA();
            this.ahr.add(dVar);
        }
    }

    private void tT() {
        d dVar = new d();
        dVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.aht.ahL;
        layoutParams.rightMargin = -this.aht.ahO;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.ahr.add(dVar);
    }

    public void h(T t) {
        this.afI = t;
        if (this.ahn != null) {
            this.ahn.H(t);
        }
        if (this.aho != null) {
            this.aho.H(t);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.ahp)) {
            for (i iVar : this.ahp) {
                iVar.H(t);
            }
        }
        if (this.ahq != null) {
            this.ahq.H(t);
        }
        if (this.ahj != null) {
            this.ahj.H(t);
        }
        l(this.ahm);
        l(this.ahl);
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
        this.ahw.c(i, bVar);
    }

    public boolean b(a.C0097a c0097a) {
        return this.ahw.b(c0097a);
    }

    public void setPosition(int i) {
        if (this.ahk != null) {
            this.ahk.setPosition(i);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ahk, this.aht.ahP);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            com.baidu.tbadk.a.b.a.be(this.mBottomLine);
            if (this.ahn != null) {
                this.ahn.onChangeSkinType(tbPageContext, i);
            }
            if (this.aho != null) {
                this.aho.onChangeSkinType(tbPageContext, i);
            }
            for (i iVar : this.ahp) {
                if (iVar != null) {
                    iVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.ahq != null) {
                this.ahq.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.ahr)) {
                Iterator<d> it = this.ahr.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof q)) {
                        ((q) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.ahs != null) {
                this.ahs.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.ahn != null) {
            this.ahn.setOnCardSubClickListener(abVar);
        }
        if (this.aho != null) {
            this.aho.setOnCardSubClickListener(abVar);
        }
        for (i iVar : this.ahp) {
            if (iVar != null) {
                iVar.setOnCardSubClickListener(abVar);
            }
        }
        if (this.ahq != null) {
            this.ahq.setOnCardSubClickListener(abVar);
        }
        this.ahv = abVar;
    }

    public void b(int i, a.b bVar) {
        this.ahw.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahu = str;
    }

    /* loaded from: classes21.dex */
    public static class a {
        private b ahA;
        private b ahB;
        private List<i> ahC;
        private b ahD;
        private ArrayList<d> ahr;
        private al aht;
        private Context context;

        public a(Context context, boolean z) {
            this.ahA = null;
            this.ahB = null;
            this.ahD = null;
            this.context = context;
            this.ahr = new ArrayList<>();
            this.aht = new al();
            if (!z) {
                this.aht.by(0);
            }
            this.ahC = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.ahA = bVar;
            return this;
        }

        public a b(b bVar) {
            this.ahD = bVar;
            return this;
        }

        public a a(i iVar) {
            this.ahC.add(iVar);
            return this;
        }

        public a c(b bVar) {
            this.ahB = bVar;
            return this;
        }

        public ak tV() {
            return new ak(this);
        }

        public ak a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
            return new ak(this, z, viewGroup, vVar);
        }

        public al tU() {
            return this.aht;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public al tU() {
        return this.aht;
    }
}
