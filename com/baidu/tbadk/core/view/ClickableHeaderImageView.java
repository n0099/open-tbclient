package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bh Fs;
    private View.OnClickListener clw;
    private boolean cmC;
    protected com.baidu.tbadk.h.d cmD;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.cmD = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.clw = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.cmD == null || !ClickableHeaderImageView.this.cmD.onClickEvent(view)) && ClickableHeaderImageView.this.Fs != null) {
                    MetaData aiE = ClickableHeaderImageView.this.cmC ? ClickableHeaderImageView.this.Fs.akb().aiE() : ClickableHeaderImageView.this.Fs.aiE();
                    if (aiE != null && !StringUtils.isNull(aiE.getName_show()) && !StringUtils.isNull(aiE.getUserId())) {
                        long j = com.baidu.adp.lib.g.b.toLong(aiE.getUserId(), 0L);
                        boolean z = j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.Fs.ajN() != null && ClickableHeaderImageView.this.Fs.ajN().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.Fs.ajN().channelId, ClickableHeaderImageView.this.Fs.ajN().Zv)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, z, aiE.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.Fs.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.clw != null) {
                            ClickableHeaderImageView.this.clw.onClick(view);
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
                if ((ClickableHeaderImageView.this.cmD == null || !ClickableHeaderImageView.this.cmD.onClickEvent(view)) && ClickableHeaderImageView.this.Fs != null) {
                    MetaData aiE = ClickableHeaderImageView.this.cmC ? ClickableHeaderImageView.this.Fs.akb().aiE() : ClickableHeaderImageView.this.Fs.aiE();
                    if (aiE != null && !StringUtils.isNull(aiE.getName_show()) && !StringUtils.isNull(aiE.getUserId())) {
                        long j = com.baidu.adp.lib.g.b.toLong(aiE.getUserId(), 0L);
                        boolean z = j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.Fs.ajN() != null && ClickableHeaderImageView.this.Fs.ajN().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.Fs.ajN().channelId, ClickableHeaderImageView.this.Fs.ajN().Zv)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, z, aiE.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.Fs.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.clw != null) {
                            ClickableHeaderImageView.this.clw.onClick(view);
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
        setDefaultErrorResource(R.drawable.icon_default_avatar100);
        setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
    }

    public void setData(bh bhVar, boolean z, boolean z2) {
        MetaData aiE;
        if (bhVar != null && bhVar.aiE() != null) {
            this.Fs = bhVar;
            this.cmC = z2;
            if (z2) {
                aiE = bhVar.akb().aiE();
            } else {
                aiE = bhVar.aiE();
            }
            setContentDescription(aiE.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aiE.getUserId());
            setUserName(aiE.getUserName());
            setUrl(aiE.getPortrait());
            if (bhVar.aiX() != null && this.Fs.getThreadType() == 49) {
                startLoad(bhVar.aiE().getPortrait(), 28, false);
            } else if (this.Fs.ajN() != null && this.Fs.ajN().channelId > 0) {
                setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
                startLoad(this.Fs.ajN().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(aiE.getPortrait()) && aiE.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(aiE.getPortrait(), 10, false);
            } else {
                startLoad(aiE.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, aiE);
            }
        }
    }

    public void setData(bh bhVar, boolean z) {
        setData(bhVar, z, false);
    }

    public void setData(bh bhVar) {
        setData(bhVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bh bhVar = new bh();
            bhVar.a(metaData);
            setData(bhVar);
        }
    }
}
