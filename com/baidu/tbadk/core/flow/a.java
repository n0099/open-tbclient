package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import com.baidu.tieba.recapp.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener VV;
    private b VY;
    private Context context;
    private ArrayList<TbImageView> VT = new ArrayList<>();
    private ArrayList<T> VU = new ArrayList<>();
    private ArrayList<TbImageView> VW = new ArrayList<>();
    private ArrayList<RelativeLayout> VX = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.VV = onClickListener;
    }

    public T cs(int i) {
        if (this.VU == null || this.VU.isEmpty() || i < 0 || i >= this.VU.size()) {
            return null;
        }
        return this.VU.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.VY = bVar;
            this.VU.clear();
            this.VU.addAll(list);
            k(this.VU);
            int size = this.VT.size();
            int size2 = this.VU.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView S = bVar.S(this.context);
                    this.VT.add(S);
                    tbImageView = bVar.S(this.context);
                    this.VW.add(tbImageView);
                    this.VX.add(new RelativeLayout(this.context));
                    tbImageView2 = S;
                } else {
                    tbImageView = this.VW.get(i);
                    this.VX.get(i);
                    tbImageView2 = this.VT.get(i);
                }
                if (this.VU.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.VU.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.VV);
                    if ((this.VU.get(i) instanceof s) && !((s) this.VU.get(i)).pF()) {
                        s sVar = (s) this.VU.get(i);
                        r.b(sVar.pC(), tbImageView, sVar.pD(), k.e(this.context, r.f.ds24));
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
        if (this.VT != null && this.VT.size() > 0) {
            return this.VT.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.VT == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) w.c(this.VT, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((w.c(this.VU, i) instanceof s) && !((s) w.c(this.VU, i)).pF()) {
            RelativeLayout relativeLayout = (RelativeLayout) w.c(this.VX, i);
            TbImageView tbImageView = (TbImageView) w.c(this.VW, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.VY.tj() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, k.e(this.context, r.f.ds220) - k.e(this.context, r.f.ds24), 0, 0);
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

    public void tg() {
        if (this.VT != null && this.VT.size() > 0) {
            Iterator<TbImageView> it = this.VT.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
