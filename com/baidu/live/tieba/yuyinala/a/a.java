package com.baidu.live.tieba.yuyinala.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private int bfV = -1;
    private List<com.baidu.live.tieba.yuyinala.c.a> mDataList;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mDataList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: eX */
    public com.baidu.live.tieba.yuyinala.c.a getItem(int i) {
        return (com.baidu.live.tieba.yuyinala.c.a) ListUtils.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0225a c0225a;
        if (view == null) {
            C0225a c0225a2 = new C0225a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_choose_feedback_reason_item_layout, viewGroup, false);
            c0225a2.bOD = (TextView) view.findViewById(a.f.id_feedback_content);
            view.setTag(c0225a2);
            c0225a = c0225a2;
        } else {
            c0225a = (C0225a) view.getTag();
        }
        com.baidu.live.tieba.yuyinala.c.a item = getItem(i);
        if (item != null) {
            c0225a.bOD.setText(item.Ve());
        }
        if (i == this.bfV) {
            c0225a.bOD.setSelected(true);
        } else {
            c0225a.bOD.setSelected(false);
        }
        return view;
    }

    public void setData(List<com.baidu.live.tieba.yuyinala.c.a> list) {
        if (this.mDataList == null) {
            this.mDataList = new ArrayList();
        } else {
            this.mDataList.clear();
        }
        if (list != null) {
            this.mDataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public int Vd() {
        return this.bfV;
    }

    public void eY(int i) {
        this.bfV = i;
    }

    /* renamed from: com.baidu.live.tieba.yuyinala.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0225a {
        public TextView bOD;

        private C0225a() {
        }
    }
}
