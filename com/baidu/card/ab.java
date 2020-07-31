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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ab extends d implements n<bv>, o {
    private static final int aeU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    private bv aeA;
    private Align aeS;
    private ImageView aeV;
    private FrameLayout aeW;
    private int aeX;
    private int aeY = R.drawable.ic_icon_pure_card_delete_svg;
    private int aeZ = R.color.cp_cont_g;
    private View.OnClickListener afa = new View.OnClickListener() { // from class: com.baidu.card.ab.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ab.this.aeA != null) {
                CustomMessage customMessage = new CustomMessage(2921428, ab.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, ab.this.aeA);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private BdUniqueId mPageId;
    private RelativeLayout mRootView;

    public ab(Context context, int i) {
        this.aeX = 0;
        this.aeX = i;
        this.mRootView = new RelativeLayout(context);
        this.aeV = new ImageView(context);
        this.aeW = new FrameLayout(context);
        this.aeW.addView(this.aeV, new FrameLayout.LayoutParams(aeU, aeU));
        this.aeW.setOnClickListener(this.afa);
        b(Align.ALIGN_RIGHT_BOTTOM);
        this.mRootView.addView(this.aeW);
        H(this.mRootView);
        setInsertIndex(-1);
        a(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b(Align align) {
        if (align != this.aeS) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds77);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams.topMargin = dimens;
                layoutParams.bottomMargin = 0;
                this.aeW.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                this.aeW.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds51);
                layoutParams3.topMargin = 0;
                this.aeW.setLayoutParams(layoutParams3);
            }
            this.aeS = align;
        }
    }

    public void f(AbsThreadDataSupport absThreadDataSupport) {
        b(Align.ALIGN_RIGHT_TOP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bv bvVar) {
        this.aeA = bvVar;
        if (bvVar == null) {
            this.aeW.setVisibility(8);
        } else if (!isShow(4)) {
            this.aeW.setVisibility(8);
        } else {
            this.aeW.setVisibility(0);
            SvgManager.baR().a(this.aeV, this.aeY, this.aeZ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private boolean isShow(int i) {
        return (this.aeX & i) > 0;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.baR().a(this.aeV, this.aeY, this.aeZ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
