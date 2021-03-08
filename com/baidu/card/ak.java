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
    private T ahB;
    private int ajA;
    private a.C0095a ajB;
    private p<T> ajm;
    private ThreadCardView ajn;
    private RelativeLayout ajo;
    private LinearLayout ajp;
    private com.baidu.card.a<T> ajq;
    private com.baidu.card.a<T> ajr;
    private List<h> ajs;
    private com.baidu.card.a<T> ajt;
    private ArrayList<c> aju;
    private q ajv;
    private al ajw;
    private String ajx;
    private com.baidu.tieba.card.ab<T> ajy;
    private com.baidu.card.a.a ajz;
    private Context context;
    private int mSkinType;
    private View mTopLine;

    public com.baidu.card.a<T> tc() {
        return this.ajr;
    }

    public com.baidu.card.a<T> td() {
        return this.ajt;
    }

    public List<h> te() {
        return this.ajs;
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
        this.ajm = null;
        this.ajv = null;
        this.ajz = new com.baidu.card.a.a();
        this.ajA = 0;
        this.ajB = new a.C0095a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.ajn = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.ajo = (RelativeLayout) this.ajn.findViewById(R.id.card_decor_layer);
        this.ajp = (LinearLayout) this.ajn.findViewById(R.id.body_root);
        this.ajp.setClipToPadding(false);
        this.mTopLine = this.ajn.findViewById(R.id.card_top_line);
        this.ajq = aVar.ajD;
        this.ajr = aVar.ajE;
        this.ajs = aVar.ajF;
        this.ajt = aVar.ajG;
        this.aju = aVar.aju;
        this.ajw = aVar.ajw;
        this.ajn.setParent(viewGroup);
        this.ajn.setITypeListView(sVar);
        initUI();
        if (supportType == BaseCardInfo.SupportType.TOP) {
            if (this.ajn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ajn.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                this.ajn.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL && (this.ajn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ajn.getLayoutParams();
            marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
            this.ajn.postInvalidate();
        }
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ak.this.ajB.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ak.this.ajB.setExtraData(false);
                        break;
                }
                ak.this.b(ak.this.ajB);
                return false;
            }
        });
    }

    public View getView() {
        return this.ajn;
    }

    private void initUI() {
        if (this.ajw != null) {
            if (this.ajp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ajp.getLayoutParams()).setMargins(this.ajw.ajT, this.ajw.ajR, this.ajw.ajU, this.ajw.ajS);
                this.ajp.postInvalidate();
            }
            if (this.ajw.ajN) {
                tg();
            }
            if (this.ajq != null) {
                this.ajq.a(this);
                this.ajp.addView(this.ajq.getView());
                this.ajq.sN();
            }
            if (this.ajr != null) {
                this.ajr.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.ajw.ajO;
                if (this.ajr.sP().booleanValue()) {
                    layoutParams.leftMargin = -this.ajw.ajT;
                    layoutParams.rightMargin = -this.ajw.ajU;
                }
                this.ajp.addView(this.ajr.getView(), layoutParams);
                this.ajr.sN();
            }
            if (this.ajs != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.ajs.size()) {
                        break;
                    }
                    h hVar = this.ajs.get(i2);
                    if (hVar != null) {
                        hVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = hVar.getTopMargin();
                        layoutParams2.bottomMargin = hVar.sV();
                        if (hVar.sP().booleanValue()) {
                            layoutParams2.leftMargin = -this.ajw.ajT;
                            layoutParams2.rightMargin = -this.ajw.ajU;
                        }
                        this.ajp.addView(hVar.getView(), layoutParams2);
                        hVar.sN();
                    }
                    i = i2 + 1;
                }
            }
            if (this.ajt != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.ajw.ajQ;
                this.ajt.a(this);
                this.ajp.addView(this.ajt.getView(), layoutParams3);
                this.ajt.sN();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.aju)) {
                Iterator<c> it = this.aju.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.sT() != null) {
                        if (next.sQ() == null) {
                            this.ajo.addView(next.sT(), next.sS());
                        } else {
                            this.ajo.addView(next.sT(), next.sS(), next.sQ());
                        }
                        next.b(this);
                        next.sN();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.ajA = i;
    }

    public int tf() {
        return this.ajA;
    }

    public void a(c cVar) {
        if (cVar != null && cVar.sT() != null) {
            this.aju.remove(cVar);
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
                this.ajo.addView(cVar.sT(), cVar.sS());
            } else {
                this.ajo.addView(cVar.sT(), cVar.sS(), cVar.sQ());
            }
            cVar.b(this);
            cVar.sN();
            this.aju.add(cVar);
        }
    }

    private void tg() {
        c cVar = new c();
        cVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = -this.ajw.ajU;
        cVar.a(layoutParams);
        cVar.setInsertIndex(-1);
        this.aju.add(cVar);
    }

    public void h(T t) {
        this.ahB = t;
        if (this.ajq != null) {
            this.ajq.E(t);
        }
        if (this.ajr != null) {
            this.ajr.E(t);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.ajs)) {
            int size = this.ajs.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.ajs.get(i);
                hVar.E(t);
                if (i == 0) {
                    az.a(hVar.getView(), az.y(t.blp()) && az.z(t.blp()) && az.A(t.blp()) && t.blp().boZ() < 1 && t.blp().boj() == null, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                }
            }
        }
        if (this.ajt != null) {
            this.ajt.E(t);
        }
        if (this.ajm != null) {
            this.ajm.E(t);
        }
        j(this.ajp);
        j(this.ajo);
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
        this.ajz.b(i, bVar);
    }

    public boolean b(a.C0095a c0095a) {
        return this.ajz.b(c0095a);
    }

    public void setPosition(int i) {
        if (this.ajn != null) {
            this.ajn.setPosition(i);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.ahB != null && !this.ahB.isSupportNone()) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ajn, this.ajw.ajV);
            }
            if (this.ajq != null) {
                this.ajq.onChangeSkinType(tbPageContext, i);
                if (this.ajt == null) {
                    com.baidu.tbadk.core.elementsMaven.c.br(this.ajn).og(1).oh(R.string.J_X06).setBackGroundColor(this.ajw.ajV);
                }
            }
            if (this.ajr != null) {
                this.ajr.onChangeSkinType(tbPageContext, i);
            }
            for (h hVar : this.ajs) {
                if (hVar != null) {
                    hVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.ajt != null) {
                this.ajt.onChangeSkinType(tbPageContext, i);
                if (this.ajq == null) {
                    com.baidu.tbadk.core.elementsMaven.c.br(this.ajn).og(2).oh(R.string.J_X06).setBackGroundColor(this.ajw.ajV);
                }
            }
            if (this.ajq != null && this.ajt != null) {
                com.baidu.tbadk.core.elementsMaven.c.br(this.ajn).oh(R.string.J_X06).aJ(this.ajw.ajV, R.color.CAM_X0206);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.aju)) {
                Iterator<c> it = this.aju.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && (next instanceof q)) {
                        ((q) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.ajv != null) {
                this.ajv.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.ajq != null) {
            this.ajq.setOnCardSubClickListener(abVar);
        }
        if (this.ajr != null) {
            this.ajr.setOnCardSubClickListener(abVar);
        }
        for (h hVar : this.ajs) {
            if (hVar != null) {
                hVar.setOnCardSubClickListener(abVar);
            }
        }
        if (this.ajt != null) {
            this.ajt.setOnCardSubClickListener(abVar);
        }
        this.ajy = abVar;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ajx = str;
    }

    /* loaded from: classes.dex */
    public static class a {
        private com.baidu.card.a ajD;
        private com.baidu.card.a ajE;
        private List<h> ajF;
        private com.baidu.card.a ajG;
        private ArrayList<c> aju;
        private al ajw;
        private Context context;

        public a(Context context, boolean z) {
            this.ajD = null;
            this.ajE = null;
            this.ajG = null;
            this.context = context;
            this.aju = new ArrayList<>();
            this.ajw = new al();
            if (!z) {
                this.ajw.bz(0);
            }
            this.ajF = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(com.baidu.card.a aVar) {
            this.ajD = aVar;
            return this;
        }

        public a b(com.baidu.card.a aVar) {
            this.ajG = aVar;
            return this;
        }

        public a a(h hVar) {
            this.ajF.add(hVar);
            return this;
        }

        public a c(com.baidu.card.a aVar) {
            this.ajE = aVar;
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
            return this.ajw;
        }
    }

    public Context getContext() {
        return this.context;
    }
}
