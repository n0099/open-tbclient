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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ad extends d implements p<by>, q {
    private static final int ahS = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    private by ahA;
    private Align ahQ;
    private ImageView ahT;
    private FrameLayout ahU;
    private int ahV;
    private int ahW = R.drawable.ic_icon_pure_card_delete_svg;
    private int ahX = R.color.CAM_X0111;
    private View.OnClickListener ahY = new View.OnClickListener() { // from class: com.baidu.card.ad.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ad.this.ahA != null) {
                CustomMessage customMessage = new CustomMessage(2921428, ad.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, ad.this.ahA);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private BdUniqueId mPageId;
    private RelativeLayout mRootView;

    public ad(Context context, int i) {
        this.ahV = 0;
        this.ahV = i;
        this.mRootView = new RelativeLayout(context);
        this.ahT = new ImageView(context);
        this.ahU = new FrameLayout(context);
        this.ahU.addView(this.ahT, new FrameLayout.LayoutParams(ahS, ahS));
        this.ahU.setOnClickListener(this.ahY);
        b(Align.ALIGN_RIGHT_BOTTOM);
        this.mRootView.addView(this.ahU);
        H((View) this.mRootView);
        setInsertIndex(-1);
        a(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b(Align align) {
        if (align != this.ahQ) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds77);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams.topMargin = dimens;
                layoutParams.bottomMargin = 0;
                this.ahU.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                this.ahU.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds51);
                layoutParams3.topMargin = 0;
                this.ahU.setLayoutParams(layoutParams3);
            }
            this.ahQ = align;
        }
    }

    public void g(com.baidu.tbadk.core.data.a aVar) {
        b(Align.ALIGN_RIGHT_TOP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(by byVar) {
        this.ahA = byVar;
        if (byVar == null) {
            this.ahU.setVisibility(8);
        } else if (!isShow(4)) {
            this.ahU.setVisibility(8);
        } else {
            this.ahU.setVisibility(0);
            SvgManager.btW().a(this.ahT, this.ahW, this.ahX, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private boolean isShow(int i) {
        return (this.ahV & i) > 0;
    }

    @Override // com.baidu.card.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.btW().a(this.ahT, this.ahW, this.ahX, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
