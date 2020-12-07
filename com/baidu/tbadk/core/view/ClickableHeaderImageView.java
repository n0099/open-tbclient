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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private by ahA;
    private View.OnClickListener akt;
    private boolean eXV;
    protected com.baidu.tbadk.h.d eXW;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.eXW = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.eXW == null || !ClickableHeaderImageView.this.eXW.onClickEvent(view)) && ClickableHeaderImageView.this.ahA != null) {
                    MetaData boP = ClickableHeaderImageView.this.eXV ? ClickableHeaderImageView.this.ahA.bqu().boP() : ClickableHeaderImageView.this.ahA.boP();
                    if (boP != null && !StringUtils.isNull(boP.getName_show()) && !StringUtils.isNull(boP.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(boP.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), boP.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.ahA.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.ahA.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.akt != null) {
                            ClickableHeaderImageView.this.akt.onClick(view);
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
                if ((ClickableHeaderImageView.this.eXW == null || !ClickableHeaderImageView.this.eXW.onClickEvent(view)) && ClickableHeaderImageView.this.ahA != null) {
                    MetaData boP = ClickableHeaderImageView.this.eXV ? ClickableHeaderImageView.this.ahA.bqu().boP() : ClickableHeaderImageView.this.ahA.boP();
                    if (boP != null && !StringUtils.isNull(boP.getName_show()) && !StringUtils.isNull(boP.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(boP.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), boP.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.ahA.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.ahA.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.akt != null) {
                            ClickableHeaderImageView.this.akt.onClick(view);
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

    public void setData(by byVar, boolean z, boolean z2) {
        MetaData boP;
        if (byVar != null && byVar.boP() != null) {
            this.ahA = byVar;
            this.eXV = z2;
            if (z2) {
                boP = byVar.bqu().boP();
            } else {
                boP = byVar.boP();
            }
            setContentDescription(boP.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(boP.getUserId());
            setUserName(boP.getUserName());
            if (byVar.bpj() != null && this.ahA.getThreadType() == 49) {
                setUrl(byVar.boP().getAvater());
                startLoad(byVar.boP().getAvater(), 28, false);
            } else {
                setUrl(boP.getAvater());
                if (!StringUtils.isNull(boP.getAvater()) && boP.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(boP.getAvater(), 10, false);
                } else {
                    startLoad(boP.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, boP);
        }
    }

    public void setData(by byVar, boolean z) {
        setData(byVar, z, false);
    }

    public void setData(by byVar) {
        setData(byVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            by byVar = new by();
            byVar.a(metaData);
            setData(byVar);
        }
    }
}
