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
    public void EH() {
        super.EH();
        this.aFv = e.d.cp_cont_i_alpha70;
        this.aFw = e.d.cp_cont_h_alpha70;
        this.aFt = e.f.icon_card_like_video_n;
        this.aFu = e.f.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, e.h.praise_view_middlevideo, this);
            this.aFx = (TextView) inflate.findViewById(e.g.thread_info_praise_num);
            this.aFy = (ImageView) inflate.findViewById(e.g.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).AS();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.frs.aggregation.g */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != 0) {
            if (gVar.aDQ()) {
                if (gVar.AV() == 0 || gVar.AV() == 1) {
                    gVar.cY(2);
                }
                if (gVar.AV() == 3 || gVar.AV() == 4) {
                    gVar.cY(5);
                }
            }
            this.mData = gVar;
            this.mThreadId = ((com.baidu.tieba.frs.aggregation.g) this.mData).threadId;
            this.avh = ((com.baidu.tieba.frs.aggregation.g) this.mData).AS();
            this.avi = ((com.baidu.tieba.frs.aggregation.g) this.mData).AT();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aFs);
        if (num > 0) {
            string = ao.X(num);
        }
        this.aFx.setText(string);
        this.aFx.setContentDescription(context.getString(this.aFs) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aDQ() && EK()) {
            this.aFy.setImageDrawable(createStateDrawable(this.aFu, this.aFt));
            this.aFx.setTextColor(createColorStateList(this.aFw, this.aFv));
            return;
        }
        this.aFy.setImageDrawable(createStateDrawable(this.aFt, this.aFu));
        this.aFx.setTextColor(createColorStateList(this.aFv, this.aFw));
    }

    public int EJ() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aDQ() && EK()) {
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cY(2);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cW(0);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).C(((com.baidu.tieba.frs.aggregation.g) this.mData).AS() - 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).D(((com.baidu.tieba.frs.aggregation.g) this.mData).AT());
            i = 1;
        } else {
            if (((com.baidu.tieba.frs.aggregation.g) this.mData).aDQ() && ((com.baidu.tieba.frs.aggregation.g) this.mData).AV() == 5) {
                ((com.baidu.tieba.frs.aggregation.g) this.mData).D(((com.baidu.tieba.frs.aggregation.g) this.mData).AT() - 1);
            }
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cW(1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).C(((com.baidu.tieba.frs.aggregation.g) this.mData).AS() + 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cY(2);
            com.baidu.tieba.n.a.buS().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        if (com.baidu.tbadk.util.g.isFastDoubleClick() || !ba.bJ(getContext()) || this.mData == 0) {
            return -1;
        }
        int EJ = EJ();
        updateUI();
        dZ(EJ);
        ea(EJ);
        bb bbVar = new bb();
        bbVar.setId(((com.baidu.tieba.frs.aggregation.g) this.mData).threadId);
        bbVar.setTid(((com.baidu.tieba.frs.aggregation.g) this.mData).threadId);
        bbVar.cY(((com.baidu.tieba.frs.aggregation.g) this.mData).AV());
        bbVar.cW(((com.baidu.tieba.frs.aggregation.g) this.mData).AU());
        bbVar.C(((com.baidu.tieba.frs.aggregation.g) this.mData).AS());
        bbVar.D(((com.baidu.tieba.frs.aggregation.g) this.mData).AT());
        a(EJ, bbVar);
        if (this.aFa != null) {
            this.aFa.onClick(view);
        }
        return EJ;
    }

    public boolean EK() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).AV() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).AV() == 1);
    }
}
