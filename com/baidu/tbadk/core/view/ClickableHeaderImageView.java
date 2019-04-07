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
    private bg XS;
    private View.OnClickListener bNw;
    private boolean bOF;
    protected com.baidu.tbadk.h.b bOG;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.b bVar) {
        this.bOG = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNw = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.bOG == null || !ClickableHeaderImageView.this.bOG.ay(view)) && ClickableHeaderImageView.this.XS != null) {
                    MetaData YO = ClickableHeaderImageView.this.bOF ? ClickableHeaderImageView.this.XS.aam().YO() : ClickableHeaderImageView.this.XS.YO();
                    if (YO != null && !StringUtils.isNull(YO.getName_show()) && !StringUtils.isNull(YO.getUserId())) {
                        long d = com.baidu.adp.lib.g.b.d(YO.getUserId(), 0L);
                        boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.XS.ZY() != null && ClickableHeaderImageView.this.XS.ZY().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.XS.ZY().channelId, ClickableHeaderImageView.this.XS.ZY().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, YO.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.XS.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bNw != null) {
                            ClickableHeaderImageView.this.bNw.onClick(view);
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
                if ((ClickableHeaderImageView.this.bOG == null || !ClickableHeaderImageView.this.bOG.ay(view)) && ClickableHeaderImageView.this.XS != null) {
                    MetaData YO = ClickableHeaderImageView.this.bOF ? ClickableHeaderImageView.this.XS.aam().YO() : ClickableHeaderImageView.this.XS.YO();
                    if (YO != null && !StringUtils.isNull(YO.getName_show()) && !StringUtils.isNull(YO.getUserId())) {
                        long d = com.baidu.adp.lib.g.b.d(YO.getUserId(), 0L);
                        boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.XS.ZY() != null && ClickableHeaderImageView.this.XS.ZY().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.XS.ZY().channelId, ClickableHeaderImageView.this.XS.ZY().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, YO.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.XS.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bNw != null) {
                            ClickableHeaderImageView.this.bNw.onClick(view);
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
            this.XS = bgVar;
            this.bOF = z2;
            if (z2) {
                YO = bgVar.aam().YO();
            } else {
                YO = bgVar.YO();
            }
            setContentDescription(YO.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(YO.getUserId());
            setUserName(YO.getUserName());
            setUrl(YO.getPortrait());
            if (bgVar.Zh() != null && this.XS.getThreadType() == 49) {
                startLoad(bgVar.YO().getPortrait(), 28, false);
            } else if (this.XS.ZY() != null && this.XS.ZY().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.XS.ZY().channelAvatar, 10, false);
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
