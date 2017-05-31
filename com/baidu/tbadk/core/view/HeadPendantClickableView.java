package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bl ahM;
    private View.OnClickListener ahN;
    protected com.baidu.tbadk.d.a ahO;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.ahO = aVar;
    }

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aig = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aig = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bl blVar) {
        if (blVar != null && blVar.getAuthor() != null) {
            this.ahM = blVar;
            MetaData author = blVar.getAuthor();
            setContentDescription(String.valueOf(author.getName_show()) + this.mContext.getString(w.l.somebodys_portrait));
            getHeadView().setUserId(author.getUserId());
            getHeadView().setUserName(author.getUserName());
            getHeadView().setUrl(author.getPortrait());
            bs sx = blVar.sx();
            if (sx != null && sx.channelId > 0) {
                getHeadView().c(sx.channelAvatar, 10, false);
            } else {
                getHeadView().c(blVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = author.getPendantData();
            if (sx != null && sx.channelId > 0) {
                dP(null);
            } else if (pendantData != null) {
                dP(blVar.getAuthor().getPendantData().pL());
            } else {
                dP(null);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bl blVar = new bl();
            blVar.setAuthor(metaData);
            setData(blVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahN = onClickListener;
    }
}
