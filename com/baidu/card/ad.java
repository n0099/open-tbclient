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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ad extends c implements p<bz>, q {
    private static final int aiF = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    private Align aiD;
    private ImageView aiG;
    private FrameLayout aiH;
    private int aiI;
    private int aiJ = R.drawable.ic_icon_pure_card_delete_svg;
    private int aiK = R.color.CAM_X0111;
    private View.OnClickListener aiL = new View.OnClickListener() { // from class: com.baidu.card.ad.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ad.this.aim != null) {
                CustomMessage customMessage = new CustomMessage(2921428, ad.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, ad.this.aim);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private bz aim;
    private BdUniqueId mPageId;
    private RelativeLayout mRootView;

    public ad(Context context, int i) {
        this.aiI = 0;
        this.aiI = i;
        this.mRootView = new RelativeLayout(context);
        this.aiG = new ImageView(context);
        this.aiH = new FrameLayout(context);
        this.aiH.addView(this.aiG, new FrameLayout.LayoutParams(aiF, aiF));
        this.aiH.setOnClickListener(this.aiL);
        b(Align.ALIGN_RIGHT_BOTTOM);
        this.mRootView.addView(this.aiH);
        H(this.mRootView);
        setInsertIndex(-1);
        a(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b(Align align) {
        if (align != this.aiD) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds77);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams.topMargin = dimens;
                layoutParams.bottomMargin = 0;
                this.aiH.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                this.aiH.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds51);
                layoutParams3.topMargin = 0;
                this.aiH.setLayoutParams(layoutParams3);
            }
            this.aiD = align;
        }
    }

    public void g(com.baidu.tbadk.core.data.a aVar) {
        b(Align.ALIGN_RIGHT_TOP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void D(bz bzVar) {
        this.aim = bzVar;
        if (bzVar == null) {
            this.aiH.setVisibility(8);
        } else if (!isShow(4)) {
            this.aiH.setVisibility(8);
        } else {
            this.aiH.setVisibility(0);
            SvgManager.bwr().a(this.aiG, this.aiJ, this.aiK, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private boolean isShow(int i) {
        return (this.aiI & i) > 0;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.bwr().a(this.aiG, this.aiJ, this.aiK, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
