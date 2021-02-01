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
    private cb ahi;
    private View.OnClickListener ajT;
    private boolean ffc;
    protected com.baidu.tbadk.h.d ffd;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.ffd = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.ffd == null || !ClickableHeaderImageView.this.ffd.onClickEvent(view)) && ClickableHeaderImageView.this.ahi != null) {
                    MetaData bnQ = ClickableHeaderImageView.this.ffc ? ClickableHeaderImageView.this.ahi.bpv().bnQ() : ClickableHeaderImageView.this.ahi.bnQ();
                    if (bnQ != null && !StringUtils.isNull(bnQ.getName_show()) && !StringUtils.isNull(bnQ.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bnQ.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bnQ.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.ahi.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.ahi.bmo());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ajT != null) {
                            ClickableHeaderImageView.this.ajT.onClick(view);
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
                if ((ClickableHeaderImageView.this.ffd == null || !ClickableHeaderImageView.this.ffd.onClickEvent(view)) && ClickableHeaderImageView.this.ahi != null) {
                    MetaData bnQ = ClickableHeaderImageView.this.ffc ? ClickableHeaderImageView.this.ahi.bpv().bnQ() : ClickableHeaderImageView.this.ahi.bnQ();
                    if (bnQ != null && !StringUtils.isNull(bnQ.getName_show()) && !StringUtils.isNull(bnQ.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bnQ.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bnQ.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.ahi.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.ahi.bmo());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ajT != null) {
                            ClickableHeaderImageView.this.ajT.onClick(view);
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
        MetaData bnQ;
        if (cbVar != null && cbVar.bnQ() != null) {
            this.ahi = cbVar;
            this.ffc = z2;
            if (z2) {
                bnQ = cbVar.bpv().bnQ();
            } else {
                bnQ = cbVar.bnQ();
            }
            setContentDescription(bnQ.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(bnQ.getUserId());
            setUserName(bnQ.getUserName());
            if (cbVar.boj() != null && this.ahi.getThreadType() == 49) {
                setUrl(cbVar.bnQ().getAvater());
                startLoad(cbVar.bnQ().getAvater(), 28, false);
            } else {
                setUrl(bnQ.getAvater());
                if (!StringUtils.isNull(bnQ.getAvater()) && bnQ.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(bnQ.getAvater(), 10, false);
                } else {
                    startLoad(bnQ.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, bnQ);
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
