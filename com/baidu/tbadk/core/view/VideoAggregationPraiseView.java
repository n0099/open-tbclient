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
    public void EU() {
        super.EU();
        this.aFX = e.d.cp_cont_i_alpha70;
        this.aFY = e.d.cp_cont_h_alpha70;
        this.aFV = e.f.icon_card_like_video_n;
        this.aFW = e.f.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void initView(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, e.h.praise_view_middlevideo, this);
            this.aFZ = (TextView) inflate.findViewById(e.g.thread_info_praise_num);
            this.aGa = (ImageView) inflate.findViewById(e.g.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).Bf();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.frs.aggregation.g */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != 0) {
            if (gVar.aEn()) {
                if (gVar.Bi() == 0 || gVar.Bi() == 1) {
                    gVar.cY(2);
                }
                if (gVar.Bi() == 3 || gVar.Bi() == 4) {
                    gVar.cY(5);
                }
            }
            this.mData = gVar;
            this.mThreadId = ((com.baidu.tieba.frs.aggregation.g) this.mData).threadId;
            this.avJ = ((com.baidu.tieba.frs.aggregation.g) this.mData).Bf();
            this.avK = ((com.baidu.tieba.frs.aggregation.g) this.mData).Bg();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aFU);
        if (num > 0) {
            string = ao.X(num);
        }
        this.aFZ.setText(string);
        this.aFZ.setContentDescription(context.getString(this.aFU) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aEn() && EX()) {
            this.aGa.setImageDrawable(createStateDrawable(this.aFW, this.aFV));
            this.aFZ.setTextColor(createColorStateList(this.aFY, this.aFX));
            return;
        }
        this.aGa.setImageDrawable(createStateDrawable(this.aFV, this.aFW));
        this.aFZ.setTextColor(createColorStateList(this.aFX, this.aFY));
    }

    public int EW() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aEn() && EX()) {
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cY(2);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cW(0);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).C(((com.baidu.tieba.frs.aggregation.g) this.mData).Bf() - 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).D(((com.baidu.tieba.frs.aggregation.g) this.mData).Bg());
            i = 1;
        } else {
            if (((com.baidu.tieba.frs.aggregation.g) this.mData).aEn() && ((com.baidu.tieba.frs.aggregation.g) this.mData).Bi() == 5) {
                ((com.baidu.tieba.frs.aggregation.g) this.mData).D(((com.baidu.tieba.frs.aggregation.g) this.mData).Bg() - 1);
            }
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cW(1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).C(((com.baidu.tieba.frs.aggregation.g) this.mData).Bf() + 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cY(2);
            com.baidu.tieba.n.a.bvB().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        if (com.baidu.tbadk.util.g.isFastDoubleClick() || !ba.bJ(getContext()) || this.mData == 0) {
            return -1;
        }
        int EW = EW();
        updateUI();
        dZ(EW);
        ea(EW);
        bb bbVar = new bb();
        bbVar.setId(((com.baidu.tieba.frs.aggregation.g) this.mData).threadId);
        bbVar.setTid(((com.baidu.tieba.frs.aggregation.g) this.mData).threadId);
        bbVar.cY(((com.baidu.tieba.frs.aggregation.g) this.mData).Bi());
        bbVar.cW(((com.baidu.tieba.frs.aggregation.g) this.mData).Bh());
        bbVar.C(((com.baidu.tieba.frs.aggregation.g) this.mData).Bf());
        bbVar.D(((com.baidu.tieba.frs.aggregation.g) this.mData).Bg());
        a(EW, bbVar);
        if (this.aFC != null) {
            this.aFC.onClick(view);
        }
        return EW;
    }

    public boolean EX() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).Bi() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).Bi() == 1);
    }
}
