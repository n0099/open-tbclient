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
    private bh FT;
    private View.OnClickListener cmo;
    private boolean cnu;
    protected com.baidu.tbadk.h.d cnv;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.cnv = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.cmo = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.cnv == null || !ClickableHeaderImageView.this.cnv.onClickEvent(view)) && ClickableHeaderImageView.this.FT != null) {
                    MetaData aiG = ClickableHeaderImageView.this.cnu ? ClickableHeaderImageView.this.FT.akd().aiG() : ClickableHeaderImageView.this.FT.aiG();
                    if (aiG != null && !StringUtils.isNull(aiG.getName_show()) && !StringUtils.isNull(aiG.getUserId())) {
                        long j = com.baidu.adp.lib.g.b.toLong(aiG.getUserId(), 0L);
                        boolean z = j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.FT.ajP() != null && ClickableHeaderImageView.this.FT.ajP().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.FT.ajP().channelId, ClickableHeaderImageView.this.FT.ajP().ZN)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, z, aiG.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.FT.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.cmo != null) {
                            ClickableHeaderImageView.this.cmo.onClick(view);
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
                if ((ClickableHeaderImageView.this.cnv == null || !ClickableHeaderImageView.this.cnv.onClickEvent(view)) && ClickableHeaderImageView.this.FT != null) {
                    MetaData aiG = ClickableHeaderImageView.this.cnu ? ClickableHeaderImageView.this.FT.akd().aiG() : ClickableHeaderImageView.this.FT.aiG();
                    if (aiG != null && !StringUtils.isNull(aiG.getName_show()) && !StringUtils.isNull(aiG.getUserId())) {
                        long j = com.baidu.adp.lib.g.b.toLong(aiG.getUserId(), 0L);
                        boolean z = j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.FT.ajP() != null && ClickableHeaderImageView.this.FT.ajP().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.FT.ajP().channelId, ClickableHeaderImageView.this.FT.ajP().ZN)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, z, aiG.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.FT.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.cmo != null) {
                            ClickableHeaderImageView.this.cmo.onClick(view);
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
        setDefaultBgResource(com.baidu.tbadk.util.e.Vl());
    }

    public void setData(bh bhVar, boolean z, boolean z2) {
        MetaData aiG;
        if (bhVar != null && bhVar.aiG() != null) {
            this.FT = bhVar;
            this.cnu = z2;
            if (z2) {
                aiG = bhVar.akd().aiG();
            } else {
                aiG = bhVar.aiG();
            }
            setContentDescription(aiG.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aiG.getUserId());
            setUserName(aiG.getUserName());
            setUrl(aiG.getPortrait());
            if (bhVar.aiZ() != null && this.FT.getThreadType() == 49) {
                startLoad(bhVar.aiG().getPortrait(), 28, false);
            } else if (this.FT.ajP() != null && this.FT.ajP().channelId > 0) {
                setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
                startLoad(this.FT.ajP().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(aiG.getPortrait()) && aiG.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(aiG.getPortrait(), 10, false);
            } else {
                startLoad(aiG.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, aiG);
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
