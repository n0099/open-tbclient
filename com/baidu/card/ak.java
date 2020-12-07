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
/* loaded from: classes21.dex */
public class ak<T extends com.baidu.tbadk.core.data.a> implements q, com.baidu.tieba.a.e {
    private T agJ;
    private a.C0097a aiA;
    private p<T> ail;
    private ThreadCardView aim;
    private RelativeLayout ain;
    private LinearLayout aio;
    private b<T> aip;
    private b<T> aiq;
    private List<i> air;
    private b<T> ais;
    private ArrayList<d> ait;
    private q aiu;
    private al aiv;
    private String aiw;
    private com.baidu.tieba.card.ab<T> aix;
    private com.baidu.card.a.a aiy;
    private int aiz;
    private Context context;
    private boolean forceNoTest;
    private int mSkinType;
    private View mTopLine;

    public b<T> tS() {
        return this.aiq;
    }

    public b<T> tT() {
        return this.ais;
    }

    public List<i> tU() {
        return this.air;
    }

    private ak(a aVar) {
        this(aVar, BaseCardInfo.SupportType.FULL);
    }

    private ak(a aVar, BaseCardInfo.SupportType supportType) {
        this(aVar, supportType, null);
    }

    private ak(a aVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
        this(aVar, supportType, viewGroup, (com.baidu.adp.widget.ListView.v) null);
    }

    private ak(a aVar, BaseCardInfo.SupportType supportType, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
        this.mSkinType = 3;
        this.ail = null;
        this.aiu = null;
        this.aiy = new com.baidu.card.a.a();
        this.aiz = 0;
        this.aiA = new a.C0097a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.aim = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.ain = (RelativeLayout) this.aim.findViewById(R.id.card_decor_layer);
        this.aio = (LinearLayout) this.aim.findViewById(R.id.body_root);
        this.aio.setClipToPadding(false);
        this.mTopLine = this.aim.findViewById(R.id.card_top_line);
        this.aip = aVar.aiC;
        this.aiq = aVar.aiD;
        this.air = aVar.aiE;
        this.ais = aVar.aiF;
        this.ait = aVar.ait;
        this.aiv = aVar.aiv;
        this.forceNoTest = aVar.forceNoTest;
        this.aim.setParent(viewGroup);
        this.aim.setITypeListView(vVar);
        initUI();
        boolean bkA = com.baidu.tbadk.a.d.bkA() & (!this.forceNoTest);
        if (supportType == BaseCardInfo.SupportType.TOP && !bkA) {
            if (this.aim.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aim.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                this.aim.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.BOTTOM && bkA) {
            if (this.aim.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.aim.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X002));
                this.aim.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL && (this.aim.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.aim.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin, (bkA ? 0 : UtilHelper.getDimenPixelSize(R.dimen.M_H_X003)) + marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, (bkA ? UtilHelper.getDimenPixelSize(R.dimen.M_H_X002) : 0) + marginLayoutParams3.bottomMargin);
            this.aim.postInvalidate();
        }
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ak.this.aiA.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ak.this.aiA.setExtraData(false);
                        break;
                }
                ak.this.b(ak.this.aiA);
                return false;
            }
        });
    }

    public View getView() {
        return this.aim;
    }

    private void initUI() {
        if (this.aiv != null) {
            if (this.aio.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aio.getLayoutParams()).setMargins(this.aiv.aiS, this.aiv.aiQ, this.aiv.aiT, this.aiv.aiR);
                this.aio.postInvalidate();
            }
            if (this.aiv.aiM) {
                tW();
            }
            if (this.aip != null) {
                this.aip.a(this);
                this.aio.addView(this.aip.getView());
                this.aip.tD();
            }
            if (this.aiq != null) {
                this.aiq.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.aiv.aiN;
                if (this.aiq.tF().booleanValue()) {
                    layoutParams.leftMargin = -this.aiv.aiS;
                    layoutParams.rightMargin = -this.aiv.aiT;
                }
                this.aio.addView(this.aiq.getView(), layoutParams);
                this.aiq.tD();
            }
            if (this.air != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.air.size()) {
                        break;
                    }
                    i iVar = this.air.get(i2);
                    if (iVar != null) {
                        iVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = iVar.getTopMargin();
                        layoutParams2.bottomMargin = iVar.tL();
                        if (iVar.tF().booleanValue()) {
                            layoutParams2.leftMargin = -this.aiv.aiS;
                            layoutParams2.rightMargin = -this.aiv.aiT;
                        }
                        this.aio.addView(iVar.getView(), layoutParams2);
                        iVar.tD();
                    }
                    i = i2 + 1;
                }
            }
            if (this.ais != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.aiv.aiP;
                this.ais.a(this);
                this.aio.addView(this.ais.getView(), layoutParams3);
                this.ais.tD();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.ait)) {
                Iterator<d> it = this.ait.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.tJ() != null) {
                        if (next.tG() == null) {
                            this.ain.addView(next.tJ(), next.tI());
                        } else {
                            this.ain.addView(next.tJ(), next.tI(), next.tG());
                        }
                        next.b(this);
                        next.tD();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.aiz = i;
    }

    public int tV() {
        return this.aiz;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.tJ() != null) {
            this.ait.remove(dVar);
            if (dVar.tJ().getParent() != null) {
                ((ViewGroup) dVar.tJ().getParent()).removeView(dVar.tJ());
                dVar.tH();
                dVar.b(null);
            }
        }
    }

    public void b(d dVar) {
        if (dVar != null && dVar.tJ() != null) {
            a(dVar);
            dVar.tJ().setVisibility(0);
            if (dVar.tG() == null) {
                this.ain.addView(dVar.tJ(), dVar.tI());
            } else {
                this.ain.addView(dVar.tJ(), dVar.tI(), dVar.tG());
            }
            dVar.b(this);
            dVar.tD();
            this.ait.add(dVar);
        }
    }

    private void tW() {
        d dVar = new d();
        dVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = -this.aiv.aiT;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.ait.add(dVar);
    }

    public void h(T t) {
        this.agJ = t;
        if (this.aip != null) {
            this.aip.H(t);
        }
        if (this.aiq != null) {
            this.aiq.H(t);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.air)) {
            int size = this.air.size();
            for (int i = 0; i < size; i++) {
                i iVar = this.air.get(i);
                iVar.H(t);
                if (i == 0) {
                    az.a(iVar.getView(), az.y(t.bmn()) && az.z(t.bmn()) && az.A(t.bmn()) && t.bmn().bpX() < 1 && t.bmn().bph() == null, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                }
            }
        }
        if (this.ais != null) {
            this.ais.H(t);
        }
        if (this.ail != null) {
            this.ail.H(t);
        }
        h(this.aio);
        h(this.ain);
    }

    private void h(ViewGroup viewGroup) {
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
        this.aiy.b(i, bVar);
    }

    public boolean b(a.C0097a c0097a) {
        return this.aiy.b(c0097a);
    }

    public void setPosition(int i) {
        if (this.aim != null) {
            this.aim.setPosition(i);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.agJ != null && !this.agJ.isSupportNone()) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.aim, this.aiv.aiU);
            }
            if (this.aip != null) {
                this.aip.onChangeSkinType(tbPageContext, i);
                if (this.ais == null) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(this.aim).pz(1).pA((!com.baidu.tbadk.a.d.bkA() || this.forceNoTest) ? R.string.J_X06 : R.string.J_X02).setBackGroundColor(this.aiv.aiU);
                }
            }
            if (this.aiq != null) {
                this.aiq.onChangeSkinType(tbPageContext, i);
            }
            for (i iVar : this.air) {
                if (iVar != null) {
                    iVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.ais != null) {
                this.ais.onChangeSkinType(tbPageContext, i);
                if (this.aip == null) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(this.aim).pz(2).pA((!com.baidu.tbadk.a.d.bkA() || this.forceNoTest) ? R.string.J_X06 : R.string.J_X02).setBackGroundColor(this.aiv.aiU);
                }
            }
            if (this.aip != null && this.ais != null) {
                com.baidu.tbadk.core.elementsMaven.c.bm(this.aim).pA((!com.baidu.tbadk.a.d.bkA() || this.forceNoTest) ? R.string.J_X06 : R.string.J_X02).aP(this.aiv.aiU, R.color.CAM_X0206);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.ait)) {
                Iterator<d> it = this.ait.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof q)) {
                        ((q) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.aiu != null) {
                this.aiu.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.aip != null) {
            this.aip.setOnCardSubClickListener(abVar);
        }
        if (this.aiq != null) {
            this.aiq.setOnCardSubClickListener(abVar);
        }
        for (i iVar : this.air) {
            if (iVar != null) {
                iVar.setOnCardSubClickListener(abVar);
            }
        }
        if (this.ais != null) {
            this.ais.setOnCardSubClickListener(abVar);
        }
        this.aix = abVar;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.aiw = str;
    }

    /* loaded from: classes21.dex */
    public static class a {
        private b aiC;
        private b aiD;
        private List<i> aiE;
        private b aiF;
        private ArrayList<d> ait;
        private al aiv;
        private Context context;
        private boolean forceNoTest;

        public a(Context context, boolean z) {
            this.aiC = null;
            this.aiD = null;
            this.aiF = null;
            this.context = context;
            this.ait = new ArrayList<>();
            this.aiv = new al();
            if (!z) {
                this.aiv.bA(0);
            }
            this.aiE = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.aiC = bVar;
            return this;
        }

        public a b(b bVar) {
            this.aiF = bVar;
            return this;
        }

        public a a(i iVar) {
            this.aiE.add(iVar);
            return this;
        }

        public a c(b bVar) {
            this.aiD = bVar;
            return this;
        }

        public a aL(boolean z) {
            this.forceNoTest = z;
            return this;
        }

        public ak tX() {
            return new ak(this);
        }

        public ak a(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            return new ak(this, supportType, viewGroup);
        }

        public ak a(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
            return new ak(this, supportType, viewGroup, vVar);
        }

        public al tY() {
            return this.aiv;
        }
    }

    public Context getContext() {
        return this.context;
    }
}
