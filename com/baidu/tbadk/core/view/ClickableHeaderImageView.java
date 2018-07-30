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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bb atD;
    private View.OnClickListener atE;
    protected com.baidu.tbadk.f.b atF;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.atF = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.atE = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.atF == null || !ClickableHeaderImageView.this.atF.v(view)) && ClickableHeaderImageView.this.atD != null && ClickableHeaderImageView.this.atD.vk() != null && !StringUtils.isNull(ClickableHeaderImageView.this.atD.vk().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.atD.vk().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.atD.vk().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.atD.wl() != null && ClickableHeaderImageView.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.atD.wl().channelId, ClickableHeaderImageView.this.atD.wl().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.atD.vk().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.atD.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.atE != null) {
                        ClickableHeaderImageView.this.atE.onClick(view);
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
                if ((ClickableHeaderImageView.this.atF == null || !ClickableHeaderImageView.this.atF.v(view)) && ClickableHeaderImageView.this.atD != null && ClickableHeaderImageView.this.atD.vk() != null && !StringUtils.isNull(ClickableHeaderImageView.this.atD.vk().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.atD.vk().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.atD.vk().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.atD.wl() != null && ClickableHeaderImageView.this.atD.wl().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.atD.wl().channelId, ClickableHeaderImageView.this.atD.wl().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.atD.vk().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.atD.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.atE != null) {
                        ClickableHeaderImageView.this.atE.onClick(view);
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
        setDefaultBgResource(d.C0140d.cp_bg_line_e);
    }

    public void setData(bb bbVar, boolean z) {
        if (bbVar != null && bbVar.vk() != null) {
            this.atD = bbVar;
            MetaData vk = bbVar.vk();
            setContentDescription(vk.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(vk.getUserId());
            setUserName(vk.getUserName());
            setUrl(vk.getPortrait());
            if (bbVar.vD() != null && this.atD.getThreadType() == 49) {
                startLoad(bbVar.vk().getPortrait(), 28, false);
            } else if (this.atD.wl() != null && this.atD.wl().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.atD.wl().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(vk.getPortrait()) && vk.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(vk.getPortrait(), 10, false);
            } else {
                startLoad(vk.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, vk);
            }
        }
    }

    public void setData(bb bbVar) {
        setData(bbVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bb bbVar = new bb();
            bbVar.a(metaData);
            setData(bbVar);
        }
    }
}
