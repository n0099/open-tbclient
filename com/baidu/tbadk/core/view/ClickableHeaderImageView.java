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
    private boolean deq;
    protected com.baidu.tbadk.h.d der;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.der = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Nh = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.der == null || !ClickableHeaderImageView.this.der.onClickEvent(view)) && ClickableHeaderImageView.this.KJ != null) {
                    MetaData aCo = ClickableHeaderImageView.this.deq ? ClickableHeaderImageView.this.KJ.aDM().aCo() : ClickableHeaderImageView.this.KJ.aCo();
                    if (aCo != null && !StringUtils.isNull(aCo.getName_show()) && !StringUtils.isNull(aCo.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aCo.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aCo.isBigV());
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
                if ((ClickableHeaderImageView.this.der == null || !ClickableHeaderImageView.this.der.onClickEvent(view)) && ClickableHeaderImageView.this.KJ != null) {
                    MetaData aCo = ClickableHeaderImageView.this.deq ? ClickableHeaderImageView.this.KJ.aDM().aCo() : ClickableHeaderImageView.this.KJ.aCo();
                    if (aCo != null && !StringUtils.isNull(aCo.getName_show()) && !StringUtils.isNull(aCo.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aCo.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aCo.isBigV());
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
        MetaData aCo;
        if (bjVar != null && bjVar.aCo() != null) {
            this.KJ = bjVar;
            this.deq = z2;
            if (z2) {
                aCo = bjVar.aDM().aCo();
            } else {
                aCo = bjVar.aCo();
            }
            setContentDescription(aCo.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aCo.getUserId());
            setUserName(aCo.getUserName());
            if (bjVar.aCH() != null && this.KJ.getThreadType() == 49) {
                setUrl(bjVar.aCo().getAvater());
                startLoad(bjVar.aCo().getAvater(), 28, false);
            } else {
                setUrl(aCo.getAvater());
                if (!StringUtils.isNull(aCo.getAvater()) && aCo.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(aCo.getAvater(), 10, false);
                } else {
                    startLoad(aCo.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, aCo);
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
