package com.baidu.live.sdk.goods.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private List<com.baidu.live.sdk.goods.a.a> bep;
    private a bwt;
    private boolean isHost;

    /* loaded from: classes4.dex */
    public interface a {
        void w(String str, boolean z);

        void x(String str, boolean z);
    }

    public void a(a aVar) {
        this.bwt = aVar;
    }

    public void c(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.bep == null) {
            this.bep = new ArrayList();
        }
        this.bep.clear();
        this.bep.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bep != null) {
            return this.bep.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bep != null) {
            return this.bep.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0207b c0207b;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_goods_display_list_item, viewGroup, false);
            C0207b c0207b2 = new C0207b();
            c0207b2.bww = (LiveGoodsDisplayItemView) view.findViewById(a.f.item_live_goods_display);
            view.setTag(c0207b2);
            c0207b = c0207b2;
        } else {
            c0207b = (C0207b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0207b.bww.setHost(this.isHost);
            c0207b.bww.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0207b.bww.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void Ro() {
                        if (b.this.bwt != null) {
                            b.this.bwt.x(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bvO);
                        }
                    }
                });
            }
            if (this.bwt != null) {
                this.bwt.w(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bvO);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0207b {
        private LiveGoodsDisplayItemView bww;

        public void recycle() {
            if (this.bww != null) {
                this.bww.release();
            }
        }
    }
}
