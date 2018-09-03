package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private View.OnClickListener alI;
    private a alL;
    private Context context;
    private ArrayList<TbImageView> alG = new ArrayList<>();
    private ArrayList<T> alH = new ArrayList<>();
    private ArrayList<TbImageView> alJ = new ArrayList<>();
    private ArrayList<RelativeLayout> alK = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.alI = onClickListener;
    }

    public T cv(int i) {
        if (this.alH == null || this.alH.isEmpty() || i < 0 || i >= this.alH.size()) {
            return null;
        }
        return this.alH.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.alL = aVar;
            this.alH.clear();
            this.alH.addAll(list);
            o(this.alH);
            int size = this.alG.size();
            int size2 = this.alH.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView aC = aVar.aC(this.context);
                    this.alG.add(aC);
                    tbImageView = aVar.aC(this.context);
                    this.alJ.add(tbImageView);
                    this.alK.add(new RelativeLayout(this.context));
                    tbImageView2 = aC;
                } else {
                    tbImageView = this.alJ.get(i);
                    this.alK.get(i);
                    tbImageView2 = this.alG.get(i);
                }
                if (this.alH.get(i) != null && tbImageView2 != null) {
                    tbImageView2.startLoad(this.alH.get(i).getPicUrl(), 10, false);
                    tbImageView2.setOnClickListener(this.alI);
                    if ((this.alH.get(i) instanceof q) && !((q) this.alH.get(i)).tS()) {
                        q qVar = (q) this.alH.get(i);
                        s.b(qVar.tP(), tbImageView, qVar.tQ(), l.f(this.context, f.e.ds24));
                    }
                }
            }
            int y = w.y(this.alH);
            int y2 = w.y(this.alG);
            if (y2 > y) {
                w.b(this.alG, y, y2);
            }
            int y3 = w.y(this.alJ);
            if (y3 > y) {
                w.b(this.alJ, y, y3);
            }
            int y4 = w.y(this.alK);
            if (y4 > y) {
                w.b(this.alK, y, y4);
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
        if (this.alG != null && this.alG.size() > 0) {
            return this.alG.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.alG == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) w.d(this.alG, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((w.d(this.alH, i) instanceof q) && !((q) w.d(this.alH, i)).tS()) {
            RelativeLayout relativeLayout = (RelativeLayout) w.d(this.alK, i);
            TbImageView tbImageView2 = (TbImageView) w.d(this.alJ, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.alL.xr() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.f(this.context, f.e.ds220) - l.f(this.context, f.e.ds24), 0, 0);
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
        if (this.alG != null && this.alG.size() > 0) {
            Iterator<TbImageView> it = this.alG.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
