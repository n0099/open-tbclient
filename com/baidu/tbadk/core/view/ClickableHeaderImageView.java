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
    private bg We;
    private View.OnClickListener bWk;
    private boolean bXx;
    protected com.baidu.tbadk.h.d bXy;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.bXy = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWk = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.bXy == null || !ClickableHeaderImageView.this.bXy.aG(view)) && ClickableHeaderImageView.this.We != null) {
                    MetaData aex = ClickableHeaderImageView.this.bXx ? ClickableHeaderImageView.this.We.afV().aex() : ClickableHeaderImageView.this.We.aex();
                    if (aex != null && !StringUtils.isNull(aex.getName_show()) && !StringUtils.isNull(aex.getUserId())) {
                        long c = com.baidu.adp.lib.g.b.c(aex.getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.We.afH() != null && ClickableHeaderImageView.this.We.afH().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.We.afH().channelId, ClickableHeaderImageView.this.We.afH().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, aex.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.We.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bWk != null) {
                            ClickableHeaderImageView.this.bWk.onClick(view);
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
                if ((ClickableHeaderImageView.this.bXy == null || !ClickableHeaderImageView.this.bXy.aG(view)) && ClickableHeaderImageView.this.We != null) {
                    MetaData aex = ClickableHeaderImageView.this.bXx ? ClickableHeaderImageView.this.We.afV().aex() : ClickableHeaderImageView.this.We.aex();
                    if (aex != null && !StringUtils.isNull(aex.getName_show()) && !StringUtils.isNull(aex.getUserId())) {
                        long c = com.baidu.adp.lib.g.b.c(aex.getUserId(), 0L);
                        boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.We.afH() != null && ClickableHeaderImageView.this.We.afH().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.We.afH().channelId, ClickableHeaderImageView.this.We.afH().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, aex.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.We.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bWk != null) {
                            ClickableHeaderImageView.this.bWk.onClick(view);
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

    public void setData(bg bgVar, boolean z, boolean z2) {
        MetaData aex;
        if (bgVar != null && bgVar.aex() != null) {
            this.We = bgVar;
            this.bXx = z2;
            if (z2) {
                aex = bgVar.afV().aex();
            } else {
                aex = bgVar.aex();
            }
            setContentDescription(aex.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aex.getUserId());
            setUserName(aex.getUserName());
            setUrl(aex.getPortrait());
            if (bgVar.aeQ() != null && this.We.getThreadType() == 49) {
                startLoad(bgVar.aex().getPortrait(), 28, false);
            } else if (this.We.afH() != null && this.We.afH().channelId > 0) {
                setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
                startLoad(this.We.afH().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(aex.getPortrait()) && aex.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(aex.getPortrait(), 10, false);
            } else {
                startLoad(aex.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, aex);
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
