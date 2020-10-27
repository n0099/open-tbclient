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
    private a brA;
    private List<com.baidu.live.sdk.goods.a.a> brB;
    private boolean isHost;

    /* loaded from: classes4.dex */
    public interface a {
        void v(String str, boolean z);

        void w(String str, boolean z);
    }

    public void a(a aVar) {
        this.brA = aVar;
    }

    public void d(boolean z, List<com.baidu.live.sdk.goods.a.a> list) {
        this.isHost = z;
        if (this.brB == null) {
            this.brB = new ArrayList();
        }
        this.brB.clear();
        this.brB.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.brB != null) {
            return this.brB.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.brB != null) {
            return this.brB.get(i);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.live_goods_display_list_item, viewGroup, false);
            C0197b c0197b2 = new C0197b();
            c0197b2.brE = (LiveGoodsDisplayItemView) view.findViewById(a.g.item_live_goods_display);
            view.setTag(c0197b2);
            c0197b = c0197b2;
        } else {
            c0197b = (C0197b) view.getTag();
        }
        final Object item = getItem(i);
        if (item instanceof com.baidu.live.sdk.goods.a.a) {
            c0197b.brE.setHost(this.isHost);
            c0197b.brE.setData(i + 1, (com.baidu.live.sdk.goods.a.a) item);
            if (this.isHost) {
                c0197b.brE.setCallback(new LiveGoodsDisplayItemView.a() { // from class: com.baidu.live.sdk.goods.c.b.1
                    @Override // com.baidu.live.sdk.goods.view.LiveGoodsDisplayItemView.a
                    public void Pd() {
                        if (b.this.brA != null) {
                            b.this.brA.w(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bqV);
                        }
                    }
                });
            }
            if (this.brA != null) {
                this.brA.v(((com.baidu.live.sdk.goods.a.a) item).gid, ((com.baidu.live.sdk.goods.a.a) item).bqV);
            }
        }
        return view;
    }

    /* renamed from: com.baidu.live.sdk.goods.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0197b {
        private LiveGoodsDisplayItemView brE;

        public void recycle() {
            if (this.brE != null) {
                this.brE.release();
            }
        }
    }
}
