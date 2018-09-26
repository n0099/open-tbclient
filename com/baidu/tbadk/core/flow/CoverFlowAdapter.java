package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener aon;
    private a aoq;
    private Context context;
    private ArrayList<TbImageView> aol = new ArrayList<>();
    private ArrayList<T> aom = new ArrayList<>();
    private ArrayList<TbImageView> aoo = new ArrayList<>();
    private ArrayList<RelativeLayout> aop = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aon = onClickListener;
    }

    public T cF(int i) {
        if (this.aom == null || this.aom.isEmpty() || i < 0 || i >= this.aom.size()) {
            return null;
        }
        return this.aom.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.aoq = aVar;
            this.aom.clear();
            this.aom.addAll(list);
            o(this.aom);
            int size = this.aol.size();
            int size2 = this.aom.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView bi = aVar.bi(this.context);
                    this.aol.add(bi);
                    tbImageView = aVar.bi(this.context);
                    this.aoo.add(tbImageView);
                    this.aop.add(new RelativeLayout(this.context));
                    tbImageView2 = bi;
                } else {
                    tbImageView = this.aoo.get(i);
                    this.aop.get(i);
                    tbImageView2 = this.aol.get(i);
                }
                if (this.aom.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.aom.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.aon);
                    if ((this.aom.get(i) instanceof q) && !((q) this.aom.get(i)).uV()) {
                        q qVar = (q) this.aom.get(i);
                        s.b(qVar.uS(), tbImageView, qVar.uT(), l.h(this.context, e.C0141e.ds24));
                    }
                }
            }
            int y = v.y(this.aom);
            int y2 = v.y(this.aol);
            if (y2 > y) {
                v.c(this.aol, y, y2);
            }
            int y3 = v.y(this.aoo);
            if (y3 > y) {
                v.c(this.aoo, y, y3);
            }
            int y4 = v.y(this.aop);
            if (y4 > y) {
                v.c(this.aop, y, y4);
            }
            notifyDataSetChanged();
        }
    }

    private void o(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.aol != null && this.aol.size() > 0) {
            return this.aol.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.aol == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.d(this.aol, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.d(this.aom, i) instanceof q) && !((q) v.d(this.aom, i)).uV()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.d(this.aop, i);
            TbImageView tbImageView2 = (TbImageView) v.d(this.aoo, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.aoq.yy() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.h(this.context, e.C0141e.ds220) - l.h(this.context, e.C0141e.ds24), 0, 0);
            }
            relativeLayout.addView(tbImageView2, layoutParams);
            if (relativeLayout.getParent() == null) {
                viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
            }
            tbImageView.setTag(Integer.valueOf(i));
            return relativeLayout;
        }
        if (tbImageView.getParent() != null) {
            ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
        }
        if (tbImageView.getParent() == null) {
            viewGroup.addView(tbImageView, new ViewGroup.LayoutParams(-1, -1));
        }
        tbImageView.setTag(Integer.valueOf(i));
        tbImageView.refresh();
        return tbImageView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void onChangeSkinType() {
        if (this.aol != null && this.aol.size() > 0) {
            Iterator<TbImageView> it = this.aol.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
