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
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener acQ;
    private b acT;
    private Context context;
    private ArrayList<TbImageView> acO = new ArrayList<>();
    private ArrayList<T> acP = new ArrayList<>();
    private ArrayList<TbImageView> acR = new ArrayList<>();
    private ArrayList<RelativeLayout> acS = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.acQ = onClickListener;
    }

    public T cu(int i) {
        if (this.acP == null || this.acP.isEmpty() || i < 0 || i >= this.acP.size()) {
            return null;
        }
        return this.acP.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.acT = bVar;
            this.acP.clear();
            this.acP.addAll(list);
            j(this.acP);
            int size = this.acO.size();
            int size2 = this.acP.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView at = bVar.at(this.context);
                    this.acO.add(at);
                    tbImageView = bVar.at(this.context);
                    this.acR.add(tbImageView);
                    this.acS.add(new RelativeLayout(this.context));
                    tbImageView2 = at;
                } else {
                    tbImageView = this.acR.get(i);
                    this.acS.get(i);
                    tbImageView2 = this.acO.get(i);
                }
                if (this.acP.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.acP.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.acQ);
                    if ((this.acP.get(i) instanceof t) && !((t) this.acP.get(i)).pV()) {
                        t tVar = (t) this.acP.get(i);
                        s.b(tVar.pS(), tbImageView, tVar.pT(), k.g(this.context, d.f.ds24));
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
        if (this.acO != null && this.acO.size() > 0) {
            return this.acO.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.acO == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) u.c(this.acO, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((u.c(this.acP, i) instanceof t) && !((t) u.c(this.acP, i)).pV()) {
            RelativeLayout relativeLayout = (RelativeLayout) u.c(this.acS, i);
            TbImageView tbImageView = (TbImageView) u.c(this.acR, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.acT.tF() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, k.g(this.context, d.f.ds220) - k.g(this.context, d.f.ds24), 0, 0);
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
        if (this.acO != null && this.acO.size() > 0) {
            Iterator<TbImageView> it = this.acO.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
