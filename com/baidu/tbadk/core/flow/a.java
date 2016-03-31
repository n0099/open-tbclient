package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener XA;
    private ArrayList<TbImageView> Xy = new ArrayList<>();
    private ArrayList<T> Xz = new ArrayList<>();
    private Context context;

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.XA = onClickListener;
    }

    public T cs(int i) {
        if (this.Xz == null || this.Xz.isEmpty() || i < 0 || i >= this.Xz.size()) {
            return null;
        }
        return this.Xz.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        if (list != null && !list.isEmpty()) {
            this.Xz.clear();
            this.Xz.addAll(list);
            j(this.Xz);
            int size = this.Xy.size();
            int size2 = this.Xz.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView K = bVar.K(this.context);
                    this.Xy.add(K);
                    tbImageView = K;
                } else {
                    tbImageView = this.Xy.get(i);
                }
                if (this.Xz.get(i) != null && tbImageView != null) {
                    tbImageView.c(this.Xz.get(i).getPicUrl(), 10, false);
                    tbImageView.setOnClickListener(this.XA);
                }
            }
            notifyDataSetChanged();
        }
    }

    private void j(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.Xy != null && this.Xy.size() > 0) {
            return this.Xy.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.Xy == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = this.Xy.get(i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (tbImageView.getParent() == null) {
            viewGroup.addView(tbImageView, new ViewGroup.LayoutParams(-1, -1));
        }
        tbImageView.setTag(Integer.valueOf(i));
        return tbImageView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void uA() {
        if (this.Xy != null && this.Xy.size() > 0) {
            Iterator<TbImageView> it = this.Xy.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
