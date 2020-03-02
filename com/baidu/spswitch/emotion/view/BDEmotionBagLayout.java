package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.spswitch.b.f;
import com.baidu.spswitch.c;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class BDEmotionBagLayout extends LinearLayout {
    private CircleIndicator aZI;
    private List<GridView> aZJ;
    private int aZK;
    private List<String> mEmotionList;
    private PagerAdapter mPagerAdapter;
    private ViewPager mViewPager;

    public BDEmotionBagLayout(Context context) {
        this(context, null);
    }

    public BDEmotionBagLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDEmotionBagLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZJ = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        if (com.baidu.spswitch.b.a.Gq().isNightMode()) {
            setBackgroundColor(-14540254);
        } else {
            setBackgroundColor(-1);
        }
        setOrientation(1);
        this.mViewPager = new ViewPager(context);
        this.aZI = new CircleIndicator(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.mViewPager.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) f.g(context, 16.0f));
        layoutParams2.weight = 0.0f;
        this.aZI.setLayoutParams(layoutParams2);
        this.mViewPager.setOverScrollMode(2);
        addView(this.mViewPager);
        addView(this.aZI);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int measuredHeight = getChildAt(0).getMeasuredHeight();
        int g = ((int) f.g(getContext(), 48.0f)) * 3;
        int g2 = (int) (((measuredHeight - g) / 4) + f.g(getContext(), 8.0f));
        this.aZK = ((measuredHeight - g) - (g2 * 2)) / 2;
        int size = this.aZJ.size();
        for (int i5 = 0; i5 < size; i5++) {
            GridView gridView = this.aZJ.get(i5);
            int g3 = (int) f.g(getContext(), 10.0f);
            gridView.setPadding(g3, g2, g3, g2);
            gridView.setVerticalSpacing(this.aZK);
            gridView.setHorizontalSpacing((int) f.g(getContext(), (int) f.g(getContext(), 3.0f)));
            final a aVar = (a) gridView.getAdapter();
            if (aVar != null && this.mViewPager != null) {
                this.mViewPager.post(new Runnable() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagLayout.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.notifyDataSetChanged();
                    }
                });
            }
        }
    }

    public void setEmotionList(List<String> list) {
        this.mEmotionList = list;
        if (this.mEmotionList != null && this.mEmotionList.size() > 0) {
            int size = this.mEmotionList.size();
            int i = size % 20 == 0 ? size / 20 : (size / 20) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                NoScrollGridView noScrollGridView = new NoScrollGridView(getContext());
                noScrollGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                noScrollGridView.setNumColumns(7);
                noScrollGridView.setStretchMode(2);
                noScrollGridView.setVerticalScrollBarEnabled(false);
                noScrollGridView.setOverScrollMode(2);
                c bf = c.bf(getContext().getApplicationContext());
                noScrollGridView.setOnItemClickListener(bf.a(EmotionType.EMOTION_CLASSIC_TYPE, i2));
                noScrollGridView.setOnItemLongClickListener(bf.b(EmotionType.EMOTION_CLASSIC_TYPE));
                noScrollGridView.setOnTouchListener(bf.c(EmotionType.EMOTION_CLASSIC_TYPE));
                noScrollGridView.setSelector(new ColorDrawable(0));
                this.aZJ.add(noScrollGridView);
            }
            Gn();
            this.mPagerAdapter = new b(this.aZJ);
            this.mViewPager.setAdapter(this.mPagerAdapter);
            this.aZI.setViewPager(this.mViewPager);
        }
    }

    private void Gn() {
        int size = this.aZJ.size();
        for (int i = 0; i < size; i++) {
            this.aZJ.get(i).setAdapter((ListAdapter) new a(getContext(), dM(i)));
        }
    }

    private List<String> dM(int i) {
        int i2 = i * 20;
        int min = Math.min(20 + i2, this.mEmotionList.size());
        ArrayList arrayList = new ArrayList();
        while (i2 < min) {
            arrayList.add(this.mEmotionList.get(i2));
            i2++;
        }
        return arrayList;
    }

    /* loaded from: classes13.dex */
    private class b extends PagerAdapter {
        private List<GridView> mList;

        public b(List<GridView> list) {
            this.mList = list;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mList.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView(this.mList.get(i));
            return this.mList.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.mList.get(i));
        }
    }

    /* loaded from: classes13.dex */
    public class a extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<String> mList;

        public a(Context context, List<String> list) {
            this.mList = list;
            this.mInflater = LayoutInflater.from(context);
            this.mContext = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return 21;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            if (i < this.mList.size()) {
                return this.mList.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            if (view == null) {
                LinearLayout linearLayout2 = (LinearLayout) this.mInflater.inflate(c.d.emotion_grid_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
                layoutParams.height = (int) f.g(this.mContext, 48.0f);
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout = linearLayout2;
            } else {
                linearLayout = (LinearLayout) view;
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(c.C0195c.img_item);
            if (i == getCount() - 1) {
                imageView.setImageResource(c.b.face_delete);
            } else if (i < this.mList.size()) {
                imageView.setImageResource(com.baidu.spswitch.emotion.b.bc(this.mContext).a(EmotionType.EMOTION_CLASSIC_TYPE, this.mList.get(i)));
            }
            return linearLayout;
        }
    }
}
