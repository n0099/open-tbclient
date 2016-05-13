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
    private ArrayList<TbImageView> SM = new ArrayList<>();
    private ArrayList<T> SN = new ArrayList<>();
    private View.OnClickListener SO;
    private Context context;

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.SO = onClickListener;
    }

    public T cc(int i) {
        if (this.SN == null || this.SN.isEmpty() || i < 0 || i >= this.SN.size()) {
            return null;
        }
        return this.SN.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        if (list != null && !list.isEmpty()) {
            this.SN.clear();
            this.SN.addAll(list);
            j(this.SN);
            int size = this.SM.size();
            int size2 = this.SN.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView J = bVar.J(this.context);
                    this.SM.add(J);
                    tbImageView = J;
                } else {
                    tbImageView = this.SM.get(i);
                }
                if (this.SN.get(i) != null && tbImageView != null) {
                    tbImageView.c(this.SN.get(i).getPicUrl(), 10, false);
                    tbImageView.setOnClickListener(this.SO);
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
        if (this.SM != null && this.SM.size() > 0) {
            return this.SM.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.SM == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = this.SM.get(i);
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

    public void sg() {
        if (this.SM != null && this.SM.size() > 0) {
            Iterator<TbImageView> it = this.SM.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
