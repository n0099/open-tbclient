package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WriteTipBubbleController {
    private a eXA;
    private com.baidu.tieba.c.e eXz;
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
        this.eXA = aVar;
    }

    public void Xm() {
        if (this.eXz != null) {
            this.eXz.TC();
        }
    }

    public void a(@NonNull View view, @NonNull String str, @NonNull final String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !au.isEmpty(str) && !au.isEmpty(str2)) {
            if (this.eXz == null) {
                this.eXz = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.eXz.eo(R.drawable.pic_post_findlink);
                this.eXz.setLines(2);
                this.eXz.pK(true);
                this.eXz.setTextViewGravity(19);
                this.eXz.setTextColor(R.color.CAM_X0105);
                this.eXz.ep(5000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.eXz.en(32);
                this.eXz.xi(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eXz.G(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.eXz.xm(0);
                this.eXz.setYOffset(-dimensionPixelSize2);
                this.eXz.setHeight(R.dimen.tbds177);
                this.eXz.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.eXz.en(32);
                this.eXz.xi(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.eXz.G(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.eXz.xm(0);
                this.eXz.setYOffset(-dimensionPixelSize4);
                this.eXz.setHeight(R.dimen.tbds177);
                this.eXz.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
                this.eXz.en(16);
                this.eXz.xi(2);
                int dimensionPixelSize5 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize6 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eXz.G(dimensionPixelSize5, 0, dimensionPixelSize5, dimensionPixelSize5);
                this.eXz.xm(0);
                this.eXz.setYOffset(-dimensionPixelSize6);
                this.eXz.setHeight(R.dimen.tbds177);
                this.eXz.setWidth(R.dimen.tbds484);
            }
            this.eXz.e(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.WriteTipBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (WriteTipBubbleController.this.eXA != null) {
                        WriteTipBubbleController.this.eXA.g(view2, str2);
                        if (WriteTipBubbleController.this.eXz != null && WriteTipBubbleController.this.eXz.isShowing()) {
                            WriteTipBubbleController.this.eXz.TC();
                        }
                    }
                }
            });
            this.eXz.Jh(str);
            TiebaStatic.log("c13801");
        }
    }
}
