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
    protected com.baidu.tbadk.f.b aFS;
    private View.OnClickListener aFa;
    private bb aFg;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aFS = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aFa = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aFS == null || !ClickableHeaderImageView.this.aFS.F(view)) && ClickableHeaderImageView.this.aFg != null && ClickableHeaderImageView.this.aFg.zG() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aFg.zG().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aFg.zG().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aFg.zG().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aFg.AJ() != null && ClickableHeaderImageView.this.aFg.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aFg.AJ().channelId, ClickableHeaderImageView.this.aFg.AJ().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aFg.zG().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aFg.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aFa != null) {
                        ClickableHeaderImageView.this.aFa.onClick(view);
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
                if ((ClickableHeaderImageView.this.aFS == null || !ClickableHeaderImageView.this.aFS.F(view)) && ClickableHeaderImageView.this.aFg != null && ClickableHeaderImageView.this.aFg.zG() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aFg.zG().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aFg.zG().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aFg.zG().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aFg.AJ() != null && ClickableHeaderImageView.this.aFg.AJ().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aFg.AJ().channelId, ClickableHeaderImageView.this.aFg.AJ().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aFg.zG().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aFg.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aFa != null) {
                        ClickableHeaderImageView.this.aFa.onClick(view);
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
            this.aFg = bbVar;
            MetaData zG = bbVar.zG();
            setContentDescription(zG.getName_show() + getContext().getString(e.j.somebodys_portrait));
            setUserId(zG.getUserId());
            setUserName(zG.getUserName());
            setUrl(zG.getPortrait());
            if (bbVar.Aa() != null && this.aFg.getThreadType() == 49) {
                startLoad(bbVar.zG().getPortrait(), 28, false);
            } else if (this.aFg.AJ() != null && this.aFg.AJ().channelId > 0) {
                setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
                startLoad(this.aFg.AJ().channelAvatar, 10, false);
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
