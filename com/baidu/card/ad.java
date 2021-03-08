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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ad extends c implements p<cb>, q {
    private static final int aiU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    private cb aiB;
    private Align aiS;
    private ImageView aiV;
    private FrameLayout aiW;
    private int aiX;
    private int aiY = R.drawable.ic_icon_pure_card_delete_svg;
    private int aiZ = R.color.CAM_X0111;
    private View.OnClickListener aja = new View.OnClickListener() { // from class: com.baidu.card.ad.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ad.this.aiB != null) {
                CustomMessage customMessage = new CustomMessage(2921428, ad.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, ad.this.aiB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private BdUniqueId mPageId;
    private RelativeLayout mRootView;

    public ad(Context context, int i) {
        this.aiX = 0;
        this.aiX = i;
        this.mRootView = new RelativeLayout(context);
        this.aiV = new ImageView(context);
        this.aiW = new FrameLayout(context);
        this.aiW.addView(this.aiV, new FrameLayout.LayoutParams(aiU, aiU));
        this.aiW.setOnClickListener(this.aja);
        b(Align.ALIGN_RIGHT_BOTTOM);
        this.mRootView.addView(this.aiW);
        H(this.mRootView);
        setInsertIndex(-1);
        a(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b(Align align) {
        if (align != this.aiS) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds77);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams.topMargin = dimens;
                layoutParams.bottomMargin = 0;
                this.aiW.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                this.aiW.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds51);
                layoutParams3.topMargin = 0;
                this.aiW.setLayoutParams(layoutParams3);
            }
            this.aiS = align;
        }
    }

    public void g(com.baidu.tbadk.core.data.a aVar) {
        b(Align.ALIGN_RIGHT_TOP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void E(cb cbVar) {
        this.aiB = cbVar;
        if (cbVar == null) {
            this.aiW.setVisibility(8);
        } else if (!isShow(4)) {
            this.aiW.setVisibility(8);
        } else {
            this.aiW.setVisibility(0);
            SvgManager.bsU().a(this.aiV, this.aiY, this.aiZ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private boolean isShow(int i) {
        return (this.aiX & i) > 0;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.bsU().a(this.aiV, this.aiY, this.aiZ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
