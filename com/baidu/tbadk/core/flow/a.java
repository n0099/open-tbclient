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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.recapp.y;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private b abB;
    private View.OnClickListener aby;
    private Context context;
    private ArrayList<TbImageView> abw = new ArrayList<>();
    private ArrayList<T> abx = new ArrayList<>();
    private ArrayList<TbImageView> abz = new ArrayList<>();
    private ArrayList<RelativeLayout> abA = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aby = onClickListener;
    }

    public T cr(int i) {
        if (this.abx == null || this.abx.isEmpty() || i < 0 || i >= this.abx.size()) {
            return null;
        }
        return this.abx.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.abB = bVar;
            this.abx.clear();
            this.abx.addAll(list);
            j(this.abx);
            int size = this.abw.size();
            int size2 = this.abx.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView as = bVar.as(this.context);
                    this.abw.add(as);
                    tbImageView = bVar.as(this.context);
                    this.abz.add(tbImageView);
                    this.abA.add(new RelativeLayout(this.context));
                    tbImageView2 = as;
                } else {
                    tbImageView = this.abz.get(i);
                    this.abA.get(i);
                    tbImageView2 = this.abw.get(i);
                }
                if (this.abx.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.abx.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.aby);
                    if ((this.abx.get(i) instanceof t) && !((t) this.abx.get(i)).qv()) {
                        t tVar = (t) this.abx.get(i);
                        y.b(tVar.qs(), tbImageView, tVar.qt(), k.g(this.context, w.f.ds24));
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
        if (this.abw != null && this.abw.size() > 0) {
            return this.abw.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.abw == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) x.c(this.abw, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((x.c(this.abx, i) instanceof t) && !((t) x.c(this.abx, i)).qv()) {
            RelativeLayout relativeLayout = (RelativeLayout) x.c(this.abA, i);
            TbImageView tbImageView = (TbImageView) x.c(this.abz, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.abB.ud() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, k.g(this.context, w.f.ds220) - k.g(this.context, w.f.ds24), 0, 0);
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
        if (this.abw != null && this.abw.size() > 0) {
            Iterator<TbImageView> it = this.abw.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
