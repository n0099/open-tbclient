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
    private View.OnClickListener aFD;
    private bb aFJ;
    protected com.baidu.tbadk.f.b aGv;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aGv = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aFD = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aGv == null || !ClickableHeaderImageView.this.aGv.F(view)) && ClickableHeaderImageView.this.aFJ != null && ClickableHeaderImageView.this.aFJ.zT() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aFJ.zT().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aFJ.zT().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aFJ.zT().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aFJ.AW() != null && ClickableHeaderImageView.this.aFJ.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aFJ.AW().channelId, ClickableHeaderImageView.this.aFJ.AW().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aFJ.zT().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aFJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aFD != null) {
                        ClickableHeaderImageView.this.aFD.onClick(view);
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
                if ((ClickableHeaderImageView.this.aGv == null || !ClickableHeaderImageView.this.aGv.F(view)) && ClickableHeaderImageView.this.aFJ != null && ClickableHeaderImageView.this.aFJ.zT() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aFJ.zT().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aFJ.zT().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aFJ.zT().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aFJ.AW() != null && ClickableHeaderImageView.this.aFJ.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aFJ.AW().channelId, ClickableHeaderImageView.this.aFJ.AW().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aFJ.zT().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aFJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aFD != null) {
                        ClickableHeaderImageView.this.aFD.onClick(view);
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
        if (bbVar != null && bbVar.zT() != null) {
            this.aFJ = bbVar;
            MetaData zT = bbVar.zT();
            setContentDescription(zT.getName_show() + getContext().getString(e.j.somebodys_portrait));
            setUserId(zT.getUserId());
            setUserName(zT.getUserName());
            setUrl(zT.getPortrait());
            if (bbVar.An() != null && this.aFJ.getThreadType() == 49) {
                startLoad(bbVar.zT().getPortrait(), 28, false);
            } else if (this.aFJ.AW() != null && this.aFJ.AW().channelId > 0) {
                setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
                startLoad(this.aFJ.AW().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(zT.getPortrait()) && zT.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(zT.getPortrait(), 10, false);
            } else {
                startLoad(zT.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, zT);
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
