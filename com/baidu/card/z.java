package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class z extends d implements n<bk>, o {
    private static final int aew = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    private int aeA = R.drawable.ic_icon_pure_card_delete_svg;
    private int aeB = R.color.cp_cont_g;
    private View.OnClickListener aeC = new View.OnClickListener() { // from class: com.baidu.card.z.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (z.this.aee != null) {
                CustomMessage customMessage = new CustomMessage(2921428, z.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, z.this.aee);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private bk aee;
    private Align aev;
    private ImageView aex;
    private FrameLayout aey;
    private int aez;
    private BdUniqueId mPageId;
    private RelativeLayout mRootView;

    public z(Context context, int i) {
        this.aez = 0;
        this.aez = i;
        this.mRootView = new RelativeLayout(context);
        this.aex = new ImageView(context);
        this.aey = new FrameLayout(context);
        this.aey.addView(this.aex, new FrameLayout.LayoutParams(aew, aew));
        this.aey.setOnClickListener(this.aeC);
        b(Align.ALIGN_RIGHT_BOTTOM);
        this.mRootView.addView(this.aey);
        F(this.mRootView);
        setInsertIndex(-1);
        a(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b(Align align) {
        if (align != this.aev) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds77);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams.topMargin = dimens;
                layoutParams.bottomMargin = 0;
                this.aey.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                this.aey.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds51);
                layoutParams3.topMargin = 0;
                this.aey.setLayoutParams(layoutParams3);
            }
            this.aev = align;
        }
    }

    public void e(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport.aOp()) {
            b(Align.ALIGN_RIGHT_TOP);
        } else {
            b(Align.ALIGN_RIGHT_BOTTOM);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bk bkVar) {
        this.aee = bkVar;
        if (bkVar == null) {
            this.aey.setVisibility(8);
        } else if (!isShow(4)) {
            this.aey.setVisibility(8);
        } else {
            this.aey.setVisibility(0);
            SvgManager.aUV().a(this.aex, this.aeA, this.aeB, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private boolean isShow(int i) {
        return (this.aez & i) > 0;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.aUV().a(this.aex, this.aeA, this.aeB, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
