package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WriteTipBubbleController {
    private com.baidu.tieba.c.e eTK;
    private a eTL;
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public enum ANCHOR_VIEW_FROM {
        FROM_EDITOR_TOOL,
        FROM_EDIT_TEXT,
        FROM_PB_REPLY
    }

    /* loaded from: classes.dex */
    public interface a {
        void f(View view, String str);
    }

    public WriteTipBubbleController(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.eTL = aVar;
    }

    public void VA() {
        if (this.eTK != null) {
            this.eTK.RS();
        }
    }

    public void a(@NonNull View view, @NonNull String str, @NonNull final String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !at.isEmpty(str) && !at.isEmpty(str2)) {
            if (this.eTK == null) {
                this.eTK = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.eTK.ej(R.drawable.pic_post_findlink);
                this.eTK.setLines(2);
                this.eTK.pA(true);
                this.eTK.setTextViewGravity(19);
                this.eTK.setTextColor(R.color.CAM_X0105);
                this.eTK.ek(5000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.eTK.ei(32);
                this.eTK.wX(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eTK.G(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.eTK.xb(0);
                this.eTK.setYOffset(-dimensionPixelSize2);
                this.eTK.setHeight(R.dimen.tbds177);
                this.eTK.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.eTK.ei(32);
                this.eTK.wX(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.eTK.G(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.eTK.xb(0);
                this.eTK.setYOffset(-dimensionPixelSize4);
                this.eTK.setHeight(R.dimen.tbds177);
                this.eTK.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
                this.eTK.ei(16);
                this.eTK.wX(2);
                int dimensionPixelSize5 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize6 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eTK.G(dimensionPixelSize5, 0, dimensionPixelSize5, dimensionPixelSize5);
                this.eTK.xb(0);
                this.eTK.setYOffset(-dimensionPixelSize6);
                this.eTK.setHeight(R.dimen.tbds177);
                this.eTK.setWidth(R.dimen.tbds484);
            }
            this.eTK.e(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.WriteTipBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (WriteTipBubbleController.this.eTL != null) {
                        WriteTipBubbleController.this.eTL.f(view2, str2);
                        if (WriteTipBubbleController.this.eTK != null && WriteTipBubbleController.this.eTK.isShowing()) {
                            WriteTipBubbleController.this.eTK.RS();
                        }
                    }
                }
            });
            this.eTK.Im(str);
            TiebaStatic.log("c13801");
        }
    }
}
