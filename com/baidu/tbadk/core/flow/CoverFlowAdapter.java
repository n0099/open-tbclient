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
    private View.OnClickListener axt;
    private a axw;
    private Context context;
    private ArrayList<TbImageView> axr = new ArrayList<>();
    private ArrayList<T> axs = new ArrayList<>();
    private ArrayList<TbImageView> axu = new ArrayList<>();
    private ArrayList<RelativeLayout> axv = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.axt = onClickListener;
    }

    public T dr(int i) {
        if (this.axs == null || this.axs.isEmpty() || i < 0 || i >= this.axs.size()) {
            return null;
        }
        return this.axs.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.axw = aVar;
            this.axs.clear();
            this.axs.addAll(list);
            o(this.axs);
            int size = this.axr.size();
            int size2 = this.axs.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView bs = aVar.bs(this.context);
                    this.axr.add(bs);
                    tbImageView = aVar.bs(this.context);
                    this.axu.add(tbImageView);
                    this.axv.add(new RelativeLayout(this.context));
                    tbImageView2 = bs;
                } else {
                    tbImageView = this.axu.get(i);
                    this.axv.get(i);
                    tbImageView2 = this.axr.get(i);
                }
                if (this.axs.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.axs.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.axt);
                    if ((this.axs.get(i) instanceof q) && !((q) this.axs.get(i)).yr()) {
                        q qVar = (q) this.axs.get(i);
                        s.b(qVar.yo(), tbImageView, qVar.yp(), l.h(this.context, e.C0210e.ds24));
                    }
                }
            }
            int H = v.H(this.axs);
            int H2 = v.H(this.axr);
            if (H2 > H) {
                v.c(this.axr, H, H2);
            }
            int H3 = v.H(this.axu);
            if (H3 > H) {
                v.c(this.axu, H, H3);
            }
            int H4 = v.H(this.axv);
            if (H4 > H) {
                v.c(this.axv, H, H4);
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
        if (this.axr != null && this.axr.size() > 0) {
            return this.axr.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.axr == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) v.d(this.axr, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((v.d(this.axs, i) instanceof q) && !((q) v.d(this.axs, i)).yr()) {
            RelativeLayout relativeLayout = (RelativeLayout) v.d(this.axv, i);
            TbImageView tbImageView2 = (TbImageView) v.d(this.axu, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.axw.BR() == null) {
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
        if (this.axr != null && this.axr.size() > 0) {
            Iterator<TbImageView> it = this.axr.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
