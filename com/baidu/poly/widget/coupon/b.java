package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.poly.b;
import com.baidu.poly.widget.coupon.a;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends BaseAdapter {
    private Context mContext;
    private List<a.C0247a> mData;

    /* loaded from: classes11.dex */
    private static class a {
        TextView af;
        ImageView bxI;
        TextView title;

        a(View view) {
            this.title = (TextView) view.findViewById(b.e.coupon_title);
            this.af = (TextView) view.findViewById(b.e.coupon_subtitle);
            this.bxI = (ImageView) view.findViewById(b.e.select_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.mContext = context;
    }

    public void b(List<a.C0247a> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a.C0247a> list = this.mData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a.C0247a item = getItem(i);
        if (item != null) {
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(b.f.coupon_list_item, (ViewGroup) null, false);
                view.setTag(new a(view));
            }
            if (view.getTag() != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                aVar.title.setText(item.bxD);
                if (TextUtils.isEmpty(item.bxE)) {
                    aVar.af.setVisibility(8);
                } else {
                    aVar.af.setVisibility(0);
                    aVar.af.setText(item.bxE);
                }
                aVar.bxI.setSelected(item.bxG == 1);
            }
        }
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dN */
    public a.C0247a getItem(int i) {
        if (i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }
}
