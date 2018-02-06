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
    private bd aZM;
    private View.OnClickListener aZN;
    protected com.baidu.tbadk.d.a aZO;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aZO = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aZN = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aZO == null || !ClickableHeaderImageView.this.aZO.aL(view)) && ClickableHeaderImageView.this.aZM != null && ClickableHeaderImageView.this.aZM.zn() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aZM.zn().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aZM.zn().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aZM.zn().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aZM.Ao() != null && ClickableHeaderImageView.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aZM.Ao().channelId, ClickableHeaderImageView.this.aZM.Ao().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aZM.zn().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aZM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aZN != null) {
                        ClickableHeaderImageView.this.aZN.onClick(view);
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
                if ((ClickableHeaderImageView.this.aZO == null || !ClickableHeaderImageView.this.aZO.aL(view)) && ClickableHeaderImageView.this.aZM != null && ClickableHeaderImageView.this.aZM.zn() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aZM.zn().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aZM.zn().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.aZM.zn().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aZM.Ao() != null && ClickableHeaderImageView.this.aZM.Ao().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aZM.Ao().channelId, ClickableHeaderImageView.this.aZM.Ao().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.aZM.zn().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aZM.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aZN != null) {
                        ClickableHeaderImageView.this.aZN.onClick(view);
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

    public void a(bd bdVar, boolean z) {
        if (bdVar != null && bdVar.zn() != null) {
            this.aZM = bdVar;
            MetaData zn = bdVar.zn();
            setContentDescription(zn.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(zn.getUserId());
            setUserName(zn.getUserName());
            setUrl(zn.getPortrait());
            if (bdVar.zG() != null && this.aZM.getThreadType() == 49) {
                startLoad(bdVar.zn().getPortrait(), 28, false);
            } else if (this.aZM.Ao() != null && this.aZM.Ao().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.aZM.Ao().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(zn.getPortrait()) && zn.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(zn.getPortrait(), 10, false);
            } else {
                startLoad(zn.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, zn);
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
