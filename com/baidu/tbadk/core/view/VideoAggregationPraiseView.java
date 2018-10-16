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
    public void Dw() {
        super.Dw();
        this.aBf = e.d.cp_cont_i_alpha70;
        this.aBg = e.d.cp_cont_h_alpha70;
        this.aBd = e.f.icon_card_like_video_n;
        this.aBe = e.f.icon_card_like_video_s;
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    protected void bJ(Context context) {
        if (context != null) {
            View inflate = View.inflate(context, e.h.praise_view_middlevideo, this);
            this.aBh = (TextView) inflate.findViewById(e.g.thread_info_praise_num);
            this.aBi = (ImageView) inflate.findViewById(e.g.thread_info_praise_img);
            setDisPraiseFrom(6);
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public long getNum() {
        if (this.mData == 0) {
            return 0L;
        }
        return ((com.baidu.tieba.frs.aggregation.g) this.mData).zH();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.frs.aggregation.g */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != 0) {
            if (gVar.aBT()) {
                if (gVar.zK() == 0 || gVar.zK() == 1) {
                    gVar.cw(2);
                }
                if (gVar.zK() == 3 || gVar.zK() == 4) {
                    gVar.cw(5);
                }
            }
            this.mData = gVar;
            this.mThreadId = ((com.baidu.tieba.frs.aggregation.g) this.mData).threadId;
            this.aqU = ((com.baidu.tieba.frs.aggregation.g) this.mData).zH();
            this.aqV = ((com.baidu.tieba.frs.aggregation.g) this.mData).zI();
            updateUI();
        }
    }

    @Override // com.baidu.tbadk.core.view.BasePraiseView
    public void updateUI() {
        Context context = getContext();
        long num = getNum();
        String string = context.getString(this.aBc);
        if (num > 0) {
            string = ao.N(num);
        }
        this.aBh.setText(string);
        this.aBh.setContentDescription(context.getString(this.aBc) + num);
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aBT() && Dz()) {
            this.aBi.setImageDrawable(createStateDrawable(this.aBe, this.aBd));
            this.aBh.setTextColor(createColorStateList(this.aBg, this.aBf));
            return;
        }
        this.aBi.setImageDrawable(createStateDrawable(this.aBd, this.aBe));
        this.aBh.setTextColor(createColorStateList(this.aBf, this.aBg));
    }

    public int Dy() {
        int i;
        if (this.mData == 0) {
            return 0;
        }
        if (((com.baidu.tieba.frs.aggregation.g) this.mData).aBT() && Dz()) {
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cw(2);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cu(0);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).v(((com.baidu.tieba.frs.aggregation.g) this.mData).zH() - 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).w(((com.baidu.tieba.frs.aggregation.g) this.mData).zI());
            i = 1;
        } else {
            if (((com.baidu.tieba.frs.aggregation.g) this.mData).aBT() && ((com.baidu.tieba.frs.aggregation.g) this.mData).zK() == 5) {
                ((com.baidu.tieba.frs.aggregation.g) this.mData).w(((com.baidu.tieba.frs.aggregation.g) this.mData).zI() - 1);
            }
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cu(1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).v(((com.baidu.tieba.frs.aggregation.g) this.mData).zH() + 1);
            ((com.baidu.tieba.frs.aggregation.g) this.mData).cw(2);
            com.baidu.tieba.n.a.bsS().y(getTbPageContext());
            i = 0;
        }
        return i;
    }

    public int L(View view) {
        if (com.baidu.tbadk.util.g.isFastDoubleClick() || !ba.bI(getContext()) || this.mData == 0) {
            return -1;
        }
        int Dy = Dy();
        updateUI();
        dx(Dy);
        dy(Dy);
        bb bbVar = new bb();
        bbVar.setId(((com.baidu.tieba.frs.aggregation.g) this.mData).threadId);
        bbVar.setTid(((com.baidu.tieba.frs.aggregation.g) this.mData).threadId);
        bbVar.cw(((com.baidu.tieba.frs.aggregation.g) this.mData).zK());
        bbVar.cu(((com.baidu.tieba.frs.aggregation.g) this.mData).zJ());
        bbVar.v(((com.baidu.tieba.frs.aggregation.g) this.mData).zH());
        bbVar.w(((com.baidu.tieba.frs.aggregation.g) this.mData).zI());
        a(Dy, bbVar);
        if (this.aAK != null) {
            this.aAK.onClick(view);
        }
        return Dy;
    }

    public boolean Dz() {
        return this.mData != 0 && (((com.baidu.tieba.frs.aggregation.g) this.mData).zK() == 2 || ((com.baidu.tieba.frs.aggregation.g) this.mData).zK() == 1);
    }
}
