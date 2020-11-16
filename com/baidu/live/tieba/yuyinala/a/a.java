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
    private int bEi = -1;
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
    /* renamed from: fZ */
    public com.baidu.live.tieba.yuyinala.c.a getItem(int i) {
        return (com.baidu.live.tieba.yuyinala.c.a) ListUtils.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0219a c0219a;
        if (view == null) {
            C0219a c0219a2 = new C0219a();
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_choose_feedback_reason_item_layout, viewGroup, false);
            c0219a2.bEj = (TextView) view.findViewById(a.f.id_feedback_content);
            view.setTag(c0219a2);
            c0219a = c0219a2;
        } else {
            c0219a = (C0219a) view.getTag();
        }
        com.baidu.live.tieba.yuyinala.c.a item = getItem(i);
        if (item != null) {
            c0219a.bEj.setText(item.TK());
        }
        if (i == this.bEi) {
            c0219a.bEj.setSelected(true);
        } else {
            c0219a.bEj.setSelected(false);
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

    public int TJ() {
        return this.bEi;
    }

    public void ga(int i) {
        this.bEi = i;
    }

    /* renamed from: com.baidu.live.tieba.yuyinala.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0219a {
        public TextView bEj;

        private C0219a() {
        }
    }
}
