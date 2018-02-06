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
    private View.OnClickListener aSv;
    private b aSy;
    private Context context;
    private ArrayList<TbImageView> aSt = new ArrayList<>();
    private ArrayList<T> aSu = new ArrayList<>();
    private ArrayList<TbImageView> aSw = new ArrayList<>();
    private ArrayList<RelativeLayout> aSx = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aSv = onClickListener;
    }

    public T fr(int i) {
        if (this.aSu == null || this.aSu.isEmpty() || i < 0 || i >= this.aSu.size()) {
            return null;
        }
        return this.aSu.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.aSy = bVar;
            this.aSu.clear();
            this.aSu.addAll(list);
            l(this.aSu);
            int size = this.aSt.size();
            int size2 = this.aSu.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView aI = bVar.aI(this.context);
                    this.aSt.add(aI);
                    tbImageView = bVar.aI(this.context);
                    this.aSw.add(tbImageView);
                    this.aSx.add(new RelativeLayout(this.context));
                    tbImageView2 = aI;
                } else {
                    tbImageView = this.aSw.get(i);
                    this.aSx.get(i);
                    tbImageView2 = this.aSt.get(i);
                }
                if (this.aSu.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.aSu.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.aSv);
                    if ((this.aSu.get(i) instanceof q) && !((q) this.aSu.get(i)).xZ()) {
                        q qVar = (q) this.aSu.get(i);
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
        if (this.aSt != null && this.aSt.size() > 0) {
            return this.aSt.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.aSt == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) v.f(this.aSt, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.f(this.aSu, i) instanceof q) && !((q) v.f(this.aSu, i)).xZ()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.f(this.aSx, i);
            TbImageView tbImageView = (TbImageView) v.f(this.aSw, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.aSy.Bh() == null) {
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
        if (this.aSt != null && this.aSt.size() > 0) {
            Iterator<TbImageView> it = this.aSt.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
