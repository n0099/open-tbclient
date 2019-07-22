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
    private TbImageView Wy;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean Wz = true;

    public w(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bp(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.Wy = new TbImageView(tbPageContext.getPageActivity());
        K(this.Wy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bg bgVar) {
        b(bgVar);
    }

    public void b(bg bgVar) {
        MetaData aex;
        if (bgVar != null && this.Wy != null && (aex = bgVar.aex()) != null) {
            final ThemeCardInUserData themeCard = aex.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.Wy.setVisibility(8);
                return;
            }
            if (this.Wz && (this.Wy.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Wy.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.Wy.setLayoutParams(layoutParams);
            }
            this.Wy.setVisibility(0);
            this.mType = 1;
            this.Wy.setImageDrawable(null);
            this.Wy.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.Wy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(w.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void aC(boolean z) {
        this.Wz = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.Wy.setPageId(bdUniqueId);
    }
}
