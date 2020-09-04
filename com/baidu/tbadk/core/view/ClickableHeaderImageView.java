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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bw afL;
    private View.OnClickListener aiC;
    private boolean epb;
    protected com.baidu.tbadk.h.d epc;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.epc = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiC = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.epc == null || !ClickableHeaderImageView.this.epc.onClickEvent(view)) && ClickableHeaderImageView.this.afL != null) {
                    MetaData beE = ClickableHeaderImageView.this.epb ? ClickableHeaderImageView.this.afL.bgh().beE() : ClickableHeaderImageView.this.afL.beE();
                    if (beE != null && !StringUtils.isNull(beE.getName_show()) && !StringUtils.isNull(beE.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(beE.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), beE.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.afL.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.afL.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.aiC != null) {
                            ClickableHeaderImageView.this.aiC.onClick(view);
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
                if ((ClickableHeaderImageView.this.epc == null || !ClickableHeaderImageView.this.epc.onClickEvent(view)) && ClickableHeaderImageView.this.afL != null) {
                    MetaData beE = ClickableHeaderImageView.this.epb ? ClickableHeaderImageView.this.afL.bgh().beE() : ClickableHeaderImageView.this.afL.beE();
                    if (beE != null && !StringUtils.isNull(beE.getName_show()) && !StringUtils.isNull(beE.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(beE.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), beE.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.afL.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.afL.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.aiC != null) {
                            ClickableHeaderImageView.this.aiC.onClick(view);
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

    public void setData(bw bwVar, boolean z, boolean z2) {
        MetaData beE;
        if (bwVar != null && bwVar.beE() != null) {
            this.afL = bwVar;
            this.epb = z2;
            if (z2) {
                beE = bwVar.bgh().beE();
            } else {
                beE = bwVar.beE();
            }
            setContentDescription(beE.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(beE.getUserId());
            setUserName(beE.getUserName());
            if (bwVar.beY() != null && this.afL.getThreadType() == 49) {
                setUrl(bwVar.beE().getAvater());
                startLoad(bwVar.beE().getAvater(), 28, false);
            } else {
                setUrl(beE.getAvater());
                if (!StringUtils.isNull(beE.getAvater()) && beE.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(beE.getAvater(), 10, false);
                } else {
                    startLoad(beE.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, beE);
        }
    }

    public void setData(bw bwVar, boolean z) {
        setData(bwVar, z, false);
    }

    public void setData(bw bwVar) {
        setData(bwVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bw bwVar = new bw();
            bwVar.a(metaData);
            setData(bwVar);
        }
    }
}
