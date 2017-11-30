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
                if ((ClickableHeaderImageView.this.ajO == null || !ClickableHeaderImageView.this.ajO.s(view)) && ClickableHeaderImageView.this.ajM != null && ClickableHeaderImageView.this.ajM.rx() != null && !StringUtils.isNull(ClickableHeaderImageView.this.ajM.rx().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.ajM.rx().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.ajM.rx().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.ajM.sC() != null && ClickableHeaderImageView.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.ajM.sC().channelId, ClickableHeaderImageView.this.ajM.sC().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.ajM.rx().isBigV());
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
                if ((ClickableHeaderImageView.this.ajO == null || !ClickableHeaderImageView.this.ajO.s(view)) && ClickableHeaderImageView.this.ajM != null && ClickableHeaderImageView.this.ajM.rx() != null && !StringUtils.isNull(ClickableHeaderImageView.this.ajM.rx().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.ajM.rx().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.ajM.rx().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.ajM.sC() != null && ClickableHeaderImageView.this.ajM.sC().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.ajM.sC().channelId, ClickableHeaderImageView.this.ajM.sC().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.ajM.rx().isBigV());
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
        setDefaultBgResource(d.C0082d.cp_bg_line_e);
    }

    public void a(bd bdVar, boolean z) {
        if (bdVar != null && bdVar.rx() != null) {
            this.ajM = bdVar;
            MetaData rx = bdVar.rx();
            setContentDescription(rx.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(rx.getUserId());
            setUserName(rx.getUserName());
            setUrl(rx.getPortrait());
            if (bdVar.rQ() != null && this.ajM.getThreadType() == 49) {
                startLoad(bdVar.rx().getPortrait(), 28, false);
            } else if (this.ajM.sC() != null && this.ajM.sC().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.ajM.sC().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(rx.getPortrait()) && rx.getPortrait().contains("http")) {
                startLoad(rx.getPortrait(), 10, false);
            } else {
                startLoad(rx.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, rx);
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
