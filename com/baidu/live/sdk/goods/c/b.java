package com.baidu.live.sdk.goods.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private List<com.baidu.live.sdk.goods.a.a> bbl;
    private a bws;
    private boolean isHost;

    /* loaded from: classes10.dex */
    public interface a {
        void w(String str, boolean z);

        void x(String str, boolean z);
    }

    public void a(a aVar) {
        this.bws = aVar;
    }

    public void d(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.bbl == null) {
            this.bbl = new ArrayList();
        }
        this.bbl.clear();
        this.bbl.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbl != null) {
            return this.bbl.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbl != null) {
            return this.bbl.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0196b c0196b;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_goods_display_list_item, viewGroup, false);
            C0196b c0196b2 = new C0196b();
            c0196b2.bwv = (LiveGoodsDisplayItemView) view.findViewById(a.f.item_live_goods_display);
            view.setTag(c0196b2);
            c0196b = c0196b2;
        } else {
            c0196b = (C0196b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0196b.bwv.setHost(this.isHost);
            c0196b.bwv.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0196b.bwv.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void Ow() {
                        if (b.this.bws != null) {
                            b.this.bws.x(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bvN);
                        }
                    }
                });
            }
            if (this.bws != null) {
                this.bws.w(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bvN);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0196b {
        private LiveGoodsDisplayItemView bwv;

        public void recycle() {
            if (this.bwv != null) {
                this.bwv.release();
            }
        }
    }
}
