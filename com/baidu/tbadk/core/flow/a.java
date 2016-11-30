package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.recapp.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener Xl;
    private b Xo;
    private Context context;
    private ArrayList<TbImageView> Xj = new ArrayList<>();
    private ArrayList<T> Xk = new ArrayList<>();
    private ArrayList<TbImageView> Xm = new ArrayList<>();
    private ArrayList<RelativeLayout> Xn = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.Xl = onClickListener;
    }

    public T cr(int i) {
        if (this.Xk == null || this.Xk.isEmpty() || i < 0 || i >= this.Xk.size()) {
            return null;
        }
        return this.Xk.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.Xo = bVar;
            this.Xk.clear();
            this.Xk.addAll(list);
            k(this.Xk);
            int size = this.Xj.size();
            int size2 = this.Xk.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView S = bVar.S(this.context);
                    this.Xj.add(S);
                    tbImageView = bVar.S(this.context);
                    this.Xm.add(tbImageView);
                    this.Xn.add(new RelativeLayout(this.context));
                    tbImageView2 = S;
                } else {
                    tbImageView = this.Xm.get(i);
                    this.Xn.get(i);
                    tbImageView2 = this.Xj.get(i);
                }
                if (this.Xk.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.Xk.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.Xl);
                    if ((this.Xk.get(i) instanceof s) && !((s) this.Xk.get(i)).pL()) {
                        s sVar = (s) this.Xk.get(i);
                        g.b(sVar.pI(), tbImageView, sVar.pJ(), k.e(this.context, r.e.ds24));
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
        if (this.Xj != null && this.Xj.size() > 0) {
            return this.Xj.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.Xj == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) x.c(this.Xj, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((x.c(this.Xk, i) instanceof s) && !((s) x.c(this.Xk, i)).pL()) {
            RelativeLayout relativeLayout = (RelativeLayout) x.c(this.Xn, i);
            TbImageView tbImageView = (TbImageView) x.c(this.Xm, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.Xo.tE() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, k.e(this.context, r.e.ds220) - k.e(this.context, r.e.ds24), 0, 0);
            }
            relativeLayout.addView(tbImageView, layoutParams);
            if (relativeLayout.getParent() == null) {
                viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            imageView.setTag(Integer.valueOf(i));
            return relativeLayout;
        }
        if (imageView.getParent() == null) {
            viewGroup.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        imageView.setTag(Integer.valueOf(i));
        return imageView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public void tB() {
        if (this.Xj != null && this.Xj.size() > 0) {
            Iterator<TbImageView> it = this.Xj.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
