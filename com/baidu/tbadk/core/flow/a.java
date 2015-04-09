package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private List<TbImageView> RL = new ArrayList();
    private ArrayList<T> RM = new ArrayList<>();
    private View.OnClickListener RN;
    private Context context;

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.RN = onClickListener;
    }

    public T bH(int i) {
        if (this.RM == null || this.RM.isEmpty() || i < 0 || i >= this.RM.size()) {
            return null;
        }
        return this.RM.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        if (list != null && !list.isEmpty()) {
            this.RM.clear();
            this.RM.addAll(list);
            n(this.RM);
            int size = this.RL.size();
            int size2 = this.RM.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView V = bVar.V(this.context);
                    this.RL.add(V);
                    tbImageView = V;
                } else {
                    tbImageView = this.RL.get(i);
                }
                if (this.RM.get(i) != null && tbImageView != null) {
                    tbImageView.c(this.RM.get(i).getPicUrl(), 10, false);
                    tbImageView.setOnClickListener(this.RN);
                }
            }
            if (this.RL.size() > size2) {
                this.RL = this.RL.subList(0, size2);
            }
            notifyDataSetChanged();
        }
    }

    private void n(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.RL != null && this.RL.size() > 0) {
            return this.RL.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.RL == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = this.RL.get(i);
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

    public void rk() {
        if (this.RL != null && this.RL.size() > 0) {
            for (TbImageView tbImageView : this.RL) {
                tbImageView.invalidate();
            }
        }
    }
}
