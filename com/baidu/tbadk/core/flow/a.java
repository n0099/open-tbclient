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
    private ArrayList<TbImageView> Td = new ArrayList<>();
    private ArrayList<T> Te = new ArrayList<>();
    private View.OnClickListener Tf;
    private Context context;

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Tf = onClickListener;
    }

    public T cd(int i) {
        if (this.Te == null || this.Te.isEmpty() || i < 0 || i >= this.Te.size()) {
            return null;
        }
        return this.Te.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        if (list != null && !list.isEmpty()) {
            this.Te.clear();
            this.Te.addAll(list);
            j(this.Te);
            int size = this.Td.size();
            int size2 = this.Te.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView I = bVar.I(this.context);
                    this.Td.add(I);
                    tbImageView = I;
                } else {
                    tbImageView = this.Td.get(i);
                }
                if (this.Te.get(i) != null && tbImageView != null) {
                    tbImageView.c(this.Te.get(i).getPicUrl(), 10, false);
                    tbImageView.setOnClickListener(this.Tf);
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
        if (this.Td != null && this.Td.size() > 0) {
            return this.Td.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.Td == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = this.Td.get(i);
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

    public void se() {
        if (this.Td != null && this.Td.size() > 0) {
            Iterator<TbImageView> it = this.Td.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
