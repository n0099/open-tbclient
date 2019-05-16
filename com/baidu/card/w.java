package com.baidu.card;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class w extends c implements i<bg> {
    private TbImageView We;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean Wf = true;

    public w(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bp(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.We = new TbImageView(tbPageContext.getPageActivity());
        I(this.We);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bg bgVar) {
        b(bgVar);
    }

    public void b(bg bgVar) {
        MetaData adv;
        if (bgVar != null && this.We != null && (adv = bgVar.adv()) != null) {
            final ThemeCardInUserData themeCard = adv.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.We.setVisibility(8);
                return;
            }
            if (this.Wf && (this.We.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.We.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.We.setLayoutParams(layoutParams);
            }
            this.We.setVisibility(0);
            this.mType = 1;
            this.We.setImageDrawable(null);
            this.We.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.We.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(w.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void az(boolean z) {
        this.Wf = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.We.setPageId(bdUniqueId);
    }
}
