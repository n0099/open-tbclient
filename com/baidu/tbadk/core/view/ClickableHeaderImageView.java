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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bh Wd;
    private View.OnClickListener bXj;
    private boolean bYw;
    protected com.baidu.tbadk.h.d bYx;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.bYx = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bXj = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.bYx == null || !ClickableHeaderImageView.this.bYx.aG(view)) && ClickableHeaderImageView.this.Wd != null) {
                    MetaData aeC = ClickableHeaderImageView.this.bYw ? ClickableHeaderImageView.this.Wd.aga().aeC() : ClickableHeaderImageView.this.Wd.aeC();
                    if (aeC != null && !StringUtils.isNull(aeC.getName_show()) && !StringUtils.isNull(aeC.getUserId())) {
                        long e = com.baidu.adp.lib.g.b.e(aeC.getUserId(), 0L);
                        boolean z = e == com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.Wd.afM() != null && ClickableHeaderImageView.this.Wd.afM().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.Wd.afM().channelId, ClickableHeaderImageView.this.Wd.afM().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(e, z, aeC.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.Wd.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bXj != null) {
                            ClickableHeaderImageView.this.bXj.onClick(view);
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
                if ((ClickableHeaderImageView.this.bYx == null || !ClickableHeaderImageView.this.bYx.aG(view)) && ClickableHeaderImageView.this.Wd != null) {
                    MetaData aeC = ClickableHeaderImageView.this.bYw ? ClickableHeaderImageView.this.Wd.aga().aeC() : ClickableHeaderImageView.this.Wd.aeC();
                    if (aeC != null && !StringUtils.isNull(aeC.getName_show()) && !StringUtils.isNull(aeC.getUserId())) {
                        long e = com.baidu.adp.lib.g.b.e(aeC.getUserId(), 0L);
                        boolean z = e == com.baidu.adp.lib.g.b.e(TbadkCoreApplication.getCurrentAccount(), 0L);
                        if (ClickableHeaderImageView.this.Wd.afM() != null && ClickableHeaderImageView.this.Wd.afM().channelId > 0) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(ClickableHeaderImageView.this.getContext(), ClickableHeaderImageView.this.Wd.afM().channelId, ClickableHeaderImageView.this.Wd.afM().mCurrentPage)));
                        } else {
                            PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(e, z, aeC.isBigV());
                            createNormalConfig.setSourceTid(ClickableHeaderImageView.this.Wd.getTid());
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                        }
                        if (ClickableHeaderImageView.this.bXj != null) {
                            ClickableHeaderImageView.this.bXj.onClick(view);
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
        setDefaultBgResource(com.baidu.tbadk.util.e.Qv());
    }

    public void setData(bh bhVar, boolean z, boolean z2) {
        MetaData aeC;
        if (bhVar != null && bhVar.aeC() != null) {
            this.Wd = bhVar;
            this.bYw = z2;
            if (z2) {
                aeC = bhVar.aga().aeC();
            } else {
                aeC = bhVar.aeC();
            }
            setContentDescription(aeC.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aeC.getUserId());
            setUserName(aeC.getUserName());
            setUrl(aeC.getPortrait());
            if (bhVar.aeV() != null && this.Wd.getThreadType() == 49) {
                startLoad(bhVar.aeC().getPortrait(), 28, false);
            } else if (this.Wd.afM() != null && this.Wd.afM().channelId > 0) {
                setDefaultErrorResource(R.drawable.avatar_channel_poto_defaul160);
                startLoad(this.Wd.afM().channelAvatar, 10, false);
            } else if (!StringUtils.isNull(aeC.getPortrait()) && aeC.getPortrait().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                startLoad(aeC.getPortrait(), 10, false);
            } else {
                startLoad(aeC.getPortrait(), 28, false);
            }
            if (z) {
                UtilHelper.showHeadImageViewBigV(this, aeC);
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
