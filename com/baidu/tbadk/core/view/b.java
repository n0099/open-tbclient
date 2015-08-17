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
    private TbPageContext<?> LS;
    private CoverFlowView<com.baidu.tieba.square.a> acT;
    private ArrayList<com.baidu.tieba.square.a> datas = new ArrayList<>();
    private com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.square.a> Xv = new c(this);

    public b(TbPageContext<?> tbPageContext) {
        this.acT = null;
        this.LS = tbPageContext;
        this.acT = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.acT.setCoverFlowFactory(new d(this, tbPageContext));
        this.acT.setCallback(this.Xv);
    }

    public void setData(ArrayList<com.baidu.tbadk.core.data.s> arrayList) {
        ArrayList<com.baidu.tieba.square.a> arrayList2 = new ArrayList<>();
        Iterator<com.baidu.tbadk.core.data.s> it = arrayList.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.core.data.s next = it.next();
            if (next != null) {
                arrayList2.add(new com.baidu.tieba.square.a(next));
            }
        }
        this.datas = arrayList2;
        this.acT.setData(arrayList2);
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
        return this.acT;
    }

    public void onChangeSkinType(int i) {
        if (this.acT != null) {
            this.acT.ta();
        }
    }

    public CoverFlowView<com.baidu.tieba.square.a> vo() {
        return this.acT;
    }
}
