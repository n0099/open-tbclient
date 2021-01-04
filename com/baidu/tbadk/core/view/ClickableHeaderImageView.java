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
    private bz aim;
    private View.OnClickListener akV;
    private boolean fhv;
    protected com.baidu.tbadk.h.d fhw;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.fhw = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akV = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.fhw == null || !ClickableHeaderImageView.this.fhw.onClickEvent(view)) && ClickableHeaderImageView.this.aim != null) {
                    MetaData brq = ClickableHeaderImageView.this.fhv ? ClickableHeaderImageView.this.aim.bsW().brq() : ClickableHeaderImageView.this.aim.brq();
                    if (brq != null && !StringUtils.isNull(brq.getName_show()) && !StringUtils.isNull(brq.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(brq.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), brq.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aim.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.aim.bpO());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.akV != null) {
                            ClickableHeaderImageView.this.akV.onClick(view);
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
                if ((ClickableHeaderImageView.this.fhw == null || !ClickableHeaderImageView.this.fhw.onClickEvent(view)) && ClickableHeaderImageView.this.aim != null) {
                    MetaData brq = ClickableHeaderImageView.this.fhv ? ClickableHeaderImageView.this.aim.bsW().brq() : ClickableHeaderImageView.this.aim.brq();
                    if (brq != null && !StringUtils.isNull(brq.getName_show()) && !StringUtils.isNull(brq.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(brq.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), brq.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aim.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.aim.bpO());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.akV != null) {
                            ClickableHeaderImageView.this.akV.onClick(view);
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
        MetaData brq;
        if (bzVar != null && bzVar.brq() != null) {
            this.aim = bzVar;
            this.fhv = z2;
            if (z2) {
                brq = bzVar.bsW().brq();
            } else {
                brq = bzVar.brq();
            }
            setContentDescription(brq.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(brq.getUserId());
            setUserName(brq.getUserName());
            if (bzVar.brJ() != null && this.aim.getThreadType() == 49) {
                setUrl(bzVar.brq().getAvater());
                startLoad(bzVar.brq().getAvater(), 28, false);
            } else {
                setUrl(brq.getAvater());
                if (!StringUtils.isNull(brq.getAvater()) && brq.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(brq.getAvater(), 10, false);
                } else {
                    startLoad(brq.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, brq);
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
