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
    private View.OnClickListener aQR;
    private b aQU;
    private Context context;
    private ArrayList<TbImageView> aQP = new ArrayList<>();
    private ArrayList<T> aQQ = new ArrayList<>();
    private ArrayList<TbImageView> aQS = new ArrayList<>();
    private ArrayList<RelativeLayout> aQT = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aQR = onClickListener;
    }

    public T fr(int i) {
        if (this.aQQ == null || this.aQQ.isEmpty() || i < 0 || i >= this.aQQ.size()) {
            return null;
        }
        return this.aQQ.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.aQU = bVar;
            this.aQQ.clear();
            this.aQQ.addAll(list);
            l(this.aQQ);
            int size = this.aQP.size();
            int size2 = this.aQQ.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView aJ = bVar.aJ(this.context);
                    this.aQP.add(aJ);
                    tbImageView = bVar.aJ(this.context);
                    this.aQS.add(tbImageView);
                    this.aQT.add(new RelativeLayout(this.context));
                    tbImageView2 = aJ;
                } else {
                    tbImageView = this.aQS.get(i);
                    this.aQT.get(i);
                    tbImageView2 = this.aQP.get(i);
                }
                if (this.aQQ.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.aQQ.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.aQR);
                    if ((this.aQQ.get(i) instanceof q) && !((q) this.aQQ.get(i)).xt()) {
                        q qVar = (q) this.aQQ.get(i);
                        r.b(qVar.xq(), tbImageView, qVar.xr(), l.s(this.context, d.e.ds24));
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
        if (this.aQP != null && this.aQP.size() > 0) {
            return this.aQP.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.aQP == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) v.f(this.aQP, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.f(this.aQQ, i) instanceof q) && !((q) v.f(this.aQQ, i)).xt()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.f(this.aQT, i);
            TbImageView tbImageView = (TbImageView) v.f(this.aQS, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.aQU.AO() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.s(this.context, d.e.ds220) - l.s(this.context, d.e.ds24), 0, 0);
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
        if (this.aQP != null && this.aQP.size() > 0) {
            Iterator<TbImageView> it = this.aQP.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
