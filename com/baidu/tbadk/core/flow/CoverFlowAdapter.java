package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener bNt;
    private a bNw;
    private Context context;
    private ArrayList<TbImageView> bNr = new ArrayList<>();
    private ArrayList<T> bNs = new ArrayList<>();
    private ArrayList<TbImageView> bNu = new ArrayList<>();
    private ArrayList<RelativeLayout> bNv = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bNt = onClickListener;
    }

    public T hG(int i) {
        if (this.bNs == null || this.bNs.isEmpty() || i < 0 || i >= this.bNs.size()) {
            return null;
        }
        return this.bNs.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.bNw = aVar;
            this.bNs.clear();
            this.bNs.addAll(list);
            t(this.bNs);
            int size = this.bNr.size();
            int size2 = this.bNs.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView cl = aVar.cl(this.context);
                    this.bNr.add(cl);
                    tbImageView = aVar.cl(this.context);
                    this.bNu.add(tbImageView);
                    this.bNv.add(new RelativeLayout(this.context));
                    tbImageView2 = cl;
                } else {
                    tbImageView = this.bNu.get(i);
                    this.bNv.get(i);
                    tbImageView2 = this.bNr.get(i);
                }
                if (this.bNs.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.bNs.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.bNt);
                    if ((this.bNs.get(i) instanceof s) && !((s) this.bNs.get(i)).abR()) {
                        s sVar = (s) this.bNs.get(i);
                        com.baidu.tieba.recapp.s.b(sVar.abO(), tbImageView, sVar.abP(), l.g(this.context, R.dimen.ds24));
                    }
                }
            }
            int Z = v.Z(this.bNs);
            int Z2 = v.Z(this.bNr);
            if (Z2 > Z) {
                v.d(this.bNr, Z, Z2);
            }
            int Z3 = v.Z(this.bNu);
            if (Z3 > Z) {
                v.d(this.bNu, Z, Z3);
            }
            int Z4 = v.Z(this.bNv);
            if (Z4 > Z) {
                v.d(this.bNv, Z, Z4);
            }
            notifyDataSetChanged();
        }
    }

    private void t(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.bNr != null && this.bNr.size() > 0) {
            return this.bNr.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.bNr == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.c(this.bNr, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.bNs, i) instanceof s) && !((s) v.c(this.bNs, i)).abR()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.bNv, i);
            TbImageView tbImageView2 = (TbImageView) v.c(this.bNu, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.bNw.agd() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.g(this.context, R.dimen.ds220) - l.g(this.context, R.dimen.ds24), 0, 0);
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
        if (this.bNr != null && this.bNr.size() > 0) {
            Iterator<TbImageView> it = this.bNr.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
