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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bd ajJ;
    private View.OnClickListener ajK;
    protected com.baidu.tbadk.d.a ajL;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.ajL = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajK = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.ajL == null || !ClickableHeaderImageView.this.ajL.s(view)) && ClickableHeaderImageView.this.ajJ != null && ClickableHeaderImageView.this.ajJ.rv() != null && !StringUtils.isNull(ClickableHeaderImageView.this.ajJ.rv().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.ajJ.rv().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.ajJ.rv().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.ajJ.sA() != null && ClickableHeaderImageView.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.ajJ.sA().channelId, ClickableHeaderImageView.this.ajJ.sA().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.ajJ.rv().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.ajJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.ajK != null) {
                        ClickableHeaderImageView.this.ajK.onClick(view);
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
                if ((ClickableHeaderImageView.this.ajL == null || !ClickableHeaderImageView.this.ajL.s(view)) && ClickableHeaderImageView.this.ajJ != null && ClickableHeaderImageView.this.ajJ.rv() != null && !StringUtils.isNull(ClickableHeaderImageView.this.ajJ.rv().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.ajJ.rv().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.ajJ.rv().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.ajJ.sA() != null && ClickableHeaderImageView.this.ajJ.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.ajJ.sA().channelId, ClickableHeaderImageView.this.ajJ.sA().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.ajJ.rv().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.ajJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.ajK != null) {
                        ClickableHeaderImageView.this.ajK.onClick(view);
                    }
                }
            }
        };
        init();
    }

    public void init() {
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(d.f.icon_default_avatar100);
        setDefaultBgResource(d.C0096d.cp_bg_line_e);
    }

    public void a(bd bdVar, boolean z) {
        if (bdVar != null && bdVar.rv() != null) {
            this.ajJ = bdVar;
            MetaData rv = bdVar.rv();
            setContentDescription(rv.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(rv.getUserId());
            setUserName(rv.getUserName());
            setUrl(rv.getPortrait());
            if (bdVar.rO() != null && this.ajJ.getThreadType() == 49) {
                startLoad(bdVar.rv().getPortrait(), 28, false);
            } else if (this.ajJ.sA() != null && this.ajJ.sA().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.ajJ.sA().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(rv.getPortrait()) && rv.getPortrait().contains("http")) {
                startLoad(rv.getPortrait(), 10, false);
            } else {
                startLoad(rv.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, rv);
            }
        }
    }

    public void setData(bd bdVar) {
        a(bdVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bd bdVar = new bd();
            bdVar.a(metaData);
            setData(bdVar);
        }
    }
}
