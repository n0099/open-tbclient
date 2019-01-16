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
    private View.OnClickListener axV;
    private a axY;
    private Context context;
    private ArrayList<TbImageView> axT = new ArrayList<>();
    private ArrayList<T> axU = new ArrayList<>();
    private ArrayList<TbImageView> axW = new ArrayList<>();
    private ArrayList<RelativeLayout> axX = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.axV = onClickListener;
    }

    public T dr(int i) {
        if (this.axU == null || this.axU.isEmpty() || i < 0 || i >= this.axU.size()) {
            return null;
        }
        return this.axU.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.axY = aVar;
            this.axU.clear();
            this.axU.addAll(list);
            o(this.axU);
            int size = this.axT.size();
            int size2 = this.axU.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView bs = aVar.bs(this.context);
                    this.axT.add(bs);
                    tbImageView = aVar.bs(this.context);
                    this.axW.add(tbImageView);
                    this.axX.add(new RelativeLayout(this.context));
                    tbImageView2 = bs;
                } else {
                    tbImageView = this.axW.get(i);
                    this.axX.get(i);
                    tbImageView2 = this.axT.get(i);
                }
                if (this.axU.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.axU.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.axV);
                    if ((this.axU.get(i) instanceof q) && !((q) this.axU.get(i)).yE()) {
                        q qVar = (q) this.axU.get(i);
                        s.b(qVar.yB(), tbImageView, qVar.yC(), l.h(this.context, e.C0210e.ds24));
                    }
                }
            }
            int H = v.H(this.axU);
            int H2 = v.H(this.axT);
            if (H2 > H) {
                v.c(this.axT, H, H2);
            }
            int H3 = v.H(this.axW);
            if (H3 > H) {
                v.c(this.axW, H, H3);
            }
            int H4 = v.H(this.axX);
            if (H4 > H) {
                v.c(this.axX, H, H4);
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
        if (this.axT != null && this.axT.size() > 0) {
            return this.axT.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.axT == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.d(this.axT, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.d(this.axU, i) instanceof q) && !((q) v.d(this.axU, i)).yE()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.d(this.axX, i);
            TbImageView tbImageView2 = (TbImageView) v.d(this.axW, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.axY.Ce() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.h(this.context, e.C0210e.ds220) - l.h(this.context, e.C0210e.ds24), 0, 0);
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
        if (this.axT != null && this.axT.size() > 0) {
            Iterator<TbImageView> it = this.axT.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
