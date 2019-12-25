package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ac extends d implements m<bj> {
    private TbImageView KL;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean KM = true;

    public ac(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.KL = new TbImageView(tbPageContext.getPageActivity());
        F(this.KL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(bj bjVar) {
        b(bjVar);
    }

    public void b(bj bjVar) {
        MetaData azE;
        if (bjVar != null && this.KL != null && (azE = bjVar.azE()) != null) {
            final ThemeCardInUserData themeCard = azE.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid()) || bjVar.cPZ) {
                this.KL.setVisibility(8);
                return;
            }
            if (this.KM && (this.KL.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.KL.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.KL.setLayoutParams(layoutParams);
            }
            this.KL.setVisibility(0);
            this.mType = 1;
            this.KL.setImageDrawable(null);
            this.KL.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.KL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.ac.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(ac.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void ac(boolean z) {
        this.KM = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.KL.setPageId(bdUniqueId);
    }
}
