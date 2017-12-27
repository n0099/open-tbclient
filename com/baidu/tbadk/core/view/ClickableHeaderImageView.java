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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private be aXV;
    private View.OnClickListener aXW;
    protected com.baidu.tbadk.d.a aXX;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aXX = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aXW = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aXX == null || !ClickableHeaderImageView.this.aXX.aL(view)) && ClickableHeaderImageView.this.aXV != null && ClickableHeaderImageView.this.aXV.yX() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aXV.yX().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aXV.yX().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aXV.yX().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aXV.Ac() != null && ClickableHeaderImageView.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aXV.Ac().channelId, ClickableHeaderImageView.this.aXV.Ac().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aXV.yX().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aXV.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aXW != null) {
                        ClickableHeaderImageView.this.aXW.onClick(view);
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
                if ((ClickableHeaderImageView.this.aXX == null || !ClickableHeaderImageView.this.aXX.aL(view)) && ClickableHeaderImageView.this.aXV != null && ClickableHeaderImageView.this.aXV.yX() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aXV.yX().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aXV.yX().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aXV.yX().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aXV.Ac() != null && ClickableHeaderImageView.this.aXV.Ac().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aXV.Ac().channelId, ClickableHeaderImageView.this.aXV.Ac().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aXV.yX().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aXV.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aXW != null) {
                        ClickableHeaderImageView.this.aXW.onClick(view);
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

    public void a(be beVar, boolean z) {
        if (beVar != null && beVar.yX() != null) {
            this.aXV = beVar;
            MetaData yX = beVar.yX();
            setContentDescription(yX.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(yX.getUserId());
            setUserName(yX.getUserName());
            setUrl(yX.getPortrait());
            if (beVar.zq() != null && this.aXV.getThreadType() == 49) {
                startLoad(beVar.yX().getPortrait(), 28, false);
            } else if (this.aXV.Ac() != null && this.aXV.Ac().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.aXV.Ac().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(yX.getPortrait()) && yX.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(yX.getPortrait(), 10, false);
            } else {
                startLoad(yX.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, yX);
            }
        }
    }

    public void setData(be beVar) {
        a(beVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            be beVar = new be();
            beVar.a(metaData);
            setData(beVar);
        }
    }
}
