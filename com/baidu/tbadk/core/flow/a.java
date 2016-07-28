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
    private ArrayList<TbImageView> TL = new ArrayList<>();
    private ArrayList<T> TM = new ArrayList<>();
    private View.OnClickListener TO;
    private Context context;

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.TO = onClickListener;
    }

    public T cd(int i) {
        if (this.TM == null || this.TM.isEmpty() || i < 0 || i >= this.TM.size()) {
            return null;
        }
        return this.TM.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        if (list != null && !list.isEmpty()) {
            this.TM.clear();
            this.TM.addAll(list);
            k(this.TM);
            int size = this.TL.size();
            int size2 = this.TM.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView I = bVar.I(this.context);
                    this.TL.add(I);
                    tbImageView = I;
                } else {
                    tbImageView = this.TL.get(i);
                }
                if (this.TM.get(i) != null && tbImageView != null) {
                    tbImageView.c(this.TM.get(i).getPicUrl(), 10, false);
                    tbImageView.setOnClickListener(this.TO);
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
        if (this.TL != null && this.TL.size() > 0) {
            return this.TL.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.TL == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = this.TL.get(i);
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

    public void sd() {
        if (this.TL != null && this.TL.size() > 0) {
            Iterator<TbImageView> it = this.TL.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
