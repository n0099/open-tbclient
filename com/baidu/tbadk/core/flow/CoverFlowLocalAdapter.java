package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowLocalAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private Context context;
    private View.OnClickListener eJd;
    private a eJg;
    private boolean eJh;
    private ArrayList<ImageView> eJc = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> eJe = new ArrayList<>();
    private ArrayList<RelativeLayout> eJf = new ArrayList<>();

    public CoverFlowLocalAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eJd = onClickListener;
    }

    public T oK(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        ImageView imageView;
        if (list != null && !list.isEmpty()) {
            this.eJg = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            I(this.dataList);
            int size = this.eJc.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    ImageView imageView2 = new ImageView(this.context);
                    this.eJc.add(imageView2);
                    this.eJf.add(new RelativeLayout(this.context));
                    imageView = imageView2;
                } else {
                    this.eJf.get(i);
                    imageView = this.eJc.get(i);
                }
                if (this.dataList.get(i) != null && imageView != null) {
                    if (this.dataList.get(i) instanceof h) {
                        imageView.setImageDrawable(ap.getDrawable(imageView.getResources(), Integer.valueOf(this.dataList.get(i).getPicUrl()).intValue()));
                    }
                    imageView.setOnClickListener(this.eJd);
                }
            }
            int count = y.getCount(this.dataList);
            int count2 = y.getCount(this.eJc);
            if (count2 > count) {
                y.removeSubList(this.eJc, count, count2);
            }
            int count3 = y.getCount(this.eJf);
            if (count3 > count) {
                y.removeSubList(this.eJf, count, count3);
            }
            notifyDataSetChanged();
        }
    }

    private void I(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1 && this.eJh) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.eJc != null && this.eJc.size() > 0) {
            return this.eJc.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.eJc == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) y.getItem(this.eJc, i);
        if (imageView.getParent() != null) {
            ((ViewGroup) imageView.getParent()).removeView(imageView);
        }
        if (imageView.getParent() == null) {
            viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        imageView.setTag(Integer.valueOf(i));
        return imageView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void setCanRepeat(boolean z) {
        this.eJh = z;
    }
}
