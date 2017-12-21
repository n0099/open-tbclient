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
    private bd ajM;
    private View.OnClickListener ajN;
    protected com.baidu.tbadk.d.a ajO;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.ajO = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajN = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.ajO == null || !ClickableHeaderImageView.this.ajO.s(view)) && ClickableHeaderImageView.this.ajM != null && ClickableHeaderImageView.this.ajM.rv() != null && !StringUtils.isNull(ClickableHeaderImageView.this.ajM.rv().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.ajM.rv().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.ajM.rv().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.ajM.sA() != null && ClickableHeaderImageView.this.ajM.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.ajM.sA().channelId, ClickableHeaderImageView.this.ajM.sA().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.ajM.rv().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.ajM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.ajN != null) {
                        ClickableHeaderImageView.this.ajN.onClick(view);
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
                if ((ClickableHeaderImageView.this.ajO == null || !ClickableHeaderImageView.this.ajO.s(view)) && ClickableHeaderImageView.this.ajM != null && ClickableHeaderImageView.this.ajM.rv() != null && !StringUtils.isNull(ClickableHeaderImageView.this.ajM.rv().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.ajM.rv().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.ajM.rv().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.ajM.sA() != null && ClickableHeaderImageView.this.ajM.sA().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.ajM.sA().channelId, ClickableHeaderImageView.this.ajM.sA().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.ajM.rv().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.ajM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.ajN != null) {
                        ClickableHeaderImageView.this.ajN.onClick(view);
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
        setDefaultBgResource(d.C0095d.cp_bg_line_e);
    }

    public void a(bd bdVar, boolean z) {
        if (bdVar != null && bdVar.rv() != null) {
            this.ajM = bdVar;
            MetaData rv = bdVar.rv();
            setContentDescription(rv.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(rv.getUserId());
            setUserName(rv.getUserName());
            setUrl(rv.getPortrait());
            if (bdVar.rO() != null && this.ajM.getThreadType() == 49) {
                startLoad(bdVar.rv().getPortrait(), 28, false);
            } else if (this.ajM.sA() != null && this.ajM.sA().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.ajM.sA().channelAvatar, 10, false);
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
