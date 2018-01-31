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
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bd aYc;
    private View.OnClickListener aYd;
    protected com.baidu.tbadk.d.a aYe;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aYe = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aYd = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aYe == null || !ClickableHeaderImageView.this.aYe.aL(view)) && ClickableHeaderImageView.this.aYc != null && ClickableHeaderImageView.this.aYc.yT() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aYc.yT().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aYc.yT().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aYc.yT().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aYc.zV() != null && ClickableHeaderImageView.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aYc.zV().channelId, ClickableHeaderImageView.this.aYc.zV().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aYc.yT().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aYc.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aYd != null) {
                        ClickableHeaderImageView.this.aYd.onClick(view);
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
                if ((ClickableHeaderImageView.this.aYe == null || !ClickableHeaderImageView.this.aYe.aL(view)) && ClickableHeaderImageView.this.aYc != null && ClickableHeaderImageView.this.aYc.yT() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aYc.yT().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aYc.yT().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aYc.yT().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aYc.zV() != null && ClickableHeaderImageView.this.aYc.zV().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aYc.zV().channelId, ClickableHeaderImageView.this.aYc.zV().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aYc.yT().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aYc.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aYd != null) {
                        ClickableHeaderImageView.this.aYd.onClick(view);
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
        setDefaultBgResource(d.C0108d.cp_bg_line_e);
    }

    public void a(bd bdVar, boolean z) {
        if (bdVar != null && bdVar.yT() != null) {
            this.aYc = bdVar;
            MetaData yT = bdVar.yT();
            setContentDescription(yT.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(yT.getUserId());
            setUserName(yT.getUserName());
            setUrl(yT.getPortrait());
            if (bdVar.zm() != null && this.aYc.getThreadType() == 49) {
                startLoad(bdVar.yT().getPortrait(), 28, false);
            } else if (this.aYc.zV() != null && this.aYc.zV().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.aYc.zV().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(yT.getPortrait()) && yT.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(yT.getPortrait(), 10, false);
            } else {
                startLoad(yT.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, yT);
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
