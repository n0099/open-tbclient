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
    private T ahi;
    private p<T> aiX;
    private ThreadCardView aiY;
    private RelativeLayout aiZ;
    private LinearLayout aja;
    private com.baidu.card.a<T> ajb;
    private com.baidu.card.a<T> ajc;
    private List<h> ajd;
    private com.baidu.card.a<T> aje;
    private ArrayList<c> ajf;
    private q ajg;
    private al ajh;
    private String aji;
    private com.baidu.tieba.card.aa<T> ajj;
    private com.baidu.card.a.a ajk;
    private int ajl;
    private a.C0090a ajm;
    private Context context;
    private int mSkinType;
    private View mTopLine;

    public com.baidu.card.a<T> tr() {
        return this.ajc;
    }

    public com.baidu.card.a<T> ts() {
        return this.aje;
    }

    public List<h> tt() {
        return this.ajd;
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
        this.aiX = null;
        this.ajg = null;
        this.ajk = new com.baidu.card.a.a();
        this.ajl = 0;
        this.ajm = new a.C0090a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.aiY = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.aiZ = (RelativeLayout) this.aiY.findViewById(R.id.card_decor_layer);
        this.aja = (LinearLayout) this.aiY.findViewById(R.id.body_root);
        this.aja.setClipToPadding(false);
        this.mTopLine = this.aiY.findViewById(R.id.card_top_line);
        this.ajb = aVar.ajo;
        this.ajc = aVar.ajp;
        this.ajd = aVar.ajq;
        this.aje = aVar.ajr;
        this.ajf = aVar.ajf;
        this.ajh = aVar.ajh;
        this.aiY.setParent(viewGroup);
        this.aiY.setITypeListView(sVar);
        initUI();
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.aiY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aiY.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                this.aiY.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL && (this.aiY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.aiY.getLayoutParams();
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
            this.aiY.postInvalidate();
        }
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ak.this.ajm.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ak.this.ajm.setExtraData(false);
                        break;
                }
                ak.this.b(ak.this.ajm);
                return false;
            }
        });
    }

    public View getView() {
        return this.aiY;
    }

    private void initUI() {
        if (this.ajh != null) {
            if (this.aja.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aja.getLayoutParams()).setMargins(this.ajh.ajE, this.ajh.ajC, this.ajh.ajF, this.ajh.ajD);
                this.aja.postInvalidate();
            }
            if (this.ajh.ajy) {
                tv();
            }
            if (this.ajb != null) {
                this.ajb.a(this);
                this.aja.addView(this.ajb.getView());
                this.ajb.tb();
            }
            if (this.ajc != null) {
                this.ajc.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.ajh.ajz;
                if (this.ajc.td().booleanValue()) {
                    layoutParams.leftMargin = -this.ajh.ajE;
                    layoutParams.rightMargin = -this.ajh.ajF;
                }
                this.aja.addView(this.ajc.getView(), layoutParams);
                this.ajc.tb();
            }
            if (this.ajd != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.ajd.size()) {
                        break;
                    }
                    h hVar = this.ajd.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.tj();
                        if (hVar.td().booleanValue()) {
                            layoutParams2.leftMargin = -this.ajh.ajE;
                            layoutParams2.rightMargin = -this.ajh.ajF;
                        }
                        this.aja.addView(hVar.getView(), layoutParams2);
                        hVar.tb();
                    }
                    i = i2 + 1;
                }
            }
            if (this.aje != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.ajh.ajB;
                this.aje.a(this);
                this.aja.addView(this.aje.getView(), layoutParams3);
                this.aje.tb();
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.ajf)) {
                Iterator<c> it = this.ajf.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.th() != null) {
                        if (next.te() == null) {
                            this.aiZ.addView(next.th(), next.tg());
                        } else {
                            this.aiZ.addView(next.th(), next.tg(), next.te());
                        }
                        next.b(this);
                        next.tb();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.ajl = i;
    }

    public int tu() {
        return this.ajl;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.th() != null) {
            this.ajf.remove(cVar);
            if (cVar.th().getParent() != null) {
                ((ViewGroup) cVar.th().getParent()).removeView(cVar.th());
                cVar.tf();
                cVar.b(null);
            }
        }
    }

    public void b(c cVar) {
        if (cVar != null && cVar.th() != null) {
            a(cVar);
            cVar.th().setVisibility(0);
            if (cVar.te() == null) {
                this.aiZ.addView(cVar.th(), cVar.tg());
            } else {
                this.aiZ.addView(cVar.th(), cVar.tg(), cVar.te());
            }
            cVar.b(this);
            cVar.tb();
            this.ajf.add(cVar);
        }
    }

    private void tv() {
        c cVar = new c();
        cVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = -this.ajh.ajF;
        cVar.a(layoutParams);
        cVar.setInsertIndex(-1);
        this.ajf.add(cVar);
    }

    public void h(T t) {
        this.ahi = t;
        if (this.ajb != null) {
            this.ajb.D(t);
        }
        if (this.ajc != null) {
            this.ajc.D(t);
        }
        if (!com.baidu.tbadk.core.util.x.isEmpty(this.ajd)) {
            int size = this.ajd.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.ajd.get(i);
                hVar.D(t);
                if (i == 0) {
                    ay.a(hVar.getView(), ay.y(t.boO()) && ay.z(t.boO()) && ay.A(t.boO()) && t.boO().bsy() < 1 && t.boO().brH() == null, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                }
            }
        }
        if (this.aje != null) {
            this.aje.D(t);
        }
        if (this.aiX != null) {
            this.aiX.D(t);
        }
        j(this.aja);
        j(this.aiZ);
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
        this.ajk.b(i, bVar);
    }

    public boolean b(a.C0090a c0090a) {
        return this.ajk.b(c0090a);
    }

    public void setPosition(int i) {
        if (this.aiY != null) {
            this.aiY.setPosition(i);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.ahi != null && !this.ahi.isSupportNone()) {
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.aiY, this.ajh.ajG);
            }
            if (this.ajb != null) {
                this.ajb.onChangeSkinType(tbPageContext, i);
                if (this.aje == null) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(this.aiY).pJ(1).pK(R.string.J_X06).setBackGroundColor(this.ajh.ajG);
                }
            }
            if (this.ajc != null) {
                this.ajc.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.ajd) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.aje != null) {
                this.aje.onChangeSkinType(tbPageContext, i);
                if (this.ajb == null) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(this.aiY).pJ(2).pK(R.string.J_X06).setBackGroundColor(this.ajh.ajG);
                }
            }
            if (this.ajb != null && this.aje != null) {
                com.baidu.tbadk.core.elementsMaven.c.bv(this.aiY).pK(R.string.J_X06).aM(this.ajh.ajG, R.color.CAM_X0206);
            }
            if (!com.baidu.tbadk.core.util.x.isEmpty(this.ajf)) {
                Iterator<c> it = this.ajf.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof q)) {
                        ((q) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.ajg != null) {
                this.ajg.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.aa<T> aaVar) {
        if (this.ajb != null) {
            this.ajb.setOnCardSubClickListener(aaVar);
        }
        if (this.ajc != null) {
            this.ajc.setOnCardSubClickListener(aaVar);
        }
        for (h hVar : this.ajd) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(aaVar);
            }
        }
        if (this.aje != null) {
            this.aje.setOnCardSubClickListener(aaVar);
        }
        this.ajj = aaVar;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aji = str;
    }

    /* loaded from: classes.dex */
    public static class a {
        private ArrayList<c> ajf;
        private al ajh;
        private com.baidu.card.a ajo;
        private com.baidu.card.a ajp;
        private List<h> ajq;
        private com.baidu.card.a ajr;
        private Context context;

        public a(Context context, boolean z) {
            this.ajo = null;
            this.ajp = null;
            this.ajr = null;
            this.context = context;
            this.ajf = new ArrayList<>();
            this.ajh = new al();
            if (!z) {
                this.ajh.bA(0);
            }
            this.ajq = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(com.baidu.card.a aVar) {
            this.ajo = aVar;
            return this;
        }

        public a b(com.baidu.card.a aVar) {
            this.ajr = aVar;
            return this;
        }

        public a a(h hVar) {
            this.ajq.add(hVar);
            return this;
        }

        public a c(com.baidu.card.a aVar) {
            this.ajp = aVar;
            return this;
        }

        public ak tw() {
            return new ak(this);
        }

        public ak a(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            return new ak(this, supportType, viewGroup);
        }

        public ak a(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, com.baidu.adp.widget.ListView.s sVar) {
            return new ak(this, supportType, viewGroup, sVar);
        }

        public al tx() {
            return this.ajh;
        }
    }

    public Context getContext() {
        return this.context;
    }
}
