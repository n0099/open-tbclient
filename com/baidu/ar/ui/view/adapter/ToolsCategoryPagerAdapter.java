package com.baidu.ar.ui.view.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.Utils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ToolsCategoryPagerAdapter extends PagerAdapter {
    private final Context a;
    private List<View> b = new ArrayList();
    private ArrayList<String> c;

    public ToolsCategoryPagerAdapter(Context context, ArrayList<String> arrayList) {
        this.c = new ArrayList<>();
        this.a = context;
        this.c = arrayList;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                return;
            }
            TextView textView = new TextView(context);
            textView.setSingleLine();
            textView.setTextSize(1, 12.0f);
            textView.setTextColor(Res.getColorStateList("bdar_viewpager_item_text_selector"));
            textView.setPadding(Utils.dipToPx(context, 5.0f), Utils.dipToPx(context, 0.0f), Utils.dipToPx(context, 5.0f), Utils.dipToPx(context, 10.0f));
            textView.setText(this.c.get(i2));
            textView.setTag(Integer.valueOf(i2));
            this.b.add(textView);
            i = i2 + 1;
        }
    }

    public ArrayList<String> a() {
        return this.c;
    }

    public List<View> b() {
        return this.b;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.c.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.b.get(i);
        viewGroup.addView(view, -1, -1);
        view.setTag(Integer.valueOf(i));
        return view;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
