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
    private bw agf;
    private View.OnClickListener aiW;
    private boolean erf;
    protected com.baidu.tbadk.h.d erg;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.erg = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiW = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.erg == null || !ClickableHeaderImageView.this.erg.onClickEvent(view)) && ClickableHeaderImageView.this.agf != null) {
                    MetaData bfy = ClickableHeaderImageView.this.erf ? ClickableHeaderImageView.this.agf.bhb().bfy() : ClickableHeaderImageView.this.agf.bfy();
                    if (bfy != null && !StringUtils.isNull(bfy.getName_show()) && !StringUtils.isNull(bfy.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bfy.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bfy.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.agf.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.agf.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.aiW != null) {
                            ClickableHeaderImageView.this.aiW.onClick(view);
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
                if ((ClickableHeaderImageView.this.erg == null || !ClickableHeaderImageView.this.erg.onClickEvent(view)) && ClickableHeaderImageView.this.agf != null) {
                    MetaData bfy = ClickableHeaderImageView.this.erf ? ClickableHeaderImageView.this.agf.bhb().bfy() : ClickableHeaderImageView.this.agf.bfy();
                    if (bfy != null && !StringUtils.isNull(bfy.getName_show()) && !StringUtils.isNull(bfy.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(bfy.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bfy.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.agf.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.agf.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.aiW != null) {
                            ClickableHeaderImageView.this.aiW.onClick(view);
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
        MetaData bfy;
        if (bwVar != null && bwVar.bfy() != null) {
            this.agf = bwVar;
            this.erf = z2;
            if (z2) {
                bfy = bwVar.bhb().bfy();
            } else {
                bfy = bwVar.bfy();
            }
            setContentDescription(bfy.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(bfy.getUserId());
            setUserName(bfy.getUserName());
            if (bwVar.bfS() != null && this.agf.getThreadType() == 49) {
                setUrl(bwVar.bfy().getAvater());
                startLoad(bwVar.bfy().getAvater(), 28, false);
            } else {
                setUrl(bfy.getAvater());
                if (!StringUtils.isNull(bfy.getAvater()) && bfy.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(bfy.getAvater(), 10, false);
                } else {
                    startLoad(bfy.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, bfy);
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
