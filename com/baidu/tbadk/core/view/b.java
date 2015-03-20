package com.baidu.tbadk.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.flow.CoverFlowView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private TbPageContext<?> LN;
    private CoverFlowView<com.baidu.tieba.square.a> Xh;
    private ArrayList<com.baidu.tieba.square.a> datas = new ArrayList<>();
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.square.a> RR = new c(this);

    public b(TbPageContext<?> tbPageContext) {
        this.Xh = null;
        this.LN = tbPageContext;
        this.Xh = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.Xh.setCoverFlowFactory(new d(this, tbPageContext));
        this.Xh.setCallback(this.RR);
    }

    public void p(ArrayList<com.baidu.tbadk.core.data.u> arrayList) {
        ArrayList<com.baidu.tieba.square.a> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.tbadk.core.data.u> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.core.data.u next = it.next();
            if (next != null) {
                arrayList2.add(new com.baidu.tieba.square.a(next));
            }
        }
        this.datas = arrayList2;
        this.Xh.setData(arrayList2);
        notifyDataSetChanged();
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
        return this.Xh;
    }

    public void onChangeSkinType(int i) {
        if (this.Xh != null) {
            this.Xh.rk();
        }
    }

    public CoverFlowView<com.baidu.tieba.square.a> tE() {
        return this.Xh;
    }
}
