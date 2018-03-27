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
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener aSm;
    private b aSp;
    private Context context;
    private ArrayList<TbImageView> aSk = new ArrayList<>();
    private ArrayList<T> aSl = new ArrayList<>();
    private ArrayList<TbImageView> aSn = new ArrayList<>();
    private ArrayList<RelativeLayout> aSo = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aSm = onClickListener;
    }

    public T fr(int i) {
        if (this.aSl == null || this.aSl.isEmpty() || i < 0 || i >= this.aSl.size()) {
            return null;
        }
        return this.aSl.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.aSp = bVar;
            this.aSl.clear();
            this.aSl.addAll(list);
            l(this.aSl);
            int size = this.aSk.size();
            int size2 = this.aSl.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView aI = bVar.aI(this.context);
                    this.aSk.add(aI);
                    tbImageView = bVar.aI(this.context);
                    this.aSn.add(tbImageView);
                    this.aSo.add(new RelativeLayout(this.context));
                    tbImageView2 = aI;
                } else {
                    tbImageView = this.aSn.get(i);
                    this.aSo.get(i);
                    tbImageView2 = this.aSk.get(i);
                }
                if (this.aSl.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.aSl.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.aSm);
                    if ((this.aSl.get(i) instanceof q) && !((q) this.aSl.get(i)).xZ()) {
                        q qVar = (q) this.aSl.get(i);
                        s.b(qVar.xW(), tbImageView, qVar.xX(), l.t(this.context, d.e.ds24));
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    private void l(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.aSk != null && this.aSk.size() > 0) {
            return this.aSk.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.aSk == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) v.f(this.aSk, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.f(this.aSl, i) instanceof q) && !((q) v.f(this.aSl, i)).xZ()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.f(this.aSo, i);
            TbImageView tbImageView = (TbImageView) v.f(this.aSn, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.aSp.Bi() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.t(this.context, d.e.ds220) - l.t(this.context, d.e.ds24), 0, 0);
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
        if (this.aSk != null && this.aSk.size() > 0) {
            Iterator<TbImageView> it = this.aSk.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
