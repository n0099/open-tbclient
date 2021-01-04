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
    private a bBe;
    private List<com.baidu.live.sdk.goods.a.a> bgb;
    private boolean isHost;

    /* loaded from: classes11.dex */
    public interface a {
        void w(String str, boolean z);

        void x(String str, boolean z);
    }

    public void a(a aVar) {
        this.bBe = aVar;
    }

    public void d(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.bgb == null) {
            this.bgb = new ArrayList();
        }
        this.bgb.clear();
        this.bgb.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bgb != null) {
            return this.bgb.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bgb != null) {
            return this.bgb.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0205b c0205b;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_goods_display_list_item, viewGroup, false);
            C0205b c0205b2 = new C0205b();
            c0205b2.bBh = (LiveGoodsDisplayItemView) view.findViewById(a.f.item_live_goods_display);
            view.setTag(c0205b2);
            c0205b = c0205b2;
        } else {
            c0205b = (C0205b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0205b.bBh.setHost(this.isHost);
            c0205b.bBh.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0205b.bBh.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void Sr() {
                        if (b.this.bBe != null) {
                            b.this.bBe.x(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bAz);
                        }
                    }
                });
            }
            if (this.bBe != null) {
                this.bBe.w(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bAz);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0205b {
        private LiveGoodsDisplayItemView bBh;

        public void recycle() {
            if (this.bBh != null) {
                this.bBh.release();
            }
        }
    }
}
