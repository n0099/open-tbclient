package com.baidu.live.tieba.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tieba.b.a.a;
/* loaded from: classes10.dex */
public abstract class a<T extends com.baidu.live.tieba.b.a.a> implements View.OnClickListener {
    public int currentPageType;
    protected b mCallback;
    public Context mContext;
    private String mFrom;
    protected c<T> mListenner;
    public int mSkinType = 3;
    private BdUniqueId mTag = null;
    public TbPageContext<?> mTbPageContext;
    private View mView;

    public abstract int getLayout();

    public abstract void onBindDataToView(T t);

    public abstract void onChangeSkinType(TbPageContext<?> tbPageContext, int i);

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mView = LayoutInflater.from(this.mContext).inflate(getLayout(), (ViewGroup) null, false);
    }

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mView = LayoutInflater.from(this.mContext).inflate(getLayout(), viewGroup, false);
    }

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public View getView() {
        return this.mView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public TbPageContext<?> getTbPageContext() {
        return this.mTbPageContext;
    }

    public void onStart() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }

    public void setVisibility(int i) {
        if (this.mView != null) {
            this.mView.setVisibility(i);
        }
    }

    public void setOnSubCardOnClickListenner(c<T> cVar) {
        this.mListenner = cVar;
    }

    public void setOnCardStatisticsCallback(b bVar) {
        this.mCallback = bVar;
    }

    public c<T> getOnSubCardOnClickListenner() {
        return this.mListenner;
    }
}
