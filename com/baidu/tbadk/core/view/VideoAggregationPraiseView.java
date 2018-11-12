package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class VideoAggregationPraiseView extends BasePraiseView<com.baidu.tieba.frs.aggregation.g> {
    public VideoAggregationPraiseView(Context context) {
        this(context, null);
    }

    public VideoAggregationPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void DD() {
        super.DD();
        this.aBU = e.d.cp_cont_i_alpha70;
        this.aBV = e.d.cp_cont_h_alpha70;
        this.aBS = e.f.icon_card_like_video_n;
        this.aBT = e.f.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, e.h.praise_view_middlevideo, this);
            this.aBW = (TextView) inflate.findViewById(e.g.thread_info_praise_num);
            this.aBX = (ImageView) inflate.findViewById(e.g.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).zO();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.frs.aggregation.g */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != 0) {
            if (gVar.aBr()) {
                if (gVar.zR() == 0 || gVar.zR() == 1) {
                    gVar.cK(2);
                }
                if (gVar.zR() == 3 || gVar.zR() == 4) {
                    gVar.cK(5);
                }
            }
            this.mData = gVar;
            this.mThreadId = ((com.baidu.tieba.frs.aggregation.g) this.mData).threadId;
            this.arH = ((com.baidu.tieba.frs.aggregation.g) this.mData).zO();
            this.arI = ((com.baidu.tieba.frs.aggregation.g) this.mData).zP();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aBR);
        if (num > 0) {
            string = ao.P(num);
        }
        this.aBW.setText(string);
        this.aBW.setContentDescription(context.getString(this.aBR) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aBr() && DG()) {
            this.aBX.setImageDrawable(createStateDrawable(this.aBT, this.aBS));
            this.aBW.setTextColor(createColorStateList(this.aBV, this.aBU));
            return;
        }
        this.aBX.setImageDrawable(createStateDrawable(this.aBS, this.aBT));
        this.aBW.setTextColor(createColorStateList(this.aBU, this.aBV));
    }

    public int DF() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aBr() && DG()) {
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cK(2);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cI(0);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).x(((com.baidu.tieba.frs.aggregation.g) this.mData).zO() - 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).y(((com.baidu.tieba.frs.aggregation.g) this.mData).zP());
            i = 1;
        } else {
            if (((com.baidu.tieba.frs.aggregation.g) this.mData).aBr() && ((com.baidu.tieba.frs.aggregation.g) this.mData).zR() == 5) {
                ((com.baidu.tieba.frs.aggregation.g) this.mData).y(((com.baidu.tieba.frs.aggregation.g) this.mData).zP() - 1);
            }
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cI(1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).x(((com.baidu.tieba.frs.aggregation.g) this.mData).zO() + 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cK(2);
            com.baidu.tieba.n.a.bso().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        if (com.baidu.tbadk.util.g.isFastDoubleClick() || !ba.bG(getContext()) || this.mData == 0) {
            return -1;
        }
        int DF = DF();
        updateUI();
        dL(DF);
        dM(DF);
        bb bbVar = new bb();
        bbVar.setId(((com.baidu.tieba.frs.aggregation.g) this.mData).threadId);
        bbVar.setTid(((com.baidu.tieba.frs.aggregation.g) this.mData).threadId);
        bbVar.cK(((com.baidu.tieba.frs.aggregation.g) this.mData).zR());
        bbVar.cI(((com.baidu.tieba.frs.aggregation.g) this.mData).zQ());
        bbVar.x(((com.baidu.tieba.frs.aggregation.g) this.mData).zO());
        bbVar.y(((com.baidu.tieba.frs.aggregation.g) this.mData).zP());
        a(DF, bbVar);
        if (this.aBz != null) {
            this.aBz.onClick(view);
        }
        return DF;
    }

    public boolean DG() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).zR() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).zR() == 1);
    }
}
