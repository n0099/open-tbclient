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
    private View.OnClickListener atf;
    private a ati;
    private Context context;
    private ArrayList<TbImageView> atd = new ArrayList<>();
    private ArrayList<T> ate = new ArrayList<>();
    private ArrayList<TbImageView> atg = new ArrayList<>();
    private ArrayList<RelativeLayout> ath = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.atf = onClickListener;
    }

    public T cP(int i) {
        if (this.ate == null || this.ate.isEmpty() || i < 0 || i >= this.ate.size()) {
            return null;
        }
        return this.ate.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.ati = aVar;
            this.ate.clear();
            this.ate.addAll(list);
            o(this.ate);
            int size = this.atd.size();
            int size2 = this.ate.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView br = aVar.br(this.context);
                    this.atd.add(br);
                    tbImageView = aVar.br(this.context);
                    this.atg.add(tbImageView);
                    this.ath.add(new RelativeLayout(this.context));
                    tbImageView2 = br;
                } else {
                    tbImageView = this.atg.get(i);
                    this.ath.get(i);
                    tbImageView2 = this.atd.get(i);
                }
                if (this.ate.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.ate.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.atf);
                    if ((this.ate.get(i) instanceof q) && !((q) this.ate.get(i)).xe()) {
                        q qVar = (q) this.ate.get(i);
                        s.b(qVar.xb(), tbImageView, qVar.xc(), l.h(this.context, e.C0175e.ds24));
                    }
                }
            }
            int I = v.I(this.ate);
            int I2 = v.I(this.atd);
            if (I2 > I) {
                v.c(this.atd, I, I2);
            }
            int I3 = v.I(this.atg);
            if (I3 > I) {
                v.c(this.atg, I, I3);
            }
            int I4 = v.I(this.ath);
            if (I4 > I) {
                v.c(this.ath, I, I4);
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
        if (this.atd != null && this.atd.size() > 0) {
            return this.atd.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.atd == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.d(this.atd, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.d(this.ate, i) instanceof q) && !((q) v.d(this.ate, i)).xe()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.d(this.ath, i);
            TbImageView tbImageView2 = (TbImageView) v.d(this.atg, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.ati.AG() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.h(this.context, e.C0175e.ds220) - l.h(this.context, e.C0175e.ds24), 0, 0);
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
        if (this.atd != null && this.atd.size() > 0) {
            Iterator<TbImageView> it = this.atd.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
