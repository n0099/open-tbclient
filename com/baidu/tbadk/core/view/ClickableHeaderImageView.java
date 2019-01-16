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
    private View.OnClickListener aFC;
    private bb aFI;
    protected com.baidu.tbadk.f.b aGu;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.aGu = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aFC = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.aGu == null || !ClickableHeaderImageView.this.aGu.F(view)) && ClickableHeaderImageView.this.aFI != null && ClickableHeaderImageView.this.aFI.zT() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aFI.zT().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aFI.zT().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aFI.zT().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aFI.AW() != null && ClickableHeaderImageView.this.aFI.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aFI.AW().channelId, ClickableHeaderImageView.this.aFI.AW().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aFI.zT().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aFI.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aFC != null) {
                        ClickableHeaderImageView.this.aFC.onClick(view);
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
                if ((ClickableHeaderImageView.this.aGu == null || !ClickableHeaderImageView.this.aGu.F(view)) && ClickableHeaderImageView.this.aFI != null && ClickableHeaderImageView.this.aFI.zT() != null && !StringUtils.isNull(ClickableHeaderImageView.this.aFI.zT().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.aFI.zT().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ClickableHeaderImageView.this.aFI.zT().getUserId(), 0L);
                    boolean z = d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.aFI.AW() != null && ClickableHeaderImageView.this.aFI.AW().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.aFI.AW().channelId, ClickableHeaderImageView.this.aFI.AW().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(d, z, ClickableHeaderImageView.this.aFI.zT().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aFI.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.aFC != null) {
                        ClickableHeaderImageView.this.aFC.onClick(view);
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
            this.aFI = bbVar;
            MetaData zT = bbVar.zT();
            setContentDescription(zT.getName_show() + getContext().getString(e.j.somebodys_portrait));
            setUserId(zT.getUserId());
            setUserName(zT.getUserName());
            setUrl(zT.getPortrait());
            if (bbVar.An() != null && this.aFI.getThreadType() == 49) {
                startLoad(bbVar.zT().getPortrait(), 28, false);
            } else if (this.aFI.AW() != null && this.aFI.AW().channelId > 0) {
                setDefaultErrorResource(e.f.avatar_channel_poto_defaul160);
                startLoad(this.aFI.AW().channelAvatar, 10, false);
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
