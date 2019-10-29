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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class w extends c implements i<bh> {
    private TbImageView Gn;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean Go = true;

    public w(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        aE(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.Gn = new TbImageView(tbPageContext.getPageActivity());
        F(this.Gn);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(bh bhVar) {
        b(bhVar);
    }

    public void b(bh bhVar) {
        MetaData aiG;
        if (bhVar != null && this.Gn != null && (aiG = bhVar.aiG()) != null) {
            final ThemeCardInUserData themeCard = aiG.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid()) || bhVar.ceC) {
                this.Gn.setVisibility(8);
                return;
            }
            if (this.Go && (this.Gn.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Gn.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.Gn.setLayoutParams(layoutParams);
            }
            this.Gn.setVisibility(0);
            this.mType = 1;
            this.Gn.setImageDrawable(null);
            this.Gn.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.Gn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(w.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void X(boolean z) {
        this.Go = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.Gn.setPageId(bdUniqueId);
    }
}
