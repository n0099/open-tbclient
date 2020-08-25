package com.baidu.live.sdk.goods.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private a bjb;
    private List<com.baidu.live.sdk.goods.a.a> bjc;
    private boolean isHost;

    /* loaded from: classes7.dex */
    public interface a {
        void u(String str, boolean z);

        void v(String str, boolean z);
    }

    public void a(a aVar) {
        this.bjb = aVar;
    }

    public void e(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.bjc == null) {
            this.bjc = new ArrayList();
        }
        this.bjc.clear();
        this.bjc.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bjc != null) {
            return this.bjc.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bjc != null) {
            return this.bjc.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0187b c0187b;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.live_goods_display_list_item, viewGroup, false);
            C0187b c0187b2 = new C0187b();
            c0187b2.bjf = (LiveGoodsDisplayItemView) view.findViewById(a.g.item_live_goods_display);
            view.setTag(c0187b2);
            c0187b = c0187b2;
        } else {
            c0187b = (C0187b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0187b.bjf.setHost(this.isHost);
            c0187b.bjf.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0187b.bjf.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void MW() {
                        if (b.this.bjb != null) {
                            b.this.bjb.v(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).biy);
                        }
                    }
                });
            }
            if (this.bjb != null) {
                this.bjb.u(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).biy);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0187b {
        private LiveGoodsDisplayItemView bjf;

        public void recycle() {
            if (this.bjf != null) {
                this.bjf.release();
            }
        }
    }
}
