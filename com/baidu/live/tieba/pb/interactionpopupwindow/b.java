package com.baidu.live.tieba.pb.interactionpopupwindow;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData;
/* loaded from: classes10.dex */
public abstract class b<D extends IBaseDialogData> implements d<D> {
    private ViewGroup bFQ;
    protected int mSkinType = 3;
    protected TbPageContext<?> mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bFQ = (ViewGroup) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(getLayout(), (ViewGroup) null, false);
        initView();
    }

    public TbPageContext<?> getTbPageContext() {
        return this.mTbPageContext;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public ViewGroup getViewGroup() {
        return this.bFQ;
    }
}
