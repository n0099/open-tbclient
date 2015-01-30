package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.CarouselRecommendView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter implements t {
    private CarouselRecommendView LK;
    private TbPageContext<?> mContext;
    private CarouselRecommendView.e LJ = null;
    private ArrayList<com.baidu.tbadk.core.data.v> datas = new ArrayList<>();

    public b(TbPageContext<?> tbPageContext) {
        this.LK = null;
        this.mContext = tbPageContext;
        this.LK = new CarouselRecommendView(tbPageContext.getContext(), false);
    }

    public void s(ArrayList<com.baidu.tbadk.core.data.v> arrayList) {
        this.datas = arrayList;
        this.LK.a(this.mContext, arrayList);
        this.LJ = this.LK.getPagerAdapter();
        notifyDataSetChanged();
    }

    public void qv() {
        if (this.LK != null) {
            this.LK.qv();
        }
    }

    public void qw() {
        if (this.LK != null) {
            this.LK.qw();
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
        return this.LK;
    }

    @Override // com.baidu.tbadk.core.view.t
    public void qx() {
        if (this.LJ != null) {
            this.LJ.qx();
        }
    }

    @Override // com.baidu.tbadk.core.view.t
    public void f(View view, int i, int i2) {
        if (this.LJ != null) {
            this.LJ.f(this.LK, 0, 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.LK != null) {
            this.LK.onChangeSkinType(i);
        }
    }
}
