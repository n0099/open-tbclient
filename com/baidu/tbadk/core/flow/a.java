package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.recapp.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener WN;
    private b WQ;
    private Context context;
    private ArrayList<TbImageView> WL = new ArrayList<>();
    private ArrayList<T> WM = new ArrayList<>();
    private ArrayList<TbImageView> WO = new ArrayList<>();
    private ArrayList<RelativeLayout> WP = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.WN = onClickListener;
    }

    public T cq(int i) {
        if (this.WM == null || this.WM.isEmpty() || i < 0 || i >= this.WM.size()) {
            return null;
        }
        return this.WM.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.WQ = bVar;
            this.WM.clear();
            this.WM.addAll(list);
            k(this.WM);
            int size = this.WL.size();
            int size2 = this.WM.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView S = bVar.S(this.context);
                    this.WL.add(S);
                    tbImageView = bVar.S(this.context);
                    this.WO.add(tbImageView);
                    this.WP.add(new RelativeLayout(this.context));
                    tbImageView2 = S;
                } else {
                    tbImageView = this.WO.get(i);
                    this.WP.get(i);
                    tbImageView2 = this.WL.get(i);
                }
                if (this.WM.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.WM.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.WN);
                    if ((this.WM.get(i) instanceof r) && !((r) this.WM.get(i)).pI()) {
                        r rVar = (r) this.WM.get(i);
                        g.b(rVar.pF(), tbImageView, rVar.pG(), k.e(this.context, r.e.ds24));
                    }
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
        if (this.WL != null && this.WL.size() > 0) {
            return this.WL.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.WL == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = this.WL.get(i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((this.WM.get(i) instanceof com.baidu.tbadk.core.data.r) && !((com.baidu.tbadk.core.data.r) this.WM.get(i)).pI()) {
            RelativeLayout relativeLayout = this.WP.get(i);
            TbImageView tbImageView2 = this.WO.get(i);
            relativeLayout.removeView(tbImageView2);
            relativeLayout.removeView(tbImageView);
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.WQ.tA() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, k.e(this.context, r.e.ds220) - k.e(this.context, r.e.ds24), 0, 0);
            }
            relativeLayout.addView(tbImageView2, layoutParams);
            if (relativeLayout.getParent() == null) {
                viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            tbImageView.setTag(Integer.valueOf(i));
            return relativeLayout;
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

    public void tx() {
        if (this.WL != null && this.WL.size() > 0) {
            Iterator<TbImageView> it = this.WL.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
