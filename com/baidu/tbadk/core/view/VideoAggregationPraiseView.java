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
/* loaded from: classes2.dex */
public class VideoAggregationPraiseView extends BasePraiseView<com.baidu.tieba.frs.aggregation.g> {
    public VideoAggregationPraiseView(Context context) {
        this(context, null);
    }

    public VideoAggregationPraiseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Bq() {
        super.Bq();
        this.awu = e.d.cp_cont_i_alpha70;
        this.awv = e.d.cp_cont_h_alpha70;
        this.aws = e.f.icon_card_like_video_n;
        this.awt = e.f.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void bB(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, e.h.praise_view_middlevideo, this);
            this.aww = (TextView) inflate.findViewById(e.g.thread_info_praise_num);
            this.awx = (ImageView) inflate.findViewById(e.g.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).xy();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.frs.aggregation.g */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != 0) {
            if (gVar.ayA()) {
                if (gVar.xB() == 0 || gVar.xB() == 1) {
                    gVar.cm(2);
                }
                if (gVar.xB() == 3 || gVar.xB() == 4) {
                    gVar.cm(5);
                }
            }
            this.mData = gVar;
            this.mThreadId = ((com.baidu.tieba.frs.aggregation.g) this.mData).threadId;
            this.alZ = ((com.baidu.tieba.frs.aggregation.g) this.mData).xy();
            this.ama = ((com.baidu.tieba.frs.aggregation.g) this.mData).xz();
            Bp();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void Bp() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.awr);
        if (num > 0) {
            string = ao.L(num);
        }
        this.aww.setText(string);
        this.aww.setContentDescription(context.getString(this.awr) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).ayA() && Bt()) {
            this.awx.setImageDrawable(createStateDrawable(this.awt, this.aws));
            this.aww.setTextColor(createColorStateList(this.awv, this.awu));
            return;
        }
        this.awx.setImageDrawable(createStateDrawable(this.aws, this.awt));
        this.aww.setTextColor(createColorStateList(this.awu, this.awv));
    }

    public int Bs() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).ayA() && Bt()) {
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cm(2);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).ck(0);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).t(((com.baidu.tieba.frs.aggregation.g) this.mData).xy() - 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).u(((com.baidu.tieba.frs.aggregation.g) this.mData).xz());
            i = 1;
        } else {
            if (((com.baidu.tieba.frs.aggregation.g) this.mData).ayA() && ((com.baidu.tieba.frs.aggregation.g) this.mData).xB() == 5) {
                ((com.baidu.tieba.frs.aggregation.g) this.mData).u(((com.baidu.tieba.frs.aggregation.g) this.mData).xz() - 1);
            }
            ((com.baidu.tieba.frs.aggregation.g) this.mData).ck(1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).t(((com.baidu.tieba.frs.aggregation.g) this.mData).xy() + 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cm(2);
            com.baidu.tieba.n.a.bpD().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        if (com.baidu.tbadk.util.g.isFastDoubleClick() || !ba.bA(getContext()) || this.mData == 0) {
            return -1;
        }
        int Bs = Bs();
        Bp();
        dn(Bs);
        m15do(Bs);
        bb bbVar = new bb();
        bbVar.setId(((com.baidu.tieba.frs.aggregation.g) this.mData).threadId);
        bbVar.setTid(((com.baidu.tieba.frs.aggregation.g) this.mData).threadId);
        bbVar.cm(((com.baidu.tieba.frs.aggregation.g) this.mData).xB());
        bbVar.ck(((com.baidu.tieba.frs.aggregation.g) this.mData).xA());
        bbVar.t(((com.baidu.tieba.frs.aggregation.g) this.mData).xy());
        bbVar.u(((com.baidu.tieba.frs.aggregation.g) this.mData).xz());
        a(Bs, bbVar);
        if (this.avZ != null) {
            this.avZ.onClick(view);
        }
        return Bs;
    }

    public boolean Bt() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).xB() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).xB() == 1);
    }
}
