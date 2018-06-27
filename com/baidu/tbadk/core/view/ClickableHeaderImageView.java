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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bc atZ;
    private View.OnClickListener aua;
    protected com.baidu.tbadk.e.b aub;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.b bVar) {
        this.aub = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aua = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aub == null || !ClickableHeaderImageView.this.aub.v(view)) && ClickableHeaderImageView.this.atZ != null && ClickableHeaderImageView.this.atZ.vw() != null && !StringUtils.isNull(ClickableHeaderImageView.this.atZ.vw().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.atZ.vw().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.atZ.vw().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.atZ.ww() != null && ClickableHeaderImageView.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.atZ.ww().channelId, ClickableHeaderImageView.this.atZ.ww().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.atZ.vw().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.atZ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aua != null) {
                        ClickableHeaderImageView.this.aua.onClick(view);
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
                if ((ClickableHeaderImageView.this.aub == null || !ClickableHeaderImageView.this.aub.v(view)) && ClickableHeaderImageView.this.atZ != null && ClickableHeaderImageView.this.atZ.vw() != null && !StringUtils.isNull(ClickableHeaderImageView.this.atZ.vw().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.atZ.vw().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.atZ.vw().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.atZ.ww() != null && ClickableHeaderImageView.this.atZ.ww().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.atZ.ww().channelId, ClickableHeaderImageView.this.atZ.ww().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.atZ.vw().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.atZ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aua != null) {
                        ClickableHeaderImageView.this.aua.onClick(view);
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
        setDefaultBgResource(d.C0142d.cp_bg_line_e);
    }

    public void setData(bc bcVar, boolean z) {
        if (bcVar != null && bcVar.vw() != null) {
            this.atZ = bcVar;
            MetaData vw = bcVar.vw();
            setContentDescription(vw.getName_show() + getContext().getString(d.k.somebodys_portrait));
            setUserId(vw.getUserId());
            setUserName(vw.getUserName());
            setUrl(vw.getPortrait());
            if (bcVar.vO() != null && this.atZ.getThreadType() == 49) {
                startLoad(bcVar.vw().getPortrait(), 28, false);
            } else if (this.atZ.ww() != null && this.atZ.ww().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.atZ.ww().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(vw.getPortrait()) && vw.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(vw.getPortrait(), 10, false);
            } else {
                startLoad(vw.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, vw);
            }
        }
    }

    public void setData(bc bcVar) {
        setData(bcVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bc bcVar = new bc();
            bcVar.a(metaData);
            setData(bcVar);
        }
    }
}
