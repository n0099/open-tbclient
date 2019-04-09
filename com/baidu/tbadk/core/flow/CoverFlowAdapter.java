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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener bFT;
    private a bFW;
    private Context context;
    private ArrayList<TbImageView> bFR = new ArrayList<>();
    private ArrayList<T> bFS = new ArrayList<>();
    private ArrayList<TbImageView> bFU = new ArrayList<>();
    private ArrayList<RelativeLayout> bFV = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bFT = onClickListener;
    }

    public T gS(int i) {
        if (this.bFS == null || this.bFS.isEmpty() || i < 0 || i >= this.bFS.size()) {
            return null;
        }
        return this.bFS.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.bFW = aVar;
            this.bFS.clear();
            this.bFS.addAll(list);
            q(this.bFS);
            int size = this.bFR.size();
            int size2 = this.bFS.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView cG = aVar.cG(this.context);
                    this.bFR.add(cG);
                    tbImageView = aVar.cG(this.context);
                    this.bFU.add(tbImageView);
                    this.bFV.add(new RelativeLayout(this.context));
                    tbImageView2 = cG;
                } else {
                    tbImageView = this.bFU.get(i);
                    this.bFV.get(i);
                    tbImageView2 = this.bFR.get(i);
                }
                if (this.bFS.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.bFS.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.bFT);
                    if ((this.bFS.get(i) instanceof s) && !((s) this.bFS.get(i)).Xj()) {
                        s sVar = (s) this.bFS.get(i);
                        com.baidu.tieba.recapp.s.b(sVar.Xg(), tbImageView, sVar.Xh(), l.h(this.context, d.e.ds24));
                    }
                }
            }
            int S = v.S(this.bFS);
            int S2 = v.S(this.bFR);
            if (S2 > S) {
                v.d(this.bFR, S, S2);
            }
            int S3 = v.S(this.bFU);
            if (S3 > S) {
                v.d(this.bFU, S, S3);
            }
            int S4 = v.S(this.bFV);
            if (S4 > S) {
                v.d(this.bFV, S, S4);
            }
            notifyDataSetChanged();
        }
    }

    private void q(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.bFR != null && this.bFR.size() > 0) {
            return this.bFR.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.bFR == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.c(this.bFR, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.bFS, i) instanceof s) && !((s) v.c(this.bFS, i)).Xj()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.bFV, i);
            TbImageView tbImageView2 = (TbImageView) v.c(this.bFU, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.bFW.abl() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.h(this.context, d.e.ds220) - l.h(this.context, d.e.ds24), 0, 0);
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
        if (this.bFR != null && this.bFR.size() > 0) {
            Iterator<TbImageView> it = this.bFR.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
