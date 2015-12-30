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
    private ArrayList<TbImageView> YI = new ArrayList<>();
    private ArrayList<T> YJ = new ArrayList<>();
    private View.OnClickListener YK;
    private Context context;

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.YK = onClickListener;
    }

    public T bX(int i) {
        if (this.YJ == null || this.YJ.isEmpty() || i < 0 || i >= this.YJ.size()) {
            return null;
        }
        return this.YJ.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        if (list != null && !list.isEmpty()) {
            this.YJ.clear();
            this.YJ.addAll(list);
            l(this.YJ);
            int size = this.YI.size();
            int size2 = this.YJ.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView X = bVar.X(this.context);
                    this.YI.add(X);
                    tbImageView = X;
                } else {
                    tbImageView = this.YI.get(i);
                }
                if (this.YJ.get(i) != null && tbImageView != null) {
                    tbImageView.d(this.YJ.get(i).getPicUrl(), 10, false);
                    tbImageView.setOnClickListener(this.YK);
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
        if (this.YI != null && this.YI.size() > 0) {
            return this.YI.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.YI == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = this.YI.get(i);
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

    public void tr() {
        if (this.YI != null && this.YI.size() > 0) {
            Iterator<TbImageView> it = this.YI.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
