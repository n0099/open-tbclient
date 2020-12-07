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
/* loaded from: classes19.dex */
public class b extends BaseAdapter {
    private Context mContext;
    private List<a.C0325a> mData;

    /* loaded from: classes19.dex */
    private static class a {
        TextView ckg;
        ImageView ckh;
        TextView title;

        a(View view) {
            this.title = (TextView) view.findViewById(b.e.coupon_title);
            this.ckg = (TextView) view.findViewById(b.e.coupon_subtitle);
            this.ckh = (ImageView) view.findViewById(b.e.select_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.mContext = context;
    }

    public void b(List<a.C0325a> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<a.C0325a> list = this.mData;
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
        a.C0325a item = getItem(i);
        if (item != null) {
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(b.f.coupon_list_item, (ViewGroup) null, false);
                view.setTag(new a(view));
            }
            if (view.getTag() != null && (view.getTag() instanceof a)) {
                a aVar = (a) view.getTag();
                aVar.title.setText(item.ckc);
                if (TextUtils.isEmpty(item.af)) {
                    aVar.ckg.setVisibility(8);
                } else {
                    aVar.ckg.setVisibility(0);
                    aVar.ckg.setText(item.af);
                }
                aVar.ckh.setSelected(item.cke == 1);
            }
        }
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hm */
    public a.C0325a getItem(int i) {
        if (i < this.mData.size()) {
            return this.mData.get(i);
        }
        return null;
    }
}
