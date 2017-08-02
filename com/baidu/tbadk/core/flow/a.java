package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener abr;
    private b abv;
    private Context context;
    private ArrayList<TbImageView> abp = new ArrayList<>();
    private ArrayList<T> abq = new ArrayList<>();
    private ArrayList<TbImageView> abt = new ArrayList<>();
    private ArrayList<RelativeLayout> abu = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.abr = onClickListener;
    }

    public T cs(int i) {
        if (this.abq == null || this.abq.isEmpty() || i < 0 || i >= this.abq.size()) {
            return null;
        }
        return this.abq.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.abv = bVar;
            this.abq.clear();
            this.abq.addAll(list);
            j(this.abq);
            int size = this.abp.size();
            int size2 = this.abq.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView as = bVar.as(this.context);
                    this.abp.add(as);
                    tbImageView = bVar.as(this.context);
                    this.abt.add(tbImageView);
                    this.abu.add(new RelativeLayout(this.context));
                    tbImageView2 = as;
                } else {
                    tbImageView = this.abt.get(i);
                    this.abu.get(i);
                    tbImageView2 = this.abp.get(i);
                }
                if (this.abq.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.abq.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.abr);
                    if ((this.abq.get(i) instanceof t) && !((t) this.abq.get(i)).pK()) {
                        t tVar = (t) this.abq.get(i);
                        s.b(tVar.pH(), tbImageView, tVar.pI(), k.g(this.context, d.f.ds24));
                    }
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
        if (this.abp != null && this.abp.size() > 0) {
            return this.abp.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.abp == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) u.c(this.abp, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((u.c(this.abq, i) instanceof t) && !((t) u.c(this.abq, i)).pK()) {
            RelativeLayout relativeLayout = (RelativeLayout) u.c(this.abu, i);
            TbImageView tbImageView = (TbImageView) u.c(this.abt, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.abv.tu() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, k.g(this.context, d.f.ds220) - k.g(this.context, d.f.ds24), 0, 0);
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

    public void onChangeSkinType() {
        if (this.abp != null && this.abp.size() > 0) {
            Iterator<TbImageView> it = this.abp.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
