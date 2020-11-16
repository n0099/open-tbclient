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
/* loaded from: classes20.dex */
public class ak<T extends com.baidu.tbadk.core.data.a> implements q, com.baidu.tieba.a.e {
    private T afN;
    private a.C0096a ahA;
    private p<T> ahl;
    private ThreadCardView ahm;
    private RelativeLayout ahn;
    private LinearLayout aho;
    private b<T> ahp;
    private b<T> ahq;
    private List<i> ahr;
    private b<T> ahs;
    private ArrayList<d> aht;
    private q ahu;
    private al ahv;
    private String ahw;
    private com.baidu.tieba.card.ab<T> ahx;
    private com.baidu.card.a.a ahy;
    private int ahz;
    private Context context;
    private int mSkinType;
    private View mTopLine;

    public b<T> tP() {
        return this.ahq;
    }

    public b<T> tQ() {
        return this.ahs;
    }

    public List<i> tR() {
        return this.ahr;
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
        this.ahl = null;
        this.ahu = null;
        this.ahy = new com.baidu.card.a.a();
        this.ahz = 0;
        this.ahA = new a.C0096a(7);
        this.context = aVar.context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.thread_card_layout, viewGroup, false);
        this.ahm = (ThreadCardView) inflate.findViewById(R.id.thread_card_root);
        this.ahn = (RelativeLayout) this.ahm.findViewById(R.id.card_decor_layer);
        this.aho = (LinearLayout) this.ahm.findViewById(R.id.body_root);
        this.aho.setClipToPadding(false);
        this.mTopLine = this.ahm.findViewById(R.id.card_top_line);
        this.ahp = aVar.ahC;
        this.ahq = aVar.ahD;
        this.ahr = aVar.ahE;
        this.ahs = aVar.ahF;
        this.aht = aVar.aht;
        this.ahv = aVar.ahv;
        this.ahm.setParent(viewGroup);
        this.ahm.setITypeListView(vVar);
        initUI();
        if (supportType == BaseCardInfo.SupportType.TOP && !com.baidu.tbadk.a.d.bhw()) {
            if (this.ahm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ahm.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                this.ahm.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.BOTTOM && com.baidu.tbadk.a.d.bhw()) {
            if (this.ahm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ahm.getLayoutParams();
                marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin + UtilHelper.getDimenPixelSize(R.dimen.M_H_X002));
                this.ahm.postInvalidate();
            }
        } else if (supportType == BaseCardInfo.SupportType.FULL && (this.ahm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.ahm.getLayoutParams();
            marginLayoutParams3.setMargins(marginLayoutParams3.leftMargin, (com.baidu.tbadk.a.d.bhw() ? 0 : UtilHelper.getDimenPixelSize(R.dimen.M_H_X003)) + marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, (com.baidu.tbadk.a.d.bhw() ? UtilHelper.getDimenPixelSize(R.dimen.M_H_X002) : 0) + marginLayoutParams3.bottomMargin);
            this.ahm.postInvalidate();
        }
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.card.ak.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 2:
                        ak.this.ahA.setExtraData(true);
                        break;
                    case 1:
                    case 3:
                        ak.this.ahA.setExtraData(false);
                        break;
                }
                ak.this.b(ak.this.ahA);
                return false;
            }
        });
    }

    public View getView() {
        return this.ahm;
    }

    private void initUI() {
        if (this.ahv != null) {
            if (this.aho.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aho.getLayoutParams()).setMargins(this.ahv.ahS, this.ahv.ahQ, this.ahv.ahT, this.ahv.ahR);
                this.aho.postInvalidate();
            }
            if (this.ahv.ahM) {
                tT();
            }
            if (this.ahp != null) {
                this.ahp.a(this);
                this.aho.addView(this.ahp.getView());
                this.ahp.tA();
            }
            if (this.ahq != null) {
                this.ahq.a(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = this.ahv.ahN;
                if (this.ahq.tC().booleanValue()) {
                    layoutParams.leftMargin = -this.ahv.ahS;
                    layoutParams.rightMargin = -this.ahv.ahT;
                }
                this.aho.addView(this.ahq.getView(), layoutParams);
                this.ahq.tA();
            }
            if (this.ahr != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.ahr.size()) {
                        break;
                    }
                    i iVar = this.ahr.get(i2);
                    if (iVar != null) {
                        iVar.a(this);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams2.topMargin = iVar.getTopMargin();
                        layoutParams2.bottomMargin = iVar.tI();
                        if (iVar.tC().booleanValue()) {
                            layoutParams2.leftMargin = -this.ahv.ahS;
                            layoutParams2.rightMargin = -this.ahv.ahT;
                        }
                        this.aho.addView(iVar.getView(), layoutParams2);
                        iVar.tA();
                    }
                    i = i2 + 1;
                }
            }
            if (this.ahs != null) {
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.topMargin = this.ahv.ahP;
                this.ahs.a(this);
                this.aho.addView(this.ahs.getView(), layoutParams3);
                this.ahs.tA();
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.aht)) {
                Iterator<d> it = this.aht.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && next.tG() != null) {
                        if (next.tD() == null) {
                            this.ahn.addView(next.tG(), next.tF());
                        } else {
                            this.ahn.addView(next.tG(), next.tF(), next.tD());
                        }
                        next.b(this);
                        next.tA();
                    }
                }
            }
        }
    }

    public void setSourceForPb(int i) {
        this.ahz = i;
    }

    public int tS() {
        return this.ahz;
    }

    public void a(d dVar) {
        if (dVar != null && dVar.tG() != null) {
            this.aht.remove(dVar);
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
                this.ahn.addView(dVar.tG(), dVar.tF());
            } else {
                this.ahn.addView(dVar.tG(), dVar.tF(), dVar.tD());
            }
            dVar.b(this);
            dVar.tA();
            this.aht.add(dVar);
        }
    }

    private void tT() {
        d dVar = new d();
        dVar.H(new TbImageView(this.context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(this.context, R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = -this.ahv.ahT;
        dVar.a(layoutParams);
        dVar.setInsertIndex(-1);
        this.aht.add(dVar);
    }

    public void h(T t) {
        this.afN = t;
        if (this.ahp != null) {
            this.ahp.H(t);
        }
        if (this.ahq != null) {
            this.ahq.H(t);
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.ahr)) {
            int size = this.ahr.size();
            for (int i = 0; i < size; i++) {
                i iVar = this.ahr.get(i);
                iVar.H(t);
                if (i == 0) {
                    az.a(iVar.getView(), az.y(t.bjd()) && az.z(t.bjd()) && az.A(t.bjd()) && t.bjd().bmK() < 1 && t.bjd().blU() == null, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                }
            }
        }
        if (this.ahs != null) {
            this.ahs.H(t);
        }
        if (this.ahl != null) {
            this.ahl.H(t);
        }
        h(this.aho);
        h(this.ahn);
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
        this.ahy.b(i, bVar);
    }

    public boolean b(a.C0096a c0096a) {
        return this.ahy.b(c0096a);
    }

    public void setPosition(int i) {
        if (this.ahm != null) {
            this.ahm.setPosition(i);
        }
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            if (this.afN != null && !this.afN.isSupportNone()) {
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ahm, this.ahv.ahU);
            }
            if (this.ahp != null) {
                this.ahp.onChangeSkinType(tbPageContext, i);
                if (this.ahs == null) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(this.ahm).pa(1).pb(com.baidu.tbadk.a.d.bhw() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(this.ahv.ahU);
                }
            }
            if (this.ahq != null) {
                this.ahq.onChangeSkinType(tbPageContext, i);
            }
            for (i iVar : this.ahr) {
                if (iVar != null) {
                    iVar.onChangeSkinType(tbPageContext, i);
                }
            }
            if (this.ahs != null) {
                this.ahs.onChangeSkinType(tbPageContext, i);
                if (this.ahp == null) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(this.ahm).pa(2).pb(com.baidu.tbadk.a.d.bhw() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(this.ahv.ahU);
                }
            }
            if (this.ahp != null && this.ahs != null) {
                com.baidu.tbadk.core.elementsMaven.c.bj(this.ahm).pb(com.baidu.tbadk.a.d.bhw() ? R.string.J_X02 : R.string.J_X06).aN(this.ahv.ahU, R.color.CAM_X0206);
            }
            if (!com.baidu.tbadk.core.util.y.isEmpty(this.aht)) {
                Iterator<d> it = this.aht.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    if (next != null && (next instanceof q)) {
                        ((q) next).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            if (this.ahu != null) {
                this.ahu.onChangeSkinType(tbPageContext, i);
            }
        }
    }

    public void a(com.baidu.tieba.card.ab<T> abVar) {
        if (this.ahp != null) {
            this.ahp.setOnCardSubClickListener(abVar);
        }
        if (this.ahq != null) {
            this.ahq.setOnCardSubClickListener(abVar);
        }
        for (i iVar : this.ahr) {
            if (iVar != null) {
                iVar.setOnCardSubClickListener(abVar);
            }
        }
        if (this.ahs != null) {
            this.ahs.setOnCardSubClickListener(abVar);
        }
        this.ahx = abVar;
    }

    @Override // com.baidu.tieba.a.e
    public void setPage(String str) {
        this.ahw = str;
    }

    /* loaded from: classes20.dex */
    public static class a {
        private b ahC;
        private b ahD;
        private List<i> ahE;
        private b ahF;
        private ArrayList<d> aht;
        private al ahv;
        private Context context;

        public a(Context context, boolean z) {
            this.ahC = null;
            this.ahD = null;
            this.ahF = null;
            this.context = context;
            this.aht = new ArrayList<>();
            this.ahv = new al();
            if (!z) {
                this.ahv.bw(0);
            }
            this.ahE = new ArrayList();
        }

        public a(Context context) {
            this(context, true);
        }

        public a a(b bVar) {
            this.ahC = bVar;
            return this;
        }

        public a b(b bVar) {
            this.ahF = bVar;
            return this;
        }

        public a a(i iVar) {
            this.ahE.add(iVar);
            return this;
        }

        public a c(b bVar) {
            this.ahD = bVar;
            return this;
        }

        public ak tU() {
            return new ak(this);
        }

        public ak a(BaseCardInfo.SupportType supportType, ViewGroup viewGroup) {
            return new ak(this, supportType, viewGroup);
        }

        public ak a(BaseCardInfo.SupportType supportType, ViewGroup viewGroup, com.baidu.adp.widget.ListView.v vVar) {
            return new ak(this, supportType, viewGroup, vVar);
        }

        public al tV() {
            return this.ahv;
        }
    }

    public Context getContext() {
        return this.context;
    }
}
