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
    private ArrayList<TbImageView> Xp = new ArrayList<>();
    private ArrayList<T> Xq = new ArrayList<>();
    private View.OnClickListener Xr;
    private Context context;

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Xr = onClickListener;
    }

    public T bW(int i) {
        if (this.Xq == null || this.Xq.isEmpty() || i < 0 || i >= this.Xq.size()) {
            return null;
        }
        return this.Xq.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        if (list != null && !list.isEmpty()) {
            this.Xq.clear();
            this.Xq.addAll(list);
            k(this.Xq);
            int size = this.Xp.size();
            int size2 = this.Xq.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView X = bVar.X(this.context);
                    this.Xp.add(X);
                    tbImageView = X;
                } else {
                    tbImageView = this.Xp.get(i);
                }
                if (this.Xq.get(i) != null && tbImageView != null) {
                    tbImageView.d(this.Xq.get(i).getPicUrl(), 10, false);
                    tbImageView.setOnClickListener(this.Xr);
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
        if (this.Xp != null && this.Xp.size() > 0) {
            return this.Xp.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.Xp == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = this.Xp.get(i);
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

    public void sZ() {
        if (this.Xp != null && this.Xp.size() > 0) {
            Iterator<TbImageView> it = this.Xp.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
