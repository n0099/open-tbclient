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
    private a bsT;
    private List<com.baidu.live.sdk.goods.a.a> bsU;
    private boolean isHost;

    /* loaded from: classes4.dex */
    public interface a {
        void v(String str, boolean z);

        void w(String str, boolean z);
    }

    public void a(a aVar) {
        this.bsT = aVar;
    }

    public void d(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.bsU == null) {
            this.bsU = new ArrayList();
        }
        this.bsU.clear();
        this.bsU.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bsU != null) {
            return this.bsU.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bsU != null) {
            return this.bsU.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0199b c0199b;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_goods_display_list_item, viewGroup, false);
            C0199b c0199b2 = new C0199b();
            c0199b2.bsX = (LiveGoodsDisplayItemView) view.findViewById(a.f.item_live_goods_display);
            view.setTag(c0199b2);
            c0199b = c0199b2;
        } else {
            c0199b = (C0199b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0199b.bsX.setHost(this.isHost);
            c0199b.bsX.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0199b.bsX.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void PD() {
                        if (b.this.bsT != null) {
                            b.this.bsT.w(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bso);
                        }
                    }
                });
            }
            if (this.bsT != null) {
                this.bsT.v(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bso);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0199b {
        private LiveGoodsDisplayItemView bsX;

        public void recycle() {
            if (this.bsX != null) {
                this.bsX.release();
            }
        }
    }
}
