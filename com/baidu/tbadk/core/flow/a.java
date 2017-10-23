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
    private View.OnClickListener abM;
    private b abP;
    private Context context;
    private ArrayList<TbImageView> abK = new ArrayList<>();
    private ArrayList<T> abL = new ArrayList<>();
    private ArrayList<TbImageView> abN = new ArrayList<>();
    private ArrayList<RelativeLayout> abO = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.abM = onClickListener;
    }

    public T ct(int i) {
        if (this.abL == null || this.abL.isEmpty() || i < 0 || i >= this.abL.size()) {
            return null;
        }
        return this.abL.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.abP = bVar;
            this.abL.clear();
            this.abL.addAll(list);
            j(this.abL);
            int size = this.abK.size();
            int size2 = this.abL.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView ay = bVar.ay(this.context);
                    this.abK.add(ay);
                    tbImageView = bVar.ay(this.context);
                    this.abN.add(tbImageView);
                    this.abO.add(new RelativeLayout(this.context));
                    tbImageView2 = ay;
                } else {
                    tbImageView = this.abN.get(i);
                    this.abO.get(i);
                    tbImageView2 = this.abK.get(i);
                }
                if (this.abL.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.abL.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.abM);
                    if ((this.abL.get(i) instanceof t) && !((t) this.abL.get(i)).pK()) {
                        t tVar = (t) this.abL.get(i);
                        s.b(tVar.pH(), tbImageView, tVar.pI(), l.f(this.context, d.f.ds24));
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
        if (this.abK != null && this.abK.size() > 0) {
            return this.abK.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.abK == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) v.c(this.abK, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.abL, i) instanceof t) && !((t) v.c(this.abL, i)).pK()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.abO, i);
            TbImageView tbImageView = (TbImageView) v.c(this.abN, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.abP.to() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.f(this.context, d.f.ds220) - l.f(this.context, d.f.ds24), 0, 0);
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
        if (this.abK != null && this.abK.size() > 0) {
            Iterator<TbImageView> it = this.abK.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
