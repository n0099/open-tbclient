package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.recapp.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener WF;
    private b WI;
    private Context context;
    private ArrayList<TbImageView> WD = new ArrayList<>();
    private ArrayList<T> WE = new ArrayList<>();
    private ArrayList<TbImageView> WG = new ArrayList<>();
    private ArrayList<RelativeLayout> WH = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.WF = onClickListener;
    }

    public T ct(int i) {
        if (this.WE == null || this.WE.isEmpty() || i < 0 || i >= this.WE.size()) {
            return null;
        }
        return this.WE.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.WI = bVar;
            this.WE.clear();
            this.WE.addAll(list);
            k(this.WE);
            int size = this.WD.size();
            int size2 = this.WE.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView Q = bVar.Q(this.context);
                    this.WD.add(Q);
                    tbImageView = bVar.Q(this.context);
                    this.WG.add(tbImageView);
                    this.WH.add(new RelativeLayout(this.context));
                    tbImageView2 = Q;
                } else {
                    tbImageView = this.WG.get(i);
                    this.WH.get(i);
                    tbImageView2 = this.WD.get(i);
                }
                if (this.WE.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.WE.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.WF);
                    if ((this.WE.get(i) instanceof r) && !((r) this.WE.get(i)).pM()) {
                        r rVar = (r) this.WE.get(i);
                        l.b(rVar.pJ(), tbImageView, rVar.pK(), k.e(this.context, r.e.ds24));
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
        if (this.WD != null && this.WD.size() > 0) {
            return this.WD.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.WD == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) x.c(this.WD, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((x.c(this.WE, i) instanceof com.baidu.tbadk.core.data.r) && !((com.baidu.tbadk.core.data.r) x.c(this.WE, i)).pM()) {
            RelativeLayout relativeLayout = (RelativeLayout) x.c(this.WH, i);
            TbImageView tbImageView = (TbImageView) x.c(this.WG, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.WI.tp() == null) {
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

    public void tm() {
        if (this.WD != null && this.WD.size() > 0) {
            Iterator<TbImageView> it = this.WD.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
