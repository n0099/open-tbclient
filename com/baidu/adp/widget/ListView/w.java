package com.baidu.adp.widget.ListView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class w extends a<x, y> {
    private int mSkinType;

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), x.Wc);
        this.mSkinType = 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public y b(ViewGroup viewGroup) {
        return new y(LayoutInflater.from(this.mContext).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, x xVar, y yVar) {
        yVar.mTextView.setText(xVar.showText);
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ao.setImageResource(yVar.mImageView, xVar.resId);
            ao.setViewTextColor(yVar.mTextView, R.color.cp_cont_d);
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
