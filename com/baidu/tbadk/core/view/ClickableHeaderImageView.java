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
    private bw agx;
    private View.OnClickListener ajp;
    private boolean eLN;
    protected com.baidu.tbadk.h.d eLO;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.eLO = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajp = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.eLO == null || !ClickableHeaderImageView.this.eLO.onClickEvent(view)) && ClickableHeaderImageView.this.agx != null) {
                    MetaData bka = ClickableHeaderImageView.this.eLN ? ClickableHeaderImageView.this.agx.blD().bka() : ClickableHeaderImageView.this.agx.bka();
                    if (bka != null && !StringUtils.isNull(bka.getName_show()) && !StringUtils.isNull(bka.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bka.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bka.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.agx.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.agx.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ajp != null) {
                            ClickableHeaderImageView.this.ajp.onClick(view);
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
                if ((ClickableHeaderImageView.this.eLO == null || !ClickableHeaderImageView.this.eLO.onClickEvent(view)) && ClickableHeaderImageView.this.agx != null) {
                    MetaData bka = ClickableHeaderImageView.this.eLN ? ClickableHeaderImageView.this.agx.blD().bka() : ClickableHeaderImageView.this.agx.bka();
                    if (bka != null && !StringUtils.isNull(bka.getName_show()) && !StringUtils.isNull(bka.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bka.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bka.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.agx.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.agx.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ajp != null) {
                            ClickableHeaderImageView.this.ajp.onClick(view);
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
        MetaData bka;
        if (bwVar != null && bwVar.bka() != null) {
            this.agx = bwVar;
            this.eLN = z2;
            if (z2) {
                bka = bwVar.blD().bka();
            } else {
                bka = bwVar.bka();
            }
            setContentDescription(bka.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(bka.getUserId());
            setUserName(bka.getUserName());
            if (bwVar.bku() != null && this.agx.getThreadType() == 49) {
                setUrl(bwVar.bka().getAvater());
                startLoad(bwVar.bka().getAvater(), 28, false);
            } else {
                setUrl(bka.getAvater());
                if (!StringUtils.isNull(bka.getAvater()) && bka.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(bka.getAvater(), 10, false);
                } else {
                    startLoad(bka.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, bka);
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
