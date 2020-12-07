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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private int beq = -1;
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
    /* renamed from: gy */
    public com.baidu.live.tieba.yuyinala.c.a getItem(int i) {
        return (com.baidu.live.tieba.yuyinala.c.a) ListUtils.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0228a c0228a;
        if (view == null) {
            C0228a c0228a2 = new C0228a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_choose_feedback_reason_item_layout, viewGroup, false);
            c0228a2.bJr = (TextView) view.findViewById(a.f.id_feedback_content);
            view.setTag(c0228a2);
            c0228a = c0228a2;
        } else {
            c0228a = (C0228a) view.getTag();
        }
        com.baidu.live.tieba.yuyinala.c.a item = getItem(i);
        if (item != null) {
            c0228a.bJr.setText(item.Wk());
        }
        if (i == this.beq) {
            c0228a.bJr.setSelected(true);
        } else {
            c0228a.bJr.setSelected(false);
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

    public int Wj() {
        return this.beq;
    }

    public void gz(int i) {
        this.beq = i;
    }

    /* renamed from: com.baidu.live.tieba.yuyinala.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0228a {
        public TextView bJr;

        private C0228a() {
        }
    }
}
