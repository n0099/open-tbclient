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
    private bb aBF;
    private View.OnClickListener aBz;
    protected com.baidu.tbadk.f.b aCr;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aCr = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aBz = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aCr == null || !ClickableHeaderImageView.this.aCr.F(view)) && ClickableHeaderImageView.this.aBF != null && ClickableHeaderImageView.this.aBF.yC() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aBF.yC().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aBF.yC().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aBF.yC().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aBF.zF() != null && ClickableHeaderImageView.this.aBF.zF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aBF.zF().channelId, ClickableHeaderImageView.this.aBF.zF().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aBF.yC().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aBF.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aBz != null) {
                        ClickableHeaderImageView.this.aBz.onClick(view);
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
                if ((ClickableHeaderImageView.this.aCr == null || !ClickableHeaderImageView.this.aCr.F(view)) && ClickableHeaderImageView.this.aBF != null && ClickableHeaderImageView.this.aBF.yC() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aBF.yC().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aBF.yC().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aBF.yC().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aBF.zF() != null && ClickableHeaderImageView.this.aBF.zF().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aBF.zF().channelId, ClickableHeaderImageView.this.aBF.zF().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aBF.yC().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aBF.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aBz != null) {
                        ClickableHeaderImageView.this.aBz.onClick(view);
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
        if (bbVar != null && bbVar.yC() != null) {
            this.aBF = bbVar;
            MetaData yC = bbVar.yC();
            setContentDescription(yC.getName_show() + getContext().getString(e.j.somebodys_portrait));
            setUserId(yC.getUserId());
            setUserName(yC.getUserName());
            setUrl(yC.getPortrait());
            if (bbVar.yW() != null && this.aBF.getThreadType() == 49) {
                startLoad(bbVar.yC().getPortrait(), 28, false);
            } else if (this.aBF.zF() != null && this.aBF.zF().channelId > 0) {
                setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
                startLoad(this.aBF.zF().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(yC.getPortrait()) && yC.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(yC.getPortrait(), 10, false);
            } else {
                startLoad(yC.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, yC);
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
