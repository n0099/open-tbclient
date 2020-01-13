package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class y extends d implements m<bj>, n {
    private ImageView KF;
    private ImageView KG;
    private FrameLayout KH;
    private int KI;
    private View.OnClickListener KJ = new View.OnClickListener() { // from class: com.baidu.card.y.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (y.this.Kn != null) {
                CustomMessage customMessage = new CustomMessage(2921428, y.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, y.this.Kn);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private bj Kn;
    private BdUniqueId mPageId;
    private LinearLayout mRootView;

    public y(Context context, int i) {
        this.KI = 0;
        this.KI = i;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(0);
        this.mRootView.setGravity(16);
        int dimens = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds42);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds122);
        this.KF = new ImageView(context);
        this.mRootView.addView(this.KF, new LinearLayout.LayoutParams(dimens, dimens));
        this.KG = new ImageView(context);
        this.KH = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
        layoutParams.gravity = 17;
        this.KH.addView(this.KG, layoutParams);
        this.KH.setOnClickListener(this.KJ);
        this.mRootView.addView(this.KH, new LinearLayout.LayoutParams(dimens2, dimens2));
        F(this.mRootView);
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8);
        a(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(bj bjVar) {
        this.Kn = bjVar;
        if (bjVar == null) {
            this.KF.setVisibility(8);
            this.KH.setVisibility(8);
            return;
        }
        if (!isShow(2) || !bjVar.isPrivacy) {
            this.KF.setVisibility(8);
        } else if (bjVar.isPrivacy) {
            this.KF.setVisibility(0);
            SvgManager.aEp().a(this.KF, R.drawable.icon_pure_personalba_lock16_svg, R.color.cp_cont_g, (SvgManager.SvgResourceStateType) null);
        }
        if (!isShow(4)) {
            this.KH.setVisibility(8);
            return;
        }
        this.KH.setVisibility(0);
        SvgManager.aEp().a(this.KG, R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private boolean isShow(int i) {
        return (this.KI & i) > 0;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.aEp().a(this.KF, R.drawable.icon_pure_personalba_lock16_svg, R.color.cp_cont_g, (SvgManager.SvgResourceStateType) null);
        SvgManager.aEp().a(this.KG, R.drawable.icon_pure_personalba_more24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
