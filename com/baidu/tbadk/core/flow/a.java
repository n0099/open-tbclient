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
    private ArrayList<TbImageView> Xv = new ArrayList<>();
    private ArrayList<T> Xw = new ArrayList<>();
    private View.OnClickListener Xx;
    private Context context;

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Xx = onClickListener;
    }

    public T bW(int i) {
        if (this.Xw == null || this.Xw.isEmpty() || i < 0 || i >= this.Xw.size()) {
            return null;
        }
        return this.Xw.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        if (list != null && !list.isEmpty()) {
            this.Xw.clear();
            this.Xw.addAll(list);
            k(this.Xw);
            int size = this.Xv.size();
            int size2 = this.Xw.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView X = bVar.X(this.context);
                    this.Xv.add(X);
                    tbImageView = X;
                } else {
                    tbImageView = this.Xv.get(i);
                }
                if (this.Xw.get(i) != null && tbImageView != null) {
                    tbImageView.d(this.Xw.get(i).getPicUrl(), 10, false);
                    tbImageView.setOnClickListener(this.Xx);
                }
            }
            notifyDataSetChanged();
        }
    }

    private void k(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.Xv != null && this.Xv.size() > 0) {
            return this.Xv.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.Xv == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = this.Xv.get(i);
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

    public void tf() {
        if (this.Xv != null && this.Xv.size() > 0) {
            Iterator<TbImageView> it = this.Xv.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
