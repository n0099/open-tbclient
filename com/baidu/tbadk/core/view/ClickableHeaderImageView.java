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
    private bj adJ;
    private View.OnClickListener afV;
    private boolean dEg;
    protected com.baidu.tbadk.h.d dEh;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.dEh = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afV = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.dEh == null || !ClickableHeaderImageView.this.dEh.onClickEvent(view)) && ClickableHeaderImageView.this.adJ != null) {
                    MetaData aKC = ClickableHeaderImageView.this.dEg ? ClickableHeaderImageView.this.adJ.aMc().aKC() : ClickableHeaderImageView.this.adJ.aKC();
                    if (aKC != null && !StringUtils.isNull(aKC.getName_show()) && !StringUtils.isNull(aKC.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aKC.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aKC.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.adJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.afV != null) {
                            ClickableHeaderImageView.this.afV.onClick(view);
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
                if ((ClickableHeaderImageView.this.dEh == null || !ClickableHeaderImageView.this.dEh.onClickEvent(view)) && ClickableHeaderImageView.this.adJ != null) {
                    MetaData aKC = ClickableHeaderImageView.this.dEg ? ClickableHeaderImageView.this.adJ.aMc().aKC() : ClickableHeaderImageView.this.adJ.aKC();
                    if (aKC != null && !StringUtils.isNull(aKC.getName_show()) && !StringUtils.isNull(aKC.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aKC.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aKC.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.adJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.afV != null) {
                            ClickableHeaderImageView.this.afV.onClick(view);
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
        MetaData aKC;
        if (bjVar != null && bjVar.aKC() != null) {
            this.adJ = bjVar;
            this.dEg = z2;
            if (z2) {
                aKC = bjVar.aMc().aKC();
            } else {
                aKC = bjVar.aKC();
            }
            setContentDescription(aKC.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aKC.getUserId());
            setUserName(aKC.getUserName());
            if (bjVar.aKV() != null && this.adJ.getThreadType() == 49) {
                setUrl(bjVar.aKC().getAvater());
                startLoad(bjVar.aKC().getAvater(), 28, false);
            } else {
                setUrl(aKC.getAvater());
                if (!StringUtils.isNull(aKC.getAvater()) && aKC.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(aKC.getAvater(), 10, false);
                } else {
                    startLoad(aKC.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, aKC);
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
