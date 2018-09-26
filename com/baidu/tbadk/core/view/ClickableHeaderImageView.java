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
    private View.OnClickListener avZ;
    protected com.baidu.tbadk.f.b awS;
    private bb awf;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.awS = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.avZ = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.awS == null || !ClickableHeaderImageView.this.awS.F(view)) && ClickableHeaderImageView.this.awf != null && ClickableHeaderImageView.this.awf.wm() != null && !StringUtils.isNull(ClickableHeaderImageView.this.awf.wm().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.awf.wm().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.awf.wm().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.awf.xp() != null && ClickableHeaderImageView.this.awf.xp().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.awf.xp().channelId, ClickableHeaderImageView.this.awf.xp().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.awf.wm().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.awf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.avZ != null) {
                        ClickableHeaderImageView.this.avZ.onClick(view);
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
                if ((ClickableHeaderImageView.this.awS == null || !ClickableHeaderImageView.this.awS.F(view)) && ClickableHeaderImageView.this.awf != null && ClickableHeaderImageView.this.awf.wm() != null && !StringUtils.isNull(ClickableHeaderImageView.this.awf.wm().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.awf.wm().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.awf.wm().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.awf.xp() != null && ClickableHeaderImageView.this.awf.xp().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.awf.xp().channelId, ClickableHeaderImageView.this.awf.xp().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.awf.wm().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.awf.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.avZ != null) {
                        ClickableHeaderImageView.this.avZ.onClick(view);
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
        if (bbVar != null && bbVar.wm() != null) {
            this.awf = bbVar;
            MetaData wm = bbVar.wm();
            setContentDescription(wm.getName_show() + getContext().getString(e.j.somebodys_portrait));
            setUserId(wm.getUserId());
            setUserName(wm.getUserName());
            setUrl(wm.getPortrait());
            if (bbVar.wG() != null && this.awf.getThreadType() == 49) {
                startLoad(bbVar.wm().getPortrait(), 28, false);
            } else if (this.awf.xp() != null && this.awf.xp().channelId > 0) {
                setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
                startLoad(this.awf.xp().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(wm.getPortrait()) && wm.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(wm.getPortrait(), 10, false);
            } else {
                startLoad(wm.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, wm);
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
