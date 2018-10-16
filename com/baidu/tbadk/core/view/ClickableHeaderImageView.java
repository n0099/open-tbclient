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
    private View.OnClickListener aAK;
    private bb aAQ;
    protected com.baidu.tbadk.f.b aBC;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aBC = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aAK = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aBC == null || !ClickableHeaderImageView.this.aBC.F(view)) && ClickableHeaderImageView.this.aAQ != null && ClickableHeaderImageView.this.aAQ.yv() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aAQ.yv().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aAQ.yv().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aAQ.yv().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aAQ.zy() != null && ClickableHeaderImageView.this.aAQ.zy().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aAQ.zy().channelId, ClickableHeaderImageView.this.aAQ.zy().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aAQ.yv().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aAQ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aAK != null) {
                        ClickableHeaderImageView.this.aAK.onClick(view);
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
                if ((ClickableHeaderImageView.this.aBC == null || !ClickableHeaderImageView.this.aBC.F(view)) && ClickableHeaderImageView.this.aAQ != null && ClickableHeaderImageView.this.aAQ.yv() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aAQ.yv().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aAQ.yv().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aAQ.yv().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aAQ.zy() != null && ClickableHeaderImageView.this.aAQ.zy().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aAQ.zy().channelId, ClickableHeaderImageView.this.aAQ.zy().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aAQ.yv().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aAQ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aAK != null) {
                        ClickableHeaderImageView.this.aAK.onClick(view);
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
        if (bbVar != null && bbVar.yv() != null) {
            this.aAQ = bbVar;
            MetaData yv = bbVar.yv();
            setContentDescription(yv.getName_show() + getContext().getString(e.j.somebodys_portrait));
            setUserId(yv.getUserId());
            setUserName(yv.getUserName());
            setUrl(yv.getPortrait());
            if (bbVar.yP() != null && this.aAQ.getThreadType() == 49) {
                startLoad(bbVar.yv().getPortrait(), 28, false);
            } else if (this.aAQ.zy() != null && this.aAQ.zy().channelId > 0) {
                setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
                startLoad(this.aAQ.zy().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(yv.getPortrait()) && yv.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(yv.getPortrait(), 10, false);
            } else {
                startLoad(yv.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, yv);
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
