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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bd alf;
    private View.OnClickListener alg;
    protected com.baidu.tbadk.e.a alh;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.a aVar) {
        this.alh = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alg = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if ((ClickableHeaderImageView.this.alh == null || !ClickableHeaderImageView.this.alh.t(view2)) && ClickableHeaderImageView.this.alf != null && ClickableHeaderImageView.this.alf.rP() != null && !StringUtils.isNull(ClickableHeaderImageView.this.alf.rP().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.alf.rP().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.alf.rP().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.alf.sP() != null && ClickableHeaderImageView.this.alf.sP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.alf.sP().channelId, ClickableHeaderImageView.this.alf.sP().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.alf.rP().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.alf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.alg != null) {
                        ClickableHeaderImageView.this.alg.onClick(view2);
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
            public void onClick(View view2) {
                if ((ClickableHeaderImageView.this.alh == null || !ClickableHeaderImageView.this.alh.t(view2)) && ClickableHeaderImageView.this.alf != null && ClickableHeaderImageView.this.alf.rP() != null && !StringUtils.isNull(ClickableHeaderImageView.this.alf.rP().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.alf.rP().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.alf.rP().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.alf.sP() != null && ClickableHeaderImageView.this.alf.sP().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.alf.sP().channelId, ClickableHeaderImageView.this.alf.sP().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.alf.rP().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.alf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.alg != null) {
                        ClickableHeaderImageView.this.alg.onClick(view2);
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
        setDefaultBgResource(d.C0126d.cp_bg_line_e);
    }

    public void setData(bd bdVar, boolean z) {
        if (bdVar != null && bdVar.rP() != null) {
            this.alf = bdVar;
            MetaData rP = bdVar.rP();
            setContentDescription(rP.getName_show() + getContext().getString(d.k.somebodys_portrait));
            setUserId(rP.getUserId());
            setUserName(rP.getUserName());
            setUrl(rP.getPortrait());
            if (bdVar.sh() != null && this.alf.getThreadType() == 49) {
                startLoad(bdVar.rP().getPortrait(), 28, false);
            } else if (this.alf.sP() != null && this.alf.sP().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.alf.sP().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(rP.getPortrait()) && rP.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(rP.getPortrait(), 10, false);
            } else {
                startLoad(rP.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, rP);
            }
        }
    }

    public void setData(bd bdVar) {
        setData(bdVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bd bdVar = new bd();
            bdVar.a(metaData);
            setData(bdVar);
        }
    }
}
