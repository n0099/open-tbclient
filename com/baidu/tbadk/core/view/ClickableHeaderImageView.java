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
    private bj Ki;
    private View.OnClickListener Mz;
    private boolean cZN;
    protected com.baidu.tbadk.h.d cZO;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.cZO = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Mz = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.cZO == null || !ClickableHeaderImageView.this.cZO.onClickEvent(view)) && ClickableHeaderImageView.this.Ki != null) {
                    MetaData azE = ClickableHeaderImageView.this.cZN ? ClickableHeaderImageView.this.Ki.aBe().azE() : ClickableHeaderImageView.this.Ki.azE();
                    if (azE != null && !StringUtils.isNull(azE.getName_show()) && !StringUtils.isNull(azE.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(azE.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), azE.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.Ki.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.Mz != null) {
                            ClickableHeaderImageView.this.Mz.onClick(view);
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
                if ((ClickableHeaderImageView.this.cZO == null || !ClickableHeaderImageView.this.cZO.onClickEvent(view)) && ClickableHeaderImageView.this.Ki != null) {
                    MetaData azE = ClickableHeaderImageView.this.cZN ? ClickableHeaderImageView.this.Ki.aBe().azE() : ClickableHeaderImageView.this.Ki.azE();
                    if (azE != null && !StringUtils.isNull(azE.getName_show()) && !StringUtils.isNull(azE.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(azE.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), azE.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.Ki.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.Mz != null) {
                            ClickableHeaderImageView.this.Mz.onClick(view);
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
        MetaData azE;
        if (bjVar != null && bjVar.azE() != null) {
            this.Ki = bjVar;
            this.cZN = z2;
            if (z2) {
                azE = bjVar.aBe().azE();
            } else {
                azE = bjVar.azE();
            }
            setContentDescription(azE.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(azE.getUserId());
            setUserName(azE.getUserName());
            if (bjVar.azX() != null && this.Ki.getThreadType() == 49) {
                setUrl(bjVar.azE().getAvater());
                startLoad(bjVar.azE().getAvater(), 28, false);
            } else {
                setUrl(azE.getAvater());
                if (!StringUtils.isNull(azE.getAvater()) && azE.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(azE.getAvater(), 10, false);
                } else {
                    startLoad(azE.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, azE);
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
