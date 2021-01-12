package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bz ahu;
    private View.OnClickListener ake;
    private boolean fcN;
    protected com.baidu.tbadk.h.d fcO;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.fcO = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ake = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.fcO == null || !ClickableHeaderImageView.this.fcO.onClickEvent(view)) && ClickableHeaderImageView.this.ahu != null) {
                    MetaData bnx = ClickableHeaderImageView.this.fcN ? ClickableHeaderImageView.this.ahu.bpd().bnx() : ClickableHeaderImageView.this.ahu.bnx();
                    if (bnx != null && !StringUtils.isNull(bnx.getName_show()) && !StringUtils.isNull(bnx.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bnx.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bnx.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.ahu.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.ahu.blV());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ake != null) {
                            ClickableHeaderImageView.this.ake.onClick(view);
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
                if ((ClickableHeaderImageView.this.fcO == null || !ClickableHeaderImageView.this.fcO.onClickEvent(view)) && ClickableHeaderImageView.this.ahu != null) {
                    MetaData bnx = ClickableHeaderImageView.this.fcN ? ClickableHeaderImageView.this.ahu.bpd().bnx() : ClickableHeaderImageView.this.ahu.bnx();
                    if (bnx != null && !StringUtils.isNull(bnx.getName_show()) && !StringUtils.isNull(bnx.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bnx.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bnx.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.ahu.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.ahu.blV());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ake != null) {
                            ClickableHeaderImageView.this.ake.onClick(view);
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
        setPlaceHolder(1);
    }

    public void setData(bz bzVar, boolean z, boolean z2) {
        MetaData bnx;
        if (bzVar != null && bzVar.bnx() != null) {
            this.ahu = bzVar;
            this.fcN = z2;
            if (z2) {
                bnx = bzVar.bpd().bnx();
            } else {
                bnx = bzVar.bnx();
            }
            setContentDescription(bnx.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(bnx.getUserId());
            setUserName(bnx.getUserName());
            if (bzVar.bnQ() != null && this.ahu.getThreadType() == 49) {
                setUrl(bzVar.bnx().getAvater());
                startLoad(bzVar.bnx().getAvater(), 28, false);
            } else {
                setUrl(bnx.getAvater());
                if (!StringUtils.isNull(bnx.getAvater()) && bnx.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(bnx.getAvater(), 10, false);
                } else {
                    startLoad(bnx.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, bnx);
        }
    }

    public void setData(bz bzVar, boolean z) {
        setData(bzVar, z, false);
    }

    public void setData(bz bzVar) {
        setData(bzVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bz bzVar = new bz();
            bzVar.a(metaData);
            setData(bzVar);
        }
    }
}
