package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bm aiu;
    private View.OnClickListener aiv;
    protected com.baidu.tbadk.d.a aiw;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aiw = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiv = onClickListener;
    }

    public ClickableHeaderImageView(Context context) {
        super(context);
        this.mOnClickListener = new b(this);
        init();
    }

    public ClickableHeaderImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new b(this);
        init();
    }

    public void init() {
        setOnClickListener(this.mOnClickListener);
        setDefaultResource(17170445);
        setDefaultErrorResource(w.g.icon_default_avatar100);
        setDefaultBgResource(w.e.cp_bg_line_e);
    }

    public void setData(bm bmVar) {
        if (bmVar != null && bmVar.getAuthor() != null) {
            this.aiu = bmVar;
            MetaData author = bmVar.getAuthor();
            setContentDescription(String.valueOf(author.getName_show()) + getContext().getString(w.l.somebodys_portrait));
            setUserId(author.getUserId());
            setUserName(author.getUserName());
            setUrl(author.getPortrait());
            if (bmVar.rJ() != null && this.aiu.getThreadType() == 49) {
                c(bmVar.getAuthor().getPortrait(), 28, false);
            } else if (this.aiu.sv() != null && this.aiu.sv().channelId > 0) {
                setDefaultErrorResource(w.g.avatar_channel_poto_defaul160);
                c(this.aiu.sv().channelAvatar, 10, false);
            } else {
                c(author.getPortrait(), 28, false);
            }
            UtilHelper.showHeadImageViewBigV(this, author);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bm bmVar = new bm();
            bmVar.setAuthor(metaData);
            setData(bmVar);
        }
    }
}
