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
import com.baidu.tieba.recapp.aa;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener aaT;
    private b aaW;
    private Context context;
    private ArrayList<TbImageView> aaR = new ArrayList<>();
    private ArrayList<T> aaS = new ArrayList<>();
    private ArrayList<TbImageView> aaU = new ArrayList<>();
    private ArrayList<RelativeLayout> aaV = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aaT = onClickListener;
    }

    public T cp(int i) {
        if (this.aaS == null || this.aaS.isEmpty() || i < 0 || i >= this.aaS.size()) {
            return null;
        }
        return this.aaS.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.aaW = bVar;
            this.aaS.clear();
            this.aaS.addAll(list);
            j(this.aaS);
            int size = this.aaR.size();
            int size2 = this.aaS.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView as = bVar.as(this.context);
                    this.aaR.add(as);
                    tbImageView = bVar.as(this.context);
                    this.aaU.add(tbImageView);
                    this.aaV.add(new RelativeLayout(this.context));
                    tbImageView2 = as;
                } else {
                    tbImageView = this.aaU.get(i);
                    this.aaV.get(i);
                    tbImageView2 = this.aaR.get(i);
                }
                if (this.aaS.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.aaS.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.aaT);
                    if ((this.aaS.get(i) instanceof t) && !((t) this.aaS.get(i)).pS()) {
                        t tVar = (t) this.aaS.get(i);
                        aa.b(tVar.pP(), tbImageView, tVar.pQ(), k.g(this.context, w.f.ds24));
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
        if (this.aaR != null && this.aaR.size() > 0) {
            return this.aaR.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.aaR == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) x.c(this.aaR, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((x.c(this.aaS, i) instanceof t) && !((t) x.c(this.aaS, i)).pS()) {
            RelativeLayout relativeLayout = (RelativeLayout) x.c(this.aaV, i);
            TbImageView tbImageView = (TbImageView) x.c(this.aaU, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.aaW.tq() == null) {
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
        if (this.aaR != null && this.aaR.size() > 0) {
            Iterator<TbImageView> it = this.aaR.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
