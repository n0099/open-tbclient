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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.e;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private View.OnClickListener aEZ;
    protected com.baidu.tbadk.f.b aFR;
    private bb aFf;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aFR = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aEZ = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aFR == null || !ClickableHeaderImageView.this.aFR.F(view)) && ClickableHeaderImageView.this.aFf != null && ClickableHeaderImageView.this.aFf.zG() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aFf.zG().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aFf.zG().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aFf.zG().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aFf.AJ() != null && ClickableHeaderImageView.this.aFf.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aFf.AJ().channelId, ClickableHeaderImageView.this.aFf.AJ().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aFf.zG().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aFf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aEZ != null) {
                        ClickableHeaderImageView.this.aEZ.onClick(view);
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
                if ((ClickableHeaderImageView.this.aFR == null || !ClickableHeaderImageView.this.aFR.F(view)) && ClickableHeaderImageView.this.aFf != null && ClickableHeaderImageView.this.aFf.zG() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aFf.zG().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aFf.zG().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aFf.zG().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aFf.AJ() != null && ClickableHeaderImageView.this.aFf.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aFf.AJ().channelId, ClickableHeaderImageView.this.aFf.AJ().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aFf.zG().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aFf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aEZ != null) {
                        ClickableHeaderImageView.this.aEZ.onClick(view);
                    }
                }
            }
        };
        init();
    }

    public void init() {
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(e.f.icon_default_avatar100);
        setDefaultBgResource(e.d.cp_bg_line_e);
    }

    public void setData(bb bbVar, boolean z) {
        if (bbVar != null && bbVar.zG() != null) {
            this.aFf = bbVar;
            MetaData zG = bbVar.zG();
            setContentDescription(zG.getName_show() + getContext().getString(e.j.somebodys_portrait));
            setUserId(zG.getUserId());
            setUserName(zG.getUserName());
            setUrl(zG.getPortrait());
            if (bbVar.Aa() != null && this.aFf.getThreadType() == 49) {
                startLoad(bbVar.zG().getPortrait(), 28, false);
            } else if (this.aFf.AJ() != null && this.aFf.AJ().channelId > 0) {
                setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
                startLoad(this.aFf.AJ().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(zG.getPortrait()) && zG.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(zG.getPortrait(), 10, false);
            } else {
                startLoad(zG.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, zG);
            }
        }
    }

    public void setData(bb bbVar) {
        setData(bbVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bb bbVar = new bb();
            bbVar.a(metaData);
            setData(bbVar);
        }
    }
}
