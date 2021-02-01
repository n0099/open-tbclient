package com.baidu.adp.widget.ListView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u extends a<v, NoDataItemViewHolder> {
    private int mSkinType;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), v.Yl);
        this.mSkinType = 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public NoDataItemViewHolder e(ViewGroup viewGroup) {
        return new NoDataItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, v vVar, NoDataItemViewHolder noDataItemViewHolder) {
        noDataItemViewHolder.mTextView.setText(vVar.showText);
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setImageResource(noDataItemViewHolder.mImageView, vVar.resId);
            ap.setViewTextColor(noDataItemViewHolder.mTextView, R.color.CAM_X0109);
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
