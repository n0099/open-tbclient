package com.baidu.adp.widget.ListView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class u extends a<v, w> {
    private int mSkinType;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), v.VD);
        this.mSkinType = 3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: g */
    public w b(ViewGroup viewGroup) {
        return new w(LayoutInflater.from(this.mContext).inflate(R.layout.adapter_no_data_item_layout, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, v vVar, w wVar) {
        wVar.mTextView.setText(vVar.showText);
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            am.setImageResource(wVar.mImageView, vVar.resId);
            am.setViewTextColor(wVar.mTextView, (int) R.color.cp_cont_d);
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        return view;
    }
}
