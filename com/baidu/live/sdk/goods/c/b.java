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
    private a bBu;
    private List<com.baidu.live.sdk.goods.a.a> bfU;
    private boolean isHost;

    /* loaded from: classes10.dex */
    public interface a {
        void w(String str, boolean z);

        void x(String str, boolean z);
    }

    public void a(a aVar) {
        this.bBu = aVar;
    }

    public void e(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.bfU == null) {
            this.bfU = new ArrayList();
        }
        this.bfU.clear();
        this.bfU.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bfU != null) {
            return this.bfU.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bfU != null) {
            return this.bfU.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0203b c0203b;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_goods_display_list_item, viewGroup, false);
            C0203b c0203b2 = new C0203b();
            c0203b2.bBx = (LiveGoodsDisplayItemView) view.findViewById(a.f.item_live_goods_display);
            view.setTag(c0203b2);
            c0203b = c0203b2;
        } else {
            c0203b = (C0203b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0203b.bBx.setHost(this.isHost);
            c0203b.bBx.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0203b.bBx.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void PY() {
                        if (b.this.bBu != null) {
                            b.this.bBu.x(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bAP);
                        }
                    }
                });
            }
            if (this.bBu != null) {
                this.bBu.w(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bAP);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0203b {
        private LiveGoodsDisplayItemView bBx;

        public void recycle() {
            if (this.bBx != null) {
                this.bBx.release();
            }
        }
    }
}
