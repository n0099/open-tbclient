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
    private a bpL;
    private List<com.baidu.live.sdk.goods.a.a> bpM;
    private boolean isHost;

    /* loaded from: classes4.dex */
    public interface a {
        void u(String str, boolean z);

        void v(String str, boolean z);
    }

    public void a(a aVar) {
        this.bpL = aVar;
    }

    public void e(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.bpM == null) {
            this.bpM = new ArrayList();
        }
        this.bpM.clear();
        this.bpM.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bpM != null) {
            return this.bpM.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bpM != null) {
            return this.bpM.get(i);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.live_goods_display_list_item, viewGroup, false);
            C0196b c0196b2 = new C0196b();
            c0196b2.bpP = (LiveGoodsDisplayItemView) view.findViewById(a.g.item_live_goods_display);
            view.setTag(c0196b2);
            c0196b = c0196b2;
        } else {
            c0196b = (C0196b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0196b.bpP.setHost(this.isHost);
            c0196b.bpP.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0196b.bpP.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void OF() {
                        if (b.this.bpL != null) {
                            b.this.bpL.v(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bpi);
                        }
                    }
                });
            }
            if (this.bpL != null) {
                this.bpL.u(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bpi);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0196b {
        private LiveGoodsDisplayItemView bpP;

        public void recycle() {
            if (this.bpP != null) {
                this.bpP.release();
            }
        }
    }
}
