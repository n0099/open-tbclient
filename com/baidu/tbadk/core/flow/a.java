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
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener abi;
    private b abl;
    private Context context;
    private ArrayList<TbImageView> abg = new ArrayList<>();
    private ArrayList<T> abh = new ArrayList<>();
    private ArrayList<TbImageView> abj = new ArrayList<>();
    private ArrayList<RelativeLayout> abk = new ArrayList<>();

    public a(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.abi = onClickListener;
    }

    public T co(int i) {
        if (this.abh == null || this.abh.isEmpty() || i < 0 || i >= this.abh.size()) {
            return null;
        }
        return this.abh.get(i);
    }

    public void a(List<T> list, b bVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.abl = bVar;
            this.abh.clear();
            this.abh.addAll(list);
            j(this.abh);
            int size = this.abg.size();
            int size2 = this.abh.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView aq = bVar.aq(this.context);
                    this.abg.add(aq);
                    tbImageView = bVar.aq(this.context);
                    this.abj.add(tbImageView);
                    this.abk.add(new RelativeLayout(this.context));
                    tbImageView2 = aq;
                } else {
                    tbImageView = this.abj.get(i);
                    this.abk.get(i);
                    tbImageView2 = this.abg.get(i);
                }
                if (this.abh.get(i) != null && tbImageView2 != null) {
                    tbImageView2.c(this.abh.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.abi);
                    if ((this.abh.get(i) instanceof t) && !((t) this.abh.get(i)).pX()) {
                        t tVar = (t) this.abh.get(i);
                        com.baidu.tieba.recapp.t.b(tVar.pU(), tbImageView, tVar.pV(), k.g(this.context, w.f.ds24));
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
        if (this.abg != null && this.abg.size() > 0) {
            return this.abg.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.abg == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ImageView imageView = (ImageView) x.c(this.abg, i);
        if (imageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((x.c(this.abh, i) instanceof t) && !((t) x.c(this.abh, i)).pX()) {
            RelativeLayout relativeLayout = (RelativeLayout) x.c(this.abk, i);
            TbImageView tbImageView = (TbImageView) x.c(this.abj, i);
            relativeLayout.removeView(tbImageView);
            if (imageView.getParent() != null) {
                ((ViewGroup) imageView.getParent()).removeView(imageView);
            }
            relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.abl.tG() == null) {
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

    public void tD() {
        if (this.abg != null && this.abg.size() > 0) {
            Iterator<TbImageView> it = this.abg.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }
}
