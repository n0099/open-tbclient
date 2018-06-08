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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.d;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bd atn;
    private View.OnClickListener ato;
    protected com.baidu.tbadk.e.b atp;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.e.b bVar) {
        this.atp = bVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ato = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.atp == null || !ClickableHeaderImageView.this.atp.v(view)) && ClickableHeaderImageView.this.atn != null && ClickableHeaderImageView.this.atn.vm() != null && !StringUtils.isNull(ClickableHeaderImageView.this.atn.vm().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.atn.vm().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.atn.vm().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.atn.wm() != null && ClickableHeaderImageView.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.atn.wm().channelId, ClickableHeaderImageView.this.atn.wm().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.atn.vm().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.atn.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.ato != null) {
                        ClickableHeaderImageView.this.ato.onClick(view);
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
                if ((ClickableHeaderImageView.this.atp == null || !ClickableHeaderImageView.this.atp.v(view)) && ClickableHeaderImageView.this.atn != null && ClickableHeaderImageView.this.atn.vm() != null && !StringUtils.isNull(ClickableHeaderImageView.this.atn.vm().getName_show()) && !StringUtils.isNull(ClickableHeaderImageView.this.atn.vm().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ClickableHeaderImageView.this.atn.vm().getUserId(), 0L);
                    boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (ClickableHeaderImageView.this.atn.wm() != null && ClickableHeaderImageView.this.atn.wm().channelId > 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.atn.wm().channelId, ClickableHeaderImageView.this.atn.wm().mCurrentPage)));
                    } else {
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(c, z, ClickableHeaderImageView.this.atn.vm().isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.atn.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    }
                    if (ClickableHeaderImageView.this.ato != null) {
                        ClickableHeaderImageView.this.ato.onClick(view);
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
        setDefaultBgResource(d.C0141d.cp_bg_line_e);
    }

    public void setData(bd bdVar, boolean z) {
        if (bdVar != null && bdVar.vm() != null) {
            this.atn = bdVar;
            MetaData vm = bdVar.vm();
            setContentDescription(vm.getName_show() + getContext().getString(d.k.somebodys_portrait));
            setUserId(vm.getUserId());
            setUserName(vm.getUserName());
            setUrl(vm.getPortrait());
            if (bdVar.vE() != null && this.atn.getThreadType() == 49) {
                startLoad(bdVar.vm().getPortrait(), 28, false);
            } else if (this.atn.wm() != null && this.atn.wm().channelId > 0) {
                setDefaultErrorResource(d.f.avatar_channel_poto_defaul160);
                startLoad(this.atn.wm().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(vm.getPortrait()) && vm.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(vm.getPortrait(), 10, false);
            } else {
                startLoad(vm.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, vm);
            }
        }
    }

    public void setData(bd bdVar) {
        setData(bdVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bd bdVar = new bd();
            bdVar.a(metaData);
            setData(bdVar);
        }
    }
}
