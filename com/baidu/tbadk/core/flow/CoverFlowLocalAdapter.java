package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowLocalAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private Context context;
    private View.OnClickListener eUC;
    private a eUF;
    private boolean eUG;
    private ArrayList<ImageView> eUB = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> eUD = new ArrayList<>();
    private ArrayList<RelativeLayout> eUE = new ArrayList<>();

    public CoverFlowLocalAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eUC = onClickListener;
    }

    public T oj(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        ImageView imageView;
        if (list != null && !list.isEmpty()) {
            this.eUF = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            D(this.dataList);
            int size = this.eUB.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    ImageView imageView2 = new ImageView(this.context);
                    this.eUB.add(imageView2);
                    this.eUE.add(new RelativeLayout(this.context));
                    imageView = imageView2;
                } else {
                    this.eUE.get(i);
                    imageView = this.eUB.get(i);
                }
                if (this.dataList.get(i) != null && imageView != null) {
                    if (this.dataList.get(i) instanceof h) {
                        imageView.setImageDrawable(ao.getDrawable(imageView.getResources(), Integer.valueOf(this.dataList.get(i).getPicUrl()).intValue()));
                    }
                    imageView.setOnClickListener(this.eUC);
                }
            }
            int count = x.getCount(this.dataList);
            int count2 = x.getCount(this.eUB);
            if (count2 > count) {
                x.removeSubList(this.eUB, count, count2);
            }
            int count3 = x.getCount(this.eUE);
            if (count3 > count) {
                x.removeSubList(this.eUE, count, count3);
            }
            notifyDataSetChanged();
        }
    }

    private void D(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1 && this.eUG) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.eUB != null && this.eUB.size() > 0) {
            return this.eUB.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.eUB == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) x.getItem(this.eUB, i);
        if (imageView.getParent() != null) {
            ((ViewGroup) imageView.getParent()).removeView(imageView);
        }
        if (imageView.getParent() == null) {
            viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        imageView.setTag(Integer.valueOf(i));
        return imageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void setCanRepeat(boolean z) {
        this.eUG = z;
    }
}
