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
    private a blY;
    private List<com.baidu.live.sdk.goods.a.a> blZ;
    private boolean isHost;

    /* loaded from: classes4.dex */
    public interface a {
        void u(String str, boolean z);

        void v(String str, boolean z);
    }

    public void a(a aVar) {
        this.blY = aVar;
    }

    public void e(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.blZ == null) {
            this.blZ = new ArrayList();
        }
        this.blZ.clear();
        this.blZ.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.blZ != null) {
            return this.blZ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.blZ != null) {
            return this.blZ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0188b c0188b;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.live_goods_display_list_item, viewGroup, false);
            C0188b c0188b2 = new C0188b();
            c0188b2.bmc = (LiveGoodsDisplayItemView) view.findViewById(a.g.item_live_goods_display);
            view.setTag(c0188b2);
            c0188b = c0188b2;
        } else {
            c0188b = (C0188b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0188b.bmc.setHost(this.isHost);
            c0188b.bmc.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0188b.bmc.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void NA() {
                        if (b.this.blY != null) {
                            b.this.blY.v(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).blv);
                        }
                    }
                });
            }
            if (this.blY != null) {
                this.blY.u(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).blv);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0188b {
        private LiveGoodsDisplayItemView bmc;

        public void recycle() {
            if (this.bmc != null) {
                this.bmc.release();
            }
        }
    }
}
