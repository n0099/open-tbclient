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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ab extends d implements n<bu>, o {
    private static final int afd = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    private bu aeK;
    private Align afc;
    private ImageView afe;
    private FrameLayout aff;
    private int afg;
    private int afh = R.drawable.ic_icon_pure_card_delete_svg;
    private int afi = R.color.cp_cont_g;
    private View.OnClickListener afj = new View.OnClickListener() { // from class: com.baidu.card.ab.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ab.this.aeK != null) {
                CustomMessage customMessage = new CustomMessage(2921428, ab.this.mPageId);
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, ab.this.aeK);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    };
    private BdUniqueId mPageId;
    private RelativeLayout mRootView;

    public ab(Context context, int i) {
        this.afg = 0;
        this.afg = i;
        this.mRootView = new RelativeLayout(context);
        this.afe = new ImageView(context);
        this.aff = new FrameLayout(context);
        this.aff.addView(this.afe, new FrameLayout.LayoutParams(afd, afd));
        this.aff.setOnClickListener(this.afj);
        b(Align.ALIGN_RIGHT_BOTTOM);
        this.mRootView.addView(this.aff);
        F(this.mRootView);
        setInsertIndex(-1);
        a(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void b(Align align) {
        if (align != this.afc) {
            if (align == Align.ALIGN_RIGHT_TOP) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds77);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams.topMargin = dimens;
                layoutParams.bottomMargin = 0;
                this.aff.setLayoutParams(layoutParams);
            } else if (align == Align.ALIGN_RIGHT_CENTER) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(15);
                layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
                this.aff.setLayoutParams(layoutParams2);
            } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(11);
                layoutParams3.addRule(12);
                layoutParams3.rightMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                layoutParams3.bottomMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds51);
                layoutParams3.topMargin = 0;
                this.aff.setLayoutParams(layoutParams3);
            }
            this.afc = align;
        }
    }

    public void f(AbsThreadDataSupport absThreadDataSupport) {
        if (absThreadDataSupport.aPZ()) {
            b(Align.ALIGN_RIGHT_TOP);
        } else {
            b(Align.ALIGN_RIGHT_BOTTOM);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bu buVar) {
        this.aeK = buVar;
        if (buVar == null) {
            this.aff.setVisibility(8);
        } else if (!isShow(4)) {
            this.aff.setVisibility(8);
        } else {
            this.aff.setVisibility(0);
            SvgManager.aWQ().a(this.afe, this.afh, this.afi, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private boolean isShow(int i) {
        return (this.afg & i) > 0;
    }

    @Override // com.baidu.card.o
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.aWQ().a(this.afe, this.afh, this.afi, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
