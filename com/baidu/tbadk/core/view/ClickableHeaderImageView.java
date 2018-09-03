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
import com.baidu.tieba.f;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bb atE;
    private View.OnClickListener atF;
    protected com.baidu.tbadk.f.b atG;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.f.b bVar) {
        this.atG = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.atF = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.atG == null || !ClickableHeaderImageView.this.atG.v(view)) && ClickableHeaderImageView.this.atE != null && ClickableHeaderImageView.this.atE.vj() != null && !StringUtils.isNull(ClickableHeaderImageView.this.atE.vj().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.atE.vj().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.atE.vj().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.atE.wk() != null && ClickableHeaderImageView.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.atE.wk().channelId, ClickableHeaderImageView.this.atE.wk().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.atE.vj().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.atE.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.atF != null) {
                        ClickableHeaderImageView.this.atF.onClick(view);
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
                if ((ClickableHeaderImageView.this.atG == null || !ClickableHeaderImageView.this.atG.v(view)) && ClickableHeaderImageView.this.atE != null && ClickableHeaderImageView.this.atE.vj() != null && !StringUtils.isNull(ClickableHeaderImageView.this.atE.vj().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.atE.vj().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.atE.vj().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.atE.wk() != null && ClickableHeaderImageView.this.atE.wk().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.atE.wk().channelId, ClickableHeaderImageView.this.atE.wk().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.atE.vj().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.atE.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.atF != null) {
                        ClickableHeaderImageView.this.atF.onClick(view);
                    }
                }
            }
        };
        init();
    }

    public void init() {
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        setDefaultBgResource(f.d.cp_bg_line_e);
    }

    public void setData(bb bbVar, boolean z) {
        if (bbVar != null && bbVar.vj() != null) {
            this.atE = bbVar;
            MetaData vj = bbVar.vj();
            setContentDescription(vj.getName_show() + getContext().getString(f.j.somebodys_portrait));
            setUserId(vj.getUserId());
            setUserName(vj.getUserName());
            setUrl(vj.getPortrait());
            if (bbVar.vC() != null && this.atE.getThreadType() == 49) {
                startLoad(bbVar.vj().getPortrait(), 28, false);
            } else if (this.atE.wk() != null && this.atE.wk().channelId > 0) {
                setDefaultErrorResource(f.C0146f.avatar_channel_poto_defaul160);
                startLoad(this.atE.wk().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(vj.getPortrait()) && vj.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(vj.getPortrait(), 10, false);
            } else {
                startLoad(vj.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, vj);
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
