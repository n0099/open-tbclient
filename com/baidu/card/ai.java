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
public class ai<T extends AbsThreadDataSupport> implements o, com.baidu.tieba.a.e {
    private T adQ;
    private int afA;
    private a.C0096a afB;
    private n<T> afm;
    private ThreadCardView afn;
    private RelativeLayout afo;
    private LinearLayout afp;
    private b<T> afq;
    private b<T> afr;
    private List<h> afs;
    private b<T> aft;
    private ArrayList<d> afu;
    private o afv;
    private aj afw;
    private String afx;
    private com.baidu.tieba.card.aa<T> afy;
    private com.baidu.card.a.a afz;
    private Context context;
    private View mBottomLine;
    private int mSkinType;

    public b<T> rZ() {
        return this.afr;
    }

    public b<T> sa() {
        return this.aft;
    }

    public List<h> sb() {
        return this.afs;
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
        this.afm = null;
        this.afv = null;
        this.afz = new com.baidu.card.a.a();
        this.afA = 0;
        this.afB = new a.C0096a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.afn = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.afo = (RelativeLayout) this.afn.findViewById(R.id.card_decor_layer);
        this.afp = (LinearLayout) this.afn.findViewById(R.id.body_root);
        this.afp.setPadding(this.afp.getPaddingLeft(), this.afp.getPaddingTop(), this.afp.getPaddingRight(), com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), com.baidu.tbadk.a.b.a.aE(R.dimen.tbds20, R.dimen.tbds0)));
        this.mBottomLine = this.afn.findViewById(R.id.card_bottom_line);
        if (z) {
            this.mBottomLine.setVisibility(0);
        }
        this.afq = aVar.afD;
        this.afr = aVar.afE;
        this.afs = aVar.afF;
        this.aft = aVar.afG;
        this.afu = aVar.afu;
        this.afw = aVar.afw;
        this.afn.setParent(viewGroup);
        this.afn.setITypeListView(vVar);
        initUI();
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ai.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ai.this.afB.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ai.this.afB.setExtraData(false);
                        break;
                }
                ai.this.b(ai.this.afB);
                return false;
            }
        });
    }

    public View getView() {
        return this.afn;
    }

    private void initUI() {
        if (this.afw != null) {
            if (this.afp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.afp.getLayoutParams()).setMargins(this.afw.afQ, this.afw.afO, this.afw.afR, this.afw.afP);
                this.afp.postInvalidate();
            }
            if (this.afw.afK) {
                sd();
            }
            if (this.afq != null) {
                this.afq.a(this);
                this.afp.addView(this.afq.getView());
                this.afq.rK();
            }
            if (this.afr != null) {
                this.afr.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.afw.afL;
                if (this.afs != null) {
                    layoutParams.bottomMargin = this.afw.afM;
                }
                if (this.afr.rM().booleanValue()) {
                    layoutParams.leftMargin = -this.afw.afQ;
                    layoutParams.rightMargin = -this.afw.afR;
                }
                this.afp.addView(this.afr.getView(), layoutParams);
                this.afr.rK();
            }
            if (this.afs != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.afs.size()) {
                        break;
                    }
                    h hVar = this.afs.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.rS();
                        if (hVar.rM().booleanValue()) {
                            layoutParams2.leftMargin = -this.afw.afQ;
                            layoutParams2.rightMargin = -this.afw.afR;
                        }
                        this.afp.addView(hVar.getView(), layoutParams2);
                        hVar.rK();
                    }
                    i = i2 + 1;
                }
            }
            if (this.aft != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.afw.afN;
                this.aft.a(this);
                this.afp.addView(this.aft.getView(), layoutParams3);
                this.aft.rK();
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.afu)) {
                Iterator<d> it = this.afu.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.rQ() != null) {
                        if (next.rN() == null) {
                            this.afo.addView(next.rQ(), next.rP());
                        } else {
                            this.afo.addView(next.rQ(), next.rP(), next.rN());
                        }
                        next.b(this);
                        next.rK();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.afA = i;
    }

    public int sc() {
        return this.afA;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.rQ() != null) {
            this.afu.remove(dVar);
            if (dVar.rQ().getParent() != null) {
                ((ViewGroup) dVar.rQ().getParent()).removeView(dVar.rQ());
                dVar.rO();
                dVar.b(null);
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null && dVar.rQ() != null) {
            a(dVar);
            dVar.rQ().setVisibility(0);
            if (dVar.rN() == null) {
                this.afo.addView(dVar.rQ(), dVar.rP());
            } else {
                this.afo.addView(dVar.rQ(), dVar.rP(), dVar.rN());
            }
            dVar.b(this);
            dVar.rK();
            this.afu.add(dVar);
        }
    }

    private void sd() {
        d dVar = new d();
        dVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = -this.afw.afO;
        layoutParams.rightMargin = -this.afw.afR;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.afu.add(dVar);
    }

    public void g(T t) {
        this.adQ = t;
        if (this.afq != null) {
            this.afq.D(t);
        }
        if (this.afr != null) {
            this.afr.D(t);
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.afs)) {
            for (h hVar : this.afs) {
                hVar.D(t);
            }
        }
        if (this.aft != null) {
            this.aft.D(t);
        }
        if (this.afm != null) {
            this.afm.D(t);
        }
        j(this.afp);
        j(this.afo);
        com.baidu.tbadk.a.b.a.a(this.mBottomLine, t);
    }

    private void j(ViewGroup viewGroup) {
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
        this.afz.c(i, bVar);
    }

    public boolean b(a.C0096a c0096a) {
        return this.afz.b(c0096a);
    }

    public void setPosition(int i) {
        if (this.afn != null) {
            this.afn.setPosition(i);
        }
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.afn, this.afw.afS);
        if (i != this.mSkinType) {
            this.mSkinType = i;
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.mBottomLine, R.color.cp_bg_line_b);
            com.baidu.tbadk.a.b.a.aU(this.mBottomLine);
            if (this.afq != null) {
                this.afq.onChangeSkinType(tbPageContext, i);
            }
            if (this.afr != null) {
                this.afr.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.afs) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.aft != null) {
                this.aft.onChangeSkinType(tbPageContext, i);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.afu)) {
                Iterator<d> it = this.afu.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof o)) {
                        ((o) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.afv != null) {
                this.afv.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.aa<T> aaVar) {
        if (this.afq != null) {
            this.afq.setOnCardSubClickListener(aaVar);
        }
        if (this.afr != null) {
            this.afr.setOnCardSubClickListener(aaVar);
        }
        for (h hVar : this.afs) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(aaVar);
            }
        }
        if (this.aft != null) {
            this.aft.setOnCardSubClickListener(aaVar);
        }
        this.afy = aaVar;
    }

    public void b(int i, a.b bVar) {
        this.afz.d(i, bVar);
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.afx = str;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private b afD;
        private b afE;
        private List<h> afF;
        private b afG;
        private ArrayList<d> afu;
        private aj afw;
        private Context context;

        public a(Context context, boolean z) {
            this.afD = null;
            this.afE = null;
            this.afG = null;
            this.context = context;
            this.afu = new ArrayList<>();
            this.afw = new aj();
            if (!z) {
                this.afw.bp(0);
            }
            this.afF = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.afD = bVar;
            return this;
        }

        public a b(b bVar) {
            this.afG = bVar;
            return this;
        }

        public a a(h hVar) {
            this.afF.add(hVar);
            return this;
        }

        public a c(b bVar) {
            this.afE = bVar;
            return this;
        }

        public ai sf() {
            return new ai(this);
        }

        public ai a(boolean z, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
            return new ai(this, z, viewGroup, vVar);
        }

        public aj se() {
            return this.afw;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public aj se() {
        return this.afw;
    }
}
