package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class HeadPendantClickableView extends HeadPendantView {
    private bm aiu;
    private View.OnClickListener aiv;
    protected com.baidu.tbadk.d.a aiw;
    private Context mContext;
    public View.OnClickListener mOnClickListener;

    public void setOnInterceptClickEventListener(com.baidu.tbadk.d.a aVar) {
        this.aiw = aVar;
    }

    public HeadPendantClickableView(Context context) {
        super(context);
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aiO = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public HeadPendantClickableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new d(this);
        this.mContext = context;
        this.aiO = com.baidu.adp.lib.util.k.g(context, w.f.ds6);
        setOnClickListener(this.mOnClickListener);
    }

    public void setData(bm bmVar) {
        if (bmVar != null && bmVar.getAuthor() != null) {
            this.aiu = bmVar;
            MetaData author = bmVar.getAuthor();
            setContentDescription(String.valueOf(author.getName_show()) + this.mContext.getString(w.l.somebodys_portrait));
            getHeadView().setUserId(author.getUserId());
            getHeadView().setUserName(author.getUserName());
            getHeadView().setUrl(author.getPortrait());
            bt sv = bmVar.sv();
            if (sv != null && sv.channelId > 0) {
                getHeadView().c(sv.channelAvatar, 10, false);
            } else {
                getHeadView().c(bmVar.getAuthor().getPortrait(), 28, false);
            }
            com.baidu.tbadk.data.j pendantData = author.getPendantData();
            if (sv != null && sv.channelId > 0) {
                ek(null);
            } else if (pendantData != null) {
                ek(bmVar.getAuthor().getPendantData().pI());
            } else {
                ek(null);
            }
        }
    }

    public void setData(MetaData metaData) {
        if (metaData != null) {
            bm bmVar = new bm();
            bmVar.setAuthor(metaData);
            setData(bmVar);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiv = onClickListener;
    }
}
