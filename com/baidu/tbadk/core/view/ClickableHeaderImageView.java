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
    private View.OnClickListener bNu;
    private boolean bOD;
    protected com.baidu.tbadk.h.b bOE;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.b bVar) {
        this.bOE = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNu = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.bOE == null || !ClickableHeaderImageView.this.bOE.ay(view)) && ClickableHeaderImageView.this.XS != null) {
                    MetaData YR = ClickableHeaderImageView.this.bOD ? ClickableHeaderImageView.this.XS.aap().YR() : ClickableHeaderImageView.this.XS.YR();
                    if (YR != null && !StringUtils.isNull(YR.getName_show()) && !StringUtils.isNull(YR.getUserId())) {
                        long d = com.baidu.adp.lib.g.b.d(YR.getUserId(), 0L);
                        boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.XS.aab() != null && ClickableHeaderImageView.this.XS.aab().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.XS.aab().channelId, ClickableHeaderImageView.this.XS.aab().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, YR.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.XS.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bNu != null) {
                            ClickableHeaderImageView.this.bNu.onClick(view);
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
                if ((ClickableHeaderImageView.this.bOE == null || !ClickableHeaderImageView.this.bOE.ay(view)) && ClickableHeaderImageView.this.XS != null) {
                    MetaData YR = ClickableHeaderImageView.this.bOD ? ClickableHeaderImageView.this.XS.aap().YR() : ClickableHeaderImageView.this.XS.YR();
                    if (YR != null && !StringUtils.isNull(YR.getName_show()) && !StringUtils.isNull(YR.getUserId())) {
                        long d = com.baidu.adp.lib.g.b.d(YR.getUserId(), 0L);
                        boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.XS.aab() != null && ClickableHeaderImageView.this.XS.aab().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.XS.aab().channelId, ClickableHeaderImageView.this.XS.aab().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, YR.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.XS.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bNu != null) {
                            ClickableHeaderImageView.this.bNu.onClick(view);
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
        MetaData YR;
        if (bgVar != null && bgVar.YR() != null) {
            this.XS = bgVar;
            this.bOD = z2;
            if (z2) {
                YR = bgVar.aap().YR();
            } else {
                YR = bgVar.YR();
            }
            setContentDescription(YR.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(YR.getUserId());
            setUserName(YR.getUserName());
            setUrl(YR.getPortrait());
            if (bgVar.Zk() != null && this.XS.getThreadType() == 49) {
                startLoad(bgVar.YR().getPortrait(), 28, false);
            } else if (this.XS.aab() != null && this.XS.aab().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.XS.aab().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(YR.getPortrait()) && YR.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(YR.getPortrait(), 10, false);
            } else {
                startLoad(YR.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, YR);
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
