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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bv aeA;
    private View.OnClickListener ahn;
    private boolean efx;
    protected com.baidu.tbadk.h.d efy;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.efy = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahn = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.efy == null || !ClickableHeaderImageView.this.efy.onClickEvent(view)) && ClickableHeaderImageView.this.aeA != null) {
                    MetaData aWl = ClickableHeaderImageView.this.efx ? ClickableHeaderImageView.this.aeA.aXO().aWl() : ClickableHeaderImageView.this.aeA.aWl();
                    if (aWl != null && !StringUtils.isNull(aWl.getName_show()) && !StringUtils.isNull(aWl.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aWl.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aWl.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aeA.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.aeA.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ahn != null) {
                            ClickableHeaderImageView.this.ahn.onClick(view);
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
                if ((ClickableHeaderImageView.this.efy == null || !ClickableHeaderImageView.this.efy.onClickEvent(view)) && ClickableHeaderImageView.this.aeA != null) {
                    MetaData aWl = ClickableHeaderImageView.this.efx ? ClickableHeaderImageView.this.aeA.aXO().aWl() : ClickableHeaderImageView.this.aeA.aWl();
                    if (aWl != null && !StringUtils.isNull(aWl.getName_show()) && !StringUtils.isNull(aWl.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aWl.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aWl.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aeA.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.aeA.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ahn != null) {
                            ClickableHeaderImageView.this.ahn.onClick(view);
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

    public void setData(bv bvVar, boolean z, boolean z2) {
        MetaData aWl;
        if (bvVar != null && bvVar.aWl() != null) {
            this.aeA = bvVar;
            this.efx = z2;
            if (z2) {
                aWl = bvVar.aXO().aWl();
            } else {
                aWl = bvVar.aWl();
            }
            setContentDescription(aWl.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aWl.getUserId());
            setUserName(aWl.getUserName());
            if (bvVar.aWF() != null && this.aeA.getThreadType() == 49) {
                setUrl(bvVar.aWl().getAvater());
                startLoad(bvVar.aWl().getAvater(), 28, false);
            } else {
                setUrl(aWl.getAvater());
                if (!StringUtils.isNull(aWl.getAvater()) && aWl.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(aWl.getAvater(), 10, false);
                } else {
                    startLoad(aWl.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, aWl);
        }
    }

    public void setData(bv bvVar, boolean z) {
        setData(bvVar, z, false);
    }

    public void setData(bv bvVar) {
        setData(bvVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bv bvVar = new bv();
            bvVar.a(metaData);
            setData(bvVar);
        }
    }
}
