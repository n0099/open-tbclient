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
    private bd aXU;
    private View.OnClickListener aXV;
    protected com.baidu.tbadk.d.a aXW;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aXW = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aXV = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aXW == null || !ClickableHeaderImageView.this.aXW.aL(view)) && ClickableHeaderImageView.this.aXU != null && ClickableHeaderImageView.this.aXU.yS() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aXU.yS().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aXU.yS().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aXU.yS().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aXU.zU() != null && ClickableHeaderImageView.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aXU.zU().channelId, ClickableHeaderImageView.this.aXU.zU().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aXU.yS().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aXU.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aXV != null) {
                        ClickableHeaderImageView.this.aXV.onClick(view);
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
                if ((ClickableHeaderImageView.this.aXW == null || !ClickableHeaderImageView.this.aXW.aL(view)) && ClickableHeaderImageView.this.aXU != null && ClickableHeaderImageView.this.aXU.yS() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aXU.yS().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aXU.yS().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aXU.yS().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aXU.zU() != null && ClickableHeaderImageView.this.aXU.zU().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aXU.zU().channelId, ClickableHeaderImageView.this.aXU.zU().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aXU.yS().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aXU.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aXV != null) {
                        ClickableHeaderImageView.this.aXV.onClick(view);
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
        setDefaultBgResource(d.C0107d.cp_bg_line_e);
    }

    public void a(bd bdVar, boolean z) {
        if (bdVar != null && bdVar.yS() != null) {
            this.aXU = bdVar;
            MetaData yS = bdVar.yS();
            setContentDescription(yS.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(yS.getUserId());
            setUserName(yS.getUserName());
            setUrl(yS.getPortrait());
            if (bdVar.zl() != null && this.aXU.getThreadType() == 49) {
                startLoad(bdVar.yS().getPortrait(), 28, false);
            } else if (this.aXU.zU() != null && this.aXU.zU().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.aXU.zU().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(yS.getPortrait()) && yS.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(yS.getPortrait(), 10, false);
            } else {
                startLoad(yS.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, yS);
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
