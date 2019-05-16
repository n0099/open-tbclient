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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bg VK;
    private View.OnClickListener bVi;
    private boolean bWu;
    protected com.baidu.tbadk.h.d bWv;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.bWv = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bVi = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.bWv == null || !ClickableHeaderImageView.this.bWv.aE(view)) && ClickableHeaderImageView.this.VK != null) {
                    MetaData adv = ClickableHeaderImageView.this.bWu ? ClickableHeaderImageView.this.VK.aeT().adv() : ClickableHeaderImageView.this.VK.adv();
                    if (adv != null && !StringUtils.isNull(adv.getName_show()) && !StringUtils.isNull(adv.getUserId())) {
                        long c = com.baidu.adp.lib.g.b.c(adv.getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.VK.aeF() != null && ClickableHeaderImageView.this.VK.aeF().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.VK.aeF().channelId, ClickableHeaderImageView.this.VK.aeF().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, adv.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.VK.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bVi != null) {
                            ClickableHeaderImageView.this.bVi.onClick(view);
                        }
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
                if ((ClickableHeaderImageView.this.bWv == null || !ClickableHeaderImageView.this.bWv.aE(view)) && ClickableHeaderImageView.this.VK != null) {
                    MetaData adv = ClickableHeaderImageView.this.bWu ? ClickableHeaderImageView.this.VK.aeT().adv() : ClickableHeaderImageView.this.VK.adv();
                    if (adv != null && !StringUtils.isNull(adv.getName_show()) && !StringUtils.isNull(adv.getUserId())) {
                        long c = com.baidu.adp.lib.g.b.c(adv.getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.VK.aeF() != null && ClickableHeaderImageView.this.VK.aeF().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.VK.aeF().channelId, ClickableHeaderImageView.this.VK.aeF().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, adv.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.VK.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bVi != null) {
                            ClickableHeaderImageView.this.bVi.onClick(view);
                        }
                    }
                }
            }
        };
        init();
    }

    public void init() {
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(R.drawable.icon_default_avatar100);
        setDefaultBgResource(com.baidu.tbadk.util.e.get());
    }

    public void setData(bg bgVar, boolean z, boolean z2) {
        MetaData adv;
        if (bgVar != null && bgVar.adv() != null) {
            this.VK = bgVar;
            this.bWu = z2;
            if (z2) {
                adv = bgVar.aeT().adv();
            } else {
                adv = bgVar.adv();
            }
            setContentDescription(adv.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(adv.getUserId());
            setUserName(adv.getUserName());
            setUrl(adv.getPortrait());
            if (bgVar.adO() != null && this.VK.getThreadType() == 49) {
                startLoad(bgVar.adv().getPortrait(), 28, false);
            } else if (this.VK.aeF() != null && this.VK.aeF().channelId > 0) {
                setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
                startLoad(this.VK.aeF().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(adv.getPortrait()) && adv.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(adv.getPortrait(), 10, false);
            } else {
                startLoad(adv.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, adv);
            }
        }
    }

    public void setData(bg bgVar, boolean z) {
        setData(bgVar, z, false);
    }

    public void setData(bg bgVar) {
        setData(bgVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bg bgVar = new bg();
            bgVar.a(metaData);
            setData(bgVar);
        }
    }
}
