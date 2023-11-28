package com.baidu.swan.apps.publisher.emoji.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.t33;
import com.baidu.tieba.u33;
import com.baidu.tieba.yj3;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmojiBagLayout extends LinearLayout {
    public ViewPager a;
    public CircleIndicator b;
    public List<String> c;
    public List<GridView> d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public List<String> a;
        public LayoutInflater b;
        public Context c;

        @Override // android.widget.Adapter
        public int getCount() {
            return 21;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public b(Context context, List<String> list) {
            this.a = list;
            this.b = LayoutInflater.from(context);
            this.c = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i) {
            if (i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            if (view2 == null) {
                linearLayout = (LinearLayout) this.b.inflate(R.layout.obfuscated_res_0x7f0d0965, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                layoutParams.height = EmojiBagLayout.this.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070141);
                linearLayout.setLayoutParams(layoutParams);
            } else {
                linearLayout = (LinearLayout) view2;
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(R.id.img_item);
            if (i == getCount() - 1) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f0814d1);
            } else if (i < this.a.size()) {
                imageView.setImageBitmap(u33.c().a(this.a.get(i)));
            }
            return linearLayout;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends PagerAdapter {
        public List<GridView> a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            return view2 == obj;
        }

        public c(List<GridView> list) {
            this.a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView(this.a.get(i));
            return this.a.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.a.get(i));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.a.size();
        }
    }

    public EmojiBagLayout(Context context) {
        this(context, null);
    }

    public final List<String> a(int i) {
        int i2 = i * 20;
        int min = Math.min(i2 + 20, this.c.size());
        ArrayList arrayList = new ArrayList();
        while (i2 < min) {
            arrayList.add(this.c.get(i2));
            i2++;
        }
        return arrayList;
    }

    public EmojiBagLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiBagLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new ArrayList();
        b(context);
    }

    public final void b(Context context) {
        setBackgroundColor(-1);
        setOrientation(1);
        this.a = new ViewPager(context);
        this.b = new CircleIndicator(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.a.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07013e));
        layoutParams2.weight = 0.0f;
        this.b.setLayoutParams(layoutParams2);
        this.a.setOverScrollMode(2);
        addView(this.a);
        addView(this.b);
    }

    public final void c() {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            this.d.get(i).setAdapter((ListAdapter) new b(getContext(), a(i)));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        ViewPager viewPager;
        super.onSizeChanged(i, i2, i3, i4);
        Resources resources = getResources();
        int measuredHeight = getChildAt(0).getMeasuredHeight() - (resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070141) * 3);
        int g = (measuredHeight / 4) + yj3.g(8.0f);
        int i5 = (measuredHeight - (g * 2)) / 2;
        int size = this.d.size();
        for (int i6 = 0; i6 < size; i6++) {
            GridView gridView = this.d.get(i6);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070140);
            gridView.setPadding(dimensionPixelSize, g, dimensionPixelSize, g);
            gridView.setVerticalSpacing(i5);
            gridView.setHorizontalSpacing(resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07013d));
            b bVar = (b) gridView.getAdapter();
            if (bVar != null && (viewPager = this.a) != null) {
                viewPager.post(new a(bVar));
            }
        }
    }

    public void setEmotionList(List<String> list) {
        this.c = list;
        if (list != null && list.size() > 0) {
            int size = this.c.size();
            int i = size % 20;
            int i2 = size / 20;
            if (i != 0) {
                i2++;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                NoScrollGridView noScrollGridView = new NoScrollGridView(getContext());
                noScrollGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                noScrollGridView.setNumColumns(7);
                noScrollGridView.setStretchMode(2);
                noScrollGridView.setVerticalScrollBarEnabled(false);
                noScrollGridView.setOverScrollMode(2);
                t33 g = t33.g(getContext().getApplicationContext());
                noScrollGridView.setOnItemClickListener(g.h());
                noScrollGridView.setOnItemLongClickListener(g.i());
                noScrollGridView.setOnTouchListener(g.j());
                noScrollGridView.setSelector(new ColorDrawable(0));
                this.d.add(noScrollGridView);
            }
            c();
            this.a.setAdapter(new c(this.d));
            this.b.setViewPager(this.a);
        }
    }
}
