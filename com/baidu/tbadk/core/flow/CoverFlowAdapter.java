package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener alJ;
    private a alM;
    private Context context;
    private ArrayList<TbImageView> alH = new ArrayList<>();
    private ArrayList<T> alI = new ArrayList<>();
    private ArrayList<TbImageView> alK = new ArrayList<>();
    private ArrayList<RelativeLayout> alL = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.alJ = onClickListener;
    }

    public T cs(int i) {
        if (this.alI == null || this.alI.isEmpty() || i < 0 || i >= this.alI.size()) {
            return null;
        }
        return this.alI.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.alM = aVar;
            this.alI.clear();
            this.alI.addAll(list);
            k(this.alI);
            int size = this.alH.size();
            int size2 = this.alI.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView aC = aVar.aC(this.context);
                    this.alH.add(aC);
                    tbImageView = aVar.aC(this.context);
                    this.alK.add(tbImageView);
                    this.alL.add(new RelativeLayout(this.context));
                    tbImageView2 = aC;
                } else {
                    tbImageView = this.alK.get(i);
                    this.alL.get(i);
                    tbImageView2 = this.alH.get(i);
                }
                if (this.alI.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.alI.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.alJ);
                    if ((this.alI.get(i) instanceof r) && !((r) this.alI.get(i)).ua()) {
                        r rVar = (r) this.alI.get(i);
                        s.b(rVar.tX(), tbImageView, rVar.tY(), l.e(this.context, d.e.ds24));
                    }
                }
            }
            int y = w.y(this.alI);
            int y2 = w.y(this.alH);
            if (y2 > y) {
                w.b(this.alH, y, y2);
            }
            int y3 = w.y(this.alK);
            if (y3 > y) {
                w.b(this.alK, y, y3);
            }
            int y4 = w.y(this.alL);
            if (y4 > y) {
                w.b(this.alL, y, y4);
            }
            notifyDataSetChanged();
        }
    }

    private void k(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.alH != null && this.alH.size() > 0) {
            return this.alH.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.alH == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) w.c(this.alH, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((w.c(this.alI, i) instanceof r) && !((r) w.c(this.alI, i)).ua()) {
            RelativeLayout relativeLayout = (RelativeLayout) w.c(this.alL, i);
            TbImageView tbImageView2 = (TbImageView) w.c(this.alK, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.alM.xn() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.e(this.context, d.e.ds220) - l.e(this.context, d.e.ds24), 0, 0);
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
        if (this.alH != null && this.alH.size() > 0) {
            Iterator<TbImageView> it = this.alH.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
