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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private cb aiB;
    private View.OnClickListener alm;
    private boolean fgB;
    protected com.baidu.tbadk.h.d fgC;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.fgC = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.fgC == null || !ClickableHeaderImageView.this.fgC.onClickEvent(view)) && ClickableHeaderImageView.this.aiB != null) {
                    MetaData bnS = ClickableHeaderImageView.this.fgB ? ClickableHeaderImageView.this.aiB.bpx().bnS() : ClickableHeaderImageView.this.aiB.bnS();
                    if (bnS != null && !StringUtils.isNull(bnS.getName_show()) && !StringUtils.isNull(bnS.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bnS.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bnS.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aiB.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.aiB.bmq());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.alm != null) {
                            ClickableHeaderImageView.this.alm.onClick(view);
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
                if ((ClickableHeaderImageView.this.fgC == null || !ClickableHeaderImageView.this.fgC.onClickEvent(view)) && ClickableHeaderImageView.this.aiB != null) {
                    MetaData bnS = ClickableHeaderImageView.this.fgB ? ClickableHeaderImageView.this.aiB.bpx().bnS() : ClickableHeaderImageView.this.aiB.bnS();
                    if (bnS != null && !StringUtils.isNull(bnS.getName_show()) && !StringUtils.isNull(bnS.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bnS.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bnS.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aiB.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.aiB.bmq());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.alm != null) {
                            ClickableHeaderImageView.this.alm.onClick(view);
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

    public void setData(cb cbVar, boolean z, boolean z2) {
        MetaData bnS;
        if (cbVar != null && cbVar.bnS() != null) {
            this.aiB = cbVar;
            this.fgB = z2;
            if (z2) {
                bnS = cbVar.bpx().bnS();
            } else {
                bnS = cbVar.bnS();
            }
            setContentDescription(bnS.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(bnS.getUserId());
            setUserName(bnS.getUserName());
            if (cbVar.bol() != null && this.aiB.getThreadType() == 49) {
                setUrl(cbVar.bnS().getAvater());
                startLoad(cbVar.bnS().getAvater(), 28, false);
            } else {
                setUrl(bnS.getAvater());
                if (!StringUtils.isNull(bnS.getAvater()) && bnS.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(bnS.getAvater(), 10, false);
                } else {
                    startLoad(bnS.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, bnS);
        }
    }

    public void setData(cb cbVar, boolean z) {
        setData(cbVar, z, false);
    }

    public void setData(cb cbVar) {
        setData(cbVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            cb cbVar = new cb();
            cbVar.a(metaData);
            setData(cbVar);
        }
    }
}
