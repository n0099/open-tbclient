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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ak<T extends com.baidu.tbadk.core.data.a> implements q, com.baidu.tieba.a.e {
    private T agj;
    private p<T> ahT;
    private ThreadCardView ahU;
    private RelativeLayout ahV;
    private LinearLayout ahW;
    private com.baidu.card.a<T> ahX;
    private com.baidu.card.a<T> ahY;
    private List<h> ahZ;
    private com.baidu.card.a<T> aia;
    private ArrayList<c> aib;
    private q aic;
    private al aie;
    private String aif;
    private com.baidu.tieba.card.ab<T> aig;
    private com.baidu.card.a.a aih;
    private int aii;
    private a.C0089a aij;
    private Context context;
    private int mSkinType;
    private View mTopLine;

    public com.baidu.card.a<T> tc() {
        return this.ahY;
    }

    public com.baidu.card.a<T> td() {
        return this.aia;
    }

    public List<h> te() {
        return this.ahZ;
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
        this.ahT = null;
        this.aic = null;
        this.aih = new com.baidu.card.a.a();
        this.aii = 0;
        this.aij = new a.C0089a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.ahU = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.ahV = (RelativeLayout) this.ahU.findViewById(R.id.card_decor_layer);
        this.ahW = (LinearLayout) this.ahU.findViewById(R.id.body_root);
        this.ahW.setClipToPadding(false);
        this.mTopLine = this.ahU.findViewById(R.id.card_top_line);
        this.ahX = aVar.ail;
        this.ahY = aVar.aim;
        this.ahZ = aVar.ain;
        this.aia = aVar.aio;
        this.aib = aVar.aib;
        this.aie = aVar.aie;
        this.ahU.setParent(viewGroup);
        this.ahU.setITypeListView(sVar);
        initUI();
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.ahU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ahU.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                this.ahU.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL && (this.ahU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ahU.getLayoutParams();
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
            this.ahU.postInvalidate();
        }
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ak.this.aij.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ak.this.aij.setExtraData(false);
                        break;
                }
                ak.this.b(ak.this.aij);
                return false;
            }
        });
    }

    public View getView() {
        return this.ahU;
    }

    private void initUI() {
        if (this.aie != null) {
            if (this.ahW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ahW.getLayoutParams()).setMargins(this.aie.aiB, this.aie.aiz, this.aie.aiC, this.aie.aiA);
                this.ahW.postInvalidate();
            }
            if (this.aie.aiv) {
                tg();
            }
            if (this.ahX != null) {
                this.ahX.a(this);
                this.ahW.addView(this.ahX.getView());
                this.ahX.sN();
            }
            if (this.ahY != null) {
                this.ahY.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.aie.aiw;
                if (this.ahY.sP().booleanValue()) {
                    layoutParams.leftMargin = -this.aie.aiB;
                    layoutParams.rightMargin = -this.aie.aiC;
                }
                this.ahW.addView(this.ahY.getView(), layoutParams);
                this.ahY.sN();
            }
            if (this.ahZ != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.ahZ.size()) {
                        break;
                    }
                    h hVar = this.ahZ.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.sV();
                        if (hVar.sP().booleanValue()) {
                            layoutParams2.leftMargin = -this.aie.aiB;
                            layoutParams2.rightMargin = -this.aie.aiC;
                        }
                        this.ahW.addView(hVar.getView(), layoutParams2);
                        hVar.sN();
                    }
                    i = i2 + 1;
                }
            }
            if (this.aia != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.aie.aiy;
                this.aia.a(this);
                this.ahW.addView(this.aia.getView(), layoutParams3);
                this.aia.sN();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.aib)) {
                Iterator<c> it = this.aib.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.sT() != null) {
                        if (next.sQ() == null) {
                            this.ahV.addView(next.sT(), next.sS());
                        } else {
                            this.ahV.addView(next.sT(), next.sS(), next.sQ());
                        }
                        next.b(this);
                        next.sN();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.aii = i;
    }

    public int tf() {
        return this.aii;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.sT() != null) {
            this.aib.remove(cVar);
            if (cVar.sT().getParent() != null) {
                ((ViewGroup) cVar.sT().getParent()).removeView(cVar.sT());
                cVar.sR();
                cVar.b(null);
            }
        }
    }

    public void b(c cVar) {
        if (cVar != null && cVar.sT() != null) {
            a(cVar);
            cVar.sT().setVisibility(0);
            if (cVar.sQ() == null) {
                this.ahV.addView(cVar.sT(), cVar.sS());
            } else {
                this.ahV.addView(cVar.sT(), cVar.sS(), cVar.sQ());
            }
            cVar.b(this);
            cVar.sN();
            this.aib.add(cVar);
        }
    }

    private void tg() {
        c cVar = new c();
        cVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = -this.aie.aiC;
        cVar.a(layoutParams);
        cVar.setInsertIndex(-1);
        this.aib.add(cVar);
    }

    public void h(T t) {
        this.agj = t;
        if (this.ahX != null) {
            this.ahX.C(t);
        }
        if (this.ahY != null) {
            this.ahY.C(t);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.ahZ)) {
            int size = this.ahZ.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.ahZ.get(i);
                hVar.C(t);
                if (i == 0) {
                    az.a(hVar.getView(), az.y(t.bln()) && az.z(t.bln()) && az.A(t.bln()) && t.bln().boX() < 1 && t.bln().boh() == null, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                }
            }
        }
        if (this.aia != null) {
            this.aia.C(t);
        }
        if (this.ahT != null) {
            this.ahT.C(t);
        }
        j(this.ahW);
        j(this.ahV);
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
        this.aih.b(i, bVar);
    }

    public boolean b(a.C0089a c0089a) {
        return this.aih.b(c0089a);
    }

    public void setPosition(int i) {
        if (this.ahU != null) {
            this.ahU.setPosition(i);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.agj != null && !this.agj.isSupportNone()) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ahU, this.aie.aiD);
            }
            if (this.ahX != null) {
                this.ahX.onChangeSkinType(tbPageContext, i);
                if (this.aia == null) {
                    com.baidu.tbadk.core.elementsMaven.c.br(this.ahU).of(1).og(R.string.J_X06).setBackGroundColor(this.aie.aiD);
                }
            }
            if (this.ahY != null) {
                this.ahY.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.ahZ) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.aia != null) {
                this.aia.onChangeSkinType(tbPageContext, i);
                if (this.ahX == null) {
                    com.baidu.tbadk.core.elementsMaven.c.br(this.ahU).of(2).og(R.string.J_X06).setBackGroundColor(this.aie.aiD);
                }
            }
            if (this.ahX != null && this.aia != null) {
                com.baidu.tbadk.core.elementsMaven.c.br(this.ahU).og(R.string.J_X06).aJ(this.aie.aiD, R.color.CAM_X0206);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.aib)) {
                Iterator<c> it = this.aib.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof q)) {
                        ((q) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.aic != null) {
                this.aic.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.ahX != null) {
            this.ahX.setOnCardSubClickListener(abVar);
        }
        if (this.ahY != null) {
            this.ahY.setOnCardSubClickListener(abVar);
        }
        for (h hVar : this.ahZ) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(abVar);
            }
        }
        if (this.aia != null) {
            this.aia.setOnCardSubClickListener(abVar);
        }
        this.aig = abVar;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aif = str;
    }

    /* loaded from: classes.dex */
    public static class a {
        private ArrayList<c> aib;
        private al aie;
        private com.baidu.card.a ail;
        private com.baidu.card.a aim;
        private List<h> ain;
        private com.baidu.card.a aio;
        private Context context;

        public a(Context context, boolean z) {
            this.ail = null;
            this.aim = null;
            this.aio = null;
            this.context = context;
            this.aib = new ArrayList<>();
            this.aie = new al();
            if (!z) {
                this.aie.by(0);
            }
            this.ain = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(com.baidu.card.a aVar) {
            this.ail = aVar;
            return this;
        }

        public a b(com.baidu.card.a aVar) {
            this.aio = aVar;
            return this;
        }

        public a a(h hVar) {
            this.ain.add(hVar);
            return this;
        }

        public a c(com.baidu.card.a aVar) {
            this.aim = aVar;
            return this;
        }

        public ak th() {
            return new ak(this);
        }

        public ak a(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            return new ak(this, supportType, viewGroup);
        }

        public ak a(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, com.baidu.adp.widget.ListView.s sVar) {
            return new ak(this, supportType, viewGroup, sVar);
        }

        public al ti() {
            return this.aie;
        }
    }

    public Context getContext() {
        return this.context;
    }
}
