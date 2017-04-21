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
    private b abC;
    private View.OnClickListener abz;
    private Context context;
    private ArrayList<TbImageView> abx = new ArrayList<>();
    private ArrayList<T> aby = new ArrayList<>();
    private ArrayList<TbImageView> abA = new ArrayList<>();
    private ArrayList<RelativeLayout> abB = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.abz = onClickListener;
    }

    public T cr(int i) {
        if (this.aby == null || this.aby.isEmpty() || i < 0 || i >= this.aby.size()) {
            return null;
        }
        return this.aby.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.abC = bVar;
            this.aby.clear();
            this.aby.addAll(list);
            j(this.aby);
            int size = this.abx.size();
            int size2 = this.aby.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView as = bVar.as(this.context);
                    this.abx.add(as);
                    tbImageView = bVar.as(this.context);
                    this.abA.add(tbImageView);
                    this.abB.add(new RelativeLayout(this.context));
                    tbImageView2 = as;
                } else {
                    tbImageView = this.abA.get(i);
                    this.abB.get(i);
                    tbImageView2 = this.abx.get(i);
                }
                if (this.aby.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.aby.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.abz);
                    if ((this.aby.get(i) instanceof t) && !((t) this.aby.get(i)).qv()) {
                        t tVar = (t) this.aby.get(i);
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
        if (this.abx != null && this.abx.size() > 0) {
            return this.abx.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.abx == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) x.c(this.abx, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((x.c(this.aby, i) instanceof t) && !((t) x.c(this.aby, i)).qv()) {
            RelativeLayout relativeLayout = (RelativeLayout) x.c(this.abB, i);
            TbImageView tbImageView = (TbImageView) x.c(this.abA, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.abC.ud() == null) {
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
        if (this.abx != null && this.abx.size() > 0) {
            Iterator<TbImageView> it = this.abx.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
