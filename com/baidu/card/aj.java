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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class aj extends c implements p<bz> {
    private TbImageView aiU;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean ahK = true;

    public aj(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.aiU = new TbImageView(tbPageContext.getPageActivity());
        H(this.aiU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void D(bz bzVar) {
        b(bzVar);
    }

    public void b(bz bzVar) {
        MetaData brq;
        if (bzVar != null && this.aiU != null && (brq = bzVar.brq()) != null) {
            final ThemeCardInUserData themeCard = brq.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid()) || bzVar.eVZ) {
                this.aiU.setVisibility(8);
                return;
            }
            if (this.ahK && (this.aiU.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiU.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.aiU.setLayoutParams(layoutParams);
            }
            this.aiU.setVisibility(0);
            this.mType = 1;
            this.aiU.setImageDrawable(null);
            this.aiU.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.aiU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.aj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(aj.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void aJ(boolean z) {
        this.ahK = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.aiU.setPageId(bdUniqueId);
    }
}
