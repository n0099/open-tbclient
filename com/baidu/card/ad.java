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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ad extends d implements n<bk> {
    private TbImageView aeJ;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean adI = true;

    public ad(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.aeJ = new TbImageView(tbPageContext.getPageActivity());
        F(this.aeJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bk bkVar) {
        b(bkVar);
    }

    public void b(bk bkVar) {
        MetaData aQx;
        if (bkVar != null && this.aeJ != null && (aQx = bkVar.aQx()) != null) {
            final ThemeCardInUserData themeCard = aQx.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid()) || bkVar.dHI) {
                this.aeJ.setVisibility(8);
                return;
            }
            if (this.adI && (this.aeJ.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aeJ.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.aeJ.setLayoutParams(layoutParams);
            }
            this.aeJ.setVisibility(0);
            this.mType = 1;
            this.aeJ.setImageDrawable(null);
            this.aeJ.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.aeJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.ad.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(ad.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void aG(boolean z) {
        this.adI = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.aeJ.setPageId(bdUniqueId);
    }
}
