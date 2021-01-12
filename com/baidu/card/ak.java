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
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ak<T extends com.baidu.tbadk.core.data.a> implements q, com.baidu.tieba.a.e {
    private T agr;
    private p<T> aig;
    private ThreadCardView aih;
    private RelativeLayout aii;
    private LinearLayout aij;
    private com.baidu.card.a<T> aik;
    private com.baidu.card.a<T> ail;
    private List<h> aim;
    private com.baidu.card.a<T> ain;
    private ArrayList<c> aio;
    private q aip;
    private al aiq;
    private String air;
    private com.baidu.tieba.card.aa<T> ais;
    private com.baidu.card.a.a ait;
    private int aiu;
    private a.C0089a aiv;
    private Context context;
    private int mSkinType;
    private View mTopLine;

    public com.baidu.card.a<T> tf() {
        return this.ail;
    }

    public com.baidu.card.a<T> tg() {
        return this.ain;
    }

    public List<h> th() {
        return this.aim;
    }

    private ak(a aVar) {
        this(aVar, BaseCardInfo.SupportType.FULL);
    }

    private ak(a aVar, BaseCardInfo.SupportType supportType) {
        this(aVar, supportType, null);
    }

    private ak(a aVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(aVar, supportType, viewGroup, (com.baidu.adp.widget.ListView.s) null);
    }

    private ak(a aVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, com.baidu.adp.widget.ListView.s sVar) {
        this.mSkinType = 3;
        this.aig = null;
        this.aip = null;
        this.ait = new com.baidu.card.a.a();
        this.aiu = 0;
        this.aiv = new a.C0089a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.aih = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.aii = (RelativeLayout) this.aih.findViewById(R.id.card_decor_layer);
        this.aij = (LinearLayout) this.aih.findViewById(R.id.body_root);
        this.aij.setClipToPadding(false);
        this.mTopLine = this.aih.findViewById(R.id.card_top_line);
        this.aik = aVar.aix;
        this.ail = aVar.aiy;
        this.aim = aVar.aiz;
        this.ain = aVar.aiA;
        this.aio = aVar.aio;
        this.aiq = aVar.aiq;
        this.aih.setParent(viewGroup);
        this.aih.setITypeListView(sVar);
        initUI();
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.aih.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aih.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                this.aih.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL && (this.aih.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.aih.getLayoutParams();
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
            this.aih.postInvalidate();
        }
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ak.this.aiv.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ak.this.aiv.setExtraData(false);
                        break;
                }
                ak.this.b(ak.this.aiv);
                return false;
            }
        });
    }

    public View getView() {
        return this.aih;
    }

    private void initUI() {
        if (this.aiq != null) {
            if (this.aij.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aij.getLayoutParams()).setMargins(this.aiq.aiN, this.aiq.aiL, this.aiq.aiO, this.aiq.aiM);
                this.aij.postInvalidate();
            }
            if (this.aiq.aiH) {
                tj();
            }
            if (this.aik != null) {
                this.aik.a(this);
                this.aij.addView(this.aik.getView());
                this.aik.sQ();
            }
            if (this.ail != null) {
                this.ail.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.aiq.aiI;
                if (this.ail.sS().booleanValue()) {
                    layoutParams.leftMargin = -this.aiq.aiN;
                    layoutParams.rightMargin = -this.aiq.aiO;
                }
                this.aij.addView(this.ail.getView(), layoutParams);
                this.ail.sQ();
            }
            if (this.aim != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.aim.size()) {
                        break;
                    }
                    h hVar = this.aim.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.sY();
                        if (hVar.sS().booleanValue()) {
                            layoutParams2.leftMargin = -this.aiq.aiN;
                            layoutParams2.rightMargin = -this.aiq.aiO;
                        }
                        this.aij.addView(hVar.getView(), layoutParams2);
                        hVar.sQ();
                    }
                    i = i2 + 1;
                }
            }
            if (this.ain != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.aiq.aiK;
                this.ain.a(this);
                this.aij.addView(this.ain.getView(), layoutParams3);
                this.ain.sQ();
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.aio)) {
                Iterator<c> it = this.aio.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.sW() != null) {
                        if (next.sT() == null) {
                            this.aii.addView(next.sW(), next.sV());
                        } else {
                            this.aii.addView(next.sW(), next.sV(), next.sT());
                        }
                        next.b(this);
                        next.sQ();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.aiu = i;
    }

    public int ti() {
        return this.aiu;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.sW() != null) {
            this.aio.remove(cVar);
            if (cVar.sW().getParent() != null) {
                ((ViewGroup) cVar.sW().getParent()).removeView(cVar.sW());
                cVar.sU();
                cVar.b(null);
            }
        }
    }

    public void b(c cVar) {
        if (cVar != null && cVar.sW() != null) {
            a(cVar);
            cVar.sW().setVisibility(0);
            if (cVar.sT() == null) {
                this.aii.addView(cVar.sW(), cVar.sV());
            } else {
                this.aii.addView(cVar.sW(), cVar.sV(), cVar.sT());
            }
            cVar.b(this);
            cVar.sQ();
            this.aio.add(cVar);
        }
    }

    private void tj() {
        c cVar = new c();
        cVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = -this.aiq.aiO;
        cVar.a(layoutParams);
        cVar.setInsertIndex(-1);
        this.aio.add(cVar);
    }

    public void h(T t) {
        this.agr = t;
        if (this.aik != null) {
            this.aik.C(t);
        }
        if (this.ail != null) {
            this.ail.C(t);
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.aim)) {
            int size = this.aim.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.aim.get(i);
                hVar.C(t);
                if (i == 0) {
                    ay.a(hVar.getView(), ay.y(t.bkV()) && ay.z(t.bkV()) && ay.A(t.bkV()) && t.bkV().boF() < 1 && t.bkV().bnO() == null, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                }
            }
        }
        if (this.ain != null) {
            this.ain.C(t);
        }
        if (this.aig != null) {
            this.aig.C(t);
        }
        j(this.aij);
        j(this.aii);
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
        this.ait.b(i, bVar);
    }

    public boolean b(a.C0089a c0089a) {
        return this.ait.b(c0089a);
    }

    public void setPosition(int i) {
        if (this.aih != null) {
            this.aih.setPosition(i);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.agr != null && !this.agr.isSupportNone()) {
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.aih, this.aiq.aiP);
            }
            if (this.aik != null) {
                this.aik.onChangeSkinType(tbPageContext, i);
                if (this.ain == null) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(this.aih).oc(1).od(R.string.J_X06).setBackGroundColor(this.aiq.aiP);
                }
            }
            if (this.ail != null) {
                this.ail.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.aim) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.ain != null) {
                this.ain.onChangeSkinType(tbPageContext, i);
                if (this.aik == null) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(this.aih).oc(2).od(R.string.J_X06).setBackGroundColor(this.aiq.aiP);
                }
            }
            if (this.aik != null && this.ain != null) {
                com.baidu.tbadk.core.elementsMaven.c.bv(this.aih).od(R.string.J_X06).aM(this.aiq.aiP, R.color.CAM_X0206);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.aio)) {
                Iterator<c> it = this.aio.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof q)) {
                        ((q) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.aip != null) {
                this.aip.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.aa<T> aaVar) {
        if (this.aik != null) {
            this.aik.setOnCardSubClickListener(aaVar);
        }
        if (this.ail != null) {
            this.ail.setOnCardSubClickListener(aaVar);
        }
        for (h hVar : this.aim) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(aaVar);
            }
        }
        if (this.ain != null) {
            this.ain.setOnCardSubClickListener(aaVar);
        }
        this.ais = aaVar;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.air = str;
    }

    /* loaded from: classes.dex */
    public static class a {
        private com.baidu.card.a aiA;
        private ArrayList<c> aio;
        private al aiq;
        private com.baidu.card.a aix;
        private com.baidu.card.a aiy;
        private List<h> aiz;
        private Context context;

        public a(Context context, boolean z) {
            this.aix = null;
            this.aiy = null;
            this.aiA = null;
            this.context = context;
            this.aio = new ArrayList<>();
            this.aiq = new al();
            if (!z) {
                this.aiq.by(0);
            }
            this.aiz = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(com.baidu.card.a aVar) {
            this.aix = aVar;
            return this;
        }

        public a b(com.baidu.card.a aVar) {
            this.aiA = aVar;
            return this;
        }

        public a a(h hVar) {
            this.aiz.add(hVar);
            return this;
        }

        public a c(com.baidu.card.a aVar) {
            this.aiy = aVar;
            return this;
        }

        public ak tk() {
            return new ak(this);
        }

        public ak a(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            return new ak(this, supportType, viewGroup);
        }

        public ak a(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, com.baidu.adp.widget.ListView.s sVar) {
            return new ak(this, supportType, viewGroup, sVar);
        }

        public al tl() {
            return this.aiq;
        }
    }

    public Context getContext() {
        return this.context;
    }
}
