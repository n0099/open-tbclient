package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.CarouselRecommendView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter implements t {
    private CarouselRecommendView Lp;
    private TbPageContext<?> mContext;
    private CarouselRecommendView.e Lo = null;
    private ArrayList<com.baidu.tbadk.core.data.u> datas = new ArrayList<>();

    public b(TbPageContext<?> tbPageContext) {
        this.Lp = null;
        this.mContext = tbPageContext;
        this.Lp = new CarouselRecommendView(tbPageContext.getContext(), false);
    }

    public void r(ArrayList<com.baidu.tbadk.core.data.u> arrayList) {
        this.datas = arrayList;
        this.Lp.a(this.mContext, arrayList);
        this.Lo = this.Lp.getPagerAdapter();
        notifyDataSetChanged();
    }

    public void qk() {
        if (this.Lp != null) {
            this.Lp.qk();
        }
    }

    public void ql() {
        if (this.Lp != null) {
            this.Lp.ql();
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
        return this.Lp;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void qm() {
        if (this.Lo != null) {
            this.Lo.qm();
        }
    }

    @Override // com.baidu.tbadk.core.view.t
    public void f(View view, int i, int i2) {
        if (this.Lo != null) {
            this.Lo.f(this.Lp, 0, 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.Lp != null) {
            this.Lp.onChangeSkinType(i);
        }
    }
}
