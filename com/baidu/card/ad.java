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
/* loaded from: classes21.dex */
public class ad extends d implements p<bw>, q {
    private static final int agR = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    private Align agP;
    private ImageView agS;
    private FrameLayout agT;
    private int agU;
    private int agV = R.drawable.ic_icon_pure_card_delete_svg;
    private int agW = R.color.cp_cont_g;
    private View.OnClickListener agX = new View.OnClickListener() { // from class: com.baidu.card.ad.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ad.this.agx != null) {
                CustomMessage customMessage = new CustomMessage(2921428, ad.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, ad.this.agx);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private bw agx;
    private BdUniqueId mPageId;
    private RelativeLayout mRootView;

    public ad(Context context, int i) {
        this.agU = 0;
        this.agU = i;
        this.mRootView = new RelativeLayout(context);
        this.agS = new ImageView(context);
        this.agT = new FrameLayout(context);
        this.agT.addView(this.agS, new FrameLayout.LayoutParams(agR, agR));
        this.agT.setOnClickListener(this.agX);
        b(Align.ALIGN_RIGHT_BOTTOM);
        this.mRootView.addView(this.agT);
        H((View) this.mRootView);
        setInsertIndex(-1);
        a(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b(Align align) {
        if (align != this.agP) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds77);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams.topMargin = dimens;
                layoutParams.bottomMargin = 0;
                this.agT.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                this.agT.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds51);
                layoutParams3.topMargin = 0;
                this.agT.setLayoutParams(layoutParams3);
            }
            this.agP = align;
        }
    }

    public void g(AbsThreadDataSupport absThreadDataSupport) {
        b(Align.ALIGN_RIGHT_TOP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bw bwVar) {
        this.agx = bwVar;
        if (bwVar == null) {
            this.agT.setVisibility(8);
        } else if (!isShow(4)) {
            this.agT.setVisibility(8);
        } else {
            this.agT.setVisibility(0);
            SvgManager.brn().a(this.agS, this.agV, this.agW, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private boolean isShow(int i) {
        return (this.agU & i) > 0;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.brn().a(this.agS, this.agV, this.agW, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
