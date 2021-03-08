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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class aj extends c implements p<cb> {
    private TbImageView ajj;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean aia = true;

    public aj(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.ajj = new TbImageView(tbPageContext.getPageActivity());
        H(this.ajj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void E(cb cbVar) {
        b(cbVar);
    }

    public void b(cb cbVar) {
        MetaData bnS;
        if (cbVar != null && this.ajj != null && (bnS = cbVar.bnS()) != null) {
            final ThemeCardInUserData themeCard = bnS.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid()) || cbVar.eVb) {
                this.ajj.setVisibility(8);
                return;
            }
            if (this.aia && (this.ajj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajj.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.ajj.setLayoutParams(layoutParams);
            }
            this.ajj.setVisibility(0);
            this.mType = 1;
            this.ajj.setImageDrawable(null);
            this.ajj.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ajj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.aj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(aj.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void aJ(boolean z) {
        this.aia = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ajj.setPageId(bdUniqueId);
    }
}
