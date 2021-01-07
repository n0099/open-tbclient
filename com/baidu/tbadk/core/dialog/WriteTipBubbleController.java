package com.baidu.tbadk.core.dialog;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class WriteTipBubbleController {
    private com.baidu.tieba.c.e eYv;
    private a eYw;
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
        this.eYw = aVar;
    }

    public void Zt() {
        if (this.eYv != null) {
            this.eYv.VL();
        }
    }

    public void a(@NonNull View view, @NonNull String str, @NonNull final String str2, @NonNull ANCHOR_VIEW_FROM anchor_view_from) {
        if (this.mPageContext != null && view != null && !at.isEmpty(str) && !at.isEmpty(str2)) {
            if (this.eYv == null) {
                this.eYv = new com.baidu.tieba.c.e(this.mPageContext, view);
                this.eYv.fP(R.drawable.pic_post_findlink);
                this.eYv.setLines(2);
                this.eYv.pE(true);
                this.eYv.setTextViewGravity(19);
                this.eYv.setTextColor(R.color.CAM_X0105);
                this.eYv.fQ(5000);
            }
            if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL) {
                this.eYv.fO(32);
                this.eYv.setAnchor(2);
                int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize2 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eYv.G(dimensionPixelSize, 0, dimensionPixelSize, dimensionPixelSize);
                this.eYv.yH(0);
                this.eYv.setYOffset(-dimensionPixelSize2);
                this.eYv.setHeight(R.dimen.tbds177);
                this.eYv.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_EDIT_TEXT) {
                this.eYv.fO(32);
                this.eYv.setAnchor(5);
                int dimensionPixelSize3 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize4 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                this.eYv.G(dimensionPixelSize3, 0, dimensionPixelSize3, dimensionPixelSize3);
                this.eYv.yH(0);
                this.eYv.setYOffset(-dimensionPixelSize4);
                this.eYv.setHeight(R.dimen.tbds177);
                this.eYv.setWidth(R.dimen.tbds484);
            } else if (anchor_view_from == ANCHOR_VIEW_FROM.FROM_PB_REPLY) {
                this.eYv.fO(16);
                this.eYv.setAnchor(2);
                int dimensionPixelSize5 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds32);
                int dimensionPixelSize6 = this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds4);
                this.eYv.G(dimensionPixelSize5, 0, dimensionPixelSize5, dimensionPixelSize5);
                this.eYv.yH(0);
                this.eYv.setYOffset(-dimensionPixelSize6);
                this.eYv.setHeight(R.dimen.tbds177);
                this.eYv.setWidth(R.dimen.tbds484);
            }
            this.eYv.e(new View.OnClickListener() { // from class: com.baidu.tbadk.core.dialog.WriteTipBubbleController.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (WriteTipBubbleController.this.eYw != null) {
                        WriteTipBubbleController.this.eYw.f(view2, str2);
                        if (WriteTipBubbleController.this.eYv != null && WriteTipBubbleController.this.eYv.isShowing()) {
                            WriteTipBubbleController.this.eYv.VL();
                        }
                    }
                }
            });
            this.eYv.Jx(str);
            TiebaStatic.log("c13801");
        }
    }
}
