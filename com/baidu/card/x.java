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
    private T Fx;
    private j GA;
    private y GB;
    private String GC;
    private com.baidu.tieba.card.ab<T> GD;
    private com.baidu.card.a.a GE;
    private int GF;
    private a.C0044a GG;
    private i<T> Gr;
    private ThreadCardView Gs;
    private RelativeLayout Gt;
    private LinearLayout Gu;
    private b<T> Gv;
    private b<T> Gw;
    private List<f> Gx;
    private b<T> Gy;
    private ArrayList<c> Gz;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> lO() {
        return this.Gw;
    }

    public b<T> lP() {
        return this.Gy;
    }

    public List<f> lQ() {
        return this.Gx;
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
        this.Gr = null;
        this.GA = null;
        this.GE = new com.baidu.card.a.a();
        this.GF = 0;
        this.GG = new a.C0044a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.Gs = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.Gt = (RelativeLayout) this.Gs.findViewById(R.id.card_decor_layer);
        this.Gu = (LinearLayout) this.Gs.findViewById(R.id.body_root);
        this.mBottomLine = this.Gs.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.Gv = aVar.GI;
        this.Gw = aVar.GJ;
        this.Gx = aVar.GK;
        this.Gy = aVar.GL;
        this.Gz = aVar.Gz;
        this.GB = aVar.GB;
        this.Gs.setParent(viewGroup);
        this.Gs.setITypeListView(rVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.x.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        x.this.GG.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        x.this.GG.setExtraData(false);
                        break;
                }
                x.this.b(x.this.GG);
                return false;
            }
        });
    }

    public View getView() {
        return this.Gs;
    }

    private void initUI() {
        if (this.GB != null) {
            if (this.Gu.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) this.Gu.getLayoutParams()).setMargins(this.GB.GX, this.GB.GV, this.GB.GY, this.GB.GW);
                this.Gu.postInvalidate();
            }
            if (this.GB.GP) {
                lS();
            }
            if (this.Gv != null) {
                this.Gv.a(this);
                this.Gu.addView(this.Gv.getView());
                this.Gv.lG();
            }
            if (this.Gw != null) {
                this.Gw.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.GB.GQ;
                this.Gu.addView(this.Gw.getView(), layoutParams);
                this.Gw.lG();
            }
            if (this.Gx != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.Gx.size()) {
                        break;
                    }
                    f fVar = this.Gx.get(i2);
                    if (fVar != null) {
                        fVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = fVar.getTopMargin();
                        this.Gu.addView(fVar.getView(), layoutParams2);
                        fVar.lG();
                    }
                    i = i2 + 1;
                }
            }
            if (this.Gy != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.GB.GU;
                this.Gy.a(this);
                this.Gu.addView(this.Gy.getView(), layoutParams3);
                this.Gy.lG();
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.Gz)) {
                Iterator<c> it = this.Gz.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.lL() != null) {
                        if (next.lI() == null) {
                            this.Gt.addView(next.lL(), next.lK());
                        } else {
                            this.Gt.addView(next.lL(), next.lK(), next.lI());
                        }
                        next.b(this);
                        next.lG();
                    }
                }
            }
        }
    }

    public void aF(int i) {
        this.GF = i;
    }

    public int lR() {
        return this.GF;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.lL() != null) {
            this.Gz.remove(cVar);
            if (cVar.lL().getParent() != null) {
                ((ViewGroup) cVar.lL().getParent()).removeView(cVar.lL());
                cVar.lJ();
                cVar.b(null);
            }
            if (cVar.lI() == null) {
                this.Gt.addView(cVar.lL(), cVar.lK());
            } else {
                this.Gt.addView(cVar.lL(), cVar.lK(), cVar.lI());
            }
            cVar.b(this);
            cVar.lG();
            this.Gz.add(cVar);
        }
    }

    private void lS() {
        c cVar = new c();
        cVar.F(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.GB.GV;
        layoutParams.rightMargin = -this.GB.GY;
        cVar.a(layoutParams);
        cVar.aE(-1);
        this.Gz.add(cVar);
    }

    public void b(T t) {
        this.Fx = t;
        if (this.Gv != null) {
            this.Gv.z(t);
        }
        if (this.Gw != null) {
            this.Gw.z(t);
        }
        if (!com.baidu.tbadk.core.util.v.isEmpty(this.Gx)) {
            for (f fVar : this.Gx) {
                fVar.z(t);
            }
        }
        if (this.Gy != null) {
            this.Gy.z(t);
        }
        if (this.Gr != null) {
            this.Gr.z(t);
        }
    }

    public void a(int i, a.b bVar) {
        this.GE.c(i, bVar);
    }

    public boolean b(a.C0044a c0044a) {
        return this.GE.b(c0044a);
    }

    public void setPosition(int i) {
        if (this.Gs != null) {
            this.Gs.setPosition(i);
        }
    }

    @Override // com.baidu.card.j
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundResource(this.Gs, this.GB.GZ);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_c);
            if (this.Gv != null) {
                this.Gv.onChangeSkinType(tbPageContext, i);
            }
            if (this.Gw != null) {
                this.Gw.onChangeSkinType(tbPageContext, i);
            }
            for (f fVar : this.Gx) {
                if (fVar != null) {
                    fVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.Gy != null) {
                this.Gy.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.v.isEmpty(this.Gz)) {
                Iterator<c> it = this.Gz.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof j)) {
                        ((j) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.GA != null) {
                this.GA.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void b(com.baidu.tieba.card.ab<T> abVar) {
        if (this.Gv != null) {
            this.Gv.a(abVar);
        }
        if (this.Gw != null) {
            this.Gw.a(abVar);
        }
        for (f fVar : this.Gx) {
            if (fVar != null) {
                fVar.a(abVar);
            }
        }
        if (this.Gy != null) {
            this.Gy.a(abVar);
        }
        this.GD = abVar;
    }

    public void b(int i, a.b bVar) {
        this.GE.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.GC = str;
    }

    /* loaded from: classes3.dex */
    public static class a {
        private y GB;
        private b GI;
        private b GJ;
        private List<f> GK;
        private b GL;
        private ArrayList<c> Gz;
        private Context context;

        public a(Context context, boolean z) {
            this.GI = null;
            this.GJ = null;
            this.GL = null;
            this.context = context;
            this.Gz = new ArrayList<>();
            this.GB = new y();
            if (!z) {
                this.GB.aH(0);
            }
            this.GK = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a c(d dVar) {
            this.GI = dVar;
            return this;
        }

        public a a(b bVar) {
            this.GL = bVar;
            return this;
        }

        public a a(f fVar) {
            this.GK.add(fVar);
            return this;
        }

        public a b(b bVar) {
            this.GJ = bVar;
            return this;
        }

        public x lU() {
            return new x(this);
        }

        public x a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.r rVar) {
            return new x(this, z, viewGroup, rVar);
        }

        public y lT() {
            return this.GB;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public y lT() {
        return this.GB;
    }
}
