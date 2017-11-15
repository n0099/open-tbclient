package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.t;
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
    private View.OnClickListener ack;
    private b acn;
    private Context context;
    private ArrayList<TbImageView> aci = new ArrayList<>();
    private ArrayList<T> acj = new ArrayList<>();
    private ArrayList<TbImageView> acl = new ArrayList<>();
    private ArrayList<RelativeLayout> acm = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ack = onClickListener;
    }

    public T ct(int i) {
        if (this.acj == null || this.acj.isEmpty() || i < 0 || i >= this.acj.size()) {
            return null;
        }
        return this.acj.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.acn = bVar;
            this.acj.clear();
            this.acj.addAll(list);
            k(this.acj);
            int size = this.aci.size();
            int size2 = this.acj.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView ay = bVar.ay(this.context);
                    this.aci.add(ay);
                    tbImageView = bVar.ay(this.context);
                    this.acl.add(tbImageView);
                    this.acm.add(new RelativeLayout(this.context));
                    tbImageView2 = ay;
                } else {
                    tbImageView = this.acl.get(i);
                    this.acm.get(i);
                    tbImageView2 = this.aci.get(i);
                }
                if (this.acj.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.acj.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.ack);
                    if ((this.acj.get(i) instanceof t) && !((t) this.acj.get(i)).pP()) {
                        t tVar = (t) this.acj.get(i);
                        s.b(tVar.pM(), tbImageView, tVar.pN(), l.f(this.context, d.e.ds24));
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
        if (this.aci != null && this.aci.size() > 0) {
            return this.aci.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.aci == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) v.c(this.aci, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.acj, i) instanceof t) && !((t) v.c(this.acj, i)).pP()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.acm, i);
            TbImageView tbImageView = (TbImageView) v.c(this.acl, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.acn.tv() == null) {
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
        if (this.aci != null && this.aci.size() > 0) {
            Iterator<TbImageView> it = this.aci.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
