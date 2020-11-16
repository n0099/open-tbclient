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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bx agB;
    private View.OnClickListener aju;
    private boolean eQE;
    protected com.baidu.tbadk.h.d eQF;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.eQF = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aju = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.eQF == null || !ClickableHeaderImageView.this.eQF.onClickEvent(view)) && ClickableHeaderImageView.this.agB != null) {
                    MetaData blC = ClickableHeaderImageView.this.eQE ? ClickableHeaderImageView.this.agB.bnh().blC() : ClickableHeaderImageView.this.agB.blC();
                    if (blC != null && !StringUtils.isNull(blC.getName_show()) && !StringUtils.isNull(blC.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(blC.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), blC.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.agB.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.agB.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.aju != null) {
                            ClickableHeaderImageView.this.aju.onClick(view);
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
                if ((ClickableHeaderImageView.this.eQF == null || !ClickableHeaderImageView.this.eQF.onClickEvent(view)) && ClickableHeaderImageView.this.agB != null) {
                    MetaData blC = ClickableHeaderImageView.this.eQE ? ClickableHeaderImageView.this.agB.bnh().blC() : ClickableHeaderImageView.this.agB.blC();
                    if (blC != null && !StringUtils.isNull(blC.getName_show()) && !StringUtils.isNull(blC.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(blC.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), blC.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.agB.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.agB.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.aju != null) {
                            ClickableHeaderImageView.this.aju.onClick(view);
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

    public void setData(bx bxVar, boolean z, boolean z2) {
        MetaData blC;
        if (bxVar != null && bxVar.blC() != null) {
            this.agB = bxVar;
            this.eQE = z2;
            if (z2) {
                blC = bxVar.bnh().blC();
            } else {
                blC = bxVar.blC();
            }
            setContentDescription(blC.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(blC.getUserId());
            setUserName(blC.getUserName());
            if (bxVar.blW() != null && this.agB.getThreadType() == 49) {
                setUrl(bxVar.blC().getAvater());
                startLoad(bxVar.blC().getAvater(), 28, false);
            } else {
                setUrl(blC.getAvater());
                if (!StringUtils.isNull(blC.getAvater()) && blC.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(blC.getAvater(), 10, false);
                } else {
                    startLoad(blC.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, blC);
        }
    }

    public void setData(bx bxVar, boolean z) {
        setData(bxVar, z, false);
    }

    public void setData(bx bxVar) {
        setData(bxVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bx bxVar = new bx();
            bxVar.a(metaData);
            setData(bxVar);
        }
    }
}
