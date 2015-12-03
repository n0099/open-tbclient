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
    private ArrayList<TbImageView> Yf = new ArrayList<>();
    private ArrayList<T> Yg = new ArrayList<>();
    private View.OnClickListener Yh;
    private Context context;

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Yh = onClickListener;
    }

    public T ce(int i) {
        if (this.Yg == null || this.Yg.isEmpty() || i < 0 || i >= this.Yg.size()) {
            return null;
        }
        return this.Yg.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        if (list != null && !list.isEmpty()) {
            this.Yg.clear();
            this.Yg.addAll(list);
            l(this.Yg);
            int size = this.Yf.size();
            int size2 = this.Yg.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView X = bVar.X(this.context);
                    this.Yf.add(X);
                    tbImageView = X;
                } else {
                    tbImageView = this.Yf.get(i);
                }
                if (this.Yg.get(i) != null && tbImageView != null) {
                    tbImageView.d(this.Yg.get(i).getPicUrl(), 10, false);
                    tbImageView.setOnClickListener(this.Yh);
                }
            }
            notifyDataSetChanged();
        }
    }

    private void l(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.Yf != null && this.Yf.size() > 0) {
            return this.Yf.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.Yf == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = this.Yf.get(i);
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

    public void tH() {
        if (this.Yf != null && this.Yf.size() > 0) {
            Iterator<TbImageView> it = this.Yf.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
