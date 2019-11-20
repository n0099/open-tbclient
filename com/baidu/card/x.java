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
/* loaded from: classes3.dex */
public class x<T extends com.baidu.tbadk.core.data.a> implements j, com.baidu.tieba.a.e {
    private T EX;
    private i<T> FQ;
    private ThreadCardView FR;
    private RelativeLayout FT;
    private LinearLayout FU;
    private b<T> FV;
    private b<T> FW;
    private List<f> FX;
    private b<T> FY;
    private ArrayList<c> FZ;
    private j Ga;
    private y Gb;
    private String Gc;
    private com.baidu.tieba.card.ab<T> Gd;
    private com.baidu.card.a.a Ge;
    private int Gf;
    private a.C0044a Gg;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> lO() {
        return this.FW;
    }

    public b<T> lP() {
        return this.FY;
    }

    public List<f> lQ() {
        return this.FX;
    }

    private x(a aVar) {
        this(aVar, true);
    }

    private x(a aVar, boolean z) {
        this(aVar, z, null);
    }

    private x(a aVar, boolean z, ViewGroup viewGroup) {
        this(aVar, z, viewGroup, null);
    }

    private x(a aVar, boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
        this.mSkinType = 3;
        this.FQ = null;
        this.Ga = null;
        this.Ge = new com.baidu.card.a.a();
        this.Gf = 0;
        this.Gg = new a.C0044a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.FR = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.FT = (RelativeLayout) this.FR.findViewById(R.id.card_decor_layer);
        this.FU = (LinearLayout) this.FR.findViewById(R.id.body_root);
        this.mBottomLine = this.FR.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.FV = aVar.Gi;
        this.FW = aVar.Gj;
        this.FX = aVar.Gk;
        this.FY = aVar.Gl;
        this.FZ = aVar.FZ;
        this.Gb = aVar.Gb;
        this.FR.setParent(viewGroup);
        this.FR.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.x.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        x.this.Gg.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        x.this.Gg.setExtraData(false);
                        break;
                }
                x.this.b(x.this.Gg);
                return false;
            }
        });
    }

    public View getView() {
        return this.FR;
    }

    private void initUI() {
        if (this.Gb != null) {
            if (this.FU.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.FU.getLayoutParams()).setMargins(this.Gb.Gv, this.Gb.Gt, this.Gb.Gw, this.Gb.Gu);
                this.FU.postInvalidate();
            }
            if (this.Gb.Gp) {
                lS();
            }
            if (this.FV != null) {
                this.FV.a(this);
                this.FU.addView(this.FV.getView());
                this.FV.lG();
            }
            if (this.FW != null) {
                this.FW.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.Gb.Gq;
                this.FU.addView(this.FW.getView(), layoutParams);
                this.FW.lG();
            }
            if (this.FX != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.FX.size()) {
                        break;
                    }
                    f fVar = this.FX.get(i2);
                    if (fVar != null) {
                        fVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = fVar.getTopMargin();
                        this.FU.addView(fVar.getView(), layoutParams2);
                        fVar.lG();
                    }
                    i = i2 + 1;
                }
            }
            if (this.FY != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.Gb.Gs;
                this.FY.a(this);
                this.FU.addView(this.FY.getView(), layoutParams3);
                this.FY.lG();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.FZ)) {
                Iterator<c> it = this.FZ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.lL() != null) {
                        if (next.lI() == null) {
                            this.FT.addView(next.lL(), next.lK());
                        } else {
                            this.FT.addView(next.lL(), next.lK(), next.lI());
                        }
                        next.b(this);
                        next.lG();
                    }
                }
            }
        }
    }

    public void aF(int i) {
        this.Gf = i;
    }

    public int lR() {
        return this.Gf;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.lL() != null) {
            this.FZ.remove(cVar);
            if (cVar.lL().getParent() != null) {
                ((ViewGroup) cVar.lL().getParent()).removeView(cVar.lL());
                cVar.lJ();
                cVar.b(null);
            }
            if (cVar.lI() == null) {
                this.FT.addView(cVar.lL(), cVar.lK());
            } else {
                this.FT.addView(cVar.lL(), cVar.lK(), cVar.lI());
            }
            cVar.b(this);
            cVar.lG();
            this.FZ.add(cVar);
        }
    }

    private void lS() {
        c cVar = new c();
        cVar.F(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.Gb.Gt;
        layoutParams.rightMargin = -this.Gb.Gw;
        cVar.a(layoutParams);
        cVar.aE(-1);
        this.FZ.add(cVar);
    }

    public void b(T t) {
        this.EX = t;
        if (this.FV != null) {
            this.FV.z(t);
        }
        if (this.FW != null) {
            this.FW.z(t);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.FX)) {
            for (f fVar : this.FX) {
                fVar.z(t);
            }
        }
        if (this.FY != null) {
            this.FY.z(t);
        }
        if (this.FQ != null) {
            this.FQ.z(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.Ge.c(i, bVar);
    }

    public boolean b(a.C0044a c0044a) {
        return this.Ge.b(c0044a);
    }

    public void setPosition(int i) {
        if (this.FR != null) {
            this.FR.setPosition(i);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.FR, this.Gb.Gx);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_c);
            if (this.FV != null) {
                this.FV.onChangeSkinType(tbPageContext, i);
            }
            if (this.FW != null) {
                this.FW.onChangeSkinType(tbPageContext, i);
            }
            for (f fVar : this.FX) {
                if (fVar != null) {
                    fVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.FY != null) {
                this.FY.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.FZ)) {
                Iterator<c> it = this.FZ.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof j)) {
                        ((j) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.Ga != null) {
                this.Ga.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void b(com.baidu.tieba.card.ab<T> abVar) {
        if (this.FV != null) {
            this.FV.a(abVar);
        }
        if (this.FW != null) {
            this.FW.a(abVar);
        }
        for (f fVar : this.FX) {
            if (fVar != null) {
                fVar.a(abVar);
            }
        }
        if (this.FY != null) {
            this.FY.a(abVar);
        }
        this.Gd = abVar;
    }

    public void b(int i, a.b bVar) {
        this.Ge.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.Gc = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private ArrayList<c> FZ;
        private y Gb;
        private b Gi;
        private b Gj;
        private List<f> Gk;
        private b Gl;
        private Context context;

        public a(Context context, boolean z) {
            this.Gi = null;
            this.Gj = null;
            this.Gl = null;
            this.context = context;
            this.FZ = new ArrayList<>();
            this.Gb = new y();
            if (!z) {
                this.Gb.aH(0);
            }
            this.Gk = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a c(d dVar) {
            this.Gi = dVar;
            return this;
        }

        public a a(b bVar) {
            this.Gl = bVar;
            return this;
        }

        public a a(f fVar) {
            this.Gk.add(fVar);
            return this;
        }

        public a b(b bVar) {
            this.Gj = bVar;
            return this;
        }

        public x lU() {
            return new x(this);
        }

        public x a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new x(this, z, viewGroup, rVar);
        }

        public y lT() {
            return this.Gb;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public y lT() {
        return this.Gb;
    }
}
