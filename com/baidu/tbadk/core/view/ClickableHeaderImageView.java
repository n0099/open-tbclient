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
    private bg XR;
    private View.OnClickListener bNt;
    private boolean bOC;
    protected com.baidu.tbadk.h.b bOD;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.b bVar) {
        this.bOD = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNt = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.bOD == null || !ClickableHeaderImageView.this.bOD.ay(view)) && ClickableHeaderImageView.this.XR != null) {
                    MetaData YR = ClickableHeaderImageView.this.bOC ? ClickableHeaderImageView.this.XR.aap().YR() : ClickableHeaderImageView.this.XR.YR();
                    if (YR != null && !StringUtils.isNull(YR.getName_show()) && !StringUtils.isNull(YR.getUserId())) {
                        long d = com.baidu.adp.lib.g.b.d(YR.getUserId(), 0L);
                        boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.XR.aab() != null && ClickableHeaderImageView.this.XR.aab().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.XR.aab().channelId, ClickableHeaderImageView.this.XR.aab().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, YR.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.XR.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bNt != null) {
                            ClickableHeaderImageView.this.bNt.onClick(view);
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
                if ((ClickableHeaderImageView.this.bOD == null || !ClickableHeaderImageView.this.bOD.ay(view)) && ClickableHeaderImageView.this.XR != null) {
                    MetaData YR = ClickableHeaderImageView.this.bOC ? ClickableHeaderImageView.this.XR.aap().YR() : ClickableHeaderImageView.this.XR.YR();
                    if (YR != null && !StringUtils.isNull(YR.getName_show()) && !StringUtils.isNull(YR.getUserId())) {
                        long d = com.baidu.adp.lib.g.b.d(YR.getUserId(), 0L);
                        boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.XR.aab() != null && ClickableHeaderImageView.this.XR.aab().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.XR.aab().channelId, ClickableHeaderImageView.this.XR.aab().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, YR.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.XR.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bNt != null) {
                            ClickableHeaderImageView.this.bNt.onClick(view);
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
            this.XR = bgVar;
            this.bOC = z2;
            if (z2) {
                YR = bgVar.aap().YR();
            } else {
                YR = bgVar.YR();
            }
            setContentDescription(YR.getName_show() + getContext().getString(d.j.somebodys_portrait));
            setUserId(YR.getUserId());
            setUserName(YR.getUserName());
            setUrl(YR.getPortrait());
            if (bgVar.Zk() != null && this.XR.getThreadType() == 49) {
                startLoad(bgVar.YR().getPortrait(), 28, false);
            } else if (this.XR.aab() != null && this.XR.aab().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.XR.aab().channelAvatar, 10, false);
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
