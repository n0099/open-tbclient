package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.CarouselRecommendView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter implements t {
    private CarouselRecommendView LH;
    private TbPageContext<?> mContext;
    private CarouselRecommendView.e LG = null;
    private ArrayList<com.baidu.tbadk.core.data.v> datas = new ArrayList<>();

    public b(TbPageContext<?> tbPageContext) {
        this.LH = null;
        this.mContext = tbPageContext;
        this.LH = new CarouselRecommendView(tbPageContext.getContext(), false);
    }

    public void s(ArrayList<com.baidu.tbadk.core.data.v> arrayList) {
        this.datas = arrayList;
        this.LH.a(this.mContext, arrayList);
        this.LG = this.LH.getPagerAdapter();
        notifyDataSetChanged();
    }

    public void qo() {
        if (this.LH != null) {
            this.LH.qo();
        }
    }

    public void qp() {
        if (this.LH != null) {
            this.LH.qp();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.datas != null ? this.datas.size() + 0 : 0) > 0 ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.LH;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void qq() {
        if (this.LG != null) {
            this.LG.qq();
        }
    }

    @Override // com.baidu.tbadk.core.view.t
    public void f(View view, int i, int i2) {
        if (this.LG != null) {
            this.LG.f(this.LH, 0, 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.LH != null) {
            this.LH.onChangeSkinType(i);
        }
    }
}
