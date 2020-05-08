package com.baidu.adp.widget.ListView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class s extends a<t, u> {
    private int mSkinType;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), t.Vp);
        this.mSkinType = 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public u b(ViewGroup viewGroup) {
        return new u(LayoutInflater.from(this.mContext).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, t tVar, u uVar) {
        uVar.mTextView.setText(tVar.showText);
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            am.setImageResource(uVar.mImageView, tVar.resId);
            am.setViewTextColor(uVar.mTextView, (int) R.color.cp_cont_d);
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
