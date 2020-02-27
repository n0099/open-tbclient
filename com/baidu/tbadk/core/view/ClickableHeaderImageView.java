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
    private View.OnClickListener Nh;
    private boolean dec;
    protected com.baidu.tbadk.h.d ded;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.ded = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Nh = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.ded == null || !ClickableHeaderImageView.this.ded.onClickEvent(view)) && ClickableHeaderImageView.this.KJ != null) {
                    MetaData aCm = ClickableHeaderImageView.this.dec ? ClickableHeaderImageView.this.KJ.aDK().aCm() : ClickableHeaderImageView.this.KJ.aCm();
                    if (aCm != null && !StringUtils.isNull(aCm.getName_show()) && !StringUtils.isNull(aCm.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aCm.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aCm.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.KJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.Nh != null) {
                            ClickableHeaderImageView.this.Nh.onClick(view);
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
                if ((ClickableHeaderImageView.this.ded == null || !ClickableHeaderImageView.this.ded.onClickEvent(view)) && ClickableHeaderImageView.this.KJ != null) {
                    MetaData aCm = ClickableHeaderImageView.this.dec ? ClickableHeaderImageView.this.KJ.aDK().aCm() : ClickableHeaderImageView.this.KJ.aCm();
                    if (aCm != null && !StringUtils.isNull(aCm.getName_show()) && !StringUtils.isNull(aCm.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aCm.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aCm.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.KJ.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.Nh != null) {
                            ClickableHeaderImageView.this.Nh.onClick(view);
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
        MetaData aCm;
        if (bjVar != null && bjVar.aCm() != null) {
            this.KJ = bjVar;
            this.dec = z2;
            if (z2) {
                aCm = bjVar.aDK().aCm();
            } else {
                aCm = bjVar.aCm();
            }
            setContentDescription(aCm.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aCm.getUserId());
            setUserName(aCm.getUserName());
            if (bjVar.aCF() != null && this.KJ.getThreadType() == 49) {
                setUrl(bjVar.aCm().getAvater());
                startLoad(bjVar.aCm().getAvater(), 28, false);
            } else {
                setUrl(aCm.getAvater());
                if (!StringUtils.isNull(aCm.getAvater()) && aCm.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(aCm.getAvater(), 10, false);
                } else {
                    startLoad(aCm.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, aCm);
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
