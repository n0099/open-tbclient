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
    private bj KJ;
    private View.OnClickListener Ni;
    private boolean deE;
    protected com.baidu.tbadk.h.d deF;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.deF = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Ni = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.deF == null || !ClickableHeaderImageView.this.deF.onClickEvent(view)) && ClickableHeaderImageView.this.KJ != null) {
                    MetaData aCr = ClickableHeaderImageView.this.deE ? ClickableHeaderImageView.this.KJ.aDQ().aCr() : ClickableHeaderImageView.this.KJ.aCr();
                    if (aCr != null && !StringUtils.isNull(aCr.getName_show()) && !StringUtils.isNull(aCr.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aCr.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aCr.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.KJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.Ni != null) {
                            ClickableHeaderImageView.this.Ni.onClick(view);
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
                if ((ClickableHeaderImageView.this.deF == null || !ClickableHeaderImageView.this.deF.onClickEvent(view)) && ClickableHeaderImageView.this.KJ != null) {
                    MetaData aCr = ClickableHeaderImageView.this.deE ? ClickableHeaderImageView.this.KJ.aDQ().aCr() : ClickableHeaderImageView.this.KJ.aCr();
                    if (aCr != null && !StringUtils.isNull(aCr.getName_show()) && !StringUtils.isNull(aCr.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aCr.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aCr.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.KJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.Ni != null) {
                            ClickableHeaderImageView.this.Ni.onClick(view);
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
        MetaData aCr;
        if (bjVar != null && bjVar.aCr() != null) {
            this.KJ = bjVar;
            this.deE = z2;
            if (z2) {
                aCr = bjVar.aDQ().aCr();
            } else {
                aCr = bjVar.aCr();
            }
            setContentDescription(aCr.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aCr.getUserId());
            setUserName(aCr.getUserName());
            if (bjVar.aCK() != null && this.KJ.getThreadType() == 49) {
                setUrl(bjVar.aCr().getAvater());
                startLoad(bjVar.aCr().getAvater(), 28, false);
            } else {
                setUrl(aCr.getAvater());
                if (!StringUtils.isNull(aCr.getAvater()) && aCr.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(aCr.getAvater(), 10, false);
                } else {
                    startLoad(aCr.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, aCr);
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
