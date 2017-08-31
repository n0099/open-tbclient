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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bj ajF;
    private View.OnClickListener ajG;
    protected com.baidu.tbadk.e.a ajH;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.ajH = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajG = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.ajH == null || !ClickableHeaderImageView.this.ajH.s(view)) && ClickableHeaderImageView.this.ajF != null && ClickableHeaderImageView.this.ajF.getAuthor() != null && !StringUtils.isNull(ClickableHeaderImageView.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.ajF.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.ajF.getAuthor().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.ajF.sF() != null && ClickableHeaderImageView.this.ajF.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.ajF.sF().channelId, ClickableHeaderImageView.this.ajF.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.ajF.getAuthor().isBigV())));
                    }
                    if (ClickableHeaderImageView.this.ajG != null) {
                        ClickableHeaderImageView.this.ajG.onClick(view);
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
                if ((ClickableHeaderImageView.this.ajH == null || !ClickableHeaderImageView.this.ajH.s(view)) && ClickableHeaderImageView.this.ajF != null && ClickableHeaderImageView.this.ajF.getAuthor() != null && !StringUtils.isNull(ClickableHeaderImageView.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.ajF.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.ajF.getAuthor().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.ajF.sF() != null && ClickableHeaderImageView.this.ajF.sF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.ajF.sF().channelId, ClickableHeaderImageView.this.ajF.sF().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.ajF.getAuthor().isBigV())));
                    }
                    if (ClickableHeaderImageView.this.ajG != null) {
                        ClickableHeaderImageView.this.ajG.onClick(view);
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

    public void a(bj bjVar, boolean z) {
        if (bjVar != null && bjVar.getAuthor() != null) {
            this.ajF = bjVar;
            MetaData author = bjVar.getAuthor();
            setContentDescription(author.getName_show() + getContext().getString(d.l.somebodys_portrait));
            setUserId(author.getUserId());
            setUserName(author.getUserName());
            setUrl(author.getPortrait());
            if (bjVar.rT() != null && this.ajF.getThreadType() == 49) {
                c(bjVar.getAuthor().getPortrait(), 28, false);
            } else if (this.ajF.sF() != null && this.ajF.sF().channelId > 0) {
                setDefaultErrorResource(d.g.avatar_channel_poto_defaul160);
                c(this.ajF.sF().channelAvatar, 10, false);
            } else {
                c(author.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, author);
            }
        }
    }

    public void setData(bj bjVar) {
        a(bjVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bj bjVar = new bj();
            bjVar.setAuthor(metaData);
            setData(bjVar);
        }
    }
}
