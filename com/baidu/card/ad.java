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
/* loaded from: classes20.dex */
public class ad extends d implements p<bw>, q {
    private static final int agz = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    private ImageView agA;
    private FrameLayout agB;
    private int agC;
    private int agD = R.drawable.ic_icon_pure_card_delete_svg;
    private int agE = R.color.cp_cont_g;
    private View.OnClickListener agF = new View.OnClickListener() { // from class: com.baidu.card.ad.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ad.this.agf != null) {
                CustomMessage customMessage = new CustomMessage(2921428, ad.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, ad.this.agf);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private bw agf;
    private Align agx;
    private BdUniqueId mPageId;
    private RelativeLayout mRootView;

    public ad(Context context, int i) {
        this.agC = 0;
        this.agC = i;
        this.mRootView = new RelativeLayout(context);
        this.agA = new ImageView(context);
        this.agB = new FrameLayout(context);
        this.agB.addView(this.agA, new FrameLayout.LayoutParams(agz, agz));
        this.agB.setOnClickListener(this.agF);
        b(Align.ALIGN_RIGHT_BOTTOM);
        this.mRootView.addView(this.agB);
        H(this.mRootView);
        setInsertIndex(-1);
        a(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b(Align align) {
        if (align != this.agx) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds77);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams.topMargin = dimens;
                layoutParams.bottomMargin = 0;
                this.agB.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                this.agB.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds51);
                layoutParams3.topMargin = 0;
                this.agB.setLayoutParams(layoutParams3);
            }
            this.agx = align;
        }
    }

    public void g(AbsThreadDataSupport absThreadDataSupport) {
        b(Align.ALIGN_RIGHT_TOP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void G(bw bwVar) {
        this.agf = bwVar;
        if (bwVar == null) {
            this.agB.setVisibility(8);
        } else if (!isShow(4)) {
            this.agB.setVisibility(8);
        } else {
            this.agB.setVisibility(0);
            SvgManager.bkl().a(this.agA, this.agD, this.agE, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private boolean isShow(int i) {
        return (this.agC & i) > 0;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.bkl().a(this.agA, this.agD, this.agE, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
