package com.baidu.spswitch.emotion.view;

import android.content.Context;
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
import com.baidu.spswitch.b;
import com.baidu.spswitch.b.d;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BDEmotionBagLayout extends LinearLayout {
    private ViewPager Zi;
    private PagerAdapter Zj;
    private CircleIndicator cyQ;
    private List<GridView> cyR;
    private int cyS;
    private List<String> mEmotionList;

    public BDEmotionBagLayout(Context context) {
        this(context, null);
    }

    public BDEmotionBagLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDEmotionBagLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cyR = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        if (com.baidu.spswitch.b.a.afp().isNightMode()) {
            setBackgroundColor(-14540254);
        } else {
            setBackgroundColor(-1);
        }
        setOrientation(1);
        this.Zi = new ViewPager(context);
        this.cyQ = new CircleIndicator(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.Zi.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) d.g(context, 16.0f));
        layoutParams2.weight = 0.0f;
        this.cyQ.setLayoutParams(layoutParams2);
        this.Zi.setOverScrollMode(2);
        addView(this.Zi);
        addView(this.cyQ);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int measuredHeight = getChildAt(0).getMeasuredHeight();
        int g = ((int) d.g(getContext(), 48.0f)) * 3;
        int g2 = (int) (((measuredHeight - g) / 4) + d.g(getContext(), 8.0f));
        this.cyS = ((measuredHeight - g) - (g2 * 2)) / 2;
        int size = this.cyR.size();
        for (int i5 = 0; i5 < size; i5++) {
            GridView gridView = this.cyR.get(i5);
            int g3 = (int) d.g(getContext(), 10.0f);
            gridView.setPadding(g3, g2, g3, g2);
            gridView.setVerticalSpacing(this.cyS);
            gridView.setHorizontalSpacing((int) d.g(getContext(), (int) d.g(getContext(), 3.0f)));
            final a aVar = (a) gridView.getAdapter();
            if (aVar != null && this.Zi != null) {
                this.Zi.post(new Runnable() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagLayout.1
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
                c bU = c.bU(getContext().getApplicationContext());
                noScrollGridView.setOnItemClickListener(bU.a(EmotionType.EMOTION_CLASSIC_TYPE, i2));
                noScrollGridView.setOnItemLongClickListener(bU.a(EmotionType.EMOTION_CLASSIC_TYPE));
                noScrollGridView.setOnTouchListener(bU.b(EmotionType.EMOTION_CLASSIC_TYPE));
                noScrollGridView.setSelector(new ColorDrawable(0));
                this.cyR.add(noScrollGridView);
            }
            afm();
            this.Zj = new b(this.cyR);
            this.Zi.setAdapter(this.Zj);
            this.cyQ.setViewPager(this.Zi);
        }
    }

    private void afm() {
        int size = this.cyR.size();
        for (int i = 0; i < size; i++) {
            this.cyR.get(i).setAdapter((ListAdapter) new a(getContext(), fU(i)));
        }
    }

    private List<String> fU(int i) {
        int i2 = i * 20;
        int min = Math.min(20 + i2, this.mEmotionList.size());
        ArrayList arrayList = new ArrayList();
        while (i2 < min) {
            arrayList.add(this.mEmotionList.get(i2));
            i2++;
        }
        return arrayList;
    }

    /* loaded from: classes3.dex */
    private class b extends PagerAdapter {
        private List<GridView> mList;

        public b(List<GridView> list) {
            this.mList = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mList.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView(this.mList.get(i));
            return this.mList.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.mList.get(i));
        }
    }

    /* loaded from: classes3.dex */
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
                LinearLayout linearLayout2 = (LinearLayout) this.mInflater.inflate(b.d.emotion_grid_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
                layoutParams.height = (int) d.g(this.mContext, 48.0f);
                linearLayout2.setLayoutParams(layoutParams);
                linearLayout = linearLayout2;
            } else {
                linearLayout = (LinearLayout) view;
            }
            ImageView imageView = (ImageView) linearLayout.findViewById(b.c.img_item);
            if (i == getCount() - 1) {
                imageView.setImageResource(b.C0352b.face_delete);
            } else if (i < this.mList.size()) {
                imageView.setImageResource(com.baidu.spswitch.emotion.b.bR(this.mContext).a(EmotionType.EMOTION_CLASSIC_TYPE, this.mList.get(i)));
            }
            return linearLayout;
        }
    }
}
