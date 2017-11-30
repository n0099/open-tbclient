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
    private View.OnClickListener acF;
    private b acI;
    private Context context;
    private ArrayList<TbImageView> acD = new ArrayList<>();
    private ArrayList<T> acE = new ArrayList<>();
    private ArrayList<TbImageView> acG = new ArrayList<>();
    private ArrayList<RelativeLayout> acH = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.acF = onClickListener;
    }

    public T cu(int i) {
        if (this.acE == null || this.acE.isEmpty() || i < 0 || i >= this.acE.size()) {
            return null;
        }
        return this.acE.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.acI = bVar;
            this.acE.clear();
            this.acE.addAll(list);
            k(this.acE);
            int size = this.acD.size();
            int size2 = this.acE.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView aA = bVar.aA(this.context);
                    this.acD.add(aA);
                    tbImageView = bVar.aA(this.context);
                    this.acG.add(tbImageView);
                    this.acH.add(new RelativeLayout(this.context));
                    tbImageView2 = aA;
                } else {
                    tbImageView = this.acG.get(i);
                    this.acH.get(i);
                    tbImageView2 = this.acD.get(i);
                }
                if (this.acE.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.acE.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.acF);
                    if ((this.acE.get(i) instanceof q) && !((q) this.acE.get(i)).pS()) {
                        q qVar = (q) this.acE.get(i);
                        r.b(qVar.pP(), tbImageView, qVar.pQ(), l.f(this.context, d.e.ds24));
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
        if (this.acD != null && this.acD.size() > 0) {
            return this.acD.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.acD == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) v.c(this.acD, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.acE, i) instanceof q) && !((q) v.c(this.acE, i)).pS()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.acH, i);
            TbImageView tbImageView = (TbImageView) v.c(this.acG, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.acI.ty() == null) {
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
        if (this.acD != null && this.acD.size() > 0) {
            Iterator<TbImageView> it = this.acD.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
