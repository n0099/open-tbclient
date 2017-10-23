package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bh aiU;
    private View.OnClickListener aiV;
    protected com.baidu.tbadk.d.a aiW;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aiW = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiV = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aiW == null || !ClickableHeaderImageView.this.aiW.s(view)) && ClickableHeaderImageView.this.aiU != null && ClickableHeaderImageView.this.aiU.getAuthor() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aiU.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aiU.getAuthor().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aiU.ss() != null && ClickableHeaderImageView.this.aiU.ss().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aiU.ss().channelId, ClickableHeaderImageView.this.aiU.ss().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aiU.getAuthor().isBigV())));
                    }
                    if (ClickableHeaderImageView.this.aiV != null) {
                        ClickableHeaderImageView.this.aiV.onClick(view);
                    }
                }
            }
        };
        init();
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aiW == null || !ClickableHeaderImageView.this.aiW.s(view)) && ClickableHeaderImageView.this.aiU != null && ClickableHeaderImageView.this.aiU.getAuthor() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aiU.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aiU.getAuthor().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aiU.ss() != null && ClickableHeaderImageView.this.aiU.ss().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aiU.ss().channelId, ClickableHeaderImageView.this.aiU.ss().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aiU.getAuthor().isBigV())));
                    }
                    if (ClickableHeaderImageView.this.aiV != null) {
                        ClickableHeaderImageView.this.aiV.onClick(view);
                    }
                }
            }
        };
        init();
    }

    public void init() {
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(d.g.icon_default_avatar100);
        setDefaultBgResource(d.e.cp_bg_line_e);
    }

    public void a(bh bhVar, boolean z) {
        if (bhVar != null && bhVar.getAuthor() != null) {
            this.aiU = bhVar;
            MetaData author = bhVar.getAuthor();
            setContentDescription(author.getName_show() + getContext().getString(d.l.somebodys_portrait));
            setUserId(author.getUserId());
            setUserName(author.getUserName());
            setUrl(author.getPortrait());
            if (bhVar.rG() != null && this.aiU.getThreadType() == 49) {
                c(bhVar.getAuthor().getPortrait(), 28, false);
            } else if (this.aiU.ss() != null && this.aiU.ss().channelId > 0) {
                setDefaultErrorResource(d.g.avatar_channel_poto_defaul160);
                c(this.aiU.ss().channelAvatar, 10, false);
            } else {
                c(author.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, author);
            }
        }
    }

    public void setData(bh bhVar) {
        a(bhVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bh bhVar = new bh();
            bhVar.setAuthor(metaData);
            setData(bhVar);
        }
    }
}
