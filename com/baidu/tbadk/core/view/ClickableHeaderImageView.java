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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bl aiQ;
    private View.OnClickListener aiR;
    protected com.baidu.tbadk.e.a aiS;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.aiS = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiR = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aiS == null || !ClickableHeaderImageView.this.aiS.s(view)) && ClickableHeaderImageView.this.aiQ != null && ClickableHeaderImageView.this.aiQ.getAuthor() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aiQ.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aiQ.getAuthor().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aiQ.sz() != null && ClickableHeaderImageView.this.aiQ.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aiQ.sz().channelId, ClickableHeaderImageView.this.aiQ.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aiQ.getAuthor().isBigV())));
                    }
                    if (ClickableHeaderImageView.this.aiR != null) {
                        ClickableHeaderImageView.this.aiR.onClick(view);
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
                if ((ClickableHeaderImageView.this.aiS == null || !ClickableHeaderImageView.this.aiS.s(view)) && ClickableHeaderImageView.this.aiQ != null && ClickableHeaderImageView.this.aiQ.getAuthor() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aiQ.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aiQ.getAuthor().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aiQ.sz() != null && ClickableHeaderImageView.this.aiQ.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aiQ.sz().channelId, ClickableHeaderImageView.this.aiQ.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aiQ.getAuthor().isBigV())));
                    }
                    if (ClickableHeaderImageView.this.aiR != null) {
                        ClickableHeaderImageView.this.aiR.onClick(view);
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

    public void a(bl blVar, boolean z) {
        if (blVar != null && blVar.getAuthor() != null) {
            this.aiQ = blVar;
            MetaData author = blVar.getAuthor();
            setContentDescription(author.getName_show() + getContext().getString(d.l.somebodys_portrait));
            setUserId(author.getUserId());
            setUserName(author.getUserName());
            setUrl(author.getPortrait());
            if (blVar.rN() != null && this.aiQ.getThreadType() == 49) {
                c(blVar.getAuthor().getPortrait(), 28, false);
            } else if (this.aiQ.sz() != null && this.aiQ.sz().channelId > 0) {
                setDefaultErrorResource(d.g.avatar_channel_poto_defaul160);
                c(this.aiQ.sz().channelAvatar, 10, false);
            } else {
                c(author.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, author);
            }
        }
    }

    public void setData(bl blVar) {
        a(blVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bl blVar = new bl();
            blVar.setAuthor(metaData);
            setData(blVar);
        }
    }
}
