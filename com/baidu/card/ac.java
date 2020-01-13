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
/* loaded from: classes6.dex */
public class ac extends d implements m<bj> {
    private TbImageView KQ;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean KR = true;

    public ac(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.KQ = new TbImageView(tbPageContext.getPageActivity());
        F(this.KQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: a */
    public void A(bj bjVar) {
        b(bjVar);
    }

    public void b(bj bjVar) {
        MetaData azX;
        if (bjVar != null && this.KQ != null && (azX = bjVar.azX()) != null) {
            final ThemeCardInUserData themeCard = azX.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid()) || bjVar.cQj) {
                this.KQ.setVisibility(8);
                return;
            }
            if (this.KR && (this.KQ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.KQ.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.KQ.setLayoutParams(layoutParams);
            }
            this.KQ.setVisibility(0);
            this.mType = 1;
            this.KQ.setImageDrawable(null);
            this.KQ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.KQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.ac.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(ac.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void ac(boolean z) {
        this.KR = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.KQ.setPageId(bdUniqueId);
    }
}
