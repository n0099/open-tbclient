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
    private a bje;
    private List<com.baidu.live.sdk.goods.a.a> bjf;
    private boolean isHost;

    /* loaded from: classes7.dex */
    public interface a {
        void u(String str, boolean z);

        void v(String str, boolean z);
    }

    public void a(a aVar) {
        this.bje = aVar;
    }

    public void e(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.bjf == null) {
            this.bjf = new ArrayList();
        }
        this.bjf.clear();
        this.bjf.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bjf != null) {
            return this.bjf.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bjf != null) {
            return this.bjf.get(i);
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
            c0187b2.bji = (LiveGoodsDisplayItemView) view.findViewById(a.g.item_live_goods_display);
            view.setTag(c0187b2);
            c0187b = c0187b2;
        } else {
            c0187b = (C0187b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0187b.bji.setHost(this.isHost);
            c0187b.bji.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0187b.bji.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void MW() {
                        if (b.this.bje != null) {
                            b.this.bje.v(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).biB);
                        }
                    }
                });
            }
            if (this.bje != null) {
                this.bje.u(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).biB);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0187b {
        private LiveGoodsDisplayItemView bji;

        public void recycle() {
            if (this.bji != null) {
                this.bji.release();
            }
        }
    }
}
