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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bk aee;
    private View.OnClickListener ags;
    private boolean dSs;
    protected com.baidu.tbadk.h.d dSt;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.h.d dVar) {
        this.dSt = dVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tbadk.core.view.ClickableHeaderImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ((ClickableHeaderImageView.this.dSt == null || !ClickableHeaderImageView.this.dSt.onClickEvent(view)) && ClickableHeaderImageView.this.aee != null) {
                    MetaData aQx = ClickableHeaderImageView.this.dSs ? ClickableHeaderImageView.this.aee.aSb().aQx() : ClickableHeaderImageView.this.aee.aQx();
                    if (aQx != null && !StringUtils.isNull(aQx.getName_show()) && !StringUtils.isNull(aQx.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aQx.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aQx.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aee.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.aee.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ags != null) {
                            ClickableHeaderImageView.this.ags.onClick(view);
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
                if ((ClickableHeaderImageView.this.dSt == null || !ClickableHeaderImageView.this.dSt.onClickEvent(view)) && ClickableHeaderImageView.this.aee != null) {
                    MetaData aQx = ClickableHeaderImageView.this.dSs ? ClickableHeaderImageView.this.aee.aSb().aQx() : ClickableHeaderImageView.this.aee.aQx();
                    if (aQx != null && !StringUtils.isNull(aQx.getName_show()) && !StringUtils.isNull(aQx.getUserId())) {
                        long j = com.baidu.adp.lib.f.b.toLong(aQx.getUserId(), 0L);
                        PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(ClickableHeaderImageView.this.getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aQx.isBigV());
                        createNormalConfig.setSourceTid(ClickableHeaderImageView.this.aee.getTid());
                        createNormalConfig.setSourceNid(ClickableHeaderImageView.this.aee.getNid());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
                        if (ClickableHeaderImageView.this.ags != null) {
                            ClickableHeaderImageView.this.ags.onClick(view);
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

    public void setData(bk bkVar, boolean z, boolean z2) {
        MetaData aQx;
        if (bkVar != null && bkVar.aQx() != null) {
            this.aee = bkVar;
            this.dSs = z2;
            if (z2) {
                aQx = bkVar.aSb().aQx();
            } else {
                aQx = bkVar.aQx();
            }
            setContentDescription(aQx.getName_show() + getContext().getString(R.string.somebodys_portrait));
            setUserId(aQx.getUserId());
            setUserName(aQx.getUserName());
            if (bkVar.aQS() != null && this.aee.getThreadType() == 49) {
                setUrl(bkVar.aQx().getAvater());
                startLoad(bkVar.aQx().getAvater(), 28, false);
            } else {
                setUrl(aQx.getAvater());
                if (!StringUtils.isNull(aQx.getAvater()) && aQx.getAvater().contains(HttpHost.DEFAULT_SCHEME_NAME)) {
                    startLoad(aQx.getAvater(), 10, false);
                } else {
                    startLoad(aQx.getAvater(), 28, false);
                }
            }
            UtilHelper.showHeadImageViewBigV(this, aQx);
        }
    }

    public void setData(bk bkVar, boolean z) {
        setData(bkVar, z, false);
    }

    public void setData(bk bkVar) {
        setData(bkVar, true);
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bk bkVar = new bk();
            bkVar.a(metaData);
            setData(bkVar);
        }
    }
}
