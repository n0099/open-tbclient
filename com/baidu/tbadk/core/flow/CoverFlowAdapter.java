package com.baidu.tbadk.core.flow;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.flow.a.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.recapp.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CoverFlowAdapter<T extends com.baidu.tbadk.core.flow.a.a> extends PagerAdapter {
    private Context context;
    private View.OnClickListener ego;
    private a egr;
    private ArrayList<TbImageView> egn = new ArrayList<>();
    private ArrayList<T> dataList = new ArrayList<>();
    private ArrayList<TbImageView> egp = new ArrayList<>();
    private ArrayList<RelativeLayout> egq = new ArrayList<>();

    public CoverFlowAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ego = onClickListener;
    }

    public T nG(int i) {
        if (this.dataList == null || this.dataList.isEmpty() || i < 0 || i >= this.dataList.size()) {
            return null;
        }
        return this.dataList.get(i);
    }

    public void a(List<T> list, a aVar) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        if (list != null && !list.isEmpty()) {
            this.egr = aVar;
            this.dataList.clear();
            this.dataList.addAll(list);
            I(this.dataList);
            int size = this.egn.size();
            int size2 = this.dataList.size();
            for (int i = 0; i < size2; i++) {
                if (i >= size) {
                    TbImageView V = aVar.V(this.context);
                    this.egn.add(V);
                    tbImageView = aVar.V(this.context);
                    this.egp.add(tbImageView);
                    this.egq.add(new RelativeLayout(this.context));
                    tbImageView2 = V;
                } else {
                    tbImageView = this.egp.get(i);
                    this.egq.get(i);
                    tbImageView2 = this.egn.get(i);
                }
                if (this.dataList.get(i) != null && tbImageView2 != null) {
                    if (this.dataList.get(i) instanceof h) {
                        tbImageView2.setImageDrawable(ap.getDrawable(Integer.valueOf(this.dataList.get(i).getPicUrl()).intValue()));
                    } else {
                        tbImageView2.startLoad(this.dataList.get(i).getPicUrl(), 10, false);
                    }
                    tbImageView2.setOnClickListener(this.ego);
                    if ((this.dataList.get(i) instanceof y) && !((y) this.dataList.get(i)).bcP()) {
                        y yVar = (y) this.dataList.get(i);
                        s.b(yVar.bcM(), tbImageView, yVar.bcN(), l.getDimens(this.context, R.dimen.ds24));
                    }
                }
            }
            int count = com.baidu.tbadk.core.util.y.getCount(this.dataList);
            int count2 = com.baidu.tbadk.core.util.y.getCount(this.egn);
            if (count2 > count) {
                com.baidu.tbadk.core.util.y.removeSubList(this.egn, count, count2);
            }
            int count3 = com.baidu.tbadk.core.util.y.getCount(this.egp);
            if (count3 > count) {
                com.baidu.tbadk.core.util.y.removeSubList(this.egp, count, count3);
            }
            int count4 = com.baidu.tbadk.core.util.y.getCount(this.egq);
            if (count4 > count) {
                com.baidu.tbadk.core.util.y.removeSubList(this.egq, count, count4);
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
        if (this.egn != null && this.egn.size() > 0) {
            return this.egn.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.egn == null) {
            return super.instantiateItem(viewGroup, i);
        }
        TbImageView tbImageView = (TbImageView) com.baidu.tbadk.core.util.y.getItem(this.egn, i);
        if (tbImageView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if ((com.baidu.tbadk.core.util.y.getItem(this.dataList, i) instanceof y) && !((y) com.baidu.tbadk.core.util.y.getItem(this.dataList, i)).bcP()) {
            RelativeLayout relativeLayout = (RelativeLayout) com.baidu.tbadk.core.util.y.getItem(this.egq, i);
            TbImageView tbImageView2 = (TbImageView) com.baidu.tbadk.core.util.y.getItem(this.egp, i);
            relativeLayout.removeView(tbImageView2);
            if (tbImageView.getParent() != null) {
                ((ViewGroup) tbImageView.getParent()).removeView(tbImageView);
            }
            relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (this.egr.bhC() == null) {
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
        if (this.egn != null && this.egn.size() > 0) {
            Iterator<TbImageView> it = this.egn.iterator();
            while (it.hasNext()) {
                it.next().refresh();
            }
        }
    }
}
