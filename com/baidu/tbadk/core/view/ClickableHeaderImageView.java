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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bj adG;
    private View.OnClickListener afS;
    private boolean dEc;
    protected com.baidu.tbadk.h.d dEd;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.dEd = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afS = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.dEd == null || !ClickableHeaderImageView.this.dEd.onClickEvent(view)) && ClickableHeaderImageView.this.adG != null) {
                    MetaData aKE = ClickableHeaderImageView.this.dEc ? ClickableHeaderImageView.this.adG.aMe().aKE() : ClickableHeaderImageView.this.adG.aKE();
                    if (aKE != null && !StringUtils.isNull(aKE.getName_show()) && !StringUtils.isNull(aKE.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aKE.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aKE.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.adG.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.afS != null) {
                            ClickableHeaderImageView.this.afS.onClick(view);
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
                if ((ClickableHeaderImageView.this.dEd == null || !ClickableHeaderImageView.this.dEd.onClickEvent(view)) && ClickableHeaderImageView.this.adG != null) {
                    MetaData aKE = ClickableHeaderImageView.this.dEc ? ClickableHeaderImageView.this.adG.aMe().aKE() : ClickableHeaderImageView.this.adG.aKE();
                    if (aKE != null && !StringUtils.isNull(aKE.getName_show()) && !StringUtils.isNull(aKE.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aKE.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aKE.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.adG.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.afS != null) {
                            ClickableHeaderImageView.this.afS.onClick(view);
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

    public void setData(bj bjVar, boolean z, boolean z2) {
        MetaData aKE;
        if (bjVar != null && bjVar.aKE() != null) {
            this.adG = bjVar;
            this.dEc = z2;
            if (z2) {
                aKE = bjVar.aMe().aKE();
            } else {
                aKE = bjVar.aKE();
            }
            setContentDescription(aKE.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aKE.getUserId());
            setUserName(aKE.getUserName());
            if (bjVar.aKX() != null && this.adG.getThreadType() == 49) {
                setUrl(bjVar.aKE().getAvater());
                startLoad(bjVar.aKE().getAvater(), 28, false);
            } else {
                setUrl(aKE.getAvater());
                if (!StringUtils.isNull(aKE.getAvater()) && aKE.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(aKE.getAvater(), 10, false);
                } else {
                    startLoad(aKE.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, aKE);
        }
    }

    public void setData(bj bjVar, boolean z) {
        setData(bjVar, z, false);
    }

    public void setData(bj bjVar) {
        setData(bjVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bj bjVar = new bj();
            bjVar.a(metaData);
            setData(bjVar);
        }
    }
}
