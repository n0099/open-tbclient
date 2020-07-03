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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bu aeK;
    private View.OnClickListener ahw;
    private boolean dZk;
    protected com.baidu.tbadk.h.d dZl;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.dZl = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahw = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.dZl == null || !ClickableHeaderImageView.this.dZl.onClickEvent(view)) && ClickableHeaderImageView.this.aeK != null) {
                    MetaData aSp = ClickableHeaderImageView.this.dZk ? ClickableHeaderImageView.this.aeK.aTS().aSp() : ClickableHeaderImageView.this.aeK.aSp();
                    if (aSp != null && !StringUtils.isNull(aSp.getName_show()) && !StringUtils.isNull(aSp.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aSp.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aSp.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aeK.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.aeK.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ahw != null) {
                            ClickableHeaderImageView.this.ahw.onClick(view);
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
                if ((ClickableHeaderImageView.this.dZl == null || !ClickableHeaderImageView.this.dZl.onClickEvent(view)) && ClickableHeaderImageView.this.aeK != null) {
                    MetaData aSp = ClickableHeaderImageView.this.dZk ? ClickableHeaderImageView.this.aeK.aTS().aSp() : ClickableHeaderImageView.this.aeK.aSp();
                    if (aSp != null && !StringUtils.isNull(aSp.getName_show()) && !StringUtils.isNull(aSp.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aSp.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aSp.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aeK.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.aeK.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ahw != null) {
                            ClickableHeaderImageView.this.ahw.onClick(view);
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

    public void setData(bu buVar, boolean z, boolean z2) {
        MetaData aSp;
        if (buVar != null && buVar.aSp() != null) {
            this.aeK = buVar;
            this.dZk = z2;
            if (z2) {
                aSp = buVar.aTS().aSp();
            } else {
                aSp = buVar.aSp();
            }
            setContentDescription(aSp.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aSp.getUserId());
            setUserName(aSp.getUserName());
            if (buVar.aSJ() != null && this.aeK.getThreadType() == 49) {
                setUrl(buVar.aSp().getAvater());
                startLoad(buVar.aSp().getAvater(), 28, false);
            } else {
                setUrl(aSp.getAvater());
                if (!StringUtils.isNull(aSp.getAvater()) && aSp.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(aSp.getAvater(), 10, false);
                } else {
                    startLoad(aSp.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, aSp);
        }
    }

    public void setData(bu buVar, boolean z) {
        setData(buVar, z, false);
    }

    public void setData(bu buVar) {
        setData(buVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bu buVar = new bu();
            buVar.a(metaData);
            setData(buVar);
        }
    }
}
