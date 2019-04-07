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
    private View.OnClickListener bFS;
    private a bFV;
    private Context context;
    private ArrayList<TbImageView> bFQ = new ArrayList<>();
    private ArrayList<T> bFR = new ArrayList<>();
    private ArrayList<TbImageView> bFT = new ArrayList<>();
    private ArrayList<RelativeLayout> bFU = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bFS = onClickListener;
    }

    public T gS(int i) {
        if (this.bFR == null || this.bFR.isEmpty() || i < 0 || i >= this.bFR.size()) {
            return null;
        }
        return this.bFR.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.bFV = aVar;
            this.bFR.clear();
            this.bFR.addAll(list);
            q(this.bFR);
            int size = this.bFQ.size();
            int size2 = this.bFR.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView cG = aVar.cG(this.context);
                    this.bFQ.add(cG);
                    tbImageView = aVar.cG(this.context);
                    this.bFT.add(tbImageView);
                    this.bFU.add(new RelativeLayout(this.context));
                    tbImageView2 = cG;
                } else {
                    tbImageView = this.bFT.get(i);
                    this.bFU.get(i);
                    tbImageView2 = this.bFQ.get(i);
                }
                if (this.bFR.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.bFR.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.bFS);
                    if ((this.bFR.get(i) instanceof s) && !((s) this.bFR.get(i)).Xj()) {
                        s sVar = (s) this.bFR.get(i);
                        com.baidu.tieba.recapp.s.b(sVar.Xg(), tbImageView, sVar.Xh(), l.h(this.context, d.e.ds24));
                    }
                }
            }
            int S = v.S(this.bFR);
            int S2 = v.S(this.bFQ);
            if (S2 > S) {
                v.d(this.bFQ, S, S2);
            }
            int S3 = v.S(this.bFT);
            if (S3 > S) {
                v.d(this.bFT, S, S3);
            }
            int S4 = v.S(this.bFU);
            if (S4 > S) {
                v.d(this.bFU, S, S4);
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
        if (this.bFQ != null && this.bFQ.size() > 0) {
            return this.bFQ.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.bFQ == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.c(this.bFQ, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.c(this.bFR, i) instanceof s) && !((s) v.c(this.bFR, i)).Xj()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.c(this.bFU, i);
            TbImageView tbImageView2 = (TbImageView) v.c(this.bFT, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.bFV.abl() == null) {
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
        if (this.bFQ != null && this.bFQ.size() > 0) {
            Iterator<TbImageView> it = this.bFQ.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
