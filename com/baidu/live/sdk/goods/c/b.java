package com.baidu.live.sdk.goods.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private List<com.baidu.live.sdk.goods.a.a> ber;
    private a bzU;
    private boolean isHost;

    /* loaded from: classes11.dex */
    public interface a {
        void w(String str, boolean z);

        void x(String str, boolean z);
    }

    public void a(a aVar) {
        this.bzU = aVar;
    }

    public void d(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.ber == null) {
            this.ber = new ArrayList();
        }
        this.ber.clear();
        this.ber.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ber != null) {
            return this.ber.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ber != null) {
            return this.ber.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0197b c0197b;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_goods_display_list_item, viewGroup, false);
            C0197b c0197b2 = new C0197b();
            c0197b2.bzX = (LiveGoodsDisplayItemView) view.findViewById(a.f.item_live_goods_display);
            view.setTag(c0197b2);
            c0197b = c0197b2;
        } else {
            c0197b = (C0197b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0197b.bzX.setHost(this.isHost);
            c0197b.bzX.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0197b.bzX.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void PV() {
                        if (b.this.bzU != null) {
                            b.this.bzU.x(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bzp);
                        }
                    }
                });
            }
            if (this.bzU != null) {
                this.bzU.w(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bzp);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0197b {
        private LiveGoodsDisplayItemView bzX;

        public void recycle() {
            if (this.bzX != null) {
                this.bzX.release();
            }
        }
    }
}
