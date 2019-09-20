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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class w extends c implements i<bh> {
    private TbImageView Wx;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean Wy = true;

    public w(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bp(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds180), com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        a(layoutParams);
        this.Wx = new TbImageView(tbPageContext.getPageActivity());
        K(this.Wx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bh bhVar) {
        b(bhVar);
    }

    public void b(bh bhVar) {
        MetaData aeC;
        if (bhVar != null && this.Wx != null && (aeC = bhVar.aeC()) != null) {
            final ThemeCardInUserData themeCard = aeC.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid()) || bhVar.bMT) {
                this.Wx.setVisibility(8);
                return;
            }
            if (this.Wy && (this.Wx.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Wx.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.g(this.mPageContext.getPageActivity(), R.dimen.tbds106);
                this.Wx.setLayoutParams(layoutParams);
            }
            this.Wx.setVisibility(0);
            this.mType = 1;
            this.Wx.setImageDrawable(null);
            this.Wx.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.Wx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(w.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void aC(boolean z) {
        this.Wy = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.Wx.setPageId(bdUniqueId);
    }
}
