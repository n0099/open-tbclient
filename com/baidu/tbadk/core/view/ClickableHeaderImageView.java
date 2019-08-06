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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bh We;
    private View.OnClickListener bWq;
    private boolean bXD;
    protected com.baidu.tbadk.h.d bXE;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.bXE = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWq = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.bXE == null || !ClickableHeaderImageView.this.bXE.aG(view)) && ClickableHeaderImageView.this.We != null) {
                    MetaData aey = ClickableHeaderImageView.this.bXD ? ClickableHeaderImageView.this.We.afW().aey() : ClickableHeaderImageView.this.We.aey();
                    if (aey != null && !StringUtils.isNull(aey.getName_show()) && !StringUtils.isNull(aey.getUserId())) {
                        long c = com.baidu.adp.lib.g.b.c(aey.getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.We.afI() != null && ClickableHeaderImageView.this.We.afI().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.We.afI().channelId, ClickableHeaderImageView.this.We.afI().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, aey.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.We.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bWq != null) {
                            ClickableHeaderImageView.this.bWq.onClick(view);
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
                if ((ClickableHeaderImageView.this.bXE == null || !ClickableHeaderImageView.this.bXE.aG(view)) && ClickableHeaderImageView.this.We != null) {
                    MetaData aey = ClickableHeaderImageView.this.bXD ? ClickableHeaderImageView.this.We.afW().aey() : ClickableHeaderImageView.this.We.aey();
                    if (aey != null && !StringUtils.isNull(aey.getName_show()) && !StringUtils.isNull(aey.getUserId())) {
                        long c = com.baidu.adp.lib.g.b.c(aey.getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.We.afI() != null && ClickableHeaderImageView.this.We.afI().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.We.afI().channelId, ClickableHeaderImageView.this.We.afI().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, aey.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.We.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bWq != null) {
                            ClickableHeaderImageView.this.bWq.onClick(view);
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
        setDefaultBgResource(com.baidu.tbadk.util.e.Qr());
    }

    public void setData(bh bhVar, boolean z, boolean z2) {
        MetaData aey;
        if (bhVar != null && bhVar.aey() != null) {
            this.We = bhVar;
            this.bXD = z2;
            if (z2) {
                aey = bhVar.afW().aey();
            } else {
                aey = bhVar.aey();
            }
            setContentDescription(aey.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aey.getUserId());
            setUserName(aey.getUserName());
            setUrl(aey.getPortrait());
            if (bhVar.aeR() != null && this.We.getThreadType() == 49) {
                startLoad(bhVar.aey().getPortrait(), 28, false);
            } else if (this.We.afI() != null && this.We.afI().channelId > 0) {
                setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
                startLoad(this.We.afI().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(aey.getPortrait()) && aey.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(aey.getPortrait(), 10, false);
            } else {
                startLoad(aey.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, aey);
            }
        }
    }

    public void setData(bh bhVar, boolean z) {
        setData(bhVar, z, false);
    }

    public void setData(bh bhVar) {
        setData(bhVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bh bhVar = new bh();
            bhVar.a(metaData);
            setData(bhVar);
        }
    }
}
