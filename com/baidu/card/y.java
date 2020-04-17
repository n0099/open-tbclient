package com.baidu.card;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class y extends d implements m<bj>, n {
    private static final int adX = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    private bj adG;
    private ImageView adY;
    private FrameLayout adZ;
    private int aea;
    private final TextView aeb;
    private View.OnClickListener aec = new View.OnClickListener() { // from class: com.baidu.card.y.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (y.this.adG != null) {
                CustomMessage customMessage = new CustomMessage(2921428, y.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, y.this.adG);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private BdUniqueId mPageId;
    private LinearLayout mRootView;

    public y(Context context, int i) {
        this.aea = 0;
        this.aea = i;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(1);
        this.mRootView.setGravity(5);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds61);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds40);
        this.aeb = new TextView(context);
        this.aeb.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds32));
        this.aeb.setSingleLine();
        this.aeb.setText(R.string.private_desc);
        this.mRootView.addView(this.aeb, layoutParams);
        this.adY = new ImageView(context);
        this.adZ = new FrameLayout(context);
        this.adZ.addView(this.adY, new FrameLayout.LayoutParams(adX, adX));
        this.adZ.setOnClickListener(this.aec);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds42);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds51);
        this.mRootView.addView(this.adZ, layoutParams2);
        F(this.mRootView);
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(12);
        a(layoutParams3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(bj bjVar) {
        this.adG = bjVar;
        if (bjVar == null) {
            this.aeb.setVisibility(8);
            this.adZ.setVisibility(8);
            return;
        }
        if (!isShow(2) || !bjVar.isPrivacy) {
            this.aeb.setVisibility(8);
        } else if (bjVar.isPrivacy) {
            this.aeb.setVisibility(0);
            am.setViewTextColor(this.aeb, (int) R.color.cp_cont_d);
        }
        if (!isShow(4)) {
            this.adZ.setVisibility(8);
            return;
        }
        this.adZ.setVisibility(0);
        SvgManager.aOU().a(this.adY, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private boolean isShow(int i) {
        return (this.aea & i) > 0;
    }

    @Override // com.baidu.card.n
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setViewTextColor(this.aeb, (int) R.color.cp_cont_d);
        SvgManager.aOU().a(this.adY, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
