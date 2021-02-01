package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WriteTipBubbleController {
    private com.baidu.tieba.c.e eWa;
    private a eWb;
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public enum ANCHOR_VIEW_FROM {
        FROM_EDITOR_TOOL,
        FROM_EDIT_TEXT,
        FROM_PB_REPLY
    }

    /* loaded from: classes.dex */
    public interface a {
        void g(View view, String str);
    }

    public WriteTipBubbleController(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.eWb = aVar;
    }

    public void Xj() {
        if (this.eWa != null) {
            this.eWa.Tz();
        }
    }

    public void a(@NonNull View view, @NonNull String str, @NonNull final String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !au.isEmpty(str) && !au.isEmpty(str2)) {
            if (this.eWa == null) {
                this.eWa = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.eWa.en(R.drawable.pic_post_findlink);
                this.eWa.setLines(2);
                this.eWa.pK(true);
                this.eWa.setTextViewGravity(19);
                this.eWa.setTextColor(R.color.CAM_X0105);
                this.eWa.eo(5000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.eWa.em(32);
                this.eWa.xh(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eWa.G(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.eWa.xl(0);
                this.eWa.setYOffset(-dimensionPixelSize2);
                this.eWa.setHeight(R.dimen.tbds177);
                this.eWa.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.eWa.em(32);
                this.eWa.xh(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.eWa.G(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.eWa.xl(0);
                this.eWa.setYOffset(-dimensionPixelSize4);
                this.eWa.setHeight(R.dimen.tbds177);
                this.eWa.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
                this.eWa.em(16);
                this.eWa.xh(2);
                int dimensionPixelSize5 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize6 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eWa.G(dimensionPixelSize5, 0, dimensionPixelSize5, dimensionPixelSize5);
                this.eWa.xl(0);
                this.eWa.setYOffset(-dimensionPixelSize6);
                this.eWa.setHeight(R.dimen.tbds177);
                this.eWa.setWidth(R.dimen.tbds484);
            }
            this.eWa.e(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.WriteTipBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (WriteTipBubbleController.this.eWb != null) {
                        WriteTipBubbleController.this.eWb.g(view2, str2);
                        if (WriteTipBubbleController.this.eWa != null && WriteTipBubbleController.this.eWa.isShowing()) {
                            WriteTipBubbleController.this.eWa.Tz();
                        }
                    }
                }
            });
            this.eWa.IX(str);
            TiebaStatic.log("c13801");
        }
    }
}
