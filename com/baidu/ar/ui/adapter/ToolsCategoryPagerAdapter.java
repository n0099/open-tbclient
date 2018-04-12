package com.baidu.ar.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.o;
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
        for (int i = 0; i < this.c.size(); i++) {
            TextView textView = new TextView(context);
            textView.setSingleLine();
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(Res.getColorStateList("bdar_viewpager_item_text_selector"));
            textView.setPadding(0, o.a(context, 13.0f), 0, o.a(context, 13.0f));
            textView.setText(this.c.get(i));
            textView.setTag(Integer.valueOf(i));
            this.b.add(textView);
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
        View view2 = this.b.get(i);
        viewGroup.addView(view2, -1, -1);
        view2.setTag(Integer.valueOf(i));
        return view2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        return view2 == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
