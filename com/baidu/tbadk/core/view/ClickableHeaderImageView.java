package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ClickableHeaderImageView extends HeadImageView {
    private bl ahM;
    private View.OnClickListener ahN;
    protected com.baidu.tbadk.d.a ahO;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.ahO = aVar;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahN = onClickListener;
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

    public void setData(bl blVar) {
        if (blVar != null && blVar.getAuthor() != null) {
            this.ahM = blVar;
            MetaData author = blVar.getAuthor();
            setContentDescription(String.valueOf(author.getName_show()) + getContext().getString(w.l.somebodys_portrait));
            setUserId(author.getUserId());
            setUserName(author.getUserName());
            setUrl(author.getPortrait());
            if (blVar.rM() != null && this.ahM.getThreadType() == 49) {
                c(blVar.getAuthor().getPortrait(), 28, false);
            } else if (this.ahM.sx() != null && this.ahM.sx().channelId > 0) {
                setDefaultErrorResource(w.g.avatar_channel_poto_defaul160);
                c(this.ahM.sx().channelAvatar, 10, false);
            } else {
                c(author.getPortrait(), 28, false);
            }
            UtilHelper.showHeadImageViewBigV(this, author);
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bl blVar = new bl();
            blVar.setAuthor(metaData);
            setData(blVar);
        }
    }
}
