package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private b acC;
    private View.OnClickListener acz;
    private Context context;
    private ArrayList<TbImageView> acx = new ArrayList<>();
    private ArrayList<T> acy = new ArrayList<>();
    private ArrayList<TbImageView> acA = new ArrayList<>();
    private ArrayList<RelativeLayout> acB = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.acz = onClickListener;
    }

    public T cu(int i) {
        if (this.acy == null || this.acy.isEmpty() || i < 0 || i >= this.acy.size()) {
            return null;
        }
        return this.acy.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.acC = bVar;
            this.acy.clear();
            this.acy.addAll(list);
            k(this.acy);
            int size = this.acx.size();
            int size2 = this.acy.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView ax = bVar.ax(this.context);
                    this.acx.add(ax);
                    tbImageView = bVar.ax(this.context);
                    this.acA.add(tbImageView);
                    this.acB.add(new RelativeLayout(this.context));
                    tbImageView2 = ax;
                } else {
                    tbImageView = this.acA.get(i);
                    this.acB.get(i);
                    tbImageView2 = this.acx.get(i);
                }
                if (this.acy.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.acy.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.acz);
                    if ((this.acy.get(i) instanceof q) && !((q) this.acy.get(i)).pQ()) {
                        q qVar = (q) this.acy.get(i);
                        r.b(qVar.pN(), tbImageView, qVar.pO(), l.f(this.context, d.e.ds24));
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
        if (this.acx != null && this.acx.size() > 0) {
            return this.acx.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.acx == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) v.c(this.acx, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.acy, i) instanceof q) && !((q) v.c(this.acy, i)).pQ()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.acB, i);
            TbImageView tbImageView = (TbImageView) v.c(this.acA, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.acC.tv() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.f(this.context, d.e.ds220) - l.f(this.context, d.e.ds24), 0, 0);
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
        if (this.acx != null && this.acx.size() > 0) {
            Iterator<TbImageView> it = this.acx.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
