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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ac extends d implements o<bw>, p {
    private static final int agd = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    private bw afJ;
    private Align agb;
    private ImageView agf;
    private FrameLayout agg;
    private int agh;
    private int agi = R.drawable.ic_icon_pure_card_delete_svg;
    private int agj = R.color.cp_cont_g;
    private View.OnClickListener agk = new View.OnClickListener() { // from class: com.baidu.card.ac.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ac.this.afJ != null) {
                CustomMessage customMessage = new CustomMessage(2921428, ac.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, ac.this.afJ);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private BdUniqueId mPageId;
    private RelativeLayout mRootView;

    public ac(Context context, int i) {
        this.agh = 0;
        this.agh = i;
        this.mRootView = new RelativeLayout(context);
        this.agf = new ImageView(context);
        this.agg = new FrameLayout(context);
        this.agg.addView(this.agf, new FrameLayout.LayoutParams(agd, agd));
        this.agg.setOnClickListener(this.agk);
        b(Align.ALIGN_RIGHT_BOTTOM);
        this.mRootView.addView(this.agg);
        H(this.mRootView);
        setInsertIndex(-1);
        a(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b(Align align) {
        if (align != this.agb) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds77);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams.topMargin = dimens;
                layoutParams.bottomMargin = 0;
                this.agg.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                this.agg.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds51);
                layoutParams3.topMargin = 0;
                this.agg.setLayoutParams(layoutParams3);
            }
            this.agb = align;
        }
    }

    public void f(AbsThreadDataSupport absThreadDataSupport) {
        b(Align.ALIGN_RIGHT_TOP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.o
    /* renamed from: a */
    public void F(bw bwVar) {
        this.afJ = bwVar;
        if (bwVar == null) {
            this.agg.setVisibility(8);
        } else if (!isShow(4)) {
            this.agg.setVisibility(8);
        } else {
            this.agg.setVisibility(0);
            SvgManager.bjq().a(this.agf, this.agi, this.agj, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private boolean isShow(int i) {
        return (this.agh & i) > 0;
    }

    @Override // com.baidu.card.p
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.bjq().a(this.agf, this.agi, this.agj, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
