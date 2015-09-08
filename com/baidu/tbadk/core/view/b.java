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
    private CoverFlowView<com.baidu.tieba.square.a> ade;
    private TbPageContext<?> mContext;
    private ArrayList<com.baidu.tieba.square.a> datas = new ArrayList<>();
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.square.a> XE = new c(this);

    public b(TbPageContext<?> tbPageContext) {
        this.ade = null;
        this.mContext = tbPageContext;
        this.ade = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.ade.setCoverFlowFactory(new d(this, tbPageContext));
        this.ade.setCallback(this.XE);
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.u> arrayList) {
        ArrayList<com.baidu.tieba.square.a> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.tbadk.core.data.u> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.core.data.u next = it.next();
            if (next != null) {
                arrayList2.add(new com.baidu.tieba.square.a(next));
            }
        }
        this.datas = arrayList2;
        this.ade.setData(arrayList2);
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
        return this.ade;
    }

    public void onChangeSkinType(int i) {
        if (this.ade != null) {
            this.ade.tf();
        }
    }

    public CoverFlowView<com.baidu.tieba.square.a> vt() {
        return this.ade;
    }
}
