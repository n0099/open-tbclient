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
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bg XT;
    private View.OnClickListener bNx;
    private boolean bOG;
    protected com.baidu.tbadk.h.b bOH;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.b bVar) {
        this.bOH = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNx = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.bOH == null || !ClickableHeaderImageView.this.bOH.ay(view)) && ClickableHeaderImageView.this.XT != null) {
                    MetaData YO = ClickableHeaderImageView.this.bOG ? ClickableHeaderImageView.this.XT.aam().YO() : ClickableHeaderImageView.this.XT.YO();
                    if (YO != null && !StringUtils.isNull(YO.getName_show()) && !StringUtils.isNull(YO.getUserId())) {
                        long d = com.baidu.adp.lib.g.b.d(YO.getUserId(), 0L);
                        boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.XT.ZY() != null && ClickableHeaderImageView.this.XT.ZY().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.XT.ZY().channelId, ClickableHeaderImageView.this.XT.ZY().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, YO.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.XT.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bNx != null) {
                            ClickableHeaderImageView.this.bNx.onClick(view);
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
                if ((ClickableHeaderImageView.this.bOH == null || !ClickableHeaderImageView.this.bOH.ay(view)) && ClickableHeaderImageView.this.XT != null) {
                    MetaData YO = ClickableHeaderImageView.this.bOG ? ClickableHeaderImageView.this.XT.aam().YO() : ClickableHeaderImageView.this.XT.YO();
                    if (YO != null && !StringUtils.isNull(YO.getName_show()) && !StringUtils.isNull(YO.getUserId())) {
                        long d = com.baidu.adp.lib.g.b.d(YO.getUserId(), 0L);
                        boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.XT.ZY() != null && ClickableHeaderImageView.this.XT.ZY().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.XT.ZY().channelId, ClickableHeaderImageView.this.XT.ZY().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, YO.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.XT.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bNx != null) {
                            ClickableHeaderImageView.this.bNx.onClick(view);
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
        setDefaultErrorResource(d.f.icon_default_avatar100);
        setDefaultBgResource(com.baidu.tbadk.util.e.get());
    }

    public void setData(bg bgVar, boolean z, boolean z2) {
        MetaData YO;
        if (bgVar != null && bgVar.YO() != null) {
            this.XT = bgVar;
            this.bOG = z2;
            if (z2) {
                YO = bgVar.aam().YO();
            } else {
                YO = bgVar.YO();
            }
            setContentDescription(YO.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(YO.getUserId());
            setUserName(YO.getUserName());
            setUrl(YO.getPortrait());
            if (bgVar.Zh() != null && this.XT.getThreadType() == 49) {
                startLoad(bgVar.YO().getPortrait(), 28, false);
            } else if (this.XT.ZY() != null && this.XT.ZY().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.XT.ZY().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(YO.getPortrait()) && YO.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(YO.getPortrait(), 10, false);
            } else {
                startLoad(YO.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, YO);
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
