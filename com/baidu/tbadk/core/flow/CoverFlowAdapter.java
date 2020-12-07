package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private Context context;
    private View.OnClickListener ePo;
    private a ePr;
    private ArrayList<TbImageView> ePn = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> ePp = new ArrayList<>();
    private ArrayList<RelativeLayout> ePq = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ePo = onClickListener;
    }

    public T pG(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.ePr = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            I(this.dataList);
            int size = this.ePn.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView W = aVar.W(this.context);
                    this.ePn.add(W);
                    tbImageView = aVar.W(this.context);
                    this.ePp.add(tbImageView);
                    this.ePq.add(new RelativeLayout(this.context));
                    tbImageView2 = W;
                } else {
                    tbImageView = this.ePp.get(i);
                    this.ePq.get(i);
                    tbImageView2 = this.ePn.get(i);
                }
                if (this.dataList.get(i) != null && tbImageView2 != null) {
                    if (this.dataList.get(i) instanceof h) {
                        tbImageView2.setImageDrawable(ap.getDrawable(Integer.valueOf(this.dataList.get(i).getPicUrl()).intValue()));
                    } else {
                        tbImageView2.startLoad(this.dataList.get(i).getPicUrl(), 10, false);
                    }
                    tbImageView2.setOnClickListener(this.ePo);
                    if ((this.dataList.get(i) instanceof z) && !((z) this.dataList.get(i)).bna()) {
                        z zVar = (z) this.dataList.get(i);
                        s.b(zVar.bmX(), tbImageView, zVar.bmY(), l.getDimens(this.context, R.dimen.ds24));
                    }
                }
            }
            int count = y.getCount(this.dataList);
            int count2 = y.getCount(this.ePn);
            if (count2 > count) {
                y.removeSubList(this.ePn, count, count2);
            }
            int count3 = y.getCount(this.ePp);
            if (count3 > count) {
                y.removeSubList(this.ePp, count, count3);
            }
            int count4 = y.getCount(this.ePq);
            if (count4 > count) {
                y.removeSubList(this.ePq, count, count4);
            }
            notifyDataSetChanged();
        }
    }

    private void I(ArrayList<T> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            arrayList.add(0, arrayList.get(size - 1));
            arrayList.add(arrayList.get(0));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.ePn != null && this.ePn.size() > 0) {
            return this.ePn.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.ePn == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) y.getItem(this.ePn, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((y.getItem(this.dataList, i) instanceof z) && !((z) y.getItem(this.dataList, i)).bna()) {
            RelativeLayout relativeLayout = (RelativeLayout) y.getItem(this.ePq, i);
            TbImageView tbImageView2 = (TbImageView) y.getItem(this.ePp, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.ePr.bsf() == null) {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, l.getDimens(this.context, R.dimen.ds220) - l.getDimens(this.context, R.dimen.ds24), 0, 0);
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
        if (this.ePn != null && this.ePn.size() > 0) {
            Iterator<TbImageView> it = this.ePn.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
