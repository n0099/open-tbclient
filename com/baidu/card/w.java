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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class w extends c implements i<bg> {
    private TbImageView Ym;
    private TbPageContext mPageContext;
    private int mType = 0;
    private boolean Yn = true;

    public w(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        bw(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.ds180), com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds30);
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(tbPageContext.getPageActivity(), d.e.tbds30);
        a(layoutParams);
        this.Ym = new TbImageView(tbPageContext.getPageActivity());
        I(this.Ym);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(bg bgVar) {
        b(bgVar);
    }

    public void b(bg bgVar) {
        MetaData YO;
        if (bgVar != null && this.Ym != null && (YO = bgVar.YO()) != null) {
            final ThemeCardInUserData themeCard = YO.getThemeCard();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.Ym.setVisibility(8);
                return;
            }
            if (this.Yn && (this.Ym.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Ym.getLayoutParams();
                layoutParams.rightMargin = com.baidu.adp.lib.util.l.h(this.mPageContext.getPageActivity(), d.e.tbds106);
                this.Ym.setLayoutParams(layoutParams);
            }
            this.Ym.setVisibility(0);
            this.mType = 1;
            this.Ym.setImageDrawable(null);
            this.Ym.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
            this.Ym.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.card.w.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(w.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                }
            });
        }
    }

    public void aH(boolean z) {
        this.Yn = z;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.Ym.setPageId(bdUniqueId);
    }
}
