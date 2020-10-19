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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bw agw;
    private View.OnClickListener ajo;
    private boolean eDr;
    protected com.baidu.tbadk.h.d eDs;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.eDs = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajo = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.eDs == null || !ClickableHeaderImageView.this.eDs.onClickEvent(view)) && ClickableHeaderImageView.this.agw != null) {
                    MetaData bih = ClickableHeaderImageView.this.eDr ? ClickableHeaderImageView.this.agw.bjK().bih() : ClickableHeaderImageView.this.agw.bih();
                    if (bih != null && !StringUtils.isNull(bih.getName_show()) && !StringUtils.isNull(bih.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bih.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bih.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.agw.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.agw.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ajo != null) {
                            ClickableHeaderImageView.this.ajo.onClick(view);
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
                if ((ClickableHeaderImageView.this.eDs == null || !ClickableHeaderImageView.this.eDs.onClickEvent(view)) && ClickableHeaderImageView.this.agw != null) {
                    MetaData bih = ClickableHeaderImageView.this.eDr ? ClickableHeaderImageView.this.agw.bjK().bih() : ClickableHeaderImageView.this.agw.bih();
                    if (bih != null && !StringUtils.isNull(bih.getName_show()) && !StringUtils.isNull(bih.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bih.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bih.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.agw.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.agw.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ajo != null) {
                            ClickableHeaderImageView.this.ajo.onClick(view);
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
        setPlaceHolder(1);
    }

    public void setData(bw bwVar, boolean z, boolean z2) {
        MetaData bih;
        if (bwVar != null && bwVar.bih() != null) {
            this.agw = bwVar;
            this.eDr = z2;
            if (z2) {
                bih = bwVar.bjK().bih();
            } else {
                bih = bwVar.bih();
            }
            setContentDescription(bih.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(bih.getUserId());
            setUserName(bih.getUserName());
            if (bwVar.biB() != null && this.agw.getThreadType() == 49) {
                setUrl(bwVar.bih().getAvater());
                startLoad(bwVar.bih().getAvater(), 28, false);
            } else {
                setUrl(bih.getAvater());
                if (!StringUtils.isNull(bih.getAvater()) && bih.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(bih.getAvater(), 10, false);
                } else {
                    startLoad(bih.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, bih);
        }
    }

    public void setData(bw bwVar, boolean z) {
        setData(bwVar, z, false);
    }

    public void setData(bw bwVar) {
        setData(bwVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bw bwVar = new bw();
            bwVar.a(metaData);
            setData(bwVar);
        }
    }
}
