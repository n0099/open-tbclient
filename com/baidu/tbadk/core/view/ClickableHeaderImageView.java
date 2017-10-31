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
    private bh ajq;
    private View.OnClickListener ajr;
    protected com.baidu.tbadk.e.a ajs;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.ajs = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajr = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.ajs == null || !ClickableHeaderImageView.this.ajs.s(view)) && ClickableHeaderImageView.this.ajq != null && ClickableHeaderImageView.this.ajq.rt() != null && !StringUtils.isNull(ClickableHeaderImageView.this.ajq.rt().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.ajq.rt().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.ajq.rt().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.ajq.sz() != null && ClickableHeaderImageView.this.ajq.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.ajq.sz().channelId, ClickableHeaderImageView.this.ajq.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.ajq.rt().isBigV())));
                    }
                    if (ClickableHeaderImageView.this.ajr != null) {
                        ClickableHeaderImageView.this.ajr.onClick(view);
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
                if ((ClickableHeaderImageView.this.ajs == null || !ClickableHeaderImageView.this.ajs.s(view)) && ClickableHeaderImageView.this.ajq != null && ClickableHeaderImageView.this.ajq.rt() != null && !StringUtils.isNull(ClickableHeaderImageView.this.ajq.rt().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.ajq.rt().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.ajq.rt().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.ajq.sz() != null && ClickableHeaderImageView.this.ajq.sz().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.ajq.sz().channelId, ClickableHeaderImageView.this.ajq.sz().mCurrentPage)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.ajq.rt().isBigV())));
                    }
                    if (ClickableHeaderImageView.this.ajr != null) {
                        ClickableHeaderImageView.this.ajr.onClick(view);
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
        setDefaultBgResource(d.C0080d.cp_bg_line_e);
    }

    public void a(bh bhVar, boolean z) {
        if (bhVar != null && bhVar.rt() != null) {
            this.ajq = bhVar;
            MetaData rt = bhVar.rt();
            setContentDescription(rt.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(rt.getUserId());
            setUserName(rt.getUserName());
            setUrl(rt.getPortrait());
            if (bhVar.rM() != null && this.ajq.getThreadType() == 49) {
                startLoad(bhVar.rt().getPortrait(), 28, false);
            } else if (this.ajq.sz() != null && this.ajq.sz().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.ajq.sz().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(rt.getPortrait()) && rt.getPortrait().contains("http")) {
                startLoad(rt.getPortrait(), 10, false);
            } else {
                startLoad(rt.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, rt);
            }
        }
    }

    public void setData(bh bhVar) {
        a(bhVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bh bhVar = new bh();
            bhVar.a(metaData);
            setData(bhVar);
        }
    }
}
