package com.baidu.adp.widget.ListView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class y extends a<z, aa> {
    private int mSkinType;

    public y(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), z.Yt);
        this.mSkinType = 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: e */
    public aa c(ViewGroup viewGroup) {
        return new aa(LayoutInflater.from(this.mContext).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, z zVar, aa aaVar) {
        aaVar.mTextView.setText(zVar.showText);
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            ap.setImageResource(aaVar.mImageView, zVar.resId);
            ap.setViewTextColor(aaVar.mTextView, R.color.CAM_X0109);
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
