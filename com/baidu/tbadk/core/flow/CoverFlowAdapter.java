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
    private View.OnClickListener atS;
    private a atV;
    private Context context;
    private ArrayList<TbImageView> atQ = new ArrayList<>();
    private ArrayList<T> atR = new ArrayList<>();
    private ArrayList<TbImageView> atT = new ArrayList<>();
    private ArrayList<RelativeLayout> atU = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.atS = onClickListener;
    }

    public T dd(int i) {
        if (this.atR == null || this.atR.isEmpty() || i < 0 || i >= this.atR.size()) {
            return null;
        }
        return this.atR.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.atV = aVar;
            this.atR.clear();
            this.atR.addAll(list);
            o(this.atR);
            int size = this.atQ.size();
            int size2 = this.atR.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView bp = aVar.bp(this.context);
                    this.atQ.add(bp);
                    tbImageView = aVar.bp(this.context);
                    this.atT.add(tbImageView);
                    this.atU.add(new RelativeLayout(this.context));
                    tbImageView2 = bp;
                } else {
                    tbImageView = this.atT.get(i);
                    this.atU.get(i);
                    tbImageView2 = this.atQ.get(i);
                }
                if (this.atR.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.atR.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.atS);
                    if ((this.atR.get(i) instanceof q) && !((q) this.atR.get(i)).xm()) {
                        q qVar = (q) this.atR.get(i);
                        s.b(qVar.xj(), tbImageView, qVar.xk(), l.h(this.context, e.C0200e.ds24));
                    }
                }
            }
            int H = v.H(this.atR);
            int H2 = v.H(this.atQ);
            if (H2 > H) {
                v.c(this.atQ, H, H2);
            }
            int H3 = v.H(this.atT);
            if (H3 > H) {
                v.c(this.atT, H, H3);
            }
            int H4 = v.H(this.atU);
            if (H4 > H) {
                v.c(this.atU, H, H4);
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
        if (this.atQ != null && this.atQ.size() > 0) {
            return this.atQ.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.atQ == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.d(this.atQ, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.d(this.atR, i) instanceof q) && !((q) v.d(this.atR, i)).xm()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.d(this.atU, i);
            TbImageView tbImageView2 = (TbImageView) v.d(this.atT, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.atV.AN() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.h(this.context, e.C0200e.ds220) - l.h(this.context, e.C0200e.ds24), 0, 0);
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
        if (this.atQ != null && this.atQ.size() > 0) {
            Iterator<TbImageView> it = this.atQ.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
