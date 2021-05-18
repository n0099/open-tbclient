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
import d.a.i0.a.d;
import d.a.i0.a.e;
import d.a.i0.a.f;
import d.a.i0.a.g;
import d.a.i0.a.v2.n0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class EmojiBagLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f11118e;

    /* renamed from: f  reason: collision with root package name */
    public CircleIndicator f11119f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f11120g;

    /* renamed from: h  reason: collision with root package name */
    public List<GridView> f11121h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f11122e;

        public a(b bVar) {
            this.f11122e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11122e.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<String> f11124e;

        /* renamed from: f  reason: collision with root package name */
        public LayoutInflater f11125f;

        /* renamed from: g  reason: collision with root package name */
        public Context f11126g;

        public b(Context context, List<String> list) {
            this.f11124e = list;
            this.f11125f = LayoutInflater.from(context);
            this.f11126g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i2) {
            if (i2 < this.f11124e.size()) {
                return this.f11124e.get(i2);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return 21;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            if (view == null) {
                linearLayout = (LinearLayout) this.f11125f.inflate(g.swanapp_emotion_grid_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                layoutParams.height = EmojiBagLayout.this.getResources().getDimensionPixelSize(d.aiapps_emoji_row_height);
                linearLayout.setLayoutParams(layoutParams);
            } else {
                linearLayout = (LinearLayout) view;
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(f.img_item);
            if (i2 == getCount() - 1) {
                imageView.setImageResource(e.swanapp_publisher_delete);
            } else if (i2 < this.f11124e.size()) {
                imageView.setImageBitmap(d.a.i0.a.w1.h.b.c().a(this.f11124e.get(i2)));
            }
            return linearLayout;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public List<GridView> f11128a;

        public c(List<GridView> list) {
            this.f11128a = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView(this.f11128a.get(i2));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f11128a.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            viewGroup.addView(this.f11128a.get(i2));
            return this.f11128a.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public EmojiBagLayout(Context context) {
        this(context, null);
    }

    public final List<String> a(int i2) {
        int i3 = i2 * 20;
        int min = Math.min(i3 + 20, this.f11120g.size());
        ArrayList arrayList = new ArrayList();
        while (i3 < min) {
            arrayList.add(this.f11120g.get(i3));
            i3++;
        }
        return arrayList;
    }

    public final void b(Context context) {
        setBackgroundColor(-1);
        setOrientation(1);
        this.f11118e = new ViewPager(context);
        this.f11119f = new CircleIndicator(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.f11118e.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.aiapps_emoji_indicator_height));
        layoutParams2.weight = 0.0f;
        this.f11119f.setLayoutParams(layoutParams2);
        this.f11118e.setOverScrollMode(2);
        addView(this.f11118e);
        addView(this.f11119f);
    }

    public final void c() {
        int size = this.f11121h.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f11121h.get(i2).setAdapter((ListAdapter) new b(getContext(), a(i2)));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        ViewPager viewPager;
        super.onSizeChanged(i2, i3, i4, i5);
        Resources resources = getResources();
        int measuredHeight = getChildAt(0).getMeasuredHeight() - (resources.getDimensionPixelSize(d.aiapps_emoji_row_height) * 3);
        int g2 = (measuredHeight / 4) + n0.g(8.0f);
        int i6 = (measuredHeight - (g2 * 2)) / 2;
        int size = this.f11121h.size();
        for (int i7 = 0; i7 < size; i7++) {
            GridView gridView = this.f11121h.get(i7);
            int dimensionPixelSize = resources.getDimensionPixelSize(d.aiapps_emoji_left_right_padding);
            gridView.setPadding(dimensionPixelSize, g2, dimensionPixelSize, g2);
            gridView.setVerticalSpacing(i6);
            gridView.setHorizontalSpacing(resources.getDimensionPixelSize(d.aiapps_emoji_grid_space));
            b bVar = (b) gridView.getAdapter();
            if (bVar != null && (viewPager = this.f11118e) != null) {
                viewPager.post(new a(bVar));
            }
        }
    }

    public void setEmotionList(List<String> list) {
        this.f11120g = list;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = this.f11120g.size();
        int i2 = size % 20;
        int i3 = size / 20;
        if (i2 != 0) {
            i3++;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            NoScrollGridView noScrollGridView = new NoScrollGridView(getContext());
            noScrollGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            noScrollGridView.setNumColumns(7);
            noScrollGridView.setStretchMode(2);
            noScrollGridView.setVerticalScrollBarEnabled(false);
            noScrollGridView.setOverScrollMode(2);
            d.a.i0.a.w1.h.a g2 = d.a.i0.a.w1.h.a.g(getContext().getApplicationContext());
            noScrollGridView.setOnItemClickListener(g2.h());
            noScrollGridView.setOnItemLongClickListener(g2.i());
            noScrollGridView.setOnTouchListener(g2.j());
            noScrollGridView.setSelector(new ColorDrawable(0));
            this.f11121h.add(noScrollGridView);
        }
        c();
        this.f11118e.setAdapter(new c(this.f11121h));
        this.f11119f.setViewPager(this.f11118e);
    }

    public EmojiBagLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiBagLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11121h = new ArrayList();
        b(context);
    }
}
