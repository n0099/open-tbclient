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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ah extends d implements n<bv> {
    private TbImageView afj;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean aec = true;

    public ah(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.afj = new TbImageView(tbPageContext.getPageActivity());
        H(this.afj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.n
    /* renamed from: a */
    public void D(bv bvVar) {
        b(bvVar);
    }

    public void b(bv bvVar) {
        MetaData aWl;
        if (bvVar != null && this.afj != null && (aWl = bvVar.aWl()) != null) {
            final ThemeCardInUserData themeCard = aWl.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid()) || bvVar.dUF) {
                this.afj.setVisibility(8);
                return;
            }
            if (this.aec && (this.afj.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.afj.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.afj.setLayoutParams(layoutParams);
            }
            this.afj.setVisibility(0);
            this.mType = 1;
            this.afj.setImageDrawable(null);
            this.afj.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.afj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.ah.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(ah.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void aJ(boolean z) {
        this.aec = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.afj.setPageId(bdUniqueId);
    }
}
