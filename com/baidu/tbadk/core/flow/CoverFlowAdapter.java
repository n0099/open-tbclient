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
    private View.OnClickListener bFO;
    private a bFR;
    private Context context;
    private ArrayList<TbImageView> bFM = new ArrayList<>();
    private ArrayList<T> bFN = new ArrayList<>();
    private ArrayList<TbImageView> bFP = new ArrayList<>();
    private ArrayList<RelativeLayout> bFQ = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bFO = onClickListener;
    }

    public T gT(int i) {
        if (this.bFN == null || this.bFN.isEmpty() || i < 0 || i >= this.bFN.size()) {
            return null;
        }
        return this.bFN.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.bFR = aVar;
            this.bFN.clear();
            this.bFN.addAll(list);
            q(this.bFN);
            int size = this.bFM.size();
            int size2 = this.bFN.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView cG = aVar.cG(this.context);
                    this.bFM.add(cG);
                    tbImageView = aVar.cG(this.context);
                    this.bFP.add(tbImageView);
                    this.bFQ.add(new RelativeLayout(this.context));
                    tbImageView2 = cG;
                } else {
                    tbImageView = this.bFP.get(i);
                    this.bFQ.get(i);
                    tbImageView2 = this.bFM.get(i);
                }
                if (this.bFN.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.bFN.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.bFO);
                    if ((this.bFN.get(i) instanceof s) && !((s) this.bFN.get(i)).Xm()) {
                        s sVar = (s) this.bFN.get(i);
                        com.baidu.tieba.recapp.s.b(sVar.Xj(), tbImageView, sVar.Xk(), l.h(this.context, d.e.ds24));
                    }
                }
            }
            int S = v.S(this.bFN);
            int S2 = v.S(this.bFM);
            if (S2 > S) {
                v.d(this.bFM, S, S2);
            }
            int S3 = v.S(this.bFP);
            if (S3 > S) {
                v.d(this.bFP, S, S3);
            }
            int S4 = v.S(this.bFQ);
            if (S4 > S) {
                v.d(this.bFQ, S, S4);
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
        if (this.bFM != null && this.bFM.size() > 0) {
            return this.bFM.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.bFM == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.c(this.bFM, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.bFN, i) instanceof s) && !((s) v.c(this.bFN, i)).Xm()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.bFQ, i);
            TbImageView tbImageView2 = (TbImageView) v.c(this.bFP, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.bFR.abo() == null) {
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
        if (this.bFM != null && this.bFM.size() > 0) {
            Iterator<TbImageView> it = this.bFM.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
