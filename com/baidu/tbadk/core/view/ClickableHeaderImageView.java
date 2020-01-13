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
    private bj Kn;
    private View.OnClickListener MG;
    private boolean cZX;
    protected com.baidu.tbadk.h.d cZY;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.cZY = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.MG = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.cZY == null || !ClickableHeaderImageView.this.cZY.onClickEvent(view)) && ClickableHeaderImageView.this.Kn != null) {
                    MetaData azX = ClickableHeaderImageView.this.cZX ? ClickableHeaderImageView.this.Kn.aBx().azX() : ClickableHeaderImageView.this.Kn.azX();
                    if (azX != null && !StringUtils.isNull(azX.getName_show()) && !StringUtils.isNull(azX.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(azX.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), azX.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.Kn.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.MG != null) {
                            ClickableHeaderImageView.this.MG.onClick(view);
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
                if ((ClickableHeaderImageView.this.cZY == null || !ClickableHeaderImageView.this.cZY.onClickEvent(view)) && ClickableHeaderImageView.this.Kn != null) {
                    MetaData azX = ClickableHeaderImageView.this.cZX ? ClickableHeaderImageView.this.Kn.aBx().azX() : ClickableHeaderImageView.this.Kn.azX();
                    if (azX != null && !StringUtils.isNull(azX.getName_show()) && !StringUtils.isNull(azX.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(azX.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), azX.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.Kn.getTid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.MG != null) {
                            ClickableHeaderImageView.this.MG.onClick(view);
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
        MetaData azX;
        if (bjVar != null && bjVar.azX() != null) {
            this.Kn = bjVar;
            this.cZX = z2;
            if (z2) {
                azX = bjVar.aBx().azX();
            } else {
                azX = bjVar.azX();
            }
            setContentDescription(azX.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(azX.getUserId());
            setUserName(azX.getUserName());
            if (bjVar.aAq() != null && this.Kn.getThreadType() == 49) {
                setUrl(bjVar.azX().getAvater());
                startLoad(bjVar.azX().getAvater(), 28, false);
            } else {
                setUrl(azX.getAvater());
                if (!StringUtils.isNull(azX.getAvater()) && azX.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(azX.getAvater(), 10, false);
                } else {
                    startLoad(azX.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, azX);
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
