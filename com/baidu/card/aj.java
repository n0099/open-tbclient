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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class aj extends d implements p<bw> {
    private TbImageView ahg;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean afV = true;

    public aj(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.ahg = new TbImageView(tbPageContext.getPageActivity());
        H((View) this.ahg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.p
    /* renamed from: a */
    public void H(bw bwVar) {
        b(bwVar);
    }

    public void b(bw bwVar) {
        MetaData bmA;
        if (bwVar != null && this.ahg != null && (bmA = bwVar.bmA()) != null) {
            final ThemeCardInUserData themeCard = bmA.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid()) || bwVar.eGK) {
                this.ahg.setVisibility(8);
                return;
            }
            if (this.afV && (this.ahg.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahg.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.ahg.setLayoutParams(layoutParams);
            }
            this.ahg.setVisibility(0);
            this.mType = 1;
            this.ahg.setImageDrawable(null);
            this.ahg.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.ahg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.aj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(aj.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void aK(boolean z) {
        this.afV = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ahg.setPageId(bdUniqueId);
    }
}
